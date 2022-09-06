package xyz.applebox.kotlin.gettersetter

fun main() {
    val person = Person()
    person.name = "코코"
    person.age = 28
    person.setAddress("서초구")

    println(person.name)
    println(person.age)
    println(person.uuid)
    println(person.myAddress())
}