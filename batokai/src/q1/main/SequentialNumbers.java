package q1.main;

import java.util.ArrayList;
import java.util.List;

public class SequentialNumbers {
	List<Integer> sequentialNumberList;
	public SequentialNumbers(int minNumber, int maxNumber){ 
		List<Integer> numberSequence = new ArrayList<Integer>();
		for (int i = minNumber; i<=maxNumber; i++){
			numberSequence.add(i);
		}
		sequentialNumberList = numberSequence;
	}
	
	public SevenCount countSeven(){
		int sevenCount = 0;
		for (Integer number:sequentialNumberList){
			String stringValueOfNumber = number.toString();
			List<String> array = new ArrayList<String>();
			for ()
			array. add(stringValueOfNumber.toCharArray())
		}
		
	}
	
	class SevenCount{
		int amountOfSeven;
		public SevenCount(int sevenCount){
			this.amountOfSeven = sevenCount;
		}
	}

}
