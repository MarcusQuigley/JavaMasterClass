package com.tb.linkedlists.playlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
	private String name;
	private String artist;
	private List<Song> songs;

	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<>();
	}

	public String getName() {
		return this.name;
	}

	public String getArtist() {
		return this.artist;
	}

	public List<Song> getSongs() {
		return this.songs;
	}

	public void addSong(Song song) {
		if (findSong(song.getTitle()) == null)
			songs.add(song);
	}

	public Song findSong(String name) {
		for (Song s : songs) {
			if (s.getTitle().equals(name))
				return s;
		}
		return null;
	}

	public int findTrackNumber(String name) {
		if (name != null && name.length() > 0) {
			int index = 0;
			for (Song s : songs) {
				if (s.getTitle().equals(name))
					return index;
				index++;
			}
		}
		return -1;
	}

	public void addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
		if (trackNumber < 1 || trackNumber > songs.size())
			return;
		var song = songs.get(trackNumber);
		if (song == null)
			return;
		playlist.addLast(song);
	}

	public void addToPlaylist(String track, LinkedList<Song> playlist) {
		addToPlaylist(findTrackNumber(track), playlist);
	}
}
