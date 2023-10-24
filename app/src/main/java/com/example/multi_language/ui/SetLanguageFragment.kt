package com.example.multi_language.ui

import android.content.Intent
import android.view.View
import com.example.multi_language.MainActivity
import com.example.multi_language.R
import com.example.multi_language.base.BaseFragment
import com.example.multi_language.databinding.FragmentSetLanguagleBinding
import com.example.multi_language.util.Constants

class SetLanguageFragment : BaseFragment<FragmentSetLanguagleBinding>(FragmentSetLanguagleBinding::inflate) {
    override fun init(view: View) {
        binding.apply {
            btnCn.setOnClickListener {
                onClickBtnCn()
            }
            btnVn.setOnClickListener {
                onClickBtnVn()
            }
        }
    }

    private fun onClickBtnVn(){
        val editor = sharedPreferences?.edit()
        editor?.putString(Constants.LANGUAGE,resources.getString(R.string.language_vn_code))
        editor?.apply()
        startActivity(Intent(context,MainActivity::class.java))
        requireActivity().finish()
    }

    private fun onClickBtnCn(){
        val editor = sharedPreferences?.edit()
        editor?.putString(Constants.LANGUAGE,resources.getString(R.string.language_cn_code))
        editor?.apply()
        startActivity(Intent(context,MainActivity::class.java))
        requireActivity().finish()
    }

}