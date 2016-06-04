package Chess;

public class PiecePosition {

    /**
     * Esta función devuelve si una posición es válida. Es válida si
     * está dentro de los límites del tablero ( 8 X 8)
     * @params column, row coordenadas de la posición a validar
     * @return true si es valida y false en caso contrario
     */
    public static boolean isAvailable(int column, int row) {
        return column >= 0 && column < 8 && row >= 0 && row < 8;
    }

    /**
     * Esta función valida la posición del nuevo movimiento, el
     * nuevo movimiento parte de la posición actual mas el incremento.
     * Es válida si está dentro de los limites del tablero.
     * @parmam position, la posicón actual de la pieza
     * @params columnIncrment, rowIncrement, incrementos sobre la posición actual
     * @return true si es válida y false en caso contrario
     */
    static boolean isAvailable(PiecePosition position, int columnIncrement, int rowIncrement) {
        if (position == null)
            return false;

        int newColumn = position.getColumn() + columnIncrement;
        int newRow = position.getRow() + rowIncrement;
        return isAvailable(newColumn, newRow);
    }

    /**
     * Esta funcion devuelve si la posición actual de la pieza es válida.
     * Es válida si está dentro de los limites del tablero.
     * @parmam position, la posicón actual de la pieza
     * @return true si es válida y false en caso contrario
     */
    static boolean isAvailable(PiecePosition position) {
        if (position == null)
            return false;
        return isAvailable(position.getColumn(), position.getRow());
    }

    private int column, row;

    /**
     * Constructor, crea la pieza situada en la posición indicada
     * @params column, row, coordenas donde se ubicará la pieza.
     */
    public PiecePosition(int column, int row) {
        this.column = column;
        this.row = row;
    }

    /**
     * Esta función de vuelve la columna actual de la pieza
     */
    public int getColumn() {
        return column;
    }

    /**
     * Esta función devuelve la fila actual de la pieza
     */
    public int getRow() {
        return row;
    }

    /**
     * Esta función cambia la posición actual de la pieza 
     * @params column, row son las coordenadas de la nueva posición
     * @return true si ha podido mover la pieza a una posición valida y false 
     * en caso contrario
     */
    public boolean setValues(int column, int row) {
        if (isAvailable(column, row)) {
                this.column = column;
                this.row = row;			
                return true;
        }
        return false;
    }

    /**
     * Esta función devuelve una nueva posición a partir de la ya existente 
     * más el incremento (movimiento)
     * @params  rowCount, columCount, 
     * @return una nueva posición
     */
    public PiecePosition getDisplacedPiece(int columnCount, int rowCount) {		
        if (!isAvailable(this, columnCount, rowCount))
            return null;
        int newColumn = getColumn() + columnCount;
        int newRow = getRow() + rowCount;
        return new PiecePosition(newColumn, newRow);
    }

    /**
     * Esta función crea una nueva pieza en la posición de la actual
     * se clonan cuando hacemos un movimientos
     * @return una nueva piez
     */
    public PiecePosition clone() {
        return new PiecePosition(column, row);
    }

    /**
     * Esta función indica si dos piezas se encuentran en la misma posición
     * @param posición de la pieza a comparar con la actual
     * @return true si son la misma posición y false en caso contrario
     */
    public boolean equals(PiecePosition aPosition) {
        return aPosition.getColumn() == getColumn() && aPosition.getRow() == getRow();
    }
}
