package presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import inspirelove.composeapp.generated.resources.Res
import inspirelove.composeapp.generated.resources.earth_globe_1024
import inspirelove.composeapp.generated.resources.ic_arrow_back
import inspirelove.composeapp.generated.resources.info_text
import inspirelove.composeapp.generated.resources.inspire_love_app_icon_heart
import inspirelove.composeapp.generated.resources.quote_background
import navigation.NavController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun InfoScreen(
    navController: NavController,
    visible: Boolean
) {
    val uriHandler = LocalUriHandler.current
    if (visible) {
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color(0xFFCDE5FF)
                ) {
                    IconButton(onClick = { navController.navigateBack() }) {
                        Image(
                            painter = painterResource(Res.drawable.ic_arrow_back),
                            contentDescription = "Favorite"
                        )
                    }
                    Spacer(Modifier.width(15.dp))
                    Image(modifier = Modifier.height(25.dp), painter = painterResource(Res.drawable.inspire_love_app_icon_heart), contentDescription = null)
                    Spacer(Modifier.width(5.dp))
                    Text(
                        "About Us",
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                }
            }
        )
        {
            Column(
                modifier = Modifier.fillMaxSize()
                    .background(Color(0xFFCDE5FF))
                    .verticalScroll(rememberScrollState())
                    .padding(top = 24.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(modifier = Modifier.height(150.dp), painter = painterResource(Res.drawable.earth_globe_1024), contentDescription = "globe")
                Text(
                    stringResource(Res.string.info_text),
                    modifier = Modifier.padding(horizontal = 24.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Left
                )
                Text(
                    "Love Foundation",
                    modifier = Modifier.padding(24.dp).clickable {
                        uriHandler.openUri("https://www.thelovefoundation.com/")
                    },
                    color = Color.Blue,
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.Underline,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Left
                )
                Spacer(modifier = Modifier.height(20.dp))
            }

        }
    }
}

