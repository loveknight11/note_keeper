package com.example.notekeeper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "note_keeper.db";
    public static final int DATABASE_VERSION = 1;
    public DatabaseOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseContract.CourseInfoEntry.SQL_CREATE_TABLE);
        db.execSQL(DatabaseContract.NoteInfoEntry.SQL_CREATE_TABLE);

        DatabaseWorker worker = new DatabaseWorker(db);
        worker.intializeCourses();
        worker.intializeNotes();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
