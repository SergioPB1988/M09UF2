import java.util.Random;

public class Motor extends Thread {
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    private Random random = new Random();

    public void setPotencia(int p) {
        this.potenciaObjectiu = p;
    }

    @Override
    public void run() {
        while (true) {
            if (potenciaActual < potenciaObjectiu) {
                potenciaActual++;
                System.out.printf("Motor %s: Incre. Objectiu: %d Actual: %d%n", getName(), potenciaObjectiu, potenciaActual);
            } else if (potenciaActual > potenciaObjectiu) {
                potenciaActual--;
                System.out.printf("Motor %s: Decre. Objectiu: %d Actual: %d%n", getName(), potenciaObjectiu, potenciaActual);
            } else {
                System.out.printf("Motor %s: FerRes Objectiu: %d Actual: %d%n", getName(), potenciaObjectiu, potenciaActual);
                if (potenciaActual == 0) {
                    break;
                }
            }

            try {
                Thread.sleep(random.nextInt(1000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

