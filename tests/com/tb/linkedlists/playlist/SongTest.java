package com.tb.linkedlists.playlist;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SongTest {

	static Stream<Arguments> source_test_songs() {
		return Stream.of(arguments("01 Tired of Being Alone", 4.6), arguments("Call Me", 4.22),
				arguments("Still in Love With You", 3.3), arguments("Here I Am", 4.54), arguments("Broken Heart", 5.02),
				arguments("Let's Stay Together", 6.23), arguments("I Can't Get Next to You", 3.23));
	}

	@ParameterizedTest
	@MethodSource("source_test_songs")
	void test_songTitle(String name, double duration) {
		Song sut = new Song(name, duration);
		assertEquals(name, sut.getTitle());
	}

	@ParameterizedTest
	@MethodSource("source_test_songs")
	void test_songDuration(String name, double duration) {
		Song sut = new Song(name, duration);
		assertEquals(duration, sut.getDuration());
	}
}
