package com.example.notekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class NoteActivity extends AppCompatActivity {

    private List<NoteInfo> mNotes;
    private List<CourseInfo> mCourses;
    private NoteInfo mNote;
    private ArrayAdapter mSpinnerAdapter;
    private Spinner spCourses;
    private EditText etTitle;
    private EditText etText;
    private boolean isNewNote = false;
    private boolean isCancel = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mNotes = DataManager.getInstance().getNotes();
        mCourses = DataManager.getInstance().getCourses();

        etTitle = findViewById(R.id.et_title);
        etText = findViewById(R.id.et_text);
        fillSpinner();

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",-1);
        if (position == -1){
            mNote = new NoteInfo();
            isNewNote = true;
        } else {
            mNote = mNotes.get(position);
            etText.setText(mNote.getText());
            etTitle.setText(mNote.getTitle());
            int spinnerPosition = mSpinnerAdapter.getPosition(mNote.getCourse());
            spCourses.setSelection(spinnerPosition);
        }

    }

    private void fillSpinner() {
        mSpinnerAdapter = new ArrayAdapter<CourseInfo>(
                this, android.R.layout.simple_spinner_item, mCourses);

        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCourses = findViewById(R.id.sp_courses);
        spCourses.setAdapter(mSpinnerAdapter);
    }

    @Override
    protected void onPause() {
        if (!isCancel) {
            mNote.setCourse((CourseInfo) spCourses.getSelectedItem());
            mNote.setTitle(etTitle.getText().toString());
            mNote.setText(etText.getText().toString());
            if (isNewNote) {
                mNotes.add(mNote);
            }
        }
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_note,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_cancel:
                isCancel = true;
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
