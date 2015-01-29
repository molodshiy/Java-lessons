public class AudioChannel {

    private int channellid;

    public AudioChannel(int id){
        super();
        this.channellid = id;
    }

    public int getChannellid(){
        return channellid;
    }

    public void setChannellid(int id){
        this.channellid = id;
    }
    
    public void using(){
        try{
            Thread.sleep(new java.util.Random().nextInt(500));
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
