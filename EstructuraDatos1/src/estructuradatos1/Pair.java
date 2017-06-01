package estructuradatos1;
/**
 * @author Orlando Montoya
 * @author Valeria Castro
 * Esta clase me representa la estructura de datos Pair, 
 * la cual me guarda un conjunto de dos valores.
*/
public class Pair<A, B> {
    private A first;
    private B second;
    
    /**
     * @param first primer elemento.
     * @param second segundo elemento.
     * Constructor de la clase Pair.
     */
    public Pair(A first, B second) {
        super();
        this.first = first;
        this.second = second;
    }
    
    /**
     * Este método me retorna el primer elemento de la pareja.
     * @return primer elemento
     */
    public A getFirst() {
        return first;
    }

    /**
     * Ente método me actualiza el primer elemento de la pareja.
     * @param first 
     */
    public void setFirst(A first) {
        this.first = first;
    }

    /**
     * Este método me retorna el segundo elemento de la pareja.
     * @return primer elemento
     */
    public B getSecond() {
        return second;
    }

    /**
     * Ente método me actualiza el segundo elemento de la pareja.
     * @param second 
     */
    public void setSecond(B second) {
        this.second = second;
    }
}