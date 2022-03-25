package com.strive.xwanandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.strive.xwanandroid.ui.discover.DiscoverPage
import com.strive.xwanandroid.ui.home.HomePage
import com.strive.xwanandroid.ui.home.HomeViewModel
import com.strive.xwanandroid.ui.my.MyPage
import com.strive.xwanandroid.ui.navigation.WanBottomNavItems
import com.strive.xwanandroid.ui.square.SquarePage
import com.strive.xwanandroid.ui.theme.StriveTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StriveTheme {
                MainPage()
            }
        }
    }

    @Composable
    private fun MainPage() {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                val array = arrayOf(
                    WanBottomNavItems.HomeItem,
                    WanBottomNavItems.SquareItem,
                    WanBottomNavItems.DiscoverItem,
                    WanBottomNavItems.MyItem
                )
                MainBottomNavigation(array, navController)
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = WanBottomNavItems.HomeItem.route,
                modifier = Modifier.padding(it)
            ) {
                composable(WanBottomNavItems.HomeItem.route) {
                    HomePage(homeViewModel)
                }
                composable(WanBottomNavItems.SquareItem.route) {
                    DiscoverPage()
                }
                composable(WanBottomNavItems.DiscoverItem.route) {
                    SquarePage()
                }
                composable(WanBottomNavItems.MyItem.route) {
                    MyPage()
                }
            }
        }
    }

    @Composable
    private fun MainBottomNavigation(
        items: Array<WanBottomNavItems>,
        navController: NavController
    ) {
        BottomNavigation(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = StriveTheme.colors.background
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach {
                BottomNavigationItem(
                    selected = currentRoute == it.route,
                    selectedContentColor = StriveTheme.colorPalette.Google,
                    unselectedContentColor = Color.Black.copy(0.4f),
                    onClick = {
                        if (it.route != currentRoute) {
                            navController.navigate(it.route) {
                                launchSingleTop = true
                                restoreState = true
                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route = route) {
                                        saveState = true
                                    }
                                }

                            }
                        }
                    },
                    icon = it.icon,
                    label = { Text(text = stringResource(id = it.label)) }
                )
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        StriveTheme {
            MainPage()
        }
    }
}