package dao;

public interface SubmitDao {

    void addSubmit(int sid, int hid);
    void submit(int sid, int hid, String content);
}
