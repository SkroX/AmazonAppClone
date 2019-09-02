package com.example.amazonappclone;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class cart_items_adapter extends ArrayAdapter<Cart_items> {
    //Create a private variable cart that can refer to Cart_items to we can remove items from it
    private ArrayList<Cart_items> cart;
    public cart_items_adapter(Activity context, ArrayList<Cart_items> Cart_items) {

        super(context, 0, Cart_items);
        this.cart=Cart_items;//setting this equal to Cart_items we need other variable because scope of Cart_items id limited so we created a global variable
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View cartListView = convertView;
        if (cartListView == null)
            cartListView = LayoutInflater.from(getContext()).inflate(R.layout.cart_items, parent, false);

        Cart_items currentItem = getItem(position);
        //sets image of the item
        ImageView itemImage = (ImageView) cartListView.findViewById(R.id.item_image);
        itemImage.setImageResource(currentItem.getItemImageResourceId());

        TextView itemName = (TextView) cartListView.findViewById(R.id.item_name);
        itemName.setText(currentItem.getItemName());

        TextView itemPrice = (TextView) cartListView.findViewById(R.id.item_price);
        itemPrice.setText("" + currentItem.getItemPrice());

        //referring to delete button by its id
        //setting tag on that button for its current position on the list
        //creating a OnClickListener
        Button deleteButton = (Button) cartListView.findViewById(R.id.deleteButton);
        deleteButton.setTag(position);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = (int) view.getTag();  //Getting tag of the item
                cart.remove(id);               //Removing item of particular tag
                notifyDataSetChanged();        //Refreshing the ArrayAdapter

            }
        });
        return cartListView;
    }
}
