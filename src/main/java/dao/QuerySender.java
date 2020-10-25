package dao;

public interface QuerySender {
    void send(Query query, Receiver tableReceiver);
}
