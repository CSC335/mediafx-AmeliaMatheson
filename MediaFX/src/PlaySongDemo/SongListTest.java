package PlaySongDemo;

import model.Song;
import model.SongList;

public class SongListTest {
	private static SongList list;
	
	
	public static void main(String[] args) {
		list = new SongList();
		list.addSong(new Song("Hello", "Adele", 301));
		list.addSong(new Song("Rookie", "Red Velvet", 45));
		list.addSong(new Song("Misunderstood", "Lucky Daye", 503));
		list.addSong(new Song("Juice", "Kris Wu", 345));
		list.addSong(new Song("Red Ruby Da Sleeze", "Nicki Minaj", 298));
		
		list.sortByTitle();
		System.out.println("By Title");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		list.sortByArtist();
		System.out.println("By Artist");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		list.sortByDuration();
		System.out.println("By Duration");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
