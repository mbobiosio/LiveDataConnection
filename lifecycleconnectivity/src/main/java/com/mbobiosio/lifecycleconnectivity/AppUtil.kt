package com.mbobiosio.lifecycleconnectivity

import android.os.Build

object AppUtil {

    fun isLollipopUp(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
    }

    fun isMarshMallowUp(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
    }

    fun isNougatUp(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
    }

}