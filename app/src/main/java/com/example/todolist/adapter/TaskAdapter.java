package com.example.todolist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;

import java.util.ArrayList;
import java.util.List;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {


    private List<String> taskList = new ArrayList<>();



    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_task, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {

        String currentTask = taskList.get(position);
        holder.taskTitleTextView.setText(currentTask);
    }

    @Override
    public int getItemCount() {

        return taskList.size();
    }


    public void setTasks(List<String> newTasks) {
        this.taskList = newTasks;
        notifyDataSetChanged();
    }


    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public TextView taskTitleTextView;
        public CheckBox taskCompletedCheckBox;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            taskTitleTextView = itemView.findViewById(R.id.textViewTaskTitle);
            taskCompletedCheckBox = itemView.findViewById(R.id.checkBoxCompleted);
        }
    }
}
