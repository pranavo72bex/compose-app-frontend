package com.example.socialmedia.android.Screen.Auth.Login

import androidx.compose.runtime.Composable
import com.example.socialmedia.android.auth.Login.LoginScreen
import com.example.socialmedia.android.auth.Login.LoginViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Destination
@Composable
fun Login(
    navigator: DestinationsNavigator
){
    val viewModel: LoginViewModel = koinViewModel()
    LoginScreen(
        uiState = viewModel.uiState,
        onEmailChange = viewModel::updateUserEmail,
        onPasswordChange = viewModel::updateUserPassword
    )
}