package com.epam.test.minimalistnotes

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

class BBCNewsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BBCNewsScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BBCNewsScreen() {
    val webViewClient = WebViewClient() // Handles navigation within the WebView

    // Get the current context
    val context = androidx.compose.ui.platform.LocalContext.current
    val activity = context as? ComponentActivity

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("BBC News") },
                navigationIcon = {
                    IconButton(onClick = {
                        // Handle back navigation
                        activity?.finish()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            AndroidView(
                factory = { ctx ->
                    WebView(ctx).apply {
                        // Enable JavaScript if needed
                        settings.javaScriptEnabled = true
                        // Set the client to handle navigation
                        this.webViewClient = webViewClient
                        // Load BBC News website
                        loadUrl("https://www.bbc.com/news")
                    }
                },
                update = { webView ->
                    // Update logic if needed
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}