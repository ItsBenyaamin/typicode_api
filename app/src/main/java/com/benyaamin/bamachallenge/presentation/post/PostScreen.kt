package com.benyaamin.bamachallenge.presentation.post

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.benyaamin.bamachallenge.ui.CircularLoading
import com.benyaamin.bamachallenge.ui.PostItem
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun PostScreen(
    postId: Int,
    viewModel: PostViewModel = hiltViewModel()
) {
    val state = viewModel.state
    if (state.message.isNotEmpty()) {
        Toast.makeText(LocalContext.current, state.message, Toast.LENGTH_SHORT).show()
    }
    state.messageId?.let {
        Toast.makeText(LocalContext.current, it, Toast.LENGTH_SHORT).show()
    }

    LaunchedEffect(Unit) {
        viewModel.getPost(postId)
    }
    Box(modifier = Modifier
        .fillMaxSize()) {
        state.data?.let {
            PostItem(post = it)
        }

        CircularLoading(state.isLoading)
    }
}