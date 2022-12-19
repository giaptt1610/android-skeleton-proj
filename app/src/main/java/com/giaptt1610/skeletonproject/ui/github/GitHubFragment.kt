package com.giaptt1610.skeletonproject.ui.github

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.giaptt1610.skeletonproject.R
import com.giaptt1610.skeletonproject.databinding.FragmentGalleryBinding
import com.giaptt1610.skeletonproject.databinding.FragmentGitHubBinding
import com.giaptt1610.skeletonproject.ui.gallery.GalleryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GitHubFragment : Fragment() {

    private val viewModel: GithubViewModel by viewModels()

    private var _binding: FragmentGitHubBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGitHubBinding.inflate(inflater, container, false)

        viewModel.loading.observe(this.viewLifecycleOwner) {
            binding.progressBar2.visibility = if (it) View.VISIBLE else View.GONE
        }

        viewModel.searchResult.observe(this.viewLifecycleOwner) {
            binding.tvSearchResult.text = "Find ${it.size} result"
        }

        viewModel.searchUser("giap")
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}