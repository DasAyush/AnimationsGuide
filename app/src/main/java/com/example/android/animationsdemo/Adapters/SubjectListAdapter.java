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
import com.example.android.animationsdemo.Objects.Subject;
import com.example.android.animationsdemo.R;

import java.util.ArrayList;
import java.util.List;

public class SubjectListAdapter extends RecyclerView.Adapter<SubjectListAdapter.ViewHolder> {

    private List<Subject> subjects;
    private Context mContext;
    private CLickListener cLickListener = null;

    public SubjectListAdapter(Context context, ArrayList<Subject> subjects) {
        mContext = context;
        this.subjects = subjects;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tvCourseCode;
        public TextView tvCourseName;
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
                (R.layout.subject_list_item,parent,false);
        ViewHolder subjectViewHolder = new ViewHolder(itemView);
        return subjectViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Subject currentSubject = subjects.get(position);
        holder.tvCourseCode.setText(currentSubject.getTvCourseCode());
        holder.tvCourseName.setText(currentSubject.getTvCourseName());
        //holder.tvCourseName.setTextColor(Color.GRAY);

        if(position%2 == 1){
            holder.itemView.setBackgroundColor(mContext.getResources().getColor(R.color.recView2Item));
        }

        else{
            holder.itemView.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public void setData(List<Subject> mSubjects){
        subjects = mSubjects;
        notifyDataSetChanged();
    }

    public void removeSubject(int position) {
        subjects.remove(position);
        // notify the item removed by position
        // to perform recycler view delete animations
        // NOTE: don't call notifyDataSetChanged()
        notifyItemRemoved(position);
    }

    public void restoreSubject(Subject item, int position) {
        subjects.add(position, item);
        // notify item added by position
        notifyItemInserted(position);
    }
}

