// Autor: Celso Paim 
// Data: Jan/2026
// uma thread nao morre sem as instrucoes devidas
      
public class SeThreadMorreu1 {
    
    public static void main(String[] args) {
        new Thread(() -> {
            while( true ) {
                System.out.println( "Thread executando..." );
                try { 
                    Thread.sleep( 1000 ); 
                } 
                catch ( InterruptedException ex ) {
                    ex.printStackTrace(); 
                }
            }
        }
        ).start();
        
        System.out.println( "Todas as instrucoes do main ja foram executadas" );
    }
}

  
