package demo.okdollar.demo2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import demo.okdollar.demo2.model.Category;
import demo.okdollar.demo2.R;

/**
 * Created by DELTA on 5/3/2017.
 */

public class CategoryAdapterHolder extends RecyclerView.Adapter<CategoryAdapterHolder.ViewHolder> {
    private List<Category> categories;
    private Context context;

    public CategoryAdapterHolder(Context context, List<Category> categories) {
        this.categories = categories;
        this.context = context;
    }

    @Override
    public CategoryAdapterHolder.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View sView = mInflater.inflate(R.layout.single_ccategory_view, parent, false);
        return new CategoryAdapterHolder.ViewHolder(sView);
    }

    @Override
    public void onBindViewHolder(CategoryAdapterHolder.ViewHolder holder, int position) {
        Category category = categories.get(position);
        Picasso.with(context).load(category.getImageUrl()).error(category.getPlaceholder()).placeholder(category.getPlaceholder()).into(holder.categoryImage);
        holder.categoryNameTextView.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView categoryImage;
        public TextView categoryNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            categoryImage = (ImageView) itemView.findViewById(R.id.category_image);
            categoryNameTextView = (TextView) itemView.findViewById(R.id.category_name);
        }
    }
}
