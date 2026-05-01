public class Main {

    public static void main(String[] args) {

        int capacidadMaxima = 5;
        int totalCafes = 20;
        Deposito deposito = new Deposito(capacidadMaxima);
        Cafetera cafetera = new Cafetera(deposito, totalCafes);

        Profesor p1 = new Profesor(deposito, "Laura", 7);
        Profesor p2 = new Profesor(deposito, "Pablo", 6);
        Profesor p3= new Profesor(deposito, "Juan", 7);

        System.out.println("Inicio de la preparación de cafés");

        cafetera.start();
        p1.start();
        p2.start();
        p3.start();

        try {
            cafetera.join();
            p1.join();
            p2.join();
            p3.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Fin de la preparación de cafés");
    }
}
