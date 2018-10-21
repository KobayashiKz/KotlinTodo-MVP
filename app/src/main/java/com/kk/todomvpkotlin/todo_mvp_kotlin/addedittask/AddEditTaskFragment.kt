package com.kk.todomvpkotlin.todo_mvp_kotlin.addedittask

import android.support.v4.app.Fragment

class AddEditTaskFragment: Fragment(){


    companion object {
        val ARGUMENT_EDIT_TASK_ID = "EDIT_TASK_ID"

        fun newInstance(): AddEditTaskFragment {
            return AddEditTaskFragment()
        }
    }
}