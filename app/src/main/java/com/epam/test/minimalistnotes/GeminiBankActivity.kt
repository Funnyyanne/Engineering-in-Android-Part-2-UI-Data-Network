package com.epam.test.minimalistnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class GeminiBankActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                BankView()
            }
        }
    }
}

@Composable
fun BankView() {
    Scaffold(
        bottomBar = { BankBottomNavigationBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(16.dp)
        ) {
            BankHeader()
            Spacer(modifier = Modifier.height(24.dp))
            BankCardSection()
            Spacer(modifier = Modifier.height(24.dp))
            BankSavingsSection()
            Spacer(modifier = Modifier.height(24.dp))
            BankStatsSection()
        }
    }
}

@Composable
private fun BankHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background), // Replace with actual image
                contentDescription = "User Avatar",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Hello, Samanta", style = MaterialTheme.typography.titleLarge)
        }
        Row {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Search, contentDescription = "Search")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Notifications, contentDescription = "Notifications")
            }
        }
    }
}

@Composable
private fun BankCardSection() {
    Box(modifier = Modifier.height(220.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(Color(0xFFFFA726), RoundedCornerShape(20.dp))
                .align(Alignment.TopCenter)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("**** 4578", color = Color.White, fontSize = 12.sp)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(Color(0xFF42A5F5), RoundedCornerShape(20.dp))
                .align(Alignment.Center)
                .offset(y = (-20).dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("**** 0809", color = Color.White, fontSize = 12.sp)
                Spacer(modifier = Modifier.weight(1f))
                Text("VISA", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF212121)),
            elevation =  CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "$ 28,901.5",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Total balance", color = Color.Gray, fontSize = 14.sp)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
                    ) {
                        Text("Deposit")
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(Icons.Default.ArrowDownward, contentDescription = null)
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
                    ) {
                        Text("Send")
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(Icons.Default.ArrowUpward, contentDescription = null)
                    }
                }
            }
        }
    }
}

@Composable
private fun BankSavingsSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.FavoriteBorder,
                        contentDescription = "Saving Goal",
                        tint = Color(0xFFFFA726)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Saving goal", fontWeight = FontWeight.Bold)
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("Top up", color = Color.White)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("$ 6,641", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text("Current amount", color = Color.Gray)
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text("$ 12,000", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text("Overall", color = Color.Gray)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = 0.55f,
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFFFA726)
            )
        }
    }
}

@Composable
private fun BankStatsSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BankStatCard("Stats", "$ 3,899", "This month", Icons.Default.PieChart)
        BankStatCard("Income", "$ 8,300", "This month", Icons.Default.AttachMoney)
    }
}

@Composable
private fun BankStatCard(title: String, amount: String, period: String, icon: ImageVector) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(icon, contentDescription = title, tint = Color(0xFF4CAF50))
                Spacer(modifier = Modifier.width(8.dp))
                Text(title, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    Icons.Default.ArrowForwardIos,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(amount, fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Text(period, color = Color.Gray)
        }
    }
}

@Composable
private fun BankBottomNavigationBar() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp, vertical = 8.dp),
        shape = RoundedCornerShape(24.dp),
        elevation =  CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Home, contentDescription = "Home")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.SwapHoriz, contentDescription = "Transactions")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.AccountBalanceWallet, contentDescription = "Wallet")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Settings, contentDescription = "Settings")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultBankPreview() {
    MaterialTheme() {
        BankView()
    }
}