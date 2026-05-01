class Cafetera extends Thread{

    private final Deposito deposito;
    private final int totalCafes;

    public Cafetera (Deposito deposito, int totalCafes){
        this.deposito = deposito;
        this.totalCafes = totalCafes;
    }
    @Override
    public void run(){
        try {
            for (int i = 0; i < totalCafes; i++){
                deposito.depositarCafe();
            }
            System.out.println("--- La cafetera ha terminado de producir café. ---");
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
