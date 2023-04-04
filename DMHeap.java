package GenderMag2;

import java.util.ArrayList;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DMHeap<T> implements DMQueue<T>{
	//priority queue
	
	//create a heap
	private ArrayList<T> heap;
	
	public DMHeap() {
		heap= new ArrayList<T>();
	}
	
	//compare
	private int compare(T x, T y) {
        if (x == null && y == null) {return 0;}
        if (x == null) {return -1;}
        if (y == null) {return 1;}
        
        return ((Comparable<T>) x).compareTo(y);
    }
	
	//swap
	private void swap(int song1, int song2) {
        T temp = heap.get(song1);
        heap.set(song1, heap.get(song2));
        heap.set(song2, temp);
    }
	
	@Override
	////////////
	public void addSong(T song) {
		// insertion 
		heap.add(song); // adds song
		// new song's index
        int index = heap.size() - 1;
        
        //maintain the structure
        int parentIndex = (index - 1) / 2;
        while (parentIndex >= 0 && compare(heap.get(index), heap.get(parentIndex)) > 0) {
            swap(index, parentIndex);
            //new parentIndex
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
	}

	@Override
	public void deleteAll() {
		heap.clear();
	}

	@Override
	public boolean isEmpty() {
		return heap.isEmpty();
	}

	@Override
	public T peekSong() {
		if (heap.isEmpty()) {
		return (T) "heap is empty"; //or null ig
		}
		return heap.get(0);
	}

	@Override
	public void pushSong(T song) {
		if (heap.isEmpty()) throw new IllegalStateException();
			
		addSong(song);
	}

	@Override
	public T removeSong() {
		 if (heap.isEmpty()) {
		        System.out.println("Heap is empty");
		        return null;
		    }
		    T root = heap.get(0);
		    T last = heap.remove(heap.size() - 1);
		    if (!heap.isEmpty()) {
		        heap.set(0, last);
		        heapifyDown(0); // ~ recursive
		    }
		    return root;
	}
	// maintain the structure
	private void heapifyDown(int index) {
	    int leftIndex = 2 * index + 1;
	    int rightIndex = 2 * index + 2;
	    int largestIndex = index;
	    if (leftIndex < heap.size() && compare(heap.get(leftIndex), heap.get(largestIndex)) > 0) {
	        largestIndex = leftIndex;
	    }
	    if (rightIndex < heap.size() && compare(heap.get(rightIndex), heap.get(largestIndex)) > 0) {
	        largestIndex = rightIndex;
	    }
	    if (largestIndex != index) {
	        swap(index, largestIndex);
	        heapifyDown(largestIndex);
	    }
	}
	       
	//implement heap sort
	public void heapSort() {
	    // sort the heap in ascending order
	    for (int i = size() - 1; i > 0; i--) {
	        // swap the root with the i-th element
	        T temp = heap.get(0);
	        heap.set(0, heap.get(i));
	        heap.set(i, temp);
	        
	        // restore the heap property for the remaining elements
	        for (int j = (i - 1) / 2; j >= 0; j--) {
	            heapifyDown(j);
	        }
	    }
	}
	
	@Override
	public int size() {
		return heap.size();
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("[");
	    for (int i = 0; i < heap.size(); i++) {
	        sb.append(heap.get(i));
	        if (i != heap.size() - 1) {
	            sb.append(" ");
	        }
	    }
	    sb.append("]");
	    return sb.toString();
	}
	//////////////////////// --> Main
	
	public static void main(String[] args) {
		
		// add code too clear the file
		String filePath = ("C:\\Users\\dahan\\Downloads\\new_songs.txt");
	    DMHeap<String> songHeap = new DMHeap<>();

	    // add 20 songs to the heap
	    songHeap.addSong("{Name='Bohemian Rhapsody',Artist='Queen',Year='1975', Album='A Night at the Opera',SongID='1741360'}");
	    songHeap.addSong("{Name='Imagine', Artist='John Lennon', Year='1971',Album='Imagine', SongID='1548985'}");
	    songHeap.addSong("{Name='Stairway to Heaven', Artist='Led Zeppelin', Year='1971', Album='Led Zeppelin IV', SongID='1126108'}");
        songHeap.addSong("{Name='Let It Be', Artist='The Beatles', Year='1970', Album='Let It Be', SongID='1933734'}");
	    songHeap.addSong("{Name='Hey Jude', Artist='The Beatles', Year='1968', Album='Hey Jude', SongID='1971862'}");
        
	    songHeap.addSong("{Name='Free Bird', Artist='Lynyrd Skynyrd', Year='1973', Album='(Pronounced 'Lĕh-'nérd 'Skin-'nérd)', SongID='1779487'}");
	    songHeap.addSong("{Name='Sweet Home Alabama', Artist='Lynyrd Skynyrd', Year='1974', Album='Second Helping', SongID='1356611'}");
	    songHeap.addSong("{Name='Yesterday', Artist='The Beatles', Year='1965', Album='Help', SongID='1164236'}");
	    songHeap.addSong("{Name='I Will Always Love You', Artist='Whitney Houston', Year='1973', Album='Jolene', SongID='1202364'}");
	    songHeap.addSong("{Name='Billie Jean', Artist='Michael Jackson', Year='1982', Album='Thriller', SongID='1009989'}");
	    
	    songHeap.addSong("{Name='Smells Like Teen Spirit', Artist='Nirvana', Year='1991', Album='Nevermind', SongID='1587113'}");
	    songHeap.addSong("{Name='Hotel California', Artist='The Eagles', Year='1976', Album='Hotel California', SongID='1394738'}");
	    songHeap.addSong("{Name='What’s Going On', Artist='Marvin Gaye', Year='1971', Album='What’s Going On', SongID='1432866'}");
	    songHeap.addSong("{Name='My Girl', Artist='The Temptations', Year='1965', Album='The Temptations Sing Smokey', SongID='1240492'}");
	    songHeap.addSong("{Name='Purple Haze', Artist='Jimi Hendrix', Year='1967', Album='Are You Experienced', SongID='1817615'}");
	    
	    songHeap.addSong("{Name='Born to Run', Artist='Bruce Springsteen', Year='1975', Album='Born to Run', SongID='1625241'}");
	    songHeap.addSong("{Name='Like a Rolling Stone', Artist='Bob Dylan', Year='1965', Album='Highway 61 Revisited', SongID='1819351'}");
	    songHeap.addSong("{Name='Good Vibrations', Artist='The Beach Boys', Year='1966', Album='Good Vibrations', SongID='1626976'}");
	    songHeap.addSong("{Name='Johnny B. Goode', Artist='Chuck Berry', Year='1958', Album='Chuck Berry Is on Top', SongID='1204100'}");
	    songHeap.addSong("{Name='Sweet Child O’ Mine', Artist='Guns N’ Roses', Year='1987', Album='Appetite for Destruction', SongID='1011725'}");

	    // adds the songs to the updated txt file that contains the ID column
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true)); //true is used for appending
            while (!songHeap.isEmpty()) {
            	writer.write(songHeap.removeSong() + "\n"); // write each song to the file
	            }
	            writer.close();
	            System.out.println("Text has been appended to the file successfully.");
	        } catch (IOException e) {
	            System.err.println("Error appending text to file: " + e.getMessage());
	        }
	    
	
		// remove 5 songs
		songHeap.removeSong();

	}// end of main
}// end of class
