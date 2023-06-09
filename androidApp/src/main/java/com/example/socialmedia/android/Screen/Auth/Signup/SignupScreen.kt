package com.example.socialmedia.android.Screen.Auth.Signup

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.socialmedia.android.R
import com.example.socialmedia.android.auth.signup.SignupUiState
import com.example.socialmedia.android.common.CustomTextField
import com.example.socialmedia.android.ui.screens.uii.ButtonHeight
import com.example.socialmedia.android.ui.screens.uii.ExtraLargeSpacing
import com.example.socialmedia.android.ui.screens.uii.LargeSpacing
import com.example.socialmedia.android.ui.screens.uii.MediumSpacing

@Composable
fun  SignupScreens(
    modifier: Modifier=Modifier,
    uiState: SignupUiState,
    onUsernameChange:(String)->Unit,
    onEmailChange:(String)-> Unit,
    onPasswordChange:(String) -> Unit,
    onNavigateToLogin:() -> Unit,
    onNavigateToHome:()-> Unit,
    onSignUpClick:() ->Unit,
){
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    top = ExtraLargeSpacing + LargeSpacing,
                    start = LargeSpacing + MediumSpacing,
                    end = LargeSpacing + MediumSpacing,
                    bottom = LargeSpacing
                )
                .background(
                    color = if (isSystemInDarkTheme()) {
                        MaterialTheme.colors.background
                    } else {
                        MaterialTheme.colors.surface
                    }
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(LargeSpacing)
        ) {
            CustomTextField(
                value = uiState.username,
                onValueChange = onUsernameChange,
                hint = R.string.username_hint
            )
            CustomTextField(
                value = uiState.email,
                onValueChange = onEmailChange,
                hint = R.string.email_hint,
                keyboardType = KeyboardType.Email
            )
            CustomTextField(
                value = uiState.password,
                onValueChange = onPasswordChange,
                hint = R.string.password_hint,
                keyboardType = KeyboardType.Password,
                isPasswordTextField = true
            )
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .height(ButtonHeight),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp
                ),
                shape = MaterialTheme.shapes.medium,
                onClick = {
                   onSignUpClick()
                }
            ) {
                Text(text = stringResource(id = R.string.signup_button_hint))
            }
        }
        if (uiState.isAuthenticating){
            CircularProgressIndicator()
        }

    }
    LaunchedEffect(
        key1 = uiState.authenticationSucceed,
        key2 = uiState.authError,
        block = {
            if(uiState.authenticationSucceed){
                onNavigateToHome()
            }
            if (uiState.authError != null){
             Toast.makeText(context,uiState.authError, Toast.LENGTH_SHORT).show()
            }

    }

    )
}

