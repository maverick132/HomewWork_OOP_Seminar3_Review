public class CellStandart extends ACell{
    public CellStandart(int x, int y, int step) {
        super(x,y,step);
//        this.coordinateX = x;
//        this.coordinateY = y;
//        this.stepFromStart = step;
    }

    @Override
    public String toString() {
        return "(" + (this.coordinateX) + "," + (this.coordinateY) + ") " + (this.stepFromStart);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CellStandart) {
            return ((CellStandart) obj).coordinateX == this.coordinateX && ((CellStandart) obj).coordinateY == this.coordinateY && ((CellStandart) obj).stepFromStart == this.stepFromStart;
        }
        return false;
    }
}
