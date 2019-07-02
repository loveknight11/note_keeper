package com.example.notekeeper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private List<CourseInfo> mCourses;
    private Context mContext;

    public CourseAdapter(List<CourseInfo> mCourses, Context mContext) {
        this.mCourses = mCourses;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_list_coures,parent,false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        CourseInfo course = mCourses.get(position);
        holder.bind(course);
    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder{
        //private TextView tvTitle;
        private TextView tvCourse;


        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            //tvTitle = itemView.findViewById(R.id.et_title);
            tvCourse = itemView.findViewById(R.id.tv_course);
            //tvCourse.setVisibility(View.GONE);
        }

        public void bind(CourseInfo course){
            //tvTitle.setText(course.getCourseTitle());
            tvCourse.setText(course.getCourseTitle());
        }
    }
}
