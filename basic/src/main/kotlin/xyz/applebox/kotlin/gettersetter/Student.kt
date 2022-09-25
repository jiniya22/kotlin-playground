package xyz.applebox.kotlin.gettersetter

import java.time.LocalDate

class Student {
    @JvmField
    var name: String? = null
    var biratDate: LocalDate? = null
    val age: Int = 10
    var grade: String? = null
        private set
}