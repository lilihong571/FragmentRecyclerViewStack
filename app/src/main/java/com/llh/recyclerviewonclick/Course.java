package com.llh.recyclerviewonclick;

/**
 * 项目名:    RecyclerViewOnClick
 * 包名:      com.llh.recyclerviewonclick
 * 文件名:    Course
 * 创建者:    LLH
 * 创建时间:  2019/8/9 10:32
 * 描述:      TODO
 */
public class Course {
    //复选框，课程名
    private boolean courseCheck;
    private String courseName;
    //构造函数
    public Course(String courseName,boolean courseCheck){
        this.courseName = courseName;
        this.courseCheck = courseCheck;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean getCourseCheck() {
        return courseCheck;
    }

    public void setCourseCheck(boolean courseCheck) {
        this.courseCheck = courseCheck;
    }
}
