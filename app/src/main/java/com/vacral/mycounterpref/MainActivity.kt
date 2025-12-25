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

        binding.tvCounter.text = pref.getCounter().toString()
        binding.btnCounter.setOnClickListener {
            handleCounter()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }


    private fun handleCounter() {
        val counter = pref.getCounter()
        if (pref.isInscresing()) {
            if (counter < 10) {
                pref.setCounter(counter + 1)
            }
            if (counter + 1 >= 10) {
                pref.setInscresing(false)
            }
        } else {
            if (counter > 0) {
                pref.setCounter(counter - 1)
            }
            if (counter - 1 <= 0) {
                pref.setInscresing(true)
            }
        }
        UpdateUi()
    }

    private fun UpdateUi() {
        val counter = pref.getCounter()
        val isInscreasing = pref.isInscresing()

        binding.tvCounter.text = counter.toString()
        binding.btnCounter.text = if (isInscreasing) "+" else "-"
    }
}
