package com.github.verachadw.test

import com.github.verachadw.kreference.Kreference
import org.junit.Test
import org.hamcrest.CoreMatchers.*
import org.junit.Assert.*
import java.util.*

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
class SetTester : BaseTester() {

    val prefKey = "myPrefKey"

    @Test
    fun test_setPreferenceAsString() {
        val value = "Hello Kreference"
        Kreference.set(mockContext, prefKey, value)

        assert(preference.contains(prefKey))

        val actual = preference.getString(prefKey, "")

        assertThat(value, `is`(actual))
    }

    @Test
    fun test_setPreferenceAsInt() {
        val value = 150
        Kreference.set(mockContext, prefKey, value)

        assert(preference.contains(prefKey))

        val actual = preference.getInt(prefKey, 0)

        assertThat(value, `is`(actual))
    }

    @Test
    fun test_setPreferenceAsLong() {
        val value = 150L
        Kreference.set(mockContext, prefKey, value)

        assert(preference.contains(prefKey))

        val actual = preference.getLong(prefKey, 0L)

        assertThat(value, `is`(actual))
    }

    @Test
    fun test_setPreferenceAsFloat() {
        val value = 150f
        Kreference.set(mockContext, prefKey, value)

        assert(preference.contains(prefKey))

        val actual = preference.getFloat(prefKey, 0f)

        assertThat(value, `is`(actual))
    }

    @Test
    fun test_setPreferenceAsBoolean() {
        val value = true
        Kreference.set(mockContext, prefKey, value)

        assert(preference.contains(prefKey))

        val actual = preference.getBoolean(prefKey, false)

        assertThat(value, `is`(actual))
    }

    @Test
    fun test_setPreferenceAsDate() {
        val value = Date()
        Kreference.set(mockContext, prefKey, value)

        assert(preference.contains(prefKey))

        val actual = preference.getLong(prefKey, 0L)

        assertThat(value, `is`(Date(actual)))
    }
}