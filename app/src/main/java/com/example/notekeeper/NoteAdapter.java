package com.example.notekeeper;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<NoteInfo> mNotes;
    private Context mContext;

    public NoteAdapter(List<NoteInfo> mNotes, Context mContext) {
        this.mNotes = mNotes;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_list_row,parent,false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        NoteInfo note = mNotes.get(position);
        holder.bind(note);
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle;
        private TextView tvCourse;


        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvCourse = itemView.findViewById(R.id.tv_course);
        }

        public void bind(NoteInfo note){
            tvTitle.setText(note.getTitle());
            tvCourse.setText(note.getCourse().getCourseTitle());
        }
    }
}
