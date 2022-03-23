package com.example.task.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.setFragmentResult
import com.example.task.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {
    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonFourthScreen.setOnClickListener {
            val thirdFragment = ThirdFragment()
            val fragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

            val getAgeInput = binding.editTextAge.text.toString().toInt()
            val getAddressInput = binding.editTextAddress.text.toString()
            val getJobInput = binding.editTextJob.text.toString()

            val bundle = Bundle().apply {
                putString(ThirdFragment.EXTRA_ADDRESS, getAddressInput)
                putInt(ThirdFragment.EXTRA_AGE, getAgeInput)
                putString(ThirdFragment.EXTRA_JOB, getJobInput)
            }

            thirdFragment.arguments = bundle

            setFragmentResult(ThirdFragment.REQUEST_KEY, bundle)

            fragmentManager.popBackStack()
            fragmentTransaction.commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}