package doukakumain;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class BitTetris {
	private final int COLUMN_HEIGHT = 8;

	public String sequence(String tetrominos){
		String[] columns = tetrominos.split("-");
		//�e����r�b�g��iString�j��
		List<String> colBin = new ArrayList<String>();
		for(int i=0, width = columns.length;i<width;i++){
			int colInt = Integer.parseInt(columns[i],16);
			colBin.add(Integer.toBinaryString(colInt));
		}
		BitSet linesToClear = detCols(columns,colBin);

		return null;
	}
	private BitSet detCols(String[] columns, List<String> colBin){
		BitSet madeline = new BitSet(COLUMN_HEIGHT);

		//���ڂ̊e�s�ɂ��ā@
		for(int i=0; i<COLUMN_HEIGHT; i++){
			if (colBin.get(0).charAt(i)==1){
				madeline.set(i, true);
			}else{
				madeline.set(i, false);
			}
		}
		//�e��̊e�s�ɂ���
		for(int col=1, size=columns.length; col<size;col++){

			for(int row=COLUMN_HEIGHT-1;row>=0;row--){
				if(madeline.get(row)==false){
					continue;
				}else{
					if(colBin.get(col).charAt(row)==1){
						continue;
					}else{
						madeline.flip(col);
					}
				}

			}
		}
		return madeline;
	}
	private String Clear(BitSet LTClear, List<String> colBin){
		List<String> afterCols = new ArrayList<String>();
		for(int i = COLUMN_HEIGHT-1;i >= 0 ;i--){
			if (LTClear.get(i) == true){
				for(String aCol : colBin){
					StringBuilder sb = new StringBuilder();
					sb.append(aCol.substring(0, i));
					aCol = aCol + "0";
					sb.append(aCol.substring(i+1));
				}

		}
	}
	return null;
}
}
