import java.io.IOException;
import java.util.Iterator;

public class Field {
    int sizeWidth;
    int sizeHeight;
    int size;
    Cell[][] Field;
    Cell startCell;
    Cell finalCell;

    public Field(int sizeHeight, int sizeWidth) {
        this.sizeHeight = sizeHeight;
        this.sizeWidth = sizeWidth;
        this.size = sizeHeight * sizeWidth;
        this.Field = new Cell[sizeHeight][sizeWidth];
        for (int i = 0; i < sizeHeight; i++) {
            for (int j = 0; j < sizeWidth; j++) {
                Cell cell = new Cell(i, j, -1);
                this.Field[i][j] = cell;
            }
        }
        System.out.printf("Field %d x %d created.\n", sizeHeight, sizeWidth);
    }

    public boolean isValidCoordinates(int coordinateX, int coordinateY) {
        return coordinateX >= 0 && coordinateX < this.sizeHeight && coordinateY >= 0 && coordinateY < this.sizeWidth;
    }

    public void setCell(int coordinateX, int coordinateY, int step) {
        if (isValidCoordinates(coordinateX, coordinateY)) {
            this.Field[coordinateX][coordinateY].stepFromStart = step;
        }
    }

    public void setStartCell(int coordinateX, int coordinateY) {
        this.startCell = this.getCell(coordinateX, coordinateY);
        this.startCell.stepFromStart = 0;
    }

    public void setFinalCell(int coordinateX, int coordinateY) {
        this.finalCell = this.getCell(coordinateX, coordinateY);
        this.finalCell.stepFromStart = -2;
    }

    public Cell getFinalCell() {
        return finalCell;
    }

    public Cell getCell(int coordinateX, int coordinateY) {
        return this.Field[coordinateX][coordinateY];
    }


    public Cell[][] getField() {
        return this.Field;
    }

    public void FindWay(FindWayMoore findWay) throws IOException {
        findWay.findWay(this);
    }
    public void FindWay(FindWayNeumann findWay) throws IOException {
        findWay.findWay(this);
    }


}
