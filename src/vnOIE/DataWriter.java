package vnOIE;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class DataWriter {
	
	/**
	 *  function main use to read data file and write into a List
	 *  @param  data file  
	 *  @return write data into List that every line is content of a sentence and every word is a KeyWord, 
	 *    
	 */
	public List<Sentence> writeSentenceList(String fileName) throws UnsupportedEncodingException, IOException{
		
		List<Sentence> sentenceList = new ArrayList<Sentence>();
		sentenceList = writeSentenceList_FromFile(fileName);
		sentenceList = addRelationKeyWord(sentenceList);
			
		return sentenceList;		
	}
	
	/**
	 *  read data from file and write into a list. However, it don't have add RelationKeyWord  
	 *  @return  Sentence list  
	 */
	
	public List<Sentence> writeSentenceList_FromFile(String fileName) throws UnsupportedEncodingException, IOException{
		List<String> dataList = new ArrayList<String>();
				
		DataReader readFile = new DataReader();
		
		//******** read from data file into the List  **************
			dataList = readFile.readFile(fileName);
		
				
		//** Write data from List into  SentenceList
		List<Sentence> sentenceList = new ArrayList<Sentence>();
			
			int count = 0;       //count the number of lines in a sentence
			int j = 0;           //starting position in a sentence
			for(int i=0; i<dataList.size(); i++){
				if ((dataList.get(i).toString().isEmpty()) && (count>1)){
					Sentence sentence = new Sentence();
					
					String line = "";
					String[] wordLine;
					String idWord, token, tag, dependenceId, dependenceType;
					KeyWord kWord;
					
					for (int k=0; k<count; k++){
						
						//create new KeyWord from a line
						line = (String) dataList.get(j);
												
						wordLine = readFile.ReadWordLine(line);
												
						idWord          = wordLine[0];
						token           = wordLine[1];
						tag             = wordLine[4];
						dependenceId    = wordLine[6]; 
						dependenceType  = wordLine[7];
						
						kWord = new KeyWord(idWord, token, tag, dependenceId, dependenceType);
										
						
						//add the KeyWord in sentence 
						sentence.addKeyWord(kWord);
											
						j++;
					}
					sentenceList.add(sentence);
					
					j = 0;
					count = 0;
				}
				else{
					if (count == 0){
						j = i;  
					}
					count++;
				}
			}
		return sentenceList;
	}
	/**
	 *  
	 *  add RelationKeyWord
	 *  @return  Sentence list  
	 */
	
	public List<Sentence> addRelationKeyWord(List<Sentence> _sentenceList){
		List<Sentence> sentenceList = new ArrayList<Sentence>();
		sentenceList = _sentenceList;
		
		Sentence sentence = new Sentence();
		KeyWord kWord = new KeyWord();
		KeyWord kWordFind = new KeyWord();
		
		for (int i=0; i<sentenceList.size(); i++ ){	
			sentence = sentenceList.get(i);
			
			for (int j=0; j<sentence.size(); j++){
				kWord = sentence.get(j);
				
				for (int k=0; k<sentence.size();k++){
					kWordFind = sentence.get(k);			
					if (kWord.getId().contentEquals(kWordFind.getDependenceId())){
						kWord.addRelationKeyWord(kWordFind);
					}		
				}	
			}
		}
		
		return sentenceList;
	}
		
	//***************************************************************************
	/**
	 *  write data into File according to sentence 
	 *  @param  sentence list and file name used to save data   
	 *  @return write data into file 
	 *    
	 */
	public void writeFile(String fileName, List<Sentence> sentenceList) throws IOException{
		try{
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
			
			String sentenceLine; 
			
			
			for(int i=0; i<sentenceList.size(); i++){
		
				sentenceLine = "";
				for(int j=0; j<sentenceList.get(i).size(); j++){
					//sentenceLine = sentenceLine + sentenceList.get(i).getWordAt(j)+"\t";
					sentenceLine = sentenceLine + sentenceList.get(i).getWordAt(j)+" ";
				}
				sentenceLine = (i+1)+": "+sentenceLine+ "\t"+ sentenceList.get(i).size();
				
				writer.write(sentenceLine);	
				writer.newLine();
					
			}
						
			writer.close();
			System.out.println("write successfull about write data from sentenceList into file");
			
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
			
	} //end void write file
	
	//****************************************************************
	/**
	 * write sentenceList into file. Giving clause types
	 * @param fileName and sentenceList
	 * @return dataFile
	 *  
	 */
	
	public void writeFile_SetClause(String fileName, List<Sentence> sentenceList) throws IOException{
		BufferedWriter writer   = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
		
		Constituent constituent = new Constituent();  
		SetClause setClause     = new SetClause();
		
		List<String> ClauseTypeList = new ArrayList<String>();
		
		
		String sentenceLine;
		String[] strVerbNumber;
		
		int countWord, countTrueSentence, countFalseSentence, lineNumber, sentenceNumber;
		countWord          = 0;
		countTrueSentence  = 0;
		countFalseSentence = 0;
		sentenceNumber	   = 0;
		
		lineNumber         = 0;
		
		
		for(int i=0; i<sentenceList.size(); i++){
			//write data into file about content of sentence and true or false sentence
			//[1] if sentence is true
			//[0] if sentence is false
			sentenceLine="";
			ClauseTypeList = setClause.setOfClause(sentenceList.get(i));
			if ((constituent.isSentence(sentenceList.get(i))
					&& (ClauseTypeList.size()>2))){
				//sentenceLine = "[1]"+" ";
				countTrueSentence++;
				countWord = 0;
				for(int j=0; j<sentenceList.get(i).size(); j++){
					sentenceLine = sentenceLine + sentenceList.get(i).getWordAt(j)+" ";
					//count word number
					if (!(sentenceList.get(i).getDependenceTypeAt(j).contentEquals("punct"))){
						countWord++;
					}
				}
				
				
				sentenceLine = (countTrueSentence)+": "+sentenceLine+"\t"+countWord;
				
			}
			else{
				//sentenceLine = "[0]"+" ";
				countFalseSentence++;
			}
			
			//Next, write data into file about set of clause types 
			
			
			if ((!ClauseTypeList.isEmpty())
					&& constituent.isSentence(sentenceList.get(i))
					&& (ClauseTypeList.size()>2)){
				
								
				strVerbNumber = ClauseTypeList.get(ClauseTypeList.size()-2).split("\\t\t");
				
				int verbNumber=0;
				
				verbNumber = Integer.parseInt(strVerbNumber[1]);
				
				//write clause types of sentence into file. Clause types has larger than 1 verb.
				if (verbNumber >= 1){
				
				//write to the file according to the verb number of the sentence
				//if (verbNumber > 6){
				
			//write clause types of sentence into file. Clause types has 1 verb. 
				//if (verbNumber == 1){
				
			//write clause types of sentence into file. Clause types has  2 and 3 verb.
				//if ((verbNumber>1) && (verbNumber<=3)){
				
			//write clause types of sentence into file. Clause types has  4,5 and 6 verb.
				//if (verbNumber>3){
				//if ((verbNumber>3) && (verbNumber<=6)){
				
			//write clause types of sentence into file. Clause types has  larger than 7 verb.
				//if (verbNumber>6){
					
					
					//write sentence content into file
					lineNumber++;
					sentenceNumber++;
					sentenceLine = lineNumber + "\t" + sentenceNumber + "\t" + sentenceLine;
					
					
					
					writer.write(sentenceLine);	
					writer.newLine();

					
					//write clause type into file
					for(int k=0; k<ClauseTypeList.size(); k++){
						
						//sentenceLine = ClauseTypeList.get(k);
						lineNumber++;
						sentenceLine = lineNumber + "\t" + sentenceNumber + "\t" + ClauseTypeList.get(k);
						
						writer.write(sentenceLine);	
						writer.newLine();
					}
					writer.newLine();
						
				}
				
				
				
			}
		}
		
		
		String totalSentenceNumber;
		totalSentenceNumber = "Total sentence number in file: " + "\t" + sentenceNumber;
		writer.write(totalSentenceNumber);	
		writer.newLine();
		
		writer.close();
		System.out.println("write successfull about input data into file. Giving clause types");
		System.out.println("The total number of sentences has in file: \t"+sentenceList.size());
		System.out.println("The total number of sentences are true: \t"+countTrueSentence);
		System.out.println("The total number of sentences are false: \t"+countFalseSentence);
	
	} //end void


	
	
	//***************************************************************
	/*
	 *  print all data from sentence List
	 *  
	 */
	
	public void printSentenceList(List<Sentence> sentenceList){
		
		for(int i=0; i<sentenceList.size(); i++){
			System.out.println("\n\n************* Sentence: "+i+"*********************");
			sentenceList.get(i).printSentenceContent();
			//sentenceList.get(i).printSentenceKeyWord();
		}	
		
	}

}
