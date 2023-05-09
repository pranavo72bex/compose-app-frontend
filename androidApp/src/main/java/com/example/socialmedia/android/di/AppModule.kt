package com.example.socialmedia.android.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.socialmedia.android.auth.Login.LoginViewModel
import com.example.socialmedia.android.auth.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {LoginViewModel()}
    viewModel { SignUpViewModel(get()) }
}