import java.util.ArrayList;
import java.util.List;

class Deposito {

    private final int capacidadMaxima;
    private final List<Integer> cafes;
    private int idCafeCounter = 1;

    public Deposito (int capacidadMaxima){
        this.capacidadMaxima = capacidadMaxima;
        this.cafes = new ArrayList<>();
    }

    public synchronized void depositarCafe() throws InterruptedException{

        while (cafes.size() >= capacidadMaxima){
            System.out.println("-> [ESPERA] Depósito lleno. La cafetera espera...");
            wait();
        }
        try {
            Thread.sleep((long) (Math.random() * 1000) + 500); //Entre 0.5 y 1.5 segundos
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        int cafeId = idCafeCounter++;
        cafes.add(cafeId);

        System.out.println("Cafetera prepara y deposita Café " + cafeId + ". En depósito: " + cafes.size());
        notifyAll();
    }

    public synchronized void retirarCafe(String nombreProfesor) throws InterruptedException{

        while (cafes.isEmpty()){
            System.out.println("-> [ESPERA] " + nombreProfesor + " espera porque no hay café...");
            wait();
        }
        int cafeId = cafes.remove(0);
        System.out.println("Profesor " + nombreProfesor + " retira Cafe " + cafeId + ". En depósito: " + cafes.size());
        notifyAll();

        try {
            Thread.sleep((long) (Math.random() * 1500) + 500);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
