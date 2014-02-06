package doukakumain;

import java.util.ArrayList;
import java.util.List;

public class TickTackToe {
	private final int NUMBER_OF_BOXES = 9;
	private final Integer[][] LINES = {
		{1,2,3},
		{4,5,6},
		{7,8,9},
		{1,4,7},
		{2,5,8},
		{3,6,9},
		{1,5,9},
		{3,5,7}};
	
	public String tickTackToe(String notation){
		//ˆêèˆêè’²‚×‚Ä‚¢‚­
		List<Integer> marunotes = new ArrayList<Integer>();
		List<Integer> batsunotes = new ArrayList<Integer>();
		for(int i = 0; i<NUMBER_OF_BOXES-1; i++){
			String str = String.valueOf(notation.charAt(i));
			Integer theNote = Integer.valueOf(str);
			
			if (i % 2 == 0){
				//›‚Ì”Ô
				//foul”»’è
				if (isItFoul(theNote, marunotes, batsunotes)){
					return "Foul : x won.";
				}
				//›’Ç‰Á
				marunotes.add(theNote);
				
				//Ÿ—˜”»’è
				if(isLineMade(marunotes)){
					return "o won.";
				}
				
			}else{
				//~‚Ì”Ô
				//foul”»’è
				if (isItFoul(theNote, marunotes, batsunotes)){
					return "Foul : o won.";
				}
				//~’Ç‰Á
				batsunotes.add(theNote);
				//Ÿ—˜”»’è
				if(isLineMade(batsunotes)){
					return "x won.";
				}
			}
		}
		return "Draw game.";
	}
	
	private boolean isItFoul(Integer theNote, List<Integer> marus, List<Integer> batsus){
		if(marus.indexOf(theNote)!=-1 || batsus.indexOf(theNote)!=-1){
			return true;
		}
		return false;
	}
	
	private boolean isLineMade(List<Integer> notes){
		for(Integer[] line : LINES){
			int boxCounter = 0;
			//‚±‚Ìƒ‰ƒCƒ“‚Í‘µ‚Á‚Ä‚é‚©‚ÈH
			for(Integer box : line){
				if(notes.indexOf(box)!=-1){
					if(boxCounter==line.length-1){
						return true;
					}else{
						boxCounter++;
						continue;	
					}
				}else{
					break;
				}
			}
		}
		return false;	
	}
}
