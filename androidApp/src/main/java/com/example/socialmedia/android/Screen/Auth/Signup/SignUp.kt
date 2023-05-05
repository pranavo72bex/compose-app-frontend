package com.example.socialmedia.android.Screen.Auth.Signup

import androidx.compose.runtime.Composable
import com.example.socialmedia.android.Screen.Auth.destinations.LoginDestination
import com.example.socialmedia.android.auth.signup.SignUpViewModel
import com.example.socialmedia.android.auth.signup.SignupScreens
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Destination(start = true)
@Composable
fun  SignUp(
    navigator: DestinationsNavigator
){
    val viewModel: SignUpViewModel = koinViewModel()
    SignupScreens(
        uiState = viewModel.uiState,
        onUsernameChange = viewModel::updateUserName,
        onEmailChange = viewModel::updateUserEmail,
        onPasswordChange =viewModel::updateUserPassword,
        onNavigateToLogin = {
            navigator.navigate(LoginDestination)
        },
        onNavigateToHome = {

        },
        onSignUpClick = viewModel::signUp

    )
}