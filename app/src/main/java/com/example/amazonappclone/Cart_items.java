package com.example.amazonappclone;


public class Cart_items {

    private String mItemName;
    private double mItemPrice;
    private int mItemImageResourceId;

    public Cart_items(String ItemName, double ItemPrice, int ItemImageResourceId){
        mItemName= ItemName;
        mItemPrice=ItemPrice;
        mItemImageResourceId=ItemImageResourceId;
    }

    public String getItemName(){
        return mItemName;
    }

    public double getItemPrice(){
        return mItemPrice;
    }

    public int getItemImageResourceId(){
        return mItemImageResourceId;
    }


}
