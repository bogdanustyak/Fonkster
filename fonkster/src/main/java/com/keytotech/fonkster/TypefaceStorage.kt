package com.keytotech.fonkster

import android.graphics.Typeface
import android.util.Log
import android.util.LruCache
import java.io.File

/**
 * TypefaceStorage
 *
 * Resolving typeface from local file and caching it in memory.
 *
 * @author Rostik Balagurak (rostikbalagurak@gmail.com)
 */
class TypefaceStorage {

    private val cache: LruCache<String, Typeface>

    init {
        val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()

        // Use 10% of the available memory for this memory cache.
        cache = LruCache(maxMemory / 10)
    }

    /**
     * Initializes typeface from file and caches it in device memory
     *
     * @param assetPath - name of the file to store locally
     * @return typeface of the font
     */
    fun get(assetPath: String): Typeface? {
        synchronized(cache) {
            if (cache.get(assetPath) == null) {
                try {
                    cache.put(assetPath, Typeface.createFromFile(File(assetPath)))
                } catch (e: Exception) {
                    Log.e(Fonkster.TAG, "Could not get typeface '" + assetPath
                            + "' because " + e.message)
                    return null
                }
            }
            return cache[assetPath]
        }
    }

    companion object {
        /**
         * Singleton instance of TypefaceStorage
         */
        val instance: TypefaceStorage by lazy {
            return@lazy TypefaceStorage()
        }
    }
}