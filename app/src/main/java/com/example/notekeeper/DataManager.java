package com.example.notekeeper;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager instance = null;
    private static List<NoteInfo> mNotes = new ArrayList<>();
    private static List<CourseInfo> mCourses = new ArrayList<>();

    public List<NoteInfo> getNotes() {
        return mNotes;
    }

    public List<CourseInfo> getCourses() {
        return mCourses;
    }

    private DataManager(){}

    public static DataManager getInstance(){
        if (instance == null){
            instance = new DataManager();
            instance.intializeCourses();
            instance.instializeNotes();
        }
        return instance;
    }

    private void instializeNotes() {
        mNotes.add(new NoteInfo(mCourses.get(0) , "Title1","Text1"));
        mNotes.add(new NoteInfo(mCourses.get(1) , "Title2","Text2"));
        mNotes.add(new NoteInfo(mCourses.get(2) , "Title3","Text3"));
        mNotes.add(new NoteInfo(mCourses.get(3) , "Title4","Text4"));
        mNotes.add(new NoteInfo(mCourses.get(4) , "Title5","Text5"));
    }

    private void intializeCourses() {
        mCourses.add(new CourseInfo("1","Course1"));
        mCourses.add(new CourseInfo("2","Course2"));
        mCourses.add(new CourseInfo("3","Course3"));
        mCourses.add(new CourseInfo("4","Course4"));
        mCourses.add(new CourseInfo("5","Course5"));

    }
}
