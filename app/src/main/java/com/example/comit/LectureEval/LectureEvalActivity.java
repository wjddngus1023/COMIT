package com.example.comit.LectureEval;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import com.example.comit.ChatbotActivity;
import com.example.comit.R;
import com.example.comit.databinding.CommunityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;



public class LectureEvalActivity extends AppCompatActivity {

    private FloatingActionButton fab2;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CommunityMainBinding binding = CommunityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fab2 = binding.fab2;

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        // 상태바 제거

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //상단바 제거

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.setGraph(R.navigation.nav_graph_java_2);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.MainFragment2) {
                    fab2.setVisibility(View.INVISIBLE);
                    fab2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            navController.navigate(R.id.action_MainFragment_to_NewPostFragment_2);
                        }
                    });
                } else {
                    fab2.setVisibility(View.GONE);
                }
            }
        });

        //onbackpressed를넣어서 오류처리해야될까


        Intent intent = new Intent(this, ChatbotActivity.class);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "챗봇 커미를 부릅니다", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (navController.getCurrentDestination().getId() == R.id.MainFragment2) {
            super.onBackPressed();
        } else {
            navController.navigate(R.id.MainFragment2);
        }
    }
}
