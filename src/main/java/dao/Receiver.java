package dao;

import java.util.List;

public interface Receiver {
    List <String[]> getData();

    void addRow(String[] row);
}
