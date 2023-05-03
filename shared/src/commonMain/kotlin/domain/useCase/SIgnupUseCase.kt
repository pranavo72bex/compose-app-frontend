package domain.useCase

import domain.model.AuthResultData
import domain.repository.AuthRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import com.example.common.util.Result

class SignupUseCase : KoinComponent {

    private val repository: AuthRepository by inject()

    suspend operator fun invoke(
        email: String,
        name: String,
        password: String
    ): Result<AuthResultData>{
        if(name.isBlank()|| name.length<3){
            return Result.Error(
                message = "Invalid name"
            )
        }
        if(email.isBlank()|| "@" !in email){
            return Result.Error(
                message = "Invalid email"
            )
        }
        if(password.isBlank()|| password.length<4) {
            return Result.Error(
                message = "invalid password or too short"
            )

        }
        return repository.signUp(name, email, password)
    }

}