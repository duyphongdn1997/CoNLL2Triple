package vnOIE;

import java.util.ArrayList;

import java.util.List;

public class SetClause {
	//***************************************************************
	/**
	 * 
	 * 
	 */
	
	public List<String> setOfClause(Sentence sentence){
		List<String> clauseTypeList = new ArrayList<String>();
		List<String> clause         = new ArrayList<String>();
		
		KeyWord kwRootVerb = new KeyWord();
		KeyWord kwVerb     = new KeyWord();
		
		KeyWord kwVmodSinmilarVerb     = new KeyWord();
		
		Constituent constituent = new Constituent();
		ClauseType  clauseType  = new ClauseType();
		
		
		String rootSubject, subject;
		String strId;
		int countVerb, countClause;
		int id1, id2;
		id1 = 0;
		id2 = 0;
		countVerb   = 0;
		countClause = 0;
		
		kwVmodSinmilarVerb = null;
		rootSubject        = "";
		
		if (constituent.isSentence(sentence)){
			for(int i=0; i<sentence.size(); i++){
				//main clause
				if (constituent.isRootVerb(sentence.get(i).getId(), sentence)){
					
					kwRootVerb    = sentence.get(i);
					rootSubject   = constituent.subject(kwRootVerb, sentence);
					
					//keyword is a verb which support to verb1 and dependence type is vmod 
					if ((constituent.isVmodSimilarVerb(kwRootVerb, sentence))
					&& (!constituent.hasSubject(constituent.getKeyWordOfVmodSimilarVerb(kwRootVerb, sentence)))) {
						
						//Main Clause
						clause = clauseType.detectClauseType(sentence, rootSubject, kwRootVerb, constituent.getKeyWordOfVmodSimilarVerb(kwRootVerb, sentence));
						clauseTypeList.addAll(clause);
						countClause = countClause + clause.size();
						countVerb++;
						
					}
					
					if (!(constituent.isVmodSimilarVerb(kwRootVerb, sentence))){
						
						
						//Main Clause 						
						clause = clauseType.detectClauseType(sentence, rootSubject, kwRootVerb, kwVmodSinmilarVerb);
						
						clauseTypeList.addAll(clause);
						countClause = countClause + clause.size();
						
						countVerb++;
					}
				}
			} //for main clause
			
			// SubbordinateClause  Or Coordinate
			
			for(int i=0; i<sentence.size(); i++){
				if (sentence.get(i).getDependenceType().contains("coord")
					&& (sentence.getKeyWordConjByCoord(sentence.get(i).getId()).getId()!=null)	
					){
					
					
					//if dependentId of coord is verb
					strId = sentence.get(i).getDependenceId();
					if(constituent.isRootVerb(strId, sentence)
							|| (constituent.isVerb(sentence.getKeyWordById(strId), sentence))
							|| ((constituent.isRootVerb(sentence.getKeyWordById(sentence.getKeyWordById(strId).getDependenceId()).getId(), sentence))
								&& sentence.getKeyWordById(sentence.getKeyWordById(strId).getId()).getDependenceType().contentEquals("vmod"))
							|| ((constituent.isVerb(sentence.getKeyWordById(sentence.getKeyWordById(sentence.getKeyWordById(strId).getDependenceId()).getId()), sentence))
							    && sentence.getKeyWordById(sentence.getKeyWordById(strId).getId()).getDependenceType().contentEquals("vmod"))
							){
						if (constituent.isRootVerb(sentence.get(i).getDependenceId(), sentence)
							|| 	(constituent.isVerb(sentence.getKeyWordById(sentence.get(i).getDependenceId()), sentence))
								){
							kwVerb  = sentence.getKeyWordById(strId);	
						}
						else{
							kwVerb = sentence.getKeyWordById(sentence.getKeyWordById(sentence.getKeyWordById(strId).getDependenceId()).getId());
							
						}
						
						
						subject = constituent.subject(kwVerb, sentence);
					//************************************************************
						
						if ((constituent.isVmodSimilarVerb(kwVerb, sentence))
								&& (!constituent.hasSubject(constituent.getKeyWordOfVmodSimilarVerb(kwVerb, sentence)))
								&& (!subject.isEmpty())
							) {	
							
							//Main Clause + coordinate clause 
							clause = coordinateClause(sentence, subject, kwVerb, constituent.getKeyWordOfVmodSimilarVerb(kwVerb, sentence), sentence.get(i));							
							clauseTypeList.addAll(clause);
							countClause = countClause + clause.size();
							
						}
						
						if (!(constituent.isVmodSimilarVerb(kwVerb, sentence))){

							//Main Clause + coordinate clause 
							clause = coordinateClause(sentence, subject, kwVerb, kwVmodSinmilarVerb, sentence.get(i));							
							clauseTypeList.addAll(clause);
							countClause = countClause + clause.size();							
						}

					
						//coordinate clause has Subject (sub) according to Conjunction (conj)
						strId = sentence.get(i).getId();
						
						if  ((constituent.hasSubject(sentence.getKeyWordConjByCoord(strId)))){
							kwVerb  = sentence.getKeyWordConjByCoord(strId);
							subject = constituent.subject(kwVerb, sentence);
							
						}
						else{
							if  (!(constituent.hasSubject(sentence.getKeyWordConjByCoord(strId)))){
								
								kwVerb    = sentence.getKeyWordConjByCoord(strId);
								
							
							}
						}
						
						
						//subordinate clause				
						//keyword is a verb which support to verb1 and dependence type is vmod 
						if (constituent.isVmodSimilarVerb(kwVerb, sentence)
								&& !subject.isEmpty()){							
							clause = clauseType.detectClauseType(sentence, subject, kwVerb, constituent.getKeyWordOfVmodSimilarVerb(kwVerb, sentence));
							clauseTypeList.addAll(clause);
							countClause = countClause + clause.size();
							countVerb++;
							
						}
						if (!(constituent.isVmodSimilarVerb(kwVerb, sentence)) 
								&& (!subject.isEmpty())){
							
							clause = clauseType.detectClauseType(sentence, subject, kwVerb, kwVmodSinmilarVerb); 
							clauseTypeList.addAll(clause);
							countClause = countClause + clause.size();
							countVerb++;
						}
						
					} //end if dependentId of coord is verb
					
					//if dependentId of coord is not verb
					strId = sentence.get(i).getDependenceId();
					if (!(constituent.isRootVerb(strId, sentence))){
						
						if ((!(sentence.getKeyWordById(strId).getDependenceType().contains("prd")))
							&& (!(sentence.getKeyWordById(strId).getDependenceType().contains("dep")))
							&& (!(sentence.getKeyWordById(strId).getDependenceType().contains("dob")))
							&& (!(sentence.getKeyWordById(strId).getDependenceType().contains("prp")))
							&& ((constituent.isVerb(sentence.getKeyWordById(strId),sentence))
								//|| constituent.isRootVerb(sentence.getKeyWordById(strId).getDependenceId(), sentence)
								//|| (constituent.isVerb(sentence.getKeyWordById(sentence.getKeyWordById(strId).getDependenceId()), sentence))
								)
							){
							
							
							
							strId = sentence.getKeyWordById(strId).getDependenceId();
							kwVerb = sentence.getKeyWordById(strId);
							subject = constituent.subject(kwVerb, sentence);
							//************************************************************
								 
							if ((constituent.isVmodSimilarVerb(kwVerb, sentence))
									&& (!constituent.hasSubject(constituent.getKeyWordOfVmodSimilarVerb(kwVerb, sentence)))
									&& (!subject.isEmpty())
								) {	
								//Main Clause + coordinate clause 
								clause = coordinateClause(sentence, subject, kwVerb, constituent.getKeyWordOfVmodSimilarVerb(kwVerb, sentence), sentence.get(i));							
								clauseTypeList.addAll(clause);
								countClause = countClause + clause.size();
								
							}
							
							if (!(constituent.isVmodSimilarVerb(kwVerb, sentence))){

								//Main Clause + coordinate clause 
								clause = coordinateClause(sentence, subject, kwVerb, kwVmodSinmilarVerb, sentence.get(i));							
								clauseTypeList.addAll(clause);
								countClause = countClause + clause.size();							
							}

						
						}
						
						if ((sentence.getKeyWordById(strId).getDependenceType().contains("dep"))
							&& ((constituent.isRootVerb(sentence.getKeyWordById(strId).getDependenceId(), sentence))
								||(constituent.isVerb(sentence.getKeyWordById(sentence.getKeyWordById(strId).getDependenceId()), sentence)))
								){
							
														
							strId = sentence.getKeyWordById(strId).getDependenceId();
							kwVerb = sentence.getKeyWordById(strId);
							subject = constituent.subject(kwVerb, sentence);
							
							//************************************************************
							 
							if ((constituent.isVmodSimilarVerb(kwVerb, sentence))
									&& (!constituent.hasSubject(constituent.getKeyWordOfVmodSimilarVerb(kwVerb, sentence)))
									&& (!subject.isEmpty())
								) {	
								//Main Clause + coordinate clause 
								clause = coordinateClause(sentence, subject, kwVerb, constituent.getKeyWordOfVmodSimilarVerb(kwVerb, sentence), sentence.get(i));							
								clauseTypeList.addAll(clause);
								countClause = countClause + clause.size();
																
							}
							
							if (!(constituent.isVmodSimilarVerb(kwVerb, sentence))){

								//Main Clause + coordinate clause 
								clause = coordinateClause(sentence, subject, kwVerb, kwVmodSinmilarVerb, sentence.get(i));							
								clauseTypeList.addAll(clause);
								countClause = countClause + clause.size();	
								
							}
								
						

						}
						
					}//end if dependentId of coord is not verb
					
					
				}//end if coord
				
				
				
				id1 = Integer.parseInt(sentence.get(i).getDependenceId());
				id2 = Integer.parseInt(sentence.get(i).getId());
				strId = sentence.get(i).getDependenceId();
				
				//if Subbordinate clause dependence clause which has  coord and conj
				
				if ((constituent.isVerb(sentence.get(i), sentence))
					&& 	(sentence.getKeyWordById(strId).getDependenceType().contentEquals("conj"))
					&& (!sentence.getKeyWordById(sentence.get(i).getDependenceId()).getDependenceType().contentEquals("prp"))
					&& ((!(id1+1==id2))
						)
					){
					subject = "";
					
					if (constituent.hasSubject(sentence.getKeyWordById(strId))){
						kwVerb  = sentence.getKeyWordById(sentence.get(i).getDependenceId());					
						subject = constituent.subject(kwVerb, sentence);
						//countVerb++;
					}
					if (!(constituent.hasSubject(sentence.getKeyWordById(strId)))){
						kwVerb  = sentence.getKeyWordById(sentence.get(i).getDependenceId());
						
						
						if ((sentence.getKeyWordById(kwVerb.getDependenceId()).getDependenceType().contentEquals("coord"))
							&& ((constituent.isRootVerb(sentence.getKeyWordById(kwVerb.getDependenceId()).getDependenceId(), sentence))
								|| 	(constituent.isVerb(sentence.getKeyWordById(sentence.getKeyWordById(kwVerb.getDependenceId()).getDependenceId()), sentence)))
								){
							
							subject = constituent.subject(sentence.getKeyWordById(sentence.getKeyWordById(kwVerb.getDependenceId()).getDependenceId()), sentence);
							//countVerb++;
						}
							
					}
					
					//************************************************************
					 
					if ((constituent.isVmodSimilarVerb(kwVerb, sentence))
							&& (!constituent.hasSubject(constituent.getKeyWordOfVmodSimilarVerb(kwVerb, sentence)))
							&& (!subject.isEmpty())
						) {	
						//Main Clause + subordinate clause						
						clause = subordinateClause(sentence, subject, kwVerb, constituent.getKeyWordOfVmodSimilarVerb(kwVerb, sentence), sentence.get(i)); 							
						clauseTypeList.addAll(clause);
						
						countClause = countClause + clause.size();
						
					}
					
					if (!(constituent.isVmodSimilarVerb(kwVerb, sentence))){

						//Main Clause + subordinate clause						
						clause = subordinateClause(sentence, subject, kwVerb, kwVmodSinmilarVerb, sentence.get(i)); 							
						clauseTypeList.addAll(clause);
						
						countClause = countClause + clause.size();													
					}

									
					
				}//end if Subbordinate clause dependence clause which has  coord and conj
				
				//if Subbordinate clause. there are not coord and conj
				
				id1 = Integer.parseInt(sentence.get(i).getDependenceId());
				id2 = Integer.parseInt(sentence.get(i).getId());
				
				strId = sentence.get(i).getDependenceId();
				
				if ((constituent.isVerb(sentence.get(i), sentence))
					&& !(sentence.get(i).getDependenceType().contentEquals("conj"))
					&& ((!(sentence.get(i).getDependenceType().contentEquals("dep")))
						|| (constituent.hasSubject(sentence.get(i)))	
						)
					&& ((!((id1+1)==id2))
						//|| (constituent.isVmodSimilarVerb(sentence.getKeyWordById(sentence.get(i).getDependenceId()), sentence))	
						)
					
					&& (constituent.isRootVerb(strId, sentence)
						|| constituent.isVerb(sentence.getKeyWordById(strId), sentence)
						|| constituent.isRootVerb(sentence.getKeyWordById(strId).getDependenceId(), sentence)
						|| constituent.isVerb(sentence.getKeyWordById(sentence.getKeyWordById(strId).getDependenceId()), sentence)
						
					   )
					){
					
					kwVerb   = sentence.getKeyWordById(sentence.get(i).getDependenceId());					
					subject  = constituent.subject(kwVerb, sentence);
					
					//************************************************************
					 
					if ((constituent.isVmodSimilarVerb(kwVerb, sentence))
							&& (!constituent.hasSubject(constituent.getKeyWordOfVmodSimilarVerb(kwVerb, sentence)))
					
						) {	
						kwVmodSinmilarVerb = constituent.getKeyWordOfVmodSimilarVerb(kwVerb, sentence);
						
					}
					
					if (!(constituent.isVmodSimilarVerb(kwVerb, sentence))){
						kwVmodSinmilarVerb = null;
																			
					}

				//*************************************************************	
					
					if (!subject.isEmpty()
							&& (!(sentence.get(i).getDependenceType().contentEquals("prd")))
							
							&& (!sentence.getKeyWordById(sentence.get(i).getDependenceId()).getDependenceType().contentEquals("conj"))
							&& (!sentence.getKeyWordById(sentence.get(i).getDependenceId()).getDependenceType().contentEquals("prp"))
							){
						
						//Main Clause + subordinate clause						
						clause = subordinateClause(sentence, subject, kwVerb, kwVmodSinmilarVerb, sentence.get(i)); 							
						clauseTypeList.addAll(clause);
						
						countClause = countClause + clause.size();
						
						kwVmodSinmilarVerb = null;
						
						
					}					
					if (subject.isEmpty()
						//&& (constituent.isVmodSimilarVerb(sentence.getKeyWordById(sentence.get(i).getDependenceId()), sentence))
						&& (constituent.hasSubject(sentence.getKeyWordById(sentence.getKeyWordById(sentence.get(i).getDependenceId()).getDependenceId())))
						&& (!sentence.getKeyWordById(sentence.get(i).getDependenceId()).getDependenceType().contentEquals("prp"))
						){
						
						kwVerb   = sentence.getKeyWordById(sentence.getKeyWordById(sentence.get(i).getDependenceId()).getDependenceId());
						subject  = constituent.subject(kwVerb, sentence);
						
						if ((constituent.isVmodSimilarVerb(kwVerb, sentence))
								&& (!constituent.hasSubject(constituent.getKeyWordOfVmodSimilarVerb(kwVerb, sentence)))
						
							) {	
							kwVmodSinmilarVerb = constituent.getKeyWordOfVmodSimilarVerb(kwVerb, sentence);
							
						}
						
						if (!(constituent.isVmodSimilarVerb(kwVerb, sentence))){
							kwVmodSinmilarVerb = null;
																				
						}	
						//Main Clause + subordinate clause						
						clause = subordinateClause(sentence, subject, kwVerb, kwVmodSinmilarVerb, sentence.get(i)); 							
						clauseTypeList.addAll(clause);
						countClause = countClause + clause.size();
						
						kwVmodSinmilarVerb = null;
						
					}
					
					
					//Subbordinate Clause has subject 
					
					if  (constituent.hasSubject(sentence.get(i))){
						
						kwVerb  = sentence.get(i);
						subject = constituent.subject(kwVerb, sentence);
						
					}
					else{
						
						if  (!(constituent.hasSubject(sentence.get(i)))){
							
							//kwVerb  = sentence.getKeyWordById(sentence.get(i).getId());
							kwVerb  = sentence.get(i);
						}
					}	
					
					
					//subordinate clause				
					//keyword is a verb which support to verb1 and dependence type is vmod 
					
					if (constituent.isVmodSimilarVerb(kwVerb, sentence)
							&& (!subject.isEmpty())){
						
						clause = clauseType.detectClauseType(sentence, subject, kwVerb, constituent.getKeyWordOfVmodSimilarVerb(kwVerb, sentence));
						clauseTypeList.addAll(clause);
						countClause = countClause + clause.size();
						countVerb++;
						
					}
					if (!(constituent.isVmodSimilarVerb(kwVerb, sentence))
							&& (!subject.isEmpty())){	
						
						kwVmodSinmilarVerb = null;
						clause = clauseType.detectClauseType(sentence, subject, kwVerb, kwVmodSinmilarVerb); 
						clauseTypeList.addAll(clause);
						countClause = countClause + clause.size();
						countVerb++;
						
					}
					
					

				} //end if Subbordinate clause
			}//for SubbordinateClause  Or Coordinate

		} // if isSentence
		
		if (countVerb>0){
			String VerbNumber = String.valueOf(countVerb);
			
			VerbNumber = "Total verb number of a sentence: "+"\t\t" +VerbNumber;
			clauseTypeList.add(VerbNumber);
		}
		if (countClause>0){
			
			String clauseNumber = String.valueOf(countClause);
			
			clauseNumber = "Total clause number of a sentence: "+"\t\t\t"+clauseNumber;
			clauseTypeList.add(clauseNumber);	
		}
		
		return clauseTypeList;
		
	}  //end setOfClause
	
