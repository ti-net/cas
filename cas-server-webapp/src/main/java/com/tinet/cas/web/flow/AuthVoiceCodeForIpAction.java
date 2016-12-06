package com.tinet.cas.web.flow;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jasig.cas.authentication.Credential;
import org.jasig.cas.web.bind.CredentialsBinder;
import org.jasig.cas.web.support.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.webflow.core.collection.LocalAttributeMap;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinet.cas.authentication.UsernamePasswordSecurityCodeCredential;
import com.tinet.cas.authentication.VoiceCodeAuthenticationException;

public class AuthVoiceCodeForIpAction {

	/** Authentication success result. */
	public static final String SUCCESS = "success";
	/** Error result. */
	public static final String ERROR = "error";
	/** Code Error result. */
	public static final String CODE_ERROR = "codeError";

	/**
	 * Binder that allows additional binding of form object beyond Spring
	 * defaults.
	 */
	private CredentialsBinder credentialsBinder;
	/** Logger instance. **/
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public final void doBind(final RequestContext context, final Credential credential) throws Exception {
		final HttpServletRequest request = WebUtils.getHttpServletRequest(context);

		if (this.credentialsBinder != null && this.credentialsBinder.supports(credential.getClass())) {
			this.credentialsBinder.bind(request, credential);
		}
	}

	public final Event authVoiceCode(final RequestContext context, final Credential credential,
			final MessageContext messageContext) throws Exception {

		final HttpServletRequest request = WebUtils.getHttpServletRequest(context);
		HttpSession session = request.getSession();
		UsernamePasswordSecurityCodeCredential upsc = (UsernamePasswordSecurityCodeCredential) credential;

		String result = (String) session.getAttribute("notwhiteip_voicecode_result");
		
		ObjectMapper mapper = new ObjectMapper();
		JavaType javaType = mapper.getTypeFactory().constructParametrizedType(LinkedHashMap.class, LinkedHashMap.class,
				String.class, Object.class);
		
		Map<String, Object> resultMap = mapper.readValue(result, javaType);
		Long voiceCodeTimestamp = Long.parseLong(resultMap.get("timestamp").toString());

		if (new Date().getTime() - voiceCodeTimestamp <= 300000) {
			if (upsc.getVoiceCode().equals(resultMap.get("value").toString())) {
				session.removeAttribute("notwhiteip_voicecode_result");
				return newEvent(SUCCESS);
			} else {
				Integer errorcount = new Integer(1);
				if(resultMap.get("errorcount") != null){
					errorcount = Integer.parseInt(resultMap.get("errorcount").toString());
					errorcount++;
				}
				if(errorcount <= 4){
					resultMap.put("errorcount", errorcount);
					result = mapper.writeValueAsString(resultMap);
					request.getSession().setAttribute("notwhiteip_voicecode_result", result);
					
					messageContext.addMessage(new MessageBuilder().error().arg(errorcount)
							.code("authenticationFailure.VoiceCodeAuthenticationException").build());
					return newEvent(CODE_ERROR, new VoiceCodeAuthenticationException());
					
				} else {
					messageContext.addMessage(new MessageBuilder().error().code("语音验证码输入错误次数过多！").build());
					return newEvent(ERROR, new Exception());					
				}
			}
		} else {
			messageContext.addMessage(new MessageBuilder().error().code("语音验证码超时!").build());
			return newEvent(ERROR, new Exception());
		}
	}

	private Event newEvent(final String id) {
		return new Event(this, id);
	}

	private Event newEvent(final String id, final Exception error) {
		return new Event(this, id, new LocalAttributeMap("error", error));
	}

	/**
	 * Set a CredentialsBinder for additional binding of the HttpServletRequest
	 * to the Credential instance, beyond our default binding of the Credential
	 * as a Form Object in Spring WebMVC parlance. By the time we invoke this
	 * CredentialsBinder, we have already engaged in default binding such that
	 * for each HttpServletRequest parameter, if there was a JavaBean property
	 * of the Credential implementation of the same name, we have set that
	 * property to be the value of the corresponding request parameter. This
	 * CredentialsBinder plugin point exists to allow consideration of things
	 * other than HttpServletRequest parameters in populating the Credential (or
	 * more sophisticated consideration of the HttpServletRequest parameters).
	 *
	 * @param credentialsBinder
	 *            the credential binder to set.
	 */
	public final void setCredentialsBinder(final CredentialsBinder credentialsBinder) {
		this.credentialsBinder = credentialsBinder;
	}

}
