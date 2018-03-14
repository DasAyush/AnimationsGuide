package com.example.android.animationsdemo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.animationsdemo.CardFlipActivity;
import com.example.android.animationsdemo.LayoutChangesActivity;
import com.example.android.animationsdemo.Objects.MainRecView;
import com.example.android.animationsdemo.R;
import com.example.android.animationsdemo.ScreenSlideActivity;
import com.example.android.animationsdemo.ScrollingActivity;
import com.example.android.animationsdemo.ZoomActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayush on 8/3/18.
 */

public class MainRecViewAdapter extends RecyclerView.Adapter<MainRecViewAdapter.ViewHolder> {

    public List<MainRecView> icons;
    private Context mContext;

    public MainRecViewAdapter(Context context, ArrayList<MainRecView> icons) {
        mContext = context;
        this.icons = icons;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView iconsView;

        public ViewHolder(View itemView) {
            super(itemView);

            iconsView = (ImageView) itemView.findViewById(R.id.iconsView);

        }


        @Override
        public void onClick(View itemView) {

            //Toast.makeText(mContext,"The Item Clicked is: "+getPosition(),Toast.LENGTH_SHORT).show();

            final Intent intent;

            switch (getAdapterPosition()){
                case 0:
                    mContext.startActivity(new Intent(mContext, ScrollingActivity.class));
                    break;
                case 1:
                    mContext.startActivity(new Intent(mContext, CardFlipActivity.class));
                    break;
                case 2:
                    mContext.startActivity(new Intent(mContext, ScreenSlideActivity.class));
                    break;
                case 3:
                    mContext.startActivity(new Intent(mContext, ZoomActivity.class));
                    break;
                case 4:
                    mContext.startActivity(new Intent(mContext, LayoutChangesActivity.class));
                    break;
            }
            //mContext.startActivity(intent);
            //myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.horizontal_view_list_item,parent,false);
        ViewHolder iconsViewHolder = new ViewHolder(itemView);
        return iconsViewHolder;
    }

    @Override
    public void onBindViewHolder(MainRecViewAdapter.ViewHolder holder, final int position) {
        final MainRecView mainRecView = icons.get(position);
        holder.iconsView.setImageResource(mainRecView.getColorResourceId());

        holder.iconsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent;

                switch (position) {
                    case 0:
                        mContext.startActivity(new Intent(mContext, ScrollingActivity.class));
                        break;
                    case 1:
                        mContext.startActivity(new Intent(mContext, CardFlipActivity.class));
                        break;
                    case 2:
                        mContext.startActivity(new Intent(mContext, ScreenSlideActivity.class));
                        break;
                    case 3:
                        mContext.startActivity(new Intent(mContext, ZoomActivity.class));
                        break;
                    case 4:
                        mContext.startActivity(new Intent(mContext, LayoutChangesActivity.class));
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return icons.size();
    }

    public void setData(List<MainRecView> mainRecViews){
        icons = mainRecViews;
        notifyDataSetChanged();
    }
}
