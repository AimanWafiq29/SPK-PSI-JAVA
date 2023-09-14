package View;

import Config.Database;
import Entity.Alternatif;
import Entity.Kriteria;
import Entity.Nilai;
import Entity.PSI;
import Entity.SubKriteria;
import java.sql.Connection;
import java.util.ArrayList;
import Repository.AlternatifRepository;
import Repository.AlternatifRepositoryImpl;
import Repository.KriteriaRepository;
import Repository.KriteriaRepositoryImpl;
import Repository.NilaiRepository;
import Repository.NilaiRepositoryImpl;
import Repository.SubKriteriaRepository;
import Repository.SubKriteriaRepositoryImpl;
import Service.AlternatifService;
import Service.AlternatifServiceImpl;
import Service.KriteriaService;
import Service.KriteriaServiceImpl;
import Service.NilaiService;
import Service.NilaiServiceImpl;
import Service.SubKriteriaService;
import Service.SubKriteriaServiceImpl;

public class index {

    public static void main(String[] args) {

        Connection conn = Database.getConnection();

        AlternatifRepository alternatifRepository = new AlternatifRepositoryImpl(conn);
        AlternatifService alternatifService = new AlternatifServiceImpl(alternatifRepository);

        KriteriaRepository kriteriaRepository = new KriteriaRepositoryImpl(conn);
        KriteriaService kriteriaService = new KriteriaServiceImpl(kriteriaRepository);

        SubKriteriaRepository subKriteriaRepository = new SubKriteriaRepositoryImpl(conn);
        SubKriteriaService subKriteriaService = new SubKriteriaServiceImpl(subKriteriaRepository);

        NilaiRepository nilaiRepository = new NilaiRepositoryImpl(conn);
        NilaiService nilaiService = new NilaiServiceImpl(nilaiRepository);

        ArrayList<Alternatif> alternatifList = alternatifService.showAlternatif();
        ArrayList<Kriteria> kriteriaList = kriteriaService.showKriteria();
        ArrayList<SubKriteria> subKriteriaList = subKriteriaService.showSubKriteria();
        ArrayList<Nilai> nilaiList = nilaiService.showNilai();

        ArrayList<PSI> matriksKeputusanList = matriksKeputusan(alternatifList, kriteriaList, subKriteriaList, nilaiList);
        double[] totalMatriksKeputusan = hitungTotalTiapKriteria(matriksKeputusanList);
        double[][] MinMax = MinMax(alternatifList, kriteriaList, subKriteriaList, nilaiList);
        ArrayList<PSI> normalisasiNilaiMatriksList = normalisasiNilaiMatriks(alternatifList, kriteriaList, subKriteriaList, nilaiList, MinMax);
        double[] nilaiRataRata = averageNormalisasiNilaiMatriks(alternatifList, kriteriaList, subKriteriaList, nilaiList, MinMax);
        ArrayList<PSI> nilaiVariasiPreferensiList = nilaiVariasiPreferensi(alternatifList, kriteriaList, subKriteriaList, nilaiList, MinMax, nilaiRataRata);
        double[] totalNilaiVariasiPreferensi = hitungTotalTiapKriteria(nilaiVariasiPreferensiList);
        double[] hitungNilaiPreferensi = hitungNilaiPreferensi(totalNilaiVariasiPreferensi);
        double totalNilaiDalamPreferensi = totalNilaiDalamPreferensi(totalNilaiVariasiPreferensi);
        double[] menentukanBobotKriteria = menentukanBobotKriteria(totalNilaiVariasiPreferensi, totalNilaiDalamPreferensi);
        ArrayList<PSI> menghitungNilaiPreferensi = menghitungNilaiPreferensi(alternatifList, kriteriaList, subKriteriaList, nilaiList, MinMax, menentukanBobotKriteria);

        // Menampilkan matriks keputusan
        System.out.println("Matriks Keputusan:");
        for (PSI psi : matriksKeputusanList) {
            System.out.print(psi.getAlternatif() + ": ");
            for (double nilai : psi.getBobotKriteria()) {
                System.out.print(nilai + " ");
            }
            System.out.println();
        }

        System.out.println("");
        // Menampilkan total tiap kriteria
        System.out.println("Total Tiap Kriteria:");
        for (int i = 0; i < totalMatriksKeputusan.length; i++) {
            System.out.println("Kriteria " + (i + 1) + ": " + totalMatriksKeputusan[i]);
        }

        // Menampilkan MinMax
        System.out.println("\nMinMax:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < MinMax[i].length; j++) {
                System.out.print(MinMax[i][j] + " ");
            }
            System.out.println();
        }

