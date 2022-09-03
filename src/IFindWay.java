import java.io.IOException;

public interface IFindWay {
    public void findWay(Field field) throws IOException;
    public void fillCellAround(Field field, Cell cell);
}
