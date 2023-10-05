package com.example.activitycommunicationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activitycommunicationdemo.MainActivity.Companion.AGE
import com.example.activitycommunicationdemo.MainActivity.Companion.NAME
import com.example.activitycommunicationdemo.databinding.ActivityAnotherBinding

class AnotherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnotherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnotherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val age = binding.editTextAge.text.toString().toInt()
            intent.putExtra(NAME,name)
            intent.putExtra(AGE, age)

            setResult(RESULT_OK,intent)
            finish()
        }
    }
}