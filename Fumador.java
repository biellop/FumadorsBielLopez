public class Fumador extends Thread{
    private int id;
    private SalaFumadores sala;
    public Fumador(int id, SalaFumadores sala){
        this.id = id;
        this.sala = sala;
    }
    public void run(){
        while(true){
            try {
                sala.entrafumar(id);
                System.out.println("Fumador "+id+" está fumando.");
                Thread.sleep(1000);
                sala.terminafumar(id);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}