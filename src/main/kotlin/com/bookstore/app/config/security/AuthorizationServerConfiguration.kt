package com.bookstore.app.config.security

import com.bookstore.app.config.security.UserDetailsServiceImpl
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler
import org.springframework.security.oauth2.provider.token.TokenStore
import javax.sql.DataSource

@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfiguration(
		private val tokenStore: TokenStore,
		private val userApprovalHandler: UserApprovalHandler,
		private val authenticationManager: AuthenticationManager,
		private val customUserDetailsService: UserDetailsServiceImpl,
		private val passwordEncoder: PasswordEncoder,
		private val dataSource: DataSource
) : AuthorizationServerConfigurerAdapter() {

	@Throws(Exception::class)
	override fun configure(clients: ClientDetailsServiceConfigurer) {
		clients.inMemory()
			.withClient("fooClientId").secret(BCryptPasswordEncoder().encode("secret"))
			.authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes("read", "write")
			.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT", "USER", "ADMIN")
			.autoApprove(true)
			.accessTokenValiditySeconds(600) //Access token is only valid for 3 minutes.
			.refreshTokenValiditySeconds(600) //Refresh token is only valid for 10 minutes.;
	}

	@Throws(Exception::class)
	override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
		endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
				.authenticationManager(authenticationManager).userDetailsService(customUserDetailsService)
	}
	
}