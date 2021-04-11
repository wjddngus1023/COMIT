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
import com.example.comit.ViewAdapter.DepartRecyclerViewAdapter;
import com.example.comit.ViewAdapter.RecyclerViewItem;
import com.example.comit.ViewAdapter.UnivRecyclerViewAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

// 학교 공지
public class Univ_Frag extends Fragment {
    RecyclerView rv = null;
    UnivRecyclerViewAdapter mAdapter = null;
    ArrayList<RecyclerViewItem> mList;
    String UnivURL = "https://www.hanbat.ac.kr/bbs/BBSMSTR_000000000042/list.do?mno=sub05_01";

    private String mainText;
    private String subText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // return inflater.inflate(R.layout.frag1, container, false);

        View v = inflater.inflate(R.layout.univnotice, container, false);

        rv = (RecyclerView) v.findViewById(R.id.univnotice);

        mList = new ArrayList<>();
        mAdapter = new UnivRecyclerViewAdapter(getActivity(), mList);
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
        ArrayList<String> ListDate = new ArrayList<>();

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect(UnivURL).get();
                final Elements Num = doc.select("div.no-more-tables table tbody tr td.atchFileId:nth-of-type(1)"); // td중에서 첫번째 꺼 가져오게해야돼
                final Elements Title = doc.select("div.no-more-tables table tbody tr td.subject"); // td중에서 두번째 거 가져오면 되
                final Elements Date = doc.select("div.no-more-tables table tbody tr td.regDate");

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
                        for (Element element : Date){
                            ListDate.add(element.text());
                        }
                        for (int i = 1; i < ListNum.size() ; i++) {
                            RecyclerViewItem data = new RecyclerViewItem();
                            data.setMainTitle(ListNum.get(i));
                            data.setSubTitle(ListTitle.get(i));
                            data.setDate(ListDate.get(i));

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

