package com.example.comit.Guide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.comit.R;
import com.example.comit.ViewAdapter.RecyclerViewItem;

import java.util.ArrayList;

public class ListViewAdapter_3 extends BaseAdapter {

    private ArrayList<ListViewItem> itemList = new ArrayList<ListViewItem>();

    public ListViewAdapter_3(){

    }

    public int getCount(){
        return itemList.size();
    }

    public View getView(int position, View v , ViewGroup Vg){
        final int pos = position;
        final Context context = Vg.getContext();

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.guide_item_3, Vg, false);
        }
        TextView mainText = (TextView) v.findViewById(R.id.tv_item_main) ;
        TextView subText = (TextView) v.findViewById(R.id.tv_item_sub) ;

        ListViewItem ListViewItem = itemList.get(position);

        mainText.setText(ListViewItem.getTitle());
        subText.setText(ListViewItem.getDesc());

        return v;
    }

    public long getItemId(int position){
        return position;
    }

    public Object getItem(int position){
        return itemList.get(position);
    }
    public void addItem(String title, String desc){
        ListViewItem item = new ListViewItem();

        item.setTitle(title);
        item.setDesc(desc);

        itemList.add(item);
    }
}
