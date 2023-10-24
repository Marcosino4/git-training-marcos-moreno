package main;

import java.util.Random;

public class HiloCoche extends Thread {
	private Integer vueltasTotales = 0;
	private String ide;
	private Podio podio;

	public HiloCoche(String ide, Podio podio) {
		this.ide = ide;
		this.podio = podio;
	}

	public String getIde() {
		return ide;
	}

	public void setId(String ide) {
		this.ide = ide;
	}

	public Integer getVueltasTotales() {
		return vueltasTotales;
	}

	public void setVueltasTotales(Integer vueltasTotales) {
		this.vueltasTotales = vueltasTotales;
	}

	public Podio getPodio() {
		return podio;
	}

	public void setPodio(Podio podio) {
		this.podio = podio;
	}

	public void run() {
		Random r = new Random();
		podio.getPodio().add(this);
		try {
			for(int vueltas = 0; vueltas <= 10; vueltas++){
				long espera = r.nextLong(2500) + 500;
				Thread.sleep(espera);
				if(podio.contains(this)) {
					podio.update(this);
				}else {
					podio.add(this);
				}
				this.vueltasTotales = vueltas;

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
