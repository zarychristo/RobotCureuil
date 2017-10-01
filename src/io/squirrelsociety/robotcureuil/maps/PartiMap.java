package io.squirrelsociety.robotcureuil.maps;

import java.util.HashMap;

import io.squirrelsociety.robotcureuil.objects.Parti;

public class PartiMap {
	private HashMap<String, Parti> partiMap = new HashMap<String, Parti>();
	
	public void register(Parti parti) {
		partiMap.put(parti.name, parti);
	}
	
	public HashMap<String, Parti> getMap() {
		return partiMap;
	}
}
