package dao.SQLMethods;


public class Update extends Query {
    public Update(String table, String[] names, String[] values, String conditions) {
        if (names.length != values.length)
            throw new IllegalArgumentException("length of names and values must be equal");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < names.length; i++) {
            sb.append(names[i]).append(" = ").append(values[i]).append(", ");
        }

        super.setQuery(String.format("UPDATE %s SET %s WHERE %s",
                table,
                sb.toString(),
                conditions)
        );
    }
}
