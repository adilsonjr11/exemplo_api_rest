package com.consumer.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ConsumerDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4885145354102676368L;
	
	private String id;
	private String conversationId;
	private Timestamp timestamp;
	private String from;
	private String to;
	private String text;

	public ConsumerDto(String id, String conversationId, Timestamp timestamp, String from, String to, String text) {
		this.id = id;
		this.conversationId = conversationId;
		this.timestamp = timestamp;
		this.from = from;
		this.to = to;
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConversationId() {
		return conversationId;
	}

	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
