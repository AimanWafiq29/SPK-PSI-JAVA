package View.nilai;

import Config.Database;
import Entity.Alternatif;
import Entity.Kriteria;
import Entity.Nilai;
import Entity.SubKriteria;
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
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EditNilai extends javax.swing.JFrame {

    Connection conn = Database.getConnection();

    AlternatifRepository alternatifRepository = new AlternatifRepositoryImpl(conn);
    AlternatifService alternatifService = new AlternatifServiceImpl(alternatifRepository);

    KriteriaRepository kriteriaRepository = new KriteriaRepositoryImpl(conn);
    KriteriaService kriteriaService = new KriteriaServiceImpl(kriteriaRepository);

    SubKriteriaRepository subKriteriaRepository = new SubKriteriaRepositoryImpl(conn);
    SubKriteriaService subKriteriaService = new SubKriteriaServiceImpl(subKriteriaRepository);

    NilaiRepository nilaiRepository = new NilaiRepositoryImpl(conn);
    NilaiService nilaiService = new NilaiServiceImpl(nilaiRepository);

    private Alternatif alternatif;
    private ArrayList<Integer> idNilaiList;

    public EditNilai(Alternatif alternatif, ArrayList<Integer> idNilaiList) {

        this.alternatif = alternatif;
        this.idNilaiList = idNilaiList;

        initComponents();
        setResizable(false);

        System.out.println(idNilaiList);

        jTextField1_Alternatif.setText(alternatif.getNama());

        this.comboboxJK1();
        jComboBox_K1.setSelectedItem(getBobotByNilaiId(idNilaiList.get(0)));

        this.comboboxJK2();
        jComboBox_K2.setSelectedItem(getBobotByNilaiId(idNilaiList.get(1)));

        this.comboboxJK3();
        jComboBox_K3.setSelectedItem(getBobotByNilaiId(idNilaiList.get(2)));

        this.comboboxJK4();
        jComboBox_K4.setSelectedItem(getBobotByNilaiId(idNilaiList.get(3)));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private String getBobotByNilaiId(int nilaiId) {
        ArrayList<Kriteria> kriteriaList = kriteriaService.showKriteria();
        ArrayList<SubKriteria> subKriteriaList = subKriteriaService.showSubKriteria();
        ArrayList<Nilai> nilaiList = nilaiService.showNilai();
        String nama = "";
        for (Nilai nilai : nilaiList) {
            if (nilai.getId() == nilaiId) {
                for (SubKriteria subKriteria : subKriteriaList) {
                    if (subKriteria.getId() == nilai.getId_SubKriteria()) {
                        nama = subKriteria.getNama();
                        break;
                    }
                }
            }
        }
        return nama;
    }

    static Map<String, Integer> k1ToIdMap = new HashMap<>();

    public void comboboxJK1() {

        jComboBox_K1.removeAllItems();

        for (SubKriteria subKriteria : subKriteriaService.showByIdSubKriteria(1)) {
            String nama = subKriteria.getNama();
            int id = subKriteria.getId();
            jComboBox_K1.addItem(nama);
            k1ToIdMap.put(nama, id);
        }

    }

    static Map<String, Integer> k2ToIdMap = new HashMap<>();

    public void comboboxJK2() {

        jComboBox_K2.removeAllItems();

        for (SubKriteria subKriteria : subKriteriaService.showByIdSubKriteria(2)) {
            String nama = subKriteria.getNama();
            int id = subKriteria.getId();
            jComboBox_K2.addItem(nama);
            k2ToIdMap.put(nama, id);
        }
    }

    static Map<String, Integer> k3ToIdMap = new HashMap<>();

    public void comboboxJK3() {

        jComboBox_K3.removeAllItems();

        for (SubKriteria subKriteria : subKriteriaService.showByIdSubKriteria(3)) {
            String nama = subKriteria.getNama();
            int id = subKriteria.getId();
            jComboBox_K3.addItem(nama);
            k3ToIdMap.put(nama, id);
        }
    }

    static Map<String, Integer> k4ToIdMap = new HashMap<>();

    public void comboboxJK4() {

        jComboBox_K4.removeAllItems();

        for (SubKriteria subKriteria : subKriteriaService.showByIdSubKriteria(4)) {
            String nama = subKriteria.getNama();
            int id = subKriteria.getId();
            jComboBox_K4.addItem(nama);
            k4ToIdMap.put(nama, id);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox_K1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1_Alternatif = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_K2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_K3 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_K4 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dhurjati", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edit Data Penilaian ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0)));

        jComboBox_K1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_K1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_K1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jLabel4.setText("Alternatif");

        jButton1.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jButton2.setText("Batal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1_Alternatif.setEditable(false);
        jTextField1_Alternatif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_AlternatifActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jLabel5.setText("K1");

        jLabel6.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jLabel6.setText("K2");

        jComboBox_K2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_K2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_K2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jLabel7.setText("K3");

        jComboBox_K3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_K3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_K3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jLabel8.setText("K4");

        jComboBox_K4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_K4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_K4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 147, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox_K3, 0, 183, Short.MAX_VALUE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox_K4, 0, 183, Short.MAX_VALUE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox_K1, 0, 183, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField1_Alternatif))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_K2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1_Alternatif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox_K1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_K2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_K3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_K4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // Mengambil nama yang terpilih dari JComboBox
        String namaTerpilih1 = jComboBox_K1.getSelectedItem().toString();

        // Menggunakan map untuk mendapatkan ID berdasarkan nama
        Integer idTerpilih1 = k1ToIdMap.get(namaTerpilih1);

        String namaTerpilih2 = jComboBox_K2.getSelectedItem().toString();

        // Menggunakan map untuk mendapatkan ID berdasarkan nama
        Integer idTerpilih2 = k2ToIdMap.get(namaTerpilih2);

        String namaTerpilih3 = jComboBox_K3.getSelectedItem().toString();

        // Menggunakan map untuk mendapatkan ID berdasarkan nama
        Integer idTerpilih3 = k3ToIdMap.get(namaTerpilih3);

        String namaTerpilih4 = jComboBox_K4.getSelectedItem().toString();

        // Menggunakan map untuk mendapatkan ID berdasarkan nama
        Integer idTerpilih4 = k4ToIdMap.get(namaTerpilih4);

        ArrayList<Integer> idsub = new ArrayList<>();
        idsub.add(idTerpilih1);
        idsub.add(idTerpilih2);
        idsub.add(idTerpilih3);
        idsub.add(idTerpilih4);

        for (int i = 0; i < idsub.size(); i++) {
            System.out.println();
            System.out.println("id : " + this.idNilaiList.get(i));
            System.out.println("id Alternatif : " + this.alternatif.getId());
            System.out.println("id kriteria: " + (i+1));
            System.out.println("id sub kriteria: " + idsub.get(i));
            System.out.println("");
        }

        int result = 0;

        for (int i = 0; i < idsub.size(); i++) {
            System.out.println(this.idNilaiList.get(i) + " | " + this.alternatif.getId() + " | " + i + " | " + idsub.get(i));
            Nilai nilai = new Nilai(this.idNilaiList.get(i), this.alternatif.getId(), (i+1), idsub.get(i));
            // Coba untuk mengedit data Alternatif
            if (nilaiService.editNilai(nilai)) {
                result++;
            } else {
                // Jika gagal, tampilkan pesan gagal
                JOptionPane.showMessageDialog(this, "Gagal mengubah data.", "Gagal", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }

        if (result >= idsub.size()) {
            JOptionPane.showMessageDialog(this, "Data berhasil diubah.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            this.dispose(); // Tutup window saat ini
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1_AlternatifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_AlternatifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_AlternatifActionPerformed

    private void jComboBox_K1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_K1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_K1ActionPerformed

    private void jComboBox_K2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_K2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_K2ActionPerformed

    private void jComboBox_K3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_K3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_K3ActionPerformed

    private void jComboBox_K4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_K4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_K4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox_K1;
    private javax.swing.JComboBox<String> jComboBox_K2;
    private javax.swing.JComboBox<String> jComboBox_K3;
    private javax.swing.JComboBox<String> jComboBox_K4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1_Alternatif;
    // End of variables declaration//GEN-END:variables
}
