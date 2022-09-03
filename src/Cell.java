public class Cell {
    int coordinateX;
    int coordinateY;
    int stepFromStart;

    public Cell(int x, int y, int step) {
        this.coordinateX = x;
        this.coordinateY = y;
        this.stepFromStart = step;
    }

    public Cell copy() {
        return new Cell(this.coordinateX, this.coordinateY, this.stepFromStart);
    }

    @Override
    public String toString() {
        return "(" + (this.coordinateX) + "," + (this.coordinateY) + ") " + (this.stepFromStart);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            return ((Cell) obj).coordinateX == this.coordinateX && ((Cell) obj).coordinateY == this.coordinateY && ((Cell) obj).stepFromStart == this.stepFromStart;
        }
        return false;
    }
}
