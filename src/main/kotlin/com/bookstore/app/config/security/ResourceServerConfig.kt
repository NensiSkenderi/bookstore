package com.bookstore.app.config.security

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity

import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import java.lang.Exception


@Configuration
@EnableResourceServer //enables a Spring Security filter that authenticates requests using an incoming OAuth2 token
class ResourceServerConfig: ResourceServerConfigurerAdapter() {
    private val RESOURCE_ID = "resource-server-rest-api"

    override fun configure(resources: ResourceServerSecurityConfigurer) {
        resources.resourceId(RESOURCE_ID)
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        /*http.requestMatchers()
                .antMatchers(SECURED_PATTERN).and().authorizeRequests()
                .antMatchers(HttpMethod.POST, SECURED_PATTERN).access(SECURED_WRITE_SCOPE)
                .anyRequest().access(SECURED_READ_SCOPE);*/
        http
            .authorizeRequests()
            .antMatchers("/user","/register").permitAll()
            .anyRequest().authenticated()
    }
}