package com.example.comit.LectureEval.models;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class Post2 {

//    public String uid;
//    public String author;
//    public String title;
//    public String body;
//    public int starCount = 0;
//    public Map<String, Boolean> stars = new HashMap<>();

    public String name = "강의 이름";
    public int stars = 0;
    public int votes = 0;
    public double avgstars = 0;


    public Post2() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Post2(String name, int stars, int votes, double avgstars) {
        this.name = name;
        this.stars = stars;
        this.votes = votes;
        this.avgstars = avgstars;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name",name);
        result.put("stars",stars);
        result.put("votes",votes);
        result.put("avgstars",stars/votes);
//        result.put("uid", uid);
//        result.put("author", author);
//        result.put("title", title);
//        result.put("body", body);
//        result.put("starCount", starCount);
//        result.put("stars", stars);

        return result;
    }

}
