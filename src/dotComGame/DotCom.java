package dotComGame;

import java.util.ArrayList;
import java.util.List;

public class DotCom {
	private List<String> locationCells;
	private String name;
	
	public DotCom() {
		name = "";
		locationCells = new ArrayList<String>();
	}
	
	public DotCom(String name) {
		this.name = name;
		locationCells = new ArrayList<String>();
	}
	
	public void setLocationCells(List<String> locations) {
		locationCells = locations;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String checkYourself(String userInput) {
		String result = "miss";
		
		int index = locationCells.indexOf(userInput);
		
		if (index >= 0) {
			locationCells.remove(index);
			
			if (locationCells.isEmpty()) {
				result = "kill";
			} else {
				result = "hit";
			}
		}
		
		return result;
	}

}
