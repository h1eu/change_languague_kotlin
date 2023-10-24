package com.example.multi_language.base

import android.content.Context
import android.content.ContextWrapper
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.example.multi_language.util.Constants
import com.example.multi_language.util.ContextWrapperUtil
import java.util.Locale

abstract class BaseActivity : AppCompatActivity() {
    private var sharedPreferences: SharedPreferences? = null
    override fun attachBaseContext(newBase: Context?) {
        sharedPreferences = newBase?.getSharedPreferences(Constants.LANGUAGE,Context.MODE_PRIVATE)
        val language = sharedPreferences?.getString(Constants.LANGUAGE,"")
        if (language != null) {
            if (language.isNotEmpty()){
                val localeSwitchTo = Locale(language)
                val localeUpdateContext: ContextWrapper? =
                    newBase?.let { ContextWrapperUtil.updateLocale(it,localeSwitchTo) }
                super.attachBaseContext(localeUpdateContext)
            }
        }
        else{
            super.attachBaseContext(newBase)
        }
    }
}