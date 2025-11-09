package com.cavies.focusflow.ui.view

import androidx.lifecycle.ViewModel
import com.cavies.focusflow.core.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavHostViewModel @Inject constructor(
    val navManager: NavigationManager
) : ViewModel()
