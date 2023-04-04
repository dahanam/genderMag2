package GenderMag2;

import java.util.ArrayList;

public class exHeap<T> implements DMQueue<T>{
	//priority queue
	
	//create a heap
	ArrayList<T> heap;
	
	//compare
	private int compare(T x, T y) {
        if (x == null && y == null) {
            return 0;
        }
        if (x == null) {
            return -1;
        }
        if (y == null) {
            return 1;
        }
        return ((Comparable<T>) x).compareTo(y);
    }
	
	//swap
	private void swap(int song1, int song2) {
        T temp = heap.get(song1);
        heap.set(song1, heap.get(song2));
        heap.set(song2, temp);
    }
	
	@Override
	public void addSong(Object song) {
		// insertion
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T peekSong() {
		if (heap.isEmpty()) {
		return (T) "heap is empty"; //or null ig
		}
		return heap.get(0);
	}

	@Override
	public void pushSong(Object song) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T removeSong() {
		 if (isEmpty()) {
		        System.out.println("Heap is empty");
		        return null;
		    }
		    T root = heap.get(0);
		    T last = heap.remove(heap.size() - 1);
		    if (!heap.isEmpty()) {
		        heap.set(0, last);
		        heapifyDown(0);
		    }
		    return root;
	}
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

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
