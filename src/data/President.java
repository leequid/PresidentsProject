package data;


public class President {
	private int termNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private String startTerm;
	private String endTerm;
	private String electionsWon;
	private String whyLeftOffice;
	private String party;
	private String pet;
	private String url;

public President (){
	
}
	public President(int termNumber, String firstName, String middleName, String lastName, String startTerm,
			String endTerm, String electionsWon, String whyLeftOffice, String party, String pet, String url) {
		super();
		this.termNumber = termNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.startTerm = startTerm;
		this.endTerm = endTerm;
		this.electionsWon = electionsWon;
		this.whyLeftOffice = whyLeftOffice;
		this.party = party;
		this.pet = pet;
		this.url = url;
	}
	
	

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getTermNumber() {
		return termNumber;
	}
	public void setTermNumber(int termNumber) {
		this.termNumber = termNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStartTerm() {
		return startTerm;
	}
	public void setStartTerm(String startTerm) {
		this.startTerm = startTerm;
	}
	public String getEndTerm() {
		return endTerm;
	}
	public void setEndTerm(String endTerm) {
		this.endTerm = endTerm;
	}
	public String getElectionsWon() {
		return electionsWon;
	}
	public void setElectionsWon(String electionsWon) {
		this.electionsWon = electionsWon;
	}
	public String getWhyLeftOffice() {
		return whyLeftOffice;
	}
	public void setWhyLeftOffice(String whyLeftOffice) {
		this.whyLeftOffice = whyLeftOffice;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getPet() {
		return pet;
	}
	public void setPet(String pet) {
		this.pet = pet;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("President [termNumber=");
		builder.append(termNumber);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", middleName=");
		builder.append(middleName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append("]");
		return builder.toString();
	}

}