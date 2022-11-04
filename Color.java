/**
 * @author esaddler3
 * @version 1.0
 * An enum representing possible colors of both rubber ducks and hair.
 */
public enum Color {
    RED, GREEN, BLUE, YELLOW, MAGENTA, CYAN, BLACK, DARKGRAY, LIGHTGRAY, BROWN, BLONDE, WHITE;
    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}