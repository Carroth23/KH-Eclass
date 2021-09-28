package manager;

import java.util.ArrayList;

import grade.Grade;

public class Manager {
	private ArrayList members = new ArrayList();
	
	public void addMember(Grade g) {
		this.members.add(g);
	}
	public ArrayList getMembers() {
		return members;
	}

}
