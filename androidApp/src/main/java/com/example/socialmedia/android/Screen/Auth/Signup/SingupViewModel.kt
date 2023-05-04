package com.example.socialmedia.android.auth.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.useCase.SignupUseCase
import kotlinx.coroutines.launch
import com.example.common.util.Result

class SignUpViewModel(
    private val signupUseCase: SignupUseCase
): ViewModel() {
    var uiState by mutableStateOf(SignupUiState())

    private  set


    fun signUp(){
        viewModelScope.launch {
            uiState = uiState.copy(isAuthenticating = true)

            val authResultData = signupUseCase(uiState.email,uiState.username,uiState.password)

            uiState = when(authResultData){
                is Result.Error -> {
                    uiState.copy(
                        isAuthenticating = false,
                        authError = authResultData.message
                    )
                }
                is Result.Success ->{
                    uiState.copy(
                        isAuthenticating = false,
                        authenticationSucceed = true
                    )
                }
            }

        }
    }

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
    var password: String = "",
    var isAuthenticating: Boolean = false,
    var authError: String? = null,
    var authenticationSucceed: Boolean= false,
)