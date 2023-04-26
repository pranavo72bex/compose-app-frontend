package com.example.socialmedia.android.auth.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.socialmedia.android.R
import com.example.socialmedia.android.SocialAppTheme
import com.example.socialmedia.android.common.CustomTextField
import com.example.socialmedia.android.ui.screens.uii.ButtonHeight
import com.example.socialmedia.android.ui.screens.uii.ExtraLargeSpacing
import com.example.socialmedia.android.ui.screens.uii.LargeSpacing
import com.example.socialmedia.android.ui.screens.uii.MediumSpacing

@Composable
fun  SignupScreens(
    modifier: Modifier=Modifier,
    uiState: SignupUiState,
    onUsernameChange:(String)->Unit,
    onEmailChange:(String)-> Unit,
    onPasswordChange:(String) -> Unit,
    onNavigateToLogin:() -> Unit
){
  Column(
      modifier = modifier
          .fillMaxSize()
          .verticalScroll(rememberScrollState())
          .padding(
              top = ExtraLargeSpacing + LargeSpacing,
              start = LargeSpacing + MediumSpacing,
              end = LargeSpacing + MediumSpacing,
              bottom = LargeSpacing
          )
          .background(
              color = if (isSystemInDarkTheme()) {
                  MaterialTheme.colors.background
              } else {
                  MaterialTheme.colors.surface
              }
          ),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.spacedBy(LargeSpacing)
  ) {
      CustomTextField(
          value = uiState.username,
          onValueChange = onUsernameChange,
          hint = R.string.username_hint
      )
      CustomTextField(
          value = uiState.email,
          onValueChange = onEmailChange,
          hint = R.string.email_hint,
          keyboardType = KeyboardType.Email
      )
      CustomTextField(
          value = uiState.password,
          onValueChange = onPasswordChange,
          hint = R.string.password_hint,
          keyboardType = KeyboardType.Password,
          isPasswordTextField = true
      )
      Button(
          modifier = modifier
              .fillMaxWidth()
              .height(ButtonHeight),
          elevation = ButtonDefaults.elevation(
              defaultElevation = 0.dp
          ),
          shape = MaterialTheme.shapes.medium,
          onClick = {
              onNavigateToLogin()
          }
      ) {
          Text(text = stringResource(id = R.string.signup_button_hint))
      }
  }
}

