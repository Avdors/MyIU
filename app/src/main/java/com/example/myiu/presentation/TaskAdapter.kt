package com.example.myiu.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myiu.data.models.TaskModel
import com.example.myiu.databinding.TaskItemBinding

class TaskAdapter (private val completeTask:(TaskModel)->Unit,
                   private val editTask:(TaskModel)->Unit) : RecyclerView.Adapter<TaskAdapter.TaskHolder>() {

    private val taskList = ArrayList<TaskModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {

        val binding : TaskItemBinding = TaskItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskHolder(binding)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.bind(taskList[position], completeTask, editTask)
    }

    fun setList(task: List<TaskModel>) {
        taskList.clear()
        taskList.addAll(task)
    }


    class TaskHolder(val binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(taskModel: TaskModel,
                 completeTask: (TaskModel) -> Unit,
                 editTask: (TaskModel) -> Unit
        ) {
            binding.nameTask.text = taskModel.name
            binding.completeTask.setOnClickListener({
                completeTask(taskModel) })
            binding.editTask.setOnClickListener({
                editTask(taskModel) })
        }

    }

}