package com.keytotech.fonkster

import java.io.File
import java.io.FileOutputStream
import java.net.URL

/**
 * FileDownloader
 *
 * @author Bogdan Ustyak (bogdan.ustyak@gmail.com)
 */
class FileDownloader {

    /**
     * Downloads file to path
     * Checks if file already exists.
     *
     * @param link - file URL to download
     * @param path - local path to save file
     *
     * @return  path of downloaded file. If file exists already - it's path.
     * If couldn't download returns null.
     */
    fun download(link: String, path: String): String? {
        var downloadedFilePath: String? = null
        if (!File(path).exists()) {
            val input = URL(link).openStream()
            val output = FileOutputStream(File(path))
            input.use { _ ->
                output.use { _ ->
                    input.copyTo(output)
                    downloadedFilePath = path
                }
            }
        } else {
            downloadedFilePath = path
        }
        return downloadedFilePath
    }
}