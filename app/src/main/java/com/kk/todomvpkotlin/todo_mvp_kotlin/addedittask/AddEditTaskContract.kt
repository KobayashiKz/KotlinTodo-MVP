package com.kk.todomvpkotlin.todo_mvp_kotlin.addedittask

interface AddEditTaskContract {

    /**
     * Presenterから呼ばれActivityやFragmentで処理する
     * 基本的にUI関連の処理をおこなう
     */
    interface View {

        // リスナーの登録要求
        fun setUserActionListener(listener: UserActionsListener)
    }

    /**
     * ActivityやFragmentから呼ばれPresenterで処理する
     * 基本的にUI以外の処理でデータの取得や保存などをおこなう
     */
    interface UserActionsListener {
        // TODO
    }
}