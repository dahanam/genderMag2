# genderMag2

Course: CPS *2232 Spring 2023
Team: Dahana Moz Ruiz [Student 2] & Roilan Iglesias [Student 1]

📖 Project Overview
This repository contains two complementary parts of our GenderMag–inspired assignment:

Part 1 (Student 1)

* Implements a generic Song class supporting arbitrary metadata fields.
* Provides file I/O methods to read, search, and display a collection of songs from a plain-text table.
* Demonstrates sorting via custom SongComparator implementations.
* Uses the Pat persona to evaluate the code’s maintainability and usability.

Part 2 (Student 2)

* Defines a generic DM<T> interface for basic queue operations.
* Implements a max-heap class (DM<T>) that realizes the queue API.
* Shows manual and programmatic construction/removal of heap elements using a 20-song subset.
* Applies the DAV persona to assess how an alternate user would experience this code.

🔍 Key Features
Generic Data Model

* Song<T> holds four arbitrary data fields (songData1–songData4), including a programmatically generated 7-digit ID.
* Fully encapsulated with constructors, getters/setters, and toString().

File I/O Utilities

* readSongsArray(String path) → Song<?>[]
* readSongsList(String path) → LinkedList<Song<?>>
* Duplicate song entries and randomized IDs are generated automatically.

Search & Sort

* searchByName(Song<?>[] array, String name)
* searchByYearThenName(List<Song<?>> list, int year, String name)
* Two Comparator<Song<?>> implementations for name‐only and year-then-name comparisons.

Heap & Queue API (Part 2)

* DM<T> interface with methods: add, deleteAll, isEmpty, peek, push, remove, size.
* DM<T>: a generic max-heap implementation that supports all queue operations, plus heapify and heapSort.
