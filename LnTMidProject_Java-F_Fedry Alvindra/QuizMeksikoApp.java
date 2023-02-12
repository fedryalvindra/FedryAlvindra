import java.util.Scanner;

public class QuizMeksikoApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choose;
        QuizMeksiko meksiko = new QuizMeksiko();
        while (true){
            do {
                System.out.println("1. input karyawan");
                System.out.println("2. view karyawan");
                System.out.println("3. update karyawan");
                System.out.println("4. delete karyawan");
                System.out.println("5. exit");
                System.out.print(">> ");
                choose = input.nextInt(); input.nextLine();
            }while (choose != 1 && choose != 2 && choose != 3 && choose != 4 && choose != 5);

            if (choose == 1){
                meksiko.inputs();
            } else if (choose == 2) {
                meksiko.view();
            } else if (choose == 3) {
                meksiko.update();
            } else if (choose == 4) {
                meksiko.delete();
            } else {
                break;
            }
        }
    }
}
