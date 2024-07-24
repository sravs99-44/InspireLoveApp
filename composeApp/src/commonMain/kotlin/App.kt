import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import navigation.NavController
import navigation.Screen
import presentation.InfoScreen
import presentation.QuoteScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            val navController = remember { NavController(Screen.QuoteScreen) }
            val currentScreen by navController.currentScreen.collectAsState()

           QuoteScreen(visible = currentScreen == Screen.QuoteScreen, navController = navController)
           InfoScreen(visible = currentScreen == Screen.InfoScreen, navController = navController)
        }
    }
}