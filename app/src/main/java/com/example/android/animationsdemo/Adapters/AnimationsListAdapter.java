package com.example.android.animationsdemo.Adapters;

/**
 * Created by ayush on 5/2/18.
 */

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.animationsdemo.Objects.CLickListener;
import com.example.android.animationsdemo.Objects.Animation;
import com.example.android.animationsdemo.R;

import java.util.ArrayList;
import java.util.List;

public class AnimationsListAdapter extends RecyclerView.Adapter<AnimationsListAdapter.ViewHolder> {

    private List<Animation> animations;
    private Context mContext;
    private CLickListener cLickListener = null;

    public AnimationsListAdapter(Context context, ArrayList<Animation> animations) {
        mContext = context;
        this.animations = animations;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tvCourseCode;
        public TextView tvCourseName;
        //public ToggleButton ibFavourite;
        public RelativeLayout viewBackground;
        public LinearLayout viewForeground;
        //public TextView tvCourseAttendance;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvCourseCode = (TextView)itemView.findViewById(R.id.tvCourseCode);
            tvCourseName = (TextView)itemView.findViewById(R.id.tvCourseName);
            viewBackground = (RelativeLayout)itemView.findViewById(R.id.view_background);
            viewForeground = (LinearLayout)itemView.findViewById(R.id.view_foreground);
            //ibFavourite = (ToggleButton) itemView.findViewById(R.id.ibFavourite);


        }

        @Override
        public void onClick(View v) {
            if (cLickListener!=null)
                cLickListener.itemClicked(v,getAdapterPosition());
        }
    }


    public void setcLickListener(CLickListener cLickListener) {
        this.cLickListener = cLickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.animations_list_item,parent,false);
        ViewHolder subjectViewHolder = new ViewHolder(itemView);
        return subjectViewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Animation currentAnimation = animations.get(position);
        holder.tvCourseCode.setText(currentAnimation.getTvCourseCode());
        holder.tvCourseName.setText(currentAnimation.getTvCourseName());
        //holder.tvCourseName.setTextColor(Color.GRAY);

        if(position%2 == 1){
            holder.itemView.setBackgroundColor(mContext.getResources().getColor(R.color.recView2Item));
        }

        else{
            holder.itemView.setBackgroundColor(Color.WHITE);
        }

        /*holder.ibFavourite = (ToggleButton) findViewById(R.id.ibFavourite);
        holder.ibFavourite.setChecked(false);
        holder.ibFavourite.setBackgroundDrawable(ContextCompat.getDrawable
                (mContext, R.mipmap.ic_not_favourite));
        holder.ibFavourite.setText(null);
        holder.ibFavourite.setTextOn(null);
        holder.ibFavourite.setTextOff(null);

        holder.ibFavourite.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    holder.ibFavourite.setBackgroundDrawable(ContextCompat.getDrawable
                            (mContext,R.mipmap.ic_favourite));
                else
                    holder.ibFavourite.setBackgroundDrawable(ContextCompat.getDrawable
                            (mContext, R.mipmap.ic_not_favourite));
            }
        });
        */
    }

    /*
    private void saveState(boolean isFavourite) {
        SharedPreferences aSharedPreferences = this.getSharedPreferences(
                "Favourite", Context.MODE_PRIVATE);
        SharedPreferences.Editor aSharedPreferencesEdit = aSharedPreferences
                .edit();
        aSharedPreferencesEdit.putBoolean("State", isFavourite);
        aSharedPreferencesEdit.commit();
    }

    private boolean readState() {
        SharedPreferences aSharedPreferences = this.getSharedPreferences(
                "Favourite", Context.MODE_PRIVATE);
        return aSharedPreferences.getBoolean("State", true);
    }
    */


    @Override
    public int getItemCount() {
        return animations.size();
    }

    public void setData(List<Animation> mAnimations){
        animations = mAnimations;
        notifyDataSetChanged();
    }

    public void removeSubject(int position) {
        animations.remove(position);
        // notify the item removed by position
        // to perform recycler view delete animations
        // NOTE: don't call notifyDataSetChanged()
        notifyItemRemoved(position);
    }

    public void restoreSubject(Animation item, int position) {
        animations.add(position, item);
        // notify item added by position
        notifyItemInserted(position);
    }
}

