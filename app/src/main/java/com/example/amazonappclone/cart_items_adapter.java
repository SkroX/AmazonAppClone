package com.example.amazonappclone;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class cart_items_adapter extends ArrayAdapter<Cart_items> {

    public cart_items_adapter(Activity context, ArrayList<Cart_items> Cart_items){

        super(context,0,Cart_items);
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View cartListView = convertView;
        if(cartListView==null)
            cartListView = LayoutInflater.from(getContext()).inflate(R.layout.cart_items, parent, false);

        Cart_items currentItem = getItem(position);
        //sets image og the item
        ImageView itemImage = (ImageView) cartListView.findViewById(R.id.item_image);
        itemImage.setImageResource(currentItem.getItemImageResourceId());

        TextView itemName = (TextView) cartListView.findViewById(R.id.item_name);
        itemName.setText(currentItem.getItemName());

        TextView itemPrice = (TextView) cartListView.findViewById(R.id.item_price);
        itemPrice.setText(""+currentItem.getItemPrice());

        return cartListView;
    }
}
