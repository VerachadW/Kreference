package com.github.verachadw.kreference.sample

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.github.verachadw.kreference.Kreference
import com.github.verachadw.kreference.sample.R

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
class KreferenceSampleActivity : AppCompatActivity() {

    private val textView by lazy {
        findViewById(R.id.textview) as TextView
    }

    /**
     * Kreference uses the name of property as the key of preference item. So, you can easily declare
     * property anywhere you want.
     */
    private var prefText by Kreference.asString(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kreference_sample)

        val message = StringBuilder().apply {
            prefText = "Hello, Kreference"
            append("Before Change:\n")
            append("prefText -> $prefText\n")
            append("SimplePreference.prefText -> ${SimplePreference(this@KreferenceSampleActivity).prefText}\n")
            prefText = "Hello, again"
            append("After Change:\n")
            append("prefText -> $prefText\n")
            append("SimplePreference.prefText -> ${SimplePreference(this@KreferenceSampleActivity).prefText}\n")
        }.toString()

        /**
         * You can also get/set preference item Kreference Object. This is useful when the class is not
         * a child of Context object or no Context object available in constructor.
         *
         * Kreference.get(context = this, key = "prefText", default = "I am Getter")
         * Kreference.set(context = this, key = "prefText", value = "Now, I've become Setter")
         *
         */

        textView.text = message

    }

    class SimplePreference(private val context: Context) {
        var prefText by Kreference.asString(context)
    }

}

