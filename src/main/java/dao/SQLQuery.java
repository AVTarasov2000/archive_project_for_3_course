package dao;

import dao.SQLMethods.Query;
import lombok.Getter;
import lombok.Setter;

public class SQLQuery extends Query {

    public SQLQuery(String query) {
        this.query = query;
    }

    @Getter @Setter String query;

}
