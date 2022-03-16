package com.example.blogappnew.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.blogappnew.R
import com.example.blogappnew.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {

        binding.tvSignUp.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frame_auth_container, SignUpFragment()).commit()
        }

        binding.btnSignIn.setOnClickListener {
            if (validate()) {

            }
        }

        binding.tvEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (binding.tvEmail.text.toString().isNotEmpty()) {
                    binding.textLayoutEmailSignIn.isErrorEnabled = false
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })

        binding.tvPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.textLayoutPasswordSignIn.isErrorEnabled =
                    binding.tvPassword.text.toString().isEmpty()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })


    }

    private fun validate(): Boolean {
        if (binding.tvEmail.text.toString().isEmpty()) {
            binding.textLayoutEmailSignIn.isErrorEnabled = true
            binding.textLayoutEmailSignIn.error = "Email is required"
            return false
        }
        if (binding.tvPassword.text.toString().length < 8) {
            binding.textLayoutPasswordSignIn.isErrorEnabled = true
            binding.textLayoutPasswordSignIn.error = "Required at least 8 character"
            return false
        }
        return true
    }

}