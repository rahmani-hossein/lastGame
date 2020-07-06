package CLI;

import model.GamePlayer;
import model.Hero;
import model.Minion;
import model.card;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameState {


    private GamePlayer freind;
    private GamePlayer enemy;



    private Player player;
    private boolean startGame=false;
    private Timer timer;
   private boolean turn = false;//false means friend has the turn.
   private int roundManaMax=1;

    public GameState() {

    }

    public int getRoundManaMax() {
        return roundManaMax;
    }

    public void setRoundManaMax(int roundManaMax) {
        this.roundManaMax = roundManaMax;
    }

    public GamePlayer getFreind() {
        return freind;
    }

    public void setFreind(GamePlayer freind) {
        this.freind = freind;
    }

    public GamePlayer getEnemy() {
        return enemy;
    }

    public void setEnemy(GamePlayer enemy) {
        this.enemy = enemy;
    }

    public boolean isStartGame() {
        return startGame;
    }

    public void setStartGame(boolean startGame) {
        this.startGame = startGame;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void updateTime() {
        // mogeh shorou nobate
        timer.scheduleAtFixedRate(new Ticker(), 0, 1000);
    }



    public GameState(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    private class Ticker extends TimerTask {
        int currentTime = 60;

        @Override
        public void run() {
            if (currentTime == 0) {
                turn = !turn;
                updateTime();
                this.cancel();
            }
            currentTime--;
        }
    }
}
