package com.aziflaj.todo

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.TextView
import com.aziflaj.todo.data.TaskContract


class TaskAdapter(context: Context, cursor: Cursor?, flags: Int) : CursorAdapter(context, cursor, flags) {
    override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View? {
        return LayoutInflater.from(context).inflate(R.layout.task_listview_item, parent, false)
    }

    override fun bindView(view: View?, context: Context?, cursor: Cursor?) {
        var titleTextView = view?.findViewById(R.id.list_item_title) as TextView

        val TITLE_COL_INDEX = cursor?.getColumnIndex(TaskContract.TaskEntry.COL_TITLE) as Int
        val taskTitle = cursor?.getString(TITLE_COL_INDEX)
        titleTextView.text = taskTitle
    }
}