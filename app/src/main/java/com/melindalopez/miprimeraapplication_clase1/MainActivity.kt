
package com.melindalopez.miprimeraapplication_clase1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.ui.unit.dp
import com.melindalopez.miprimeraapplication_clase1.ui.theme.MiPrimeraApplication_clase1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            primeraApp()
        }

    }

    @Composable
    fun primeraApp() {
        var entrada by remember { mutableStateOf("") }
        var etiqueta by remember { mutableStateOf("Ingrese un texto") }

        MaterialTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    etiqueta(text = etiqueta)
                    entrada(value = entrada, onValueChange = { entrada = it })
                    boton(onClick = { etiqueta = entrada
                         etiqueta = ""
                    })
                }
            }
        }
    }

    @Composable
    fun etiqueta(text: String) {
        Text(
            text = text,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }

    @Composable
    fun entrada(value: String, onValueChange: (String) -> Unit) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text("Ingrese un texto") },
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun boton(onClick: () -> Unit) {
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cambiar etiqueta")
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PrimeraAppPreview() {
        MiPrimeraApplication_clase1Theme {
            primeraApp()
        }
    }
}
