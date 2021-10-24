package com.example.comit.LectureEval.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User2 {

    public String username;
    public String email;

    public User2() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User2(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
