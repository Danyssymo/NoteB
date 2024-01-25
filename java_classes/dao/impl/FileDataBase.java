package edu.examples.java_classes.dao.impl;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.entity.Note;


public class FileDataBase {
    private List<Note> notes = new ArrayList<>();
    private File file = new File("myFile.txt");

    public List<Note> readFromFile() throws DaoException {
        List<Note> notes_ = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("myFile.txt"))) {
            String[] params;
            String line = reader.readLine();
            while (line != null) {

                params = line.split("&");
                Note newNote = new Note();
                newNote.setId(Integer.parseInt(params[0].split("=")[1]));
                newNote.setTitle(params[1].split("=")[1]);
                newNote.setContent(params[2].split("=")[1]);
                notes_.add(newNote);

                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        notes = notes_;
        return notes;
    }

    public void writeToFile(Note n) throws DaoException {
        try (FileWriter fw = new FileWriter("myFile.txt", true)) {
            notes.add(n);
            String str = "Id=" + n.getId() + "&Title=" + n.getTitle() + "&Content=" + n.getContent() + "&Date=" + n.getD();
            fw.write(str);
            fw.append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public int countOfNotes() throws DaoException {
        return readFromFile().size();
    }

    private int lastId() throws DaoException {
        return countOfNotes();
    }

    public int getId() throws DaoException {
        return lastId() + 1;
    }

    //    public static void clear() {
//        notes.clear();
//    }

//    public static void delete(int idDelete) {
//        notes.remove(idDelete);
//    }

//    public static void sortNotesTitle() {
//        Collections.sort(notes);
//    }

//    public static void sortNotesContent() {
//        Comparator<Note> contentComparator = new SortingItems();
//        notes.sort(contentComparator);
//    }

//
}