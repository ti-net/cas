package com.tinet.cas.authentication;

import javax.security.auth.login.LoginException;

public class VoiceCodeAuthenticationException extends LoginException {

	private static final long serialVersionUID = 2134986869630732646L;

	/**
	 * Constructs a TicketCreationException with the default exception code.
	 */
	public VoiceCodeAuthenticationException() {
	}

	/**
	 * Constructs a TicketCreationException with the default exception code and
	 * the original exception that was thrown.
	 * 
	 * @param throwable
	 *            the chained exception
	 */
	public VoiceCodeAuthenticationException(final String msg) {
		super(msg);
	}
}
