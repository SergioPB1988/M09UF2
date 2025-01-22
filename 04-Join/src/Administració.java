public class Administració {
    private static final int NUM_POBLACIO_ACTIVA = 50;
    private Treballador[] poblacioActiva;

    // Constructor que inicializa los 50 trabajadores
    public Administració() {
        poblacioActiva = new Treballador[NUM_POBLACIO_ACTIVA];
        for (int i = 0; i < NUM_POBLACIO_ACTIVA; i++) {
            poblacioActiva[i] = new Treballador("Ciutadà-" + i, 25000, 20, 65);
        }
    }

    // Método principal
    public void run() {
        // Iniciar los hilos de los trabajadores
        for (Treballador treballador : poblacioActiva) {
            treballador.start();
        }

        // Esperar a que todos los trabajadores terminen
        for (Treballador treballador : poblacioActiva) {
            try {
                treballador.join();  // Esperar a que el hilo termine
            } catch (InterruptedException e) {
                System.out.println("El procés ha estat interromput.");
            }
        }

        // Mostrar estadístiques
        for (Treballador treballador : poblacioActiva) {
            System.out.println(treballador.getName() + " -> edat: " + treballador.getEdat() + " / total: " + String.format("%.2f", treballador.getCobrat()));
        }
    }

    // Método main para ejecutar la simulación
    public static void main(String[] args) {
        Administració administracio = new Administració();
        administracio.run();
    }
}

