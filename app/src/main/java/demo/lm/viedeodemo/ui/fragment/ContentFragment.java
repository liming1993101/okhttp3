package demo.lm.viedeodemo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import demo.lm.viedeodemo.R;
import demo.lm.viedeodemo.adapter.ContentAdapter;
import demo.lm.viedeodemo.bean.ContentEntity;
import demo.lm.viedeodemo.network.HomeNetwork;
import demo.lm.viedeodemo.network.impl.HomeNetworkImpl;
import demo.lm.viedeodemo.recyclerview.MGridLayoutManager;
import demo.lm.viedeodemo.recyclerview.OnRecycleViewScrollListener;
import demo.lm.viedeodemo.view.ContentView;

/**
 * Created by Administrator on 2016/5/12.
 */
public class ContentFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener,ContentView{
    private static final String KEY_VIDEO_ID = "id";
    private static final String KEY_VIDEO_TYPE = "type";
    private RecyclerView mListview;
    private SwipeRefreshLayout mRefreshLayout;
    private View view;
    private HomeNetwork mHomeNetwork;
    private int id;
    private int type;
    private int page=1;
    private ContentAdapter mAdapter;
   public static Fragment newInstance(int id, int type) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_VIDEO_ID, id);
        bundle.putInt(KEY_VIDEO_TYPE, type);
        Fragment fragment = new ContentFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            
        view=inflater.inflate(R.layout.fragment_content,container,false);
        initView();
        initData();
        return view;
    }

    private void initData() {

        mHomeNetwork = new HomeNetworkImpl(this);
        id = getArguments().getInt(KEY_VIDEO_ID);
        type = getArguments().getInt(KEY_VIDEO_TYPE);
        mRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mRefreshLayout.setOnRefreshListener(this);
        mAdapter = new ContentAdapter(getActivity());
        mListview.setLayoutManager(new MGridLayoutManager(getActivity(), 2, mAdapter));
        mAdapter.setHasMoreData(true);
        mListview.addOnScrollListener(new OnRecycleViewScrollListener() {
            @Override
            public void onLoadMore() {
                mAdapter.setHasFooter(true);
                page++;
                mHomeNetwork.loadMore(id, page);
                mListview.scrollToPosition(mAdapter.getItemCount() - 1);
            }
        });
        mListview.setAdapter(mAdapter);
        mHomeNetwork.refresh(id, 1);
    }

    private void initView() {
        mListview= (RecyclerView) view.findViewById(R.id.content_lv);
        mRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.content_refresh);

    }

    @Override
    public void onRefresh() {

        mRefreshLayout.setRefreshing(true);
        mHomeNetwork.refresh(id,1);

    }

    @Override
    public void showMediaData(ContentEntity contentEntity) {

    }

    @Override
    public void showLoadMediaError() {

    }

    @Override
    public void refreshComment(List<ContentEntity> dataList) {
         mAdapter.clear();
        mAdapter.appendToList(dataList);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showMoreComments(List<ContentEntity> dataList) {
        if (dataList.isEmpty()) {
            mAdapter.setHasMoreData(false);

        } else {
            mAdapter.appendToList(dataList);
            mAdapter.notifyDataSetChanged();
            mAdapter.setHasMoreData(true);
        }

    }
}
