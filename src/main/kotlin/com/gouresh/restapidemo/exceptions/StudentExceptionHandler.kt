package com.gouresh.restapidemo.exceptions

import com.gouresh.restapidemo.entity.StudentErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class StudentExceptionHandler {

    @ExceptionHandler
    fun handleStudentException(exception: Exception): ResponseEntity<StudentErrorResponse> {
        val errorEntity = StudentErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            message = exception.message ?: "",
            timestamp = System.currentTimeMillis()
        )

        return ResponseEntity(errorEntity, HttpStatus.BAD_REQUEST)
    }
}