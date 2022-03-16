package manager;

import java.util.ArrayList;

import classes.Menu;

public class Manager {
	private ArrayList<Menu> menus = new ArrayList<>();

	public void addMenu(Menu m) {
		this.menus.add(m);
	}

	public ArrayList<Menu> getMenus() {
		return this.menus;
	}

	public void deleteMenu(int id) {
		ArrayList<Menu> tmp = new ArrayList<>();
		for (Menu m : this.menus) {
			if (m.getId() == id) {
				tmp.add(m);
			}
		}
		for (Menu m : tmp) {
			this.menus.remove(m);
		}
	}

}
