package frameChange.controller;

import javax.swing.JOptionPane;

import frameChange.model.vo.GameCenter;
import frameChange.model.vo.Maps;
import frameChange.model.vo.Market;
import frameChange.model.vo.Npc;
import frameChange.model.vo.Player;
import frameChange.model.vo.Town;

public class MapManager {

	private ChangePanel win;
	private Maps map;
	private Player player;
	private Npc npc;
	private ProductManager productManager;
	private final int cntProduct = 10;

	public MapManager() {
	}

	public MapManager(ChangePanel win, Maps map, Player player) {

		this.win = win;
		this.map = map;
		this.player = player;

		// map의 테이터형에 따라 다운캐스팅 후 초기화
		// 맵 상에서 player의 위치
		// 이미지 크기
		if (map instanceof Town) {
			// 다운캐스팅
			map = (Town) map;

			// 초기 위치 설정
			player.setX(((Town) map).getUserX());
			player.setY(((Town) map).getUserY());

			// 이미지 크기 설정
			player.setPlayerNow(player.getPlayerNow().getScaledInstance(50, 50, 0));

			player.setImgPlayerUp(player.getImgPlayerUp().getScaledInstance(50, 50, 0));
			player.setImgPlayerUp1(player.getImgPlayerUp1().getScaledInstance(50, 50, 0));
			player.setImgPlayerUp2(player.getImgPlayerUp2().getScaledInstance(50, 50, 0));

			player.setImgPlayerDown(player.getImgPlayerDown().getScaledInstance(50, 50, 0));
			player.setImgPlayerDown1(player.getImgPlayerDown1().getScaledInstance(50, 50, 0));
			player.setImgPlayerDown2(player.getImgPlayerDown2().getScaledInstance(50, 50, 0));

			player.setImgPlayerLeft(player.getImgPlayerLeft().getScaledInstance(50, 50, 0));
			player.setImgPlayerLeft1(player.getImgPlayerLeft1().getScaledInstance(50, 50, 0));
			player.setImgPlayerLeft2(player.getImgPlayerLeft2().getScaledInstance(50, 50, 0));

			player.setImgPlayerRight(player.getImgPlayerRight().getScaledInstance(50, 50, 0));
			player.setImgPlayerRight1(player.getImgPlayerRight1().getScaledInstance(50, 50, 0));
			player.setImgPlayerRight2(player.getImgPlayerRight2().getScaledInstance(50, 50, 0));

			this.npc = new Npc(map, player);

		}

		if (map instanceof Market) {
			// 다운캐스팅
			map = (Market) map;

			// 초기 위치 설정
			player.setX(((Market) map).getUserX());
			player.setY(((Market) map).getUserY());

			// 이미지 크기 재설정
			player.setPlayerNow(player.getPlayerNow().getScaledInstance(100, 100, 0));

			player.setImgPlayerUp(player.getImgPlayerUp().getScaledInstance(100, 100, 0));
			player.setImgPlayerUp1(player.getImgPlayerUp1().getScaledInstance(100, 100, 0));
			player.setImgPlayerUp2(player.getImgPlayerUp2().getScaledInstance(100, 100, 0));

			player.setImgPlayerDown(player.getImgPlayerDown().getScaledInstance(100, 100, 0));
			player.setImgPlayerDown1(player.getImgPlayerDown1().getScaledInstance(100, 100, 0));
			player.setImgPlayerDown2(player.getImgPlayerDown2().getScaledInstance(100, 100, 0));

			player.setImgPlayerLeft(player.getImgPlayerLeft().getScaledInstance(100, 100, 0));
			player.setImgPlayerLeft1(player.getImgPlayerLeft1().getScaledInstance(100, 100, 0));
			player.setImgPlayerLeft2(player.getImgPlayerLeft2().getScaledInstance(100, 100, 0));

			player.setImgPlayerRight(player.getImgPlayerRight().getScaledInstance(100, 100, 0));
			player.setImgPlayerRight1(player.getImgPlayerRight1().getScaledInstance(100, 100, 0));
			player.setImgPlayerRight2(player.getImgPlayerRight2().getScaledInstance(100, 100, 0));

			this.productManager = new ProductManager();

		}

		if (map instanceof GameCenter) {
			// 다운캐스팅
			map = (GameCenter) map;

			// 초기 위치 설정
			player.setX(((GameCenter) map).getUserX());
			player.setY(((GameCenter) map).getUserY());

			// 이미지 크기 재설정
			player.setPlayerNow(player.getPlayerNow().getScaledInstance(100, 100, 0));

			player.setImgPlayerUp(player.getImgPlayerUp().getScaledInstance(100, 100, 0));
			player.setImgPlayerUp1(player.getImgPlayerUp1().getScaledInstance(100, 100, 0));
			player.setImgPlayerUp2(player.getImgPlayerUp2().getScaledInstance(100, 100, 0));

			player.setImgPlayerDown(player.getImgPlayerDown().getScaledInstance(100, 100, 0));
			player.setImgPlayerDown1(player.getImgPlayerDown1().getScaledInstance(100, 100, 0));
			player.setImgPlayerDown2(player.getImgPlayerDown2().getScaledInstance(100, 100, 0));

			player.setImgPlayerLeft(player.getImgPlayerLeft().getScaledInstance(100, 100, 0));
			player.setImgPlayerLeft1(player.getImgPlayerLeft1().getScaledInstance(100, 100, 0));
			player.setImgPlayerLeft2(player.getImgPlayerLeft2().getScaledInstance(100, 100, 0));

			player.setImgPlayerRight(player.getImgPlayerRight().getScaledInstance(100, 100, 0));
			player.setImgPlayerRight1(player.getImgPlayerRight1().getScaledInstance(100, 100, 0));
			player.setImgPlayerRight2(player.getImgPlayerRight2().getScaledInstance(100, 100, 0));
		}
	}

	public Npc getNpc() {
		return npc;
	}

	public void setNpc(Npc npc) {
		this.npc = npc;
	}

	public Maps getMap() {
		return map;
	}

	public void setMap(Maps map) {
		this.map = map;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ProductManager getProductManager() {
		return productManager;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public void moveNextMap(Maps map, Player player, ChangePanel win) {
		this.win = win;

		map.saveLocation(player);

		switch (map.mapChange(player.getX(), player.getY())) {

		case "town":
			map.saveLocation(player);
			if (map instanceof Market) {
				showReceipt((Market) map);
			}
			win.change("town", player);
			break;

		case "market":
			((Town)map).saveLocation(player, npc);
			win.change("market", player);
			break;

		case "gameCenter":
			((Town)map).saveLocation(player, npc);
			win.change("gameCenter", player);
			break;

		default:
			break;
		}
	}

	// 영수증 출력
	public void showReceipt(Market map) {
		// 영수증 다이얼로그 출력

		JOptionPane.showMessageDialog(null, map.totalList(), "영수증", JOptionPane.QUESTION_MESSAGE);

	}

	public void resetProductManager() {
		this.productManager = new ProductManager();
	}

}
