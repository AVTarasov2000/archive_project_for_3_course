package dao;

import java.sql.ResultSet;
import java.util.List;

public interface DataConverter {
    <T> List <T> convert(ResultSet resultSet, Class<T> entity);
}
