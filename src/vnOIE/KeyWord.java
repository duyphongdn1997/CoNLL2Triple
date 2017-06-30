package vnOIE;

import java.util.ArrayList;
import java.util.List;

public class KeyWord {

	private String        id;
	private String        word;
	private String        posTag;
	private String        dependenceId;
	private String        dependenceType;
	private List<KeyWord> relationKeyWord;

	// ***************************************************************
	// constructors
	/**
	 * Instantiates a new KeyWord.
	 */
	public KeyWord() {

		relationKeyWord = new ArrayList<KeyWord>();

	}

	// ***************************************************************
	// constructors
	/**
	 * Instantiates a new KeyWord.
	 *
	 * @param _id, _word, _posTag, _dependenceId, _dependenceType, _relationKeyWord
	 *        
	 */
	public KeyWord(String _id, String _word, String _posTag, String _dependenceId, String _dependenceType) {

		id              = _id;
		word            = _word;
		posTag          = _posTag;
		dependenceId    = _dependenceId;
		dependenceType  = _dependenceType;

		relationKeyWord = new ArrayList<KeyWord>();

	}

	// ***************************************************************
	public String getId() {
		return id;
	}

	// ***************************************************************
	public String getWord() {
		return word;
	}

	// ***************************************************************
	public String getPosTag() {
		return posTag;

	}

	// ***************************************************************
	public String getDependenceId() {
		return dependenceId;
	}

	// ***************************************************************
	public String getDependenceType() {
		return dependenceType;
	}

	// ***************************************************************
	// idRelation ***********************
	public List<KeyWord> getRelationKeyWord() {
		return relationKeyWord;
	}

	// ***************************************************************
	public void addRelationKeyWord(KeyWord _keyWord) {
		relationKeyWord.add(_keyWord);
	}

	// ***************************************************************

	public void printKeyWord() {
		System.out.println("id:   " + id);
		System.out.println("word: " + word);
		System.out.println("posTag:  " + posTag);
		System.out.println("dependenceId:  " + dependenceId);
		System.out.println("dependenceType:  " + dependenceType);

		if (relationKeyWord != null) {
			for (int i = 0; i < relationKeyWord.size(); i++) {
				System.out.println("\n" + word + " = <" + relationKeyWord.get(i).getWord() + ", "
						+ relationKeyWord.get(i).getDependenceType() + ">");
			}
		}
	}
	// ***************************************************************

}
