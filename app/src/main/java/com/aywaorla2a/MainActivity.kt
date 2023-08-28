package com.aywaorla2a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.aywaorla2a.home.YesOrNo
import com.aywaorla2a.home.YesOrNoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: YesOrNoViewModel by viewModels()

        setContent {

            YesOrNo(yesOrNoViewModel = viewModel)

        }
    }
}
