package main;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		int nCoches = 9;
		ArrayList<HiloCoche> listaCoches = new ArrayList();
		Podio podio = new Podio(new ArrayList<>());
		for (int i = 0; i <= nCoches; i++) {
			listaCoches.add(new HiloCoche("c" + (i + 1), podio));
			listaCoches.get(i).start();
		}

		for (HiloCoche coche : listaCoches) {
			while (coche.isAlive()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				sort(podio.getPodio());
				podio.imprimirPodio();

			}
		}
	}

	public static void sort(ArrayList<HiloCoche> podio) {
		podio.sort((c2, c1) -> c1.getVueltasTotales().compareTo(c2.getVueltasTotales()));

	}

}
