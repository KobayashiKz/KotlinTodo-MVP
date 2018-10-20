package com.kk.todomvpkotlin.todo_mvp_kotlin.tasks

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class TasksFragment: Fragment(), TasksContract.View {

    companion object {
        /**
         * Fragmentのインスタンス生成
         */
        fun newInstance(): TasksFragment {
            return TasksFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO　アダプター生成
    }

    override fun onResume() {
        super.onResume()
        // TODO Presenterの読み込み
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO タスクが正常に追加されたらsnackbarを表示させる
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }



}