import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        ArrayList<Integer> squares = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            squares.add(i * i);
        }

        while (squares.size() > 0) {
            System.out.print(squares.remove(squares.size() - 1) + " ");
        }
    }
}
