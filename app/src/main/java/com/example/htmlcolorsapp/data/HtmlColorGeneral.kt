package com.example.htmlcolorsapp.data

sealed class HtmlColorGeneral {
    data class HtmlColorMain (
        val htmlName: String,
        val hex: String,
        val rgb: String
        ): HtmlColorGeneral()
    data class HtmlColorSecondary (
        val hex: String
    ): HtmlColorGeneral()
}