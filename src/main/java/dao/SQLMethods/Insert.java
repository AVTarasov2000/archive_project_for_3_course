package dao.SQLMethods;

import java.util.Arrays;
import java.util.Iterator;

public class Insert extends Query {
    public Insert(String table, String[] columnNames, String[] values) {
        if (columnNames.length != values.length)
            throw new IllegalArgumentException("length of columnNames and values must be equal");

        StringBuilder namesBuilder = new StringBuilder();
        Iterator<String> nameIter = Arrays.stream(columnNames).iterator();
        while (nameIter.hasNext()){
            namesBuilder.append(nameIter.next());
            if (nameIter.hasNext())
                namesBuilder.append(" ,");
        }
//        for (String name : columnNames) {
//            namesBuilder.append(name).append(", ");
//        }

        StringBuilder valuesBuilder = new StringBuilder();
        Iterator<String> valueIter = Arrays.stream(columnNames).iterator();
        while (valueIter.hasNext()){
            valuesBuilder.append(valueIter.next());
            if (valueIter.hasNext())
                valuesBuilder.append(" ,");
        }


//        StringBuilder valuesBuilder = new StringBuilder();
//        for (String value : values) {
//            valuesBuilder.append(value).append(", ");
//        }
        super.setQuery(String.format("INSERT INTO %s (%s) VALUES (%s)",
                table,
                namesBuilder.toString(),
                valuesBuilder.toString())
        );
    }
}
