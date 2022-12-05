package xyz.applebox.kotlin.solid

import kotlin.math.pow

//interface Shape
//
//data class Triangle(val width: Int, val height: Int):Shape {
//}
//data class Circle(val radius: Int):Shape {
//}
//
//data class ShapeCalculator(val shapes: List<Shape>) {
//    fun sum(): Double {
//        return shapes.stream()
//            .mapToDouble {
//                when (it) {
//                    is Triangle -> it.width * it.height / 2.0
//                    is Circle -> Math.PI * it.radius.toDouble().pow(2)
//                    else -> 0.0
//                }
//            }
//            .sum()
//    }
//}
//fun main() {
//    val shapes = listOf(Triangle(3, 5), Triangle(6, 6), Circle(5))
//    println(ShapeCalculator(shapes).sum())
//}

interface Shape {
    fun getArea(): Double
}

data class Triangle(val width: Int, val height: Int): Shape {
    override fun getArea(): Double {
        return width * height / 2.0
    }
}
data class Circle(val radius: Int):Shape {
    override fun getArea(): Double {
        return Math.PI * radius.toDouble().pow(2)
    }
}

data class AreaCalculator(val shapes: List<Shape>) {
    fun sum(): Double {
        return shapes.stream()
            .mapToDouble(Shape::getArea)
            .sum()
    }
}
fun main() {
    val shapes = listOf(Triangle(3, 5), Triangle(6, 6), Circle(5))
    println(AreaCalculator(shapes).sum())
}