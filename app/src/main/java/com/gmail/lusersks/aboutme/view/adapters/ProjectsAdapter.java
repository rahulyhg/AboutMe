package com.gmail.lusersks.aboutme.view.adapters;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.lusersks.aboutme.R;
import com.gmail.lusersks.aboutme.model.entity.Project;
import com.gmail.lusersks.aboutme.view.ProjectsActivity;

import java.util.ArrayList;
import java.util.List;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectsViewHolder> {
    private final List<Project> list;
    private final Activity activity;

    public ProjectsAdapter(Activity activity) {
        list = new ArrayList<>();
        this.activity = activity;
    }

    @Override
    public ProjectsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_project, parent, false);

        return new ProjectsAdapter.ProjectsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProjectsViewHolder holder, int position) {
        Project prj = list.get(position);
        holder.name.setText(prj.getName());
        holder.description.setText(prj.getDescription());
        holder.language.setText(prj.getLanguage());

        holder.cardView.setOnClickListener(v -> {
            Uri uri = Uri.parse(list.get(position).getUrl());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public List<Project> getData() {
        return list;
    }

    public void setData(List<Project> data) {
        list.addAll(data);
    }

    class ProjectsViewHolder extends RecyclerView.ViewHolder {
        TextView name, description, language;
        CardView cardView;

        ProjectsViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.project_card_view);
            name = (TextView) view.findViewById(R.id.tv_name);
            description = (TextView) view.findViewById(R.id.tv_description);
            language = (TextView) view.findViewById(R.id.tv_language);
        }
    }
}
