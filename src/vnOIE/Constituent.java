package vnOIE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Constituent {
	
	//***************************************************************
	/*
	 * all constituents of a sentence
	 * SUBJECT, VERB, DIRECT OBJECT, IN DIRECT OBJECT, VERB TO BE, COMPLEMENT, ADVERB 
	 * 
	 */
	
	//***************************************************************
	/**
	 * SUBJECT
	 * @param Verb, sentence 
	 * @return String Subject according to Verb 
	 * 
	 */
	public String subject(KeyWord kwVerb, Sentence sentence){
		String strSubject;
		HashMap<Integer,KeyWord> hmSubject = new HashMap<Integer, KeyWord>();
		hmSubject = getSubject(kwVerb, sentence); 

		strSubject 	   = convertedHashMapToString(hmSubject);
		return strSubject;
	} //end subject
		
	//***************************************************************
	/**
	 * VERB
	 * @param kwVerb, sentence 
	 * @return String verb according to kwVerb 
	 * 
	 */
	public String verb(KeyWord kwVerb, Sentence sentence){
		String strVerb;
		HashMap<Integer,KeyWord> hmVerb = new HashMap<Integer, KeyWord>();
		hmVerb = getVerb(kwVerb, sentence); 
		
		strVerb 	   = convertedHashMapToString(hmVerb);
		
		return strVerb;
	} //end verb
	
	//***************************************************************
	/**
	 * VERB 2
	 * @param kwVerb, sentence 
	 * @return String verb according to kwVerb 
	 * 
	 */
	public String verb2(KeyWord kwVerb1, KeyWord kwVerb2, Sentence sentence){
		String strVerb2;
		HashMap<Integer,KeyWord> hmVerb = new HashMap<Integer, KeyWord>();
		hmVerb = getVerb2(kwVerb1, kwVerb2, sentence); 
		
		strVerb2 	   = convertedHashMapToString(hmVerb);
		
		return strVerb2;
	} //end verb

	//***************************************************************
	/**
	 * VERB TO BE
	 * @param kwVerb, sentence 
	 * @return String Subject according to Verb 
	 * 
	 */
	public String verbToBe(KeyWord kwVerb, Sentence sentence){
		String strVerbToBe;
		HashMap<Integer,KeyWord> hmVerbToBe = new HashMap<Integer, KeyWord>();
		
		hmVerbToBe = getVerbToBe(kwVerb, sentence); 
		
		strVerbToBe   = convertedHashMapToString(hmVerbToBe);
		
		return strVerbToBe;
	} //end verbToBe

	//***************************************************************
	/**
	 * COMPLEMENT
	 * @param Verb, sentence 
	 * @return String Subject according to Verb 
	 * 
	 */
	public String complement(KeyWord kwVerb, Sentence sentence){
		String strComplement;
		HashMap<Integer,KeyWord> hmComplement = new HashMap<Integer, KeyWord>();
		hmComplement = getComplement(kwVerb, sentence); 
		
		strComplement 	   = convertedHashMapToString(hmComplement);
		
		return strComplement;
	} //end complement

	//***************************************************************
	/**
	 * DIRECT OBJECT
	 * @param Verb, sentence 
	 * @return String direct objetc according to Verb 
	 * 
	 */
	public String directObject(KeyWord kwVerb, Sentence sentence){
		String strDirectObject;
		HashMap<Integer,KeyWord> hmDirectObject = new HashMap<Integer, KeyWord>();
		hmDirectObject = getDirectObject(kwVerb, sentence); 
		
		strDirectObject 	   = convertedHashMapToString(hmDirectObject);
		
		return strDirectObject;
	} //end DirectObject	
	
	//***************************************************************
	/**
	 * IN DIRECT OBJECT
	 * @param Verb, sentence 
	 * @return String in direct object according to Verb 
	 * 
	 */
	public String inDirectObject(KeyWord kwVerb, Sentence sentence){
		String strInDirectObject;
		HashMap<Integer,KeyWord> hmInDirectObject = new HashMap<Integer, KeyWord>();
		hmInDirectObject = getInDirectObject(kwVerb, sentence); 
		
		strInDirectObject 	   = convertedHashMapToString(hmInDirectObject);
		
		return strInDirectObject;
	} //end DirectObject	
	
	//***************************************************************
	/**
	 * adverb of loc 
	 * @param kwVerb, sentence 
	 * @return String adverb of loc according to Verb 
	 * 
	 */
	public String adverbOfLoc(KeyWord kwVerb, Sentence sentence){
		String strLoc;
		HashMap<Integer,KeyWord> hmLoc = new HashMap<Integer, KeyWord>();
		hmLoc = getAdverbOfLoc(kwVerb, sentence); 
		
		strLoc 	   = convertedHashMapToString(hmLoc);
		
		return strLoc;
	} //end loc
	
	//***************************************************************
	/**
	 * adverb of tmp 
	 * @param kwVerb, sentence 
	 * @return String adverb tmp according to Verb 
	 * 
	 */
	public String adverbOfTmp(KeyWord kwVerb, Sentence sentence){
		String strTmp;
		HashMap<Integer,KeyWord> hmTmp = new HashMap<Integer, KeyWord>();
		hmTmp = getAdverbOfTmp(kwVerb, sentence); 
		
		strTmp 	   = convertedHashMapToString(hmTmp);
		
		return strTmp;
	} //end tmp	
	
	//***************************************************************
	/**
	 * adverb of direction 
	 * @param kwVerb, sentence 
	 * @return String adverb of dir according to Verb 
	 * 
	 */
	public String adverbOfDir(KeyWord kwVerb, Sentence sentence){
		String strDir;
		HashMap<Integer,KeyWord> hmDir = new HashMap<Integer, KeyWord>();
		hmDir = getAdverbOfDir(kwVerb, sentence); 
		
		strDir 	   = convertedHashMapToString(hmDir);
		
		return strDir;
	} //end Dir	

	//***************************************************************
	/**
	 * adverb of manner 
	 * @param kwVerb, sentence 
	 * @return String adverb of mnr according to Verb 
	 * 
	 */
	public String adverbOfMnr(KeyWord kwVerb, Sentence sentence){
		String strMnr;
		HashMap<Integer,KeyWord> hmMnr = new HashMap<Integer, KeyWord>();
		hmMnr = getAdverbOfMnr(kwVerb, sentence); 
		
		strMnr 	   = convertedHashMapToString(hmMnr);
		
		return strMnr;
	} //end Mnr	
	
	//***************************************************************
	/**
	 * adverb of purpose 
	 * @param kwVerb, sentence 
	 * @return String adverb of prp according to Verb 
	 * 
	 */
	public String adverbOfPrp(KeyWord kwVerb, Sentence sentence){
		String strPrp;
		HashMap<Integer,KeyWord> hmPrp = new HashMap<Integer, KeyWord>();
		hmPrp = getAdverbOfPrp(kwVerb, sentence); 
		
		strPrp 	   = convertedHashMapToString(hmPrp);
		
		return strPrp;
	} //end Prp	
	
	//***************************************************************
	/**
	 * predicate
	 * @param kwVerb, sentence 
	 * @return String predicate according to Verb 
	 * 
	 */
	public String predicate(KeyWord kwVerb, Sentence sentence){
		String strPrd;
		HashMap<Integer,KeyWord> hmPrd = new HashMap<Integer, KeyWord>();
		hmPrd = getPrd(kwVerb, sentence); 
		
		strPrd 	   = convertedHashMapToString(hmPrd);
		
		return strPrd;
	} //end prd

	//***************************************************************
	/**
	 *  subordinate Clause
	 * @param kwVerb, sentence 
	 * @return subordinateClause 
	 * 
	 */
	public String subordinateClause(KeyWord kwVerb, Sentence sentence){
		String strSubClause;
		HashMap<Integer,KeyWord> hmSubClause = new HashMap<Integer, KeyWord>();
		hmSubClause = getSubordinateClause(kwVerb, sentence); 
		
		strSubClause 	   = convertedHashMapToString(hmSubClause);
		
		return strSubClause;
	} //end SubClause	

	//***************************************************************
	/**
	 * CoordinateClause 
	 * @param kwVerb, sentence 
	 * @return String CoordinateClause 
	 * 
	 */
	public String coordinateClause(KeyWord kwVerb, Sentence sentence){
		String strCoorClause;
		HashMap<Integer,KeyWord> hmCoorClause = new HashMap<Integer, KeyWord>();
		hmCoorClause = getCoordinateClause(kwVerb, sentence); 
		
		strCoorClause 	   = convertedHashMapToString(hmCoorClause);
		
		return strCoorClause;
	} //end SubClause	
	
	//***************************************************************
	
	//***************************************************************
	/**
	 * getSubject  according to Verb
	 * 
	 * @return HashMap<id, KeyWord> express Subject according to Verb 
	 * 
	 */
	public HashMap<Integer, KeyWord> getSubject(KeyWord kwVerb, Sentence sentence){
		HashMap<Integer,KeyWord> subject = new HashMap<Integer, KeyWord>();
		int id, relationId;
		
		for(int i=0; i<sentence.size(); i++){
			if ((sentence.get(i).getDependenceType().contains("sub"))
					&& (sentence.get(i).getDependenceId().contentEquals(kwVerb.getId()))){
					
				//id = sentence.get(i).getId().charAt(0);//65279
				//System.out.println("id: "+id);
												
				if ((sentence.get(i).getId().length()==2) && (sentence.get(i).getId().charAt(0)==65279) && (sentence.get(i).getId().charAt(1)=='1')){
					id = (sentence.get(i).getId().charAt(1)-'0');
				}
				else{
					id = Integer.parseInt(sentence.get(i).getId());
				}
				subject.put(id, sentence.get(i));
				
				if (sentence.get(i).getRelationKeyWord()!= null){
					for (int j=0; j<sentence.get(i).getRelationKeyWord().size(); j++){
						relationId = Integer.parseInt(sentence.get(i).getRelationKeyWord().get(j).getId());
						subject.put(relationId, sentence.get(i).getRelationKeyWord().get(j));
						subject = getAllRelationKeyWord(relationId,subject, sentence);
					}
				}
			}
			
		}	
		return subject;
		
	} //end subject


	//***************************************************************
	/**
	 * get  relations of a Verb 
	 * @return HashMap of Verb
	 * 
	 */
	public HashMap<Integer, KeyWord> getVerb(KeyWord kwVerb, Sentence sentence){
		HashMap<Integer, KeyWord> verb = new HashMap<Integer, KeyWord>();

		List<String> setRemovedWord = Arrays.asList("sub", "dob", "iob", "punct", "loc", "tmp", "pmod", "coord", "dep", "prp", "mnr", "dir", "prd");
		List<String> setLinkingVerb = Arrays.asList();
				
		int id, relationId;
		
		if (!(setLinkingVerb.contains(kwVerb.getWord()))){
		
			if ((kwVerb.getId().length()==2) && (kwVerb.getId().charAt(0)==65279) && (kwVerb.getId().charAt(1)=='1')){
				id = (kwVerb.getId().charAt(1)-'0');
			}
			else{
				id = Integer.parseInt(kwVerb.getId());
			}
			
			verb.put(id, kwVerb);
			if (kwVerb.getRelationKeyWord()!= null){
				for (int j=0; j<kwVerb.getRelationKeyWord().size(); j++){
					
					if ((!setRemovedWord.contains(kwVerb.getRelationKeyWord().get(j).getDependenceType()))
							&& (!(isVerb(kwVerb.getRelationKeyWord().get(j), sentence)))
							&& ((sentence.isCompareRemote2ID(kwVerb,kwVerb.getRelationKeyWord().get(j))))
							&& (!(hasSubject(kwVerb.getRelationKeyWord().get(j))))
							&& !(isObjectOfPreposition(kwVerb, kwVerb.getRelationKeyWord().get(j), sentence))
							
							){
						
						
					
						
						relationId = Integer.parseInt(kwVerb.getRelationKeyWord().get(j).getId());				
						verb.put(relationId, kwVerb.getRelationKeyWord().get(j));
						
						verb = getAllRelationKeyWordByVerb(relationId, verb, sentence);
						
						
						
					}
					
					if ((kwVerb.getRelationKeyWord().get(j).getDependenceType().contentEquals("dob"))
							
						){
						
						
						break;
						
					}
				}
			}
		}
		
		return verb;
	} //end verb
	//***************************************************************
	/**
	 * get  relations of a Verb1 and verb2 
	 * @return HashMap of Verb
	 * 
	 */

	public HashMap<Integer, KeyWord> getVerb2(KeyWord kwVerb1, KeyWord kwVerb2, Sentence sentence){
		HashMap<Integer, KeyWord> verb = new HashMap<Integer, KeyWord>();

		List<String> setRemovedWord = Arrays.asList("sub", "dob", "iob", "punct", "loc", "tmp", "pmod", "coord", "dep", "prp", "mnr", "dir");
		
				
		int id, relationId;
		
		
			if ((kwVerb1.getId().length()==2) && (kwVerb1.getId().charAt(0)==65279) && (kwVerb1.getId().charAt(1)=='1')){
				id = (kwVerb1.getId().charAt(1)-'0');
			}
			else{
				id = Integer.parseInt(kwVerb1.getId());
			}
			
			verb.put(id, kwVerb1);
			
			if (kwVerb1.getRelationKeyWord()!= null){
				for (int j=0; j<kwVerb1.getRelationKeyWord().size(); j++){
										
					if ((!setRemovedWord.contains(kwVerb1.getRelationKeyWord().get(j).getDependenceType())) 
							//&& ((sentence.isTwoRemotePostion(kwVerb1,kwVerb1.getRelationKeyWord().get(j))))
							&& ((sentence.isCompareRemote2ID(kwVerb1,kwVerb1.getRelationKeyWord().get(j))))
							&& (!(hasSubject(kwVerb1.getRelationKeyWord().get(j))))
							//&& (!(isVmodVerb2(kwVerb1.getRelationKeyWord().get(j))))
							){
						

						relationId = Integer.parseInt(kwVerb1.getRelationKeyWord().get(j).getId());
						
											
						verb.put(relationId, kwVerb1.getRelationKeyWord().get(j));
						//verb = getAllRelationKeyWordByVerb(relationId, verb, sentence);
						
						
						
						if (!(kwVerb1.getRelationKeyWord().get(j).getId().contentEquals(kwVerb2.getId()))){
							
							verb = getAllRelationKeyWordByVerb(relationId, verb, sentence);
						}
						
						
							
					}
					
					
				}
			}
		
		return verb;
	} //end verb2

	//***************************************************************
	/**
	 * get  relations of tobe Verb 
	 * @param kwVerb
	 * @return relations of to be Verb
	 */
	public HashMap<Integer, KeyWord> getVerbToBe(KeyWord kwVerb, Sentence sentence){
		HashMap<Integer, KeyWord> verb = new HashMap<Integer, KeyWord>();

		List<String> setRemovedWord = Arrays.asList("sub", "dob", "iob", "punct", "loc", "tmp", "pmod", "coord", "dep", "vmod", "prp");
		
				
		int id, relationId;
		
		if (kwVerb.getWord().contentEquals("là")){
		
			if ((kwVerb.getId().length()==2) && (kwVerb.getId().charAt(0)==65279) && (kwVerb.getId().charAt(1)=='1')){
				id = (kwVerb.getId().charAt(1)-'0');
			}
			else{
				id = Integer.parseInt(kwVerb.getId());
			}
			
			verb.put(id, kwVerb);
										
			if (kwVerb.getRelationKeyWord()!= null){
				for (int j=0; j<kwVerb.getRelationKeyWord().size(); j++){
										
					if ((!setRemovedWord.contains(kwVerb.getRelationKeyWord().get(j).getDependenceType())) 
							//&& (!(isTwoRemotePostion(kwVerb,kwVerb.getRelationKeyWord().get(j))))
							//&& (!(isVmodHasSubject(kwVerb.getRelationKeyWord().get(j))))
							&& (!(isVmodSimilarVerb(kwVerb.getRelationKeyWord().get(j), sentence)))
							){
										
						relationId = Integer.parseInt(kwVerb.getRelationKeyWord().get(j).getId());
						
						verb.put(relationId, kwVerb.getRelationKeyWord().get(j));
						verb = getAllRelationKeyWord(relationId, verb, sentence);													
					}
				}
			}
		}
		return verb;
	} //end tobe verb

	//***************************************************************
	/*
	 * get complement of sentence 
	 * @param kwToBeVerb, sentence
	 * @return complement of sentence 
	 */
	public HashMap<Integer, KeyWord> getComplement(KeyWord kwToBeVerb, Sentence sentence){
		HashMap<Integer, KeyWord> complement = new HashMap<Integer, KeyWord>();
		List<String> setComplement = Arrays.asList("dob", "vmod");
		
		int id, relationId;
			
		for(int i=0; i<sentence.size(); i++){
			if (sentence.get(i).getDependenceId().contentEquals(kwToBeVerb.getId())
				&& (setComplement.contains(sentence.get(i).getDependenceType()))
				&& (kwToBeVerb.getWord().contentEquals("là"))){
				
				//************* write Complement
				if ((sentence.get(i).getId().length()==2) && (sentence.get(i).getId().charAt(0)==65279) && (sentence.get(i).getId().charAt(1)=='1')){
					id = (sentence.get(i).getId().charAt(1)-'0');
				}
				else{
					id = Integer.parseInt(sentence.get(i).getId());
				}
				complement.put(id, sentence.get(i));
				
				if (sentence.get(i).getRelationKeyWord()!= null){
					for (int j=0; j<sentence.get(i).getRelationKeyWord().size(); j++){
						relationId = Integer.parseInt(sentence.get(i).getRelationKeyWord().get(j).getId());
						complement.put(relationId, sentence.get(i).getRelationKeyWord().get(j));
						complement = getAllRelationKeyWord(relationId,complement, sentence);
					}
				}
				
			}
			
		}//for
		return complement;
	} //end complement
	
	
	//***************************************************************
	/*
	 * get Direct Object of sentence
	 */

	public HashMap<Integer, KeyWord> getDirectObject(KeyWord kwVerb, Sentence sentence){
		HashMap<Integer, KeyWord> directObject = new HashMap<Integer, KeyWord>();
		
		int id, relationId;
		
		for(int i=0; i<sentence.size(); i++){
			if (((sentence.get(i).getDependenceType().contains("dob"))
				 || (sentence.get(i).getDependenceType().contains("voc"))	
				 || (isObjectOfPreposition(kwVerb, sentence.get(i), sentence))
					  
					)
				&& (sentence.get(i).getDependenceId().contentEquals(kwVerb.getId()))
				
					){
				
				
				
				if ((sentence.get(i).getId().length()==2) && (sentence.get(i).getId().charAt(0)==65279) && (sentence.get(i).getId().charAt(1)=='1')){
					id = (sentence.get(i).getId().charAt(1)-'0');
				}
				else{
					id = Integer.parseInt(sentence.get(i).getId());
				}
				directObject.put(id, sentence.get(i));
				
				if (sentence.get(i).getRelationKeyWord()!= null){
										
					for (int j=0; j<sentence.get(i).getRelationKeyWord().size(); j++){
						relationId = Integer.parseInt(sentence.get(i).getRelationKeyWord().get(j).getId());	
						directObject.put(relationId, sentence.get(i).getRelationKeyWord().get(j));
						directObject = getAllRelationKeyWord(relationId,directObject, sentence);
						
					}
				}
				
				
			}
			
		}
		return directObject;
	}//end directObject
		
	//***************************************************************
	/**
	 * get In Direct Object of clause according to Verb
	 * @param kwVerb
	 * @return HashMap of InDirectObject
	 */
	public HashMap<Integer, KeyWord> getInDirectObject(KeyWord kwVerb, Sentence sentence){
		HashMap<Integer, KeyWord> inDirectObject = new HashMap<Integer, KeyWord>();
		
		int id, relationId;
		
		for(int i=0; i<sentence.size(); i++){
			if ((sentence.get(i).getDependenceType().contains("iob"))
					&&(sentence.get(i).getDependenceId().contentEquals(kwVerb.getId()))
					
					){
				
				if ((sentence.get(i).getId().length()==2) && (sentence.get(i).getId().charAt(0)==65279) && (sentence.get(i).getId().charAt(1)=='1')){
					id = (sentence.get(i).getId().charAt(1)-'0');
				}
				else{
					id = Integer.parseInt(sentence.get(i).getId());
				}
				inDirectObject.put(id, sentence.get(i));
				
				if (sentence.get(i).getRelationKeyWord()!= null){
					for (int j=0; j<sentence.get(i).getRelationKeyWord().size(); j++){
						relationId = Integer.parseInt(sentence.get(i).getRelationKeyWord().get(j).getId());
						inDirectObject.put(relationId, sentence.get(i).getRelationKeyWord().get(j));	
						inDirectObject = getAllRelationKeyWord(relationId,inDirectObject, sentence);
					}
				}
			}
			
		}
		return inDirectObject;
	} //end inDirectObject

	//***************************************************************
	/*
	 *  check Object of a Preposition
	 *  return true if Object of a Preposition
	 */

	public boolean  isObjectOfPreposition(KeyWord kwVerb, KeyWord kwPreposition, Sentence sentence){
			
		if ( (kwPreposition.getDependenceId().contentEquals(kwVerb.getId()))
				
				&& (kwPreposition.getPosTag().contentEquals("E"))
				&& (kwPreposition.getDependenceType().contentEquals("vmod")) 	
			){
			if (kwPreposition.getRelationKeyWord()!=null){
				for (int k=0; k<kwPreposition.getRelationKeyWord().size(); k++){
					if (kwPreposition.getRelationKeyWord().get(k).getDependenceType().contentEquals("pob")){
						return true;
					}
				}
			}
			
		}
		
		return false;
	}//end Object of a Preposition 
	//***************************************************************
	/**
	 * get Loc - adverb of Location by verb
	 *  
	 */

	public HashMap<Integer, KeyWord> getAdverbOfLoc(KeyWord kwVerb, Sentence sentence){
		HashMap<Integer, KeyWord> loc = new HashMap<Integer, KeyWord>();
		int id, relationId; 
			
		
		for(int i=0; i<sentence.size(); i++){
			//k = i+1;
			
			//dependence type of loc Support verb of a clause
			if ((sentence.get(i).getDependenceType().contains("loc"))
					&&(sentence.get(i).getDependenceId().contentEquals(kwVerb.getId()))){
				if ((sentence.get(i).getId().length()==2) && (sentence.get(i).getId().charAt(0)==65279) && (sentence.get(i).getId().charAt(1)=='1')){
					id = (sentence.get(i).getId().charAt(1)-'0');
				}
				else{
					id = Integer.parseInt(sentence.get(i).getId());
				}
				loc.put(id, sentence.get(i));
				
				if (sentence.get(i).getRelationKeyWord()!= null){
					for (int j=0; j<sentence.get(i).getRelationKeyWord().size(); j++){
						relationId = Integer.parseInt(sentence.get(i).getRelationKeyWord().get(j).getId());
						loc.put(relationId, sentence.get(i).getRelationKeyWord().get(j));	
						loc = getAllRelationKeyWord(relationId,loc, sentence);
					}
				}
				
			}
			
			
		}
		return loc;
	} //end loc
	//***************************************************************
	/**
	 * get tmp - adverb of tmp(temporal) by verb
	 *  
	 */
	public HashMap<Integer, KeyWord> getAdverbOfTmp(KeyWord kwVerb, Sentence sentence){
		HashMap<Integer, KeyWord> tmp = new HashMap<Integer, KeyWord>();
		int id, relationId; 
			
		for(int i=0; i<sentence.size(); i++){
			if ((sentence.get(i).getDependenceType().contains("tmp"))
					&&(sentence.get(i).getDependenceId().contentEquals(kwVerb.getId()))){
				if ((sentence.get(i).getId().length()==2) && (sentence.get(i).getId().charAt(0)==65279) && (sentence.get(i).getId().charAt(1)=='1')){
					id = (sentence.get(i).getId().charAt(1)-'0');
				}
				else{
					id = Integer.parseInt(sentence.get(i).getId());
				}
				tmp.put(id, sentence.get(i));
				
				if (sentence.get(i).getRelationKeyWord()!= null){
					for (int j=0; j<sentence.get(i).getRelationKeyWord().size(); j++){
						relationId = Integer.parseInt(sentence.get(i).getRelationKeyWord().get(j).getId());
						tmp.put(relationId, sentence.get(i).getRelationKeyWord().get(j));	
						tmp = getAllRelationKeyWord(relationId,tmp, sentence);
					}
				}
				
			}
			
		}
		return tmp;
	}
	
	//***************************************************************
	/**
	 * get prp - adverb of Purpose by verb
	 *  
	 */
	public HashMap<Integer, KeyWord> getAdverbOfPrp(KeyWord kwVerb, Sentence sentence){
		HashMap<Integer, KeyWord> prp= new HashMap<Integer, KeyWord>();
		int id, relationId; 
			
		//System.out.println("get prp: "+sentence.get(i).getWord());
		for(int i=0; i<sentence.size(); i++){
			
			
			if ((sentence.get(i).getDependenceType().contains("prp"))
					&& (sentence.get(i).getDependenceId().contentEquals(kwVerb.getId()))){
				
				if ((sentence.get(i).getId().length()==2) && (sentence.get(i).getId().charAt(0)==65279) && (sentence.get(i).getId().charAt(1)=='1')){
					id = (sentence.get(i).getId().charAt(1)-'0');
				}
				else{
					id = Integer.parseInt(sentence.get(i).getId());
				}
				prp.put(id, sentence.get(i));
				
				
				
				if (sentence.get(i).getRelationKeyWord()!= null){
					for (int j=0; j<sentence.get(i).getRelationKeyWord().size(); j++){
						relationId = Integer.parseInt(sentence.get(i).getRelationKeyWord().get(j).getId());
						prp.put(relationId, sentence.get(i).getRelationKeyWord().get(j));						
						prp = getAllRelationKeyWord(relationId,prp, sentence);
						
					}
				}
				
			}
			
		}
		return prp;
	} //end prp
	
	//***************************************************************
	/**
	 * get dir - Adverb of direction by verb 
	 */
	public HashMap<Integer, KeyWord> getAdverbOfDir(KeyWord kwVerb, Sentence sentence){
		HashMap<Integer, KeyWord> dir= new HashMap<Integer, KeyWord>();
		int id, relationId; 
			
		for(int i=0; i<sentence.size(); i++){
			//k = i+1;
			
			if ((sentence.get(i).getDependenceType().contains("dir"))
					&&(sentence.get(i).getDependenceId().contentEquals(kwVerb.getId()))){
				if ((sentence.get(i).getId().length()==2) && (sentence.get(i).getId().charAt(0)==65279) && (sentence.get(i).getId().charAt(1)=='1')){
					id = (sentence.get(i).getId().charAt(1)-'0');
				}
				else{
					id = Integer.parseInt(sentence.get(i).getId());
				}
				dir.put(id, sentence.get(i));
				
				
				if (sentence.get(i).getRelationKeyWord()!= null){
					for (int j=0; j<sentence.get(i).getRelationKeyWord().size(); j++){
						relationId = Integer.parseInt(sentence.get(i).getRelationKeyWord().get(j).getId());
						dir.put(relationId, sentence.get(i).getRelationKeyWord().get(j));						
						dir = getAllRelationKeyWord(relationId,dir, sentence);
						
					}
				}
				
			}
			
		}
		return dir;
	} //end dir
	
	//***************************************************************
	/**
	 * get Adverb about manner by verb 
	 */
	public HashMap<Integer, KeyWord> getAdverbOfMnr(KeyWord kwVerb, Sentence sentence){
		HashMap<Integer, KeyWord> mnr= new HashMap<Integer, KeyWord>();
		int id, relationId; 
			
		for(int i=0; i<sentence.size(); i++){
			//k = i+1;
			
			if ((sentence.get(i).getDependenceType().contains("mnr"))
					&&(sentence.get(i).getDependenceId().contentEquals(kwVerb.getId()))){
				if ((sentence.get(i).getId().length()==2) && (sentence.get(i).getId().charAt(0)==65279) && (sentence.get(i).getId().charAt(1)=='1')){
					id = (sentence.get(i).getId().charAt(1)-'0');
				}
				else{
					id = Integer.parseInt(sentence.get(i).getId());
				}
				mnr.put(id, sentence.get(i));
				
				
				if (sentence.get(i).getRelationKeyWord()!= null){
					for (int j=0; j<sentence.get(i).getRelationKeyWord().size(); j++){
						relationId = Integer.parseInt(sentence.get(i).getRelationKeyWord().get(j).getId());
						mnr.put(relationId, sentence.get(i).getRelationKeyWord().get(j));						
						mnr = getAllRelationKeyWord(relationId,mnr, sentence);
						
					}
				}
				
			}
		}
		return mnr;
	} //end mnr
	//***************************************************************
		/**
		 * get prd - predicate
		 *  
		 */
		public HashMap<Integer, KeyWord> getPrd(KeyWord kwVerb, Sentence sentence){
			HashMap<Integer, KeyWord> prd = new HashMap<Integer, KeyWord>();
			int id, relationId; 
				
			for(int i=0; i<sentence.size(); i++){
				if (((sentence.get(i).getDependenceType().contains("prd"))
						//||((sentence.get(i).getDependenceType().contains("x"))
						//	&& (!((Integer.parseInt(sentence.get(i).getId())+1)==(Integer.parseInt(kwVerb.getId())))) 
						//	)	
						)
						&&(sentence.get(i).getDependenceId().contentEquals(kwVerb.getId()))){
										
					if ((sentence.get(i).getId().length()==2) && (sentence.get(i).getId().charAt(0)==65279) && (sentence.get(i).getId().charAt(1)=='1')){
						id = (sentence.get(i).getId().charAt(1)-'0');
					}
					else{
						id = Integer.parseInt(sentence.get(i).getId());
					}
					prd.put(id, sentence.get(i));
					
					if (sentence.get(i).getRelationKeyWord()!= null){
						for (int j=0; j<sentence.get(i).getRelationKeyWord().size(); j++){
							relationId = Integer.parseInt(sentence.get(i).getRelationKeyWord().get(j).getId());
							prd.put(relationId, sentence.get(i).getRelationKeyWord().get(j));	
							prd = getAllRelationKeyWord(relationId,prd, sentence);
						}
					}
					
				}
				
			}
			return prd;
		}			
	//***************************************************************
	/**
	 * get  Vmod is similar Verb 
	 * @return HashMap of Verb
	 * 
	 */

	public KeyWord getKeyWordOfVmodSimilarVerb(KeyWord kwVerb, Sentence sentence){
		KeyWord kwVerb2 = new KeyWord();
		
		
		List<String> setWord = Arrays.asList("dob", "iob", "punct", "loc", "tmp", "pmod", "dep", "prp", "mnr", "dir");
		
		
		if (kwVerb.getRelationKeyWord()!= null){ 
			for (int i=0; i<kwVerb.getRelationKeyWord().size(); i++){
				if (kwVerb.getRelationKeyWord().get(i).getDependenceType().contains("vmod")){
					
					for (int k=0; k<sentence.size(); k++){
						if ((sentence.get(k).getDependenceId().contentEquals(kwVerb.getRelationKeyWord().get(i).getId()))
								&& (setWord.contains(sentence.get(k).getDependenceType()))){
							kwVerb2 = kwVerb.getRelationKeyWord().get(i);
								
						}
					}
				}
			}
		}			
		return kwVerb2;
	} //end getKeyWordOfVmodSimilarVerb

	//***************************************************************
	/**
	 * get Subordinate clause by verb 
	 */
	public HashMap<Integer, KeyWord> getSubordinateClause(KeyWord kwVerb, Sentence sentence){
		HashMap<Integer, KeyWord> subordinate = new HashMap<Integer, KeyWord>();
		int id, relationId; 
		for(int i=0; i<sentence.size(); i++){
			if (sentence.get(i).getId().contentEquals(kwVerb.getId())
					&& (isRootVerb(sentence.get(i).getDependenceId(), sentence)
						|| isVerb(sentence.get(i), sentence))
					){
				if ((sentence.get(i).getId().length()==2) && (sentence.get(i).getId().charAt(0)==65279) && (sentence.get(i).getId().charAt(1)=='1')){
					id = (sentence.get(i).getId().charAt(1)-'0');
				}
				else{
					id = Integer.parseInt(sentence.get(i).getId());
				}
				subordinate.put(id, sentence.get(i));
				
				if (sentence.get(i).getRelationKeyWord()!= null){
					for (int j=0; j<sentence.get(i).getRelationKeyWord().size(); j++){
						relationId = Integer.parseInt(sentence.get(i).getRelationKeyWord().get(j).getId());
						subordinate.put(relationId, sentence.get(i).getRelationKeyWord().get(j));	
						subordinate = getAllRelationKeyWord(relationId,subordinate, sentence);
					}
				}
				
			}
			
		}
		return subordinate;
	} //end getSubordinateClause 
	//***************************************************************
	/**
	 * get Coordinate clause by verb 
	 */
	public HashMap<Integer, KeyWord> getCoordinateClause(KeyWord kwCoord, Sentence sentence){
		HashMap<Integer, KeyWord> coord = new HashMap<Integer, KeyWord>();
		int id, relationId; 
			
		for(int i=0; i<sentence.size(); i++){
			if (sentence.get(i).getId().contentEquals(kwCoord.getId())
					//&& isRootVerb(sentence.get(i).getDependenceId(), sentence)
					){
				if ((sentence.get(i).getId().length()==2) && (sentence.get(i).getId().charAt(0)==65279) && (sentence.get(i).getId().charAt(1)=='1')){
					id = (sentence.get(i).getId().charAt(1)-'0');
				}
				else{
					id = Integer.parseInt(sentence.get(i).getId());
				}
				coord.put(id, sentence.get(i));
				
				if (sentence.get(i).getRelationKeyWord()!= null){
					for (int j=0; j<sentence.get(i).getRelationKeyWord().size(); j++){
						relationId = Integer.parseInt(sentence.get(i).getRelationKeyWord().get(j).getId());
						coord.put(relationId, sentence.get(i).getRelationKeyWord().get(j));	
						coord = getAllRelationKeyWord(relationId,coord, sentence);
					}
				}
				
			}
			
		}
		return coord;
	} //end getCoordinateClause


	///**************************************************************
	/*
	 *
	 * @param sentence
	 * @return true if sentence has subject and verb
	 */
	public boolean isSentence(Sentence sentence){
		
		for(int i=0; i<sentence.size(); i++){
			if ((sentence.get(i).getDependenceType().contains("sub"))
					&&(isRootVerb(sentence.get(i).getDependenceId(), sentence)) 
					&& (!sentence.isQuestion())){
				return true;	
			}
		}
		return false;
	}


	//***************************************************************
	/**
	 * 
	 * @param kwVerb
	 * @return true if kWord is subject 
	 */	
	public boolean hasSubject(KeyWord kwVerb){
		if (kwVerb.getRelationKeyWord()!= null){ 
			for (int i=0; i<kwVerb.getRelationKeyWord().size(); i++){
				if (kwVerb.getRelationKeyWord().get(i).getDependenceType().contains("sub")){
					
					
					return true;
				}
				
			}
		}			
		return false;
	}

	//***************************************************************
	/**
	 * 
	 * @param id
	 * @return true if KeyWord is root verb
	 */

	public boolean isRootVerb(String id, Sentence sentence){
		List<String> setVerbType = Arrays.asList("V", "A", "N");
	
		for(int i=0; i<sentence.size(); i++){
			if ((sentence.get(i).getId().contentEquals(id))
				&& (setVerbType.contains(sentence.get(i).getPosTag()))
				&& (sentence.get(i).getDependenceType().contains("root"))
					){
				
				return true;
				
			}
		}
		return false;
	} //end isRootVerb
	
	//***************************************************************
	/**
	 * 
	 * @param id
	 * @return true if KeyWord dependences root verb
	 */
	public boolean isVerb(KeyWord kwVerb, Sentence sentence){
		//List<String> setPosTag      = Arrays.asList("V", "A", "E");
		List<String> setPosTag      = Arrays.asList("V", "A");
		List<String> setAdverbType  = Arrays.asList("tmp", "loc", "prp", "dir", "mnr");
		List<String> setRemovedWord = Arrays.asList("sub", "dob", "iob", "punct", "loc", "tmp", "pmod", "coord", "dep", "prp", "mnr", "dir", "prd");
		int id1, id2;
		for(int i=0; i<sentence.size(); i++){
			
			if ((sentence.get(i).getId().contentEquals(kwVerb.getId()))
				&& (!sentence.get(i).getDependenceType().contains("root"))
				&& (setPosTag.contains(sentence.get(i).getPosTag()))
				&& (!setAdverbType.contains(sentence.get(i).getDependenceType()))
				&& ((!(sentence.getKeyWordById(kwVerb.getDependenceId()).getPosTag().contentEquals("N")))
					|| (hasSubject(kwVerb))	
						)
						
					
				){
				id1 = Integer.parseInt(sentence.get(i).getDependenceId());
				id2 = Integer.parseInt(kwVerb.getId());
				
				if (isRootVerb(sentence.get(i).getDependenceId(), sentence)){
					if (
						(hasSubject(kwVerb)
						|| (!(sentence.isCompareRemote2ID(sentence.getKeyWordById(sentence.get(i).getDependenceId()), sentence.get(i))))
						|| (!((id1+1)==id2))
						)
						&& (id1<id2)
						&& (!(sentence.getKeyWordById(kwVerb.getDependenceId()).getDependenceType().contentEquals("sub")))
						
						){
							
						
						return true;
					}
				}
				
				else{
					if (((hasSubject(kwVerb))
							|| (kwVerb.getDependenceType().contentEquals("conj"))
							|| (!(sentence.isCompareRemote2ID(sentence.getKeyWordById(sentence.get(i).getDependenceId()), sentence.get(i))))
							|| ((!((id1+1)==id2)) 
								 )
						 )
						 && (id1<id2)	
						 && (!(sentence.getKeyWordById(kwVerb.getDependenceId()).getDependenceType().contentEquals("sub")))
						){
						return true;
						
					}					
					
					for (int k=0; k<sentence.size(); k++ ){
						if ((sentence.get(k).getDependenceId().contentEquals(kwVerb.getId()))
								&& 	(setRemovedWord.contains(sentence.get(k).getDependenceType()))
								&& (!(sentence.getKeyWordById(kwVerb.getDependenceId()).getDependenceType().contentEquals("sub")))	
								){
							
							
							return true;
						}
					}					
				}
			}
			
		}
		
		return false;
	}
	//***************************************************************
	/**
	 * 
	 * @param kWord is Verb
	 * @return true if Verb has a dependence vmod's verb (verb2).  verb2 has  dob, loc, tmp..   
	 */	
	public boolean isVmodSimilarVerb(KeyWord kwVerb, Sentence sentence){
		List<String> setPosTag   = Arrays.asList("V", "A", "E", "N");
		List<String> setWord = Arrays.asList("dob", "iob", "punct", "loc", "tmp", "pmod", "dep", "prp", "mnr", "dir");
		int id1, id2;
		
		
		if (kwVerb.getRelationKeyWord()!= null){ 
			for (int i=0; i<kwVerb.getRelationKeyWord().size(); i++){
				
				if (kwVerb.getRelationKeyWord().get(i).getDependenceType().contains("vmod")
						&& (setPosTag.contains(kwVerb.getRelationKeyWord().get(i).getPosTag()))
						){
					
					
					for (int k=0; k<sentence.size(); k++){
						if(sentence.get(k).getDependenceId().contentEquals(kwVerb.getRelationKeyWord().get(i).getId())
							&& (setWord.contains(sentence.get(k).getDependenceType()))	
								){
							
							id1 = Integer.parseInt(kwVerb.getId());
							id2 = Integer.parseInt(kwVerb.getRelationKeyWord().get(i).getId());
							if ((id1+1)==id2){
								return true;
							}
							
								
						}
					}
				} //if
				
				
			} //for
		}			
		return false;
		
	}


	//***************************************************************
	/**
	*  get all Relations of a KeyWord
	*/
	public HashMap<Integer, KeyWord> getAllRelationKeyWord(int idParent, HashMap<Integer, KeyWord> relationKeyWord, Sentence sentence){
		HashMap<Integer, KeyWord> allRelationKeyWord = new HashMap<Integer, KeyWord>();
		allRelationKeyWord = relationKeyWord;
			
		int depenedenceId, id;
				
			for (int k=0; k<sentence.size();k++){
				depenedenceId = Integer.parseInt(sentence.get(k).getDependenceId());
				if (depenedenceId == idParent){
					id = Integer.parseInt(sentence.get(k).getId());
									
					
					allRelationKeyWord.put(id, sentence.get(k));
					getAllRelationKeyWord(id,allRelationKeyWord, sentence);
				}	
							
			}	
			
		return allRelationKeyWord;
	}
	//***************************************************************
	
	//***************************************************************
	/**
	*  get all Relations of a KeyWord
	*/
	public HashMap<Integer, KeyWord> getAllRelationKeyWordByVerb(int idParent, HashMap<Integer, KeyWord> relationKeyWord, Sentence sentence){
		HashMap<Integer, KeyWord> allRelationKeyWord = new HashMap<Integer, KeyWord>();
		allRelationKeyWord = relationKeyWord;
			
		int depenedenceId, id;
				
			for (int k=0; k<sentence.size();k++){
				depenedenceId = Integer.parseInt(sentence.get(k).getDependenceId());
				if ((depenedenceId == idParent)
					&& !(sentence.get(k).getDependenceType().contentEquals("coord"))
					&& !(isVerb(sentence.get(k), sentence))
					){
					id = Integer.parseInt(sentence.get(k).getId());
					
					allRelationKeyWord.put(id, sentence.get(k));
					getAllRelationKeyWord(id,allRelationKeyWord, sentence);
				}	
							
			}	
			
		return allRelationKeyWord;
	}
	//***************************************************************
	
	//***************************************************************
	/* convert  a HashMap structure to String 
	 * @param HashMap <Integer, KeyWord>
	 * @return a string is sorted  
	 */

	public String convertedHashMapToString(HashMap<Integer, KeyWord> hMap){
		String strValue;
		
		strValue = "";
		
        Map<Integer, KeyWord> sorted  = new TreeMap<Integer, KeyWord>(hMap);
				
		for (Integer k : sorted.keySet()){
			strValue = strValue + sorted.get(k).getWord() + " ";
			
		}
				
		return strValue;
	}	

}

