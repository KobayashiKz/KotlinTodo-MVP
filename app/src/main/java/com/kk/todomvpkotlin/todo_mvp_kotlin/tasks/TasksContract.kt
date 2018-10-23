package com.kk.todomvpkotlin.todo_mvp_kotlin.tasks

import com.kk.todomvpkotlin.todo_mvp_kotlin.data.Task

interface TasksContract {

    /**
     * Presenterから呼ばれActivityやFragmentで処理する
     * 基本的にUI関連の処理をおこなう
     */
    interface View {

        fun showAddTask()

        fun setActionListener(tasksPresenter: TasksPresenter)

        fun showTaskMarkActive()
    }

    /**
     * ActivityやFragmentから呼ばれPresenterで処理する
     * 基本的にUI以外の処理でデータの取得や保存などをおこなう
     */
    interface UserActionListener {

        fun addNewTask()

        fun completeTask(completeTask: Task)

        fun activateTask(task: Task)

        fun loadTasks(forceUpdate: Boolean)
    }
}