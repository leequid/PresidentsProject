package data;

import java.util.List;

public interface PresidentDao {
	
	
	List<President> getAllPresidents();
	President getPresident(int a);
}
