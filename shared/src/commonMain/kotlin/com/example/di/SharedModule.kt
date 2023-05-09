package com.example.di
import com.example.Auth.data.AuthService
import com.example.common.util.provideDispatcher
import com.example.domain.repository.AuthRepository
import com.example.domain.repository.AuthRepositoryImpl
import com.example.domain.useCase.SignInUseCase
import com.example.domain.useCase.SignupUseCase
import org.koin.dsl.module
private val authModule = module{
    single<AuthRepository> { AuthRepositoryImpl(get(),get()) }
    factory { AuthService() }
    factory { SignupUseCase() }
    factory { SignInUseCase() }

}

private val utilityModule = module {
    factory { provideDispatcher() }
}

fun getShareModules() = listOf(authModule, utilityModule)