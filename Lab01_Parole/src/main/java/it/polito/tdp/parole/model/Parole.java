package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	List<String> parole;
	
	public Parole() {
		parole = new LinkedList<String>();
	}
	
	public void addParola(String p) {
    	if (p.length()==0) {
    		System.err.println("Non hai inserito alcuna parola!");
    		return;
    	}
    	
		parole.add(p);
		
	}
	
	public void rimuoviParola(String p) {
		for (String s : parole)
			if (s.compareTo(p)==0) 
				parole.remove(p);
	
	}
	
	public List<String> getElenco() {
		parole.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		
		return parole;
	}
	
	public String getElencoString() {	
		StringBuffer s = new StringBuffer();
		for (String wip : this.getElenco())
    		s.append(wip + "\n");
		
		 return s.toString();
	}
	
	
	public void reset() {
		parole.removeAll(parole);
	}

}
