package vnOIE;

import java.util.ArrayList;
import java.util.List;


public class Sentence{
	
	private List<KeyWord> sentence;
	
	
	public Sentence(){
		sentence = new ArrayList<KeyWord>();
	}
	//***************************************************************
	public void addKeyWord(KeyWord kWord){
		sentence.add(kWord);
	}
	//***************************************************************
	public KeyWord get(int pos){
		return sentence.get(pos); 
	}
	//***************************************************************
	public String getIdAt(int pos){
		return sentence.get(pos).getId();
	}
	//***************************************************************
	public String getWordAt(int pos){
		return sentence.get(pos).getWord();
	}
	//***************************************************************
	public String getPosTagAt(int pos){
		return sentence.get(pos).getPosTag();
	}
	//***************************************************************
	public String getDependenceIdAt(int pos){
		return sentence.get(pos).getDependenceId();
	}
	//***************************************************************
	public String getDependenceTypeAt(int pos){
		return sentence.get(pos).getDependenceType();
	}
	
	//***************************************************************
	/**
	 *  get content of a KeyWord
	 *  @param  id of a KeyWord  
	 *  @return a KeyWord according to id, 
	 *    
	 */  
	public KeyWord getKeyWordById(String id){
		KeyWord kWord = new KeyWord();
		
		for(int i=0; i<sentence.size(); i++){
			if (sentence.get(i).getId().contentEquals(id)){
				 kWord = sentence.get(i);
				
				 
			}
		}
		return kWord;		 
	}
	
	//***************************************************************	
	public void clear(){
		sentence.clear();
	}
	//***************************************************************
	public int size(){
		return sentence.size();
	}

	//***************************************************************
	/**
	 * 
	 * @return true if sentence have question
	 */

	public boolean isQuestion(){		
		for(int i=0; i<sentence.size(); i++){
			if (sentence.get(i).getWord().contains("?")){
				return true;				
			}
		}
		return false;
	}

	//***************************************************************
	/**
	 * 
	 * @param ID1, ID2 is number id in a sentence        
	 * @return  
	 */
	public boolean isCompareRemote2ID(KeyWord kwVerb, KeyWord kWord){
					
		int id1, id2;
		id1 = Integer.parseInt(kwVerb.getId());
		id2 = Integer.parseInt(kWord.getId());
		
		
		if (id1 < id2){
			if ((id2-id1) <= 2){
				
				return true;
			}
		}
		else{
			if ((id1-id2) <= 2){
				
				return true;
			}
		}
		return false;
	}
	
	//***************************************************************
	/**
	 * 
	 * @param idCoord
	 * @return a KeyWord about Conj of Coord
	 */
	public KeyWord getKeyWordConjByCoord(String idCoord){
		KeyWord kWord = new KeyWord();
		for(int i=0; i<sentence.size(); i++){
			if (sentence.get(i).getDependenceId().contentEquals(idCoord)
					&& sentence.get(i).getDependenceType().contentEquals("conj")){
				 kWord = sentence.get(i);
			}
		}
		return kWord;
		 
	}
		

	//***************************************************************
	/*
	 *  print the contents of a sentence
	 *  
	 */
	
	public void printSentenceContent(){
		for(int i=0; i<sentence.size(); i++){
			//System.out.print(sentence.get(i).getWord()+"\t");
			System.out.print(sentence.get(i).getWord()+" ");
			
		}
		System.out.println("\n");
	}

	//***************************************************************
	/*
	 * print Words of a sentence with every word is a KeyWord 
	 */
	public void printSentenceKeyWord(){
		for(int i=0; i<sentence.size(); i++){
			sentence.get(i).printKeyWord();
			System.out.println("\n");
		}
	}




}
