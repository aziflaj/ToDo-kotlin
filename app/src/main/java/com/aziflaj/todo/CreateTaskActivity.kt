package com.aziflaj.todo

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.aziflaj.todo.data.TaskContract.TaskEntry
import com.aziflaj.todo.data.TaskDbHelper

class CreateTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)
        title = getString(R.string.task_new_task_actionbar_title)

        val saveBtn = findViewById(R.id.save_task_btn) as Button

        saveBtn.setOnClickListener({ view ->
            val taskTitleEditText = findViewById(R.id.task_title) as EditText
            val taskTitle = taskTitleEditText.text.toString()

            val taskDescriptionEditText = findViewById(R.id.task_description) as EditText
            val taskDescription: String = taskDescriptionEditText.text.toString()

            val values = ContentValues()
            values.put(TaskEntry.COL_TITLE, taskTitle)
            values.put(TaskEntry.COL_DESCRIPTION, taskDescription)

            var inserted = contentResolver.insert(TaskEntry.CONTENT_URI, values)

            Log.d("New Task", "inserted: $inserted")
        })
    }
}
