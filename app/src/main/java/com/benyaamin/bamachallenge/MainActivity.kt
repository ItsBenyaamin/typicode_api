package com.benyaamin.bamachallenge

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.benyaamin.bamachallenge.presentation.NavGraphs
import com.benyaamin.bamachallenge.presentation.appCurrentDestinationAsState
import com.benyaamin.bamachallenge.ui.theme.BamaChallengeTheme
import com.benyaamin.bamachallenge.util.BottomNavigationItems
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.utils.startDestination
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
@Composable
fun MainScreen() {
    val engine = rememberAnimatedNavHostEngine()
    val navController = engine.rememberNavController()

    BamaChallengeTheme {
        Scaffold(
            bottomBar = {
                BottomNavigation(navController = navController)
            }
        ) {
            DestinationsNavHost(
                modifier = Modifier.padding(it),
                engine = engine,
                navController = navController,
                navGraph = NavGraphs.root,
                startRoute = NavGraphs.root.startRoute
            )
        }
    }
}

@Composable
fun BottomNavigation(
    navController: NavController
) {
    val currentDestination = navController.appCurrentDestinationAsState().value ?: NavGraphs.root.startDestination
    BottomNavigation() {
        BottomNavigationItems.values().forEach { dest ->
            BottomNavigationItem(selected = currentDestination == dest.direction,
                onClick = {
                    navController.navigate(dest.direction) {
                        launchSingleTop = true
                    }
                },
                icon = { Icon(dest.icon, contentDescription = stringResource(dest.title))},
                label = { Text(stringResource(dest.title)) },
            )
        }
    }
}

@Preview
@Composable
fun PreviewMainActivity() {
    MainScreen()
}