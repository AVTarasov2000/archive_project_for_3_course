package dao.SQLMethods;


import java.util.Arrays;
import java.util.Iterator;

public class Update extends Query {
    public Update(String table, String[] columnNames, String[] values, String conditions) {
        if (columnNames.length != values.length)
            throw new IllegalArgumentException("length of columnNames and values must be equal");

        StringBuilder sb = new StringBuilder();
        Iterator <String> nameIter = Arrays.stream(columnNames).iterator();
        Iterator <String> valueIter = Arrays.stream(values).iterator();
        while (nameIter.hasNext() && valueIter.hasNext()){
            sb.append(nameIter.next()).append(" = ").append(valueIter.next());
            if (nameIter.hasNext() && valueIter.hasNext())
                sb.append(" ,");
        }


        super.setQuery(String.format("UPDATE %s SET %s WHERE %s",
                table,
                sb.toString(),
                conditions)
        );
    }
}
