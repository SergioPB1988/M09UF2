public class Associacio {
    private static final int NUM_SOCIS = 1000;
    private Soci[] socis;

    public Associacio() {
        socis = new Soci[NUM_SOCIS];
        for (int i = 0; i < NUM_SOCIS; i++) {
            socis[i] = new Soci("Soci-" + i);
        }
    }

    // Método para iniciar todos los hilos de los socios
    public void iniciaCompteTempsSocis() {
        for (Soci soci : socis) {
            soci.start();  // Iniciar los hilos
        }

        // Esperar a que todos los hilos terminen
        for (Soci soci : socis) {
            try {
                soci.join();  // Esperar a que el hilo termine
            } catch (InterruptedException e) {
                System.out.println("El procés ha estat interromput.");
            }
        }
    }

    // Método para mostrar el saldo final del compte
    public void mostraBalancComptes() {
        Compte compte = Compte.getInstance();
        System.out.println("Saldo final del compte: " + compte.getSaldo());
    }

    public static void main(String[] args) {
        Associacio associacio = new Associacio();
        associacio.iniciaCompteTempsSocis();  // Iniciar hilos y esperar que terminen
        associacio.mostraBalancComptes();     // Mostrar saldo final
    }
}

