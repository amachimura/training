package doukakumain;

import java.util.ArrayList;
import java.util.List;

public class NichiGazou {
	private static final int NUM_OF_HEXA_BINS = 4;

	public String sequence(String mondai){
		String[] lengthAndHex = mondai.split(":");
		int sideLength = Integer.parseInt(lengthAndHex[0]);
		//16進数を2進数のリスト（二値画像）に
		List<String> binaries = hexToBin(sideLength, lengthAndHex[1]);
		//時計回りに回転
		List<String> spinnedBinaries = spin(binaries);
		//16進数に直す
		String hexas = binToHex(sideLength, spinnedBinaries);
		String kotae = String.valueOf(sideLength)+":"+hexas;

		return kotae;
	}

	private List<String> hexToBin(int sideLength, String hex){
		StringBuilder bins = new StringBuilder();
		Long decimal = Long.parseLong(hex,16);
		bins.append(Long.toBinaryString(decimal));
		int headZeros = (NUM_OF_HEXA_BINS-(bins.length()%NUM_OF_HEXA_BINS));
		if(headZeros == NUM_OF_HEXA_BINS){
			headZeros=0;
		}
		for(int i=0; i<headZeros; i++){
			bins.insert(0, "0");
		}

		List<String> result = new ArrayList<String>();
		//辺の長さ分ずつ切り取ってListに格納
		for (int i=0; i<sideLength;i++){
			int beginPoint = i*sideLength;
			int endPoint = beginPoint+sideLength;
			result.add(bins.substring(beginPoint, endPoint));
		}

		return result;
	}

	private List<String> spin(List<String> previous){
		List<String> result = new ArrayList<String>();
		//各列のビットを順にListに格納
		for (int i=0, width=previous.size(); i<width; i++){
			StringBuilder aLine = new StringBuilder();
			//一行のビット列
			for (int j=0, height=previous.size(); j<height; j++){
				aLine.insert(0,previous.get(j).charAt(i));
			}
			result.add(aLine.toString());
		}
		return result;
	}

	private String binToHex(int sideLength, List<String> bin){

		StringBuilder binaries = new StringBuilder();
		for(String bins : bin){
			binaries.append(bins);
		}
		int tailZeros =NUM_OF_HEXA_BINS-(binaries.length()%NUM_OF_HEXA_BINS);
		if(tailZeros == NUM_OF_HEXA_BINS){
			tailZeros = 0;
		}

		for(int i=0;i<tailZeros;i++){
			binaries.append("0");
		}

		int answerLength = binaries.length()/NUM_OF_HEXA_BINS;
		List<String> fourBins = new ArrayList<String>();
		for (int i=0; i<answerLength;i++){
			int beginPoint = i*NUM_OF_HEXA_BINS;
			int endPoint = beginPoint+NUM_OF_HEXA_BINS;
			if (endPoint < binaries.length()){
				fourBins.add(binaries.substring(beginPoint, endPoint));
			}else{
				fourBins.add(binaries.substring(beginPoint));
			}
		}

		StringBuilder Hexas = new StringBuilder();
		for (String fourBin : fourBins){
			Long LongForm = Long.parseLong(fourBin,2);
			String hexaForm = Long.toHexString(LongForm);
			Hexas.append(String.valueOf(hexaForm));
		}

		return Hexas.toString();
	}
}
