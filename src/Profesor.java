class Profesor extends Thread{

    private final Deposito deposito;
    private final String nombre;
    private final int cafesAConsumir;

    public Profesor(Deposito deposito, String nombre, int cafesAConsumir){
        this.nombre = nombre;
        this.deposito = deposito;
        this.cafesAConsumir = cafesAConsumir;
    }
    @Override
    public void run(){
        try {
            for(int i = 0; i < cafesAConsumir; i ++){
                deposito.retirarCafe(nombre);
            }
            System.out.println("Profesor " + nombre + " ha terminado su café diario");
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
