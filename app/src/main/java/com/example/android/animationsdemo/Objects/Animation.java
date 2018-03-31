package com.example.android.animationsdemo.Objects;

/**
 * Created by ayush on 25/2/18.
 */

public class Animation {

    public String tvCourseCode;
    public String tvCourseName;

    public Animation(String tvCourseCode, String tvCourseName){
        this.tvCourseCode = tvCourseCode;
        this.tvCourseName = tvCourseName;
        //this.tvCourseAttendance = tvCourseAttendance;
    }

    public void setTvCourseCode(String tvCourseCode) {
        this.tvCourseCode = tvCourseCode;
    }

    public void setTvCourseName(String tvCourseName) {
        this.tvCourseName = tvCourseName;
    }


    public String getTvCourseCode(){
        return tvCourseCode;
    }

    public String getTvCourseName() {
        return tvCourseName;
    }

}
