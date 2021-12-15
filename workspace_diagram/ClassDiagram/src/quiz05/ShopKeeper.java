package quiz05;

public class ShopKeeper {
	private Cart cart;
	public int makeBillPaper() {
		Item item = new Item();
		return item.getItemPrice();
		
	};
	public Cart getCart() {
		return this.cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public void calculate(Calculator c) {

	}

}