	//***************************************************************
	/**
	 *  Main Clause+ subordinate Clause: SV + subordinate clause
	 *	Have not dependence type "coord"			
	 * @param sentence
	 * @return subordinate Clause: SV + subordinate clause
	 */
		
	public List<String> subordinateClause(Sentence sentence, String subject, KeyWord kwVerb1, KeyWord kwVerb2, KeyWord kwSubVerb){
		List<String> clauseTypeList = new ArrayList<String>();
		
		Constituent constituent = new Constituent();
		KeyWord kwVerb = new KeyWord();
		
		String verb, directObject, inDirectObject, verbToBe, complement;
		String subClause, clause;
		
		verb = "";
		
		//constituents of each clause by String
		
		
		if (kwVerb2==null){
			kwVerb = kwVerb1;
			verb   = constituent.verb(kwVerb, sentence);
		}
		if (kwVerb2!=null){
			kwVerb = kwVerb2;
			
			verb   = constituent.verb2(kwVerb1, kwVerb2, sentence);
			
			
		}

		
		//verb    	   = constituent.verb(kwVerb, sentence);
		
		directObject   = constituent.directObject(kwVerb, sentence);
		
		inDirectObject = constituent.inDirectObject(kwVerb, sentence);
		
		verbToBe       = constituent.verbToBe(kwVerb, sentence);
		complement	   = constituent.complement(kwVerb, sentence);
		
		subClause      = constituent.subordinateClause(kwSubVerb, sentence);
		
		
		//clause-type detection
		//*********************************************************************
		//SV: write into List<String> about clause type SVi
		if ((!verb.isEmpty()) && (!subject.isEmpty()) && !(subClause.isEmpty())
				&& verbToBe.isEmpty()){
			if (directObject.isEmpty()){
				
				clause = "SV + subClause:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ subClause+"\")";
				clauseTypeList.add(clause);
			}
			if (!directObject.isEmpty() && (!directObject.contains(subClause))
					&& (inDirectObject.isEmpty())
					){
				clause = "SVO + subClause:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \"" + directObject.trim()+"\", \""+ subClause+"\")";
				clauseTypeList.add(clause);
				
			}
			if (!directObject.isEmpty() && (!directObject.contains(subClause))
					&& (!inDirectObject.isEmpty()) && (!inDirectObject.contains(subClause))	
					){
				clause = "SVOO + subClause:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \"" + directObject.trim()+"\", \""+ inDirectObject.trim()+"\", \""+subClause+"\")";
				clauseTypeList.add(clause);
				
			}
		}
		if ((!verbToBe.isEmpty()) && (!complement.isEmpty()) && (!subClause.isEmpty())
				&& (!complement.contains(subClause))){
			clause = "SVC + subClause:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \"" + complement.trim()+"\", \""+ subClause+"\")";
			clauseTypeList.add(clause);
		}
		
		return clauseTypeList;
	}//Main clause + subordinate clause	
	//***************************************************************
	/**
	 *  Main Clause+ subordinate Clause: SV + subordinate clause (coordinate)
	 *				
	 * @param sentence
	 * @return subordinate Clause: SV + subordinate clause (coordinate)
	 */
		
