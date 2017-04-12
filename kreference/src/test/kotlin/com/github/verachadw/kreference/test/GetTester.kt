package com.github.verachadw.kreference.test

import com.github.verachadw.kreference.Kreference
import com.github.verachadw.kreference.test.BaseTester
import org.junit.Test
import org.junit.Assert.*
import java.util.*
import org.hamcrest.CoreMatchers.*

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
class GetTester : BaseTester(){

    val keyWithValue = "withValue"
    val keyWithOutValue = "withOutValue"

    @Test
    fun test_GetPreferenceAsDefaultString() {
        val default = "DefaultString"
        val value = Kreference.get(mockContext, keyWithOutValue, default)

        assertThat(default, `is`(value))
    }

    @Test
    fun test_GetPreferenceAsString() {
        val pValue = "Hello Kreference"
        preference.edit {
            it.putString(keyWithValue, pValue)
        }
        val kValue = Kreference.get(mockContext, keyWithValue, "")

        assertThat(pValue, `is`(kValue))
    }

    @Test
    fun test_GetPreferenceAsDefaultInt() {
        val default = 1000
        val value = Kreference.get(mockContext, keyWithOutValue, default)

        assertThat(default, `is`(value))
    }

    @Test
    fun test_GetPreferenceAsInt() {
        val pValue = 10
        preference.edit {
            it.putInt(keyWithValue, pValue)
        }
        val kValue = Kreference.get(mockContext, keyWithValue, 0)

        assertThat(pValue, `is`(kValue))
    }

    @Test
    fun test_GetPreferenceAsDefaultFloat() {
        val default = 1000f
        val value = Kreference.get(mockContext, keyWithOutValue, default)

        assertThat(default, `is`(value))
    }

    @Test
    fun test_GetPreferenceAsFloat() {
        val pValue = 10f
        preference.edit {
            it.putFloat(keyWithValue, pValue)
        }
        val kValue = Kreference.get(mockContext, keyWithValue, 0f)

        assertThat(pValue, `is`(kValue))
    }

    @Test
    fun test_GetPreferenceAsDefaultLong() {
        val default = 1000L
        val value = Kreference.get(mockContext, keyWithOutValue, default)

        assertThat(default, `is`(value))
    }

    @Test
    fun test_GetPreferenceAsLong() {
        val pValue = 10L
        preference.edit {
            it.putLong(keyWithValue, pValue)
        }
        val kValue = Kreference.get(mockContext, keyWithValue, 0L)

        assertThat(pValue, `is`(kValue))
    }

    @Test
    fun test_GetPreferenceAsDefaultBoolean() {
        val default = true
        val value = Kreference.get(mockContext, keyWithOutValue, default)

        assertThat(default, `is`(value))
    }

    @Test
    fun test_GetPreferenceAsBoolean() {
        val pValue = true
        preference.edit {
            it.putBoolean(keyWithValue, pValue)
        }
        val kValue = Kreference.get(mockContext, keyWithValue, false)

        assertThat(pValue, `is`(kValue))
    }

    @Test
    fun test_GetPreferenceAsDefaultDateObject() {
        val timestamp = 123456L
        val default = Date(timestamp)
        val value = Kreference.get(mockContext, keyWithOutValue, default)

        assertThat(default, `is`(value))
    }

    @Test
    fun test_GetPreferenceAsDateObject() {
        val pValue = System.currentTimeMillis()
        preference.edit {
            it.putLong(keyWithValue, pValue)
        }
        val kValue = Kreference.get(mockContext, keyWithValue, Date(0L))

        assertThat(kValue, `is`(Date(pValue)))
    }

}