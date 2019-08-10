package com.llh.recyclerviewonclick;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * 项目名:    RecyclerViewOnClick
 * 包名:      com.llh.recyclerviewonclick
 * 文件名:    CourseAdapter
 * 创建者:    LLH
 * 创建时间:  2019/8/9 10:33
 * 描述:      TODO
 */
public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    //链表
    private List<Course> courseList;
    private Context context;
    //构造函数
    public CourseAdapter(List<Course> courseList,Context context){
        this.courseList = courseList;
        this.context = context;
    }
    //内部类
    static class CourseViewHolder extends RecyclerView.ViewHolder{
        //复选框，文本框
        CheckBox checkBoxCourse;
        TextView textViewCourse;
        //构造函数
        public CourseViewHolder(View view){
            super(view);
            checkBoxCourse = view.findViewById(R.id.select_course);
            textViewCourse = view.findViewById(R.id.tv_courseName);
        }

    }
    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_course,viewGroup,false);
        final CourseViewHolder courseViewHolder = new CourseViewHolder(view);
        //设置复选框的选中事件
        courseViewHolder.checkBoxCourse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //获取到当前点击的项
                int position = courseViewHolder.getAdapterPosition();
                Log.d("llhData", "position:  "+position);
                //获取课程实例
                Course course = courseList.get(position);
                Log.d("llhData", "course:  "+course);
                if(isChecked == true){
                    //Log.d("llhData", "ourse.getCourseName():  "+course.getCourseName());
                    course.setCourseCheck(true);
                    //Log.d("llhData", "ourse.setCourseCheck():  "+course.getCourseCheck()+position);
                }
            }
        });
        return courseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder courseViewHolder, int i) {
        Course course = courseList.get(i);
        courseViewHolder.textViewCourse.setText(course.getCourseName());
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }
}
