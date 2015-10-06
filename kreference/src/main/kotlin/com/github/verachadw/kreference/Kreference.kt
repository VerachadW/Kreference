package com.github.verachadw.kreference

import android.content.Context
import android.content.SharedPreferences
import java.util.Date
import kotlin.properties.ReadWriteProperty

/**
The MIT License (MIT)

Copyright (c) 2015 Verachad Wongsawangtham

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 **/

public object Kreference {

    fun asString(context: Context, default: String = "") : ReadWriteProperty<Any?, String> = PreferenceDelegate(context, default)
    fun asLong(context: Context, default: Long = 0L) : ReadWriteProperty<Any?, Long> = PreferenceDelegate(context, default)
    fun asInt(context: Context, default: Int = 0) : ReadWriteProperty<Any?, Int> = PreferenceDelegate(context, default)
    fun asFloat(context: Context, default: Float = 0f) : ReadWriteProperty<Any?, Float> = PreferenceDelegate(context, default)
    fun asBoolean(context: Context, default: Boolean = false) : ReadWriteProperty<Any?, Boolean> = PreferenceDelegate(context, default)
    fun asDate(context: Context, default: Date = Date(0)) : ReadWriteProperty<Any?, Date?> = PreferenceDelegate(context, default)

    operator fun <T> get(context: Context, key: String, default: T): T {
        val preference = getPreference(context, context.defaultKreferenceName)
        return getPrefValue(preference, key, default)
    }

    operator fun <T> set(context: Context, key: String, value: T) {
        val editor = getPreference(context, context.defaultKreferenceName).edit()
        setPrefValue(editor, key, value)
        editor.apply()
    }

    fun clearAll(context: Context) {
        val editor = getPreference(context, context.defaultKreferenceName).edit()
        editor.clear()
        editor.apply()
    }

    private fun getPreference(context: Context, name: String) =
            context.applicationContext.getSharedPreferences(name, Context.MODE_PRIVATE)

    @Suppress("unchecked_cast")
    private fun <T> getPrefValue(preference: SharedPreferences, name: String, defaultValue: T): T {
        return when (defaultValue) {
            is String -> preference.getString(name, defaultValue) as T
            is Float -> preference.getFloat(name, defaultValue) as T
            is Int -> preference.getInt(name, defaultValue) as T
            is Boolean -> preference.getBoolean(name, defaultValue) as T
            is Long -> preference.getLong(name, defaultValue) as T
            is Date -> {
                val timestamp = preference.getLong(name, defaultValue.time)
                Date(timestamp) as T
            }
            else -> {
                throw IllegalStateException("Not supported Preference type.")
            }
        }
    }

    private fun <T> setPrefValue(editor: SharedPreferences.Editor, name: String, value: T) {
        when (value) {
            is String -> editor.putString(name, value)
            is Float -> editor.putFloat(name, value)
            is Int -> editor.putInt(name, value)
            is Boolean -> editor.putBoolean(name, value)
            is Long -> editor.putLong(name, value)
            is Date -> editor.putLong(name, value.time)
        }
    }

    private class PreferenceDelegate<T>(appContext: Context, val defaultValue: T) : ReadWriteProperty<Any?, T> {

        val prefName by lazy(LazyThreadSafetyMode.NONE) {
            appContext.defaultKreferenceName
        }

        protected val sharedPreferences by lazy(LazyThreadSafetyMode.NONE) {
            appContext.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        }

        private var value = defaultValue

        operator override fun get(thisRef: Any?, property: PropertyMetadata): T {
            value = getPrefValue(sharedPreferences, property.name, defaultValue)
            return value
        }

        operator override fun set(thisRef: Any?, property: PropertyMetadata, value: T) {
            val editor = sharedPreferences.edit()
            setPrefValue(editor, property.name, value)
            this.value = value
            editor.apply()
        }

    }

}

