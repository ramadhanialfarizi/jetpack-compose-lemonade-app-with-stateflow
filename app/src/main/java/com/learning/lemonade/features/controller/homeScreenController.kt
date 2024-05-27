package com.learning.lemonade.features.controller

import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.learning.lemonade.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeScreenController : ViewModel() {
    private val _count = MutableStateFlow(1)
    private val _imagesResult = MutableStateFlow(R.drawable.lemon_tree)
    private val _titleResult = MutableStateFlow("Tap the lemon tree to select a lemon")
    val imagesResult: StateFlow<Int> = _imagesResult
    val titleResult: StateFlow<String> = _titleResult

    fun onTapImage(){

        if(_count.value == 4) {
            _count.value = 1
        } else {
            _count.value++
        }
//        _count.value = (1..4).random()
        _imagesResult.value = when (_count.value) {
            1 -> R.drawable.lemon_tree
            2 -> R.drawable.lemon_squeeze
            3 -> R.drawable.lemon_drink
            4 -> R.drawable.lemon_restart
            else -> R.drawable.lemon_restart
        }

        _titleResult.value = when(_count.value) {
            1 -> "Tap the lemon tree to select a lemon"
            2 -> "Keep tapping the lemon to squeeze it"
            3 -> "Tap the lemonade to drink it"
            4 -> "Tap the empty glass to start again"
            else -> "Tap the lemon tree to select a lemon"
        }

    }
}