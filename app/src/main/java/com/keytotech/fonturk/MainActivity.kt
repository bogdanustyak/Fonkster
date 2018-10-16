package com.keytotech.fonturk

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.keytotech.fonkster.Fonkster
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fontLink = "https://site.com/fontFile.ttf"
        val fontFileName = "fontFile.ttf"
        tv_text.typeface = Fonkster(baseContext, fontLink, fontFileName).typeFace()
    }
}
