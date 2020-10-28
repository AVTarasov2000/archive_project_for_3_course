package dao.SQLMethods;

public class Delete extends Query {
    public Delete(String table, String conditions) {
        super.setQuery(String.format("DELETE FROM %s WHERE %s",
                table,
                conditions)
        );
    }
}
