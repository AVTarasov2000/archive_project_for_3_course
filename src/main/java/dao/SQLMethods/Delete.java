package dao.SQLMethods;

public class Delete extends Query {
    public Delete(String table, String id) {
        String str = "DELETE FROM %s";
        if(!id.equals(""))
            str+=String.format(" WHERE id=%s",id);
        str+=";";
        super.setQuery(String.format(str,
                table)
        );
    }
}
