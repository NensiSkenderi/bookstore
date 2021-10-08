package com.bookstore.app.config.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer

@Configuration
@EnableResourceServer
class ResourceServerConfiguration : ResourceServerConfigurerAdapter() {
	override fun configure(resources: ResourceServerSecurityConfigurer) {
		resources.resourceId(RESOURCE_ID).stateless(false)
	}

	@Throws(Exception::class)
	override fun configure(http: HttpSecurity) {
		http
			.authorizeRequests()
			.antMatchers("/**").permitAll();
	}

	companion object {
		private val RESOURCE_ID = "rest_api"
	}
}