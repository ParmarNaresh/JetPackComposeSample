package com.jbdinfotech.jetpackcomposesample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbdinfotech.jetpackcomposesample.ui.theme.JetPackComposeSampleTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            layoutMethod()
        }
    }

    fun onLoginButtonClicked(text: String, text1: String) {

    }

    @Preview(showBackground = true)
    @Composable
    fun layoutMethod() {
        JetPackComposeSampleTheme {
            // A surface container using the 'background' color from the theme
            Surface(color = MaterialTheme.colors.background) {
                val image: Painter = painterResource(id = R.drawable.ic_launcher_background)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(image, contentDescription = "")

                    val email = remember { mutableStateOf(TextFieldValue()) }
                    val password = remember { mutableStateOf(TextFieldValue()) }
                    TextField(
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White
                        ),
                        value = email.value,
                        onValueChange = { email.value = it },
                        label = { Text("Email") },
                        modifier = Modifier
                            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth()
                    )
                    TextField(
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        value = password.value,
                        onValueChange = { password.value = it },
                        label = { Text("Password") },
                        placeholder = { Text("Enter Password") },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()

                    )
                    Button(onClick = {
                        if (email.value.text.isEmpty()) {
                            Log.d("LoginActivity", "email is empty ")
                        } else if (password.value.text.isEmpty()) {
                            Log.d("LoginActivity", "layoutMethod: password empty")
                        } else {
                            onLoginButtonClicked(email.value.text, password.value.text)
                        }
                    }, Modifier.background(color = Color.Blue)) {
                        Text(text = "Login Now")
                    }

                    ClickableText(text = buildAnnotatedString {
                        append("Not Register? ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF4552B8)
                            )
                        ) {
                            append("Register Now")
                        }
                    }, onClick = {
                        onRegisterButtonClicked()
                    }, modifier = Modifier.padding(20.dp))


                }
            }
        }
    }

    fun onRegisterButtonClicked() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

}

