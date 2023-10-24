package com.example.multi_language.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import android.os.LocaleList
import com.google.android.material.internal.ContextUtils
import java.util.Locale

class ContextWrapperUtil(base: Context) : ContextWrapper(base) {
    companion object{
        @SuppressLint("ObsoleteSdkInt")
        fun updateLocale(c: Context, localeSwitchTo: Locale) : ContextWrapper{
            var context = c
            val resources = context.resources
            val configuration = resources.configuration
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                val localeList = LocaleList(localeSwitchTo)
                LocaleList.setDefault(localeList)
                configuration.setLocales(localeList)
            }
            else{
                @Suppress("DEPRECATION")
                configuration.locale = localeSwitchTo
            }
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1){
                context = context.createConfigurationContext(configuration)
            }
            else{
                @Suppress("DEPRECATION")
                resources.updateConfiguration(configuration,resources.displayMetrics)
            }
            return ContextWrapperUtil(context)
        }
    }
}