        // Menampilkan normalisasi nilai matriks
        System.out.println("\nNormalisasi Nilai Matriks:");
        for (PSI psi : normalisasiNilaiMatriksList) {
            System.out.print(psi.getAlternatif() + ": ");
            for (double nilai : psi.getBobotKriteria()) {
                System.out.print(nilai + " ");
            }
            System.out.println();
        }

        System.out.println("\nNilai Rata-Rata:");
        for (int j = 0; j < kriteriaList.size(); j++) {
            System.out.println(kriteriaList.get(j).getNama() + ": " + nilaiRataRata[j]);
        }

        // Menampilkan normalisasi nilai matriks
        System.out.println("\nnilai Variasi PreferensiList:");
        for (PSI psi : nilaiVariasiPreferensiList) {
            System.out.print(psi.getAlternatif() + ": ");
            for (double nilai : psi.getBobotKriteria()) {
                System.out.print(nilai + " ");
            }
            System.out.println();
        }

        System.out.println("");
        // Menampilkan total tiap kriteria
        System.out.println("Menentukan Nilai Dalam Preferensi :");
        for (int i = 0; i < totalNilaiVariasiPreferensi.length; i++) {
            System.out.println("Kriteria " + (i + 1) + ": " + totalNilaiVariasiPreferensi[i]);
        }

        System.out.print("∑𝛺𝑗 = ");
        System.out.println(totalNilaiDalamPreferensi);

        System.out.println("");
        // Menampilkan nilai preferensi
        System.out.println("Menentukan Bobot Kriteria:");
        for (int i = 0; i < hitungNilaiPreferensi.length; i++) {
            System.out.println("𝛺" + (i + 1) + " = " + hitungNilaiPreferensi[i]);
        }

        System.out.println("");
        // Menampilkan nilai preferensi
        System.out.println("Nilai Preferensi:");
        for (int i = 0; i < menentukanBobotKriteria.length; i++) {
            System.out.println("W" + (i + 1) + " = " + menentukanBobotKriteria[i]);
        }

