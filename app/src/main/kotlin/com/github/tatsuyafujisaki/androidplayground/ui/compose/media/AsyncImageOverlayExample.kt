package com.github.tatsuyafujisaki.androidplayground.ui.compose.media

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.github.tatsuyafujisaki.androidplayground.R

@Preview
@Composable
private fun AsyncImageOverlayExample() {
    Box(modifier = Modifier.size(size = 200.dp)) {
        AsyncImage(
            model = "https://www.gstatic.com/webp/gallery/4.webp",
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
        Image(
            painter = painterResource(id = R.drawable.solid_yellow),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            alpha = 0.5f,
        )
    }
}
