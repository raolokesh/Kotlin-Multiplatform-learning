package com.jetbrains.kmpapp.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jetbrains.kmpapp.components.AppButton
import com.jetbrains.kmpapp.components.AppInputText


@Composable
fun LoginScreen(
    onSignUpClick: () -> Unit,
    onForgotClick: () -> Unit,
    onLoginButton: () -> Unit,
) {

    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf<String?>(null) }

    var password by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf<String?>(null) }

    Scaffold { innerPadding ->

//        BaseScreen(viewModel, modifier = Modifier.padding(innerPadding)) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center, modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Text(
                    text = "Login Screen",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineMedium
                )

                AppInputText(
                    label = "Username",
                    text = email,
                    placeholder = "Enter Username",
                    onValueChange = { text ->
                        email = text
                        emailError = if (text.length > 5) "Email is required" else null
                    },
                    error = emailError,
                    leadingIcon = Icons.Default.Person,
                    modifier = Modifier
                )

                AppInputText(
                    label = "Password",
                    text = password,
                    placeholder = "Enter Password",
                    onValueChange = { text ->
                        password = text
                        passwordError =
                            if (text.length > 10) "Password is required" else null

                    },
                    error = passwordError,
                    leadingIcon = Icons.Default.Person,
                    modifier = Modifier
                        .fillMaxWidth()

                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                AppButton(
                    onClick = { onLoginButton() },
                    text = "Login Button",
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                AppButton(
                    onClick = { onForgotClick() },
                    text = "Forgot Password",
                    modifier = Modifier
                        .fillMaxWidth()

                )


            }
        }

//        }
    }
}


//@Preview
//@Composable
//private fun LoginScreenPreview() {
//    LoginScreen(
//        onSignUpClick = {},
//        onForgotClick = {},
//        onLoginButton = {}
//    )
//}


