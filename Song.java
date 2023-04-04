package GenderMag2;


import java.util.LinkedList;

public class Song<T> {
    // Instance variables
    private T name;
    private T artist;
    private T year;
    private T album;
    private T songID;

    // Constructors
    public Song() {
    }

    public Song(T name, T artist, T year, T album, T songID) {
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.album = album;
        this.songID = songID;
    }

    // Getters and Setters
    public T getName() {
        return this.name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getArtist() {
        return this.artist;
    }

    public void setArtist(T artist) {
        this.artist = artist;
    }

    public T getYear() {
        return this.year;
    }

    public void setYear(T year) {
        this.year = year;
    }

    public T getAlbum() {
        return this.album;
    }

    public void setAlbum(T album) {
        this.album = album;
    }

    public T getSongID() {
        return this.songID;
    }

    public void setSongID(T songID) {
        this.songID = songID;
    }

    // toString
    @Override
    public String toString() {
        return "{" +
            " Name='" + getName() + "'" +
            ", Artist='" + getArtist() + "'" +
            ", Year='" + getYear() + "'" +
            ", Album='" + getAlbum() + "'" +
            ", SongID='" + getSongID() + "'" +
            "}";
    }

    public static <T> void displayAllSongs(LinkedList<Song<T>> songsLinkedList) {
        //Print first 3 instances variables of each song
        for (int i = 0; i < songsLinkedList.size(); i++) {
            Song<T> song = songsLinkedList.get(i);
            System.out.println(song.getName() + ", " + song.getArtist() + ", " + song.getYear());
        }
    }
}