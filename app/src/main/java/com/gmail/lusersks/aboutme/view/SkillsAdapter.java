package com.gmail.lusersks.aboutme.view;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.lusersks.aboutme.R;
import com.gmail.lusersks.aboutme.model.Skill;

import java.util.ArrayList;
import java.util.List;

class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.SkillsViewHolder> {
    private final List<Skill> list;

    SkillsAdapter() {
        list = new ArrayList<>();
    }

    @Override
    public SkillsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_skill, parent, false);

        return new SkillsAdapter.SkillsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SkillsViewHolder holder, int position) {
        Skill skill = list.get(position);
        holder.skill.setText(skill.getSkill());
        holder.years.setText(skill.getYears());
        holder.level.setText(skill.getLevel());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public List<Skill> getData() {
        return list;
    }

    public void setData(List<Skill> data) {
        for (Skill s : data) {
            list.add(s);
        }
        notifyDataSetChanged();
    }


    class SkillsViewHolder extends RecyclerView.ViewHolder {
        TextView skill, years, level;

        SkillsViewHolder(View view) {
            super(view);
            skill = (TextView) view.findViewById(R.id.tv_skill);
            years = (TextView) view.findViewById(R.id.tv_years);
            level = (TextView) view.findViewById(R.id.tv_level);
        }
    }
}
