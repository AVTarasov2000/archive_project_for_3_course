package dao;

import java.util.ArrayList;
import java.util.List;

public class TableReceiver implements Receiver{

    private List<String[]> rows = new ArrayList <>();

    @Override
    public List <String[]> getData() {
        return rows;
    }

    @Override
    public void addRow(String[] row) {
        rows.add(row);
    }
}
