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



	public President(int termNumber, String firstName, String middleName, String lastName, String startTerm,
			String endTerm, String electionsWon, String whyLeftOffice, String party, String pet) {
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
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("President [termNumber=");
		return builder.toString();
	}

}