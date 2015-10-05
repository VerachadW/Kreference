package com.github.verachadw.test

import android.content.Context
import android.content.SharedPreferences
import com.github.verachadw.kreference.BuildConfig
import com.github.verachadw.kreference.Kreference
import com.github.verachadw.kreference.defaultKreferenceName
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import kotlin.test.assertEquals

/**
 * Created by verachadw on 10/3/2015 AD.
 */

@RunWith(CustomRobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(21))
class KreferenceTester {

    lateinit var mockContext: Context
    lateinit var preference: SharedPreferences

    val keyWithValue = "withValue"
    val keyWithOutValue = "withOutValue"

    @Before
    public fun setUp() {
        mockContext = RuntimeEnvironment.application.applicationContext
        preference = mockContext.getSharedPreferences(mockContext.defaultKreferenceName, Context.MODE_PRIVATE)
    }

    @After
    public fun tearDown() {
        preference.edit().clear().apply()
    }

    @Test
    public fun test_GetPreferenceAsDefaultString() {
        val default = "DefaultString"
        val value = Kreference.get(mockContext, keyWithOutValue, default)

        assertEquals(default, value)
    }

    @Test
    public fun test_GetPreferenceAsString() {
        val kValue = Kreference.get(mockContext, keyWithValue, "")
        val pValue = preference.getString(keyWithValue, "")

        assertEquals(pValue, kValue)
    }

    @Test
    public fun test_GetPreferenceAsDefaultInt() {
        val default = 1000
        val value = Kreference.get(mockContext, keyWithOutValue, default)

        assertEquals(default, value)
    }

    @Test
    public fun test_GetPreferenceAsInt() {
        val kValue = Kreference.get(mockContext, keyWithValue, 0)
        val pValue = preference.getInt(keyWithValue, 0)

        assertEquals(pValue, kValue)
    }

    @Test
    public fun test_GetPreferenceAsDefaultFloat() {
        val default = 1000f
        val value = Kreference.get(mockContext, keyWithOutValue, default)

        assertEquals(default, value)
    }

    @Test
    public fun test_GetPreferenceAsFloat() {
        val kValue = Kreference.get(mockContext, keyWithValue, 0f)
        val pValue = preference.getFloat(keyWithValue, 0f)

        assertEquals(pValue, kValue)
    }

    @Test
    public fun test_GetPreferenceAsDefaultLong() {
        val default = 1000L
        val value = Kreference.get(mockContext, keyWithOutValue, default)

        assertEquals(default, value)
    }

    @Test
    public fun test_GetPreferenceAsLong() {
        val kValue = Kreference.get(mockContext, keyWithValue, 0L)
        val pValue = preference.getLong(keyWithValue, 0L)

        assertEquals(pValue, kValue)
    }

    @Test
    public fun test_GetPreferenceAsDefaultBoolean() {
        val default = true
        val value = Kreference.get(mockContext, keyWithOutValue, default)

        assertEquals(default, value)
    }

    @Test
    public fun test_GetPreferenceAsBoolean() {
        val kValue = Kreference.get(mockContext, keyWithValue, false)
        val pValue = preference.getBoolean(keyWithValue, false)

        assertEquals(pValue, kValue)
    }

}