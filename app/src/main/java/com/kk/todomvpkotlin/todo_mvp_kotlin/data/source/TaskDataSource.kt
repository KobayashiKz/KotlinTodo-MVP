package com.kk.todomvpkotlin.todo_mvp_kotlin.data.source

import com.kk.todomvpkotlin.todo_mvp_kotlin.data.Task

/**
 * Taskのデータにアクセスする際のインターフェース.
 */
interface TaskDataSource {

    interface GetTaskCallback {

        fun onTaskLoaded(task: Task)

        fun onDataNotAvailable()
    }

}