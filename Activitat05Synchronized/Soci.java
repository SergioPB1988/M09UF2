import java.util.Random;

public class Soci extends Thread {
    private static final float APORTACIO = 10f;
    private static final int MAX_ANY = 10;
    private static final int ESPERA_MAX = 100;
    private Compte compte;
    private Random rnd;

    // Constructor que asigna la cuenta compartida
    public Soci(String nom) {
        super(nom);
        this.compte = Compte.getInstance();
        this.rnd = new Random();
    }

    // Método run, donde se simula el ingreso y retiro de dinero
    @Override
    public void run() {
        for (int any = 1; any <= MAX_ANY; any++) {
            for (int mes = 1; mes <= 12; mes++) {
                if (mes % 2 == 0) {
                    ingressar();
                } else {
                    retirar();
                }
                // Simulación del tiempo de espera aleatorio
                try {
                    Thread.sleep(rnd.nextInt(ESPERA_MAX));
                } catch (InterruptedException e) {
                    System.out.println(getName() + " ha estat interromput.");
                }
            }
        }
    }

    // Método synchronized para ingresar dinero
    private synchronized void ingressar() {
        compte.ingressar(APORTACIO);
        System.out.println(getName() + " ha ingressat " + APORTACIO + ". Saldo actual: " + compte.getSaldo());
    }

    // Método synchronized para retirar dinero
    private synchronized void retirar() {
        compte.retirar(APORTACIO);
        System.out.println(getName() + " ha retirat " + APORTACIO + ". Saldo actual: " + compte.getSaldo());
    }
}

