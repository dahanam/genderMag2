# Java Data Structures — Heap, Queue & Sorting with GenderMag Evaluation

**Course:** CPS 2232 — Data Structures, Spring 2023
**Team:** Dahana Moz Ruiz & Roilan Iglesias
**Language:** Java

---

## Overview

This project implements core data structures in Java — including a generic max-heap, queue API, and a song collection manager with file I/O and sorting — and evaluates the codebase using the **GenderMag cognitive walkthrough method**, a research-backed framework for identifying usability and inclusivity issues in software.

---

## What is GenderMag?

GenderMag (Gender-Inclusiveness Magnifier) is a software inspection method developed by researchers at Oregon State University. It uses fictional personas with different problem-solving styles to surface design decisions that may unintentionally exclude certain users. This project applies two personas:

- **Pat** — used to evaluate the Song collection and sorting implementation
- **DAV** — used to evaluate the heap and queue implementation

---

## Project Structure

### Part 1 — Song Collection Manager
- `Song.java` — Generic Song class with 4 arbitrary metadata fields and auto-generated 7-digit IDs
- `TestSong.java` — File I/O utilities: read, search, and display songs from a plain-text table
- `songs.txt` / `new_songs.txt` — Sample song datasets

**Key features:**
- Search by name or by year + name
- Two `Comparator<Song<?>>` implementations for flexible sorting
- Fully encapsulated with constructors, getters/setters, and `toString()`

### Part 2 — Heap & Queue Implementation
- `DMQueue.java` — Generic queue interface with: `add`, `deleteAll`, `isEmpty`, `peek`, `push`, `remove`, `size`
- `DMHeap.java` — Generic max-heap implementing the queue API, plus `heapify` and `heapSort`
- `HeapSort.java` — Heap sort demonstration on a 20-song subset
- `exHeap.java` — Manual heap construction and removal examples

---

## How to Run

```bash
# Compile all files
javac *.java

# Run the song collection demo
java TestSong

# Run the heap sort demo
java HeapSort
```

---

## Key Concepts Demonstrated

- Generic types in Java (`Song<?>`, `DM<T>`)
- Max-heap construction and heap sort
- File I/O with plain-text parsing
- Custom `Comparator` implementations
- GenderMag usability evaluation methodology
