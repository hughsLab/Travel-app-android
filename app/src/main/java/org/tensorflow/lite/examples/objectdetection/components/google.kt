package org.tensorflow.lite.examples.objectdetection.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.tensorflow.lite.examples.objectdetection.R

@Composable
fun GoogleSignInButton(onClick: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.android_dark_rd_ctn_4x),
        contentDescription = "Sign in with Google",
        modifier = Modifier
            .height(48.dp)
            .wrapContentWidth()
            .clickable { onClick() },
        contentScale = ContentScale.FillHeight
    )
}


