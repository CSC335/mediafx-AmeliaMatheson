package model;

import java.util.Objects;

public class Song implements Comparable<Song>{
	private String title;
	private String artist;
	private String fileName;
	private int duration;
	
	public Song(String name, String artist, int playtime) {
		title = name;
		this.artist = artist;
		duration = playtime;
	}
	
	public int compareByTitle(Song other) {
		return this.title.compareTo(other.title);
	}
	
	public int compareByArtist(Song other) {
		return this.artist.compareTo(other.artist);
	}
	
	public int compareByDuration(Song other) {
		if (this.duration == other.duration) {
			return 0;
		}
		else if (this.duration < other.duration) {
			return -1;
		}
		return 1;
	}


	@Override
	public int compareTo(Song o) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public String toString() {
		return "[" + title + ", " + artist + ", " + duration + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		return Objects.equals(artist, other.artist) && duration == other.duration
				&& Objects.equals(fileName, other.fileName) && Objects.equals(title, other.title);
	}
	
	
}
