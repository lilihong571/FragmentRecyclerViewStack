package com.llh.recyclerviewonclick.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.llh.recyclerviewonclick.Course;
import com.llh.recyclerviewonclick.CourseAdapter;
import com.llh.recyclerviewonclick.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名:    RecyclerViewOnClick
 * 包名:      com.llh.recyclerviewonclick.Fragment
 * 文件名:    FragmentSong
 * 创建者:    LLH
 * 创建时间:  2019/8/9 10:43
 * 描述:      TODO
 */
public class FragmentCourse extends Fragment implements View.OnClickListener {
    private RecyclerView recyclerViewCourse;
    private List<Course> courseList;
    private Button buttonConfirm;
    public static boolean btnConfirmInPress = false;
    String str = "";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course,container,false);
        courseList = new ArrayList<>();
        recyclerViewCourse = (RecyclerView)view.findViewById(R.id.rv_course);
        //创建线性布局
        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext());
        recyclerViewCourse.setLayoutManager(layoutManager);
        //给链表添加值
        addCourseList();
        //创建适配器
        CourseAdapter courseAdapter = new CourseAdapter(courseList,container.getContext());
        recyclerViewCourse.setAdapter(courseAdapter);
        buttonConfirm = view.findViewById(R.id.btn_confirm);
        buttonConfirm.setOnClickListener(this);
        return view;
    }

    private void addCourseList() {
        Course course = null;
        for (int i = 0; i < 6; i++) {
            switch (i){
                case 0:
                    course = new Course("语文",false);
                    break;
                case 1:
                    course = new Course("数学",false);
                    break;
                case 2:
                    course = new Course("英语",false);
                    break;
                case 3:
                    course = new Course("物理",false);
                    break;
                case 4:
                    course = new Course("化学",false);
                    break;
                case 5:
                    course = new Course("生物",false);
                    break;
            }
            courseList.add(course);
        }
    }

    @Override
    public void onClick(View v) {
        Course course = null;
        switch (v.getId()){
            case R.id.btn_confirm:
                btnConfirmInPress = true;
                //点击此按钮，将选中的栏目的文本框展示出来
                //遍历链表
                for (int i=0; i<courseList.size(); i++){
                    course = courseList.get(i);
                    if(course.getCourseCheck()){
                        str += course.getCourseName();
                    }
                }
                //切换碎片，回到FragmentSong碎片，先把这个展示出来，然后再做一个recyclerView,把数据展示到recyclerView之下
                //获取 栈中的FragmentSong
                FragmentSong fragmentSong = (FragmentSong) getActivity().getSupportFragmentManager().findFragmentByTag("pre");
                //把值写到FragmentSong的控件中去
                fragmentSong.text = str;
                //FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.frame_main,fragmentSong);
//                fragmentTransaction.commit();
                //弹栈
                getActivity().getSupportFragmentManager().popBackStackImmediate();
                break;
        }
    }
}
