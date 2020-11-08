package com.tb.linkedlists.playlist;

import java.util.stream.Stream;
import com.tb.linkedlists.playlist.Album;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AlbumTest {

	static Stream<Arguments> source_test_albums() {
		return Stream.of(arguments("Surrender", "Chemical Brothers",
				new Song[] { new Song("Music, response", 2.0), new Song("Under the influence", 3.33),
						new Song("Out of control.", 4.30), new Song("Orange wedge", 2.54),
						new Song("Let forever be", 5.1), new Song("The sunshine underground", 6.2),
						new Song("Asleep from day", 6.2), new Song("Got glint", 6.2),
						new Song("Hey boy hey girl", 6.2) }));
	}

	static Stream<Arguments> source_test_albumTrackNumber() {
		return Stream.of(arguments("Surrender", "Chemical Brothers", 2, new Song[] { new Song("Music, response", 2.0),
				new Song("Under the influence", 3.33), new Song("Out of control.", 4.30) }));
	}

	static Stream<Arguments> source_test_addSong() {
		return Stream.of(arguments("DJ Krush", "Meiso", "Meiso"));
	}

	@ParameterizedTest
	@MethodSource("source_test_albums")
	void test_albumName(String name, String artist, Song[] songs) {
		Album sut = new Album(name, artist);
		assertEquals(name, sut.getName());
	}

	@ParameterizedTest
	@MethodSource("source_test_albums")
	void test_albumArtist(String name, String artist, Song[] songs) {
		Album sut = new Album(name, artist);
		assertEquals(artist, sut.getArtist());
	}

	@ParameterizedTest
	@MethodSource("source_test_albums")
	void test_albumFindTrack_byName(String name, String artist, Song[] songs) {
		Album sut = new Album(name, artist);
		for (Song s : songs)
			sut.addSong(s);
		var song = songs[0];
		assertEquals(song.getTitle(), sut.findSong(song.getTitle()).getTitle());
	}

	@ParameterizedTest
	@MethodSource("source_test_albumTrackNumber")
	void test_albumFindTrack_byNumber(String name, String artist, int trackNumber, Song[] songs) {
		Album sut = new Album(name, artist);
		for (Song s : songs)
			sut.addSong(s);
		var song = songs[trackNumber];
		assertEquals(trackNumber, sut.findTrackNumber(song.getTitle()));
	}

	@ParameterizedTest
	@MethodSource("source_test_addSong")
	void test_addSong(String name, String artist, String songName) {
		Album sut = new Album(name, artist);
		Song s = new Song(songName, 1d);
		sut.addSong(s);
		assertEquals(songName, sut.findSong(s.getTitle()).getTitle());
	}
}
