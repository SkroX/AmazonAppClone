package com.example.amazonappclone;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

//public class LandingPageAdapter extends RecyclerView.Adapter<LandingPageAdapter.MyViewHolder> {
//
//
//
//    static protected List<List<Cart_items>> dataModelList;
//    private Context mContext;
//    private OnItemListener mOnItemListener;
//
//    public LandingPageAdapter(List<List<Cart_items>> modelList, Context context, OnItemListener mOnItemListener) {
//        dataModelList = modelList;
//        mContext = context;
//        this.mOnItemListener=mOnItemListener;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.category, parent, false);
//        // Return a new view holder
//        return new MyViewHolder(view,mOnItemListener);
//    }
//
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.bindData(dataModelList.get(position), mContext);
//    }
//
//    @Override
//    public int getItemCount() {
//        return dataModelList.size();
//    }
//
//    // View holder class whose objects represent each list item
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
//        public ImageView imageView;
//        public TextView titleTextView;
//        public TextView subTitleTextView;
//        OnItemListener onItemListener;
//        TextView title;
//        GridView gridView;
//
//        public MyViewHolder(@NonNull final View itemView, final OnItemListener onItemListener) {
//            super(itemView);
//            this.onItemListener=onItemListener;
//            imageView = itemView.findViewById(R.id.item_image);
//            titleTextView=itemView.findViewById(R.id.item_name);
//            subTitleTextView=itemView.findViewById(R.id.item_price);
//            title = itemView.findViewById(R.id.textView2);
//            gridView=itemView.findViewById(R.id.gridVIew);
//            itemView.setOnClickListener(this);
//            itemView.setOnLongClickListener(this);
//
//
////
////            favouriteButton.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View view) {
////                    onItemListener.OnFavButtonClick(getAdapterPosition(),itemView);
////                }
////            });
////            Action1.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View view) {
////                    onItemListener.OnButton1Click(getAdapterPosition(),itemView);
////                }
////            });
////            Action2.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View view) {
////                    onItemListener.OnButton2Click(getAdapterPosition(),itemView);
////                }
////            });
//
//
//        }
//
//
//        public void bindData(final List<Cart_items> dataModel, Context context) {
//            /*imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_dashboard_black_24dp));
//            ti0tleTextView.setText(dataModel.getTitle());
//            subTitleTextView.setText(dataModel.getSubTitle());*/
//
//            //imageView.setImageBitmap(dataModel.getImage());
////            Log.i("ye ha url",dataModel.getDownloadUri());
//
//            title.setText(dataModel.get(0).getItemName());
//            GridViewAdapter adapter=new GridViewAdapter(context,dataModel);
//            gridView.setAdapter(adapter);
//            adapter.notifyDataSetChanged();
//            // setImage(dataModel.getItemImageResourceId(), imageView,context);
////            titleTextView.setText(dataModel.getItemName());
////            subTitleTextView.setText(String.valueOf(dataModel.getItemPrice()));
//        }
//
//        @Override
//        public void onClick(View v) {
//            onItemListener.OnBookClick(getAdapterPosition());
//        }
//
//        @Override
//        public boolean onLongClick(View view) {
//            onItemListener.OnBookLongClick(getAdapterPosition(),view);
//            return true;
//        }
//    }
//
//
//    public static void setImage( int imageID, final ImageView imageView,Context mContext){
//
//
//        // FirebaseStorage storage=FirebaseStorage.getInstance();
//        //StorageReference httpsReference = storage.getReferenceFromUrl(dataModel.getDownloadUri())
//
////imageView.setImageResource(R.drawable.amzon_image);
//
//       /* try {
//            final File localFile = File.createTempFile("images", "jpg");
//
//            httpsReference.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                    // Local temp file has been created
//                    Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
//                    imageView.setImageBitmap(bitmap);
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception exception) {
//                    // Handle any errors
//                }
//            });
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }*/
//
//    }
//
//    public interface OnItemListener{
//        void OnBookClick(int position);
//        void OnBookLongClick(int position,View view);
//        void OnButton1Click(int position,View view);
//        void OnButton2Click(int position,View view);
//        void OnFavButtonClick(int position,View view);
//    }
//
//}

