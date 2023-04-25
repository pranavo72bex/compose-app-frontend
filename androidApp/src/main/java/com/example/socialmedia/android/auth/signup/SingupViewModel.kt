package com.example.socialmedia.android.auth.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SingupViewModel: ViewModel() {
    var uiState by mutableStateOf(SignupUiState())

    private  set

    fun updateUserName(input: String){
        uiState = uiState.copy(username = input)
    }
    fun updateUserEmail(input: String){
        uiState = uiState.copy(email = input)
    }
    fun updateUserPassword(input: String){
        uiState = uiState.copy(password = input)
    }

 }

data class  SignupUiState(
    var username: String = "",
    var email: String = "",
    var password: String = ""
)