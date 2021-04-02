public class View {
    private final char[][] table;
    private final Controller controller;

    public View(Controller controller){
        this.controller = controller;
        table = new char[6][8];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (i == 0 || i == table.length - 2){
                    table[i][j] = '=';
                } else if (j == 1 || j == table[i].length - 1){
                    table[i][j] = '|';
                }
                else {
                    table[i][j] = ' ';
                }
            }
        }
        table[1][0] = 'A';
        table[2][0] = 'B';
        table[3][0] = 'C';
        table[5][2] = '1';
        table[5][4] = '2';
        table[5][6] = '3';
    }

    public void refresh(){
        char[][] gameField = controller.getTable().getGameField();
        int x = 2;
        int y = 1;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                table[y][x] = gameField[i][j];
                x += 2;
            }
            y += 1;
            x = 2;
        }
    }

    public void drawTable(){
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }
}
