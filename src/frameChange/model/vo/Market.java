package frameChange.model.vo;

import javax.swing.ImageIcon;

public class Market extends Maps {
	private int userX = 850; // 초기화 할 player의 x 좌표. 최초값: 인스턴스 생성 시 최초 위치
	private int userY = 120; // 초기화 할 player의 y 좌표. 최조값: 인스턴스 생성 시 최초 위치
	private Product[] buyList = new Product[8];
	private String buyString = "";
	private int totalPrice = 0;
	private int[] tempCnt = new int[8];

	public Market() {
		String path = System.getProperty("user.dir") + "\\images\\";

		// "town.png"
		super.setImgBackground(new ImageIcon(path + "bg\\market.png").getImage());
		setXY();

		this.setTitle("market");

	}

	// 맵마다 이동 가능한 위치의 location 값을 true로 변경
	@Override
	public void setXY() {

		// 카운터 위
		for (int i = 520; i <= 740; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 40; j <= 50; j++) { // 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}

		// 카운터 복도
		for (int i = 740; i <= 740; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 40; j <= 90; j++) { // 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}

		// 우상단
		for (int i = 740; i <= 910; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 90; j <= 190; j++) { // 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}
		// 좌상단
		for (int i = 70; i <= 290; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 120; j <= 210; j++) { // 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}

		// 좌상단 복도
		for (int i = 290; i <= 430; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 190; j < 230; j++) { // 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}

		// 중앙
		for (int i = 430; i <= 820; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 190; j <= 410; j++) { // 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}

		// 하단
		for (int i = 30; i <= 840; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 410; j <= 580; j++) { // 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}

	}

	public int getUserX() {
		return userX;
	}

	public void setUserX(int userX) {
		this.userX = userX;
	}

	public int getUserY() {
		return userY;
	}

	public void setUserY(int userY) {
		this.userY = userY;
	}

	public String getBuyString() {
		return buyString;
	}

	public void setBuyString(String buyString) {
		this.buyString = buyString;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int[] getTempCnt() {
		return tempCnt;
	}

	public void setTempCnt(int[] tempCnt) {
		this.tempCnt = tempCnt;
	}

	// Player가 위치한 x,y 좌표를 매개변수로 받아
	// 이동 가능한 좌표인지 판단하여 boolean 값으로 반환
	@Override
	public boolean checkXY(int x, int y) {

		return this.outputLocation(x, y);
	}

	@Override
	public String mapChange(int x, int y) {
		if ((x >= 900) && (y >= 90 && y <= 200)) {
			return "town";
		} else {
			return "";
		}
	}

	@Override
	public void saveLocation(Player player) {
		this.userX = player.getX();
		this.userY = player.getY();

		this.buyString = "";
	}

	public void collectItems(Player player, Product[] productList) {

		for (int i = 0; i < productList.length; i++) {
			// 범위값으로 좌표 비교
			if (player.getX() >= productList[i].getX() - 50 && player.getX() <= productList[i].getX() &&

					player.getY() >= productList[i].getY() - 70 && player.getY() <= productList[i].getY()) {

				if (productList[i].isChecked() == false ) {

					// 제품별 개수 확인하여 buyList에 저장
					switch (productList[i].getName()) {

					case "쓰레기":
						System.out.println(productList[i].getName() + " " + productList[i].getPrice());
						buyList[0] = new Product(productList[i].getName(), productList[i].getPrice());
						buyList[0].setCnt(buyList[0].getCnt() + 1);
						break;

					case "바나나":
						buyList[1] = new Product(productList[i].getName(), productList[i].getPrice());
						buyList[1].setCnt(buyList[1].getCnt() + 1);
						break;

					case "포도":
						buyList[2] = new Product(productList[i].getName(), productList[i].getPrice());
						buyList[2].setCnt(buyList[2].getCnt() + 1);
						break;

					case "생선":
						buyList[3] = new Product(productList[i].getName(), productList[i].getPrice());
						buyList[3].setCnt(buyList[3].getCnt() + 1);
						break;

					case "수박":
						buyList[4] = new Product(productList[i].getName(), productList[i].getPrice());
						buyList[4].setCnt(buyList[4].getCnt() + 1);
						break;

					case "목걸이":
						buyList[5] = new Product(productList[i].getName(), productList[i].getPrice());
						buyList[5].setCnt(buyList[5].getCnt() + 1);
						break;

					case "책":
						buyList[6] = new Product(productList[i].getName(), productList[i].getPrice());
						buyList[6].setCnt(buyList[6].getCnt() + 1);
						break;

					case "신발":
						buyList[7] = new Product(productList[i].getName(), productList[i].getPrice());
						buyList[7].setCnt(buyList[7].getCnt() + 1);
						break;
					}

					productList[i].setChecked(true);
				}
			}
		}

	}

	public String totalList() {
		// 매 영수증마다 리셋
		this.totalPrice = 0;
		this.buyString = "";
		
		for (int i = 0; i < tempCnt.length; i++) {

			if (buyList[i] != null && buyList[i].getCnt() > 0) {
				totalPrice += buyList[i].getPrice();
				buyString += (buyList[i].toString() + buyList[i].getCnt() + "개\n");
				System.out.println(buyString);
			}
		}

		buyString += "====================\n합계: " + totalPrice + "원\n";

		return buyString;
	}
}
