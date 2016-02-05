package com.github.verachadw.test

import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config
import org.robolectric.manifest.AndroidManifest
import org.robolectric.res.FileFsFile

/**
 * Created by verachadw on 10/3/2015 AD.
 */
public class CustomRobolectricTestRunner(private val clazz: Class<*>) : RobolectricGradleTestRunner(clazz) {

    override fun getAppManifest(config: Config): AndroidManifest {
        val appManifest = super.getAppManifest(config)
        var androidManifestFile = appManifest.androidManifestFile

        if (androidManifestFile.exists()) {
            return appManifest
        } else {
            val moduleRoot = getModuleRootPath(config)
            androidManifestFile = FileFsFile.from(moduleRoot, appManifest.androidManifestFile.path)
            val resDirectory = FileFsFile.from(moduleRoot, appManifest.androidManifestFile.path.replace("AndroidManifest.xml", "res"))
            val assetsDirectory = FileFsFile.from(moduleRoot, appManifest.androidManifestFile.path.replace("AndroidManifest.xml", "assets"))
            return AndroidManifest(androidManifestFile, resDirectory, assetsDirectory)
        }
    }

    private fun getModuleRootPath(config: Config): String {
        val moduleRoot = config.constants.java.getResource("").toString()
        return moduleRoot.substring(0, moduleRoot.indexOf("/build"))
    }
}