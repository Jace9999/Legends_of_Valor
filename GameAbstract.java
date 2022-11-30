/**
 * @Author: Jun Zhu
 * @Date: 11/29/2022 7:43 PM
 * @Description: abstract game class, contains basic processes for a game.
 */
public abstract class GameAbstract {
    abstract void initiate();
    abstract void playGame();

    abstract void heroesRound();

    abstract void monstersRound();
}
