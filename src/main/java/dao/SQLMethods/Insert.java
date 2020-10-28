package dao.SQLMethods;

public class Insert extends Query {
    public Insert(String table, String[] columnNames, String[] values) {
        if (columnNames.length != values.length)
            throw new IllegalArgumentException("length of columnNames and values must be equal");

        StringBuilder namesBuilder = new StringBuilder();
        for (String name : columnNames) {
            namesBuilder.append(name).append(", ");
        }

        StringBuilder valuesBuilder = new StringBuilder();
        for (String value : values) {
            valuesBuilder.append(value).append(", ");
        }
        super.setQuery(String.format("INSERT INTO %s (%s) VALUES (%s)",
                table,
                namesBuilder.toString(),
                valuesBuilder.toString())
        );
    }
}