        // Menampilkan normalisasi nilai matriks
        System.out.println("\nmenghitungNilaiPreferensi:");
        for (PSI psi : menghitungNilaiPreferensi) {
            System.out.print(psi.getAlternatif() + ": ");
            double total = 0;
            for (double nilai : psi.getBobotKriteria()) {
                System.out.print(nilai + " ");

                total += nilai;
            }
            System.out.println(" = " + total);
        }

    }

    static ArrayList<PSI> matriksKeputusanAsli(
            ArrayList<Alternatif> alternatifList,
            ArrayList<Kriteria> kriteriaList,
            ArrayList<SubKriteria> subKriteriaList,
            ArrayList<Nilai> nilaiList
    ) {
        ArrayList<PSI> matriksKeputusan = new ArrayList<>();
        for (int i = 0; i < alternatifList.size(); i++) {
            int index = 0;
            Alternatif alternatif = alternatifList.get(i);
            String[] kriteriaNilai = new String[kriteriaList.size()];
            for (Kriteria kriteria : kriteriaList) {
                double nilaiSubKriteria = 0.0;
                for (Nilai nilai : nilaiList) {
                    if (nilai.getId_Alternatif() == alternatif.getId() && nilai.getId_Kriteria() == kriteria.getId()) {
                        for (SubKriteria subKriteria : subKriteriaList) {
                            if (subKriteria.getId() == nilai.getId_SubKriteria()) {
                                kriteriaNilai[index] = subKriteria.getNama();
                                index++;
                                break;
                            }
                        }
                    }
                }
            }
            PSI psi = new PSI(alternatif.getNama(), kriteriaNilai);
            matriksKeputusan.add(psi);
        }

        return matriksKeputusan;

    }

    static ArrayList<PSI> matriksKeputusan(
            ArrayList<Alternatif> alternatifList,
            ArrayList<Kriteria> kriteriaList,
            ArrayList<SubKriteria> subKriteriaList,
            ArrayList<Nilai> nilaiList
    ) {
        ArrayList<PSI> matriksKeputusan = new ArrayList<>();
        for (int i = 0; i < alternatifList.size(); i++) {
            int index = 0;
            Alternatif alternatif = alternatifList.get(i);
            double[] kriteriaNilai = new double[kriteriaList.size()];
            for (Kriteria kriteria : kriteriaList) {
                double nilaiSubKriteria = 0.0;
                for (Nilai nilai : nilaiList) {
                    if (nilai.getId_Alternatif() == alternatif.getId() && nilai.getId_Kriteria() == kriteria.getId()) {
                        for (SubKriteria subKriteria : subKriteriaList) {
                            if (subKriteria.getId() == nilai.getId_SubKriteria()) {
                                nilaiSubKriteria += subKriteria.getBobot();
                                kriteriaNilai[index] = nilaiSubKriteria;
                                index++;
                                break;
                            }
                        }
                    }
                }
            }
            PSI psi = new PSI(alternatif.getNama(), kriteriaNilai);
            matriksKeputusan.add(psi);
        }

        return matriksKeputusan;

    }

    static double[][] MinMax(
            ArrayList<Alternatif> alternatifList,
            ArrayList<Kriteria> kriteriaList,
            ArrayList<SubKriteria> subKriteriaList,
            ArrayList<Nilai> nilaiList
    ) {
        double[][] MinMax = new double[2][kriteriaList.size()];

        // Menginisialisasi nilai maksimum (Max) dan minimum (Min) awal
        for (int j = 0; j < kriteriaList.size(); j++) {
            MinMax[0][j] = Double.MIN_VALUE;
            MinMax[1][j] = Double.MAX_VALUE;
        }

        // Menghitung nilai maksimum (Max) dan minimum (Min) untuk setiap kriteria
        for (int j = 0; j < kriteriaList.size(); j++) {
            for (Alternatif alternatif : alternatifList) {
                double nilaiSubKriteria = 0.0;
                for (Nilai nilai : nilaiList) {
                    if (nilai.getId_Alternatif() == alternatif.getId() && nilai.getId_Kriteria() == kriteriaList.get(j).getId()) {
                        for (SubKriteria subKriteria : subKriteriaList) {
                            if (subKriteria.getId() == nilai.getId_SubKriteria()) {
                                nilaiSubKriteria += subKriteria.getBobot();
                                break;
                            }
                        }
                    }
                }
                // Memperbarui nilai maksimum (Max) dan minimum (Min) jika diperlukan
                if (nilaiSubKriteria > MinMax[0][j]) {
                    MinMax[0][j] = nilaiSubKriteria;
                }
                if (nilaiSubKriteria < MinMax[1][j]) {
                    MinMax[1][j] = nilaiSubKriteria;
                }
            }
        }

        return MinMax;
    }

    static ArrayList<PSI> normalisasiNilaiMatriks(
            ArrayList<Alternatif> alternatifList,
            ArrayList<Kriteria> kriteriaList,
            ArrayList<SubKriteria> subKriteriaList,
            ArrayList<Nilai> nilaiList,
            double[][] MinMax
    ) {
        ArrayList<PSI> normalisasiNilaiMatriks = new ArrayList<>();
        for (int i = 0; i < alternatifList.size(); i++) {
            int index = 0;
            System.out.println("Alternatif" + i);
            Alternatif alternatif = alternatifList.get(i);
            double[] kriteriaNilai = new double[kriteriaList.size()];
            for (int j = 0; j < kriteriaList.size(); j++) {
                for (Nilai nilai : nilaiList) {
                    if (nilai.getId_Alternatif() == alternatif.getId() && nilai.getId_Kriteria() == kriteriaList.get(j).getId()) {
                        for (SubKriteria subKriteria : subKriteriaList) {
                            if (subKriteria.getId() == nilai.getId_SubKriteria()) {
                                if (kriteriaList.get(j).getJenis().equals("Benefit")) {
                                    double max = subKriteria.getBobot() / MinMax[0][j];
                                    System.out.print("K" + i + " : " + subKriteria.getBobot() + " / " + MinMax[0][j]);
                                    kriteriaNilai[index] = max;
                                    System.out.println(max);
                                    index++;
                                } else {
                                    double min = MinMax[1][j] / subKriteria.getBobot();
                                    kriteriaNilai[index] = min;
                                    index++;
                                }
                                break;
                            }
                        }
                    }
                }
            }
            normalisasiNilaiMatriks.add(new PSI(alternatif.getNama(), kriteriaNilai));
        }
        return normalisasiNilaiMatriks;
    }

    static double[] averageNormalisasiNilaiMatriks(
            ArrayList<Alternatif> alternatifList,
            ArrayList<Kriteria> kriteriaList,
            ArrayList<SubKriteria> subKriteriaList,
            ArrayList<Nilai> nilaiList,
            double[][] MinMax
    ) {
        // Menghitung nilai rata-rata dari nilai normalisasi
        double[] nilaiRataRata = new double[kriteriaList.size()];
        for (int j = 0; j < kriteriaList.size(); j++) {
            double totalNilai = 0.0;
            for (int i = 0; i < alternatifList.size(); i++) {
                Alternatif alternatif = alternatifList.get(i);
                double nilaiSubKriteria = 0.0;
                for (Nilai nilai : nilaiList) {
                    if (nilai.getId_Alternatif() == alternatif.getId() && nilai.getId_Kriteria() == kriteriaList.get(j).getId()) {
                        for (SubKriteria subKriteria : subKriteriaList) {
                            if (subKriteria.getId() == nilai.getId_SubKriteria()) {
                                if (kriteriaList.get(j).getJenis().equals("Benefit")) {
                                    double max = subKriteria.getBobot() / MinMax[0][j];
                                    nilaiSubKriteria += max;
                                } else {
                                    double min = MinMax[1][j] / subKriteria.getBobot();
                                    nilaiSubKriteria += min;
                                }
                                break;
                            }
                        }
                    }
                }
                totalNilai += nilaiSubKriteria;
            }

            nilaiRataRata[j] = 1.0 / (alternatifList.size() * totalNilai);
        }
        return nilaiRataRata;
    }

    static ArrayList<PSI> nilaiVariasiPreferensi(
            ArrayList<Alternatif> alternatifList,
            ArrayList<Kriteria> kriteriaList,
            ArrayList<SubKriteria> subKriteriaList,
            ArrayList<Nilai> nilaiList,
            double[][] MinMax,
            double[] nilaiRataRata
    ) {
        System.out.println("");
        ArrayList<PSI> nilaiVariasiPreferensi = new ArrayList<>();
        for (int i = 0; i < alternatifList.size(); i++) {
            Alternatif alternatif = alternatifList.get(i);
            double[] kriteriaNilai = new double[kriteriaList.size()];
            for (int j = 0; j < kriteriaList.size(); j++) {
                for (Nilai nilai : nilaiList) {
                    if (nilai.getId_Alternatif() == alternatif.getId() && nilai.getId_Kriteria() == kriteriaList.get(j).getId()) {
                        for (SubKriteria subKriteria : subKriteriaList) {
                            if (subKriteria.getId() == nilai.getId_SubKriteria()) {
                                if (kriteriaList.get(j).getJenis().equals("Benefit")) {
                                    double max = subKriteria.getBobot() / MinMax[0][j];
                                    kriteriaNilai[j] = Math.pow(max - nilaiRataRata[j], 2);
                                    System.out.println("K" + (j + 1) + " (" + max + " - " + nilaiRataRata[j] + ")^2" + " = " + Math.pow(max - nilaiRataRata[j], 2));
                                } else {
                                    double min = MinMax[1][j] / subKriteria.getBobot();
                                    kriteriaNilai[j] = Math.pow(nilaiRataRata[j] - min, 2);
                                }
                                break;
                            }
                        }
                    }
                }
            }
            PSI psi = new PSI(alternatif.getNama(), kriteriaNilai);
            System.out.println("");
            nilaiVariasiPreferensi.add(psi);
        }
        return nilaiVariasiPreferensi;
    }

