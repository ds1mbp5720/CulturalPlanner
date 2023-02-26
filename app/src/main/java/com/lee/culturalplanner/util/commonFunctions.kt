package com.lee.culturalplanner.util

import android.graphics.Typeface
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.lee.culturalplanner.CulturalPlannerApplication
import com.lee.culturalplanner.R.*

// toast 사용 목적 함수
fun toastMessage(message: String){
    Toast.makeText(CulturalPlannerApplication.getAppInstance(),message, Toast.LENGTH_SHORT).show()
}

fun TextView.bold() {
    setTypeface(ResourcesCompat.getFont(context, font.bmjua_ttf), Typeface.BOLD)
}

fun TextView.normal() {
    setTypeface(ResourcesCompat.getFont(context, font.bmjua_ttf), Typeface.NORMAL)
}