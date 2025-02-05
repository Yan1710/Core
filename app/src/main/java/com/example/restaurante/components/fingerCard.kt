package com.example.restaurante.components

import androidx.activity.OnBackPressedCallback
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.restaurante.R


@Composable
fun fingerCard(onDismiss: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var viewPassword by remember { mutableStateOf(true) }
    Card() {
        Column(  horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.width(550.dp).height(275.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.fingerprint),
                contentDescription = "",
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp),
                tint = Color.Black
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                textStyle = TextStyle.Default,
                label = { Text(text = "Email", color = Color.Black) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                colors = TextFieldDefaults.colors(focusedContainerColor = Color.White, disabledContainerColor = Color.Black),
                shape = RoundedCornerShape(30.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password", color = Color.Black) },
                visualTransformation = if (!viewPassword) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                colors = TextFieldDefaults.colors(focusedContainerColor = Color.White, disabledContainerColor = Color.Black),
                textStyle = TextStyle.Default,
                trailingIcon = {
                    IconButton(onClick = { viewPassword = !viewPassword}) {
                        if(viewPassword) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.visibilityoff),
                                contentDescription = ""
                            )
                        }else{
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.eye),
                                contentDescription = ""
                            )
                        }
                    }
                },
                shape = RoundedCornerShape(30.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = onDismiss) {
                Text("Cerrar")
            }

        }
    }

}