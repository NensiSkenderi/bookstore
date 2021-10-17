package com.bookstore.app.utils

import com.bookstore.app.entity.ApplicationUserRole
import com.bookstore.app.entity.CustomUserDetails
import org.springframework.security.core.context.SecurityContextHolder

object Helper {

    fun getAuthenticatedUser(): CustomUserDetails? {
        return if (SecurityContextHolder.getContext().authentication.principal is CustomUserDetails) {
            SecurityContextHolder.getContext().authentication.principal as CustomUserDetails
        } else {
            null
        }
    }

    fun isAdmin(): Boolean {
        val authenticatedUser = getAuthenticatedUser()?.authorities
        if (authenticatedUser != null) {
            if(authenticatedUser.first().authority == "ROLE_"+ApplicationUserRole.ADMIN.name)
                return true
        }
        return false
    }
}
