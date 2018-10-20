package com.kk.todomvpkotlin.todo_mvp_kotlin.tasks

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.kk.todomvpkotlin.todo_mvp_kotlin.data.Task


class TasksFragment: Fragment(), TasksContract.View {

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

    companion object {
        /**
         * Fragmentのインスタンス生成
         */
        fun newInstance(): TasksFragment {
            return TasksFragment()
        }

        /**
         * アダプタークラス
         */
        class TasksAdapter: BaseAdapter() {

            var mTasks: List<Task>? = null

            override fun getCount(): Int {
                return mTasks?.count() ?: 0
            }

            override fun getItem(p0: Int): Any {
                return mTasks?.get(p0) ?: 0
            }

            override fun getItemId(p0: Int): Long {
                return p0.toLong()
            }

            override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
                // TODO Viewの生成
                return p1!!
            }
        }
    }
}