package com.kk.todomvpkotlin.todo_mvp_kotlin.tasks

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.kk.todomvpkotlin.todo_mvp_kotlin.R
import com.kk.todomvpkotlin.todo_mvp_kotlin.data.source.TasksRepository
import com.kk.todomvpkotlin.todo_mvp_kotlin.util.ActivityUtil

class TasksActivity : AppCompatActivity() {

    private var mDrawerLayout: DrawerLayout? = null

    private var mTasksPresenter: TasksPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tasks_act)

        //Toolbarの設定.サポートライブラリv7を使用
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar: ActionBar? = supportActionBar
        // ハンバーガー画像を設定
        actionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu)
        // タップイベントの有効化
        actionBar.setDisplayHomeAsUpEnabled(true)

        // ナビゲーションドロワーの設定
        mDrawerLayout = findViewById(R.id.drawer_layout)
        mDrawerLayout!!.setStatusBarBackground(R.color.colorPrimaryDark)
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        setUpDrawerContent(navigationView)

        // FragmentをActivityに配置
        val tasksFragment: TasksFragment = TasksFragment.newInstance()
        ActivityUtil.addFragmentToActivity(
            supportFragmentManager, tasksFragment, R.id.contentFrame)

        // Presenterの生成
        mTasksPresenter = TasksPresenter(TasksRepository(), tasksFragment)

        // TODO: Activityが再生成されたときの処理
    }

    /**
     * ナビゲーションドロワーのアイテムがタップされた時の処理
     */
    private fun setUpDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.list_navigation_menu_item -> {
                    // メニューボタンタップ時は特になにもしない
                }
                R.id.statistics_navigation_menu_item -> {
                    // TODO 結果表示画面に遷移させる
                }
                else -> {
                    // アイテム以外の部分タップした際には特になにもしない
                    // ドロワーナビゲーションが閉じる判定などはフレームワーク側で行われる
                }
            }

            menuItem.isChecked = true
            // ドロワーナビゲーションを閉じる
            mDrawerLayout?.closeDrawers()
            true
        }
    }

    /**
     * オプションボタンが押された際の処理
     */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.getItemId()) {
            android.R.id.home -> {
                // ドロワーナビゲーションを表示
                mDrawerLayout?.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
