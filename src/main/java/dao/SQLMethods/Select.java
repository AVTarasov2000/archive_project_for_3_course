package dao.SQLMethods;


public class Select extends Query {
    public Select(String table, String conditions) {
        super.setQuery(String.format("SELECT * FROM %s WHERE %s",
                table,
                conditions)
        );
    }
}
