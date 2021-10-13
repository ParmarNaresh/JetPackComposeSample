package com.jbdinfotech.jetpackcomposesample

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jbdinfotech.jetpackcomposesample.ui.theme.JetPackComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            contentOfScreen()
        }
        initAllControls()
    }

    private fun initAllControls() {
        Handler(Looper.myLooper()!!).postDelayed(Runnable {startLoginActivity()  },1000)
    }
    private fun startLoginActivity()
    {
        val intent=Intent(this,LoginActivity::class.java);
        startActivity(intent)
        finish()
    }
}

@Preview(showBackground = true)
@Composable
fun contentOfScreen() {
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
                Text(
                    "App Name",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
