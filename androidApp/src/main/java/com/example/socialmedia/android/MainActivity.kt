package com.example.socialmedia.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.socialmedia.Greeting
import com.example.socialmedia.android.auth.Login.LoginScreen
import com.example.socialmedia.android.auth.Login.LoginUiState
import com.example.socialmedia.android.auth.signup.SignupScreens
import com.example.socialmedia.android.auth.signup.SignupUiState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = if (isSystemInDarkTheme()) {
                        MaterialTheme.colors.background
                    } else {
                        MaterialTheme.colors.surface
                    }
                ) {
                    LoginScreen(
                        uiState = LoginUiState(),
                        onEmailChange = {},
                        onPasswordChange = {},
                    )
                }
            }
        }
    }
}




