package com.gouresh.restapidemo.exceptions

class StudentNotFoundException(private val errorMessage : String) : RuntimeException(errorMessage)