public class MultiViewTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;

    static protected List<List<Cart_items>> dataModelList;
    private OnItemListener mOnItemListener;

    int total_types;
    ArrayList<Integer> slider_image_list;
    int page = 0;



    public MultiViewTypeAdapter(List<List<Cart_items>> modelList, Context context, OnItemListener mOnItemListener) {
        dataModelList=modelList;
        this.mContext = context;
        this.mOnItemListener=mOnItemListener;
        total_types = dataModelList.size();
    }

    public static class TextTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener  {
//        @BindView(R.id.ll_dots)
//
//        LinearLayout ll_dots;
//        @BindView(R.id.vp_slider)
        CircleIndicator circleIndicator;
        OnItemListener onItemListener;
        ViewPager mvViewPager;

        public TextTypeViewHolder(View itemView, final OnItemListener onItemListener) {
            super(itemView);
            this.onItemListener=onItemListener;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            circleIndicator=itemView.findViewById(R.id.circle);
            mvViewPager=itemView.findViewById(R.id.view_pager);
          //  ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View view) {

        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
//        @BindView(R.id.type)
//        TextView tvtype;
//        @BindView(R.id.img)
//        ImageView iv;

        public ImageView imageView;
        public TextView titleTextView;
        public TextView subTitleTextView;
        OnItemListener onItemListener;
        TextView title;
        GridView gridView;

        public ImageTypeViewHolder(View itemView,final OnItemListener onItemListener) {
            super(itemView);
           // ButterKnife.bind(this, itemView);

            this.onItemListener=onItemListener;
            imageView = itemView.findViewById(R.id.item_image);
            titleTextView=itemView.findViewById(R.id.item_name);
            subTitleTextView=itemView.findViewById(R.id.item_price);
            title = itemView.findViewById(R.id.textView2);
            gridView=itemView.findViewById(R.id.gridVIew);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View view) {

        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_view_pager, parent, false);
                return new TextTypeViewHolder(view,mOnItemListener);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category, parent, false);
                return new ImageTypeViewHolder(view,mOnItemListener);

        }
        return null;


    }


    @Override
    public int getItemViewType(int position) {

        if(position==0)return 0;
        else return 1;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        //Data object = dataSet.get(listPosition);
//        if (object != null) {
           // switch (listPosition) {
               if(listPosition==0) {
//                    //((TextTypeViewHolder) holder).type.setText(object.text);
                   slider_image_list = new ArrayList<>();
//
//                    //Add few items to slider_image_list ,this should contain url of images which should be displayed in slider
//                    // here i am adding few sample image links, you can add your own
//
//                    slider_image_list.add("http://cdn.collider.com/wp-content/uploads/avengers-movie-banner-scarlett-johansson-jeremy-renner.jpg");
//                    slider_image_list.add("http://www.officialterridwyer.com/wp-content/uploads/2015/04/Disneys-Cinderella-2015-Movie-Banner.jpg");
//                    slider_image_list.add("http://igmedia.blob.core.windows.net/igmedia/hindi/gallery/movies/raabta/main1.jpg");
//                    slider_image_list.add("http://fantoosy.com/wp-content/uploads/2015/11/tamasha.jpg");

                   slider_image_list.add(R.drawable.amzon_image);
                   slider_image_list.add(R.drawable.amzon_image);
                   slider_image_list.add(R.drawable.amzon_image);
                   slider_image_list.add(R.drawable.amzon_image);
                   final MyPager sliderPagerAdapter = new MyPager((Activity) mContext, slider_image_list);
                   ((TextTypeViewHolder) holder).mvViewPager.setAdapter(sliderPagerAdapter);

                   ((TextTypeViewHolder) holder).mvViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                       @Override
                       public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                       }

                       @Override
                       public void onPageSelected(int position) {
                           //addBottomDots(position, ((TextTypeViewHolder) holder).ll_dots);
                           page = position;
                       }

                       @Override
                       public void onPageScrollStateChanged(int state) {

                       }
                   });
                   // addBottomDots(0, ((TextTypeViewHolder) holder).ll_dots);
                   final Handler h = new Handler();
                   h.postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           if (sliderPagerAdapter.getCount() == page) {
                               page = 0;
                           } else {
                               page++;
                           }
                           ((TextTypeViewHolder) holder).mvViewPager.setCurrentItem(page);
                           h.postDelayed(this, 2000);
                       }
                   }, 1000);
               }

                else
                    bindData(dataModelList.get(listPosition), mContext,holder);


            }


//    }

    public void bindData(final List<Cart_items> dataModel, Context context,final RecyclerView.ViewHolder holder) {
            /*imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_dashboard_black_24dp));
            ti0tleTextView.setText(dataModel.getTitle());
            subTitleTextView.setText(dataModel.getSubTitle());*/

        //imageView.setImageBitmap(dataModel.getImage());
//            Log.i("ye ha url",dataModel.getDownloadUri());

        ((ImageTypeViewHolder) holder).title.setText(dataModel.get(0).getItemName());
        GridViewAdapter adapter=new GridViewAdapter(context,dataModel);
        ((ImageTypeViewHolder) holder).gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        // setImage(dataModel.getItemImageResourceId(), imageView,context);
//            titleTextView.setText(dataModel.getItemName());
//            subTitleTextView.setText(String.valueOf(dataModel.getItemPrice()));
    }



    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    //showing dots on screen
    private void addBottomDots(int currentPage, LinearLayout ll_dots) {
        TextView[] dots = new TextView[slider_image_list.size()];
        ll_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(mContext);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#343434"));
            ll_dots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.parseColor("#A2A2A2"));
    }


    public interface OnItemListener{
        void OnBookClick(int position);
        void OnBookLongClick(int position,View view);
        void OnButton1Click(int position,View view);
        void OnButton2Click(int position,View view);
        void OnFavButtonClick(int position,View view);
    }

}
