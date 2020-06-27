package frameChange.controller;

import frameChange.model.vo.GameCenter;
import frameChange.model.vo.Maps;
import frameChange.model.vo.Market;
import frameChange.model.vo.Npc;
import frameChange.model.vo.Player;
import frameChange.model.vo.Town;

public class MapManager {

	private Player player;
	private Maps maps;
//	private Npc npc;

	public MapManager() {
		player = new Player();
	}


	public MapManager(Maps map) {
		
		this();
		
		
		// map의 테이터형에 따라 다운캐스팅 후 초기화
		// 맵 상에서 player의 위치
		// 이미지 크기
		if(map instanceof Town) {
			map = (Town) map;
			player.setX(((Town) map).getUserX());
			player.setY(((Town) map).getUserY());
			
			player.setPlayerNow(player.getPlayerNow().getScaledInstance(50, 50, 0));

			player.setImgPlayerUp(player.getImgPlayerUp().getScaledInstance(50, 50, 0));
			player.setImgPlayerUp1(player.getImgPlayerUp().getScaledInstance(50, 50, 0));
			player.setImgPlayerUp2(player.getImgPlayerUp().getScaledInstance(50, 50, 0));
			
			player.setImgPlayerDown(player.getImgPlayerDown().getScaledInstance(50, 50, 0));
			player.setImgPlayerDown1(player.getImgPlayerDown1().getScaledInstance(50, 50, 0));
			player.setImgPlayerDown2(player.getImgPlayerDown2().getScaledInstance(50, 50, 0));
			
			player.setImgPlayerLeft(player.getImgPlayerLeft().getScaledInstance(50, 50, 0));
			player.setImgPlayerLeft1(player.getImgPlayerLeft1().getScaledInstance(50, 50, 0));
			player.setImgPlayerLeft2(player.getImgPlayerLeft2().getScaledInstance(50, 50, 0));
			
			player.setImgPlayerRight(player.getImgPlayerRight().getScaledInstance(50, 50, 0));
			player.setImgPlayerRight1(player.getImgPlayerRight1().getScaledInstance(50, 50, 0));
			player.setImgPlayerRight2(player.getImgPlayerRight2().getScaledInstance(50, 50, 0));
			
		}

		if(map instanceof Market) {
			map = (Market) map;
			
			player.setX(((Market) map).getUserX());
			player.setY(((Market) map).getUserY());
			
			player.setPlayerNow(player.getPlayerNow().getScaledInstance(100, 100, 0));

			player.setImgPlayerUp(player.getImgPlayerUp().getScaledInstance(100, 100, 0));
			player.setImgPlayerUp1(player.getImgPlayerUp().getScaledInstance(100, 100, 0));
			player.setImgPlayerUp2(player.getImgPlayerUp().getScaledInstance(100, 100, 0));
			
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

		if(map instanceof GameCenter) {
			map = (GameCenter) map;
			
			player.setX(((GameCenter) map).getUserX());
			player.setY(((GameCenter) map).getUserY());
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Maps getMaps() {

		return maps;
	}

	public void setMaps(Maps maps) {

		this.maps = maps;
	}

	
	
}
