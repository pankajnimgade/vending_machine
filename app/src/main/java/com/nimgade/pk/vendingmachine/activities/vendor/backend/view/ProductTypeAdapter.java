package com.nimgade.pk.vendingmachine.activities.vendor.backend.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nimgade.pk.vendingmachine.R;
import com.nimgade.pk.vendingmachine.activities.vendor.backend.presenter.IVendorBackdoorPresenter;
import com.nimgade.pk.vendingmachine.application.model.product.Product;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 12/30/2017.
 */

public class ProductTypeAdapter extends RecyclerView.Adapter<ProductTypeAdapter.ProductTypeViewHolder> {

    private int typeOfProducts;
    private Context context;
    private LayoutInflater layoutInflater;
    private IVendorBackdoorPresenter presenter;


    public ProductTypeAdapter(int typeOfProducts, Context context, IVendorBackdoorPresenter presenter) {
        this.typeOfProducts = typeOfProducts;
        this.context = context;
        this.presenter = presenter;
        layoutInflater = LayoutInflater.from(this.context);
    }

    @Override
    public ProductTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.single_product_type, parent, false);
        return new ProductTypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductTypeViewHolder holder, final int position) {
        final List<Product> productTypeList = presenter.getProductTypeList(position);
        holder.typeQuantityTextView.setText("Quantity: " + productTypeList.size());
        if (!productTypeList.isEmpty()) {
            holder.typeNameTextView.setText("Product Type: " + productTypeList.get(0).getProductType() + "");
        } else {
            holder.typeNameTextView.setText("Product Type: " + productTypeList.get(0).getProductType());
        }
        holder.rootLayoutCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addProduct(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return typeOfProducts;
    }

    public static class ProductTypeViewHolder extends RecyclerView.ViewHolder {
        private CardView rootLayoutCardView;
        private TextView typeNameTextView;
        private TextView typeQuantityTextView;

        public ProductTypeViewHolder(View itemView) {
            super(itemView);
            rootLayoutCardView = (CardView) itemView.findViewById(R.id.single_product_type_root_layout_CardView);
            typeNameTextView = (TextView) itemView.findViewById(R.id.single_product_type_name_textView);
            typeQuantityTextView = (TextView) itemView.findViewById(R.id.single_product_type_quantity_textView);
        }
    }
}
