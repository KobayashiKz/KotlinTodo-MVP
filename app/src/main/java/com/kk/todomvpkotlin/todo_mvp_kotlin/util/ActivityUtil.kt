package com.kk.todomvpkotlin.todo_mvp_kotlin.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

class ActivityUtil {

    companion object {

        /**
         * Activityに対してFragmentをaddする
         *
         * @param fragmentManager   FragmentManager
         * @param fragment          addする対象のFragment
         * @param frameId           addするレイアウトID
         */
        fun addFragmentToActivity(
            fragmentManager: FragmentManager, fragment: Fragment, frameId: Int) {
            checkNotNull(fragmentManager)
            checkNotNull(fragment)
            val transaction = fragmentManager.beginTransaction()
            transaction.add(frameId, fragment)
            transaction.commit()
        }
    }
}