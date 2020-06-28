package frameChange.controller;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.ImageIcon;

import frameChange.model.vo.Market;
import frameChange.model.vo.Product;

public class ProductManager extends Market {

	private Product[] productList;
	private final int cntProduct = 10;
	private ArrayList<Product> alist;
	private int[][] XY; // 좌표
	private Image imgTrash, imgBanana, imgBook, imgFish, imgGrape, imgNecklaces, imgShoes, imgWatermelon;

	public ProductManager() {
		this.productList = new Product[cntProduct];
		
		String path = System.getProperty("user.dir") + "\\images\\";
		
		imgTrash = new ImageIcon(path + "shop\\icon_trash.png").getImage().getScaledInstance(50, 50, 0);
		imgBanana = new ImageIcon(path + "shop\\productBanana.png").getImage().getScaledInstance(50, 50, 0);
		imgBook = new ImageIcon(path + "shop\\productBook.png").getImage().getScaledInstance(50, 50, 0);
		imgFish = new ImageIcon(path + "shop\\productFish.png").getImage().getScaledInstance(50, 50, 0);
		imgGrape = new ImageIcon(path + "shop\\productGrape.png").getImage().getScaledInstance(50, 50, 0);
		imgNecklaces = new ImageIcon(path + "shop\\productNecklaces.png").getImage().getScaledInstance(50, 50, 0);
		imgShoes = new ImageIcon(path + "shop\\productShoes.png").getImage().getScaledInstance(50, 50, 0);
		imgWatermelon = new ImageIcon(path + "shop\\productWatermelon.png").getImage().getScaledInstance(50, 50, 0);

		alist = new ArrayList<Product>();

		alist.add(new Product("쓰레기", 0, 0, imgTrash, 0, 0));
		alist.add(new Product("바나나", 1300, 0, imgBanana, 0, 0));
		alist.add(new Product("포도", 4400, 0, imgGrape, 0, 0));
		alist.add(new Product("생선", 5700, 0, imgFish, 0, 0));
		alist.add(new Product("수박", 8000, 0, imgWatermelon, 0, 0));
		alist.add(new Product("목걸이", 13200, 0, imgNecklaces, 0, 0));
		alist.add(new Product("책", 15000, 0, imgBook, 0, 0));
		alist.add(new Product("신발", 34000, 0, imgShoes, 0, 0));
	
		
		for(int i=0; i<productList.length; i++) {
			Collections.shuffle(alist);
			System.out.println(alist.get(0).getName());
			productList[i] = alist.get(0);
		}
		
		Random rand = new Random();
		
		for(int i=0; i<productList.length; i++) {

			productList[i].setX( rand.nextInt(super.getWIDTH()/10)*10 );
			productList[i].setY( rand.nextInt(super.getHEIGHT()/10)*10 );

			System.out.println(productList[i].getX() + " " + productList[i].getY() );

			if (!super.checkXY(productList[i].getX(), productList[i].getY())) {
				i--;
			}

		}
	}

	// product를 배치할 임의의 위치를 만드는 함수
	public int[] makeXY(int[] xy) {
		System.out.println("makeXY 호출");

		int tempX = ((int) Math.random() * super.getWIDTH());
		int tempY = ((int) Math.random() * super.getHEIGHT());

		if (super.checkXY(tempX, tempY)) {
			xy[0] = tempX;
			xy[1] = tempY;
		} else {
			xy[0] = -1;
			xy[1] = -1;
		}
		
		return xy;
	}

	public int getCntProduct() {
		return cntProduct;
	}

	public Product[] getProductList() {
		return productList;
	}

	public void setProductList(Product[] productList) {
		this.productList = productList;
	}

	
}
