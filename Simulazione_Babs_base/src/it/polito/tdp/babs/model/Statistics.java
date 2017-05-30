package it.polito.tdp.babs.model;

public class Statistics implements Comparable<Statistics>{
	
	private Station stazione;
	private int pick;
	private int drop;
	
	public Statistics(Station stazione, int pick, int drop) {
		super();
		this.stazione = stazione;
		this.pick = pick;
		this.drop = drop;
	}
	public Station getStazione() {
		return stazione;
	}
	public void setStazione(Station stazione) {
		this.stazione = stazione;
	}
	public int getPick() {
		return pick;
	}
	public void setPick(int pick) {
		this.pick = pick;
	}
	public int getDrop() {
		return drop;
	}
	public void setDrop(int drop) {
		this.drop = drop;
	}
	
	@Override
	public int compareTo(Statistics s) {
		return Double.compare(this.stazione.getLat(), s.stazione.getLat()); 
		//meglio usare Double.compare(d1, d2) -> se facessi il cast tutti i numeri dopo la virgola si perderebbero
		//nel caso delle lat non va bene perchè sarebbero tutte uguali
		
	}
	
	
	

}
