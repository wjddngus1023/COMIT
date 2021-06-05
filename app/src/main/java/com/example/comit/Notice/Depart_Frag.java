package com.example.comit.Notice;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comit.ChatbotActivity;
import com.example.comit.R;
import com.example.comit.ViewAdapter.DepartRecyclerViewAdapter;
import com.example.comit.ViewAdapter.RecyclerViewItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

// 학과 공지
public class Depart_Frag extends Fragment {
    RecyclerView rv = null;
    DepartRecyclerViewAdapter mAdapter = null;
    ArrayList<RecyclerViewItem> mList;
    String departURL = "https://www.hanbat.ac.kr/prog/bbsArticle/BBSMSTR_000000000333/list.do?pageIndex=1"; // ?이후는 페이지번호에요
    private String mainText;
    private String subText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // return inflater.inflate(R.layout.frag1, container, false);

        View v = inflater.inflate(R.layout.departnotice, container, false);

        rv = (RecyclerView) v.findViewById(R.id.departnotice);

        mList = new ArrayList<>();
        mAdapter = new DepartRecyclerViewAdapter(getActivity(), mList);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(mAdapter);

        // 클릭리스너 테스트
        // Longclick리스너로 북마크
        // clicklistener로 웹 이동

        getData();
        mAdapter.notifyDataSetChanged();

        return v;

    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            rv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    RecyclerViewItem item = mList.get(pos);
                    if(pos != RecyclerView.NO_POSITION){
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getLink()));
                        startActivity(intent);
                    }
                }
            });
        }
    } // 여기 외않됀대?

    private void getData() {
        DepartSoup departSoup = new DepartSoup();
        departSoup.execute();
    }

    private class DepartSoup extends AsyncTask<Void, Void, Void> {
        ArrayList<String> ListNum = new ArrayList<>();
        ArrayList<String> ListTitle = new ArrayList<>();
        ArrayList<String> ListDate = new ArrayList<>();
        ArrayList<String> ListLink = new ArrayList<>();

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect(departURL).get();
                final Elements Num = doc.select("div.no-more-tables table tbody tr td.atchFileId:nth-of-type(1)"); // 번호
                final Elements Title = doc.select("div.no-more-tables table tbody tr td.subject"); // 제목
                final Elements Date = doc.select("div.no-more-tables table tbody tr td.regDate"); // 날짜
                final Elements Link = doc.select("div.no-more-tables table tbody tr td.subject a"); // 링크


                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        for (Element element : Num) {
                            ListNum.add(element.text());
                        }
                        for (Element element : Title) {
                            ListTitle.add(element.text());
                        }
                        for( Element element : Date){
                            ListDate.add(element.text());
                        }
                        for( Element element : Link){
                            ListLink.add(element.text());
                        }
                        for (int i = 0; i < ListNum.size() ; i++) {
                            RecyclerViewItem data = new RecyclerViewItem();
                            data.setMainTitle(ListNum.get(i));
                            data.setSubTitle(ListTitle.get(i));
                            data.setDate(ListDate.get(i));
                            data.setLink(ListLink.get(i));

                            mAdapter.addItem(data);
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private void addItem(String mainText, String subText){
        RecyclerViewItem item = new RecyclerViewItem();

        item.setMainTitle(mainText);
        item.setSubTitle(subText);

        mList.add(item);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}

