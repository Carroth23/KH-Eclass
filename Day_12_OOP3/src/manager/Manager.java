package manager;

import grade.Gold;
import grade.Silver;

public class Manager {
	private Silver[] silverMembers = new Silver[10];
	private int silverIndex = 0;

	private Gold[] goldMembers = new Gold[10];
	private int goldIndex = 0;

	public void addMember(Gold g) {
		this.goldMembers[goldIndex++] = g;
	}

	public void addMember(Silver s) {
		this.silverMembers[silverIndex++] = s;
	}

	public Gold[] getGoldMembers() {
		return goldMembers;
	}

	public Silver[] getSilverMembers() {
		return silverMembers;
	}

	public int getGoldIndex() {
		return goldIndex;
	}

	public int getSilverIndex() {
		return silverIndex;
	}
}
