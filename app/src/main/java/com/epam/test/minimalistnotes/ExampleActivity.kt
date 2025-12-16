import android.os.Bundle
import androidx.activity.ComponentActivity

class ExampleActivity : ComponentActivity() {

    private var isDarkTheme = true // 我们想保存的状态

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 2. 恢复：检查 Bundle 是否有之前保存的数据
        if (savedInstanceState != null) {
            isDarkTheme = savedInstanceState.getBoolean("KEY_DARK_THEME", true)
            // 恢复成功！继续使用用户之前的设置
        }

        // ... 设置 UI
    }

    // 1. 保存：系统即将销毁 Activity 时调用
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // 把当前状态打包放入 Bundle
        outState.putBoolean("KEY_DARK_THEME", isDarkTheme)
    }
}