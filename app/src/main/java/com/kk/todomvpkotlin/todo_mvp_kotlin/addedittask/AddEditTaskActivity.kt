package com.kk.todomvpkotlin.todo_mvp_kotlin.addedittask

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import com.kk.todomvpkotlin.todo_mvp_kotlin.R
import com.kk.todomvpkotlin.todo_mvp_kotlin.util.ActivityUtil

/**
 * タスク作成/編集画面
 */
class AddEditTaskActivity: AppCompatActivity() {

    private val mAddEditTaskPresenter: AddEditTaskPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContentView(R.layout.addtask_act)

        Log.d("kkkk" , "AddEditTaskActivity onCreate()")
        // Toolbarの設定とハンバーガー画像の設定.
        // 初回起動画面と同じ
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)

        // タスク作成/編集画面のFragment生成
        var addEditTaskFragment: AddEditTaskFragment =
            supportFragmentManager.findFragmentById(R.id.contentFrame) as AddEditTaskFragment

        addEditTaskFragment = AddEditTaskFragment.newInstance()

        // 編集画面か作成画面かを判断
        if (intent.hasExtra(AddEditTaskFragment.ARGUMENT_EDIT_TASK_ID)) {
            // 遷移元画面からintentに値がセットされていたら、それをFragmentへそのまま渡す
            val taskId: String = intent.getStringExtra(
                AddEditTaskFragment.ARGUMENT_EDIT_TASK_ID)
            val bundle: Bundle = Bundle()
            bundle.putString(AddEditTaskFragment.ARGUMENT_EDIT_TASK_ID, taskId)
            addEditTaskFragment.arguments = bundle

            actionBar?.setTitle(R.string.edit_task)
        } else {
            // Intentに値がセットされていない場合タスク作成画面のタイトルセット
            actionBar?.setTitle(R.string.add_task)
        }
        ActivityUtil.addFragmentToActivity(supportFragmentManager,
            addEditTaskFragment, R.id.contentFrame)

        // TODO Presenterの生成（mock作っているためひとまず保留）
//        val mAddEditTaskPresenter: AddEditTaskPresenter =
//                AddEditTaskPresenter()

    }

    /**
     * ツールバーの戻るボタンを押したときに呼ばれる処理
     */
    override fun onSupportNavigateUp(): Boolean {
        // バックキーを押したときと同じふるまいをする
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}