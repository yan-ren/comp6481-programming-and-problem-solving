//
// Assignment 1, part II A
// © Yan Ren
// Written by: Yan Ren 40212201
//
package a1;

import java.util.Arrays;
import java.util.Objects;

public class Voter {
	private long voterID;
	private String voterName;
	private byte voterAge;
	private String voterEmail;
	private char[] voterPcode;

	private static int numberOfCreatedVoters = 0;

	public Voter(long voterID, String voterName, byte voterAge, String voterEmail, char[] voterPcode) {
		this.voterID = voterID;
		this.voterName = voterName;
		this.voterAge = voterAge;
		this.voterEmail = voterEmail;
		this.voterPcode = voterPcode;
		numberOfCreatedVoters++;
	}

	public String getVoterName() {
		return voterName;
	}

	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}

	public byte getVoterAge() {
		return voterAge;
	}

	public void setVoterAge(byte voterAge) {
		this.voterAge = voterAge;
	}

	public String getVoterEmail() {
		return voterEmail;
	}

	public void setVoterEmail(String voterEmail) {
		this.voterEmail = voterEmail;
	}

	public char[] getVoterPcode() {
		return voterPcode;
	}

	public void setVoterPcode(char[] voterPcode) {
		this.voterPcode = voterPcode;
	}

	public long getVoterID() {
		return voterID;
	}

	@Override
	public String toString() {
		return "Voter [voterID=" + voterID + ", voterName=" + voterName + ", voterAge=" + voterAge + ", voterEmail="
				+ voterEmail + ", voterPcode=" + Arrays.toString(voterPcode) + "]";
	}

	public static int findNumberOfCreatedVoters() {
		return numberOfCreatedVoters;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(voterPcode);
		result = prime * result + Objects.hash(voterID);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voter other = (Voter) obj;
		return voterID == other.voterID && Arrays.equals(voterPcode, other.voterPcode);
	}

}
