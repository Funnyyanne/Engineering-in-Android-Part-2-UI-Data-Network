@file:OptIn(ExperimentalMaterial3Api::class)

package com.epam.test.minimalistnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.*

import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

data class DesignItem(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val timestamp: Long = Date().time
)

//class DesignActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            DesignScreen()
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DesignScreen() {
//    // Sample data for the design screen
//    val designItems = listOf(
//        DesignItem(1, "Clean Layout", "Simple and uncluttered interface", "UI"),
//        DesignItem(2, "Material Design", "Following Material Design guidelines", "UI"),
//        DesignItem(3, "Dark Theme", "Support for dark mode", "Theme"),
//        DesignItem(4, "Responsive Design", "Adapts to different screen sizes", "Layout"),
//        DesignItem(5, "Smooth Animations", "Fluid transitions between screens", "UX")
//    )
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("Design Elements") },
//                navigationIcon = {
//                    val activity = LocalActivity.current
//                    IconButton(onClick = { activity?.finish() }) {
//                        Icon(
//                            imageVector = Icons.Default.ArrowBack,
//                            contentDescription = "Back"
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.primary,
//                    titleContentColor = MaterialTheme.colorScheme.onPrimary
//                )
//            )
//        }
//    ) { innerPadding ->
//        LazyColumn(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding),
//            contentPadding = PaddingValues(16.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            items(designItems) { item ->
//                DesignItemCard(item = item)
//            }
//        }
//    }
//}
//
//@Composable
//fun DesignItemCard(item: DesignItem) {
//    Card(
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.surfaceVariant
//        ),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//        ) {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(
//                    text = item.title,
//                    style = MaterialTheme.typography.headlineSmall,
//                    color = MaterialTheme.colorScheme.onSurface
//                )
//                Badge(
//                    containerColor = MaterialTheme.colorScheme.primary,
//                    contentColor = MaterialTheme.colorScheme.onPrimary
//                ) {
//                    Text(text = item.category)
//                }
//            }
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            Text(
//                text = item.description,
//                style = MaterialTheme.typography.bodyMedium,
//                color = MaterialTheme.colorScheme.onSurfaceVariant
//            )
//        }
//    }
//}

class DesignActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 设置主题
            AppTheme {
                // 调用主界面
                BankingAppScreen()
            }
        }
    }
}

// 定义应用主题
@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = MaterialTheme.typography,
        shapes = MaterialTheme.shapes,
        content = content
    )
}

// 主界面
@Composable
fun BankingAppScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Banking App") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
            ) {
                // 用户问候语
                GreetingSection()

                // 卡片区域
                CardSection()

                // 存款目标
                SavingGoalSection()

                // 统计区域
                StatsSection()

                // 空白占位符
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    )
}

// 顶部问候语部分
@Composable
fun GreetingSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 这里应该是一个圆形头像，我们用一个简单的圆形代替
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = "Hello, Samanta",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )

        // 搜索图标
        IconButton(onClick = { /* TODO */ }) {
            Icon(Icons.Default.Search, contentDescription = "Search")
        }

        // 通知图标
        IconButton(onClick = { /* TODO */ }) {
            Icon(Icons.Default.Notifications, contentDescription = "Notifications")
        }
    }
}

// 卡片区域
@Composable
fun CardSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // 第一张卡
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clip(RoundedCornerShape(16.dp)),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFF7A5C)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "**** 4578",
                    color = Color.White,
                    modifier = Modifier.padding(start = 16.dp)
                )
                // 开关
                Switch(
                    checked = true,
                    onCheckedChange = { /* TODO */ },
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 第二张卡
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clip(RoundedCornerShape(16.dp)),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF5C9BFF)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "**** 0809",
                    color = Color.White,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Text(
                    text = "VISA",
                    color = Color.White,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 余额卡片
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$28,901.5",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Total balance",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 8.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors( Color.White)
                    ) {
                        Text(
                            text = "Deposit",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        Icon(
                            Icons.Default.CheckCircle,
                            contentDescription = "Check",
                            tint = Color.Black,
                            modifier = Modifier.size(16.dp).padding(start = 4.dp)
                        )
                    }

                    Button(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 8.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(  Color.White)
                    ) {
                        Text(
                            text = "Send",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        Icon(
                            Icons.Default.Send,
                            contentDescription = "Send",
                            tint = Color.Black,
                            modifier = Modifier.size(16.dp).padding(start = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

// 存款目标部分
@Composable
fun SavingGoalSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Saving Goal",
                    tint = Color(0xFFFF5C5C) // 红色
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Saving goal",
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                onClick = { /* TODO */ },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors( Color.Black)
            ) {
                Text(text = "Top up", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "$6,641",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = "Current amount",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
            Column {
                Text(
                    text = "$12,000",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = "Overall",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 进度条
        LinearProgressIndicator(
            progress = 0.55f, // 6641 / 12000 ≈ 0.55
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp),
            color = Color(0xFFFF5C5C) // 红色
        )
    }
}

// 统计部分
@Composable
fun StatsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        StatCard(
            icon = Icons.Default.ShowChart,
            title = "Stats",
            value = "$3,899",
            subtitle = "This month"
        )

        StatCard(
            icon = Icons.Default.MonetizationOn,
            title = "Income",
            value = "$8,300",
            subtitle = "This month"
        )
    }
}

// 统计卡片组件
@Composable
fun StatCard(
    icon: ImageVector,
    title: String,
    value: String,
    subtitle: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.48f)
            .clip(RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    icon,
                    contentDescription = title,
                    tint = Color(0xFF00C853) // 绿色
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    Icons.Default.ArrowForward,
                    contentDescription = "More",
                    tint = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = value,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(
                text = subtitle,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

// 底部导航栏
@Composable
fun BottomNavigationBar(navController: NavController) {
//    BottomNavigation(
//        backgroundColor = Color.Black,
//        elevation = 8.dp
//    ) {
//        BottomNavigationItem(
//            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
//            label = { Text("Home") },
//            selected = true,
//            onClick = { /* TODO */ },
//            alwaysShowLabel = false
//        )
//        BottomNavigationItem(
//            icon = { Icon(Icons.Default.AttachMoney, contentDescription = "Money") },
//            label = { Text("Money") },
//            selected = false,
//            onClick = { /* TODO */ },
//            alwaysShowLabel = false
//        )
//        BottomNavigationItem(
//            icon = { Icon(Icons.Default.Description, contentDescription = "Document") },
//            label = { Text("Docs") },
//            selected = false,
//            onClick = { /* TODO */ },
//            alwaysShowLabel = false
//        )
//        BottomNavigationItem(
//            icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
//            label = { Text("Settings") },
//            selected = false,
//            onClick = { /* TODO */ },
//            alwaysShowLabel = false
//        )
//    }
}

// 预览
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        BankingAppScreen()
    }
}