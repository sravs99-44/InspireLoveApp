package presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import inspirelove.composeapp.generated.resources.Res
import inspirelove.composeapp.generated.resources.baseline_info_24
import inspirelove.composeapp.generated.resources.inspire_love_app_icon_heart
import inspirelove.composeapp.generated.resources.quote_background
import navigation.NavController
import navigation.Screen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun QuoteScreen(
    navController: NavController,
    visible: Boolean,
) {
    val txt = remember { mutableStateListOf<String>() }
    val txtIndex = remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        txt.clear()
        Res.readBytes("files/quotes.txt").decodeToString().lines().forEach {
            txt.add(it.replace("”", "").replace(",", "").replace("\"", ""))
        }
    }

    if (visible) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.quote_background),
                contentDescription = "Background Image",
                contentScale = ContentScale.FillBounds
            )
            Row(
                modifier = Modifier.fillMaxWidth().background(Color(0xFFCDE5FF)).padding(10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(modifier = Modifier.height(30.dp), painter = painterResource(Res.drawable.inspire_love_app_icon_heart), contentDescription = null)
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    "Inspire Love",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton( onClick = { navController.navigateTo(Screen.InfoScreen) }) {
                    Image(
                        painter = painterResource(Res.drawable.baseline_info_24),
                        contentDescription = "Info"
                    )
                }
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = if (txt.isNotEmpty()) txt[txtIndex.value] else "Loading...",
                    modifier = Modifier.padding(10.dp)
                        .clickable(
                            onClick = {
                                txtIndex.value = txt.indexOf(txt.random())
                            },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }

                        ),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

            }

        }
    }
}


