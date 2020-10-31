package dao.SQLMethods;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Insert extends Query {
    public Insert(String table, List <String> columnNames, List<String> values) {
        if (columnNames.size() != values.size())
            throw new IllegalArgumentException("length of columnNames and values must be equal");

        StringBuilder namesBuilder = new StringBuilder();
        Iterator<String> nameIter = columnNames.stream().iterator();
        while (nameIter.hasNext()){
            namesBuilder.append(nameIter.next());
            if (nameIter.hasNext())
                namesBuilder.append(" ,");
        }

        StringBuilder valuesBuilder = new StringBuilder();
        Iterator<String> valueIter = values.stream().iterator();
        while (valueIter.hasNext()){
            valuesBuilder.append(valueIter.next());
            if (valueIter.hasNext())
                valuesBuilder.append(" ,");
        }

        super.setQuery(String.format("INSERT INTO %s (%s) VALUES (%s);",
                table,
                namesBuilder.toString(),
                valuesBuilder.toString())
        );
    }
}
