package com.example.comit.Notice;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comit.R;
import com.example.comit.ViewAdapter.RecyclerViewAdapter;
import com.example.comit.ViewAdapter.RecyclerViewItem;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

// 학과 공지
public class Depart_Frag extends Fragment {
    RecyclerView rv = null;
    RecyclerViewAdapter mAdapter = null;
    ArrayList<RecyclerViewItem> mList;
    String departURL = "https://www.hanbat.ac.kr/prog/bbsArticle/BBSMSTR_000000000333/list.do";

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
        mAdapter = new RecyclerViewAdapter(getActivity(), mList);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(mAdapter);

        getData();

        //mainText = "공지번호";
        //subText = "내용";

        mAdapter.notifyDataSetChanged();

        return v;
    }

    private void getData() {
        DepartSoup departSoup = new DepartSoup();
        departSoup.execute();
    }

    private class DepartSoup extends AsyncTask<Void, Void, Void> {
        ArrayList<String> ListNum = new ArrayList<>();
        ArrayList<String> ListTitle = new ArrayList<>();

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect(departURL).get();
                final Elements Num = doc.select("div.no-more-tables tr td"); // td중에서 첫번째 꺼 가져오게해야돼
                final Elements Title = doc.select(".subject td"); // 여기랑 윗줄 태그만 수정

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
                        for (int i = 1; i < ListNum.size() ; i++) {
                            RecyclerViewItem data = new RecyclerViewItem();
                            data.setMainTitle(ListNum.get(i));
                            //data.setSubTitle(ListTitle.get(i));

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
