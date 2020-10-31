package dao.SQLMethods;


public class Select extends Query {
    public Select(String table, String conditions) {
        String str = "SELECT * FROM %s";
        if(!conditions.equals(""))
            str+=String.format(" WHERE %s", conditions);
        str+=";";
        super.setQuery(String.format(str,
                table)
        );
    }
}
