package com.giaptt1610.skeletonproject.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.giaptt1610.skeletonproject.R
import com.giaptt1610.skeletonproject.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnGallery.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_galleryFragment)
        }

        binding.btnGitgub.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_gitHubFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}