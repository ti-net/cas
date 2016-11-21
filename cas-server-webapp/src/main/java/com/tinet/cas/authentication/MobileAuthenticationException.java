/**
 * 
 */
package com.tinet.cas.authentication;

import javax.security.auth.login.LoginException;

/**
 * @author wangll
 *
 */
public class MobileAuthenticationException extends LoginException {

	private static final long serialVersionUID = -8550513282334114388L;

	public MobileAuthenticationException() {
	}

	public MobileAuthenticationException(final String msg) {
		super(msg);
	}
}
