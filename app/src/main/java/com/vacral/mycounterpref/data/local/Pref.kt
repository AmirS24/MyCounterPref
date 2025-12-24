package com.vacral.mycounterpref.data.local

import android.content.Context

class Pref(context : Context) {
val pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE)

fun setCounter(counter : Int){
    pref.edit().putInt("counter", counter).apply()
}
    fun getCounter(): Int{
        return pref.getInt("counter", 0)


    }

}