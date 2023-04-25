package com.example.socialmedia.android.auth.Login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    var uiState by mutableStateOf(LoginUiState())

        private  set

    fun updateUserEmail(input: String){
        uiState = uiState.copy(email = input)
    }
    fun updateUserPassword(input: String){
        uiState = uiState.copy(password = input)
    }

}

data class  LoginUiState(
    var email: String = "",
    var password: String = ""
)