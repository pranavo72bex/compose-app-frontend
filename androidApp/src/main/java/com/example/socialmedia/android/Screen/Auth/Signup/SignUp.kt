package com.example.socialmedia.android.Screen.Auth.Signup

import androidx.compose.runtime.Composable
import com.example.socialmedia.android.Screen.destinations.HomeScreenDestination
import com.example.socialmedia.android.Screen.destinations.LoginDestination
import com.example.socialmedia.android.auth.signup.SignUpViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Destination
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
             navigator.navigate(HomeScreenDestination){
                 popUpTo(0)
             }
        },
        onSignUpClick = viewModel::signUp

    )
}