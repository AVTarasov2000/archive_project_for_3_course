package dao.daoInterfaces;

public interface FromStringToObjectCaster {
    public <T> Object cast(Class<T> cls, String value);
}
