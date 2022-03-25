package com.strive.xwanandroid.ui.home

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.strive.xwanandroid.R
import com.strive.xwanandroid.service.data.dto.ArticleResultDto
import com.strive.xwanandroid.service.data.dto.HomeBannerResultDto
import com.strive.xwanandroid.ui.theme.StriveTheme
import com.strive.xwanandroid.ui.widgets.StriveTag
import kotlinx.coroutines.launch

/**
 * @author strivexing
 * @date 2022/3/22 22:20
 * @description
 */
@Composable
fun HomePage(
    viewModel: HomeViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .height(32.dp)
                    .background(Color.Gray.copy(alpha = 0.2f), shape = RoundedCornerShape(5.dp))
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search",
                    modifier = Modifier.padding(start = 6.dp)
                )
                Text(text = "搜索你的最爱", modifier = Modifier.padding(start = 8.dp))
            }
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "add",
                modifier = Modifier
                    .padding(start = 12.dp, end = 20.dp)
                    .clickable {
                        viewModel.fetchHomeAllData()
                    }
            )
        }
        val viewState = viewModel.viewState.collectAsState(initial = HomePageViewState.Default)
        when (viewState.value) {
            HomePageViewState.Default -> {}
            is HomePageViewState.ShowHomeAndData -> {
                val articleList =
                    (viewState.value as HomePageViewState.ShowHomeAndData).homeAllDataInfo.homeHotArticleList
                val mutableList: MutableList<ArticleResultDto> = mutableListOf()
                mutableList.addAll((viewState.value as HomePageViewState.ShowHomeAndData).homeAllDataInfo.homeTopArticleList)
                mutableList.addAll(articleList)
                HomeBanner((viewState.value as HomePageViewState.ShowHomeAndData).homeAllDataInfo.bannerList)
                HomeArticleList(mutableList)
            }
        }
    }
}

@Composable
private fun HomeBanner(bannerList: List<HomeBannerResultDto>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .height(120.dp)
    ) {
        items(bannerList) {
            AsyncImage(model = it.imagePath, contentDescription = it.desc)
        }
    }
}

@Composable
private fun HomeArticleList(articleList: List<ArticleResultDto>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(articleList) {
            ArticleItem(it)
        }
    }
}

@Composable
private fun ArticleItem(articleInfo: ArticleResultDto) {
    val rememberScaffoldState = rememberScaffoldState()
    val coroutine = rememberCoroutineScope()
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                val intentCustomTabs = CustomTabsIntent
                    .Builder()
                    .build()
                intentCustomTabs.launchUrl(context, Uri.parse(articleInfo.link))
            }
    ) {
        Column(
            modifier = Modifier.padding(
                start = 20.dp,
                end = 20.dp,
                top = 16.dp,
                bottom = 16.dp
            )
        ) {
            Row {
                if (articleInfo.isTop) StriveTag(title = stringResource(id = R.string.top))
                if (articleInfo.fresh) StriveTag(
                    modifier = Modifier.padding(start = 6.dp),
                    title = stringResource(id = R.string.fresh)
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Filled.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = StriveTheme.colors.striveRed
                )
            }
            Text(
                text = articleInfo.title,
                style = StriveTheme.typography.headline3,
                color = StriveTheme.colors.foreground,
                modifier = Modifier.padding(top = 4.dp)
            )
            Row(
                modifier = Modifier.padding(top = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = articleInfo.superChapterName,
                    style = StriveTheme.typography.textMedium,
                    color = StriveTheme.colorPalette.Google,
                    modifier = Modifier.clickable {
                        coroutine.launch {
                            rememberScaffoldState.snackbarHostState.showSnackbar(articleInfo.superChapterName)
                        }
                    }
                )
                Text(
                    text = " | ", style = StriveTheme.typography.textMedium,
                    color = StriveTheme.colorPalette.Google
                )
                Text(
                    text = articleInfo.chapterName,
                    style = StriveTheme.typography.textMedium,
                    color = StriveTheme.colorPalette.Google,
                    modifier = Modifier.clickable {
                        coroutine.launch {
                            rememberScaffoldState.snackbarHostState.showSnackbar(articleInfo.superChapterName)
                        }
                    }
                )
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )
                if (articleInfo.tags?.isNotEmpty() == true) {
                    LazyRow(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        items(articleInfo.tags) {
                            Spacer(modifier = Modifier.width(6.dp))
                            StriveTag(
                                title = it.name,
                                color = StriveTheme.colors.notificationSuccess
                            )
                        }
                    }
                }
            }
            Row(modifier = Modifier.padding(top = 6.dp)) {
                Text(
                    text = articleInfo.getUserName(),
                    style = StriveTheme.typography.textMedium
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = articleInfo.niceShareDate,
                    style = StriveTheme.typography.textMedium,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(StriveTheme.colors.neutralContrastLow)
        )
    }
}

fun ArticleResultDto.getUserName(): String = if (this.shareUser.isNotEmpty()) {
    "分享人:${this.shareUser}"
} else "作者:${this.author}"

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    HomePage(viewModel())
}