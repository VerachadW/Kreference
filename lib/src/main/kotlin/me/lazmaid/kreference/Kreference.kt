package me.lazmaid.kreference

import android.content.Context
import android.content.SharedPreferences
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

    fun String(context: Context, default: String = "") : ReadWriteProperty<Any?, String> = PreferenceDelegate(context, default)
    fun Long(context: Context, default: Long = 0L) : ReadWriteProperty<Any?, Long> = PreferenceDelegate(context, default)
    fun Int(context: Context, default: Int = 0) : ReadWriteProperty<Any?, Int> = PreferenceDelegate(context, default)
    fun Float(context: Context, default: Float = 0f) : ReadWriteProperty<Any?, Float> = PreferenceDelegate(context, default)
    fun Boolean(context: Context, default: Boolean = false) : ReadWriteProperty<Any?, Boolean> = PreferenceDelegate(context, default)

    fun clearAll(context: Context) {
        val prefName = context.defaultKreferenceName
        val editor = context.applicationContext.getSharedPreferences(prefName, Context.MODE_PRIVATE).edit()
        editor.clear()
        editor.apply()
    }

    private class PreferenceDelegate<T>(context: Context, val defaultValue: T) : ReadWriteProperty<Any?, T> {
        lateinit var appContext: Context

        val prefName by lazy {
            appContext.defaultKreferenceName
        }

        init {
            appContext = context.applicationContext
        }

        private var value = defaultValue

        override fun get(thisRef: Any?, property: PropertyMetadata): T {
            @Suppress("unchecked_cast")
            when (value) {
                is String -> value = sharedPreferences.getString(property.name, defaultValue as String) as T
                is Float -> value = sharedPreferences.getFloat(property.name, defaultValue as Float) as T
                is Int -> value = sharedPreferences.getInt(property.name, 0) as T
                is Boolean -> value = sharedPreferences.getBoolean(property.name, false) as T
                is Long -> value = sharedPreferences.getLong(property.name, 0L) as T
            }
            return value
        }

        protected val sharedPreferences: SharedPreferences = appContext.getSharedPreferences(prefName, Context.MODE_PRIVATE)

        override fun set(thisRef: Any?, property: PropertyMetadata, value: T) {
            val editor = sharedPreferences.edit()
            when (value) {
                is String -> editor.putString(property.name, value)
                is Float -> editor.putFloat(property.name, value)
                is Int -> editor.putInt(property.name, value)
                is Boolean -> editor.putBoolean(property.name, value)
                is Long -> editor.putLong(property.name, value)
            }
            this.value = value
            editor.apply()

        }


    }
}

