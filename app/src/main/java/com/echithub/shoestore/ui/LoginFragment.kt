package com.echithub.shoestore.ui

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.echithub.shoestore.R
import com.echithub.shoestore.databinding.FragmentLoginBinding

import com.echithub.shoestore.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

//    private lateinit var loginViewModel: LoginViewModel
    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val usernameEditText = binding.username
        val passwordEditText = binding.password
        val loginButton = binding.loginButton
        val loadingProgressBar = binding.loading

        loginButton.setOnClickListener {
//            Toast.makeText(this,"I got here",Toast.LENGTH_LONG).show()
            Log.i("LoginFragment","On Click Setup")
            findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
//            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_welcomeFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}