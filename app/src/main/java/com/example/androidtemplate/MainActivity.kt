package com.example.androidtemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidtemplate.ui.theme.AndroidTemplateTheme
import dagger.hilt.android.AndroidEntryPoint
import kr.pe.ssun.template.core.designsystem.theme.SsunTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SsunTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Greeting("Android")
                        Text("compile sdk = ${BuildConfig.COMPILE_SDK}")
                        Text("target sdk = ${BuildConfig.TARGET_SDK}")
                        Text("min sdk = ${BuildConfig.MIN_SDK}")
                        Text("version name = ${BuildConfig.VERSION_NAME}")
                        Text("version code = ${BuildConfig.VERSION_CODE}")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidTemplateTheme {
        Greeting("Android")
    }
}