package it.polito.tdp.babs.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.babs.db.BabsDAO;

public class Model {
		BabsDAO babsDAO;
		List<Station> stazioni ;
		
	public Model() {
		this.babsDAO = new BabsDAO();
		}
	
	public List<Station> getStazioni() {
		if(stazioni == null) {
			stazioni = babsDAO.getAllStations();
		}  
		return stazioni;
	}

	public List<Statistics> getStats(LocalDate ld) {
		//numero di volte in cui la bici è stata presa e numero di volte in cui è stata lasciata
		List<Statistics> stats = new ArrayList<Statistics>();
		
		
		for(Station stazione: this.getStazioni()) {
			int picks = babsDAO.getPickNumber(stazione, ld); //biciclette prese
			int drops = babsDAO.getDropNumber(stazione, ld); //biciclette passate 
			Statistics stat = new Statistics(stazione, picks, drops);
			stats.add(stat);
		}
		return stats;
	}

}
