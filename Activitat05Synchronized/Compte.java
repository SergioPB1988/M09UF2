public class Compte {
    private static Compte instancia;
    private float saldo;

    // Constructor privado para el patrón Singleton
    private Compte() {
        saldo = 0.0f;
    }

    // Método para obtener la única instancia de Compte
    public static synchronized Compte getInstance() {
        if (instancia == null) {
            instancia = new Compte();
        }
        return instancia;
    }

    // Synchronized para asegurar que solo un hilo acceda a este método a la vez
    public synchronized void ingressar(float quantitat) {
        saldo += quantitat;
    }

    public synchronized void retirar(float quantitat) {
        saldo -= quantitat;
    }

    public float getSaldo() {
        return saldo;
    }
}

