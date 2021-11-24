package ru.gb.course1.room_lesson.ui

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.gb.course1.room_lesson.app
import ru.gb.course1.room_lesson.databinding.ActivityMainBinding
import ru.gb.course1.room_lesson.model.NoteEntity
import ru.gb.course1.room_lesson.model.NoteRepo

private const val DONE_DEFAULT_VALUE_PREF_KEY = "DONE_DEFAULT_VALUE_PREF_KEY"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val preferences: SharedPreferences by lazy { app.sharedPreferences }
    private val noteRepo: NoteRepo by lazy { app.noteRepo }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addNoteButton.setOnClickListener {
            val body = binding.noteBodyEditText.text.toString()
            val isDone = binding.doneCheckbox.isChecked

            val note = NoteEntity(NoteEntity.UNDEFINED_ID, body, isDone)
            Thread {
                noteRepo.add(note)
                val notes = noteRepo.getNotes()
                runOnUiThread {
                    binding.resultTextView.text = notes.toString()
                }
            }.start()
        }
    }

    override fun onStart() {
        super.onStart()
        binding.doneCheckbox.isChecked = preferences.getBoolean(DONE_DEFAULT_VALUE_PREF_KEY, false)
    }

    override fun onStop() {
        preferences.edit().let {
            it.putBoolean(DONE_DEFAULT_VALUE_PREF_KEY, binding.doneCheckbox.isChecked)
            it.commit()
        }
        super.onStop()
    }
}