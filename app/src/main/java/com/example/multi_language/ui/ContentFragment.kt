package com.example.multi_language.ui

import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.multi_language.R
import com.example.multi_language.base.BaseFragment
import com.example.multi_language.databinding.FragmentContentBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ContentFragment : BaseFragment<FragmentContentBinding>(FragmentContentBinding::inflate) {
    override fun init(view: View) {
        lifecycleScope.launch {
            delay(3000)
            navController?.navigate(R.id.contentFragment2)
        }
    }
}