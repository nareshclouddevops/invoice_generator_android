package com.example.invoiceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.invoiceapp.ui.theme.InvoiceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InvoiceAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InvoiceForm()
                }
            }
        }
    }
}

@Composable
fun InvoiceForm() {
    var fromName by remember { mutableStateOf("") }
    var fromAddress by remember { mutableStateOf("") }
    var fromPhone by remember { mutableStateOf("") }
    var fromPAN by remember { mutableStateOf("") }

    var toName by remember { mutableStateOf("") }
    var toAddress by remember { mutableStateOf("") }
    var toPAN by remember { mutableStateOf("") }
    var toGST by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Your Details", fontSize = 20.sp)
        OutlinedTextField(value = fromName, onValueChange = { fromName = it }, label = { Text("From: Name") })
        OutlinedTextField(value = fromAddress, onValueChange = { fromAddress = it }, label = { Text("From: Address") })
        OutlinedTextField(value = fromPhone, onValueChange = { fromPhone = it }, label = { Text("From: Phone") })
        OutlinedTextField(value = fromPAN, onValueChange = { fromPAN = it }, label = { Text("From: PAN") })

        Text("Client Details", fontSize = 20.sp)
        OutlinedTextField(value = toName, onValueChange = { toName = it }, label = { Text("To: Name") })
        OutlinedTextField(value = toAddress, onValueChange = { toAddress = it }, label = { Text("To: Address") })
        OutlinedTextField(value = toPAN, onValueChange = { toPAN = it }, label = { Text("To: PAN") })
        OutlinedTextField(value = toGST, onValueChange = { toGST = it }, label = { Text("To: GST Number") })

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* TODO: Generate or preview invoice */ }) {
            Text("Generate Invoice PDF")
        }
    }
}