package com.aziflaj.todo

import android.content.CursorLoader
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ListView
import com.aziflaj.todo.data.TaskContract

class MainActivity : AppCompatActivity(), android.app.LoaderManager.LoaderCallbacks<Cursor> {
    override fun onCreateLoader(id: Int, args: Bundle?): android.content.Loader<Cursor>? {
        return CursorLoader(applicationContext,
                TaskContract.TaskEntry.CONTENT_URI,
                null,
                null,
                null,
                null)
    }

    override fun onLoadFinished(loader: android.content.Loader<Cursor>?, data: Cursor?) {
        taskAdapter?.swapCursor(data)
    }

    override fun onLoaderReset(loader: android.content.Loader<Cursor>?) {
        taskAdapter?.swapCursor(null)
    }

    companion object {
        val TASK_LOADER = 0 //the loader id
        var taskAdapter: TaskAdapter? = null
        var listView: ListView? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        loaderManager.initLoader(TASK_LOADER, null, this)

        listView = findViewById(R.id.task_listview) as ListView
        taskAdapter = TaskAdapter(applicationContext, null, 0)

        listView?.adapter = taskAdapter

        val newTaskFab = findViewById(R.id.fab) as FloatingActionButton

        newTaskFab.setOnClickListener({ view ->
            val newTaskIntent = Intent(applicationContext, CreateTaskActivity::class.java)
            startActivity(newTaskIntent)
        })
    }
}
