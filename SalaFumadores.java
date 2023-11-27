public class SalaFumadores {

    public static int mesa = 0; // indicará qué elemento falta en la mesa
    public static boolean alguienFumando = false;



    public synchronized void entrafumar( int ingrediente){
        while(mesa != ingrediente || alguienFumando){
            try {
                System.out.println("El fumador "+ ingrediente + " no puede fumar aún.");
                wait();
            } catch (InterruptedException e) {e.printStackTrace();}
        }
        // se hace el cigarro
        mesa = 0; //mesa vacía
        //fuma
        alguienFumando = true;
    }
    public synchronized void terminafumar(int id){
        alguienFumando = false;
        notifyAll();
    }

    public synchronized void colocar(int noesta){
        while(mesa != 0 || alguienFumando){
            try {
                //System.out.println("No puedo poner ingredientes aún");
                wait();
            } catch (InterruptedException e) {e.printStackTrace();}
        }
        mesa = noesta;
        System.out.println("En la mesa no hay ingrediente "+ mesa);
        notifyAll();
    }
}