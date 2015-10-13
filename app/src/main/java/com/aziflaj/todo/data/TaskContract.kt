package com.aziflaj.todo.data

import android.content.ContentResolver
import android.content.ContentUris
import android.net.Uri
import android.provider.BaseColumns

object TaskContract {
    val CONTENT_AUTHORITY = "com.aziflaj.todo"
    val BASE_CONTENT_URI: Uri = Uri.parse("content://${CONTENT_AUTHORITY}")
    val TASK_PATH = TaskEntry.TABLE_NAME

    object TaskEntry {
        val CONTENT_URI: Uri = BASE_CONTENT_URI.buildUpon().appendPath(TASK_PATH).build()
        val CONTENT_TYPE = "${ContentResolver.CURSOR_DIR_BASE_TYPE}/${CONTENT_AUTHORITY}/${TASK_PATH}"
        val CONTENT_ITEM_TYPE = "${ContentResolver.CURSOR_ITEM_BASE_TYPE}/${CONTENT_AUTHORITY}/${TASK_PATH}"

        val TABLE_NAME = "tasks"

        val _ID = BaseColumns._ID // Y U NO implement?!
        val _COUNT = BaseColumns._COUNT
        val COL_TITLE = "title"
        val COL_DESCRIPTION = "description"

        fun buildWithId(id: Long): Uri {
            return ContentUris.withAppendedId(CONTENT_URI, id)
        }

        fun getIdFromUri(uri: Uri): Long {
            return ContentUris.parseId(uri)
        }
    }
}