public class SyncThreaad extends Thread{

    private Resourse rs;

    public SyncThreaad(String name, Resourse rs) {
        super(name);
        this.rs = rs;
    }

    public void run(){
        for (int i = 0; i < 5; i++) {
            rs.writing(getName(), i);
        }
    }
}
