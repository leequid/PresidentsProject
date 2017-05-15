package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

public class PresidentDaoListImpl implements PresidentDao {
	private List<President> presList = new ArrayList<>();
	private List<President> presFilteredList;
	private int index=0;
	
	
	public List<President> getAllPresidents(){
		return new ArrayList<President>(presList);
	}
	
	public President getPreviousPres(int term){
		if (term > 0 && term <=45){
		return presList.get(term-2);
		}
		else{
			return presList.get(0);
		}
	}
	
	public President getNextPres(int term){
		if (term > 0 && term <=45){
		return presList.get(term);
		}
		else{
			return presList.get(0);
		}
	}
	
	public President filterPartyPresident(String party){
		index = 0;

			presFilteredList = new ArrayList<>();

		for (President president : presList) {
			if(president.getParty().equals(party)){
				presFilteredList.add(president);
//				for (President p : presFilteredList) {
//					System.out.println(p);
//				}
			}
		}
		return presFilteredList.get(index);
	}
	
	public List<President> getPresFilteredList(){
		return presFilteredList;
	}
	
	public President filterPartyPreviousPresident(){
		return presFilteredList.get(--index);
		
	}
	public President filterPartyNextPresident(){
		return presFilteredList.get(++index);
		
	}
	
	public President getPresident(int term){
		if (term > 0 && term <=45){
		return presList.get(term-1);
		}
		else{
			return presList.get(0);
		}
	}
	
	public PresidentDaoListImpl(ServletContext context){
		loadPresident(context);
	}
	
	public void loadPresident(ServletContext context){
		InputStream is = context.getResourceAsStream("/WEB-INF/president.tsv");
		System.out.println("test");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
			System.out.println("test");
			String record; // Read and discard header line
			while ((record = reader.readLine()) != null) {
				String[] col = record.split("\\|");
				int termnum = Integer.parseInt(col[0]);
				President i = new President(termnum,col[1],col[2],col[3],col[4],col[5],col[6],col[7],col[8],col[9],col[10]);
//				System.out.println(i);
				presList.add(i);
			}
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

	
	
}