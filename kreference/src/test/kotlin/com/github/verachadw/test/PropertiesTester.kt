package com.github.verachadw.test

import com.github.verachadw.kreference.Kreference
import org.junit.Test
import org.junit.Assert.*
import org.hamcrest.CoreMatchers.*
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
class PropertiesTester : BaseTester() {

    val mockProperty = ""

    @Test
    fun test_GetFromPropertyAsString() {
        val value = "Test Property"

        preference.edit {
            it.putString(PropertiesTester::mockProperty.name, value)
        }

        val property = Kreference.asString(context = mockContext)
        val actual = property.getValue(this, PropertiesTester::mockProperty)

        assertThat(value, `is`(actual))
    }

    @Test
    fun test_SetToPropertyAsString() {
        val value = "Test Get Property"

        val property = Kreference.asString(context = mockContext)
        property.setValue(this, PropertiesTester::mockProperty, value)

        assert(preference.contains(PropertiesTester::mockProperty.name))

        val actual = preference.getString(PropertiesTester::mockProperty.name, "")

        assertThat(value, `is`(actual))
    }

    @Test
    fun test_GetFromPropertyAsInt() {
        val value = 100
        preference.edit {
            it.putInt(PropertiesTester::mockProperty.name, value)
        }

        val property = Kreference.asInt(context = mockContext)
        val actual = property.getValue(this, PropertiesTester::mockProperty)

        assertThat(value, `is`(actual))
    }

    @Test
    fun test_SetToPropertyAsInt() {
        val value = 100

        val property = Kreference.asInt(context = mockContext)
        property.setValue(this, PropertiesTester::mockProperty, value)

        assert(preference.contains(PropertiesTester::mockProperty.name))

        val actual = preference.getInt(PropertiesTester::mockProperty.name, 0)

        assertThat(value, `is`(actual))
    }

    @Test
    fun test_GetFromPropertyAsFloat() {
        val value = 100f
        preference.edit {
            it.putFloat(PropertiesTester::mockProperty.name, value)
        }

        val property = Kreference.asFloat(context = mockContext)
        val actual = property.getValue(this, PropertiesTester::mockProperty)

        assertThat(value, `is`(actual))
    }

    @Test
    fun test_SetToPropertyAsFloat() {
        val value = 100f

        val property = Kreference.asFloat(context = mockContext)
        property.setValue(this, PropertiesTester::mockProperty, value)

        assert(preference.contains(PropertiesTester::mockProperty.name))

        val actual = preference.getFloat(PropertiesTester::mockProperty.name, 0f)

        assertThat(value, `is`(actual))
    }

    @Test
    fun test_GetFromPropertyAsBoolean() {
        val value = true
        preference.edit {
            it.putBoolean(PropertiesTester::mockProperty.name, value)
        }

        val property = Kreference.asBoolean(context = mockContext)
        val actual = property.getValue(this, PropertiesTester::mockProperty)

        assertThat(value, `is`(actual))
    }

    @Test
    fun test_SetToPropertyAsBoolean() {
        val value = true

        val property = Kreference.asBoolean(context = mockContext)
        property.setValue(this, PropertiesTester::mockProperty, value)

        assert(preference.contains(PropertiesTester::mockProperty.name))

        val actual = preference.getBoolean(PropertiesTester::mockProperty.name, false)

        assertThat(value, `is`(actual))
    }

    @Test
    fun test_GetFromPropertyAsLong() {
        val value = 100L
        preference.edit {
            it.putLong(PropertiesTester::mockProperty.name, value)
        }

        val property = Kreference.asLong(context = mockContext)
        val actual = property.getValue(this, PropertiesTester::mockProperty)

        assertThat(value, `is`(actual))
    }

    @Test
    fun test_SetToPropertyAsLong() {
        val value = 100L

        val property = Kreference.asLong(context = mockContext)
        property.setValue(this, PropertiesTester::mockProperty, value)

        assert(preference.contains(PropertiesTester::mockProperty.name))

        val actual = preference.getLong(PropertiesTester::mockProperty.name, 0L)

        assertThat(value, `is`(actual))
    }

    @Test
    fun test_GetFromPropertyAsDateObject() {
        val value = 123456L
        preference.edit {
            it.putLong(PropertiesTester::mockProperty.name, value)
        }

        val property = Kreference.asDate(context = mockContext)
        val actual = property.getValue(this, PropertiesTester::mockProperty)

        assertThat(Date(value), `is`(actual))
    }

    @Test
    fun test_SetToPropertyAsDateObject() {
        val value = Date(123456L)

        val property = Kreference.asDate(context = mockContext)
        property.setValue(this, PropertiesTester::mockProperty, value)

        assert(preference.contains(PropertiesTester::mockProperty.name))

        val actual = preference.getLong(PropertiesTester::mockProperty.name, 0L)

        assertThat(value.time, `is`(actual))
    }

}