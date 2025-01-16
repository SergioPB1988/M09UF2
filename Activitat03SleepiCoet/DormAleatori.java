import java.util.Random;

public class DormAleatori extends Thread {
    private long creationTime;
    private Random random = new Random();

    public DormAleatori(String name) {
        super(name);
        this.creationTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int interval = random.nextInt(1000);
            long totalTime = System.currentTimeMillis() - creationTime;
            System.out.printf("%s(%d) a dormir %dms total %d%n", getName(), i, interval, totalTime);
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");
        
        joan.start();
        pep.start();
        
        System.out.println("-- Fi de main -----------");
    }
}

