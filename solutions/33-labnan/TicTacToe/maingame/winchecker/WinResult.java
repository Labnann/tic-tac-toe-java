package maingame.winchecker;

import maingame.LineType;
import maingame.PlayerMarkEnum;

public class WinResult{

    private int winAt;
    private LineType lineType;
    private PlayerMarkEnum winner;
    public WinResult(int winAt, LineType lineType, PlayerMarkEnum winner) {
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

    public PlayerMarkEnum getWinner() {
        return winner;
    }
}
