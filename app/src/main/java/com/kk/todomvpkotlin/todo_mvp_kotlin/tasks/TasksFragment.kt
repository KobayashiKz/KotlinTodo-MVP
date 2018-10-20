package com.kk.todomvpkotlin.todo_mvp_kotlin.tasks

import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.kk.todomvpkotlin.todo_mvp_kotlin.R
import com.kk.todomvpkotlin.todo_mvp_kotlin.data.Task


class TasksFragment: Fragment(), TasksContract.View {

    /**
     * タスクのListViewタップ時に呼ばれるListener
     */
    interface TaskItemListener {
        fun onTaskClick(clickedTask: Task)
        fun onCompleteTaskClick(completedTask: Task)
        fun onActivateTaskClick(activateTask: Task)
    }

    val mTaskItemListener: TaskItemListener = object: TaskItemListener {
        override fun onTaskClick(clickedTask: Task) {
            // TODO Presenterにタスク詳細画面を開く要求を投げる
        }

        override fun onCompleteTaskClick(completedTask: Task) {
            // TODO Presenterにタスク完了要求を投げる
        }

        override fun onActivateTaskClick(activateTask: Task) {
            // TODO Presenterにタスク未完了要求を投げる
        }
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
            var mItemListener: TaskItemListener? = null

            fun TasksAdapter(tasks: List<Task>, itemListener: TaskItemListener) {
                mTasks = tasks
                mItemListener = itemListener
            }

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
                // 1行のViewをinflate
                var rowView: View? = p1
                if (rowView == null) {
                    val inflater: LayoutInflater = LayoutInflater.from(p2?.context)
                    rowView = inflater.inflate(R.layout.task_item, p2, false)
                }

                // タスクを取得
                var task: Task = getItem(p0) as Task

                // すでにnullチェックしているのでTextViewはNullable型にしない
                val titleTextView: TextView = rowView!!.findViewById(R.id.title)
                // タスクタイトルがない場合にはタスク説明文をセットする
                titleTextView.text = task.getTitleForList()

                // チェックボックス
                val completeBox: CheckBox = rowView.findViewById(R.id.complete)
                completeBox.isChecked = task.isCompleted()

                // 完了と未完了タスクで背景色を変える
                if (task.isCompleted()) {
                    rowView.setBackgroundDrawable(p1!!.context.resources
                        .getDrawable(R.drawable.list_completed_touch_feedback))
                } else {
                    rowView.setBackgroundDrawable(p1!!.context.resources
                        .getDrawable(R.drawable.touch_feedback))
                }

                // チェックボックスをタップされたときの挙動
                completeBox.setOnClickListener { View.OnClickListener {
                    if (!completeBox.isChecked) {
                        // 未完了タスクは完了へ
                        mItemListener?.onCompleteTaskClick(task)
                    } else {
                        // 完了タスクは未完了へ
                        mItemListener?.onActivateTaskClick(task)
                    }
                } }

                // タスクアイテムをタップした際の挙動
                rowView.setOnClickListener { View.OnClickListener {
                    mItemListener?.onTaskClick(task)
                } }

                return rowView
            }
        }
    }
}