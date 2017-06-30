package vnOIE;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class vnOIE {

		public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		// TODO Auto-generated method stub

		//***************************************************************
		/**
		 *   read data from File and write data into sentenceList
		 */		
				
			  String inputFileName = "resources/VnDTv1.CoNLL";
			
			
			
			// read data from file and write into List by sentence. 
			// Every line is a sentence and every word of sentence is a KeyWord
			List<Sentence> sentenceList = new ArrayList<Sentence>();
			DataWriter 		Writer      = new DataWriter();
			sentenceList = Writer.writeSentenceList(inputFileName); 
						//the total number of sentences of data file: 10197
			
			
				
		//***************************************************************		
		/**
		 *  write sentenceList into the file. Giving clause types  
		 * 
		 */	
			
			//write data from sentence List into file
			String outputFileName = "resources/outPut_vnOIE.txt";
			
			Writer.writeFile_SetClause(outputFileName, sentenceList);
			
							
		} //void main

}
