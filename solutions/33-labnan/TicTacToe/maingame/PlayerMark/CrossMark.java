package maingame.PlayerMark;

public class CrossMark implements PlayerMark{
  private PlayerMarkEnum type = PlayerMarkEnum.CROSS;

    public PlayerMarkEnum getType() {
        return type;
    }
}
