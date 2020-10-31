package dao.SQLMethods;


import java.util.Iterator;
import java.util.List;

public class Update extends Query {
    public Update(String table, List<String> columnNames, List<String> values, String conditions, String id) {
        if (columnNames.size() != values.size())
            throw new IllegalArgumentException("length of columnNames and values must be equal");

        StringBuilder sb = new StringBuilder();
        Iterator <String> nameIter = columnNames.stream().iterator();
        Iterator <String> valueIter = values.stream().iterator();
        while (nameIter.hasNext() && valueIter.hasNext()){
            sb.append(nameIter.next()).append(" = ").append(valueIter.next());
            if (nameIter.hasNext() && valueIter.hasNext())
                sb.append(" ,");
        }
        if (!id.equals(""))
            id = "id="+id;

        super.setQuery(String.format("UPDATE %s SET %s WHERE %s %s ;",
                table,
                sb.toString(),
                id,
                conditions)
        );
    }
}
