package com.gouresh.restapidemo.controller

import com.gouresh.restapidemo.entity.Student
import com.gouresh.restapidemo.exceptions.StudentNotFoundException
import jakarta.annotation.PostConstruct
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class StudentRestController {

    val studentsList = mutableListOf<Student>()

    init {
        println("--->>  init")
    }

    @PostConstruct
    fun loadData() {

        println("--->>  loadData")

        val s1 = Student(firstName = "Saish", lastName = "Gawas")
        val s2 = Student(firstName = "Pavan", lastName = "Patil")
        val s3 = Student(firstName = "Raj", lastName = "Maverick")
        studentsList.add(s1)
        studentsList.add(s2)
        studentsList.add(s3)
    }

    @GetMapping("/students")
    fun getStudents(): List<Student> {
        return studentsList
    }

    @GetMapping("/student/{id}")
    fun getStudent(@PathVariable id: Int): Student {
        if (id > studentsList.size-1 || id < 0) {
            throw StudentNotFoundException("Student with Id= $id Not Found")
        }
        return studentsList[id]
    }
}