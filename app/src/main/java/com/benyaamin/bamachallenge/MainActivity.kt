package com.benyaamin.bamachallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.benyaamin.bamachallenge.presentation.NavGraphs
import com.benyaamin.bamachallenge.ui.theme.BamaChallengeTheme
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
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
        Surface(modifier = Modifier.fillMaxSize(), color = Color.LightGray) {
            DestinationsNavHost(
                engine = engine,
                navController = navController,
                navGraph = NavGraphs.root,
                startRoute = NavGraphs.root.startRoute
            )
        }
    }
}

@Preview
@Composable
fun PreviewMainActivity() {
    MainScreen()
}