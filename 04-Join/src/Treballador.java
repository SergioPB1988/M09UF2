import java.util.Random;

public class Treballador extends Thread {
    private float souAnualBrut;
    private int edatIniciTreball;
    private int edatFiTreball;
    private int edatActual;
    private float cobrat;
    private Random rnd;

    // Constructor
    public Treballador(String nom, float souAnualBrut, int edatIniciTreball, int edatFiTreball) {
        super(nom);  // Establecemos el nombre usando la clase Thread
        this.souAnualBrut = souAnualBrut;
        this.edatIniciTreball = edatIniciTreball;
        this.edatFiTreball = edatFiTreball;
        this.edatActual = 0;  // Empieza desde 0
        this.cobrat = 0.0f;   // Inicialmente no ha cobrado nada
        this.rnd = new Random();
    }

    // Método que simula cobrar cada mes
    private void cobra() {
        cobrat += (souAnualBrut / 12);  // Incrementa el sueldo mensual bruto
    }

    // Método que simula pagar impuestos cada mes
    private void pagaImpostos() {
        float impost = (souAnualBrut / 12) * 0.24f;  // 24% de impuestos
        cobrat -= impost;  // Restamos los impuestos al salario cobrado
    }

    // Método run que simula el ciclo de trabajo de un trabajador
    @Override
    public void run() {
        while (edatActual < edatFiTreball) {
            if (edatActual >= edatIniciTreball) {
                // Cobra cada mes
                cobra();
                pagaImpostos();
            }
            edatActual++;  // Incrementamos la edad cada año (simulamos año a año)

            // Espera aleatoria para simular el tiempo que pasa (en lugar de segundos serán milisegundos)
            try {
                Thread.sleep(rnd.nextInt(100));  // Simulación de tiempo de espera entre iteraciones
            } catch (InterruptedException e) {
                System.out.println(getName() + " ha sido interrumpido");
            }
        }
    }

    // Getters
    public float getCobrat() {
        return cobrat;
    }

    public int getEdat() {
        return edatActual;
    }
}

