package com.example.comit.Notice;

import android.os.Bundle;
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

import java.util.ArrayList;

// 학과 공지
public class Depart_Frag extends Fragment {
    RecyclerView rv = null;
    RecyclerViewAdapter mAdapter = null;
    ArrayList<RecyclerViewItem> mList;

    private String mainText;
    private String subText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // return inflater.inflate(R.layout.frag1, container, false);

        View v = inflater.inflate(R.layout.departnotice, container, false);

        rv = (RecyclerView)v.findViewById(R.id.departnotice);

        mList = new ArrayList<>();
        mAdapter = new RecyclerViewAdapter(getActivity(), mList);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(mAdapter);


        mainText = "공지번호";
        subText = "내용";

        addItem(mainText + " - 1", subText);

        mAdapter.notifyDataSetChanged();

        return v;
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