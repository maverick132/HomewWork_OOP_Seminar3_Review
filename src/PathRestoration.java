public class PathRestoration {

    final static int[][] aroundCell = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };
    static int[][] coordinateWay;


    public static String pathRestoration(Field field) {

        coordinateWay = new int[field.getFinalCell().stepFromStart+1][2];
        coordinateWay[0][0] = field.getFinalCell().coordinateX;
        coordinateWay[0][1] = field.getFinalCell().coordinateY;
        int countMatrix = 1;
        StringBuilder wayToStart = new StringBuilder(("(")).append(field.getFinalCell().coordinateX).append(",").append(field.getFinalCell().coordinateY).append(")");

        boolean isWayFind = false;
        boolean isWayCantFound = false;
        Cell cellNow = field.getFinalCell().copy();
        while (!isWayFind && !isWayCantFound) {
            int x = cellNow.coordinateX;
            int y = cellNow.coordinateY;
            int stepNow = cellNow.stepFromStart;
            int count = 0;
            if (stepNow != 0) {
                int minStepAround = stepNow;
                for (int i = 0; i < 8; i++) {
                    if (field.isValidCoordinates(x + aroundCell[i][0], y + aroundCell[i][1])) {
                        if (field.getCell(x + aroundCell[i][0], y + aroundCell[i][1]).stepFromStart + 1 == minStepAround) { //?????????????? ????? ????????? ?????
                            cellNow = field.getCell(x + aroundCell[i][0], y + aroundCell[i][1]).copy();
                            count++;
                            minStepAround = cellNow.stepFromStart;
                        }
                    }

                }
                if (count > 0) {
                    stepNow = cellNow.stepFromStart;
                    coordinateWay[countMatrix][0] = cellNow.coordinateX;
                    coordinateWay[countMatrix][1] = cellNow.coordinateY;
                    countMatrix++;
                    wayToStart.append("(").append(cellNow.coordinateX).append(",").append(cellNow.coordinateY).append(")");
                } else {
                    isWayCantFound = true;
                }
            }
            if (stepNow == 0) {
                isWayFind = true;
            }
        }
        if (isWayFind) {
            printToConsoleWay(field);
            return wayToStart.toString();
        } else {
            return "Way cant found";
        }
    }

    public static void printToConsoleWay(Field field) {
        Field fieldForPrint = fieldWithWay(field);
        int sizeElementsMax = 0;
        for (int i = 0; i < field.sizeHeight; i++) {
            for (int j = 0; j < field.sizeWidth; j++) {
                if (String.valueOf(field.getCell(i, j).stepFromStart).length() > sizeElementsMax) {
                    sizeElementsMax = String.valueOf(field.getCell(i, j).stepFromStart).length();
                }
            }
        }
        StringBuilder space = new StringBuilder();
        space.append(" ".repeat(sizeElementsMax));

        for (int i = 0; i < fieldForPrint.sizeHeight; i++) {
            for (int j = 0; j < fieldForPrint.sizeWidth; j++) {
                if (String.valueOf(fieldForPrint.getCell(i, j).stepFromStart).length() == sizeElementsMax) {
                    if (fieldForPrint.getCell(i, j).stepFromStart == -99) {
                        System.out.print(" ".repeat(sizeElementsMax - 1) + "+" + space);
                    } else {
                        System.out.print(fieldForPrint.getCell(i, j).stepFromStart + space.toString());
                    }
                } else {
                    if (fieldForPrint.getCell(i, j).stepFromStart == -99) {
                        System.out.print(" ".repeat(sizeElementsMax - 1) + "+" + space);
                    } else {
                        System.out.print(" ".repeat(sizeElementsMax - String.valueOf(field.getCell(i, j).stepFromStart).length()) + field.getCell(i, j).stepFromStart + space);
                    }

                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static Field fieldWithWay(Field field) {
        Field fieldResult = new Field(field.sizeHeight, field.sizeWidth);
        for (Cell[] value : field.Field) {
            for (Cell cell : value) {
                for (int[] ints : coordinateWay) {
                    if (ints[0] == cell.coordinateX && ints[1] == cell.coordinateY) {
                        fieldResult.getCell(cell.coordinateX, cell.coordinateY).stepFromStart = -99;
                    } else {
                        if (fieldResult.getCell(cell.coordinateX, cell.coordinateY).stepFromStart != -99) {
                            fieldResult.getCell(cell.coordinateX, cell.coordinateY).stepFromStart = cell.stepFromStart;
                        }
                    }
                }
            }
        }
        return fieldResult;
    }
}
