package philo;

import java.util.concurrent.Semaphore;

public class Filosofo {
    public static void main(String[] args) {
        Jantar test = new Jantar();
        test.exec();
    }
}
