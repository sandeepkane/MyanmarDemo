package demo.okdollar.demo2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import demo.okdollar.demo2.R;
import demo.okdollar.demo2.model.Product;

/**
 * Created by DELTA on 5/3/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> productList;
    private Context context;

    public ProductAdapter(Context context, List<Product> productList) {
        this.productList = productList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View sView = mInflater.inflate(R.layout.single_product_view, parent, false);
        return new ProductAdapter.ViewHolder(sView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productNameTextView.setText(product.getProductPrice());
        holder.productImage.setImageDrawable(context.getResources().getDrawable(R.drawable.sbi_offer));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView productImage;
        public TextView productNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            productImage = (ImageView) itemView.findViewById(R.id.product_image);
            productNameTextView = (TextView) itemView.findViewById(R.id.product_price);
        }
    }
}
