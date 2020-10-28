package dao;

public class SQLQueryMaker implements QueryMaker {

    public<T> Query makeQuery(DBMethods method, T entity, String... postfixes) {
        StringBuilder sb = new StringBuilder();
        for (String s :
                postfixes) {
            sb.append(" ").append(s);
        }
        // TODO: 24/10/2020 убрать new
        return new SQLQuery(String.format(method.getPrefix(), entity, sb.toString()));
    }
}
