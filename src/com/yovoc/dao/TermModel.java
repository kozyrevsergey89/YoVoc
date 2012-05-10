package com.yovoc.dao;

public class TermModel {

	private long id;
	private String termin;
	private String description;
	private String termType;
	
	public static final String AUDIO_TYPE = "audio";
	public static final String TEXT_TYPE = "text";
	public static final String IMAGE_TYPE = "image";
	public static final String VIDEO_TYPE = "video";
	
	public void setId(final long id) { this.id = id;}
	
	public void setTermin(final String termin) { this.termin = termin; }
	
	public void setDescription(final String description) { this.description = description; }
	
	public long getId() { return id; }
	
	public String getTermin() { return termin;}
	
	public String getDescription() { return description; }
	
	public String getTermType() { return termType; }
	
	public void setTermType(final String type) { this.termType = type; }
}
