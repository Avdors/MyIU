package com.example.myiu.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myiu.R
import com.example.myiu.data.models.TaskModel
import com.example.myiu.databinding.TaskAllBinding
import com.example.myiu.presentation.viewModel.TaskViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class TaskAll : Fragment() {

    private var binding: TaskAllBinding? = null
    private var taskAdapter: TaskAdapter? = null
    val taskViewModel: TaskViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TaskAllBinding.inflate(inflater, container, false)
        initRecyclerProducts()
        loadProducts()
        return binding?.root
    }

    private fun initRecyclerProducts(){

        binding?.recyclerTask?.layoutManager = LinearLayoutManager(context)
        taskAdapter = TaskAdapter({taskModel: TaskModel -> completeTask(taskModel)  },
            {taskModel: TaskModel -> editTask(taskModel)  })
        binding?.recyclerTask?.adapter = taskAdapter

    }

    private fun completeTask(taskModel: TaskModel) {
    }

    private fun editTask(taskModel: TaskModel) {
    }
    private fun loadProducts(){
        taskViewModel.loadTask.observe(viewLifecycleOwner, Observer {
            taskAdapter?.setList(it)
            taskAdapter?.notifyDataSetChanged()
        })
    }



}