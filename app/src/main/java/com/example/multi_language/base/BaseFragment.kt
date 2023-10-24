package com.example.multi_language.base

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.multi_language.util.Constants

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
abstract class BaseFragment<B : ViewBinding>(val inflate: Inflate<B>) : Fragment() {
    var navController: NavController? = null
    var sharedPreferences: SharedPreferences? = null
    private lateinit var _binding: B
    val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        sharedPreferences = requireActivity().getSharedPreferences(Constants.LANGUAGE,Context.MODE_PRIVATE)
        init(view)
    }

    abstract fun init(view: View)

}