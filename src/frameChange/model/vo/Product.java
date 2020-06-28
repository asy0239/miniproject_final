package frameChange.model.vo;

import java.awt.Image;

public class Product extends Market {
	// 무작위 제품 객체를 생성
	
	private String name;
	private int price;
	private int cnt=0;
	private Image img;
	private int x;
	private int y;
	private boolean checked = false;
	
	public Product() {}
	

	public Product(String name, int price) {
		this();
		this.name = name;
		this.price = price;
	}
	
	public Product(String name, int price, int cnt, Image img, int x, int y) {
		this(name, price);
		this.name = name;
		this.price = price;
		this.cnt = cnt;
		this.img = img;
		this.x = 0;
		this.y = 0;
	}
	
	public Product(Product product) {
		this.name = product.name;
		this.price = product.price;
		this.img = product.img;
		this.x = product.x;
		this.y = product.y;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public int getCnt() {
		return cnt;
	}


	public void setCnt(int cnt) {
		this.cnt = cnt;
	}


	@Override
	public String toString() {
		return name + ":  " + price + "원    ";
	}

	
}
