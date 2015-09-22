#Kreference
Simple Android Preference library written in Kotlin.

##Overview
When you want to get/set a String in SharedPreference in Android. You need this bunch of code
```
    object PreferenceHelper {
        fun getMyPrefString(context: Context): String? {
            val preference = context.getSharedPreferences("myPref", Context.MODE_PRIVATE)
            return preference.getString("myString")
        }

        fun setMyPrefString(context: Context, newString) {
            val preference = context.getSharedPreferences("myPref", Context.MODE_PRIVATE)
            val editor = preference.edit()
            editor.putString("myString", new String)
            editor.apply()
        }
    }

    // Get value in Activity
    PreferenceHelper.getMyPrefString(this)
    // Set value in Activity
    PreferenceHelper.setMyPrefString(this, "This is not simple :(")
```

A lot of work just to handle 1 item. Is it better if you can write those stuff as one-liner, or even better no need for singleton class declaration? Kreference make that happen for you. Here is how we declare ```myString``` with Kreference.
```
    // Declare in Activity. No need for additional class.
    private val myString by Kreference.asString(this)
    ...
    // Use it as same as variable in activity
    textView.setText(myString)
    myString = "This is simple and lovely :)"
```

Since Kreference used the variable's name as a key of preference item, You can easily access preference item in different classes by using the same variable name.
 ```
     object MyPref1 {
        val myTime by Kreference.asLong(this)
     }

     object MyPref2 {
        val myTime by Kreference.asLong(this)
     }

    // This is true
     MyPref1.myTime == MyPref2.myTime
 ```

##Features
    - One line Preference declaration
    - Null-Safety
    - Allow default value for preference item
    - Support ```Date``` as preference item with ```Kreference.asDate()```

##Need more features?
    Fork it and send PR to me.

##Licensce
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
