package demo.lm.viedeodemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import demo.lm.viedeodemo.bean.ClassifyEntity;
import demo.lm.viedeodemo.ui.fragment.ContentFragment;

/**
 * Created by Administrator on 2016/5/12.
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments = new ArrayList<>();
    private List<ClassifyEntity> mCategoryLists = new ArrayList<>();
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    public void addItem(ClassifyEntity entity) {
        mCategoryLists.add(entity);
        mFragments.add(ContentFragment.newInstance(entity.getId(), entity.getType()));
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mCategoryLists.get(position).getName();
    }
    /**
     * Override this method to save Fragment state
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }



}
