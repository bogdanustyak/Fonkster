package com.keytotech.fonkster

import android.content.Context
import android.graphics.Typeface
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking
import java.io.File


/**
 * Fonkster
 *
 * Dynamically loading fonts from URL.
 *
 * @property context - Base context
 * @property fontUrl - url of the font file
 * @property fontFileName - name of the file to store locally
 *
 * @author Bogdan Ustyak (bogdan.ustyak@gmail.com)
 */
class Fonkster(private val context: Context,
               private val fontUrl: String,
               private val fontFileName: String) {


    /**
     * Loads font from URL
     * Uses Kotlin's coroutines to sync job.
     *
     * @return typeface of the font
     */
    fun typeFace(): Typeface? = runBlocking {
        val localFilePath = context.filesDir.absolutePath + "/" + fontFileName
        val loadedFontPath = GlobalScope.async {
            FileDownloader().download(
                    fontUrl,
                    localFilePath
            )
        }.await()
        if (loadedFontPath != null && File(loadedFontPath).exists()) {
            Typeface.createFromFile(File(loadedFontPath))
        } else {
            null
        }
    }
}