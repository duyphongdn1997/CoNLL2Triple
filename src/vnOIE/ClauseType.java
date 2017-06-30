package vnOIE;

import java.util.ArrayList;

import java.util.List;

public class ClauseType {

	//***************************************************************
	/**
	 * Clause types SV, SVC, SVO  
	 * SV: Intransitive verb 			==> extended patterns: SV, SVA, SVAA,
	 * SVC: Linking verb + complement	==> extended patterns: SVC, SVCA, SVCAA,
	 * SVO: transitive verb				
	 * @param sentence
	 */
	public List<String> detectClauseType(Sentence sentence, String subject, KeyWord kwVerb1, KeyWord kwVerb2){
		
		List<String> clauseType = new ArrayList<String>();
		Constituent constituent = new Constituent();
		KeyWord kwVerb = new KeyWord();
		
		String verb, verbToBe, directObject, inDirectObject, complement;
		
		verb = "";
		
		
		
		if (kwVerb2==null){
			kwVerb = kwVerb1;
			verb   = constituent.verb(kwVerb, sentence);
			
			
		}
		if (kwVerb2!=null){
			
			kwVerb = kwVerb2;
			verb   = constituent.verb2(kwVerb1, kwVerb2, sentence);
		
			
			
		}
				
		directObject   = constituent.directObject(kwVerb, sentence);
		inDirectObject = constituent.inDirectObject(kwVerb, sentence);
		verbToBe       = constituent.verbToBe(kwVerb, sentence);
		complement	   = constituent.complement(kwVerb, sentence); 
		
		
		
		
		//clause-type detection
		//*********************************************************************
		
		
		
		if (!directObject.isEmpty() && verbToBe.isEmpty()){
			
			if (!inDirectObject.isEmpty()){
				clauseType = SVOO(sentence, subject, kwVerb1, kwVerb2);
				
			}
			if (inDirectObject.isEmpty()){
				clauseType = SVO(sentence, subject, kwVerb1, kwVerb2);
				
			}
			
		} 
		else{
			if (!verbToBe.isEmpty() && !complement.isEmpty() ){		
				clauseType = SVC(sentence, subject, kwVerb1, kwVerb2);
			}
			if (!verbToBe.isEmpty() && complement.isEmpty()){
				clauseType = SVA(sentence, subject, kwVerb1, kwVerb2);
			}
			if (!verb.isEmpty() && verbToBe.isEmpty() && complement.isEmpty()){
						
				clauseType = SV(sentence, subject, kwVerb1, kwVerb2);
				
			}
			
		}
		
		return clauseType;
	} //end detectClauseType

