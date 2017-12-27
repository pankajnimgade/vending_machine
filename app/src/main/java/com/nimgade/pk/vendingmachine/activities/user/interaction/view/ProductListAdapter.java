package com.nimgade.pk.vendingmachine.activities.user.interaction.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import com.nimgade.pk.vendingmachine.R;
import com.nimgade.pk.vendingmachine.activities.user.interaction.presenter.IUserInterfacePresenter;
import com.nimgade.pk.vendingmachine.application.model.Product;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {

    private static final String TAG = "ProductListAdapter";

    private Context context;
    private int productType;
    private LayoutInflater layoutInflater;
    private IUserInterfacePresenter presenter;

    public ProductListAdapter(Context context, int productType, IUserInterfacePresenter presenter) {
        this.context = context;
        this.productType = productType;
        this.presenter = presenter;
        layoutInflater = LayoutInflater.from(this.context);
        Log.d(TAG, "ProductListAdapter: productType: " + productType);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.single_product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position) {
        final List<Product> productList = this.presenter.getProductList(position);
        Log.d(TAG, "onBindViewHolder: productList: " + productList);

        Log.d(TAG, "onBindViewHolder: productList:size() " + productList.size());
        if (!productList.isEmpty()) {
            Product product = productList.get(0);
            holder.productTotalTextView.setText("Total: " + productList.size());
            holder.productTypeTextView.setText("Product Type: " + product.getProductType());
            holder.productPriceTextView.setText("Product Price: " + product.getProductPrice() + "");
        } else {
            holder.productTotalTextView.setText("Total: Out of Stock");
            holder.productTypeTextView.setText("Product Type: NA");
            holder.productPriceTextView.setText("Product Price: NA");
        }

        holder.rootGridLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: position: " + position);
                if (!productList.isEmpty()) {
                    presenter.removeProduct(position);
                    notifyDataSetChanged();
                } else {
                    presenter.showMessageToUser("Out of Stock");
                    holder.productTotalTextView.setText("Total: Out of Stock");
                    holder.productTypeTextView.setText("Product Type: NA");
                    holder.productPriceTextView.setText("Product Price: NA");
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productType;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        private GridLayout rootGridLayout;
        private TextView productTotalTextView;
        private TextView productTypeTextView;
        private TextView productPriceTextView;


        public ProductViewHolder(View itemView) {
            super(itemView);
            rootGridLayout = (GridLayout) itemView.findViewById(R.id.single_product_item_product_root_GridLayout);
            productTotalTextView = (TextView) itemView.findViewById(R.id.single_product_item_product_total_textView);
            productTypeTextView = (TextView) itemView.findViewById(R.id.single_product_item_product_type_textView);
            productPriceTextView = (TextView) itemView.findViewById(R.id.single_product_item_product_price_textView);

        }
    }
}
