package com.kk.todomvpkotlin.todo_mvp_kotlin.tasks

import android.content.Context
import android.support.v4.view.ViewCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.util.AttributeSet
import android.view.View

/**
 * タスクリストのスワイプを処理するクラス
 */
class ScrollChildSwipeRefreshLayout: SwipeRefreshLayout {

    private val mScrollChildUp: View? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    /**
     * タスクリストががスクロール可能な場合の処理
     */
    override fun canChildScrollUp(): Boolean {
        // もしタスクリストがスクロールできる場合は縦方向にスクロール
        if (mScrollChildUp != null) {
            return ViewCompat.canScrollVertically(mScrollChildUp, -1)
        }
        return super.canChildScrollUp()
    }
}