package edu.examples.java_classes.output;

import edu.examples.java_classes.entity.Note;

import java.util.List;

public class NotebookOutput {

    public void print(String title, List<Note> notes) {

        System.out.println(title.toUpperCase());
        System.out.println();

        for (Note n : notes) {
            System.out.println(n.getId() + " - " + n.getTitle() + " - " + n.getContent() + " - " + n.getD());
        }

    }

}