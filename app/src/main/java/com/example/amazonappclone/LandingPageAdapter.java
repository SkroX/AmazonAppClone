package com.example.amazonappclone;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LandingPageAdapter extends RecyclerView.Adapter<LandingPageAdapter.MyViewHolder> {



    private List<Cart_items> dataModelList;
    private Context mContext;
    private OnItemListener mOnItemListener;

    public LandingPageAdapter(List<Cart_items> modelList, Context context, OnItemListener mOnItemListener) {
        dataModelList = modelList;
        mContext = context;
        this.mOnItemListener=mOnItemListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_items, parent, false);
        // Return a new view holder
        return new MyViewHolder(view,mOnItemListener);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindData(dataModelList.get(position), mContext);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    // View holder class whose objects represent each list item

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public ImageView imageView;
        public TextView titleTextView;
        public TextView subTitleTextView;
        OnItemListener onItemListener;
        Button Action1;
        Button Action2;
        ImageButton favouriteButton;


        public MyViewHolder(@NonNull final View itemView, final OnItemListener onItemListener) {
            super(itemView);
            this.onItemListener=onItemListener;
            imageView = itemView.findViewById(R.id.item_image);
            titleTextView=itemView.findViewById(R.id.item_name);
            subTitleTextView=itemView.findViewById(R.id.item_price);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);


//
//            favouriteButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    onItemListener.OnFavButtonClick(getAdapterPosition(),itemView);
//                }
//            });
//            Action1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    onItemListener.OnButton1Click(getAdapterPosition(),itemView);
//                }
//            });
//            Action2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    onItemListener.OnButton2Click(getAdapterPosition(),itemView);
//                }
//            });


        }


        public void bindData(final Cart_items dataModel, Context context) {
            /*imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_dashboard_black_24dp));
            ti0tleTextView.setText(dataModel.getTitle());
            subTitleTextView.setText(dataModel.getSubTitle());*/

            //imageView.setImageBitmap(dataModel.getImage());
//            Log.i("ye ha url",dataModel.getDownloadUri());



            setImage(dataModel.getItemImageResourceId(), imageView,context);
            titleTextView.setText(dataModel.getItemName());
            subTitleTextView.setText(String.valueOf(dataModel.getItemPrice()));
        }

        @Override
        public void onClick(View v) {
            onItemListener.OnBookClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View view) {
            onItemListener.OnBookLongClick(getAdapterPosition(),view);
            return true;
        }
    }


    public static void setImage( int imageID, final ImageView imageView,Context mContext){


        // FirebaseStorage storage=FirebaseStorage.getInstance();
        //StorageReference httpsReference = storage.getReferenceFromUrl(dataModel.getDownloadUri())

imageView.setImageResource(imageID);

       /* try {
            final File localFile = File.createTempFile("images", "jpg");

            httpsReference.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    // Local temp file has been created
                    Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                    imageView.setImageBitmap(bitmap);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle any errors
                }
            });


        }catch (Exception e){
            e.printStackTrace();
        }*/

    }

    public interface OnItemListener{
        void OnBookClick(int position);
        void OnBookLongClick(int position,View view);
        void OnButton1Click(int position,View view);
        void OnButton2Click(int position,View view);
        void OnFavButtonClick(int position,View view);
    }

}


