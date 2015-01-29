public class Client extends Thread {

    private boolean reading = false;
    private ChanelPool<AudioChannel> pool;

    public Client (ChanelPool<AudioChannel> pool){
        this.pool = pool;
    }

    public void run(){
        AudioChannel channel = null;
        try {
            channel = pool.getResources(500);
            reading = true;
            System.out.println("Channel Client #" +this.getId() +"took cannel #" +channel.getChannellid());

            channel.using();

        } catch (ResourceException e) {
            System.out.println("Client #" +this.getId() +" lost ->" +e.getMessage());
        } finally {
            if(channel != null){
                reading = false;
                System.out.println("Channel Client #" +this.getId() +" : " +channel.getChannellid() +" channel released");

                pool.returnResourse(channel);
            }
        }
    }

    public boolean isReading(){
        return reading;
    }
}
