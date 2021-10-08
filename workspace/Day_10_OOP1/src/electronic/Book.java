package electronic;

public class Book {

	private int id = 1001; // ����Ʈ ���(���� �ʱⰪ)
	private String title = "�ι̿��� �ٸ���"; // ����Ʈ ����� Ŭ���� �����ڰ� �ʱ⿡ �����صδ� ��
	private int price;

	public Book() {} // �����ڸ� �����ε� �صθ� ���ο��� ������ �ȳ�
	public Book(int id, String title, int price){ // ������ constructor
		this.id = id; // �̷������� �ʱⰪ �����Ҷ� �����ڸ� ���
		this.title = title; // ����Ʈ���ʹ� ����ڰ� �ʱ⿡ �ִ� ��
		this.price = price;
	}
	
	public int getId() { 
		return id;
	}

	public void setId(int id) { // ��ü ����� ���� �����Ҷ� ���� ��  1. ����Ʈ ��� 2. ������� ����Ʈ���� 3. ������� ���� ������ ���� ����
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
