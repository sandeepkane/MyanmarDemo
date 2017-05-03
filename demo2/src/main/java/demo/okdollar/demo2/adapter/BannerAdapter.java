package demo.okdollar.demo2.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

import demo.okdollar.demo2.R;

/**
 * Created by DELTA on 5/2/2017.
 */

public class BannerAdapter extends PagerAdapter {
    private Context context;
    private List<String> bannerImages;


    public BannerAdapter(Context context, List<String> bannerImages) {
        this.context = context;
        this.bannerImages = bannerImages;
    }

    @Override
    public int getCount() {
        return bannerImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return true;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.banner_item, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.img_pager_item);
//        imageView.setImageURI(Uri.parse(bannerImages.get(position)));;
        Picasso.with(context).load(bannerImages.get(position)).into(imageView);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
