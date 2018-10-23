package com.kk.todomvpkotlin.todo_mvp_kotlin.tasks

import android.util.Log
import com.kk.todomvpkotlin.todo_mvp_kotlin.data.Task
import com.kk.todomvpkotlin.todo_mvp_kotlin.data.source.TasksRepository

class TasksPresenter: TasksContract.UserActionListener {

    private var mTasksRepository: TasksRepository? = null
    private var mTasksView: TasksContract.View? = null

    /**
     * コンストラクタ
     */
    constructor(tasksRepository: TasksRepository, tasksView: TasksContract.View) {
        mTasksRepository = tasksRepository
        mTasksView = tasksView
        tasksView.setActionListener(this)
    }

    /**
     * 新規タスク追加要求
     */
    override fun addNewTask() {
        mTasksView?.showAddTask()
    }

    /**
     * タスクの完了要求
     */
    override fun completeTask(completeTask: Task) {
        checkNotNull(completeTask)
        mTasksRepository?.completeTask(completeTask)
    }

    /**
     * タスクを未完了にする
     */
    override fun activateTask(task: Task) {
        if (task == null) {
            Log.d("TasksPresenter", "activateTask cannot be null")
        }
        // Repository側には未完了にするデータの処理を依頼
        mTasksRepository?.activateTask(task)
        // Fragment側には未完了にするUI更新処理を依頼
        mTasksView?.showTaskMarkActive()
    }

    /**
     * タスクの読み込み処理、更新処理
     */
    override fun loadTasks(forceUpdate: Boolean) {
        // TODO タスクの読み込み処理
    }
}