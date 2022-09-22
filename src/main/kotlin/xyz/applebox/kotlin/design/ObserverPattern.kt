package xyz.applebox.kotlin.design

import java.util.Observable
import java.util.Observer

class Coffee(val name: String)

class Barista : Observable() {
    private lateinit var coffeeName: String

    fun orderCoffee(name: String) {
        this.coffeeName = name
    }

    fun makeCoffee() {
        setChanged()
        notifyObservers(Coffee(this.coffeeName))
    }
}

class Customer(val name: String): Observer {
    override fun update(o: Observable?, arg: Any?) {
        val coffee = arg as Coffee
        println("${name}이(가) ${coffee.name}을(를) 받았습니다.")
    }
}

fun main() {
    val barista = Barista()
    barista.orderCoffee("아이스 라떼")

    val customer1 = Customer("jini")
    val customer2 = Customer("sol")
    val customer3 = Customer("coco")
    barista.addObserver(customer1)
    barista.addObserver(customer2)
    barista.addObserver(customer3)
    barista.makeCoffee()
}