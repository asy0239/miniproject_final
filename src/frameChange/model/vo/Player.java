package frameChange.model.vo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Player {

	private boolean isMoving = false;		// 정지 or 이동
	final int perMove = 10; // 이동단위

	private Image imgPlayerNow, imgPlayerUp, imgPlayerUp1, imgPlayerUp2, imgPlayerDown, imgPlayerDown1, imgPlayerDown2,
			imgPlayerLeft, imgPlayerLeft1, imgPlayerLeft2, imgPlayerRight, imgPlayerRight1, imgPlayerRight2, npcImage;

	private int x, y; // 좌표
	private int status=0; // 이동방향
	private int changeImg = 1; // 왼발, 오른발 모션 변환
	
	
	Thread th;
	Maps maps;
	private int npcX, npcY;
	private int npcPerMove = 10;
	
	public Player() {

		String path = System.getProperty("user.dir") + "\\images\\";

		imgPlayerNow = new ImageIcon(path + "character\\downStand.png").getImage().getScaledInstance(100, 100, 0);

		imgPlayerUp = new ImageIcon(path + "character\\upStand.png").getImage().getScaledInstance(100, 100, 0);
		imgPlayerUp1 = new ImageIcon(path + "character\\upLeft.png").getImage().getScaledInstance(100, 100, 0);
		imgPlayerUp2 = new ImageIcon(path + "character\\upRight.png").getImage().getScaledInstance(100, 100, 0);

		imgPlayerDown = new ImageIcon(path + "character\\downStand.png").getImage().getScaledInstance(100, 100, 0);
		imgPlayerDown1 = new ImageIcon(path + "character\\downLeft.png").getImage().getScaledInstance(100, 100, 0);
		imgPlayerDown2 = new ImageIcon(path + "character\\downRight.png").getImage().getScaledInstance(100, 100, 0);

		imgPlayerLeft = new ImageIcon(path + "character\\leftStand.png").getImage().getScaledInstance(100, 100, 0);
		imgPlayerLeft1 = new ImageIcon(path + "character\\leftLeft.png").getImage().getScaledInstance(100, 100, 0);
		imgPlayerLeft2 = new ImageIcon(path + "character\\leftRight.png").getImage().getScaledInstance(100, 100, 0);

		imgPlayerRight = new ImageIcon(path + "character\\rightStand.png").getImage().getScaledInstance(100, 100, 0);
		imgPlayerRight1 = new ImageIcon(path + "character\\rightLeft.png").getImage().getScaledInstance(100, 100, 0);
		imgPlayerRight2 = new ImageIcon(path + "character\\rightRight.png").getImage().getScaledInstance(100, 100, 0);

		moveImage();
		
	}
	
	// 플레이어의 현재 모습을 반환
	public Image moveImage() {
		
		// 왼발, 오른발 이미지를 바꿔가며 반환
		if (isMoving == true) {

            switch (status) {
            
            case 1:
               if(changeImg == 1) {
                  imgPlayerNow = imgPlayerUp1;
                  changeImg *= -1;
               } else {
                  imgPlayerNow = imgPlayerUp2;
                  changeImg *= -1;
               }
               break;
            case 2:
               if(changeImg == 1) {
                  imgPlayerNow = imgPlayerDown1;
                  changeImg *= -1;                   
               } else {
                  imgPlayerNow = imgPlayerDown2;
                  changeImg *= -1;
               }
               break;
            case 3:
               if(changeImg == 1) {
                  imgPlayerNow = imgPlayerLeft1;
                  changeImg *= -1;
               } else {
                  imgPlayerNow = imgPlayerLeft2;
                  changeImg *= -1;
               }
               break;
            case 4:
               if(changeImg == 1) {
                  imgPlayerNow = imgPlayerRight1;
                  changeImg *= -1;
               } else {
                  imgPlayerNow = imgPlayerRight2;
                  changeImg *= -1;
               }
               break;
            }
            // 서있는 이미지를 반환
         } else {
            switch (status) {
            case 1:
               imgPlayerNow = imgPlayerUp;
               break;
            case 2:
               imgPlayerNow = imgPlayerDown;
               break;
            case 3:
               imgPlayerNow = imgPlayerLeft;
               break;
            case 4:
               imgPlayerNow = imgPlayerRight;
               break;
            }
         }
        return imgPlayerNow;
	}
	
	
	

	public boolean isPlayMove() {
		return isMoving;
	}

	public void setPlayMove(boolean playMove) {
		this.isMoving = playMove;
	}

	public Image getPlayerNow() {
		return imgPlayerNow;
	}

	public void setPlayerNow(Image player) {
		this.imgPlayerNow = player;
	}

	public Image getImgPlayerUp() {
		return imgPlayerUp;
	}

	public void setImgPlayerUp(Image imgPlayerUp) {
		this.imgPlayerUp = imgPlayerUp;
	}

	public Image getImgPlayerUp1() {
		return imgPlayerUp1;
	}

	public void setImgPlayerUp1(Image imgPlayerUp1) {
		this.imgPlayerUp1 = imgPlayerUp1;
	}

	public Image getImgPlayerUp2() {
		return imgPlayerUp2;
	}

	public void setImgPlayerUp2(Image imgPlayerUp2) {
		this.imgPlayerUp2 = imgPlayerUp2;
	}

	public Image getImgPlayerDown() {
		return imgPlayerDown;
	}

	public void setImgPlayerDown(Image imgPlayerDown) {
		this.imgPlayerDown = imgPlayerDown;
	}

	public Image getImgPlayerDown1() {
		return imgPlayerDown1;
	}

	public void setImgPlayerDown1(Image imgPlayerDown1) {
		this.imgPlayerDown1 = imgPlayerDown1;
	}

	public Image getImgPlayerDown2() {
		return imgPlayerDown2;
	}

	public void setImgPlayerDown2(Image imgPlayerDown2) {
		this.imgPlayerDown2 = imgPlayerDown2;
	}

	public Image getImgPlayerLeft() {
		return imgPlayerLeft;
	}

	public void setImgPlayerLeft(Image imgPlayerLeft) {
		this.imgPlayerLeft = imgPlayerLeft;
	}

	public Image getImgPlayerLeft1() {
		return imgPlayerLeft1;
	}

	public void setImgPlayerLeft1(Image imgPlayerLeft1) {
		this.imgPlayerLeft1 = imgPlayerLeft1;
	}

	public Image getImgPlayerLeft2() {
		return imgPlayerLeft2;
	}

	public void setImgPlayerLeft2(Image imgPlayerLeft2) {
		this.imgPlayerLeft2 = imgPlayerLeft2;
	}

	public Image getImgPlayerRight() {
		return imgPlayerRight;
	}

	public void setImgPlayerRight(Image imgPlayerRight) {
		this.imgPlayerRight = imgPlayerRight;
	}

	public Image getImgPlayerRight1() {
		return imgPlayerRight1;
	}

	public void setImgPlayerRight1(Image imgPlayerRight1) {
		this.imgPlayerRight1 = imgPlayerRight1;
	}

	public Image getImgPlayerRight2() {
		return imgPlayerRight2;
	}

	public void setImgPlayerRight2(Image imgPlayerRight2) {
		this.imgPlayerRight2 = imgPlayerRight2;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getChangeImg() {
		return changeImg;
	}

	public void setChangeImg(int changeImg) {
		this.changeImg = changeImg;
	}

	public int getPerMove() {
		return perMove;
	}

	
	
}
