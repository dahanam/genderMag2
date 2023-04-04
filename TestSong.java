package GenderMag2;

import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class TestSong {
    public static void main(String[] args) {
        // Testing the Song class
        Song<String> test1 = new Song<>("Bohemian Rhapsody", "Queen", "1975", "Arrival", "0000000");
        Song<String> test2 = new Song<>("Imagine", "John Lennon", "1971", "Imagine", "11111111");
        Song<String> test3 = new Song<>("Stairway to Heaven", "Led Zeppelin", "1971", "Led Zeppelin IV", "22222222");

        System.out.println(test1.toString());
        System.out.println(test2.toString());
        System.out.println(test3.toString());

        System.out.println();

        // Testing readSongs method
        String[] songsArray = readSongs();
        for (String song : songsArray) {
            System.out.println(song);
        }
        
        System.out.println();

        // Testing readSongs2 method
        LinkedList<Song<String>> songsLinkedList = readSongs2();
        for (Song<String> song : songsLinkedList) {
            System.out.println(song.toString());
        }

        System.out.println();

        // Testing searchSong method
        String searchedSong = searchSong(songsArray, "Imagine");
        System.out.println(searchedSong);
        String searchedSong2 = searchSong(songsArray, "1965", "My Girl");
        System.out.println(searchedSong2);

        // Testing comparator method
        int compare = comparator(songsArray, "My Girl", "Imagine");
        if (compare == 0) {
            System.out.println("The songs are the same");
        } else if (compare == -1) {
            System.out.println("The second song goes after the first");
        } else if (compare == 1) {
            System.out.println("The first song goes after the second");
        }
        int compare2 = comparator(songsArray, "1965", "My Girl", "1965", "Yesterday");
        if (compare2 == 0) {
            System.out.println("The songs are the same");
        } else if (compare2 == -1) {
            System.out.println("The second song goes after the first");
        } else if (compare2 == 1) {
            System.out.println("The first song goes after the second");
        }
        
        // made by dahana
     // Write the songs to a new file
        writeToFile(songsArray, "C:\\Users\\dahan\\Downloads\\new_songs.txt");
    }
    ///////////////////////// Modification made by Dahana
    // Write modified songs array to a new text file
    public static void writeToFile(String[] songsArray, String filePath) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            for (String song : songsArray) {
                writer.write(song);
                writer.newLine();
            }
            
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file: " + e.getMessage());
            }
        }
    }
    /////////////////////////

    public static String[] readSongs() {
        // Create an array to hold the songs
        File songs = new File("C:\\Users\\dahan\\Downloads\\new_songs.txt");
        String[] songsArray = new String[25];
        // Read the file and store the lines in an array 
        try {
            Scanner scanner = new Scanner(songs);
            Random random = new Random();
            int i = 0;
            while (scanner.hasNextLine()) {
                // Create a random number between 1000000 and 9999999
                random.setSeed(i); // Set's the seed so each song has the same ID each time
                Integer randomNumber = random.nextInt(1000000) + 1000000;
                String line = scanner.nextLine();
                String[] lineArray = line.split(",");
                // Create a new song
                Song<String> song = new Song<>(lineArray[0], lineArray[1], lineArray[2], lineArray[3], randomNumber.toString());
                // Add the song to the list
                songsArray[i] = song.toString();
                i++;
                }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        // Return the array
        return songsArray;
    }

    public static LinkedList<Song<String>> readSongs2() {
        // Create an array to hold the songs
        File songs = new File("C:\\Users\\dahan\\Downloads\\songs.txt");
        LinkedList<Song<String>> songsLinkedList = new LinkedList<>();
        // Read the file and store the lines in an array 
        try {
            Scanner scanner = new Scanner(songs);
            Random random = new Random();
            int i = 0;
            while (scanner.hasNextLine()) {
                random.setSeed(i); // Set's the seed so each song has the same ID each time
                i++;
                // Create a random number between 1000000 and 9999999
                Integer randomNumber = random.nextInt(1000000) + 1000000;
                String line = scanner.nextLine();
                String[] lineArray = line.split(",");
                // Create a new song
                Song<String> song = new Song<>(lineArray[0], lineArray[1], lineArray[2], lineArray[3], randomNumber.toString());
                // Add the song to the list
                songsLinkedList.add(song);
                }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        // Return the array
        return songsLinkedList;
    }

    public static String searchSong(String[] songsArray, String name) {
        for (int i = 0; i < songsArray.length; i++) {
            if (songsArray[i].contains(name)) {
                return songsArray[i];
            }
        }
        return "Song not found";
    }

    public static String searchSong(String[] songsArray, String year, String name) {
        for (int i = 0; i < songsArray.length; i++) {
            if (songsArray[i].contains(year) && songsArray[i].contains(name)) {
                return songsArray[i];
            }
        }
        return "Song not found";
    }

    public static int comparator(String[] songsArray, String name1, String name2) {
        if (name1.compareTo(name2) > 0 && searchSong(songsArray, name1) != "Song not found" && searchSong(songsArray, name2) != "Song not found") {
            return 1;
        }
        else if (name1.compareTo(name2) < 0 && searchSong(songsArray, name1) != "Song not found" && searchSong(songsArray, name2) != "Song not found") {
            return -1;
        }
        else if (name1.compareTo(name2) == 0 && searchSong(songsArray, name1) != "Song not found" && searchSong(songsArray, name2) != "Song not found") {
            return 0;
        } 
        else {
            System.out.println("One or more songs are not found");
            return -2;
        }
    }

    public static int comparator(String[] songsArray, String year1, String name1, String year2, String name2) {
        if (year1.compareTo(year2) > 0 && searchSong(songsArray, year1, name1) != "Song not found" && searchSong(songsArray, year2, name2) != "Song not found") {
            return -1;
        }
        else if (year1.compareTo(year2) < 0 && searchSong(songsArray, year1, name1) != "Song not found" && searchSong(songsArray, year2, name2) != "Song not found") {
            return 1;
        }
        else if (year1.compareTo(year2) == 0 && searchSong(songsArray, year1, name1) != "Song not found" && searchSong(songsArray, year2, name2) != "Song not found") {
            return comparator(songsArray, name1, name2);
        }
        else {
            System.out.println("One or more songs are not found");
            return -2;
        }
    }
}