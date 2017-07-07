package com.gmail.lusersks.aboutme.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.lusersks.aboutme.R;
import com.gmail.lusersks.aboutme.model.Project;

import java.util.ArrayList;
import java.util.List;

class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectsViewHolder> {
    private final List<Project> list;

    ProjectsAdapter() {
        list = new ArrayList<>();
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
        holder.project.setText(prj.getProject());
        holder.tag.setText(prj.getTag());
        holder.description.setText(prj.getDescription());
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
        TextView project, tag, description;

        ProjectsViewHolder(View view) {
            super(view);
            project = (TextView) view.findViewById(R.id.tv_project);
            tag = (TextView) view.findViewById(R.id.tv_tag);
            description = (TextView) view.findViewById(R.id.tv_description);
        }
    }
}