	//*******************************************************************
	/*
	 * Clause Type: SVOO
	 * 
	 */
	public List<String> SVOO(Sentence sentence, String subject, KeyWord kwVerb1, KeyWord kwVerb2){
		List<String> clauseTypeList = new ArrayList<String>();
		Constituent constituent = new Constituent();
		KeyWord kwVerb = new KeyWord();
		
		String clause, verb, directObject, inDirectObject, dir, loc, mnr, prp, tmp, prd;
		
		verb = "";
		
		
		if (kwVerb2==null){
			kwVerb = kwVerb1;
			verb   = constituent.verb(kwVerb, sentence);
		}
		if (kwVerb2!=null){
			kwVerb = kwVerb2;
			verb   = constituent.verb2(kwVerb1, kwVerb2, sentence);
		}
		
		
		
		directObject    = constituent.directObject(kwVerb, sentence);
		inDirectObject  = constituent.inDirectObject(kwVerb, sentence);
		dir				= constituent.adverbOfDir(kwVerb, sentence);
		loc				= constituent.adverbOfLoc(kwVerb, sentence);
		mnr				= constituent.adverbOfMnr(kwVerb, sentence);
		prp				= constituent.adverbOfPrp(kwVerb, sentence);
		tmp				= constituent.adverbOfTmp(kwVerb, sentence);
		prd				= constituent.predicate(kwVerb, sentence);
		
		if ((!subject.isEmpty()) && (!verb.isEmpty()) && (!directObject.isEmpty())
				&& !inDirectObject.isEmpty()){
						 				
			clause = "SVOO:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim()+"\", \""+ inDirectObject.trim() +"\")";
			clauseTypeList.add(clause);

			//SVOOA:write into List<String> about clause type SVOA with Adverb: location
			if (!loc.isEmpty()){
				clause = "SVOO:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim()+"\", \""+ inDirectObject.trim() +"\", \""+ loc.trim()+"\")";
				clauseTypeList.add(clause);	
			}

			//SVOOA:write into List<String> about clause type SVOA with Adverb: temporal
			if (!tmp.isEmpty()){
				clause = "SVOOA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim()+"\", \""+ inDirectObject.trim() +"\", \""+ tmp.trim()+"\")";
				clauseTypeList.add(clause);	
			}

			//write into List<String> about clause type SVOA (A:purpose)
			if ((!prp.isEmpty())&&(!tmp.isEmpty())){
				clause = "SVOOAA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim()+"\", \""+ inDirectObject.trim() +"\", \""+ prp.trim()+"\", \""+ tmp.trim()+"\")";
				clauseTypeList.add(clause);	
			}
			//write into List<String> about clause type SVOA (A:purpose)
			if (!prp.isEmpty()){
				clause = "SVOOA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim()+"\", \""+ inDirectObject.trim() +"\", \""+ prp.trim()+"\")";
				clauseTypeList.add(clause);	
			}
			//write into List<String> about clause type SVOA (A:manner)
			if (!mnr.isEmpty()){
				clause = "SVOOA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim()+"\", \""+ inDirectObject.trim() +"\", \""+ mnr.trim()+"\")";
				clauseTypeList.add(clause);	
			}

			//write into List<String> about clause type SVOA (A:direction)
			if (!dir.isEmpty()){
				clause = "SVOOA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim()+"\", \""+ inDirectObject.trim() +"\", \""+ dir.trim()+"\")";
				clauseTypeList.add(clause);	
			}
			
			//SVOOAA: write into List<String> about clause type SVOA with Adverb: location and temporal
			if ((!loc.isEmpty())&& (!tmp.isEmpty())){
				clause = "SVOOAA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim()+"\", \""+ inDirectObject.trim() +"\", \""+ loc.trim()+"\", \""+tmp.trim()+"\")";
				clauseTypeList.add(clause);	
			}
			//SVOO Prd: write into List<String> about clause type SVOO predicate 
			if (!prd.isEmpty()){
				clause = "SVOO Prd:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim()+"\", \""+ inDirectObject.trim() +"\", \""+ prd.trim()+"\")";
				clauseTypeList.add(clause);	
			}

			
		}	
		return clauseTypeList;
	} //end SVOO
	
	
	
