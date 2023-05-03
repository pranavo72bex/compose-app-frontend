package com.example.di
import com.example.Auth.data.AuthService
import com.example.common.util.provideDispatcher
import domain.repository.AuthRepositoryImpl
import domain.useCase.SignInUseCase
import domain.useCase.SignupUseCase
import org.koin.dsl.module
private val authModule = module{
    single { AuthRepositoryImpl(get(),get()) }
    factory { AuthService() }
    factory { SignupUseCase() }
    factory { SignInUseCase() }

}

private val utilityModule = module {
    factory { provideDispatcher() }
}

fun getShareModules() = listOf(authModule, utilityModule)