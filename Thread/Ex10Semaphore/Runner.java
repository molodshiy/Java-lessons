import java.util.LinkedList;

public class Runner {
    public static void main(String[] args) {
    
        LinkedList<AudioChannel> list = new LinkedList<AudioChannel>(){
            {
                this.add(new AudioChannel(777));
                this.add(new AudioChannel(656));
                this.add(new AudioChannel(333));
                this.add(new AudioChannel(898));
                this.add(new AudioChannel(010));
            }
        };

        ChanelPool<AudioChannel> pool = new ChanelPool<>(list);
        for (int i = 0; i < 20; i++) {
            new Client(pool).start();
        }
    }
}
