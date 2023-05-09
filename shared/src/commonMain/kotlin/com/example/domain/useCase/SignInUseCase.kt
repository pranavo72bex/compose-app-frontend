package com.example.domain.useCase

import com.example.domain.model.AuthResultData
import com.example.domain.repository.AuthRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import com.example.common.util.Result

class SignInUseCase: KoinComponent {

    private val repository: AuthRepository by inject()

    suspend operator fun invoke(
        email: String,
        password: String
    ) : Result<AuthResultData>{
        if(email.isBlank()|| "@" !in email){
            return com.example.common.util.Result.Error(
                message = "Invalid email"
            )
        }
        if(password.isBlank()|| password.length<4) {
            return com.example.common.util.Result.Error(
                message = "invalid password or too short"
            )

        }
        return repository.signIn( email, password)
    }

}