	public List<String> coordinateClause(Sentence sentence, String subject, KeyWord kwVerb1, KeyWord kwVerb2, KeyWord kwCoord){
		List<String> clauseTypeList = new ArrayList<String>();
		Constituent constituent = new Constituent();
		
		String verb, directObject, inDirectObject;
		String clause, coordClause, verbToBe, complement;
		KeyWord kwVerb = new KeyWord();
		
		verb 	    = "";
		clause	    = "";
		coordClause = "";

		//all the constituents of each clause by String
		
		if (kwVerb2==null){
			kwVerb = kwVerb1;
			verb   = constituent.verb(kwVerb, sentence);
		}
		if (kwVerb2!=null){
			kwVerb = kwVerb2;
			
			verb   = constituent.verb2(kwVerb1, kwVerb2, sentence);
			
			
		}
		//verb      = constituent.verb(kwVerb, sentence); 
		
		
		directObject   = constituent.directObject(kwVerb, sentence);
		inDirectObject = constituent.inDirectObject(kwVerb, sentence);
		coordClause    = constituent.coordinateClause(kwCoord, sentence);
		verbToBe       = constituent.verbToBe(kwVerb, sentence);
		complement	   = constituent.complement(kwVerb, sentence);
		
		
		
		if (sentence.getKeyWordById(kwCoord.getDependenceId()).getDependenceType().contentEquals("dep")){
			coordClause = sentence.getKeyWordById(kwCoord.getDependenceId()).getWord()+" "+coordClause;
		}
		
		//clause-type detection
		//*********************************************************************
		//SV: write into List<String> about clause type SVi
		if ((!verb.isEmpty()) && (!subject.isEmpty()) && !(coordClause.isEmpty())
				&& verbToBe.isEmpty()){
			
			if (directObject.isEmpty()){
				clause = "SV + coordClause:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \""+ coordClause+"\")";
				clauseTypeList.add(clause);
			}
			
			
			if (!(directObject.isEmpty()) && (!directObject.contains(coordClause))){
				
				clause = "SVO + coordClause:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \"" + directObject.trim()+"\", \""+ coordClause+"\")";
				clauseTypeList.add(clause);
			}
			if (!(directObject.isEmpty()) && (!directObject.contains(coordClause))
				&& (!inDirectObject.isEmpty()) && (!inDirectObject.contains(coordClause))	
				){
				
				clause = "SVOO + coordClause:(\""+subject.trim()+"\", \"" + verb.trim()+"\", \"" + directObject.trim()+"\", \"" + inDirectObject.trim()+"\", \""+ coordClause+"\")";
				clauseTypeList.add(clause);
			}
			
		}
		if ((!verbToBe.isEmpty())&&(!complement.isEmpty())&& !(coordClause.isEmpty())){
			clause = "SVC + coordClause:(\""+subject.trim()+"\", \"" + verbToBe.trim()+"\", \""+ complement.trim()+"\", \""+ coordClause+"\")";
			clauseTypeList.add(clause);
		}
		
		return clauseTypeList;
	}//Main clause + coordinate clause	

	

}



