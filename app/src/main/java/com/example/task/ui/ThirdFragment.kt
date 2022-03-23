package com.example.task.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.setFragmentResultListener
import com.example.task.R
import com.example.task.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        setFragmentResultListener(REQUEST_KEY) { _, bundle ->
            val getJobBundle = bundle.getString(EXTRA_JOB)
            val getAgeBundle = bundle.getInt(EXTRA_AGE)
            val getAddressBundle = bundle.getString(EXTRA_ADDRESS)

            val getOddOrEven = if (getAgeBundle %2 == 0){
                "$getAgeBundle, Usia anda bernilai genap"
            } else {
                "$getAgeBundle, Usia anda bernilai ganjil"
            }

            binding.textViewAge.text = getOddOrEven
            binding.textViewAge.visibility = View.VISIBLE

            binding.textViewAddress.text = getAddressBundle
            binding.textViewAddress.visibility = View.VISIBLE

            binding.textViewJob.text = getJobBundle
            binding.textViewJob.visibility = View.VISIBLE
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getNameBundle = arguments?.getString(EXTRA_NAME)
        binding.textViewName.text = getNameBundle

        binding.buttonThirdScreen.setOnClickListener {
            val fourthFragment = FourthFragment()
            val fragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

            fragmentTransaction.replace(
                R.id.frame_layout_container,
                fourthFragment,
                FourthFragment::class.java.simpleName
            )
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val EXTRA_ADDRESS = "extraAddress"
        const val EXTRA_AGE = "extraAge"
        const val EXTRA_JOB = "extraJob"
        const val EXTRA_NAME = "extraName"
        const val REQUEST_KEY = "requestKey"
    }
}