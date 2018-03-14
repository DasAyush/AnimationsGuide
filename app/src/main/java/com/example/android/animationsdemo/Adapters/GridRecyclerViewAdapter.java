package com.example.android.animationsdemo.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.animationsdemo.Objects.GridDataModel;
import com.example.android.animationsdemo.R;

import java.util.ArrayList;

/**
 * Created by ayush on 4/3/18.
 */

public class GridRecyclerViewAdapter extends
        RecyclerView.Adapter<GridRecyclerViewAdapter.ViewHolder> {

    ArrayList<GridDataModel> mValues;
    Context mContext;
    protected ItemListener mListener;

    public GridRecyclerViewAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener=itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView;
        public ImageView imageView;
        public RelativeLayout relativeLayout;
        GridDataModel item;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);
            textView = (TextView) v.findViewById(R.id.textView);
            imageView = (ImageView) v.findViewById(R.id.imageView);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.gridRelativeLayout);

        }


        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }

    @Override
    public GridRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.grid_recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder Vholder, int position) {
        //GridDataModel gridDataModel = mValues.get(position);

        GridDataModel gridDataModel = mValues.get(position);

        Vholder.textView.setText(gridDataModel.getText());
        Vholder.imageView.setImageResource(gridDataModel.getDrawable());
        Vholder.relativeLayout.setBackgroundColor(Color.parseColor(gridDataModel.getColor()));


    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }

    public interface ItemListener {
        void onItemClick(GridDataModel item);
    }

    public void setData(ArrayList<GridDataModel> mValues){
        this.mValues = mValues;
        notifyDataSetChanged();
    }
}
