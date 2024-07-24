package navigation

sealed interface Screen {
    data object QuoteScreen : Screen
    data object InfoScreen : Screen
}