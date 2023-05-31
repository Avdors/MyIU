package com.example.myiu.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myiu.R
import com.example.myiu.databinding.ActivityMainBinding
import com.example.myiu.presentation.autorization.Login
import com.example.myiu.presentation.viewModel.TaskViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    val taskViewModel: TaskViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        taskViewModel.migration(this)



        supportFragmentManager.beginTransaction().replace(R.id.content, Login()).commit()

        binding?.bottomNav?.selectedItemId = R.id.loginBottomNav

        binding?.bottomNav?.setOnItemSelectedListener { item ->

            when(item.itemId) {
                R.id.settingItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, SettingFragment()).commit()
                R.id.loginBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Login()).commit()
                R.id.allList -> supportFragmentManager.beginTransaction().replace(R.id.content, TaskAll()).commit()
            }

            return@setOnItemSelectedListener true
        }
    }
}