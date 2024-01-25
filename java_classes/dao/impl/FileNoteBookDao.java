package edu.examples.java_classes.dao.impl;

import java.util.Date;
import java.util.List;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.util.CreateNewDate;

public class FileNoteBookDao implements NoteBookDao {
    FileDataBase myDb = new FileDataBase();

    @Override
    public void save(Note n) throws DaoException {

        int id = myDb.getId();
        n.setId(id);

        if (n.getD() == null) {
            n.setD(CreateNewDate.addDate());
        }

        myDb.writeToFile(n);
    }

    @Override
    public List<Note> allNotes() throws DaoException {
        return myDb.readFromFile();
    }

}
