package com.kk.todomvpkotlin.todo_mvp_kotlin

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * テストで使用するMockを使用するためのInjectionクラス
 */
object Injection {
    fun provideTasksRepository(context: Context): TasksRepository {
        checkNotNull(context)
        return TasksRepository.getInstance(
            FakeTasksRemoteDataSource.getInstance(),
            TasksLocalDataSource.getInstance(context)
        )
    }
}

