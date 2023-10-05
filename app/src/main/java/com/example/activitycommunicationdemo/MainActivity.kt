package com.example.activitycommunicationdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.activitycommunicationdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
//        private const val REQUEST_CODE = 1
        const val NAME = "NAME"
        const val AGE = "AGE"
    }

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val stringExtra = result.data?.getStringExtra(NAME)
                val intExtra = result.data?.getIntExtra(AGE, 0)
                binding.tvName.text = "收到的名字為 $stringExtra"
                binding.tvAge.text = "收到的年齡為 $intExtra"
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGo.setOnClickListener {
            val intent = Intent(this, AnotherActivity::class.java)
//            startActivityForResult(intent, REQUEST_CODE)
            resultLauncher.launch(intent)
        }


    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
//            val stringExtra = data?.getStringExtra(NAME)
//            val intExtra = data?.getIntExtra(AGE, 0)
//            binding.tvName.text = "收到的名字為 $stringExtra"
//            binding.tvAge.text = "收到的年齡為 $intExtra"
//        }
//    }
}