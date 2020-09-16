package maingame.winchecker;

import maingame.LineType;
import maingame.PlayerMark.PlayerMark;

public class WinResult{

    private int winAt;
    private LineType lineType;
    private PlayerMark winner;
    public WinResult(int winAt, LineType lineType, PlayerMark winner) {
        this.winAt = winAt;
        this.lineType = lineType;
        this.winner = winner;
    }

    public int getWinAt() {
        return winAt;
    }

    public LineType getLineType() {
        return lineType;
    }

    public PlayerMark getWinner() {
        return winner;
    }
}
