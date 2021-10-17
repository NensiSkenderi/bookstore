package com.bookstore.app.entity

enum class ApplicationUserPermission (
    var STUDENT_READ: ApplicationUserPermission? = null,
    var STUDENT_WRITE: ApplicationUserPermission? = null,
    var COURSE_READ: ApplicationUserPermission? = null,
    var COURSE_WRITE: ApplicationUserPermission? = null
)