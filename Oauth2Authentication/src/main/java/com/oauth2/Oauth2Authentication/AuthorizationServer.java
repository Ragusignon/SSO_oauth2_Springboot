package com.oauth2.Oauth2Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@EnableAuthorizationServer
public class AuthorizationServer {
	
	//@Configuration
	
	protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter {

		@Autowired
		private AuthenticationManager authenticationManager;

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints)
				throws Exception {
			endpoints.authenticationManager(authenticationManager);
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			// @formatter:off
			clients.inMemory().withClient("my-trusted-client")
					.authorizedGrantTypes("password", "authorization_code",
							"refresh_token", "implicit")
					.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
					.scopes("read", "write", "trust").resourceIds("sparklr")
					.accessTokenValiditySeconds(60).and()
					.withClient("my-client-with-registered-redirect")
					.authorizedGrantTypes("authorization_code").authorities("ROLE_CLIENT")
					.scopes("read", "trust").resourceIds("sparklr")
					.redirectUris("http://anywhere?key=value").and()
					.withClient("my-client-with-secret")
					.authorizedGrantTypes("client_credentials", "password")
					.authorities("ROLE_CLIENT").scopes("read").resourceIds("sparklr")
					.secret("secret");
			// @formatter:on
		}

	}
}
