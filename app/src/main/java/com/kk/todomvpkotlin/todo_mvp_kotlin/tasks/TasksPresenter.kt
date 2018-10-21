package com.kk.todomvpkotlin.todo_mvp_kotlin.tasks

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
}