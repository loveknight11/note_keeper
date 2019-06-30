package com.example.notekeeper;

import androidx.annotation.NonNull;

public class CourseInfo {
    private String mCourseId;
    private String mCourseTitle;

    public CourseInfo(String courseId, String courseTitle) {
        mCourseId = courseId;
        mCourseTitle = courseTitle;
    }

    public String getCourseId() {
        return mCourseId;
    }

    public void setCourseId(String courseId) {
        mCourseId = courseId;
    }

    public String getCourseTitle() {
        return mCourseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        mCourseTitle = courseTitle;
    }

    @NonNull
    @Override
    public String toString() {
        return "Title : " + mCourseTitle;
    }
}
