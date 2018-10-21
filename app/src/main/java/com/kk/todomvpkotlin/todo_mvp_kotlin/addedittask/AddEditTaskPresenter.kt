package com.kk.todomvpkotlin.todo_mvp_kotlin.addedittask

import android.support.annotation.NonNull
import com.kk.todomvpkotlin.todo_mvp_kotlin.data.source.TaskDataSource

class AddEditTaskPresenter: AddEditTaskContract.UserActionsListener {

    private var mTasksRepository: TaskDataSource? = null

    private var mAddTaskView: AddEditTaskContract.View? = null

    /**
     * コンストラクタ
     * @param tasksRepository   Taskのデータをやりとりする
     * @param addTaskView       タスクを追加するView
     */
    fun AddEditTaskPresenter(@NonNull tasksRepository: TaskDataSource,
                             @NonNull addTaskView: AddEditTaskContract.View) {
        mTasksRepository = tasksRepository
        mAddTaskView = addTaskView
        // Fragment側にリスナーの登録要求を投げる
        addTaskView.setUserActionListener(this)
    }


}