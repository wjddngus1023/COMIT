package com.example.comit.LectureEval.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.comit.LectureEval.models.Post2;
import com.example.comit.R;

public class PostViewHolder2 extends RecyclerView.ViewHolder {

    public TextView titleView;
    public TextView authorView;
    public ImageView starView;
    public TextView starsView;
    public TextView numStarsView;
    public TextView bodyView;
    public TextView avgstarsView;

    public PostViewHolder2(View itemView) {
        super(itemView);

        titleView = itemView.findViewById(R.id.postTitle2);
        authorView = itemView.findViewById(R.id.postAuthor2);
        starView = itemView.findViewById(R.id.stars2);
        //starsView = itemView.findViewById(R.id.stars2);
        numStarsView = itemView.findViewById(R.id.postNumStars2);
        bodyView = itemView.findViewById(R.id.postBody2);
    }

    public void bindToPost(Post2 post, View.OnClickListener starClickListener) {
        titleView.setText(post.name);
        //starView.setText(post.stars);
        //authorView.setText(post.author);
        numStarsView.setText(String.valueOf(post.stars));
        //bodyView.setText(post.body);
        starView.setOnClickListener(starClickListener);
    }
}
