package com.example.comit.LectureEval.listfragments;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class SecondFragment extends com.example.comit.LectureEval.listfragments.PostListFragment2 {

    public SecondFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // [START recent_posts_query]
        // Last 100 posts, these are automatically the 100 most recent
        // due to sorting by push() keys
        Query recentPostsQuery = databaseReference.child("Lectures").orderByChild("grade").equalTo(2)
                .limitToFirst(100);
        // [END recent_posts_query]

        return recentPostsQuery;
    }
}
