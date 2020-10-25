package dao;

public class SQLQueryMaker implements QueryMaker {

    public<T> SQLQuery makeQuery(DBMethods method, T entity, String... postfixes) {
        StringBuilder sb = new StringBuilder();
        for (String s :
                postfixes) {
            sb.append(" ").append(s);
        }
        // TODO: 24/10/2020 сдедать доставание target values
        return String.format(method.getPrefix(), entity.targetValues(), sb.toString());
    }
}
