package main;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

        public static void main(String[] args) {
                int nCoches = 777; //Prueba con muchos hilo
                ArrayList<HiloCoche> listaCoches = new ArrayList();
                Podio podio = new Podio(new ArrayList<>());
                for (int i = 0; i <= nCoches; i++) { //genera tantos como haya en la variable nHilos y los añade a un ArrayList
                        listaCoches.add(new HiloCoche("c" + (i + 1), podio));
                        listaCoches.get(i).start();
                }

                for (HiloCoche coche : listaCoches) {
                        while (coche.isAlive()) { //Hace el bucle mientras algun hilo continue vivo
                                try {
                                        Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                }
                                sort(podio.getPodio()); // Llamada al metodo para ordenar
                                podio.imprimirPodio();  // Lamada al metodo de la clase "podio" para imprimirlo

                        }
                }
        }

        public static void sort(ArrayList<HiloCoche> podio) { //Ordena los hilos
                podio.sort((c2, c1) -> c1.getVueltasTotales().compareTo(c2.getVueltasTotales()));

        }

}
