package com.testrecruitment.penjualan.data.local

import android.content.Context
import com.testrecruitment.penjualan.until.App

object AppSharedPreference {

    private const val APP_SHARED_PREFERENCES = "app_shared_preferences"
    private const val KEY_IS_LOGIN = "key_is_login"
    private const val KEY_ID = "key_id"
    private const val KEY_USERNAME = "key_username"
    private const val USER_TOKEN = "user_token"
    private const val KEY_EMAIL = "key_email"

    private val sharedPreference =
        App.context.get()?.getSharedPreferences(APP_SHARED_PREFERENCES, Context.MODE_PRIVATE)

    var isLogin: Boolean?
        get() = sharedPreference?.getBoolean(KEY_IS_LOGIN, false)
        set(value) {
            if (value != null) {
                sharedPreference?.edit()?.putBoolean(KEY_IS_LOGIN, value)?.apply()
            }
        }

    var id: Int?
        get() = sharedPreference?.getInt(KEY_ID, 0)
        set(value) {
            if (value != null) {
                sharedPreference?.edit()?.putInt(KEY_ID, value)?.apply()
            }
        }

    var userToken: String?
        get() = sharedPreference?.getString(USER_TOKEN, "")
        set(value) {
            if (value != null) {
                sharedPreference?.edit()?.putString(USER_TOKEN, value)?.apply()
            }
        }

    var username: String?
        get() = sharedPreference?.getString(KEY_USERNAME, "")
        set(value) {
            sharedPreference?.edit()?.putString(KEY_USERNAME, value)?.apply()
        }

    var email: String?
        get() = sharedPreference?.getString(KEY_EMAIL, "")
        set(value) {
            if (value != null) {
                sharedPreference?.edit()?.putString(KEY_EMAIL, value)?.apply()
            }
        }


}