package dao;

import lombok.SneakyThrows;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class FromPostgreStringToObjectCasterImpl implements FromStringToObjectCaster {
    @SneakyThrows
    @Override
    public <T> Object cast(Class <T> cls, String value) {
        if (Integer.class.equals(cls)) {
            return Integer.parseInt(value);
        } else if (Date.class.equals(cls)) {
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZ yyyy");
            return dateFormat.parse(value);
        }else if (String.class.equals(cls)) {
            return value;
        }
        return null;
    }
}
