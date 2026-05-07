package manuscript;

/**
 * Das Movie Interface ist die fachliche Repräsentation der Geschichte.
 * Es definiert den Lebenszyklus und die Abfolge der Inszenierung.
 */
public interface Movie {

    /** Startet die Vorführung und befüllt die Filmrolle. */  
    void start();

    /** Spielt alle geladenen Szenen nacheinander ab. */  
    void nextScene();  
}