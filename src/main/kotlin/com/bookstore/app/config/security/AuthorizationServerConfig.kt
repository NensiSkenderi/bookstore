package com.bookstore.app.config.security

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer //enables an authorization server
class AuthorizationServerConfig : AuthorizationServerConfigurerAdapter() {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    lateinit var userDetailsService: UserDetailsService

    @Throws(Exception::class)
    override fun configure(oauthServer: AuthorizationServerSecurityConfigurer) {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()")
    }

    /*
    Registers a client with client-id ‘fooClientId’
    and password ‘ secret’ and the roles and scope they are allowed.
     */
    @Throws(Exception::class)
    override fun configure(clients: ClientDetailsServiceConfigurer) {
        clients.inMemory()
            .withClient("fooClientId").secret("secret")
            .authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes("read", "write")
            .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT", "USER", "ADMIN")
            .autoApprove(true)
            .accessTokenValiditySeconds(600) //Access token is only valid for 3 minutes.
            .refreshTokenValiditySeconds(600) //Refresh token is only valid for 10 minutes.;
    }

    @Throws(Exception::class)
    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager)
            .accessTokenConverter(defaultAccessTokenConverter()).userDetailsService(userDetailsService)
    }

    //JwtTokenStore encodes token-related data into the token itself
    /*
    JwtTokenStore is a TokenStore implementation that just reads data from the tokens
    themselves. Not really a store since it never persists anything,
    and methods like getAccessToken(OAuth2Authentication)
    always return null. But nevertheless a useful tool since
    it translates access tokens to and from authentications.
    Use this wherever a TokenStore is needed
     */
    @Bean
    fun tokenStore(): TokenStore? {
        return JwtTokenStore(defaultAccessTokenConverter())
    }

    @Bean
    fun defaultAccessTokenConverter(): JwtAccessTokenConverter {
        val converter = JwtAccessTokenConverter()
        converter.setSigningKey("123")
        return converter
    }
}