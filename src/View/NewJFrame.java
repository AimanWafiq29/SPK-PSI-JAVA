package View;

import Config.Database;
import Entity.Alternatif;
import Entity.HasilAkhir;
import Entity.Kriteria;
import Entity.Nilai;
import Entity.PSI;
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
import View.alternatif.EditAlternatif;
import View.alternatif.TambahAlternatif;
import static View.index.MinMax;
import static View.index.averageNormalisasiNilaiMatriks;
import static View.index.hitungNilaiPreferensi;
import static View.index.hitungTotalNilaiPreferensi;
import static View.index.hitungTotalTiapKriteria;
import static View.index.matriksKeputusan;
import static View.index.matriksKeputusanAsli;
import static View.index.menentukanBobotKriteria;
import static View.index.menghitungNilaiPreferensi;
import static View.index.nilaiVariasiPreferensi;
import static View.index.normalisasiNilaiMatriks;
import static View.index.totalNilaiDalamPreferensi;
import View.kriteria.EditKriteria;
import View.nilai.EditNilai;
import View.subkriteria.EditSubKriteria;
import View.subkriteria.TambahSubKriteria;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class NewJFrame extends javax.swing.JFrame {

    Connection conn = Database.getConnection();

    AlternatifRepository alternatifRepository = new AlternatifRepositoryImpl(conn);
    AlternatifService alternatifService = new AlternatifServiceImpl(alternatifRepository);

    KriteriaRepository kriteriaRepository = new KriteriaRepositoryImpl(conn);
    KriteriaService kriteriaService = new KriteriaServiceImpl(kriteriaRepository);

    SubKriteriaRepository subKriteriaRepository = new SubKriteriaRepositoryImpl(conn);
    SubKriteriaService subKriteriaService = new SubKriteriaServiceImpl(subKriteriaRepository);

    NilaiRepository nilaiRepository = new NilaiRepositoryImpl(conn);
    NilaiService nilaiService = new NilaiServiceImpl(nilaiRepository);

    public NewJFrame() {
        initComponents();
        this.showAlternatif();
        this.showkriteria();
        this.showSubKriteria();
        this.showNilai();
        this.showMatiksKeputusanAsli();
    }

    private void tutupFrame() {
        this.dispose(); // Menutup frame TambahAlternatif
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton_TambahAlternatif1 = new javax.swing.JButton();
        jButton_RefreshAlternatif = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAlternatif = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_Kriteria = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton_Refreshkriteria = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jButton_TambahKriteria1 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_SubKriteria = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton_Refreshkriteria1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_Penilaian = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cont = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_Perhitungan = new javax.swing.JTable();
        Hasil = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));

        jLabel1.setFont(new java.awt.Font("Dhurjati", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SPK");

        jLabel2.setFont(new java.awt.Font("Dhurjati", 3, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(".");

        jLabel3.setFont(new java.awt.Font("Dhurjati", 3, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PREFERENCE SELECTION INDEX");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(153, 0, 0));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Dhurjati", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Selamat Datang");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(102, 102, 102))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(105, 105, 105))
        );

        jTabbedPane1.addTab("Home", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        jPanel5.setBackground(new java.awt.Color(153, 0, 0));

        jLabel5.setFont(new java.awt.Font("Dhurjati", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Data Alternatif");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        jButton_TambahAlternatif1.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jButton_TambahAlternatif1.setText("Tambah");
        jButton_TambahAlternatif1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_TambahAlternatif1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TambahAlternatif1ActionPerformed(evt);
            }
        });

        jButton_RefreshAlternatif.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jButton_RefreshAlternatif.setText("Rehresh");
        jButton_RefreshAlternatif.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_RefreshAlternatif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RefreshAlternatifActionPerformed(evt);
            }
        });

        jTableAlternatif.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableAlternatif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAlternatifMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableAlternatif);

        jLabel6.setFont(new java.awt.Font("Dhurjati", 3, 15)); // NOI18N
        jLabel6.setText("Menampilkan Data");

        jLabel7.setFont(new java.awt.Font("Dhurjati", 3, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("*Klik Data Pada Table Untuk Mengedit Dan Menghapus Data");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(164, 164, 164)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton_TambahAlternatif1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_RefreshAlternatif)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_RefreshAlternatif)
                    .addComponent(jButton_TambahAlternatif1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Alternatif", jPanel4);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        jPanel11.setBackground(new java.awt.Color(153, 0, 0));

        jLabel11.setFont(new java.awt.Font("Dhurjati", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Data Kriteria");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        jTable_Kriteria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_Kriteria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_KriteriaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable_Kriteria);

        jLabel12.setFont(new java.awt.Font("Dhurjati", 3, 15)); // NOI18N
        jLabel12.setText("Menampilkan Data");

        jLabel13.setFont(new java.awt.Font("Dhurjati", 3, 15)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("*Klik Data Pada Table Untuk Mengedit Dan Menghapus Data");

        jButton_Refreshkriteria.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jButton_Refreshkriteria.setText("Refresh");
        jButton_Refreshkriteria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Refreshkriteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RefreshkriteriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(164, 164, 164)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jButton_Refreshkriteria)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Refreshkriteria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kriteria", jPanel10);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        jPanel16.setBackground(new java.awt.Color(153, 0, 0));

        jLabel15.setFont(new java.awt.Font("Dhurjati", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Data Sub Kriteria");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        jButton_TambahKriteria1.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jButton_TambahKriteria1.setText("Tambah");
        jButton_TambahKriteria1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_TambahKriteria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TambahKriteria1ActionPerformed(evt);
            }
        });

        jTable_SubKriteria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_SubKriteria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_SubKriteriaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable_SubKriteria);

        jLabel16.setFont(new java.awt.Font("Dhurjati", 3, 15)); // NOI18N
        jLabel16.setText("Menampilkan Data");

        jLabel17.setFont(new java.awt.Font("Dhurjati", 3, 15)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("*Klik Data Pada Table Untuk Mengedit Dan Menghapus Data");

        jButton_Refreshkriteria1.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jButton_Refreshkriteria1.setText("Refresh");
        jButton_Refreshkriteria1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Refreshkriteria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Refreshkriteria1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jButton_TambahKriteria1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Refreshkriteria1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(164, 164, 164)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_TambahKriteria1)
                    .addComponent(jButton_Refreshkriteria1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sub Kriteria", jPanel15);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        jPanel8.setBackground(new java.awt.Color(153, 0, 0));

        jLabel8.setFont(new java.awt.Font("Dhurjati", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Data Nilai");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        jButton2.setFont(new java.awt.Font("Dhurjati", 1, 15)); // NOI18N
        jButton2.setText("Refresh");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable_Penilaian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_Penilaian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_PenilaianMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_Penilaian);

        jLabel9.setFont(new java.awt.Font("Dhurjati", 3, 15)); // NOI18N
        jLabel9.setText("Menampilkan Data");

        jLabel10.setFont(new java.awt.Font("Dhurjati", 3, 15)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("*Klik Data Pada Table Untuk Mengedit Dan Menghapus Data");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(164, 164, 164)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Penilaian", jPanel7);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        jPanel14.setBackground(new java.awt.Color(153, 0, 0));

        jLabel14.setFont(new java.awt.Font("Dhurjati", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Perhitungan PSI");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cont.setBackground(new java.awt.Color(255, 255, 255));
        cont.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        jTable_Perhitungan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_PerhitunganMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable_Perhitungan);

        javax.swing.GroupLayout contLayout = new javax.swing.GroupLayout(cont);
        cont.setLayout(contLayout);
        contLayout.setHorizontalGroup(
            contLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                    .addGroup(contLayout.createSequentialGroup()
                        .addComponent(Hasil)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        contLayout.setVerticalGroup(
            contLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Hasil)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jButton5.setText("Data Asli ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Matriks Keputusan");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Normalisasi Nilai Matriks");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Nilai Variasi Preferensi");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Hasil Akhir");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Nilai Preferensi");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cont, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Perhitungan", jPanel13);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void showAlternatif() {

        ArrayList<Alternatif> alternatifList = alternatifService.showAlternatif();

        DefaultTableModel DftTblModel_Alternatif = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Mengembalikan false untuk semua kolom sehingga tidak dapat diedit
                return false;
            }
        };

        DftTblModel_Alternatif.addColumn("No");
        DftTblModel_Alternatif.addColumn("Kode Alternatif");
        DftTblModel_Alternatif.addColumn("Nama Alternatif");
        DftTblModel_Alternatif.addColumn("id Alternatif");

        jTableAlternatif.setModel(DftTblModel_Alternatif);

        int nomor = 1; // Digunakan untuk nomor urut
        for (Alternatif alternatif : alternatifList) {
            Object[] rowData = new Object[]{
                nomor,
                alternatif.getKode(), // Gantilah dengan getter yang sesuai
                alternatif.getNama(), // Gantilah dengan getter yang sesuai
                alternatif.getId() // Ambil ID Kriteria langsung dari objek Kriteria
            };

            DftTblModel_Alternatif.addRow(rowData);
            nomor++; // Increment nomor urut
        }

        // Menyembunyikan kolom "id Kriteria" (kolom 4)
        TableColumnModel columnModel = jTableAlternatif.getColumnModel();
        columnModel.getColumn(3).setMinWidth(0);
        columnModel.getColumn(3).setMaxWidth(0);
        columnModel.getColumn(3).setWidth(0);
    }

    public void showkriteria() {
        ArrayList<Kriteria> kriteriaList = kriteriaService.showKriteria();

        DefaultTableModel DftTblModel_kriteria = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Mengembalikan false untuk semua kolom sehingga tidak dapat diedit
                return false;
            }
        };

        DftTblModel_kriteria.addColumn("No");
        DftTblModel_kriteria.addColumn("Kode Kriteria");
        DftTblModel_kriteria.addColumn("Nama Kriteria");
        DftTblModel_kriteria.addColumn("jenis Kriteria");
        DftTblModel_kriteria.addColumn("id Kriteria");

        jTable_Kriteria.setModel(DftTblModel_kriteria);

        int nomor = 1; // Digunakan untuk nomor urut
        for (Kriteria kriteria : kriteriaList) {
            Object[] rowData = new Object[]{
                nomor,
                kriteria.getKode(), // Gantilah dengan getter yang sesuai
                kriteria.getNama(), // Gantilah dengan getter yang sesuai
                kriteria.getJenis(), // Gantilah dengan getter yang sesuai
                kriteria.getId() // Ambil ID Kriteria langsung dari objek Kriteria
            };

            DftTblModel_kriteria.addRow(rowData);
            nomor++; // Increment nomor urut
        }

        // Menyembunyikan kolom "id Kriteria" (kolom 4)
        TableColumnModel columnModel = jTable_Kriteria.getColumnModel();
        columnModel.getColumn(4).setMinWidth(0);
        columnModel.getColumn(4).setMaxWidth(0);
        columnModel.getColumn(4).setWidth(0);
    }

    public void showSubKriteria() {
        ArrayList<SubKriteria> subKriteriaList = subKriteriaService.showSubKriteria();

        DefaultTableModel DftTblModel_SubKriteria = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Mengembalikan false untuk semua kolom sehingga tidak dapat diedit
                return false;
            }
        };

        DftTblModel_SubKriteria.addColumn("No");
        DftTblModel_SubKriteria.addColumn("Kriteria");
        DftTblModel_SubKriteria.addColumn("Kode SubKriteria");
        DftTblModel_SubKriteria.addColumn("Nama SubKriteria");
        DftTblModel_SubKriteria.addColumn("Bobot SubKriteria");
        DftTblModel_SubKriteria.addColumn("id Kriteria"); // Kolom baru untuk ID Kriteria
        DftTblModel_SubKriteria.addColumn("id SubKriteria");

        jTable_SubKriteria.setModel(DftTblModel_SubKriteria);

        int nomor = 1; // Digunakan untuk nomor urut
        for (SubKriteria subKriteria : subKriteriaList) {
            Object[] rowData = new Object[]{
                nomor,
                kriteriaService.namaKriteria(subKriteria.getId_kriteria()), // Gantilah dengan getter yang sesuai
                subKriteria.getKode(), // Gantilah dengan getter yang sesuai
                subKriteria.getNama(), // Gantilah dengan getter yang sesuai
                subKriteria.getBobot(), // Gantilah dengan getter yang sesuai
                subKriteria.getId_kriteria(),
                subKriteria.getId()
            };

            DftTblModel_SubKriteria.addRow(rowData);
            nomor++; // Increment nomor urut
        }

        // Menyembunyikan kolom "id Kriteria" (kolom indeks 5) dan "id SubKriteria" (kolom indeks 6)
        jTable_SubKriteria.getColumnModel().getColumn(5).setMinWidth(0);
        jTable_SubKriteria.getColumnModel().getColumn(5).setMaxWidth(0);
        jTable_SubKriteria.getColumnModel().getColumn(5).setWidth(0);

        jTable_SubKriteria.getColumnModel().getColumn(6).setMinWidth(0);
        jTable_SubKriteria.getColumnModel().getColumn(6).setMaxWidth(0);
        jTable_SubKriteria.getColumnModel().getColumn(6).setWidth(0);
    }

    public void showNilai() {
        ArrayList<Alternatif> alternatifList = alternatifService.showAlternatif();
        ArrayList<Kriteria> kriteriaList = kriteriaService.showKriteria();
        ArrayList<SubKriteria> subKriteriaList = subKriteriaService.showSubKriteria();
        ArrayList<Nilai> nilaiList = nilaiService.showNilai();

        DefaultTableModel DftTblModel_Nilai = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Mengembalikan false untuk semua kolom sehingga tidak dapat diedit
                return false;
            }
        };

        DftTblModel_Nilai.addColumn("No");
        DftTblModel_Nilai.addColumn("Alternatif");

        for (int i = 0; i < kriteriaList.size(); i++) {
            DftTblModel_Nilai.addColumn("K" + (i + 1));
            DftTblModel_Nilai.addColumn("idnilai" + (i + 1));
        }

        jTable_Penilaian.setModel(DftTblModel_Nilai);

        int nomor = 1; // Digunakan untuk nomor urut

        // Mengisi model tabel dengan data
        for (int i = 0; i < alternatifList.size(); i++) {
            Alternatif alternatif = alternatifList.get(i);
            Object[] rowData = new Object[(kriteriaList.size() * 2) + 2]; // Jumlah kolom = jumlah kriteria * 2 + 2 (No dan Nama Alternatif)
            rowData[0] = i + 1; // Nomor
            rowData[1] = alternatif.getNama(); // Nama Alternatif

            for (int j = 0; j < kriteriaList.size(); j++) {
                double nilaiSubKriteria = 0.0;
                int id = 0;
                for (Nilai nilai : nilaiList) {
                    if (nilai.getId_Alternatif() == alternatif.getId() && nilai.getId_Kriteria() == kriteriaList.get(j).getId()) {
                        for (SubKriteria subKriteria : subKriteriaList) {
                            if (subKriteria.getId() == nilai.getId_SubKriteria()) {
                                nilaiSubKriteria += subKriteria.getBobot();
                                id = nilai.getId();
                                break;
                            }
                        }
                    }
                }
                System.out.println(id);
                rowData[j * 2 + 2] = nilaiSubKriteria; // Menyimpan nilai kriteria dalam kolom yang sesuai
                rowData[j * 2 + 3] = id; // Menyimpan id nilai kriteria dalam kolom yang sesuai

                // Menyembunyikan kolom "idnilai"
                jTable_Penilaian.getColumnModel().getColumn(j * 2 + 3).setMinWidth(0);
                jTable_Penilaian.getColumnModel().getColumn(j * 2 + 3).setMaxWidth(0);
                jTable_Penilaian.getColumnModel().getColumn(j * 2 + 3).setWidth(0);
            }

            DftTblModel_Nilai.addRow(rowData); // Menambahkan baris data ke dalam model tabel
            System.out.println("");
        }
    }

    public void showMatiksKeputusanAsli() {

        ArrayList<Alternatif> alternatifList = alternatifService.showAlternatif();
        ArrayList<Kriteria> kriteriaList = kriteriaService.showKriteria();
        ArrayList<SubKriteria> subKriteriaList = subKriteriaService.showSubKriteria();
        ArrayList<Nilai> nilaiList = nilaiService.showNilai();

        ArrayList<PSI> matriksKeputusanList = matriksKeputusanAsli(alternatifList, kriteriaList, subKriteriaList, nilaiList);

        DefaultTableModel DftTblModel_perhitungan = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Mengembalikan false untuk semua kolom sehingga tidak dapat diedit
                return false;
            }
        };

        DftTblModel_perhitungan.addColumn("No");
        DftTblModel_perhitungan.addColumn("Alternatif");
        for (int i = 0; i < kriteriaList.size(); i++) {
            DftTblModel_perhitungan.addColumn("K" + (i + 1) + "(" + kriteriaList.get(i).getNama() + ")"
            );
        }

        jTable_Perhitungan.setModel(DftTblModel_perhitungan);

        int nomor = 1; // Digunakan untuk nomor urut

        for (PSI psi : matriksKeputusanList) {
            Object[] rowData = new Object[kriteriaList.size() + 3];
            rowData[0] = nomor;
            rowData[1] = psi.getAlternatif();
            String[] kriteriaNilai = psi.getNamaKriteria();
            for (int i = 0; i < kriteriaList.size(); i++) {
                rowData[i + 2] = kriteriaNilai[i];
            }

            DftTblModel_perhitungan.addRow(rowData); // Add this line to add the row to the table model
            nomor++;
        }
    }

    public void showMatiksKeputusan() {

        ArrayList<Alternatif> alternatifList = alternatifService.showAlternatif();
        ArrayList<Kriteria> kriteriaList = kriteriaService.showKriteria();
        ArrayList<SubKriteria> subKriteriaList = subKriteriaService.showSubKriteria();
        ArrayList<Nilai> nilaiList = nilaiService.showNilai();
        ArrayList<PSI> matriksKeputusanList = matriksKeputusan(alternatifList, kriteriaList, subKriteriaList, nilaiList);

        double[][] MinMax = MinMax(alternatifList, kriteriaList, subKriteriaList, nilaiList);

        DefaultTableModel DftTblModel_perhitungan = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Mengembalikan false untuk semua kolom sehingga tidak dapat diedit
                return false;
            }
        };

        DftTblModel_perhitungan.addColumn("No");
        DftTblModel_perhitungan.addColumn("Alternatif");
        for (int i = 0; i < kriteriaList.size(); i++) {
            DftTblModel_perhitungan.addColumn("K" + (i + 1) + "( " + kriteriaList.get(i).getNama() + ")"
            );
        }

        jTable_Perhitungan.setModel(DftTblModel_perhitungan);

        int nomor = 1; // Digunakan untuk nomor urut

        for (int i = 0; i < matriksKeputusanList.size(); i++) {
            PSI psi = matriksKeputusanList.get(i);
            Object[] rowData = new Object[kriteriaList.size() + 4];
            rowData[0] = nomor;
            rowData[1] = psi.getAlternatif();
            double[] kriteriaNilai = psi.getBobotKriteria();
            for (int j = 0; j < kriteriaList.size(); j++) {
                rowData[j + 2] = kriteriaNilai[j];
            }
            DftTblModel_perhitungan.addRow(rowData);
            nomor++;
        }

        // Add "MIN" row
        Object[] minRowData = new Object[kriteriaList.size() + 4];
        minRowData[1] = "MIN"; // Min 

        for (int i = 0; i < MinMax[0].length; i++) {
            minRowData[i + 2] = MinMax[1][i]; // Min 
        }

        DftTblModel_perhitungan.addRow(minRowData);

        // Add "MAX" row
        Object[] maxRowData = new Object[kriteriaList.size() + 4];
        maxRowData[1] = "MAX"; // Max 

        for (int i = 0; i < MinMax[1].length; i++) {
            maxRowData[i + 2] = MinMax[0][i]; // Max 
        }

        DftTblModel_perhitungan.addRow(maxRowData);
    }

    public void showNormalisasiNilaiMatriks() {

        ArrayList<Alternatif> alternatifList = alternatifService.showAlternatif();
        ArrayList<Kriteria> kriteriaList = kriteriaService.showKriteria();
        ArrayList<SubKriteria> subKriteriaList = subKriteriaService.showSubKriteria();
        ArrayList<Nilai> nilaiList = nilaiService.showNilai();

        ArrayList<PSI> matriksKeputusanList = matriksKeputusan(alternatifList, kriteriaList, subKriteriaList, nilaiList);
        double[][] MinMax = MinMax(alternatifList, kriteriaList, subKriteriaList, nilaiList);
        ArrayList<PSI> normalisasiNilaiMatriksList = normalisasiNilaiMatriks(alternatifList, kriteriaList, subKriteriaList, nilaiList, MinMax);
        double[] totalMatriksKeputusan = hitungTotalTiapKriteria(normalisasiNilaiMatriksList);

        DefaultTableModel DftTblModel_perhitungan = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Mengembalikan false untuk semua kolom sehingga tidak dapat diedit
                return false;
            }
        };

        DftTblModel_perhitungan.addColumn("No");
        DftTblModel_perhitungan.addColumn("Alternatif");
        for (int i = 0; i < kriteriaList.size(); i++) {
            DftTblModel_perhitungan.addColumn("K" + (i + 1) + " ( " + kriteriaList.get(i).getNama() + ")");
        }

        jTable_Perhitungan.setModel(DftTblModel_perhitungan);

        int nomor = 1; // Digunakan untuk nomor urut

        for (int i = 0; i < normalisasiNilaiMatriksList.size(); i++) {
            PSI psi = normalisasiNilaiMatriksList.get(i);
            Object[] rowData = new Object[kriteriaList.size() + 4];
            rowData[0] = nomor;
            rowData[1] = psi.getAlternatif();
            double[] kriteriaNilai = psi.getBobotKriteria();
            for (int j = 0; j < kriteriaList.size(); j++) {
                rowData[j + 2] = kriteriaNilai[j];
            }
            DftTblModel_perhitungan.addRow(rowData);
            nomor++;
        }

        // Add "MIN" row
        Object[] minRowData = new Object[kriteriaList.size() + 4];
        minRowData[1] = "Total";

        for (int i = 0; i < totalMatriksKeputusan.length; i++) {
            minRowData[i + 2] = totalMatriksKeputusan[i]; // Min 
        }

        DftTblModel_perhitungan.addRow(minRowData);

    }

    public void showNilaiVariasiPreferensi() {

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

        DefaultTableModel DftTblModel_perhitungan = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Mengembalikan false untuk semua kolom sehingga tidak dapat diedit
                return false;
            }
        };

        DftTblModel_perhitungan.addColumn("No");
        DftTblModel_perhitungan.addColumn("Alternatif");
        for (int i = 0; i < kriteriaList.size(); i++) {
            DftTblModel_perhitungan.addColumn("K" + (i + 1));
        }

        jTable_Perhitungan.setModel(DftTblModel_perhitungan);

        int nomor = 1; // Digunakan untuk nomor urut

        for (int i = 0; i < nilaiVariasiPreferensiList.size(); i++) {
            PSI psi = nilaiVariasiPreferensiList.get(i);
            Object[] rowData = new Object[kriteriaList.size() + 4];
            rowData[0] = nomor;
            rowData[1] = psi.getAlternatif();
            double[] kriteriaNilai = psi.getBobotKriteria();
            for (int j = 0; j < kriteriaList.size(); j++) {
                rowData[j + 2] = kriteriaNilai[j];
            }
            DftTblModel_perhitungan.addRow(rowData);
            nomor++;
        }

        // Add "MIN" row
        Object[] minRowData = new Object[kriteriaList.size() + 4];
        minRowData[1] = "∅";

        for (int i = 0; i < totalNilaiVariasiPreferensi.length; i++) {
            minRowData[i + 2] = totalNilaiVariasiPreferensi[i]; // Min 
        }

        DftTblModel_perhitungan.addRow(minRowData);

    }

    public void showNilaiPreferensi() {

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
        double totalHitungNilaiPreferensi = hitungTotalNilaiPreferensi(totalNilaiVariasiPreferensi);
        double totalNilaiDalamPreferensi = totalNilaiDalamPreferensi(totalNilaiVariasiPreferensi);
        double[] menentukanBobotKriteria = menentukanBobotKriteria(totalNilaiVariasiPreferensi, totalNilaiDalamPreferensi);
        ArrayList<PSI> menghitungNilaiPreferensi = menghitungNilaiPreferensi(alternatifList, kriteriaList, subKriteriaList, nilaiList, MinMax, menentukanBobotKriteria);

        DefaultTableModel DftTblModel_perhitungan = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Mengembalikan false untuk semua kolom sehingga tidak dapat diedit
                return false;
            }
        };

        DftTblModel_perhitungan.addColumn("No");
        DftTblModel_perhitungan.addColumn("Alternatif");
        for (int i = 0; i < kriteriaList.size(); i++) {
            DftTblModel_perhitungan.addColumn("K" + (i + 1));
        }
        DftTblModel_perhitungan.addColumn("Total Nilai");

        jTable_Perhitungan.setModel(DftTblModel_perhitungan);

        int nomor = 1; // Digunakan untuk nomor urut

        for (int i = 0; i < menghitungNilaiPreferensi.size(); i++) {
            PSI psi = menghitungNilaiPreferensi.get(i);
            Object[] rowData = new Object[kriteriaList.size() + 4];
            rowData[0] = nomor;
            rowData[1] = psi.getAlternatif();
            double[] kriteriaNilai = psi.getBobotKriteria();
            for (int j = 0; j < kriteriaList.size(); j++) {
                rowData[j + 2] = kriteriaNilai[j];
            }

            double total = 0;
            for (double nilai : psi.getBobotKriteria()) {
                total += nilai;
            }

            rowData[menghitungNilaiPreferensi.size() + 3] = total;
            DftTblModel_perhitungan.addRow(rowData);
            nomor++;
        }
    }

    public void showHasilAkhir() {

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
        double totalHitungNilaiPreferensi = hitungTotalNilaiPreferensi(totalNilaiVariasiPreferensi);
        double totalNilaiDalamPreferensi = totalNilaiDalamPreferensi(totalNilaiVariasiPreferensi);
        double[] menentukanBobotKriteria = menentukanBobotKriteria(totalNilaiVariasiPreferensi, totalNilaiDalamPreferensi);
        ArrayList<PSI> menghitungNilaiPreferensi = menghitungNilaiPreferensi(alternatifList, kriteriaList, subKriteriaList, nilaiList, MinMax, menentukanBobotKriteria);

        DefaultTableModel DftTblModel_perhitungan = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Mengembalikan false untuk semua kolom sehingga tidak dapat diedit
                return false;
            }
        };

        DftTblModel_perhitungan.addColumn("No");
        DftTblModel_perhitungan.addColumn("Alternatif");
        DftTblModel_perhitungan.addColumn("Nilai");
        DftTblModel_perhitungan.addColumn("Rank");

        jTable_Perhitungan.setModel(DftTblModel_perhitungan);

        int nomor = 1; // Digunakan untuk nomor urut

        // Create a data structure to store alternatives and their total values
        ArrayList<HasilAkhir> alternativeTotalValues = new ArrayList<>();

        for (int i = 0; i < menghitungNilaiPreferensi.size(); i++) {
            PSI psi = menghitungNilaiPreferensi.get(i);
            double total = 0;
            for (double nilai : psi.getBobotKriteria()) {
                total += nilai;
            }
            alternativeTotalValues.add(new HasilAkhir(psi.getAlternatif(), total));
        }

        alternativeTotalValues.sort((a, b) -> Double.compare(b.getTotalValue(), a.getTotalValue()));

        int rank = 1;
        for (HasilAkhir alternativeTotal : alternativeTotalValues) {
            String alternative = alternativeTotal.getAlternative();
            double totalValue = alternativeTotal.getTotalValue();
            Object[] rowData = new Object[]{
                nomor,
                alternative,
                totalValue,
                rank
            };
            DftTblModel_perhitungan.addRow(rowData);
            nomor++;
            rank++;
        }

        // Setelah Anda memiliki hasil perhitungan, ubah teks JLabel
        String alternativeTerbaik = alternativeTotalValues.get(0).getAlternative();
        double totalValueTerbaik = alternativeTotalValues.get(0).getTotalValue();

        Hasil.setText("Berdasarkan Hasil Perhitungan Bibit Kakao Terbaik Adalah : " + alternativeTerbaik + " Dengan Nilai : " + totalValueTerbaik);
    }


    private void jButton_RefreshAlternatifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RefreshAlternatifActionPerformed
        this.showAlternatif();
    }//GEN-LAST:event_jButton_RefreshAlternatifActionPerformed

    private void jTableAlternatifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAlternatifMouseClicked
        int row = jTableAlternatif.getSelectedRow();

        if (row != -1) { // Memeriksa apakah ada baris yang dipilih
            Object idObject = jTableAlternatif.getValueAt(row, 3);
            if (idObject != null) {

                int idKriteria = Integer.parseInt(idObject.toString());
                String kodeAlternatif = jTableAlternatif.getValueAt(row, 1).toString();
                String namaAlternatif = jTableAlternatif.getValueAt(row, 2).toString();

                // Buka form EditKriteria dan gunakan data yang diperoleh
                EditAlternatif formAlternatif = new EditAlternatif(idKriteria, kodeAlternatif, namaAlternatif);

                formAlternatif.setLocationRelativeTo(null);
                formAlternatif.setVisible(true);

            } else {
                System.out.println("ID Kriteria tidak tersedia.");
            }
        }
    }//GEN-LAST:event_jTableAlternatifMouseClicked

    private void jTable_PenilaianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_PenilaianMouseClicked

        ArrayList<Alternatif> alternatifList = alternatifService.showAlternatif();
        ArrayList<Kriteria> kriteriaList = kriteriaService.showKriteria();
        ArrayList<SubKriteria> subKriteriaList = subKriteriaService.showSubKriteria();
        ArrayList<Nilai> nilaiList = nilaiService.showNilai();

