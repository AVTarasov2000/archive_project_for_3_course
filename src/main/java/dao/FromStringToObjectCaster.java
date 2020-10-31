package dao;

public interface FromStringToObjectCaster {
    public <T> Object cast(Class<T> cls, String value);
}
