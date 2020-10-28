package dao.SQLMethods;


public class Create extends Query {
    public Create(String table, String[] columns) {
        StringBuilder sb = new StringBuilder();
        for (String column : columns) {
            sb.append(column).append(" ,\n");
        }
        super.setQuery(String.format("CREATE TABLE %s (\n%s\n);",
                table,
                sb.toString())
        );
    }
}
