package q1.main;

public class MainClass {

	public static void main(String[] args) throws Exception {
		MainClass mainClass = new MainClass();
		if (args.length < 1){
			throw new Exception();
		}
		mainClass.execute(args[0]);
	}
	
	private void execute(String MaxNumber){
		MaxNumber maxNum = new MaxNumber(Integer.valueOf(MaxNumber));
		MinNumber minNumber = new MinNumber();
		new SequentialNumbers(minNumber.MIN_NUMBER, maxNum.maxNumber);
	}
	
	class MaxNumber{
		int maxNumber;
		public MaxNumber(int maxNumber){
			this.maxNumber = maxNumber;
		}
	}
	
	class MinNumber{
		final int MIN_NUMBER = 1;
//		private int minNumber;
//		public MinNumber(int minNumber){
//			this.minNumber = minNumber;
//		}	
	}
}
