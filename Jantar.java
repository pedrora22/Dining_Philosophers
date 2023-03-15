package philo;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jantar {

    public static void main(String[] args) {
        Jantar test = new Jantar();
        test.exec();
    }

    public void exec() {
        Garfos garfo1 = new Garfos(1, 5);
        Garfos garfo2 = new Garfos(2, 1);
        Garfos garfo3 = new Garfos(3, 2);
        Garfos garfo4 = new Garfos(4, 3);
        Garfos garfo5 = new Garfos(5, 4);

        Filosofos filosofo1 = new Filosofos("Descartes", garfo1, 1);
        Filosofos filosofo2 = new Filosofos("Kant", garfo2, 2);
        Filosofos filosofo3 = new Filosofos("Confucio", garfo3, 3);
        Filosofos filosofo4 = new Filosofos("Agostinho", garfo4, 4);
        Filosofos filosofo5 = new Filosofos("Nietzsche", garfo5, 5);

        new Thread(filosofo1).start();
        new Thread(filosofo2).start();
        new Thread(filosofo3).start();
        new Thread(filosofo4).start();
        new Thread(filosofo5).start();
    }

    public class Garfos extends Thread {
        int esquerda;
        int direita;

        public Garfos(int esquerda, int direita) {
            this.esquerda = esquerda;
            this.direita = direita;
        }

        public void run() {
            while (true) {
                try {
                    SorteioDireita();
                    SorteioEsquerda();
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        }

        public void SorteioDireita() {
            int Direita;
            Random randomico = new Random();
            Direita = randomico.nextInt();
            System.out.println("O garfo da direita sorteado" + Direita);
        }

        public void SorteioEsquerda() {
            int Esquerda;
            Random randomico = new Random();
            Esquerda = randomico.nextInt();
            System.out.println("O garfo da direita sorteado" + Esquerda);
        }


    }

    public class Filosofos extends Thread {
        String nome;
        Garfos garfo;
        int lugar;

        public Filosofos(String nome, Garfos garfo, int lugar) {
            this.nome = nome;
            this.garfo = garfo;
            this.lugar = lugar;

            System.out.println("O filosofo " + nome + " sentou-se.");
        }

        public void Pensar() throws InterruptedException {
            System.out.println("O filosofo " + nome + " esta pensando no momento.");
            Thread.sleep(1000);
        }

        public void run() {
            while (true) {
                if (garfo.direita == 5) {
                    System.out.println("O filosofo " + nome + " pegou o garfo de número " + garfo.direita);
                    if (garfo.esquerda == 1) {
                        System.out.println("O filosofo " + nome + " pegou o garfo " + garfo.esquerda);
                        System.out.println("O filosofo " + nome + " está comendo");
                        System.out.println("O filosofo " + nome + " largou o garfo da direita");
                        System.out.println("O filosofo " + nome + " largou o garfo da esquerda");
                    } else {
                        System.out.println("O filosofo " + nome + " largou o garfo " + garfo.direita);
                    }
                } else {
                    try {
                        Pensar();
                    } catch (InterruptedException excpt) {
                        System.out.println(excpt);
                        //Logger.getLogger(Jantar.class.getName()).log(Level.SEVERE, null, excpt);
                    }
                }

                if (garfo.direita == 1) {
                    System.out.println("O filosofo " + nome + " pegou o garfo de número " + garfo.direita);
                    if (garfo.esquerda == 2) {
                        System.out.println("O filosofo " + nome + " pegou o garfo " + garfo.esquerda);
                        System.out.println("O filosofo " + nome + " está comendo");
                        System.out.println("O filosofo " + nome + " largou o garfo da direita");
                        System.out.println("O filosofo " + nome + " largou o garfo da esquerda");
                    } else {
                        System.out.println("O filosofo " + nome + " largou o garfo " + garfo.direita);
                    }
                } else {
                    try {
                        Pensar();
                    } catch (InterruptedException excpt) {
                        System.out.println(excpt);
                    }
                }
                if (garfo.direita == 2) {
                    System.out.println("O filosofo " + nome + " pegou o garfo de número " + garfo.direita);
                    if (garfo.esquerda == 3) {
                        System.out.println("O filosofo " + nome + " pego o garfo " + garfo.esquerda);
                        System.out.println("O filosofo " + nome + " está comendo");
                        System.out.println("O filosofo " + nome + " largou o garfo da direita");
                        System.out.println("O filosofo " + nome + " largou o garfo da esquerda");
                    } else {
                        System.out.println("O filosofo " + nome + " largou o garfo " + garfo.direita);
                    }
                } else {
                    try {
                        Pensar();
                    } catch (InterruptedException excpt) {
                        System.out.println(excpt);
                    }
                }
                if (garfo.direita == 4) {
                    System.out.println("O filosofo " + nome + " pegou o garfo de número " + garfo.direita);
                    if (garfo.esquerda == 5) {
                        System.out.println("O filosofo " + nome + " pego o garfo " + garfo.esquerda);
                        System.out.println("O filosofo " + nome + " está comendo");
                        System.out.println("O filosofo " + nome + " largou o garfo da direita");
                        System.out.println("O filosofo " + nome + " largou o garfo da esquerda");
                    } else {
                        System.out.println("O filosofo " + nome + " largou o garfo " + garfo.direita);
                    }
                } else {
                    try {
                        Pensar();
                    } catch (InterruptedException excpt) {
                        System.out.println(excpt);
                    }
                }
            }

        }
    }
}
