package com.aziflaj.todo

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import com.aziflaj.todo.data.TaskContract

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        // TODO: create a cursor adapter to populate a ListView
        val cursor: Cursor? = contentResolver.query(TaskContract.TaskEntry.CONTENT_URI,
                null, null, null, null)

        Log.d("Task Count", "${cursor?.count} rows fetched")

        val newTaskFab = findViewById(R.id.fab) as FloatingActionButton

        newTaskFab.setOnClickListener({ view ->
            val newTaskIntent = Intent(applicationContext, CreateTaskActivity::class.java)
            startActivity(newTaskIntent)
        })
    }
}
