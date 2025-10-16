package com.jetbrains.kmpapp.screens.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedSecureTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jetbrains.kmpapp.components.AppButton


@Composable
fun DashboardScreen(
    onClickNextScreen: (id: Int) -> Unit,
) {

    var textInput by remember { mutableStateOf("Lokesh") }

    var textError by remember { mutableStateOf<String?>(null) }

    var passwordInput by remember { mutableStateOf<String>("") }

    var passwordError by remember { mutableStateOf<String?>(null) }

    var isPassword by remember { mutableStateOf(true) }

    var passwordState by remember { mutableStateOf(TextFieldState()) }

    var passwordVisible by remember { mutableStateOf(false) }

//    BaseScreen(viewModel = viewModel) { uiState ->
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Dashboard Screen",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.padding(10.dp))
            AppButton(
                onClick = { },
                text = "Load Dashboard"
            )

            Spacer(modifier = Modifier.padding(10.dp))
            AppButton(
                onClick = { onClickNextScreen(100) },
                text = "Next Screen"
            )
            Spacer(modifier = Modifier.padding(10.dp))

            OutlinedTextField(
                value = textInput,
                label = { Text("Enter value") },
                placeholder = { Text("Enter value") },
                onValueChange = { textInput = it },
                enabled = true,
                //readOnly = true,  // in this we can enable or disable the text field
//                    singleLine = true, // in this we can enable or disable the single line text field
                maxLines = 10,
                minLines = 1,
                isError = textError != null,
                supportingText = {
                    if (textError != null) {
                        Text(textError!!)
                    }
                },
// show or hide text like as password
//                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)

            )

            AppButton(
                onClick = { textError = "Username is not correct" },
                text = "Load Error"
            )
            Spacer(modifier = Modifier.padding(10.dp))





            OutlinedSecureTextField(
                state = passwordState,
                label = { Text("Password") },
                placeholder = { Text("Password") },
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                isError = passwordError != null,
                supportingText = {
                    if (passwordError != null) {
                        Text(passwordError!!)
                    }
                },
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Check
                    else Icons.Filled.CheckCircle
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description)
                    }
                },
                textObfuscationMode = if (passwordVisible) TextObfuscationMode.Visible else TextObfuscationMode.RevealLastTyped,

                )



            AppButton(
                onClick = { passwordError = "Password is not correct" },
                text = passwordState.text.toString()
            )
            Spacer(modifier = Modifier.padding(10.dp))

//            }

//        CircularProgressIndicator(
//            modifier = Modifier.align(Alignment.Center)
//        )
        }
    }
}



