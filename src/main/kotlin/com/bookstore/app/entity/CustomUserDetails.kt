package com.bookstore.app.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(user: User) : UserDetails {
	private val username: String = user.username
	private val password: String = user.passw
	private val authorities: Collection<out GrantedAuthority>
	val id: Int

	companion object {
		private val serialVersionUID = 1L
	}

	init {
		this.authorities = translate(user)
		this.id  = user.id
	}

	private fun translate(user: User): Collection<out GrantedAuthority> {
		val authorities = ArrayList<GrantedAuthority>()
		authorities.add(SimpleGrantedAuthority("ROLE_"+user.role))
		return authorities
	}

	override fun getAuthorities(): Collection<out GrantedAuthority> {
		return authorities
	}

	override fun getPassword(): String {
		return password
	}

	override fun getUsername(): String {
		return username
	}

	override fun isAccountNonExpired(): Boolean {
		return true
	}

	override fun isAccountNonLocked(): Boolean {
		return true
	}

	override fun isCredentialsNonExpired(): Boolean {
		return true
	}

	override fun isEnabled(): Boolean {
		return true
	}

}
