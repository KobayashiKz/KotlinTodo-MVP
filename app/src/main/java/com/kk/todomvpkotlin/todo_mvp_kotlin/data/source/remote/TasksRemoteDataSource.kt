package com.kk.todomvpkotlin.todo_mvp_kotlin.data.source.remote

import com.kk.todomvpkotlin.todo_mvp_kotlin.data.Task
import com.kk.todomvpkotlin.todo_mvp_kotlin.data.source.TaskDataSource

class TasksRemoteDataSource: TaskDataSource {

    companion object {
        private const val TASK_TITLE_FIRST: String = "Build tower in Pisa"
        private const val TASK_DESCRIPTION_FIRST: String = "Ground looks good, no foundation work required."
        private const val TASK_TITLE_SECOND: String = "Finish bridge in Tacoma"
        private const val TASK_DESCRIPTION_SECOND: String = "Found awesome girders at half the cost!"
    }

    // SingleTon
    object TasksRemoteDataSource {}

    private val mTasksServiceData: MutableMap<String?, Task>? = null

    init {
        addTask(TASK_TITLE_FIRST, TASK_DESCRIPTION_FIRST)
        addTask(TASK_TITLE_SECOND, TASK_DESCRIPTION_SECOND)
    }

    /**
     * 追加するタスクをMapに保存
     *
     * @param title 追加するタスクのタイトル
     * @param description 追加するタスクの詳細
     */
    private fun addTask(title: String, description: String) {
        val newTask = Task(title, description)
        // Mapに追加するタスクのIDと詳細を保存
        mTasksServiceData?.put(newTask.getId(), newTask)
    }

    /**
     * 完了するタスクをMapに保存
     *
     * @param completeTask 完了するタスク
     */
    override fun completeTask(completeTask: Task) {
        val completeTask = Task(completeTask.getTitle(), completeTask.getDescription(),
            completeTask.getId(), true)
        mTasksServiceData?.put(completeTask.getId(), completeTask)
    }

    /**
     * 未完了にするタスクをMapに保存
     */
    override fun activateTask(task: Task) {
        val activateTask: Task = Task(task.getTitle(), task.getDescription(), task.getId())
        mTasksServiceData?.put(task.getId(), activateTask)
    }
}