package com.example.comit.LectureEval.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Comment2 {

    public String uid;
    public String author;
    public String text;

    public Comment2() {
        // Default constructor required for calls to DataSnapshot.getValue(Comment.class)
    }

    public Comment2(String uid, String author, String text) {
        this.uid = uid;
        this.author = author;
        this.text = text;
    }

}
