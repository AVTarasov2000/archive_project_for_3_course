package dao;

import annotations.db.Singleton;
import dao.daoInterfaces.FromStringToObjectCaster;
import lombok.SneakyThrows;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
@Singleton
public class FromPostgreStringToObjectCasterImpl implements FromStringToObjectCaster {
    @SneakyThrows
    @Override
    public <T> Object cast(Class <T> cls, String value) {
        if (Integer.class.equals(cls)) {
            return Integer.parseInt(value);
        } else if (Date.class.equals(cls)) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return new Date(dateFormat.parse(value).getTime());
        }else if (String.class.equals(cls)) {
            return value;
        }
        return null;
    }
}
