// Autor: Celso Paim 
// Data: Abril/2026
// Demonstrar o conceito de lock e de sincronizacao entre threads

public class TesteSyncThreads {
    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK) {
                System.out.println("T1 obteve o recurso LOCK");
                try { 
                    Thread.sleep( 5000 ); 
                } 
                catch (InterruptedException e) {}
                System.out.println("T1 libertou o LOCK");
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            System.out.println("T2 tentando obter o LOCK...");
            synchronized (LOCK) { // Aqui ela vai ficar BLOCKED
                System.out.println("T2 conseguiu o recurso LOCK e esta a ser executada");                
            }
        }, "Thread-2");

        t1.start();
        Thread.sleep(100); // Garante que t1 pegue o lock primeiro
        t2.start();
        System.out.println("Estado da T2 no inicio: " + t2.getState());
        
        Thread.sleep(500); // Dá tempo pra t2 ficar blocked
        System.out.println("Estado da T2: " + t2.getState()); // BLOCKED
         
    }
}
    
