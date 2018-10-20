package com.kk.todomvpkotlin.todo_mvp_kotlin.tasks

interface TasksContract {

    /**
     * Presenterから呼ばれActivityやFragmentで処理する
     * 基本的にUI関連の処理をおこなう
     */
    interface View {


    }

    /**
     * ActivityやFragmentから呼ばれPresenterで処理する
     * 基本的にUI以外の処理でデータの取得や保存などをおこなう
     */
    interface UserActionListener {

    }
}