package com.keytotech.fonkster

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking

/**
 * Fonkster
 *
 * Dynamically loading fonts from URL.
 *
 * @property context - Base context
 *
 * @author Bogdan Ustyak (bogdan.ustyak@gmail.com)
 */
class Fonkster private constructor(private val context: Context) {

    private val typefaceStorage = TypefaceStorage.instance

    /**
     * Loads font from URL
     * Uses Kotlin's coroutines to sync job.
     *
     * @param fontUrl - url of the font file
     * @param fontFileName - name of the file to store locally
     * @return typeface of the font
     */
    fun typeFace(fontUrl: String,
                 fontFileName: String): Typeface? = runBlocking {
        try {
            val localFilePath = context.filesDir.absolutePath + "/" + fontFileName
            val loadedFontPath = GlobalScope.async {
                FileDownloader().download(
                        fontUrl,
                        localFilePath
                )
            }.await()
            return@runBlocking if (loadedFontPath == null) null else typefaceStorage.get(loadedFontPath)
        } catch (e: Exception) {
            Log.e(Fonkster.TAG, "Could not get typeface '" + fontFileName
                    + "' because " + e.message)
            return@runBlocking null
        }
    }

    companion object {
        const val TAG: String = "Fonkster"

        fun with(context: Context): Fonkster {
            return Fonkster(context)
        }
    }
}