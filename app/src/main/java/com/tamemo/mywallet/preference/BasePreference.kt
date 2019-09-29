package com.tamemo.mywallet.preference

import android.content.SharedPreferences

open class BasePreference internal constructor(private val mSharedPreferences: SharedPreferences) : SharedPreferences {

    override fun getAll(): Map<String, *> {
        return mSharedPreferences.all
    }

    override fun getString(key: String, defValue: String?): String? {
        return try {
            mSharedPreferences.getString(key, defValue)
        } catch (e: ClassCastException) {
            handleInvalidType(key, e)
            defValue
        }

    }

    override fun getStringSet(key: String, defValues: Set<String>?): Set<String>? {
        return try {
            mSharedPreferences.getStringSet(key, defValues)
        } catch (e: ClassCastException) {
            handleInvalidType(key, e)
            defValues
        }

    }

    override fun getInt(key: String, defValue: Int): Int {
        return try {
            mSharedPreferences.getInt(key, defValue)
        } catch (e: ClassCastException) {
            handleInvalidType(key, e)
            defValue
        }

    }

    override fun getLong(key: String, defValue: Long): Long {
        return try {
            mSharedPreferences.getLong(key, defValue)
        } catch (e: ClassCastException) {
            handleInvalidType(key, e)
            defValue
        }

    }

    override fun getFloat(key: String, defValue: Float): Float {
        return try {
            mSharedPreferences.getFloat(key, defValue)
        } catch (e: ClassCastException) {
            handleInvalidType(key, e)
            defValue
        }

    }

    override fun getBoolean(key: String, defValue: Boolean): Boolean {
        return try {
            mSharedPreferences.getBoolean(key, defValue)
        } catch (e: ClassCastException) {
            handleInvalidType(key, e)
            defValue
        }

    }

    override fun contains(key: String): Boolean {
        return mSharedPreferences.contains(key)
    }

    override fun edit(): SharedPreferences.Editor {
        return mSharedPreferences.edit()
    }

    override fun registerOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        mSharedPreferences.registerOnSharedPreferenceChangeListener(listener)
    }

    override fun unregisterOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        mSharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
    }

    private fun handleInvalidType(key: String, e: ClassCastException) {
        throw e
    }

    private fun removeInvalidKey(key: String) {
        edit().remove(key)
                .apply()
    }

    companion object {

        fun from(sharedPreferences: SharedPreferences): BasePreference {
            return BasePreference(sharedPreferences)
        }
    }
}
