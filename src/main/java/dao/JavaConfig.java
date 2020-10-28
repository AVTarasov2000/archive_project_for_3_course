package dao;

public class JavaConfig implements Config {
    @Override
    public <T> Class <? extends T> getIplClass(Class <T> type) {
        return null;
    }
}
