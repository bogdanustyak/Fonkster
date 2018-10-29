package com.keytotech.fonturk

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.keytotech.fonkster.Fonkster
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fontLink = "https://drive.google.com/uc?authuser=0&id=1WGF1wU7AyaCvrl-uwo-KeKfLSf7JrC0o&export=download"
        val fontFileName = "fontFile.ttf"

        val fonkster = Fonkster.with(applicationContext)
        tv_text.typeface = fonkster.typeFace(fontLink, fontFileName)

        Handler().postDelayed({
            tv_text_1.typeface = fonkster.typeFace(fontLink, fontFileName)
            tv_text_2.typeface = fonkster.typeFace(fontLink, fontFileName)
        }, 2000)
    }
}