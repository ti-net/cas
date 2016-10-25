package com.tinet.cas.authentication;

import javax.security.auth.login.LoginException;

/**
 * The exception to throw when we know the authcoe is not correct
 * 
 * @author Scott Battaglia
 * @version 3.0
 * @since 3.0
 */
public class SecurityCodeAuthenticationException extends LoginException {

	private static final long serialVersionUID = 3908895176574055757L;

	/**
	 * Constructs a TicketCreationException with the default exception code.
	 */
	public SecurityCodeAuthenticationException() {
	}

	/**
	 * Constructs a TicketCreationException with the default exception code and
	 * the original exception that was thrown.
	 * 
	 * @param throwable
	 *            the chained exception
	 */
	public SecurityCodeAuthenticationException(final String msg) {
		super(msg);
	}
}