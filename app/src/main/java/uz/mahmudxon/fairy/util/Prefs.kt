package uz.mahmudxon.fairy.util

import android.content.Context
import android.content.SharedPreferences

class Prefs(private val context: Context) {
    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(
            "this is a shared prefs",
            Context.MODE_PRIVATE
        )
    }


    fun save(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    fun get(key: String, default: Int) = sharedPreferences.getInt(key, default)

    fun save(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun get(key: String, default: String) = sharedPreferences.getString(key, default)

}