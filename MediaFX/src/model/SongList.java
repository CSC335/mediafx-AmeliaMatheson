package model;

import java.util.ArrayList;
import java.util.Collections;

public class SongList {
	 private ArrayList<Song> songList;
	 private int size;
	 
	 
	 public SongList() {
		 songList = new ArrayList<>();
		 size = 0;
	 }
	 
	 public void addSong(Song newSong) {
		 songList.add(newSong);
		 size++;
	 }
	 
	 public void removeSong(Song toBeRemoved) {
		 for (Song song : songList) {
			 if (song.equals(toBeRemoved)) {
				 songList.remove(song);
				 return;
			 }
		 }
	 }
	 
	 public int size() {
		 return size;
	 }
	 
	 public Song get(int i) {
		 return songList.get(i);
	 }
	 
	 public void sortByTitle() {
		 Collections.sort(songList, Song::compareByTitle);
	 }
	 
	 public void sortByArtist() {
		 Collections.sort(songList, Song::compareByArtist);
	 }
	 
	 public void sortByDuration() {
		Collections.sort(songList, Song::compareByDuration);
	}

}
