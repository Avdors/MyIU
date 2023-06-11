package com.example.myiu.presentation

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.myiu.R
import com.example.myiu.databinding.PanelEditTaskBinding
import com.example.myiu.presentation.viewModel.TaskViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class PanelEditTask : BottomSheetDialogFragment(), View.OnKeyListener, View.OnClickListener{

    private var binding: PanelEditTaskBinding? = null
    private var idTask: Int? = null
    private var email: String? = null
    private var typeTask: String? = null
    private var complet: String? = null
    private var taskViewModel: TaskViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = PanelEditTaskBinding.inflate(inflater, container, false)

        idTask = arguments?.getString("idTask")?.toInt()
        binding?.editNameTask?.setText(arguments?.getString("nameTask").toString())
        email = arguments?.getString("email")?.toString()
        typeTask = arguments?.getString("typeTask")?.toString()
        binding?.editInfoTask?.setText(arguments?.getString("infoTask").toString())
        binding?.DateStartTask?.setText(arguments?.getString("dateStart").toString())
        binding?.DateEndTask?.setText(arguments?.getString("dateEnd").toString())
        complet = arguments?.getString("completed").toString()
        if (complet == "true"){

          binding?.checkBoxCompleted?.isChecked = true
        }
        else binding?.checkBoxCompleted?.isChecked = false

        binding?.finishEdit?.setOnClickListener(this)

        return binding?.root
    }

    override fun onKey(view: View, i: Int, keyEvent: KeyEvent): Boolean {
        TODO("Not yet implemented")
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.finishEdit ->{
                var checked: String = ""
                if(binding?.checkBoxCompleted?.isChecked == true){
                   checked = "true"
                }
            taskViewModel?.startUpdateTask(idTask.toString().toInt(), binding?.editNameTask?.text?.toString()!!,
            email!!, typeTask.toString(),binding?.editInfoTask?.text?.toString()!!,binding?.DateStartTask?.toString()!!,
            binding?.DateEndTask.toString()!!, checked)
            //AVD
            taskViewModel?.startUpdateDb(context as FragmentActivity)
                dismiss()

                (context as FragmentActivity).supportFragmentManager.beginTransaction().replace(R.id.content, TaskForType()).commit()
            }
        }
    }
}