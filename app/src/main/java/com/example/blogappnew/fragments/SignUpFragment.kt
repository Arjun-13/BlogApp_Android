package com.example.blogappnew.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.blogappnew.R
import com.example.blogappnew.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.tvSignIn.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frame_auth_container, SignInFragment()).commit()
        }

        binding.btnSignUp.setOnClickListener {
            if (validate()) {

            }
        }

        binding.tvEmailSignUp.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (binding.tvEmailSignUp.text.toString().isNotEmpty()) {
                    binding.textLayoutEmailSignUp.isErrorEnabled = false
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })

        binding.tvPasswordSignUp.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.tvPasswordSignUp.text.toString().isNotEmpty()) {
                    binding.textLayoutPasswordSignUp.isErrorEnabled = false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        binding.tvConfirmPwSignUp.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.tvConfirmPwSignUp.text.toString() == binding.tvPasswordSignUp.text.toString()) {
                    binding.textLayoutPasswordConfirmSignUp.isErrorEnabled = false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    private fun validate(): Boolean {
        if (binding.tvEmailSignUp.text.toString().isEmpty()) {
            binding.textLayoutEmailSignUp.isErrorEnabled = true
            binding.textLayoutEmailSignUp.error = "Email is required"
            return false
        }
        if (binding.tvPasswordSignUp.text.toString().length < 8) {
            binding.textLayoutPasswordSignUp.isErrorEnabled = true
            binding.textLayoutPasswordSignUp.error = "Required at least 8 character"
            return false
        }
        if (binding.tvConfirmPwSignUp.text.toString() != binding.tvPasswordSignUp.text.toString()) {
            binding.textLayoutPasswordConfirmSignUp.isErrorEnabled = true
            binding.textLayoutPasswordConfirmSignUp.error = "Password Miss match"
            return false
        }
        return true
    }

}