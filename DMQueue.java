package GenderMag2;

public interface DMQueue<T> {
    void addSong(T song);
    
    void deleteAll();
    
    boolean isEmpty();
    
    T peekSong();
    
    void pushSong(T song);
    
    T removeSong();
    
    int size();
}