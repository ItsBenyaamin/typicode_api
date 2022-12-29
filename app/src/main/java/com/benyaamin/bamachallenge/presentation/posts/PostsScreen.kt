package com.benyaamin.bamachallenge.presentation.posts

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.benyaamin.bamachallenge.ui.PostItem
import com.benyaamin.bamachallenge.presentation.destinations.PostScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination()
@Composable
fun PostsScreen(
    viewModel: PostsViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val state = viewModel.state

    if (state.message.isNotEmpty()) {
        Toast.makeText(LocalContext.current, state.message, Toast.LENGTH_SHORT).show()
    }
    state.messageId?.let {
        Toast.makeText(LocalContext.current, it, Toast.LENGTH_SHORT).show()
    }

    Box(modifier = Modifier
        .fillMaxSize()) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            content = {
                items(state.posts.size) { index ->
                    val item = state.posts[index]
                    PostItem(post = item, onClick = {
                        navigator.navigate(
                            PostScreenDestination(postId = item.id)
                        )
                    })
                }
            }
        )

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(35.dp)
                    .align(Alignment.Center),
                color = Color.Black,
            )
        }
    }
}