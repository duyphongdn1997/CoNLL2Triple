package vnOIE;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

	/**
	 * read data from file
	 *
	 * @param data file name 
	 * @return list of file data 
	 */
	public List<String> readFile(String fileName) throws UnsupportedEncodingException, IOException{
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName), "UTF-8"));
			
			List<String> data = new ArrayList<String>();
			
			String line = "";
			while((line = reader.readLine()) != null){
					data.add(line);
			}
			reader.close();
			
			return data;	
			
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}			
	} //end readFile
	
	
	/**
	 * Read a data Line and return String [] words 
	 *
	 * @param  a data Line in List
	 * @return String[] words in a line 
	 */
	
	public String[]  ReadWordLine(String dataLine){
				
		String[] words= dataLine.split("\\t"); 
		return words;
	}
	/**
	 * print all data by line which a line is a string 
	 *
	 * @param  a data Line in List
	 * @return all lines in data file 
	 */
	
	public void printDataFile(List<String> dataFileList){
		
		for (int i=0; i<dataFileList.size(); i++){
			System.out.println(dataFileList.get(i));
			
		}
		
	}
}

