package domain.repository

import com.example.Auth.data.AuthService
import com.example.Auth.data.SignInRequest
import com.example.Auth.data.SignUpRequest
import com.example.Auth.data.toAuthResultData
import domain.model.AuthResultData
import com.example.common.util.DispatcherProvider
import com.example.common.util.Result
import kotlinx.coroutines.withContext

internal class AuthRepositoryImpl(
    private val dispatcher: DispatcherProvider,
    private val authService: AuthService
) : AuthRepository {
    override suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): Result<AuthResultData> {
        return withContext(dispatcher.io){
            try {
                val request = SignUpRequest(name, email, password)

                val authResponse = authService.signUp(request)

                if(authResponse.data ==null){
                    Result.Error(
                        message = authResponse.errorMessage!!
                    )
                }else{
                    Result.Success(
                        data = authResponse.data.toAuthResultData()
                    )
                }
            } catch (e: Exception){
                Result.Error(
                    message = "oops, Fail to signup"
                )
            }
        }
    }

    override suspend fun signIn(email: String, password: String): Result<AuthResultData> {
       return withContext(dispatcher.io){
        try {
            val request = SignInRequest(email, password)

            val authResponse = authService.signIn(request)

            if(authResponse.data ==null){
                Result.Error(
                    message = authResponse.errorMessage!!
                )
            }else{
                Result.Success(
                    data = authResponse.data.toAuthResultData()
                )
            }
        }catch (e: Exception){
            Result.Error(
                message = "oops, Fail to signIn"
            )
        }
       }
    }
}