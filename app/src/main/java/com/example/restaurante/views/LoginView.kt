package com.example.restaurante.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.restaurante.R
import com.example.restaurante.components.WelcomeBackCard
import com.example.restaurante.components.menuIcon
import com.example.restaurante.ui.theme.Color1
import com.example.restaurante.ui.theme.Pin
import com.example.restaurante.ui.theme.color2A
import com.example.restaurante.ui.theme.color4
import com.example.restaurante.viewmodel.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginView(viewModel: LoginViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            Row(modifier = Modifier.padding(37.dp)) {
                Text(text = "Version 0001", color = Color.Black)
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "Build 220424",color = Color.Black)
            }

        },
        containerColor = Color1,
        contentColor = color4
    ) { paddingValues ->
            WelcomeBackCard()
            ContentLoginView(viewModel, paddingValues, navController)
        }

    }


@Composable
fun ContentLoginView(viewModel: LoginViewModel, it: PaddingValues,
                     navController: NavController)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var viewPassword by remember { mutableStateOf(true) }
        val coroutineScope = rememberCoroutineScope()


        menuIcon()
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
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = {
            coroutineScope.launch {
               if (viewModel.login(email, password)) navController.navigate("Home")
            }
        }) {
            Text(text = "Iniciar Sesion")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        IconButton(
            onClick = { /*TODO*/ }, modifier = Modifier
                .height(70.dp)
                .width(70.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.fingerprint),
                contentDescription = "",
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp),
                tint = Color.Black
            )
        }
        Spacer(modifier = Modifier.padding(3.dp))
        Text(text = "Inicia sesion mendiante huella")
    }

}