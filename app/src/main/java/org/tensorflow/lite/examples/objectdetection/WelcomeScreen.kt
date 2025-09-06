package org.tensorflow.lite.examples.objectdetection

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.tensorflow.lite.examples.objectdetection.components.CButton
import org.tensorflow.lite.examples.objectdetection.components.DontHaveAccountRow
import org.tensorflow.lite.examples.objectdetection.components.GoogleSignInButton
import org.tensorflow.lite.examples.objectdetection.theme.AlegreyaFontFamily
import org.tensorflow.lite.examples.objectdetection.theme.AlegreyaSansFontFamily

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit,
    onSignupClick: () -> Unit,
    onmenulick: () -> Unit,
    onProfileClick: () -> Unit,
    onLibClick: () -> Unit
) {
    val context = LocalContext.current

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.tas_menu),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .width(320.dp)
                    .height(240.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                "WELCOME",
                fontSize = 32.sp,
                fontFamily = AlegreyaFontFamily,
                fontWeight = FontWeight(700),
                color = Color.White
            )

            Text(
                "State of the Art offline Fungi Detection App\n",
                textAlign = TextAlign.Center,
                fontFamily = AlegreyaSansFontFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight(500),
                color = Color.White
            )

            Spacer(modifier = Modifier.weight(1f))

            // Google sign-in button
            GoogleSignInButton(
                onClick = {
                    val activity = context as? LoginActivity
                    activity?.signInWithGoogle()
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            // Email sign in
            CButton(
                text = "Sign In With Email",
               // onClick = onLoginClick
                onClick =  onmenulick
            )

            // Signup
            DontHaveAccountRow(
                onSignupTap = onSignupClick
            )
        }
    }
}


@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(
        onLoginClick = {  },
        onSignupClick = { /* navigate to signup Compose screen */ },
        onmenulick = { },
        onProfileClick = { },
        onLibClick = { })
}