// Fungsi untuk menghitung total tiap kriteria dari hasil normalisasi nilai matriks
    static double[] hitungTotalTiapKriteria(ArrayList<PSI> normalisasiNilaiMatriks) {
        int jumlahKriteria = normalisasiNilaiMatriks.get(0).getBobotKriteria().length;
        double[] totalTiapKriteria = new double[jumlahKriteria];

        // Inisialisasi totalTiapKriteria dengan nilai awal 0
        for (int i = 0; i < jumlahKriteria; i++) {
            totalTiapKriteria[i] = 0.0;
        }

        // Menghitung total tiap kriteria
        for (PSI psi : normalisasiNilaiMatriks) {
            double[] kriteriaNilai = psi.getBobotKriteria();
            for (int i = 0; i < jumlahKriteria; i++) {
                totalTiapKriteria[i] += kriteriaNilai[i];
                System.out.println(totalTiapKriteria[i] + " + ");
            }
        }

        return totalTiapKriteria;
    }

    static double totalNilaiDalamPreferensi(double[] totalVariasiPreferensi) {
        int jumlahKriteria = totalVariasiPreferensi.length;
        double[] nilaiPreferensi = new double[jumlahKriteria];
        double total = 0;
        // Menghitung nilai preferensi
        for (int i = 0; i < jumlahKriteria; i++) {
            nilaiPreferensi[i] = 1 - totalVariasiPreferensi[i];
            total += nilaiPreferensi[i];
        }
        return total;
    }

    // Fungsi untuk menghitung nilai preferensi
    static double[] hitungNilaiPreferensi(double[] totalVariasiPreferensi) {
        int jumlahKriteria = totalVariasiPreferensi.length;
        double[] nilaiPreferensi = new double[jumlahKriteria];
        double total = 0;
        // Menghitung nilai preferensi
        for (int i = 0; i < jumlahKriteria; i++) {
            nilaiPreferensi[i] = 1 - totalVariasiPreferensi[i];
            total += nilaiPreferensi[i];
            System.out.println(nilaiPreferensi[i] + " + ");
        }
        System.out.println(total);
        System.out.println("");
        return nilaiPreferensi;
    }

    static double hitungTotalNilaiPreferensi(double[] totalVariasiPreferensi) {
        int jumlahKriteria = totalVariasiPreferensi.length;
        double totalnilaiPreferensi = 0;

        // Menghitung nilai preferensi
        for (int i = 0; i < jumlahKriteria; i++) {
            totalnilaiPreferensi += totalVariasiPreferensi[i];
        }
        return totalnilaiPreferensi;
    }

    static double[] menentukanBobotKriteria(double[] totalVariasiPreferensi, double hitungTotalNilaiPreferensi) {
        int jumlahKriteria = totalVariasiPreferensi.length;
        double[] nilaiPreferensi = new double[jumlahKriteria];
        System.out.println(hitungTotalNilaiPreferensi);
        // Menghitung nilai preferensi
        for (int i = 0; i < jumlahKriteria; i++) {
            nilaiPreferensi[i] = totalVariasiPreferensi[i] / hitungTotalNilaiPreferensi;
        }

        return nilaiPreferensi;
    }

    static ArrayList<PSI> menghitungNilaiPreferensi(
            ArrayList<Alternatif> alternatifList,
            ArrayList<Kriteria> kriteriaList,
            ArrayList<SubKriteria> subKriteriaList,
            ArrayList<Nilai> nilaiList,
            double[][] MinMax,
            double[] menentukanBobotKriteria
    ) {
        ArrayList<PSI> menghitungNilaiPreferensi = new ArrayList<>();
        for (int i = 0; i < alternatifList.size(); i++) {
            int index = 0;
            Alternatif alternatif = alternatifList.get(i);
            double[] kriteriaNilai = new double[kriteriaList.size()];
            for (int j = 0; j < kriteriaList.size(); j++) {
                for (Nilai nilai : nilaiList) {
                    if (nilai.getId_Alternatif() == alternatif.getId() && nilai.getId_Kriteria() == kriteriaList.get(j).getId()) {
                        for (SubKriteria subKriteria : subKriteriaList) {
                            if (subKriteria.getId() == nilai.getId_SubKriteria()) {
                                if (kriteriaList.get(j).getJenis().equals("Benefit")) {
                                    double max = subKriteria.getBobot() / MinMax[0][j];
                                    kriteriaNilai[index] = max * menentukanBobotKriteria[j];
                                    System.out.println("K" + (j + 1) + " " + max + " * " + menentukanBobotKriteria[j] + " = " + kriteriaNilai[index]);
                                    index++;
                                } else {
                                    double min = MinMax[1][j] / subKriteria.getBobot();
                                    kriteriaNilai[index] = min * menentukanBobotKriteria[j];
                                    index++;
                                }
                                break;
                            }
                        }
                    }
                }
            }
            menghitungNilaiPreferensi.add(new PSI(alternatif.getNama(), kriteriaNilai));
        }
        return menghitungNilaiPreferensi;
    }

    static double hitungTotalNilaiPreferensi1(ArrayList<PSI> totalVariasiPreferensi) {
        int jumlahKriteria = totalVariasiPreferensi.size();
        double total = 0;

        // Menghitung nilai preferensi
        for (int i = 0; i < jumlahKriteria; i++) {
            for (int j = 0; j < 4; j++) {
                total += totalVariasiPreferensi.get(i).getBobotKriteria(j);
            }
        }

        return total;
    }
}
