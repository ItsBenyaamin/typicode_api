package com.benyaamin.bamachallenge.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benyaamin.bamachallenge.data.remote.dto.Post

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostItem(post: Post, onClick: ((postId: Int) -> Unit)? = null) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        onClick = { onClick?.invoke(post.id) }
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = post.title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = post.body)
        }
    }
}