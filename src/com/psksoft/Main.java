package com.psksoft;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> dll = new LinkedList<>();

        // Add elements and demonstrate functionality
        addOrMoveToFront(dll, "one");
        addOrMoveToFront(dll, "two");
        addOrMoveToFront(dll, "three");
        addOrMoveToFront(dll, "four");

        System.out.println("List after adding elements:");
        display(dll);

        // Add existing element to bring it to the front
        addOrMoveToFront(dll, "two");

        System.out.println("List after moving 'two' to the front:");
        display(dll);

        dll.removeLast();
        display(dll);

    }

    // Display the list
    public static void display(LinkedList<String> dll) {
        for (String value : dll) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Add a string to the front if not present, else move to front
    public static void addOrMoveToFront(LinkedList<String> dll, String value) {
        int index = dll.indexOf(value);

        if (index == -1) {
            // Add the value to the front if it is not in the list
            dll.addFirst(value);
        } else {
            // Remove the value from its current position
            dll.remove(index);
            // Add the value to the front
            dll.addFirst(value);
        }
    }
}

