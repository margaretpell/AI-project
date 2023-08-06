import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The Dice class represents a dice used in the sorting algorithms GUI.
 * It allows observers to be notified when the dice is rolled and provides the rolled dice number.
 */
public class Dice {
    private int diceRoll;
    private List<DiceObserver> observers;

    /**
     * Initializes a new instance of the Dice class.
     * Creates an empty list of observers.
     */
    public Dice() {
        observers = new ArrayList<>();
    }

    /**
     * Rolls the dice, generating a random number between 1 and 6 (inclusive).
     * Notifies all observers of the rolled dice number.
     */
    public void roll() {
        Random random = new Random();
        diceRoll = random.nextInt(6) + 1;
        notifyObservers();
    }

    /**
     * Returns the last rolled dice number.
     *
     * @return The last rolled dice number.
     */
    public int getDiceRoll() {
        return diceRoll;
    }

    /**
     * Adds an observer to be notified when the dice is rolled.
     *
     * @param observer The observer to be added.
     */
    public void addObserver(DiceObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers.
     *
     * @param observer The observer to be removed.
     */
    public void removeObserver(DiceObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all observers of the rolled dice number.
     */
    private void notifyObservers() {
        for (DiceObserver observer : observers) {
            observer.update(diceRoll);
        }
    }
}
