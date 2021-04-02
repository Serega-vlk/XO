import javafx.application.Application;
import javafx.stage.Stage;
import model.Table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    private final Table table;
    private final View view;

    public Controller(){
        this.table = new Table();
        this.view = new View(this);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Controller game = new Controller();
        int move = 2;
        System.out.println("Вводите сначала ряд и колонку вместе.");
        System.out.println("Пример:\na1 или A1");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        while (true) {
            System.out.println("##########################\n" +
                    "##########################\n" +
                    "##########################");
            game.view.refresh();
            game.view.drawTable();
            char winner = game.table.checkWin();
            if (winner != '-' && winner != '/'){
                System.out.println("ИГРА ОКОНЧЕНА\nПобеда -> " + winner);
                break;
            } else if (winner == '/'){
                System.out.println("ИГРА ОКОНЧЕНА\nНИЧЬЯ");
                break;
            }
            System.out.println("Ходит -> " + (move % 2 == 0 ? "X" : "0"));
            char[] s = reader.readLine().toCharArray();
            try {
                int x = s[0] == 'A' || s[0] == 'a' ? 1 : s[0] == 'B' || s[0] == 'b' ? 2 : s[0] == 'C' || s[0] == 'c' ? 3 : 0;
                int y = Integer.parseInt(Character.toString(s[1]));
                if (move % 2 == 0) {
                    game.table.setElem(y, x, 'X');
                } else {
                    game.table.setElem(y, x, '0');
                }
            } catch (IllegalArgumentException e){
                System.out.println("Выбранная клетка недоступна.\nВыберите другую!");
                continue;
            } catch (ArrayIndexOutOfBoundsException ai){
                System.out.println("Неверный формат ввода.\nПовторите ещё раз!");
                continue;
            }
            move++;
        }
    }

    public Table getTable() {
        return table;
    }

    public View getView() {
        return view;
    }
}
