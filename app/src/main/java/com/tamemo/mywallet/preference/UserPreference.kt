package com.tamemo.mywallet.preference

import android.content.Context
import android.content.SharedPreferences

class UserPreference(sharedPreferences: SharedPreferences) : BasePreference(sharedPreferences) {

    companion object{
        val domain = "user-pref"
        val mode = Context.MODE_PRIVATE
    }

    private val USER_ID = "user_id"

    var userId: Int?
        get() {
            return when (val id = getInt(USER_ID, 0)) {
                0 -> null
                else -> id
            }
        }
        set(id) {
            edit().putInt(USER_ID, id ?: 0).apply()
        }

}