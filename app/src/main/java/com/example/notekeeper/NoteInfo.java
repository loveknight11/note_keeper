package com.example.notekeeper;

import androidx.annotation.NonNull;

public class NoteInfo {
    private CourseInfo mCourse;
    private String mTitle;
    private String mText;

    public NoteInfo(CourseInfo course, String title, String text) {
        mCourse = course;
        mTitle = title;
        mText = text;
    }

    public CourseInfo getCourse() {
        return mCourse;
    }

    public void setCourse(CourseInfo course) {
        mCourse = course;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    @NonNull
    @Override
    public String toString() {
        return "Coure : " + mCourse.getCourseTitle() + "\nTitle : " + mTitle + "\nText : " + mText;
    }
}
