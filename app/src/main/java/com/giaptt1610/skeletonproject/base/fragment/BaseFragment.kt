package com.giaptt1610.skeletonproject.base.fragment

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.giaptt1610.skeletonproject.base.viewmodel.BaseViewModel
import com.giaptt1610.skeletonproject.R
import com.giaptt1610.skeletonproject.base.activities.BaseActivity
import com.giaptt1610.skeletonproject.common.EventObserver

open class BaseFragment : Fragment() {

    protected fun navigateToPage(actionId: Int) {
        findNavController().navigate(actionId)
    }

    protected fun showLoading(isShow: Boolean) {
        val activity = requireActivity()
        if (activity is BaseActivity) {
            activity.showLoading(isShow)
        }
    }

    protected fun showErrorMessage(messageId: Int) {
        val message = requireContext().getString(messageId)
        showErrorMessage(message)
    }

    protected fun showErrorMessage(message: String) {
        val activity = requireActivity()
        if (activity is BaseActivity) {
            activity.showErrorDialog(message)
        }
    }

    protected fun showNotify(title: String?, message: String) {
        val activity = requireActivity()
        if (activity is BaseActivity) {
            activity.showNotifyDialog(title ?: getDefaultNotifyTitle(), message)
        }
    }

    protected fun showNotify(titleId: Int = R.string.default_notify_title, messageId: Int) {
        val activity = requireActivity()
        if (activity is BaseActivity) {
            activity.showNotifyDialog(titleId, messageId)
        }
    }

    protected fun registerObserverNetworkExceptionEvent(
        viewModel: BaseViewModel,
        viewLifecycleOwner: LifecycleOwner
    ) {
        viewModel.networkException.observe(viewLifecycleOwner, EventObserver {
            showNotify(getDefaultNotifyTitle(), it.message ?: "Network error")
        })
    }

    protected fun registerObserverMessageEvent(
        viewModel: BaseViewModel,
        viewLifecycleOwner: LifecycleOwner
    ) {
        viewModel.errorMessageResourceId.observe(viewLifecycleOwner, EventObserver { message ->
            showErrorMessage(message)
        })
    }

    protected fun registerObserverLoadingMoreEvent(
        viewModel: BaseViewModel,
        viewLifecycleOwner: LifecycleOwner
    ) {
        viewModel.isLoadingMore.observe(viewLifecycleOwner, EventObserver { isShow ->
            showLoadingMore(isShow)
        })
    }

    protected fun showLoadingMore(isShow: Boolean) {

    }


    private fun getDefaultNotifyTitle(): String {
        return getString(R.string.default_notify_title)
    }

    protected fun registerAllExceptionEvent(
        viewModel: BaseViewModel,
        viewLifecycleOwner: LifecycleOwner
    ) {
        registerObserverNetworkExceptionEvent(viewModel, viewLifecycleOwner)
        registerObserverMessageEvent(viewModel, viewLifecycleOwner)
    }

    protected fun registerObserverLoadingEvent(
        viewModel: BaseViewModel,
        viewLifecycleOwner: LifecycleOwner
    ) {
        viewModel.isLoading.observe(viewLifecycleOwner, EventObserver { isShow ->
            showLoading(isShow)
        })
    }

}