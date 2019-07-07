package com.example.notekeeper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseWorker {
    private SQLiteDatabase mDB;

    public DatabaseWorker(SQLiteDatabase mDB) {
        this.mDB = mDB;
    }

    public void intializeCourses(){
        addCourse("test1","Course1");
        addCourse("test2","Course2");
        addCourse("test3","Course3");
        addCourse("test4","Course4");
        addCourse("test5","Course5");
    }

    public void intializeNotes(){
        addNote("Title1","Text1","test1");
        addNote("Title2","Text2","test2");
        addNote("Title3","Text3","test3");
        addNote("Title4","Text4","test4");
        addNote("Title5","Text5","test5");
    }

    private void addCourse(String courseId, String courseName){
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.CourseInfoEntry.COLUMN_COURSE_ID, courseId);
        values.put(DatabaseContract.CourseInfoEntry.COLUMN_COURSE_NAME, courseName);

        mDB.insert(DatabaseContract.CourseInfoEntry.TABLE_NAME,null,values);
    }

    private void addNote(String noteTitle, String noteText, String courseId){
        ContentValues values = new ContentValues();

        values.put(DatabaseContract.NoteInfoEntry.COLUMN_COURSE_ID, courseId);
        values.put(DatabaseContract.NoteInfoEntry.COLUMN_NOTE_TEXT, noteText);
        values.put(DatabaseContract.NoteInfoEntry.COLUMN_NOTE_TITLE, noteTitle);

        mDB.insert(DatabaseContract.NoteInfoEntry.TABLE_NAME,null,values);
    }
}