	//*******************************************************************
	/*
	 * Clause Type: SVO
	 * 
	 */
	public List<String> SVO(Sentence sentence, String subject, KeyWord kwVerb1, KeyWord kwVerb2){
		List<String> clauseTypeList = new ArrayList<String>();
		Constituent constituent = new Constituent();
		KeyWord kwVerb = new KeyWord();
		
		String clause, verb, directObject, inDirectObject, dir, loc, mnr, prp, tmp, prd;
		
		verb = "";
				
				
		if (kwVerb2==null){
			kwVerb = kwVerb1;
			verb   = constituent.verb(kwVerb, sentence);
		}
		if (kwVerb2!=null){
			kwVerb = kwVerb2;
			
			verb   = constituent.verb2(kwVerb1, kwVerb2, sentence);
			
		}
		
		
		directObject    = constituent.directObject(kwVerb, sentence);
		inDirectObject  = constituent.inDirectObject(kwVerb, sentence);
		dir				= constituent.adverbOfDir(kwVerb, sentence);
		loc				= constituent.adverbOfLoc(kwVerb, sentence);
		mnr				= constituent.adverbOfMnr(kwVerb, sentence);
		prp				= constituent.adverbOfPrp(kwVerb, sentence);
		tmp				= constituent.adverbOfTmp(kwVerb, sentence);
		prd				= constituent.predicate(kwVerb, sentence);
		
		
		if ((!subject.isEmpty()) && (!verb.isEmpty()) && (!directObject.isEmpty())
				&& inDirectObject.isEmpty()){
			 
			//SVO: write into List<String> about clause type SVO	
			clause = "SVO:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim() +"\")";
			clauseTypeList.add(clause);
			
			
			//SVOA:write into List<String> about clause type SVOA with Adverb: location
			if (!loc.isEmpty()){
				clause = "SVOA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim() +"\", \""+ loc.trim()+"\")";
				clauseTypeList.add(clause);	
			}
			
			//SVOA: write into List<String> about clause type SVOA with Adverb: temporal
			if (!tmp.isEmpty()){
				clause = "SVOA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim() +"\", \""+ tmp.trim()+"\")";
				clauseTypeList.add(clause);	
			}
			
			//write into List<String> about clause type SVOA (A:purpose) 
			if(!prp.isEmpty()){
				 clause = "SVOA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim() +"\", \""+ prp.trim() +"\")";
				 clauseTypeList.add(clause);
			}
			//write into List<String> about clause type SVOA (A:purpose) 
			if((!prp.isEmpty()) && (!tmp.isEmpty())){
				 clause = "SVOAA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim() +"\", \""+ prp.trim() +"\", \""+ tmp.trim()+"\")";
				 clauseTypeList.add(clause);
			}
			
			//write into List<String> about clause type SVOA (A:manner)
			if(!mnr.isEmpty()){
				 clause = "SVOA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim() +"\", \""+ mnr.trim() +"\")";
				 clauseTypeList.add(clause);				 
			}
			//write into List<String> about clause type SVOA (A:direction)
			if(!dir.isEmpty()){
				 clause = "SVOA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim() +"\", \""+ dir.trim() +"\")";
				 clauseTypeList.add(clause);				 
			}
			
			//SVOAA: write into List<String> about clause type SVOA with Adverb: temporal
			if ((!loc.isEmpty())&& (!tmp.isEmpty())){
				clause = "SVOAA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim()+"\", \""+ loc.trim() +"\", \""+ tmp.trim()+"\")";
				clauseTypeList.add(clause);	
			}
			//write into List<String> about clause type SVOPrd (Predicate)
			if(!prd.isEmpty()){
				 clause = "SVO Predicate:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ directObject.trim() +"\", \""+ prd.trim() +"\")";
				 clauseTypeList.add(clause);				 
			}
			
		}

		return clauseTypeList;
	} //end SVO
	
	
	//*******************************************************************
	/*
	 * Clause Type: SVC
	 * 
	 */
	
	public List<String> SVC(Sentence sentence, String subject, KeyWord kwVerb1, KeyWord kwVerb2){
		List<String> clauseTypeList = new ArrayList<String>();
		Constituent constituent = new Constituent();
		KeyWord kwVerb = new KeyWord();
		
		String clause, verbToBe, complement, dir, loc, mnr, prp, tmp, prd;

		//verb = "";
		
		if (kwVerb2==null){
			kwVerb = kwVerb1;
			//verb   = constituent.verb(kwVerb, sentence);
		}
		if (kwVerb2!=null){
			kwVerb = kwVerb2;
			//verb   = constituent.verb2(kwVerb1, kwVerb2, sentence);
		}
		
		verbToBe    = constituent.verbToBe(kwVerb, sentence);
		complement	= constituent.complement(kwVerb, sentence);	
		dir			= constituent.adverbOfDir(kwVerb, sentence);
		loc			= constituent.adverbOfLoc(kwVerb, sentence);
		mnr			= constituent.adverbOfMnr(kwVerb, sentence);
		prp			= constituent.adverbOfPrp(kwVerb, sentence);
		tmp			= constituent.adverbOfTmp(kwVerb, sentence);
		prd			= constituent.predicate(kwVerb, sentence);

		
		//*********************************************************************
		//SVC: write into List<String> about clause type SVC (S+"la"+Complement)
		if ((!verbToBe.isEmpty())){
			if (!complement.isEmpty()){
				clause = "SVC:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+ complement.trim() +"\")";
				clauseTypeList.add(clause);
				
				
				//write into List<String> about clause type SVCA according to location
				if (!loc.isEmpty()){
					clause = "SVCA:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+ complement.trim()+"\", \""+loc.trim()+"\")"; 
					clauseTypeList.add(clause);
				}
				
				//write into List<String> about clause type SVCA according to temporal
				if (!tmp.isEmpty()){
					clause = "SVCA:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+ complement.trim()+"\", \""+tmp.trim()+"\")"; 
					clauseTypeList.add(clause);
				}
				//write into List<String> about clause type SVCA according to location and temporal
				if ((!loc.isEmpty())&& (!tmp.isEmpty())){
					clause = "SVCAA:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+ complement.trim()+"\", \""+tmp.trim()+"\", \""+loc.trim()+"\")"; 
					clauseTypeList.add(clause);
				}
				//write into List<String> about clause type SVCA according to purpose
				if (!prp.isEmpty()){
					clause = "SVCA:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+ complement.trim()+"\", \""+prp.trim()+"\")"; 
					clauseTypeList.add(clause);
				}
				//write into List<String> about clause type SVCA according to purpose
				if ((!prp.isEmpty()) && (!tmp.isEmpty())){
					clause = "SVCA:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+ complement.trim()+"\", \""+prp.trim()+"\", \""+tmp.trim()+"\")"; 
					clauseTypeList.add(clause);
				}
				//write into List<String> about clause type SVCA according to direction
				if (!dir.isEmpty()){
					clause = "SVCA:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+ complement.trim()+"\", \""+dir.trim()+"\")"; 
					clauseTypeList.add(clause);
				}
				
				//write into List<String> about clause type SVCA according to manner
				if (!mnr.isEmpty()){
					clause = "SVCA:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+ complement.trim()+"\", \""+mnr.trim()+"\")"; 
					clauseTypeList.add(clause);
				}
				
				
				//write into List<String> about clause type SVC predicate
				if (!prd.isEmpty()){
					clause = "SVC predicate:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+ complement.trim()+"\", \""+prd.trim()+"\")"; 
					clauseTypeList.add(clause);
				}
			}
				
		}
		

		/////
		
		return clauseTypeList;
	} //end SVC
	
