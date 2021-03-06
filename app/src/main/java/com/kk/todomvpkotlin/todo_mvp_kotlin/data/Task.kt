package com.kk.todomvpkotlin.todo_mvp_kotlin.data

import java.util.*

class Task {

    // 一意に振られるタスクID
    private var mId: String? = null
    // タイトル
    private var mTitle: String? = null
    // タスク詳細
    private var mDescription: String? = null
    // 完了フラグ
    private var mCompleted: Boolean = false

    /**
     * 新たにタスクを生成するときに呼ばれるコンストラクタ
     *
     * @param title
     * @param description
     */
    constructor(title: String, description: String) {
        mId = UUID.randomUUID().toString()
        mTitle = title
        mDescription = description
        mCompleted = false
    }

    /**
     * タスクを編集する際に呼ばれるコンストラクタ
     * @param title
     * @param description
     * @param id
     */
    constructor(title: String?, description: String?, id: String?) {
        mId = id
        mTitle = title
        mDescription = description
        mCompleted = false
    }

    /**
     * タスクを完了したときに呼ばれるコンストラクタ
     * @param title
     * @param description
     * @param completed
     */
    constructor(title: String, description: String, completed: Boolean) {
        mId = UUID.randomUUID().toString()
        mTitle = title
        mDescription = description
        mCompleted = completed
    }

    /**
     * コピーされたタスクを完了する場合に呼ばれるコンストラクタ
     * @param title
     * @param description
     * @param id
     * @param completed
     */
    constructor(title: String?, description: String?, id: String?, completed: Boolean) {
        mId = id
        mTitle = title
        mDescription = description
        mCompleted = completed
    }

    /**
     * タスクタイトルの取得.
     * もしタスクタイトルが入力されていない場合には説明文を返す
     */
    fun getTitleForList(): String {
        if (mTitle != null && !mTitle.equals("")) {
            return mTitle as String
        } else {
            return mDescription as String
        }
    }

    fun isCompleted(): Boolean {
        return mCompleted
    }

    fun isActive(): Boolean {
        return !mCompleted
    }

    fun isEmpty(): Boolean {
        return (mId == null || mId.equals( "") &&
                mTitle == null || mTitle.equals(""))
    }

    fun getId(): String? {
        return mId
    }

    fun getTitle(): String? {
        return mTitle
    }

    fun getDescription(): String? {
        return mDescription
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        val task: Task = other as Task
        return Objects.equals(mId, task.mId) &&
                Objects.equals(mTitle, task.mTitle) &&
                Objects.equals(mDescription, task.mDescription)
    }

    override fun toString(): String {
        return "Task with Title $mTitle"
    }
}