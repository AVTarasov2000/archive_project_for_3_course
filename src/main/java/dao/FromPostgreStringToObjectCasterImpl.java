package dao;

import java.sql.Date;

public class FromPostgreStringToObjectCasterImpl implements FromStringToObjectCaster {
    @Override
    public <T> Object cast(Class <T> cls, String value) {
        if (Integer.class.equals(cls)) {
            return Integer.parseInt(value);
        } else if (Date.class.equals(cls)) {
            String[] arr = value.split(" ");
            return new Date(Integer.parseInt(arr[0]), Integer.parseInt(arr[0]), Integer.parseInt(arr[0]));
        }else if (String.class.equals(cls)) {
            return value;
        }
        return null;
    }
}
