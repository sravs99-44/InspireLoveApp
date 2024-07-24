package navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NavController(initialScreen: Screen) {

    // val currentScreen
    private val _currentScreen = MutableStateFlow(initialScreen)
    val currentScreen = _currentScreen.asStateFlow()

    // val backStack
    private val backStack: MutableList<Screen> = mutableListOf()

    //fun navigateTo
    fun navigateTo(screen: Screen) {
        backStack.add(_currentScreen.value)
        _currentScreen.update { screen }
    }

    //fun navigateBack
    fun navigateBack(){
        if(backStack.isNotEmpty()) {
            _currentScreen.update { backStack.last() }
            backStack.removeLast()
        }
    }

}