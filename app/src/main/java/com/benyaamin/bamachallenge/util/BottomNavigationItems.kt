package com.benyaamin.bamachallenge.util

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.benyaamin.bamachallenge.R
import com.benyaamin.bamachallenge.presentation.destinations.DirectionDestination
import com.benyaamin.bamachallenge.presentation.destinations.PostsScreenDestination
import com.benyaamin.bamachallenge.presentation.destinations.UsersScreenDestination

enum class BottomNavigationItems(
    val direction: DirectionDestination,
    val icon: ImageVector,
    @StringRes val title: Int
) {
    Posts(PostsScreenDestination, Icons.Default.Info, R.string.posts),
    Users(UsersScreenDestination, Icons.Default.Person, R.string.users)
}