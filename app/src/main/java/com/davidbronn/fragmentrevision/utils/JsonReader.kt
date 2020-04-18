package com.davidbronn.fragmentrevision.utils

import android.content.Context
import androidx.annotation.RawRes
import com.google.gson.Gson
import java.lang.reflect.Type
import java.util.*

/**
 * Created by Jude on 17/April/2020
 */

inline fun <reified T> String.jsonify(typeToken: Type): T? {
    return Gson().fromJson(this, typeToken)
}

fun Context.readRawString(@RawRes rawId: Int): String {
    val stream = resources.openRawResource(rawId)
    val s = Scanner(stream).useDelimiter("\\A")
    return if (s.hasNext()) s.next() else ""
}