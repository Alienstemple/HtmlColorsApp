package com.example.htmlcolorsapp.data

data class HtmlColorMain(
    val htmlName: String,
    val hex: String,
    val rgb: String
) {
    data class HtmlColorSecondary(
        val hex: String
    )
}