// Get the selected row
        int selectedRow = jTable_Penilaian.getSelectedRow();

        // Check if a valid row is clicked
        if (selectedRow >= 0) {
            // Create an ArrayList to store all the idnilai values for the selected row
            ArrayList<Integer> idNilaiList = new ArrayList<>();

            Alternatif alternatif = alternatifList.get(selectedRow);

            // Iterate through the columns where idnilai values are stored (even-numbered columns)
            for (int j = 3; j < jTable_Penilaian.getColumnCount(); j += 2) {
                int idNilai = (int) jTable_Penilaian.getValueAt(selectedRow, j);
                idNilaiList.add(idNilai);
            }

            // Buka form EditAlternatif dan gunakan data yang diperoleh
            EditNilai formNilai = new EditNilai(
                    alternatif,
                    idNilaiList
            );

            formNilai.setLocationRelativeTo(null);
            formNilai.setVisible(true);
        }
    }//GEN-LAST:event_jTable_PenilaianMouseClicked

    private void jTable_KriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_KriteriaMouseClicked
        int row = jTable_Kriteria.getSelectedRow();

        if (row != -1) { // Memeriksa apakah ada baris yang dipilih
            Object idObject = jTable_Kriteria.getValueAt(row, 4);
            if (idObject != null) {

                int idKriteria = Integer.parseInt(idObject.toString());
                String kodeKriteria = jTable_Kriteria.getValueAt(row, 1).toString();
                String namaKriteria = jTable_Kriteria.getValueAt(row, 2).toString();
                String jenisKriteria = jTable_Kriteria.getValueAt(row, 3).toString();

                // Buka form EditKriteria dan gunakan data yang diperoleh
                EditKriteria formKriteria = new EditKriteria(
                        idKriteria,
                        kodeKriteria,
                        namaKriteria,
                        jenisKriteria
                );

                formKriteria.setLocationRelativeTo(null);
                formKriteria.setVisible(true);

            } else {
                System.out.println("ID Kriteria tidak tersedia.");
            }
        }
    }//GEN-LAST:event_jTable_KriteriaMouseClicked

    private void jTable_PerhitunganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_PerhitunganMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_PerhitunganMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.showMatiksKeputusan();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton_TambahAlternatif1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TambahAlternatif1ActionPerformed
        TambahAlternatif formAlternatif = new TambahAlternatif();
        formAlternatif.setLocationRelativeTo(null);
        formAlternatif.setVisible(true);
    }//GEN-LAST:event_jButton_TambahAlternatif1ActionPerformed

    private void jButton_RefreshkriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RefreshkriteriaActionPerformed
        this.showkriteria();
    }//GEN-LAST:event_jButton_RefreshkriteriaActionPerformed

    private void jButton_TambahKriteria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TambahKriteria1ActionPerformed
        TambahSubKriteria formSubKriteria = new TambahSubKriteria();
        formSubKriteria.setLocationRelativeTo(null);
        formSubKriteria.setVisible(true);
    }//GEN-LAST:event_jButton_TambahKriteria1ActionPerformed

    private void jTable_SubKriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_SubKriteriaMouseClicked
        int row = jTable_SubKriteria.getSelectedRow();

        if (row != -1) { // Memeriksa apakah ada baris yang dipilih

            Object idkObject = jTable_SubKriteria.getValueAt(row, 5);
            // Mengambil ID SubKriteria dari kolom indeks 6
            Object idObject = jTable_SubKriteria.getValueAt(row, 6);

            // Mengambil data lain dari baris yang dipilih
            String kodeSubKriteria = jTable_SubKriteria.getValueAt(row, 2).toString();
            String namaSubKriteria = jTable_SubKriteria.getValueAt(row, 3).toString();
            String bobotSubKriteria = jTable_SubKriteria.getValueAt(row, 4).toString();

            int idKriteria = Integer.parseInt(idkObject.toString());
            int id = Integer.parseInt(idObject.toString());

            EditSubKriteria formSubKriteria = new EditSubKriteria(id, idKriteria, kodeSubKriteria, namaSubKriteria, bobotSubKriteria);
            formSubKriteria.setLocationRelativeTo(null);
            formSubKriteria.setVisible(true);
        }
    }//GEN-LAST:event_jTable_SubKriteriaMouseClicked

    private void jButton_Refreshkriteria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Refreshkriteria1ActionPerformed
        this.showSubKriteria();
    }//GEN-LAST:event_jButton_Refreshkriteria1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.showNilai();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.showMatiksKeputusanAsli();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.showNormalisasiNilaiMatriks();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.showNilaiVariasiPreferensi();

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.showHasilAkhir();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.showNilaiPreferensi();
    }//GEN-LAST:event_jButton10ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Hasil;
    private javax.swing.JPanel cont;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton_RefreshAlternatif;
    private javax.swing.JButton jButton_Refreshkriteria;
    private javax.swing.JButton jButton_Refreshkriteria1;
    private javax.swing.JButton jButton_TambahAlternatif1;
    private javax.swing.JButton jButton_TambahKriteria1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableAlternatif;
    private javax.swing.JTable jTable_Kriteria;
    private javax.swing.JTable jTable_Penilaian;
    private javax.swing.JTable jTable_Perhitungan;
    private javax.swing.JTable jTable_SubKriteria;
    // End of variables declaration//GEN-END:variables

}
