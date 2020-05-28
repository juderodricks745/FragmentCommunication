package com.davidbronn.fragmentrevision.navigation

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController

open class NavBaseFragment : Fragment() {

    fun <T> NavController.removeKeyAndNavigate(key: String) {
        this.previousBackStackEntry?.savedStateHandle?.remove<T>(key)
        popBackStack()
    }

    fun <T> NavController.addKeyAndNavigate(key: String, @NonNull t: T) {
        this.previousBackStackEntry?.savedStateHandle?.set(key, t)
        popBackStack()
    }

    fun <T> NavController.getLiveDataKey(key: String): MutableLiveData<T>? {
        return this.currentBackStackEntry?.savedStateHandle?.getLiveData(key)
    }
}
