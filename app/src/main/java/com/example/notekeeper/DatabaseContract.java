package com.example.notekeeper;

import android.provider.BaseColumns;

public final class DatabaseContract {
    private DatabaseContract() {
    }

    public static final class CourseInfoEntry implements BaseColumns{
        public static final String TABLE_NAME = "course_info";
        public static final String COLUMN_COURSE_ID = "course_id";
        public static final String COLUMN_COURSE_NAME = "course_name";

        public static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY, " +
                COLUMN_COURSE_ID + " TEXT UNIQUE NOT NULL, " +
                COLUMN_COURSE_NAME + " TEXT NOT NULL)";

    }

    public static final class NoteInfoEntry implements BaseColumns{
        public static final String TABLE_NAME = "Note_info";
        public static final String COLUMN_NOTE_TITLE = "note_title";
        public static final String COLUMN_NOTE_TEXT = "note_text";
        public static final String COLUMN_COURSE_ID = "course_id";

        public static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY, " +
                COLUMN_NOTE_TITLE + " TEXT NOT NULL, " +
                COLUMN_NOTE_TEXT + " TEXT, " +
                COLUMN_COURSE_ID + " TEXT NOT NULL)";
    }
}