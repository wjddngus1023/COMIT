package com.example.comit.LectureEval.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.comit.R;

public class CommentViewHolder2 extends RecyclerView.ViewHolder {
    public TextView authorView;
    public TextView bodyView;

    public CommentViewHolder2(View itemView) {
        super(itemView);
        authorView = itemView.findViewById(R.id.commentAuthor2);
        bodyView = itemView.findViewById(R.id.commentBody2);
    }
}
