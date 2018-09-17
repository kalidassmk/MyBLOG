package com.gemalto.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.TimeZone;

/**
 * The type Session.
 */
@Document(collection = "session")
public class Session {

	@Id
	private ObjectId _id;

	private String correlationId;
	private String sessionId;
	private String userId;
	private TimeZone timezone;
	private Long sessionCreationTime;

	/**
	 * Gets correlation id.
	 *
	 * @return the correlation id
	 */
	public String getCorrelationId() {
		return correlationId;
	}

	/**
	 * Sets correlation id.
	 *
	 * @param correlationId the correlation id
	 */
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	/**
	 * Gets session id.
	 *
	 * @return the session id
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * Sets session id.
	 *
	 * @param sessionId the session id
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * Gets customer id.
	 *
	 * @return the customer id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets customer id.
	 *
	 * @param userId the customer id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets timezone.
	 *
	 * @return the timezone
	 */
	public TimeZone getTimezone() {
		return timezone;
	}

	/**
	 * Sets timezone.
	 *
	 * @param timezone the timezone
	 */
	public void setTimezone(TimeZone timezone) {
		this.timezone = timezone;
	}

	/**
	 * Gets session creation time.
	 *
	 * @return the session creation time
	 */
	public Long getSessionCreationTime() {
		return sessionCreationTime;
	}

	/**
	 * Sets session creation time.
	 *
	 * @param sessionCreationTime the session creation time
	 */
	public void setSessionCreationTime(Long sessionCreationTime) {
		this.sessionCreationTime = sessionCreationTime;
	}
}
