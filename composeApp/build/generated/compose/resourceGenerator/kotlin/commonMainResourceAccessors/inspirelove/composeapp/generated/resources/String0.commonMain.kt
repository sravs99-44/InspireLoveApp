@file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)

package inspirelove.composeapp.generated.resources

import kotlin.OptIn
import org.jetbrains.compose.resources.StringResource

private object CommonMainString0 {
  public val info_text: StringResource by 
      lazy { init_info_text() }
}

internal val Res.string.info_text: StringResource
  get() = CommonMainString0.info_text

private fun init_info_text(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:info_text", "info_text",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/inspirelove.composeapp.generated.resources/values/strings.commonMain.cvr", 10,
    853),
    )
)
