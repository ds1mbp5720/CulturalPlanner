package com.lee.culturalplanner.util

import android.graphics.Typeface
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.lee.culturalplanner.R
import com.lee.culturalplanner.R.*

fun TextView.bold() {
    setTypeface(ResourcesCompat.getFont(context, font.bmjua_ttf), Typeface.BOLD)
}

fun TextView.normal() {
    setTypeface(ResourcesCompat.getFont(context, font.bmjua_ttf), Typeface.NORMAL)
}

