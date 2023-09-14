package View.subkriteria;

import Config.Database;
import Entity.Kriteria;
import Entity.SubKriteria;
import Repository.KriteriaRepository;
import Repository.KriteriaRepositoryImpl;
import Repository.SubKriteriaRepository;
import Repository.SubKriteriaRepositoryImpl;
import Service.KriteriaService;
import Service.KriteriaServiceImpl;
import Service.SubKriteriaService;
import Service.SubKriteriaServiceImpl;
import static View.subkriteria.TambahSubKriteria.namaToIdMap;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EditSubKriteria extends javax.swing.JFrame {

    private int id;
    private int IdKriteria;
    private String kodeSubKriteria;
    private String namaSubKriteria;
    private String bobotSubKriteria;

    Connection conn = Database.getConnection();

    KriteriaRepository kriteriaRepository = new KriteriaRepositoryImpl(conn);
    KriteriaService kriteriaService = new KriteriaServiceImpl(kriteriaRepository);

    SubKriteriaRepository subKriteriaRepository = new SubKriteriaRepositoryImpl(conn);
    SubKriteriaService subKriteriaService = new SubKriteriaServiceImpl(subKriteriaRepository);

    public EditSubKriteria(int id, int IdKriteria, String kodeSubKriteria, String namaSubKriteria, String bobotSubKriteria) {

        this.id = id;
        this.IdKriteria = IdKriteria;
        this.kodeSubKriteria = kodeSubKriteria;
        this.namaSubKriteria = namaSubKriteria;
        this.bobotSubKriteria = bobotSubKriteria;

        initComponents();

        this.comboboxJK();

        setResizable(false);

        jTextField_KodeSubKriteria.setText(kodeSubKriteria);
        jTextField_NamaSubKriteria.setText(namaSubKriteria);
        jTextField_BobotSubKriteria.setText(bobotSubKriteria);
        jComboBox_SK.setSelectedItem(kriteriaService.namaKriteria(IdKriteria));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void comboboxJK() {

        jComboBox_SK.removeAllItems();

        for (Kriteria kriteria: kriteriaService.showKriteria()) {
            String nama = kriteriaService.namaKriteria(kriteria.getId());
            int id = kriteria.getId();
            jComboBox_SK.addItem(nama);
            namaToIdMap.put(nama, id);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox_SK = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_NamaSubKriteria = new javax.swing.JTextField();
        jTextField_KodeSubKriteria = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton_Hapus = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField_BobotSubKriteria = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dhurjati", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edit Data Sub Kriteria ");

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

        jComboBox_SK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jLabel4.setText("Nama Sub Kritea");

        jLabel3.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jLabel3.setText("Kode Sub Kriteria");

        jLabel2.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jLabel2.setText("Kriteria");

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

        jButton_Hapus.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jButton_Hapus.setText("Hapus");
        jButton_Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HapusActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jLabel5.setText("Bobot Sub Kriteria");

        jButton4.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_KodeSubKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox_SK, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_NamaSubKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_BobotSubKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 195, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_SK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_KodeSubKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_NamaSubKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_BobotSubKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton_Hapus)
                    .addComponent(jButton4))
                .addContainerGap(16, Short.MAX_VALUE))
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
        String namaTerpilih = jComboBox_SK.getSelectedItem().toString();

        // Menggunakan map untuk mendapatkan ID berdasarkan nama
        Integer idTerpilih = namaToIdMap.get(namaTerpilih);

        double bobot = Double.parseDouble(jTextField_BobotSubKriteria.getText());

        SubKriteria subKriteria = new SubKriteria(
                this.id,
                idTerpilih,
                jTextField_KodeSubKriteria.getText(),
                jTextField_NamaSubKriteria.getText(),
                bobot
        );

        // Coba untuk mengedit data Alternatif
        if (subKriteriaService.editSubKriteria(subKriteria)) {
            // Jika berhasil, tampilkan pesan berhasil
            JOptionPane.showMessageDialog(this, "Data berhasil diubah.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            // Tutup window saat berhasil
            this.dispose(); // Tutup window saat ini
        } else {
            // Jika gagal, tampilkan pesan gagal
            JOptionPane.showMessageDialog(this, "Gagal mengubah data.", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HapusActionPerformed

        // Coba untuk mengedit data Alternatif
        if (subKriteriaService.removeSubKriteria(this.id)) {
            // Jika berhasil, tampilkan pesan berhasil
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            // Tutup window saat berhasil
            this.dispose(); // Tutup window saat ini
        } else {
            // Jika gagal, tampilkan pesan gagal
            JOptionPane.showMessageDialog(this, "Gagal menghapus data.", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_HapusActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTextField_KodeSubKriteria.setText("");
        jTextField_NamaSubKriteria.setText("");
        jTextField_BobotSubKriteria.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_Hapus;
    private javax.swing.JComboBox<String> jComboBox_SK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField_BobotSubKriteria;
    private javax.swing.JTextField jTextField_KodeSubKriteria;
    private javax.swing.JTextField jTextField_NamaSubKriteria;
    // End of variables declaration//GEN-END:variables
}