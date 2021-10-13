package com.jbdinfotech.jetpackcomposesample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jbdinfotech.jetpackcomposesample.ui.theme.JetPackComposeSampleTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*JetPackComposeSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }*/
            layoutFiles()
        }
    }

    @Composable
    fun layoutFiles() {
        Scaffold(
            topBar = {
                val image: Painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24)
                TopAppBar(title = {
                    Text(
                        "Register ",
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    )
                }, backgroundColor = Color.Blue, navigationIcon = {
                    Image(painter =image , contentDescription ="",modifier = Modifier
                        .height(35.dp)
                        .width(35.dp)
                        .clickable(enabled = true, onClick = {
                            onBackPressed()
                        }) )
                })
            },
            content = {
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {
                    val name = remember { mutableStateOf(TextFieldValue()) }
                    val email = remember { mutableStateOf(TextFieldValue()) }
                    val mobile = remember { mutableStateOf(TextFieldValue()) }
                    val password = remember { mutableStateOf(TextFieldValue()) }
                    val confirmPassword = remember { mutableStateOf(TextFieldValue()) }
                    TextField(
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White
                        ),
                        value = name.value,
                        onValueChange = { name.value = it },
                        label = { Text("Name") },
                        modifier = Modifier
                            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth()
                    )
                    TextField(
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        value = mobile.value,
                        onValueChange = { mobile.value = it },
                        label = { Text("Mobile") },
                        modifier = Modifier
                            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth()
                    )
                    TextField(
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        value = mobile.value,
                        onValueChange = { mobile.value = it },
                        label = { Text("Password") },
                        modifier = Modifier
                            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth()
                    )
                    TextField(
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        value = confirmPassword.value,
                        onValueChange = { confirmPassword.value = it },
                        label = { Text("Confirm Password") },
                        modifier = Modifier
                            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth()
                    )
                    Row(modifier = Modifier.padding(16.dp).fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
                        val checkedState = remember { mutableStateOf(false) }
                        Checkbox(
                            checked = checkedState.value,
                            onCheckedChange = { checkedState.value = it }
                        )
                        Text(text = "I agree tearm & services",modifier = Modifier.padding(start = 10.dp))
                    }
                    Button(onClick = {
                        if (email.value.text.isEmpty()) {
                            Log.d("LoginActivity", "email is empty ")
                        } else if (password.value.text.isEmpty()) {
                            Log.d("LoginActivity", "layoutMethod: password empty")
                        } else {
                            //onLoginButtonClicked(email.value.text, password.value.text)
                        }
                    }, Modifier.background(color = Color.Blue),) {
                        Text(text = "Register Now")
                    }

                    ClickableText(text = buildAnnotatedString {
                        append("Already Register? ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF4552B8)
                            )
                        ) {
                            append(" Login Now")
                        }
                    }, onClick = {
                        onBackPressed()
                    }, modifier = Modifier.padding(20.dp))

                }
            }
        
            )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeSampleTheme {
        Greeting("Android")
    }
}