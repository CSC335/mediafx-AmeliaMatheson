package model;
import java.io.File;
import java.net.URI;
import java.util.concurrent.LinkedBlockingQueue;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PlayList{

    private LinkedBlockingQueue<SongThread> queue;


    public PlayList() {
        queue = new LinkedBlockingQueue<>();
    }
    
    public boolean addSong(String songTitle) {
        if (queue.size() <= 3) {
            SongThread newSong = new SongThread(songTitle);
            queue.add(newSong);
            return true;
        }
        return false;
    }

    public boolean removeSong(String song) {
        for (SongThread item : queue) {
            if (item.getName().equals(song)) {
                queue.remove(item);
                return true;
            }
        }
        return false;
    }

    public String seePlaylist() {
        String list = "";
        for (SongThread song : queue) {
            list += song.getName() + ",";
        }
        return list;
    }

    
    public void play() {
    	SongThread song = queue.poll();  // first
    	System.out.println("First: " + song.name);
    	SongThread nextSong = queue.poll();
    	if (nextSong != null) {
    		System.out.println("Second: " + nextSong.name);
    		song.nextSong = nextSong;
    		SongThread thirdSong = queue.poll();
    		if (thirdSong != null) {
    			System.out.println("Third: " + thirdSong.name);
    			nextSong.nextSong = thirdSong;
    		}
    	}
    	System.out.println();
    	song.run();
    }
    
    private class SongThread implements Runnable {

    	private String name;
    	private String path;
    	private SongThread nextSong;
    	
    	public SongThread(String name) {
    		this.name = name;
    		path = "songfiles/" + name;
    		nextSong = null;
    	}
    	
		@Override
		public void run() {
			System.out.println("Song " + name + " is playing");
			
			File file = new File(path);
	        URI uri = file.toURI();
	        Media media = new Media(uri.toString());
	        MediaPlayer mediaPlayer = new MediaPlayer(media);
	        mediaPlayer.play();
	        mediaPlayer.setOnEndOfMedia(new EndHandler(nextSong, mediaPlayer));
		}
		
		public String getName() {
			return name;
		}
    }
    
    private class EndHandler implements Runnable {

    	private SongThread next;
    	private MediaPlayer player;
    	
    	public EndHandler(SongThread nextSong, MediaPlayer player) {
    		next = nextSong;
    		this.player = player;
    	}
    	
		@Override
		public void run() {
			System.out.println("\tSong has ended");
			if (next != null) {
				next.run();
				player.stop();
		        player.dispose();
		        try {
		            Thread.sleep(2000); // 2 second pause
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			}
			
		}
		
    }

}
