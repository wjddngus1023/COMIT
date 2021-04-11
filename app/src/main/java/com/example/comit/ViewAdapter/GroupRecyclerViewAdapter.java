package com.example.comit.ViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comit.R;

import java.util.ArrayList;

public class GroupRecyclerViewAdapter extends RecyclerView.Adapter<GroupRecyclerViewAdapter.ViewHolder> {
    private ArrayList<RecyclerViewItem> mData = null;

    public GroupRecyclerViewAdapter(FragmentActivity activity, ArrayList<RecyclerViewItem> data){
        mData = data;
    }

    @NonNull
    @Override
    public GroupRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.recycler_groupnotice,parent,false);
        GroupRecyclerViewAdapter.ViewHolder viewHolder = new GroupRecyclerViewAdapter.ViewHolder(v);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull GroupRecyclerViewAdapter.ViewHolder holder, int position) {
        RecyclerViewItem item = mData.get(position);

        holder.textview1.setText(item.getMainTitle());
        holder.textview2.setText(item.getSubTitle());
        holder.textview3.setText(item.getDate());
    }

    public void addItem(RecyclerViewItem data){
        mData.add(data);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textview1;
        TextView textview2;
        TextView textview3;

        ViewHolder(View itemView){
            super(itemView);

            textview1 = itemView.findViewById(R.id.groupnotice_recycler_tv1);
            textview2 = itemView.findViewById(R.id.groupnotice_recycler_tv2);
            textview3 = itemView.findViewById(R.id.groupnotice_recycler_tv3);
        }
        void onBind(RecyclerViewItem data){
            textview1.setText(data.getMainTitle());
            textview2.setText(data.getSubTitle());
            textview3.setText(data.getDate());
        }
    }
}
