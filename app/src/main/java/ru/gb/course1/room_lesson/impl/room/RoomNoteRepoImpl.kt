package ru.gb.course1.room_lesson.impl.room

import ru.gb.course1.room_lesson.model.NoteEntity
import ru.gb.course1.room_lesson.model.NoteRepo

class RoomNoteRepoImpl(private val noteDao: NoteDao) : NoteRepo {
    override fun add(note: NoteEntity): Int {
        noteDao.add(note)
        return -1
    }

    override fun getNotes(): List<NoteEntity> {
        return noteDao.getNotes()
    }

    override fun delete(id: Int) {
        // todo noteDao.delete()
    }
}