package com.kk.todomvpkotlin.todo_mvp_kotlin

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

class FakeTasksRemoteDataSource// Prevent direct instantiation.
private constructor() : TasksDataSource {

    fun getTasks(callback: LoadTasksCallback) {
        callback.onTasksLoaded(Lists.newArrayList(TASKS_SERVICE_DATA.values))
    }

    fun getTask(taskId: String, callback: GetTaskCallback) {
        val task = TASKS_SERVICE_DATA.get(taskId)
        callback.onTaskLoaded(task)
    }

    fun saveTask(task: Task) {
        TASKS_SERVICE_DATA.put(task.getId(), task)
    }

    fun completeTask(task: Task) {
        val completedTask = Task(task.getTitle(), task.getDescription(), task.getId(), true)
        TASKS_SERVICE_DATA.put(task.getId(), completedTask)
    }

    fun completeTask(taskId: String) {
        // Not required for the remote data source.
    }

    fun activateTask(task: Task) {
        val activeTask = Task(task.getTitle(), task.getDescription(), task.getId())
        TASKS_SERVICE_DATA.put(task.getId(), activeTask)
    }

    fun activateTask(taskId: String) {
        // Not required for the remote data source.
    }

    fun clearCompletedTasks() {
        val it = TASKS_SERVICE_DATA.entries.iterator()
        while (it.hasNext()) {
            val entry = it.next()
            if (entry.value.isCompleted()) {
                it.remove()
            }
        }
    }

    fun refreshTasks() {
        // Not required because the {@link TasksRepository} handles the logic of refreshing the
        // tasks from all the available data sources.
    }

    fun deleteTask(taskId: String) {
        TASKS_SERVICE_DATA.remove(taskId)
    }

    fun deleteAllTasks() {
        TASKS_SERVICE_DATA.clear()
    }

    @VisibleForTesting
    fun addTasks(vararg tasks: Task) {
        for (task in tasks) {
            TASKS_SERVICE_DATA.put(task.getId(), task)
        }
    }

    companion object {

        private var INSTANCE: FakeTasksRemoteDataSource? = null

        private val TASKS_SERVICE_DATA = LinkedHashMap<String, Task>()

        val instance: FakeTasksRemoteDataSource
            get() {
                if (INSTANCE == null) {
                    INSTANCE = FakeTasksRemoteDataSource()
                }
                return INSTANCE
            }
    }
}
