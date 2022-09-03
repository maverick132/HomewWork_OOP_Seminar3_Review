import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Printer   {

    //    static int countFileNum = 1;
    public static void printField(Cell field[][]) {
        int sizeElementsMax = findSizeElementsMax(field);

        StringBuilder space = new StringBuilder();
        space.append(" ".repeat(sizeElementsMax));

        for (Cell[] value : field) {
            for (Cell cell : value) {
                if (String.valueOf(cell.stepFromStart).length() == sizeElementsMax) {
                    System.out.print(cell.stepFromStart + space.toString());
                } else {
                    System.out.print(" ".repeat(sizeElementsMax - String.valueOf(cell.stepFromStart).length()) + cell.stepFromStart + space);
                }
            }
            System.out.println();
        }
        System.out.println();
    }




    public static void printFieldToFile(Cell field[][], int countFileNum) throws IOException {
        File file = new File("log" + countFileNum++ + ".txt");
        FileWriter fileWriter = new FileWriter(file, true);

        int sizeElementsMax = findSizeElementsMax(field);

        StringBuilder space = new StringBuilder();
        space.append(" ".repeat(sizeElementsMax));

        for (Cell[] value : field) {
            for (Cell cell : value) {
                if (String.valueOf(cell.stepFromStart).length() == sizeElementsMax) {
                    fileWriter.write(cell.stepFromStart + space.toString());
                } else {
                    fileWriter.write(" ".repeat(sizeElementsMax - String.valueOf(cell.stepFromStart).length()) + cell.stepFromStart + space);
                }
            }
            fileWriter.write("\n");
        }

        fileWriter.write("\n");
        fileWriter.flush();
        fileWriter.close();


    }

    private static int findSizeElementsMax(Cell field[][]) {
        int sizeElementsMax = 0;
        for (Cell[] value : field) {
            for (Cell cell : value) {
                if (String.valueOf(cell.stepFromStart).length() > sizeElementsMax) {
                    sizeElementsMax = String.valueOf(cell.stepFromStart).length();
                }
            }
        }
        return sizeElementsMax;
    }

}
