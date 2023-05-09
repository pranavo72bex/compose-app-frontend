package com.example.socialmedia.android.auth.Login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.useCase.SignInUseCase
import com.example.common.util.Result
import kotlinx.coroutines.launch

class LoginViewModel(
    private val signInUseCase: SignInUseCase
): ViewModel() {
    var uiState by mutableStateOf(LoginUiState())

        private  set

     fun signIn(){
     viewModelScope.launch {
         uiState = uiState.copy(isAuthenticating = true)

         val authResultData = signInUseCase(uiState.email, uiState.password)

         uiState = when(authResultData){
             is Result.Error -> {
                 uiState.copy(
                     isAuthenticating = false,
                     authError = authResultData.message
                 )
             }
             is Result.Success -> {
                 uiState.copy(
                     isAuthenticating = false,
                     authenticationSucceed = true
                 )
             }
         }
     }
    }


    fun updateUserEmail(input: String){
        uiState = uiState.copy(email = input)
    }
    fun updateUserPassword(input: String){
        uiState = uiState.copy(password = input)
    }

}

data class  LoginUiState(
    var email: String = "",
    var password: String = "",
    var isAuthenticating: Boolean = false,
    var authError: String? = null,
    var authenticationSucceed: Boolean= false
)