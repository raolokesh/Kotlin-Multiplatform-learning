package com.jetbrains.kmpapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType


@Composable
fun AppInputText(
    label: String,
    text: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    error: String? = null,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    onImeAction: () -> Unit = {}
) {


    OutlinedTextField(
        value = text,
        label = { Text(label) },
        onValueChange = onValueChange,
        placeholder = { Text(placeholder) },
        singleLine = true,
        isError = error != null,
//        keyboardOptions = KeyboardOptions.Default.copy(
//            keyboardType = keyboardType,
//            imeAction = imeAction
//        ),
//        keyboardActions = KeyboardActions(
//            onDone = {
//                onImeAction()
//            }
//        ),
        leadingIcon = if (leadingIcon != null) {
            val leadingIcon: @Composable () -> Unit = {
                Icon(leadingIcon, null)
            }
            leadingIcon
        } else {
            null
        },

        modifier = modifier.fillMaxWidth(),
    )

}
