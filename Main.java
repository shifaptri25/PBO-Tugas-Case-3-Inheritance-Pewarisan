import java.util.Scanner;

class Mahasiswa {
    String nim, nama;
    int nilai;
    char grade;

    // Method untuk menentukan grade
    void hitungGrade() {
        if (nilai >= 80 && nilai <= 100) {
            grade = 'A';
        } else if (nilai >= 70) {
            grade = 'B';
        } else if (nilai >= 60) {
            grade = 'C';
        } else if (nilai >= 50) {
            grade = 'D';
        } else if (nilai >= 0) {
            grade = 'E';
        } else {
            grade = 'X'; // nilai salah
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int jumlah = 4;
        Mahasiswa[] mhs = new Mahasiswa[jumlah];

        int totalNilai = 0;
        int lulus = 0, tidakLulus = 0;
        int gradeA = 0, gradeB = 0, gradeD = 0;

        for (int i = 0; i < jumlah; i++) {
            mhs[i] = new Mahasiswa();

            System.out.println("Data Mahasiswa ke-" + (i+1));

            System.out.print("NIM  : ");
            mhs[i].nim = input.nextLine();

            System.out.print("Nama : ");
            mhs[i].nama = input.nextLine();

            System.out.print("Nilai: ");
            mhs[i].nilai = input.nextInt();
            input.nextLine();

            if (mhs[i].nilai < 0 || mhs[i].nilai > 100) {
                System.out.println("Input nilai anda salah");
                continue;
            }

            mhs[i].hitungGrade();
            totalNilai += mhs[i].nilai;

            // Hitung lulus/tidak
            if (mhs[i].grade == 'A' || mhs[i].grade == 'B' || mhs[i].grade == 'C') {
                lulus++;
            } else {
                tidakLulus++;
            }

            // Hitung per grade
            if (mhs[i].grade == 'A') gradeA++;
            if (mhs[i].grade == 'B') gradeB++;
            if (mhs[i].grade == 'D') gradeD++;

            System.out.println();
        }

        // OUTPUT
        System.out.println("\n===== HASIL =====");
        for (int i = 0; i < jumlah; i++) {
            if (mhs[i] == null) continue;

            System.out.println("NIM   : " + mhs[i].nim);
            System.out.println("Nama  : " + mhs[i].nama);
            System.out.println("Nilai : " + mhs[i].nilai);
            System.out.println("Grade : " + mhs[i].grade);
            System.out.println("----------------------------------");
        }

        double rata = (double) totalNilai / jumlah;

        System.out.println("Jumlah Mahasiswa : " + jumlah);
        System.out.println("Jumlah Mahasiswa yg Lulus : " + lulus);
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus : " + tidakLulus);
        System.out.println("Jumlah Mahasiswa dengan Nilai A : " + gradeA);
        System.out.println("Jumlah Mahasiswa dengan Nilai B : " + gradeB);
        System.out.println("Jumlah Mahasiswa dengan Nilai D : " + gradeD);
        System.out.println("Rata-rata nilai mahasiswa : " + rata);
    }
}