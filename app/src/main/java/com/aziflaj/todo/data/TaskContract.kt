package com.aziflaj.todo.data

import android.provider.BaseColumns

class TaskContract {
    class TaskEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "tasks"

            val COL_TITLE = "title"
            val COL_DESCRIPTION = "description"
        }
    }
}