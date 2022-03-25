package com.strive.xwanandroid.ui.my

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.ProvideWindowInsets
import com.strive.xwanandroid.R
import com.strive.xwanandroid.ui.theme.StriveTheme

/**
 * @author strivexing
 * @date 2022/3/22 22:20
 * @description
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyPage() {
    ProvideWindowInsets {
        Scaffold(topBar = {
            TopAppBar(title = { Text(text = "我的") })
        }, content = {
            Column(
                modifier = Modifier
                    .background(StriveTheme.colors.neutralContrastLow)
                    .fillMaxSize()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .background(StriveTheme.colors.background)
                        .height(100.dp)
                        .padding(20.dp)
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(id = R.drawable.ic_launcher),
                        contentDescription = "",
                        modifier = Modifier.size(60.dp)
                    )
                    Column(modifier = Modifier.padding(start = 8.dp)) {
                        Text(
                            text = "街道书记",
                            style = StriveTheme.typography.textCopy,
                            color = StriveTheme.colors.foreground
                        )
                        Text(
                            text = "邮箱", style = StriveTheme.typography.textSmall,
                            color = StriveTheme.colors.foreground,
                            modifier = Modifier.padding(start = 2.dp)
                        )
                    }
                }
                ListItem(
                    text = { Text(text = "我的消息") }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .background(StriveTheme.colors.background)
                )
                ListItem(
                    text = { Text(text = "我的收藏") }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 1.dp)
                        .background(StriveTheme.colors.background)
                )
                ListItem(
                    text = { Text(text = "我的积分") }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 1.dp)
                        .background(StriveTheme.colors.background)
                )
                ListItem(
                    text = { Text(text = "实用工具") }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 1.dp)
                        .background(StriveTheme.colors.background)
                )

                ListItem(
                    text = { Text(text = "设置") }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                        .background(StriveTheme.colors.background)
                )
            }
        })
    }

}

@Composable
fun DetailListItem(
    modifier: Modifier = Modifier,
    primaryText: String,
    secondaryText: String? = null,
    trailingText: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(end = 16.dp)
                .weight(1f)
        ) {
            Text(text = primaryText)
        }
    }
}

@Preview
@Composable
@ExperimentalMaterialApi
fun DefaultPreview() {
    StriveTheme {
        MyPage()
    }
}