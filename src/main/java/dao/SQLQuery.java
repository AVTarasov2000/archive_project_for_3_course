package dao;

import lombok.Getter;
import lombok.Setter;

public class SQLQuery extends Query{

    public SQLQuery(String query) {
        this.query = query;
    }

    @Getter @Setter String query;

}
