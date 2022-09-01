package com.example.stackexchangeapp.ui.views.common

import android.content.Context
import android.view.View
import androidx.annotation.IdRes

abstract class BaseView: IBaseView {
    private lateinit var mRootView: View
    protected val context: Context get() = mRootView.context

    override val rootView: View
        get() = mRootView

    protected fun setRootView(view: View){
        mRootView = view
    }

    protected fun <T: View> findViewById(@IdRes id: Int): T {
        return rootView.findViewById(id)
    }
}
