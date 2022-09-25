package xyz.applebox.kotlin.gettersetter;

import java.time.LocalDate;

public class JavaGetterSetterExample {
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "지니";
        student.setBiratDate(LocalDate.of(1992, 11, 11));
        System.out.println(student.name);
        System.out.println(student.getBiratDate());
    }
}
