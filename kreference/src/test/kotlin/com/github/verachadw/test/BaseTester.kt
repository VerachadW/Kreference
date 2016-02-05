package com.github.verachadw.test

import android.content.Context
import android.content.SharedPreferences
import com.github.verachadw.kreference.BuildConfig
import com.github.verachadw.kreference.defaultKreferenceName
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

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
@RunWith(CustomRobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(21))
abstract class BaseTester {

    lateinit var mockContext: Context
    lateinit var preference: SharedPreferences

    @Before
    fun setUp() {
        mockContext = RuntimeEnvironment.application.applicationContext
        preference = mockContext.getSharedPreferences(mockContext.defaultKreferenceName, Context.MODE_PRIVATE)
    }

    @After
    fun tearDown() {
        preference.edit().clear().apply()
    }

    fun SharedPreferences.edit(f:(SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        f(editor)
        editor.apply()
    }

}

