

public class ClientUpdatePacket {
	private int PosX;
	private int PosY;
	private String Username;
	public ClientUpdatePacket(int posX, int posY, String username) {
		
		PosX = posX;
		PosY = posY;
		Username = username;
	}
	public int getPosX() {
		return PosX;
	}
	public int getPosY() {
		return PosY;
	}
	public void setUsername(String username) {
		Username = username;
	}

}
