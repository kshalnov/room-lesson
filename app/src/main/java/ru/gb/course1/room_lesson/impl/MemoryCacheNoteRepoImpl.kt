package ru.gb.course1.room_lesson.impl

import ru.gb.course1.room_lesson.model.NoteEntity
import ru.gb.course1.room_lesson.model.NoteRepo

class MemoryCacheNoteRepoImpl : NoteRepo {
    private val cache: MutableList<NoteEntity> = mutableListOf()
    private var counter = 0

    override fun add(note: NoteEntity): Int {
        val id = counter++
        cache.add(note.copy(id = id))
        return id
    }

    override fun getNotes(): List<NoteEntity> {
        return ArrayList<NoteEntity>(cache)
    }

    override fun delete(id: Int) {
        val indexToDelete = cache.indexOfFirst {
            it.id == id
        }
        cache.removeAt(indexToDelete)
    }
}