	//*******************************************************************
	/*
	 * Clause Type: SVA (V: verb to be)
	 * 
	 */
	
	public List<String> SVA(Sentence sentence, String subject, KeyWord kwVerb1, KeyWord kwVerb2){
		List<String> clauseTypeList = new ArrayList<String>();
		Constituent constituent = new Constituent();
		KeyWord kwVerb = new KeyWord();
		
		String clause, verbToBe, complement, dir, loc, mnr, prp, tmp, prd;

		//verb = "";
		
		if (kwVerb2==null){
			kwVerb = kwVerb1;
			//verb   = constituent.verb(kwVerb, sentence);
		}
		if (kwVerb2!=null){
			kwVerb = kwVerb2;
			//verb   = constituent.verb2(kwVerb1, kwVerb2, sentence);
		}
		
		verbToBe    = constituent.verbToBe(kwVerb, sentence);
		complement	= constituent.complement(kwVerb, sentence);	
		dir			= constituent.adverbOfDir(kwVerb, sentence);
		loc			= constituent.adverbOfLoc(kwVerb, sentence);
		mnr			= constituent.adverbOfMnr(kwVerb, sentence);
		prp			= constituent.adverbOfPrp(kwVerb, sentence);
		tmp			= constituent.adverbOfTmp(kwVerb, sentence);		
		prd			= constituent.predicate(kwVerb, sentence);

		
		//*********************************************************************
		//SVC: write into List<String> about clause type SVC (S+"la"+Complement)
		if ((!verbToBe.isEmpty())){	
			//have not Complement   (S + V="la" + A)  
			if (complement.isEmpty()){
				
				//write into List<String> about clause type SVA according to location
				if (!loc.isEmpty()){
					clause = "SVA:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+loc.trim()+"\")"; 
					clauseTypeList.add(clause);
				}
				
				//write into List<String> about clause type SVA according to temporal
				if (!tmp.isEmpty()){
					clause = "SVA:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+tmp.trim()+"\")"; 
					clauseTypeList.add(clause);
				}
				//write into List<String> about clause type SVAA according to temporal	
				if ((!loc.isEmpty())&& (!tmp.isEmpty())){
					clause = "SVAA:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+tmp.trim()+"\", \""+loc.trim()+"\")"; 
					clauseTypeList.add(clause);
				}
				//write into List<String> about clause type SVA according to purpose
				if (!prp.isEmpty()){
					clause = "SVA:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+prp.trim()+"\")"; 
					clauseTypeList.add(clause);
				}
				//write into List<String> about clause type SVA according to purpose
				if ((!prp.isEmpty())&&(!tmp.isEmpty())){
					clause = "SVA:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+prp.trim()+"\", \""+tmp.trim()+"\")"; 
					clauseTypeList.add(clause);
				}
				//write into List<String> about clause type SVA according to direction
				if (!dir.isEmpty()){
					clause = "SVA:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+dir.trim()+"\")"; 
					clauseTypeList.add(clause);
				}
				//write into List<String> about clause type SVA according to manner
				if (!mnr.isEmpty()){
					clause = "SVA:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+mnr.trim()+"\")"; 
					clauseTypeList.add(clause);
				}
				
				//write into List<String> about clause type SV predicate
				if (!prd.isEmpty()){
					clause = "SV predicate:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+prd.trim()+"\")"; 
					clauseTypeList.add(clause);
				}
			}
			
				
		}
		
		return clauseTypeList;
	}	//end SVA (A: verb to be)

	
	//*******************************************************************
	/*
	 * Clause Type: SV 
	 * 
	 */
	
