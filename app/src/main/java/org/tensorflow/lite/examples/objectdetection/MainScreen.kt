package org.tensorflow.lite.examples.objectdetection

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.platform.LocalContext
import org.tensorflow.lite.examples.objectdetection.components.CButton
import org.tensorflow.lite.examples.objectdetection.components.DontHaveAccountRow
import org.tensorflow.lite.examples.objectdetection.theme.AlegreyaFontFamily
import org.tensorflow.lite.examples.objectdetection.theme.AlegreyaSansFontFamily
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current
    var searchQuery by remember { mutableStateOf("") }
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

            // 🔍 Search Box (fixed at the top)
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = {
                    Text(
                        "Search for Fungi",
                        color = Color.White.copy(alpha = 0.7f)
                    )
                },
                singleLine = true,
                textStyle = TextStyle(color = Color.White), // makes user input white
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search, // built-in search icon
                        contentDescription = "Search",
                        tint = Color.White
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF253334)), // background color
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )


            Spacer(modifier = Modifier.weight(3f))


            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .width(320.dp)
                    .height(240.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                "Main Menu",
                fontSize = 32.sp,
                fontFamily = AlegreyaFontFamily,
                fontWeight = FontWeight(700),
                color = Color.White
            )

            Text(
                "Explore, Review & Detect\n.",
                textAlign = TextAlign.Center,
                fontFamily = AlegreyaSansFontFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight(500),
                color = Color.White
            )

            Spacer(modifier = Modifier.weight(1f))

            val context = LocalContext.current

            CButton(
                text = "Launch Camera",
                onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }
            )

            DontHaveAccountRow(
                onSignupTap = {
                    navController.navigate("signup")
                }
            )

            Spacer(modifier = Modifier.height(80.dp)) // leave space for bottom bar
        }

        // Bottom Navigation Bar
        // Bottom Navigation Bar
        BottomBar(
            onLibraryClick = { navController.navigate("library") },
            onCameraClick = {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            },
            onProfileClick = { navController.navigate("profile") },
            modifier = Modifier.align(Alignment.BottomCenter)


        )
    }
}

@Composable
fun BottomBar(
    onLibraryClick: () -> Unit,
    onCameraClick: () -> Unit,
    onProfileClick: () -> Unit,

    modifier: Modifier = Modifier
) {
    Surface(
        color = Color(0xFF253334),
        shadowElevation = 8.dp,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Library Button
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { onLibraryClick() }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lib), // <-- add your icon
                    contentDescription = "Library",
                    modifier = Modifier.size(28.dp)
                )
                Text("Library", color = Color.White, fontSize = 12.sp)
            }

            // Central Camera Button (larger, circular)
            Box(

            ) {
                Image(
                    painter = painterResource(id = R.drawable.cam), // <-- add your icon
                    contentDescription = "Camera",
                    modifier = Modifier.size(32.dp)
                )

            }

            // Profile Button
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { onProfileClick() }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile), // <-- add your icon
                    contentDescription = "Profile",
                    modifier = Modifier.size(28.dp)
                )
                Text("Profile", color = Color.White, fontSize = 12.sp)
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun MainScreenPreview() {
    MainScreen(rememberNavController())
}
