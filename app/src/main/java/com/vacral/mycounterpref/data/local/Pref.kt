package com.vacral.mycounterpref.data.local

import android.R.attr.value
import android.content.Context
import androidx.core.content.edit

class Pref(context: Context) {
    private val pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE)

    fun setCounter(counter: Int) {
        pref.edit().putInt("counter", counter).apply()
    }

    fun getCounter(): Int {
        return pref.getInt("counter", 0)
    }
    fun isInscresing(): Boolean {
        return pref.getBoolean("key", true)
    }
    fun setInscresing(value: Boolean){
        pref.edit{
            putBoolean("key", value)
        }
    }

}