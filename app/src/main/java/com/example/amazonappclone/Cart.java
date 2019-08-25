package com.example.amazonappclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);

        //creating a arraylist with custom objects Cart_items for storing all items in cart
        ArrayList<Cart_items> cart_items = new ArrayList<Cart_items>();

        cart_items.add(new Cart_items("Seven Rays Be Amazing Be Revolutionary Laptop Skin Covers Fits",249.00,R.drawable.amzon_image));
        cart_items.add(new Cart_items("Seven Rays Be Amazing Be Revolutionary Laptop Skin Covers Fits",249.00,R.drawable.amzon_image));
        cart_items.add(new Cart_items("Seven Rays Be Amazing Be Revolutionary Laptop Skin Covers Fits",249.00,R.drawable.amzon_image));
        cart_items.add(new Cart_items("Seven Rays Be Amazing Be Revolutionary Laptop Skin Covers Fits",249.00,R.drawable.amzon_image));

        //Setting the custom made adapter on that list
        cart_items_adapter adapter = new cart_items_adapter(this,cart_items);
        ListView listView = (ListView) findViewById(R.id.items);
        listView.setAdapter(adapter);

    }

}
