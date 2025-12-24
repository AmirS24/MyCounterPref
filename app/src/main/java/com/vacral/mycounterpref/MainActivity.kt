package com.vacral.mycounterpref

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vacral.mycounterpref.data.local.Pref
import com.vacral.mycounterpref.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var pref: Pref
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = Pref(context = this)
        val counter = pref.getCounter()
        binding.btnCounter.setOnClickListener {
            pref.setCounter(pref.getCounter() + 1)
            binding.tvCounter.setText(pref.getCounter().toString())

        }
        binding.tvCounter.text = counter.toString()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}