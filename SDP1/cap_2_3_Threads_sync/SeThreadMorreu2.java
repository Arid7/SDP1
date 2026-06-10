// Autor: Celso Paim 
// Data: Jan/2026
// Demonstrar que uma thread morre com as instrucoes devidas
// solucao marcar como daemon apos executar a sua tarefa ou garantir que termina de facto
     
public class SeThreadMorreu2 {

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(() -> {
            while ( true ) {
                System.out.println( "Thread executando..." );
                try { 
                    Thread.sleep( 1000 ); 
                } 
                catch ( InterruptedException ex ) {
                    ex.printStackTrace(); 
                }
            }
        });
        t.setDaemon( true );
        t.start();        
        System.out.println( "Todas as instrucoes do main ja foram executadas" );
    }
}
