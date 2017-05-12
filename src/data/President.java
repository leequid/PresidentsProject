package data;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class President implements Comparable<President> {
	private int termNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private LocalDate startTerm;
	private LocalDate endTerm;
	private int electionsWon;
	private String whyLeftOffice;
	private String party;

	public President(int termNumber, String firstName, String middleName, String lastName, int electionsWon,
			String reasonLeftOffice, String party) {
		super();
		this.termNumber = termNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.electionsWon = electionsWon;
		this.whyLeftOffice = reasonLeftOffice;
		this.party = party;
	}


	public President(int termNumber, String firstName, String middleName, String lastName, LocalDate startTerm,
			LocalDate endTerm, int electionsWon, String whyLeftOffice, String party) {
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
	}


	public Period getTermLength() throws DateTimeParseException {
		if (getEndTerm() != null) {
			return Period.between(getStartTerm(), getEndTerm());
		} else {
			return Period.between(getStartTerm(), LocalDate.now());
		}
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

	public int getElectionsWon() {
		return electionsWon;
	}

	public void setElectionsWon(int electionsWon) {
		this.electionsWon = electionsWon;
	}

	public String getWhyLeftOffice() {
		return whyLeftOffice;
	}

	public void setWhyLeftOffice(String reasonLeftOffice) {
		this.whyLeftOffice = reasonLeftOffice;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public LocalDate getStartTerm() {
		return startTerm;
	}

	public void setStartTerm(LocalDate startTerm) {
		this.startTerm = startTerm;
	}

	public LocalDate getEndTerm() {
		return endTerm;
	}

	public void setEndTerm(LocalDate endTerm) {
		this.endTerm = endTerm;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("President [termNumber=");
		builder.append(termNumber);
		builder.append(",\t firstName=");
		builder.append(firstName);
		builder.append(",\t middleName=");
		builder.append(middleName);
		builder.append(",\t lastName=");
		builder.append(lastName);
		builder.append(",\t startTerm=");
		builder.append(startTerm);
		builder.append(",\t endTerm=");
		builder.append(endTerm);
		builder.append(",\t termLength=");
		builder.append(getTermLength());
		builder.append(",\t electionsWon=");
		builder.append(electionsWon);
		builder.append(",\t whyLeftOffice=");
		builder.append(whyLeftOffice);
		builder.append(",\t party=");
		builder.append(party);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(President other) {
		if (this.termNumber > other.termNumber) {
			return 1;
		} else if (this.termNumber < other.termNumber) {
			return -1;
		}
		return 0;
	}

}