package com.example.socialmedia.android.common

import androidx.annotation.StringRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.socialmedia.android.R
import com.example.socialmedia.android.ui.screens.uii.Gray

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordTextField: Boolean = false,
    @StringRes hint: Int,
    isSingleLine: Boolean = true,
){
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.body2,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType
        ),
        singleLine = isSingleLine,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = if (isSystemInDarkTheme()){
                MaterialTheme.colors.surface
            }else{
                Gray
            },
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        visualTransformation = if(isPasswordTextField){
            if(isPasswordVisible){
                VisualTransformation.None
            } else{
                PasswordVisualTransformation()
            }
        }else{
            VisualTransformation.None
        },
        trailingIcon = if(isPasswordTextField) {
            {
                PasswordEyeIcon(isPasswordVisible = isPasswordVisible){
                    isPasswordVisible =! isPasswordVisible
                }
            }
        }else {
            null
        },
      placeholder = {
          Text(text = stringResource(id = hint), style = MaterialTheme.typography.body2)
      },
        shape = MaterialTheme.shapes.medium

    )

}

@Composable
fun PasswordEyeIcon(
    isPasswordVisible: Boolean,
    onPasswordVisibilityToggle: ()-> Unit
){
    val image = if(isPasswordVisible){
        painterResource(id = R.drawable.visible)
    } else {
        painterResource(id = R.drawable.hidden_visible)
    }
    IconButton(onClick = onPasswordVisibilityToggle) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = image,
            contentDescription =null
        )
    }
}