	public List<String> SV(Sentence sentence, String subject, KeyWord kwVerb1, KeyWord kwVerb2){
		List<String> clauseTypeList = new ArrayList<String>();
		Constituent constituent = new Constituent();
		KeyWord kwVerb = new KeyWord();
		
		String clause, verb, directObject, verbToBe, complement, dir, loc, mnr, prp, tmp, prd;

		verb = "";
		
		if (kwVerb2==null){
			kwVerb = kwVerb1;
			verb   = constituent.verb(kwVerb, sentence);
		}
		if (kwVerb2!=null){
			kwVerb = kwVerb2;
			verb   = constituent.verb2(kwVerb1, kwVerb2, sentence);
		}
		
		directObject = constituent.directObject(kwVerb, sentence);
		verbToBe     = constituent.verbToBe(kwVerb, sentence);
		complement	 = constituent.complement(kwVerb, sentence);	
		dir			 = constituent.adverbOfDir(kwVerb, sentence);
		loc			 = constituent.adverbOfLoc(kwVerb, sentence);
		mnr			 = constituent.adverbOfMnr(kwVerb, sentence);
		prp			 = constituent.adverbOfPrp(kwVerb, sentence);
		tmp			 = constituent.adverbOfTmp(kwVerb, sentence);		
		prd			 = constituent.predicate(kwVerb, sentence);
	
		//*********************************************************************
		//SV: write into List<String> about clause type SVi
		if ((!verb.isEmpty()) && (directObject.isEmpty()) && (verbToBe.isEmpty())
				&&(complement.isEmpty())){
			clause = "SV:(\""+subject.trim()+"\", \"" + verb.trim()+"\")";
			clauseTypeList.add(clause);
			
								
			//write into List<String> about clause type SViA (A:location) 
			if((!loc.isEmpty())){
				 clause = "SVA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ loc.trim() +"\")";
				 clauseTypeList.add(clause);
			}
			//write into List<String> about clause type SViA (A:temporal) 
			if(!tmp.isEmpty()){
				 clause = "SVA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ tmp.trim() +"\")";
				 clauseTypeList.add(clause);
			}
			//write into List<String> about clause type SViAA (A:temporal)
			if ((!loc.isEmpty()) && (!tmp.isEmpty())){
				clause = "SVAA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ loc.trim() +"\", \""+ tmp.trim() +"\")";
				clauseTypeList.add(clause);
			}
			//write into List<String> about clause type SViA (A:purpose) 
			if(!prp.isEmpty()){
				 clause = "SVA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ prp.trim() +"\")";
				 clauseTypeList.add(clause);
			}
			//write into List<String> about clause type SViA (A:purpose) 
			if((!prp.isEmpty())&&(!tmp.isEmpty())){
				 clause = "SVAA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ prp.trim() +"\", \""+ tmp.trim()+"\")";
				 clauseTypeList.add(clause);
			}
			//write into List<String> about clause type SViA (A:Manner)
			if(!mnr.isEmpty()){
				 clause = "SVA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ mnr.trim() +"\")";
				 clauseTypeList.add(clause);
				
			}	 
			
			//write into List<String> about clause type SViA (A:Direction) 
			if(!dir.isEmpty()){
				 clause = "SVA:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ dir.trim() +"\")";
				 clauseTypeList.add(clause);

			}
			//write into List<String> about clause type SVi predicate (A:Direction) 
			if(!prd.isEmpty()){
				 clause = "SV Predicate:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ prd.trim() +"\")";
				 clauseTypeList.add(clause);

			}
			
		}
		return clauseTypeList;

	} // end SV
	
} //end class

