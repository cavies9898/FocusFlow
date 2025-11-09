package com.cavies.focusflow.ui.view.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cavies.focusflow.core.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navManager: NavigationManager
) : ViewModel() {

    fun onSplashFinished() {
        viewModelScope.launch {
            navManager.navigateAndPop("home", "splash", inclusive = true)
        }
    }
}
