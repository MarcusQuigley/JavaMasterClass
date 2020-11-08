package com.tb.linkedlists.playlist;

public class Song {
	private String title;
	private double duration = 0d;

	public Song(String title, double duration) {
		this.title = title;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public double getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return this.getTitle();
	}
}