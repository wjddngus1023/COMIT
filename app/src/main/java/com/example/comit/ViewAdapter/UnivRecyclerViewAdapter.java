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

public class UnivRecyclerViewAdapter extends RecyclerView.Adapter<UnivRecyclerViewAdapter.ViewHolder> {
    private ArrayList<RecyclerViewItem> mData = null;

    public UnivRecyclerViewAdapter(FragmentActivity activity, ArrayList<RecyclerViewItem> data){
        mData = data;
    }

    @NonNull
    @Override
    public UnivRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.recycler_univnotice,parent,false);
        UnivRecyclerViewAdapter.ViewHolder viewHolder = new UnivRecyclerViewAdapter.ViewHolder(v);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull UnivRecyclerViewAdapter.ViewHolder holder, int position) {
        RecyclerViewItem item = mData.get(position);

        holder.textview1.setText(item.getMainTitle());
        holder.textview2.setText(item.getSubTitle());
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

        ViewHolder(View itemView){
            super(itemView);

            textview1 = itemView.findViewById(R.id.univnotice_recycler_tv1);
            textview2 = itemView.findViewById(R.id.univnotice_recycler_tv2);
        }
        void onBind(RecyclerViewItem data){
            textview1.setText(data.getMainTitle());
            textview2.setText(data.getSubTitle());
        }
    }
}
