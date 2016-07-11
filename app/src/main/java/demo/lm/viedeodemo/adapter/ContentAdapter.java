package demo.lm.viedeodemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import demo.lm.viedeodemo.R;
import demo.lm.viedeodemo.bean.ContentEntity;
import demo.lm.viedeodemo.ui.activity.VideoViewDemo;
import demo.lm.viedeodemo.ui.activity.ViedeoActivity;
import demo.lm.viedeodemo.ui.activity.ViedeoPalyActivity;
import demo.lm.viedeodemo.ui.fragment.ContentFragment;

/**
 * Created by Administrator on 2016/5/12.
 */
public class ContentAdapter extends BaseLoadMoreRecyclerAdapter<ContentEntity,ContentAdapter.ViewHolder> {
    private Context context;
    private DisplayImageOptions options;
    public ContentAdapter(Context context) {
        super();
        this.context=context;
        this.options=new DisplayImageOptions.Builder().
                cacheInMemory().cacheOnDisc().
                showImageForEmptyUri(R.mipmap.ic_launcher).
                showImageOnFail(R.mipmap.ic_launcher).
                displayer(new RoundedBitmapDisplayer(20)).
                imageScaleType(ImageScaleType.IN_SAMPLE_INT)//图片显示方式
                .bitmapConfig(Bitmap.Config.ARGB_4444).build();//設置圖片配置信息  對圖片進行處理防止內存溢出
    }




    @Override
    public ContentAdapter.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_home,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(ContentAdapter.ViewHolder holder, int position) {

        final ContentEntity entity = getItem(position);
        ImageLoader.getInstance().displayImage(entity.getRecommend_cover_pic()+"", holder.imageView,options);
        holder.textView.setText(""+entity.getRecommend_caption());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context,VideoViewDemo.class);
                intent.putExtra("id",entity.getMedia().getVideo());
                context.startActivity(intent);
            }
        });

    }
    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView imageView;
        private TextView textView;
        public ViewHolder(View view) {
            super(view);
            imageView= (ImageView) itemView.findViewById(R.id.img);
            textView= (TextView) itemView.findViewById(R.id.tv1);

        }
    }
}
