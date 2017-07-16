package com.gmail.lusersks.aboutme.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.lusersks.aboutme.R;

import java.util.ArrayList;
import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {
    private final List<String> list;

    public InfoAdapter() {
        list = new ArrayList<>();
    }

    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_info, parent, false);

        return new InfoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, int position) {
        String str = list.get(position);
        holder.infoString.setText(str);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public List<String> getData() {
        return list;
    }

    public void setData(List<String> data) {
        for (String s : data) {
            list.add(s);
        }
        notifyDataSetChanged();
    }


    class InfoViewHolder extends RecyclerView.ViewHolder {
        TextView infoString;

        InfoViewHolder(View view) {
            super(view);
            infoString = (TextView) view.findViewById(R.id.info_string);
        }
    }
}
