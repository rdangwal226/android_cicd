package com.exmaple.localization

object TranslationManager {
    private var currentLanguage = "en"

    private val translations = mapOf(
        "en" to mapOf(
            "greeting" to "Hello",
            "welcome_message" to "Welcome to our app",
            "switch_language" to "Switch to Arabic"
        ),
        "ar" to mapOf(
            "greeting" to "مرحبا",
            "welcome_message" to "مرحبًا بك في تطبيقنا",
            "switch_language" to "التبديل إلى الإنجليزية"
        )
    )

    fun setLanguage(lang: String) {
        currentLanguage = lang
    }

    fun getLanguage(): String = currentLanguage

    fun getString(key: String): String {
        return translations[currentLanguage]?.get(key) ?: key
    }
}
