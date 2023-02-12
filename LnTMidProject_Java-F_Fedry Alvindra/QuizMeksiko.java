import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class QuizMeksiko {

    Scanner input = new Scanner(System.in);
    Vector<String> ids = new Vector<>();
    Vector<String> names = new Vector<>();
    Vector<String> genders = new Vector<>();
    Vector<String> positions = new Vector<>();
    Vector<Integer> salaries = new Vector<>();


    int babangMan = 0;
    int babangSup = 0;
    int babangAd = 0;

    int babangManNo = 3;

    int babangSupNo = 3;

    int babangAdNo = 3;

    public void inputs(){

        String name;
        String gender;
        String position;
        Integer salary;

        String id = "";

        Random rand = new Random();
        for (int i = 0; i < 2; i++){
            id += (char) (rand.nextInt(26) + 'A');
        }

        for (int i = 0; i < 3; i++){
            id += (rand.nextInt(10));
        }
        do {
            System.out.print("Input nama karyawan [>= 3]: ");
            name = input.nextLine();
        }while (name.length() < 3);

        do {
            System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
            gender = input.nextLine();
        }while (!gender.equals("Laki-laki") && !gender.equals("Perempuan"));

        do {
            System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
            position = input.nextLine();
        }while (!position.equals("Manager") && !position.equals("Supervisor") && !position.equals("Admin") );

        if (position.equals("Manager")){
            salary = 8000000;
            babangMan++;

        } else if (position.equals("Supervisor")) {
            salary = 6000000;
            babangSup++;
        } else {
            salary = 4000000;
            babangAd++;
        }

        ids.add(id);
        names.add(name);
        genders.add(gender);
        positions.add(position);
        salaries.add(salary);

        System.out.println("Berhasil menambahkan karyawan dengan id " + id);


        if (babangMan >= babangManNo ){
            for (int i = 0; i < names.size(); i++){
                if (positions.get(i).equals("Manager")){
                    salaries.set(i, salaries.get(i) * 10/100 + salaries.get(i));

                }
            }
            babangManNo = babangManNo + 3;
        } else if (babangSup >= babangSupNo) {
            for (int i = 0; i < names.size(); i++) {
                if (positions.get(i).equals("Supervisor")) {
                    salaries.set(i, salaries.get(i) * 75 / 100 + salaries.get(i));
                }
            }
            babangSupNo += 3;
        } else if (babangAd >= babangAdNo) {
            for (int i = 0; i < names.size(); i++) {
                if (positions.get(i).equals("Admin")) {
                    salaries.set(i, salaries.get(i) * 5 / 100 + salaries.get(i));
                }
            }
            babangAdNo += 3;
        } else {
            System.out.println("Enter to return");
            input.nextLine();
        }

    }

    public void view (){

        if (names.size() == 0){
            System.out.println("Anda belum menginput karyawan!");
        }
        else {
            for (int i = 0; i < names.size(); i++){
                for (int j = 0; j < names.size()-1; j++){
                    if (names.get(j).compareToIgnoreCase(names.get(j+1)) > 0){
                        String tempId = ids.get(j);
                        ids.set(j, ids.get(j+1));
                        ids.set(j+1, tempId);

                        String tempName = names.get(j);
                        names.set(j, names.get(j+1));
                        names.set(j+1, tempName);

                        String tempGender = genders.get(j);
                        genders.set(j, genders.get(j+1));
                        genders.set(j+1, tempGender);

                        String tempPosition = positions.get(j);
                        positions.set(j, positions.get(j+1));
                        positions.set(j+1, tempPosition);

                        Integer tempSalary = salaries.get(j);
                        salaries.set(j, salaries.get(j+1));
                        salaries.set(j+1, tempSalary);
                    }
                }
            }

            int no = 1;
            System.out.printf("%-3s|%-15s|%-32s|%-16s|%-14s|%-19s|\n", "===", "===============", "================================", "================", "==============","===================");
            System.out.printf("%-3s|%-15s|%-32s|%-16s|%-14s|%-19s|\n", "No", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan","Gaji Karyawan");
            System.out.printf("%-3s|%-15s|%-32s|%-16s|%-14s|%-19s|\n", "===", "===============", "================================", "================", "==============","===================");
            for (int i = 0; i< names.size(); i++){
                System.out.printf("%3d|%15s|%32s|%16s|%14s|%19d|\n", no, ids.get(i), names.get(i), genders.get(i), positions.get(i),salaries.get(i));
                no++;
            }

            System.out.printf("%-3s|%-15s|%-32s|%-16s|%-14s|%-19s|\n", "===", "===============", "================================", "================", "==============","===================");
        }
    }

    public void update(){
        view();
        int no;
        do {
            System.out.print("Input nomor urutan karyawan yang ingin diupdate: ");
            no = input.nextInt(); input.nextLine();
        } while (no == 0 || no > names.size());
        no = no -1;

        // input ulang
        String name;
        String gender;
        String position;
        Integer salary;

        do {
            System.out.print("Input nama karyawan [>= 3]: ");
            name = input.nextLine();
        }while (name.length() < 3);

        do {
            System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
            gender = input.nextLine();
        }while (!gender.equals("Laki-laki") && !gender.equals("Perempuan"));

        do {
            System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
            position = input.nextLine();
        }while (!position.equals("Manager") && !position.equals("Supervisor") && !position.equals("Admin") );

        if (position.equals("Manager")){
            salary = 8000000;
            babangMan++;

        } else if (position.equals("Supervisor")) {
            salary = 6000000;
            babangSup++;
        } else {
            salary = 4000000;
            babangAd++;
        }

        if (babangMan >= babangManNo ){
            for (int i = 0; i < names.size(); i++){
                if (positions.get(i).equals("Manager")){
                    salaries.set(i, salaries.get(i) * 10/100 + salaries.get(i));
                }
            }
            babangManNo = babangManNo + 3;
            System.out.println("Berhasil mengupdate karyawan dengan id " + ids.get(no));

            names.set(no,name);
            genders.set(no,gender);
            positions.set(no,position);
            salaries.set(no,salary);
        } else if (babangSup >= babangSupNo) {
            for (int i = 0; i < names.size(); i++) {
                if (positions.get(i).equals("Supervisor")) {
                    salaries.set(i, salaries.get(i) * 75 / 100 + salaries.get(i));
                }
            }
            babangSupNo += 3;
            System.out.println("Berhasil mengupdate karyawan dengan id " + ids.get(no));

            names.set(no,name);
            genders.set(no,gender);
            positions.set(no,position);
            salaries.set(no,salary);
        } else if (babangAd >= babangAdNo) {
            for (int i = 0; i < names.size(); i++) {
                if (positions.get(i).equals("Admin")) {
                    salaries.set(i, salaries.get(i) * 5 / 100 + salaries.get(i));
                }
            }
            babangAdNo += 3;
            System.out.println("Berhasil mengupdate karyawan dengan id " + ids.get(no));

            names.set(no,name);
            genders.set(no,gender);
            positions.set(no,position);
            salaries.set(no,salary);
        } else {
            System.out.println("Berhasil mengupdate karyawan dengan id " + ids.get(no));
            names.set(no,name);
            genders.set(no,gender);
            positions.set(no,position);
            salaries.set(no,salary);
            System.out.println("Enter to return");
            input.nextLine();
        }
    }

    public void delete(){
        view();
        int no;
        do {
            System.out.print("Input nomor urutan karyawan yang ingin didelete: ");
            no = input.nextInt(); input.nextLine();
        } while (no == 0 || no > names.size());
        no = no - 1;

        names.remove(no);
        genders.remove(no);
        positions.remove(no);
        salaries.remove(no);
        ids.remove(no);
    }
}

