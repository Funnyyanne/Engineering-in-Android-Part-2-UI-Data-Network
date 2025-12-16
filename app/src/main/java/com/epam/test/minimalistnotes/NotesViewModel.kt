package com.epam.test.minimalistnotes

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.epam.test.minimalistnotes.network.NetworkModule
import com.epam.test.minimalistnotes.network.Quote
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.collections.emptyList

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.Companion.getDatabase(application).noteDao()

    val allNotes = dao.getAllNotes().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun addNote(title: String, content: String) {
        viewModelScope.launch {
            dao.insertNote(Note(title = title, content = content))
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            dao.deleteNote(note)
        }
    }

    private val _quote = MutableStateFlow<Quote?>(null)
    val quote = _quote.asStateFlow()

    init {
        fetchDailyQuote() // 初始化时获取
    }

    fun fetchDailyQuote() {
        viewModelScope.launch {
            try {
                // 网络请求也是 suspend 函数，运行在协程中
                val remoteQuote = NetworkModule.api.getRandomQuote()
                Log.i("note++", "Success: $remoteQuote")
                _quote.value = remoteQuote
            } catch (e: Exception) {
                Log.e("note++", "Error fetching quote: ${e.message}", e)
                // 处理错误，例如显示默认名言
                _quote.value = Quote("Keep coding!", "Developer")
            }
        }
    }
}