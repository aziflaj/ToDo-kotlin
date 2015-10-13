package com.aziflaj.todo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class CreateTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)
        title = getString(R.string.task_new_task_actionbar_title)
    }
}
