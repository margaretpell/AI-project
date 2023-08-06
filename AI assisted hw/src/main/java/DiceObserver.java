/**
 * The DiceObserver interface provides an update method that is called when the dice is rolled.
 * Classes implementing this interface can observe the dice and respond to dice roll events.
 */
public interface DiceObserver {
    /**
     * Called when the dice is rolled, providing the dice roll number.
     *
     * @param diceRoll The number rolled on the dice.
     */
    void update(int diceRoll);
}
