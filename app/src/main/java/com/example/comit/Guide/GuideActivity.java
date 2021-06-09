package com.example.comit.Guide;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.comit.ChatbotActivity;
import com.example.comit.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_main);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        // 상태바 제거

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //상단바 제거

        Intent intent1 = new Intent(this, Guide_frag_1.class); // 이동 액티비티 설정
        Intent intent2 = new Intent(this, Guide_frag_2.class);
        Intent intent3 = new Intent(this, Guide_frag_3.class);
        Intent intent4 = new Intent(this, Guide_frag_4.class);
        Intent intent5 = new Intent(this, Guide_frag_5.class);
        Intent intent6 = new Intent(this, Guide_frag_6.class);

        ListView listview;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        listview = (ListView)findViewById(R.id.guide_list);
        listview.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_android_black_24dp),"유용한 사이트들","새내기도, 4학년도 자주쓰는 꿀사이트!");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_android_black_24dp),"한밭대동여지도","학교지리를 잘 모르신다구요?");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_android_black_24dp),"교수님 소개","분명 인사는 드렸는데..누구시지?");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_android_black_24dp),"랩실 소개","저희과는 어떤 랩실이있나요?");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_android_black_24dp),"학번별 졸업 요건","5학년이 되고 싶지 않다면 필수!");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_android_black_24dp),"필수 교양 목록","미리미리 꼭 들어야할 필수 교양!");


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                final ListViewItem item = (ListViewItem) adapter.getItem(position);
                if(position == 0){
                    startActivity(intent1);
                }
                else if(position == 1){
                    startActivity(intent2);
                    Toast.makeText(GuideActivity.this,"2021년 상반기 기준입니다",Toast.LENGTH_SHORT).show();
                }
                else if(position == 2){
                    startActivity(intent3);
                    Toast.makeText(GuideActivity.this,"2021년 상반기 기준입니다",Toast.LENGTH_SHORT).show();
                }
                else if(position ==3){
                    startActivity(intent4);
                    Toast.makeText(GuideActivity.this,"2021년 상반기 기준입니다",Toast.LENGTH_SHORT).show();
                }
                else if(position ==4){
                    startActivity(intent5);
                    Toast.makeText(GuideActivity.this,"사진을 누르시면 확대/축소가 가능합니다",Toast.LENGTH_SHORT).show();
                }
                else if(position == 5){
                    startActivity(intent6);
                }
                //startActivity(intent1); // 액티비티 이동
                //Toast.makeText(GuideActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show(); // 여긴 지워도됨
            }
        });
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




}
