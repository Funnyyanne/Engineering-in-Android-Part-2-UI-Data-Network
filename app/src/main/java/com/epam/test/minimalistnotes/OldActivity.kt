import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

// ❌ 传统方式：手动保存和恢复
class OldActivity : ComponentActivity() {
    private var isDarkTheme = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isDarkTheme = savedInstanceState?.getBoolean("KEY") ?: true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("KEY", isDarkTheme)
    }
}

// ✅ Compose 方式：一行搞定
@Composable
fun MyScreen() {
    var isDarkTheme by rememberSaveable { mutableStateOf(true) }
    // 自动保存，自动恢复，无需额外代码！
}