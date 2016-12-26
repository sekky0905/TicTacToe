import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * コマンドラインとのやりとりを行うクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class Terminal {


    /**
     * コマンドライン上にゲーム番を描くためのメソッド
     */
    public void drawBoard(MOVES[] gameBoard) {


        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + this.changeMovesToStone(gameBoard[0], 1) + " |");
        System.out.print("| " + this.changeMovesToStone(gameBoard[1], 2) + " |");
        System.out.println("| " + this.changeMovesToStone(gameBoard[2], 3) + " |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + this.changeMovesToStone(gameBoard[3], 4) + " |");
        System.out.print("| " + this.changeMovesToStone(gameBoard[4], 5) + " |");
        System.out.println("| " + this.changeMovesToStone(gameBoard[5], 6) + " |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + this.changeMovesToStone(gameBoard[6], 7) + " |");
        System.out.print("| " + this.changeMovesToStone(gameBoard[7], 8) + " |");
        System.out.println("| " + this.changeMovesToStone(gameBoard[8], 9) + " |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

        System.out.println("自分の打ち手を入力するにはゲーム盤上に表示されている数字を入力し、Enterキーを押してください");

    }


    /**
     * MOVESから石の文字に変換するためのメソッド
     *
     * @param moves MOVESのEnumの要素
     * @return 石の文字
     */
    String changeMovesToStone(MOVES moves, int spotNumber) {
        if (moves == MOVES.USER_MOVE) {
            return "○";
        } else if (moves == MOVES.CPU_MOVE) {
            return "×";
        }
        return String.valueOf(spotNumber);

    }

    /**
     * 勝敗結果をコマンドライン上に描くためのメソッド
     *
     * @param result 勝敗結果
     */
    public void drawResult(String result) {
        System.out.println(result);
    }

    /**
     * コマンドラインからの入力を受け取る
     *
     * @return 盤の場所を返す
     * @throws java.io.IOException コンソールからの入力を正常に受けてれませんでした
     */
    public int receiveCommand(MOVES[] gameBoard) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        List<MOVES> gameBoardList = new ArrayList<>();
        IntStream.range(0, 9).forEach(i -> gameBoardList.add(gameBoard[i]));

        if (!(gameBoardList.get(userInput - 1) == MOVES.NO_MOVE)) {
            System.out.println("すでに打ち手が入力されています");
            System.out.println("再度数字を入力してください");
        } else if (userInput > 8) {
            System.out.println("不適切な数字です");
            System.out.println("再度数字を入力してください");
        }

        return userInput - 1;
    }

}
