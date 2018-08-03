package serialize;

import models.Position;
import java.io.Serializable;

/**
 *
 * @author medaimane
 */
public class Identify implements Serializable {

    private static final long serialVersionUID = -6990889123824983381L;
    
    private String nameSession;
    
    private Position position;
    private String typeAlgo;
    private String typemode;
    private boolean playerOrder;
    private int totalNumOfAides = 2;
    private int player1aide = 2;
    private int player2aide = 2;
    

    

    public Identify() {
    }

    public Identify(String nameSession, Position position, String typeAlgo, String typemode, int totalNumOfAides, int player1aide, int player2aide, boolean playerOrder) {
        this.nameSession = nameSession;
        this.position = position;
        this.typeAlgo = typeAlgo;
        this.typemode = typemode;
        this.totalNumOfAides = totalNumOfAides;
        this.player1aide = player1aide;
        this.player2aide = player2aide;
        this.playerOrder = playerOrder;
    }

    public String getNameSession() {
        return nameSession;
    }

    public void setNameSession(String nameSession) {
        this.nameSession = nameSession;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getTypeAlgo() {
        return typeAlgo;
    }

    public void setTypeAlgo(String typeAlgo) {
        this.typeAlgo = typeAlgo;
    }

    public String getTypemode() {
        return typemode;
    }

    public void setTypemode(String typemode) {
        this.typemode = typemode;
    }

    public int getTotalNumOfAides() {
        return totalNumOfAides;
    }

    public void setTotalNumOfAides(int totalNumOfAide) {
        this.totalNumOfAides = totalNumOfAide;
    }

    public int getPlayer1aide() {
        return player1aide;
    }

    public void setPlayer1aide(int player1aide) {
        this.player1aide = player1aide;
    }

    public int getPlayer2aide() {
        return player2aide;
    }

    public void setPlayer2aide(int player2aide) {
        this.player2aide = player2aide;
    }

    public boolean isPlayerOrder() {
        return playerOrder;
    }

    public void setPlayerOrder(boolean playerOrder) {
        this.playerOrder = playerOrder;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Identify [nameSession=" + nameSession + ", position=" + position + ", typeAlgo=" + typeAlgo
				+ ", typemode=" + typemode + ", playerOrder=" + playerOrder + ", totalNumOfAides=" + totalNumOfAides
				+ ", player1aide=" + player1aide + ", player2aide=" + player2aide + "]";
	}

    
    

}
