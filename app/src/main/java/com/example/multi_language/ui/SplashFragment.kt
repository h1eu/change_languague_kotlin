package com.example.multi_language.ui

import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.multi_language.R
import com.example.multi_language.base.BaseFragment
import com.example.multi_language.databinding.FragmentSplashBinding
import com.example.multi_language.util.Constants
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override fun init(view: View) {
        lifecycleScope.launch {
            delay(3000)
            goToSetLanguageScreen()
        }
    }

    private fun goToSetLanguageScreen(){
        navController?.navigate(R.id.setLanguageFragment)
    }
}