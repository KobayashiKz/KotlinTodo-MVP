package com.kk.todomvpkotlin.todo_mvp_kotlin.data.source

import android.support.annotation.NonNull
import com.kk.todomvpkotlin.todo_mvp_kotlin.data.Task

class TasksRepository: TaskDataSource {

    private var mTasksRemoteDataSource: TaskDataSource? = null

    private var mTasksLocalDataSource: TaskDataSource? = null

    var mCacheTasks: MutableMap<String, Task>? = null

    fun init() {
        // do nothing
    }

    fun constructor(tasksRemoteDataSource: TaskDataSource,
                    tasksLocalDataSource: TaskDataSource) {
        mTasksRemoteDataSource = tasksRemoteDataSource
        mTasksLocalDataSource = tasksLocalDataSource
    }

    /**
     * タスク完了時に呼ばれるデータ処理
     */
    override fun completeTask(@NonNull completeTask: Task) {
        checkNotNull(completeTask)

        // 完了するタスクをMapに保存
        mTasksRemoteDataSource?.completeTask(completeTask)

        mTasksLocalDataSource?.completeTask(completeTask)

        // キャッシュをアップデートしてUIを最新状態に保つ
        val completedTask: Task = Task(completeTask.getTitle(), completeTask.getDescription(),
            completeTask.getId(), true)
        if (mCacheTasks == null) {
            mCacheTasks = LinkedHashMap()
        }
        mCacheTasks?.put(completeTask.getId()!!, completedTask)
    }

    /**
     * タスクを未完了にする際のデータ処理
     */
    override fun activateTask(task: Task) {
        checkNotNull(task)
        // 未完了タスクをMapに保存する
        mTasksRemoteDataSource?.activateTask(task)
        mTasksLocalDataSource?.activateTask(task)

        val activateTask: Task =
            Task(task.getId(), task.getDescription(), task.getId())

        // 未完了にするタスクをキャッシュに保存
        if (mCacheTasks == null) {
            mCacheTasks = LinkedHashMap()
        }
        mCacheTasks?.put(task.getId()!!, task)
    }
}