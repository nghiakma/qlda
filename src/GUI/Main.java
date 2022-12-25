/*
quangvinh.gulang@gmail.com
 */
package GUI;

import Manager.SinhVienManager;
import Manager.MuonTraManager;
import Manager.NhanVienManager;

import Manager.DoAnManager;
import Manager.ThongKeManager;
import Manager.ViPhamManager;

import Model.SinhVien;
import Model.MuonTra;
import Model.NhanVien;
import Model.DoAn;
import Model.ThongKe;
import com.placeholder.PlaceHolder;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author quangvinh.gulang@gmail.com
 */
public class Main extends javax.swing.JFrame {
    SinhVienManager docgiaManager= new SinhVienManager();
    DoAnManager sachManager=new DoAnManager();
    NhanVienManager nhanvienManager = new NhanVienManager();
    MuonTraManager muontraManager = new MuonTraManager();
    ViPhamManager viphamManager = new ViPhamManager();
    PlaceHolder holder;
    static final int SACH_TOI_DA = 3;// số sách mượn tối đa.
    public static int maMPPrint;
   
    public Main(){
        initComponents();
        docgiaManager.xoaDocGiaHetHan();
        docgiaManager.loadDataDocGiaFromDB(jtableDocGia,txtTimKiemDocGia.getText());
        sachManager.loadDataSachFromDB(jtableSach,txtTimKiemSach.getText());
        nhanvienManager.loadDataNhanVienFromDB(jtableNhanVien,txtTimKiemNV.getText());
        docgiaManager.loadDataDocGiaMTFromDB(jtableDocGiaMT,txtTimKiemDGMT.getText());
        muontraManager.loadDataMuonTraFromDB(jtableMuonTra,txtTimKiemMT.getText());
        viphamManager.loadDataViPhamFromDB(jtableViPham, txtTimKiemVP.getText());
        jLabelTenDN.setText("Xin chào "+Login.tenDN+"!");
        jLabelSachToiDa.setText(SACH_TOI_DA + " Quyển");
        jLabelHanThe.setText(SinhVienManager.HAN_THE + " Năm");
        jLabelMuonTD.setText(MuonTraManager.MUON_TOI_DA + " Ngày");
        jButtonXoaMuon.setEnabled(false);
        jButtonBaoMat.setEnabled(false); 
        jbuttonChonSach.setEnabled(false);
        jbuttonBoSach.setEnabled(false);
        jButtonSuaSach.setEnabled(false);
        jButtonXoaSach.setEnabled(false);
        jButtonSuaDocGia.setEnabled(false);
        jButtonXoaDocGia.setEnabled(false);
 
        jButtonXoaNV.setEnabled(false);
        jButtonCapNhatNV.setEnabled(false);
        jButtonXuLyVP.setEnabled(false);

        holder = new PlaceHolder(txtTimKiemDGMT, "Nhập mã sinh viên/ tên sinh viên/ email cần tìm");
        holder = new PlaceHolder(txtTimKiemSachMT, "Nhập mã đồ án/ tên đồ án/ loại đồ án cần tìm");
        holder = new PlaceHolder(txtTimKiemMT, "Nhập mã mượn trả/ mã hoặc tên sinh viên/ tên đồ án");
        holder = new PlaceHolder(txtTimKiemSach, "Nhập mã đồ án/ tên đồ án/ loại đồ án/ chủ đồ án cần tìm");
        holder = new PlaceHolder(txtTimKiemDocGia, "Nhập mã sinh viên/ tên sinh viên/ email cần tìm");
        holder = new PlaceHolder(txtTimKiemNV, "Nhập mã nhân viên/ tên nhân viên/ chức vụ cần tìm");
        holder = new PlaceHolder(txtTimKiemVP, "Nhập mã sinh viên/ tên sinh viên/ tên đồ án cần tìm");
        jRadioToanThoiGian.doClick();
        jRadioSach.doClick();
        
        if(Login.maNV == 1){
            this.jTabbedMain.setEnabledAt(4,true);       
        } else this.jTabbedMain.setEnabledAt(4,false);
    }
    
    
    public void NhapMoiDocGia(){
        txtTenDocGia.setText(""); 
        txtDiaChi.setText(""); 
        txtEmail.setText(""); 
        txtDienThoai.setText(""); 
        txtTimKiemDocGia.setText("");
        docgiaManager.loadDataDocGiaFromDB(jtableDocGia,txtTimKiemDocGia.getText());
        //Đặt mặc định độc giả 18 tuổi.
        java.util.Date toDay = new java.util.Date();
        Calendar ngay18 = Calendar.getInstance();
        ngay18.setTime(toDay);
        ngay18.roll(Calendar.YEAR, -18);
        jDateNgayLapThe.setDate(toDay);
        jDateNgaySinh.setDate(ngay18.getTime());
    }
    
    public void NhapMoiSach(){
        txtTenSach.setText(""); 
        txtTacGia.setText(""); 
        txtNgonNgu.setText(""); 
        txtNhaXuatBan.setText("");
        txtNamXuatBan.setText("");
        spinnerSoLuong.setValue(1);
        spinnerSoTrang.setValue(0);
        txtGiaTien.setText(""); 
        txtTimKiemSach.setText("");        
        sachManager.loadDataSachFromDB(jtableSach,txtTimKiemSach.getText());
        
        java.util.Date toDay = new java.util.Date();
        jDateNgayNhap.setDate(toDay);
    }
    
    public void NhapMoiNV(){
        txtTenNhanVien.setText("");
        txtChucVu.setText("");
        txtDienThoaiNV.setText("");        
        txtEmailNV.setText("");
        txtTimKiemNV.setText("");
        txtTenDangNhap.setText("");
        nhanvienManager.loadDataNhanVienFromDB(jtableNhanVien,txtTimKiemNV.getText());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupMuonTra = new javax.swing.ButtonGroup();
        GroupYeuCauTK = new javax.swing.ButtonGroup();
        GroupKhoangThoiGianTK = new javax.swing.ButtonGroup();
        jTabbedMain = new javax.swing.JTabbedPane();
        tabMuonTra = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        txtTimKiemSachMT = new javax.swing.JTextField();
        jTimkiem1 = new javax.swing.JButton();
        jScrollPane24 = new javax.swing.JScrollPane();
        jtableSachMT = new javax.swing.JTable();
        jbuttonChonSach = new javax.swing.JButton();
        jbuttonBoSach = new javax.swing.JButton();
        jLabelTitleSachChon = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        jtableSachChon = new javax.swing.JTable();
        jPanel38 = new javax.swing.JPanel();
        txtTimKiemDGMT = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jButtonTimKiemDGMT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableDocGiaMT = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jRMuonsach = new javax.swing.JRadioButton();
        jRTrasach = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelDangMuon = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButtonBaoMat = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jDateNgayMT = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jButtonXoaMuon = new javax.swing.JButton();
        jBMuontra = new javax.swing.JButton();
        jButtonToDay = new javax.swing.JButton();
        txtTimKiemMT = new javax.swing.JTextField();
        jButtonTimKiemMT1 = new javax.swing.JButton();
        jScrollPane26 = new javax.swing.JScrollPane();
        jtableMuonTra = new javax.swing.JTable();
        tabSach = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtableSach = new javax.swing.JTable();
        txtTimKiemSach = new javax.swing.JTextField();
        jButtonTimKiemSach = new javax.swing.JButton();
        jButtonThemSach = new javax.swing.JButton();
        jButtonNhapMoiSach = new javax.swing.JButton();
        jButtonXoaSach = new javax.swing.JButton();
        jButtonSuaSach = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel17 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        jComboBoxTheLoai = new javax.swing.JComboBox<>();
        txtNgonNgu = new javax.swing.JTextField();
        txtNhaXuatBan = new javax.swing.JTextField();
        txtTacGia = new javax.swing.JTextField();
        jDateNgayNhap = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtGiaTien = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        spinnerSoLuong = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        spinnerSoTrang = new javax.swing.JSpinner();
        txtNamXuatBan = new javax.swing.JTextField();
        tabDocGia = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtTenDocGia = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jComboBoxGioiTinh = new javax.swing.JComboBox<>();
        txtDienThoai = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jDateNgayLapThe = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jDateNgaySinh = new com.toedter.calendar.JDateChooser();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtableDocGia = new javax.swing.JTable();
        txtTimKiemDocGia = new javax.swing.JTextField();
        jButtonTimKiemDocGia = new javax.swing.JButton();
        jButtonThemDocGia = new javax.swing.JButton();
        jButtonSuaDocGia = new javax.swing.JButton();
        jButtonXoaDocGia = new javax.swing.JButton();
        jButtonNhapMoiDocGia = new javax.swing.JButton();
        tabThongKe = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jDateNgayBD = new com.toedter.calendar.JDateChooser();
        jDateNgayKT = new com.toedter.calendar.JDateChooser();
        jRadioChonNgay = new javax.swing.JRadioButton();
        jRadioToanThoiGian = new javax.swing.JRadioButton();
        jRadioTuan = new javax.swing.JRadioButton();
        jRadioThang = new javax.swing.JRadioButton();
        jRadioDocGia = new javax.swing.JRadioButton();
        jRadioTheLoai = new javax.swing.JRadioButton();
        jRadioTacGia = new javax.swing.JRadioButton();
        jRadioNXB = new javax.swing.JRadioButton();
        jRadioSach = new javax.swing.JRadioButton();
        jRadioSachHet = new javax.swing.JRadioButton();
        jRadioViPham = new javax.swing.JRadioButton();
        jRadioDGHetHan = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableThongKe = new javax.swing.JTable();
        jButtonThongKe = new javax.swing.JButton();
        tabNhanVien = new javax.swing.JPanel();
        jPanelTTNhanVien = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        jComboBoxGioiTinhNV = new javax.swing.JComboBox<>();
        txtDienThoaiNV = new javax.swing.JTextField();
        txtEmailNV = new javax.swing.JTextField();
        jDateNgaySinhNV = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        txtChucVu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtableNhanVien = new javax.swing.JTable();
        txtTimKiemNV = new javax.swing.JTextField();
        jButtonTimKiemNV = new javax.swing.JButton();
        jButtonThemNV = new javax.swing.JButton();
        jButtonCapNhatNV = new javax.swing.JButton();
        jButtonXoaNV = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tabViPham = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableViPham = new javax.swing.JTable();
        jButtonTimKiemVP = new javax.swing.JButton();
        txtTimKiemVP = new javax.swing.JTextField();
        jButtonXuLyVP = new javax.swing.JButton();
        tabThongTin = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabelHanThe = new javax.swing.JLabel();
        jLabelSachToiDa = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelMuonTD = new javax.swing.JLabel();
        jLabelTenDN = new javax.swing.JLabel();
        jLabelDangXuat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm quản lý đồ án");
        setBackground(new java.awt.Color(153, 255, 255));

        jTabbedMain.setBackground(new java.awt.Color(255, 255, 204));
        jTabbedMain.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tabMuonTra.setBackground(new java.awt.Color(204, 255, 204));

        jPanel39.setBackground(new java.awt.Color(204, 255, 204));

        txtTimKiemSachMT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemSachMTKeyPressed(evt);
            }
        });

        jTimkiem1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTimkiem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/timkiem16.png"))); // NOI18N
        jTimkiem1.setText("Tìm kiếm");
        jTimkiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTimkiem1ActionPerformed(evt);
            }
        });

        jtableSachMT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã mượn trả", "Mã Sinh Viên", "Tên Sinh Viên", "Tên Đồ Án", "Tên nhân viên", "Ngày mượn", "Ngày trả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableSachMT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableSachMTMouseClicked(evt);
            }
        });
        jScrollPane24.setViewportView(jtableSachMT);

        jbuttonChonSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/down-arrow.png"))); // NOI18N
        jbuttonChonSach.setText("Chọn");
        jbuttonChonSach.setToolTipText("Chọn sách cần thực hiện");
        jbuttonChonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonChonSachActionPerformed(evt);
            }
        });

        jbuttonBoSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/up-arrow (1).png"))); // NOI18N
        jbuttonBoSach.setText("Bỏ chọn");
        jbuttonBoSach.setToolTipText("Loại bỏ bớt 1 quyển sách");
        jbuttonBoSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonBoSachActionPerformed(evt);
            }
        });

        jLabelTitleSachChon.setText("Danh sách đăng ký mượn / trả");

        jtableSachChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", ""
            }
        ));
        jtableSachChon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableSachChonMouseClicked(evt);
            }
        });
        jScrollPane25.setViewportView(jtableSachChon);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(txtTimKiemSachMT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTimkiem1))
            .addComponent(jScrollPane24)
            .addComponent(jScrollPane25, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jLabelTitleSachChon)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jbuttonChonSach)
                .addGap(89, 89, 89)
                .addComponent(jbuttonBoSach)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel39Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbuttonBoSach, jbuttonChonSach});

        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemSachMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTimkiem1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonChonSach)
                    .addComponent(jbuttonBoSach))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTitleSachChon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel39Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTimkiem1, txtTimKiemSachMT});

        jPanel39Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbuttonBoSach, jbuttonChonSach});

        jPanel38.setBackground(new java.awt.Color(204, 255, 204));
        jPanel38.setName("ĐỒ ÁN"); // NOI18N

        txtTimKiemDGMT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiemDGMT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemDGMTKeyPressed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonTimKiemDGMT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonTimKiemDGMT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/timkiem16.png"))); // NOI18N
        jButtonTimKiemDGMT.setText("Tìm kiếm");
        jButtonTimKiemDGMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemDGMTActionPerformed(evt);
            }
        });

        jtableDocGiaMT.setAutoCreateRowSorter(true);
        jtableDocGiaMT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sinh Viên", "Họ tên", "Ngày sinh", "Điện thoại", "Đang mượn", "Phạt"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableDocGiaMT.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtableDocGiaMT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableDocGiaMTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableDocGiaMT);
        if (jtableDocGiaMT.getColumnModel().getColumnCount() > 0) {
            jtableDocGiaMT.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(475, 475, 475)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel65)))
                .addGap(0, 151, Short.MAX_VALUE))
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(txtTimKiemDGMT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonTimKiemDGMT, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTimKiemDGMT)
                    .addComponent(txtTimKiemDGMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel64)
                .addGap(204, 204, 204)
                .addComponent(jLabel65))
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("3. Chọn tác vụ"));

        jRMuonsach.setBackground(new java.awt.Color(204, 255, 204));
        GroupMuonTra.add(jRMuonsach);
        jRMuonsach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRMuonsach.setText("Mượn đồ án");
        jRMuonsach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRMuonsachActionPerformed(evt);
            }
        });

        jRTrasach.setBackground(new java.awt.Color(204, 255, 204));
        GroupMuonTra.add(jRTrasach);
        jRTrasach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRTrasach.setText("Trả đồ án");
        jRTrasach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRTrasachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jRMuonsach)
                .addGap(113, 113, 113)
                .addComponent(jRTrasach)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRMuonsach)
                    .addComponent(jRTrasach))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Đang mượn:");
        jLabel4.setToolTipText("Hiển thị tổng số sách độc giả chưa trả.");

        jLabelDangMuon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelDangMuon.setText("0");
        jLabelDangMuon.setToolTipText("Tổng số sách mà độc giả đang mượn");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("đồ án");

        jButtonBaoMat.setBackground(new java.awt.Color(255, 153, 153));
        jButtonBaoMat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/baomat.png"))); // NOI18N
        jButtonBaoMat.setText("Báo mất!");
        jButtonBaoMat.setToolTipText("Báo mất khi độc giả để mất sách mượn.");
        jButtonBaoMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBaoMatActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("2. Ngày mượn/ trả:");

        jDateNgayMT.setBackground(new java.awt.Color(204, 255, 204));
        jDateNgayMT.setDateFormatString("dd/MM/yyyy");
        jDateNgayMT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel8.setBackground(new java.awt.Color(204, 255, 204));

        jButtonXoaMuon.setBackground(new java.awt.Color(255, 153, 153));
        jButtonXoaMuon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonXoaMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/xoa.png"))); // NOI18N
        jButtonXoaMuon.setText("Xóa");
        jButtonXoaMuon.setToolTipText("Ấn để xóa 1 lượt mượn đã chọn.");
        jButtonXoaMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaMuonActionPerformed(evt);
            }
        });

        jBMuontra.setBackground(new java.awt.Color(102, 102, 255));
        jBMuontra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBMuontra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/thuchien.png"))); // NOI18N
        jBMuontra.setText("Duyệt ");
        jBMuontra.setToolTipText("Thực hiện các bước 1 2 3 4 bên trên trước khi ấn nút này");
        jBMuontra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMuontraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jBMuontra, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(jButtonXoaMuon)
                .addGap(29, 29, 29))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBMuontra, jButtonXoaMuon});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBMuontra, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonXoaMuon))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBMuontra, jButtonXoaMuon});

        jButtonToDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/today.png"))); // NOI18N
        jButtonToDay.setText("ToDay");
        jButtonToDay.setToolTipText("Đặt ngày mượn trả về ngày hôm nay");
        jButtonToDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonToDayActionPerformed(evt);
            }
        });

        txtTimKiemMT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiemMT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemMTKeyPressed(evt);
            }
        });

        jButtonTimKiemMT1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonTimKiemMT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/timkiem16.png"))); // NOI18N
        jButtonTimKiemMT1.setText("Tìm kiếm");
        jButtonTimKiemMT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemMT1ActionPerformed(evt);
            }
        });

        jtableMuonTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Sinh Viên", "Sinh Viên", "Mã Đồ Án", "Tên Đồ Án", "Ngày mượn", "Ngày trả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableMuonTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMuonTraMouseClicked(evt);
            }
        });
        jScrollPane26.setViewportView(jtableMuonTra);

        javax.swing.GroupLayout tabMuonTraLayout = new javax.swing.GroupLayout(tabMuonTra);
        tabMuonTra.setLayout(tabMuonTraLayout);
        tabMuonTraLayout.setHorizontalGroup(
            tabMuonTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabMuonTraLayout.createSequentialGroup()
                .addGroup(tabMuonTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabMuonTraLayout.createSequentialGroup()
                        .addGroup(tabMuonTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(tabMuonTraLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateNgayMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonToDay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDangMuon)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16))
                            .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(56, 56, 56)
                        .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane26)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabMuonTraLayout.createSequentialGroup()
                        .addGap(0, 436, Short.MAX_VALUE)
                        .addGroup(tabMuonTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabMuonTraLayout.createSequentialGroup()
                                .addComponent(txtTimKiemMT, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonTimKiemMT1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabMuonTraLayout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(320, 320, 320)
                                .addComponent(jButtonBaoMat, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        tabMuonTraLayout.setVerticalGroup(
            tabMuonTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabMuonTraLayout.createSequentialGroup()
                .addGroup(tabMuonTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tabMuonTraLayout.createSequentialGroup()
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabMuonTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(jDateNgayMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabelDangMuon)
                            .addComponent(jLabel16)
                            .addComponent(jButtonToDay))
                        .addGap(24, 24, 24)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabMuonTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBaoMat)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabMuonTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTimKiemMT1)
                    .addComponent(txtTimKiemMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
        );

        jPanel38.getAccessibleContext().setAccessibleName("\"Chọn Đồ Án\""); // NOI18N
        jPanel38.getAccessibleContext().setAccessibleDescription("");

        jTabbedMain.addTab("Mượn trả ", new javax.swing.ImageIcon(getClass().getResource("/Icon/muontra.png")), tabMuonTra); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jtableSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đồ án", "Tên đồ án", "Loại đồ án", "Chủ đồ án", "Nơi quản lý đồ án", "Năm ht đồ án", "Ngày nhập", "Ngôn ngữ", "Số trang", "Số lượng", "Giá tiền bản cứng", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableSachMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jtableSach);

        txtTimKiemSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiemSach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemSachKeyPressed(evt);
            }
        });

        jButtonTimKiemSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonTimKiemSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/timkiem16.png"))); // NOI18N
        jButtonTimKiemSach.setText("Tìm kiếm");
        jButtonTimKiemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemSachActionPerformed(evt);
            }
        });

        jButtonThemSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonThemSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/them.png"))); // NOI18N
        jButtonThemSach.setText("Thêm");
        jButtonThemSach.setToolTipText("Thêm mới 1 quyển Sách.");
        jButtonThemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemSachActionPerformed(evt);
            }
        });

        jButtonNhapMoiSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/nhapmoi.png"))); // NOI18N
        jButtonNhapMoiSach.setText("Nhập Mới");
        jButtonNhapMoiSach.setToolTipText("Nhập mới toàn bộ thông tin");
        jButtonNhapMoiSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNhapMoiSachActionPerformed(evt);
            }
        });

        jButtonXoaSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonXoaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/xoa.png"))); // NOI18N
        jButtonXoaSach.setText("Xóa");
        jButtonXoaSach.setToolTipText("Chọn 1 quyển sách rồi Xóa");
        jButtonXoaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaSachActionPerformed(evt);
            }
        });

        jButtonSuaSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSuaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua.png"))); // NOI18N
        jButtonSuaSach.setText("Sửa");
        jButtonSuaSach.setToolTipText("Chọn 1 quyển sách và Sửa thông tin");
        jButtonSuaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(204, 204, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Tên Đồ Án");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Loại Đồ Án");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Chủ đồ án");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Nơi quản lý đồ án");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Ngôn ngữ:");

        txtTenSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jComboBoxTheLoai.setBackground(new java.awt.Color(204, 204, 255));
        jComboBoxTheLoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxTheLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CNTT", "ATTT", "DTVT", " " }));
        jComboBoxTheLoai.setToolTipText("");

        txtNgonNgu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNhaXuatBan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtTacGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateNgayNhap.setBackground(new java.awt.Color(204, 204, 255));
        jDateNgayNhap.setToolTipText("Nhấp để chọn ngày tháng");
        jDateNgayNhap.setDateFormatString("dd/MM/yyyy");
        jDateNgayNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Ngày nhập:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Năm Hoàn thành đồ án");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Giá Bản cứng đồ án");

        txtGiaTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("VNĐ");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Số lượng:");

        spinnerSoLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Số trang:");

        spinnerSoTrang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNamXuatBan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addComponent(jComboBoxTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(txtTenSach, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTacGia, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))))
                .addGap(9, 9, 9)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNhaXuatBan)
                            .addComponent(txtNgonNgu))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel44))
                            .addComponent(jDateNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(spinnerSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(448, 448, 448))))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtNgonNgu, txtNhaXuatBan, txtTacGia, txtTenSach});

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel9});

        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(jDateNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jComboBoxTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(spinnerSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(43, 43, 43))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgonNgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtNamXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxTheLoai, txtGiaTien, txtNgonNgu, txtNhaXuatBan, txtTacGia, txtTenSach});

        jComboBoxTheLoai.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jButtonThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145)
                .addComponent(jButtonSuaSach)
                .addGap(174, 174, 174)
                .addComponent(jButtonXoaSach)
                .addGap(166, 166, 166)
                .addComponent(jButtonNhapMoiSach)
                .addContainerGap(200, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonTimKiemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane6)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonNhapMoiSach, jButtonSuaSach, jButtonXoaSach});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane1)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSuaSach)
                    .addComponent(jButtonXoaSach)
                    .addComponent(jButtonNhapMoiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTimKiemSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTimKiemSach))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonNhapMoiSach, jButtonSuaSach, jButtonThemSach, jButtonXoaSach});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonTimKiemSach, txtTimKiemSach});

        javax.swing.GroupLayout tabSachLayout = new javax.swing.GroupLayout(tabSach);
        tabSach.setLayout(tabSachLayout);
        tabSachLayout.setHorizontalGroup(
            tabSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabSachLayout.setVerticalGroup(
            tabSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedMain.addTab("Đồ Án", new javax.swing.ImageIcon(getClass().getResource("/Icon/sach.png")), tabSach); // NOI18N

        tabDocGia.setBackground(new java.awt.Color(255, 255, 204));

        jPanel18.setBackground(new java.awt.Color(255, 255, 204));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin Sinh Viên"));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Tên sinh viên:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Địa chỉ:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Giới tính:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Email:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Điện thoại:");

        txtTenDocGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jComboBoxGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        txtDienThoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Ngày lập thẻ:");

        jDateNgayLapThe.setBackground(new java.awt.Color(255, 255, 204));
        jDateNgayLapThe.setDateFormatString("dd/MM/yyyy");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Ngày sinh:");

        jDateNgaySinh.setBackground(new java.awt.Color(255, 255, 204));
        jDateNgaySinh.setDateFormatString("dd/MM/yyyy");
        jDateNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTenDocGia))
                .addGap(132, 132, 132)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jDateNgayLapThe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel21, jLabel22});

        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel21)
                    .addComponent(txtTenDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jDateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel25)
                    .addComponent(jComboBoxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jDateNgayLapThe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtDiaChi, txtDienThoai, txtEmail, txtTenDocGia});

        jPanel18Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel21, jLabel22, jLabel23, jLabel28});

        jPanel18Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel25, jLabel30});

        jtableDocGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Email", "Điện thoại", "Số đồ án đang mượn", "Vi phạm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableDocGiaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jtableDocGia);

        txtTimKiemDocGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemDocGiaKeyPressed(evt);
            }
        });

        jButtonTimKiemDocGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonTimKiemDocGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/timkiem16.png"))); // NOI18N
        jButtonTimKiemDocGia.setText("Tìm kiếm");
        jButtonTimKiemDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemDocGiaActionPerformed(evt);
            }
        });

        jButtonThemDocGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonThemDocGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/them.png"))); // NOI18N
        jButtonThemDocGia.setText("Thêm");
        jButtonThemDocGia.setToolTipText("Thêm mới 1 độc giả.");
        jButtonThemDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemDocGiaActionPerformed(evt);
            }
        });

        jButtonSuaDocGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSuaDocGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua.png"))); // NOI18N
        jButtonSuaDocGia.setText("Sửa");
        jButtonSuaDocGia.setToolTipText("Chọn 1 độc giả rồi Sửa.");
        jButtonSuaDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaDocGiaActionPerformed(evt);
            }
        });

        jButtonXoaDocGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonXoaDocGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/xoa.png"))); // NOI18N
        jButtonXoaDocGia.setText("Xóa");
        jButtonXoaDocGia.setToolTipText("Chọn 1 độc giả rồi Xóa.");
        jButtonXoaDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaDocGiaActionPerformed(evt);
            }
        });

        jButtonNhapMoiDocGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonNhapMoiDocGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/nhapmoi.png"))); // NOI18N
        jButtonNhapMoiDocGia.setText("Nhập mới");
        jButtonNhapMoiDocGia.setToolTipText("Nhập mới toàn bộ thông tin");
        jButtonNhapMoiDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNhapMoiDocGiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabDocGiaLayout = new javax.swing.GroupLayout(tabDocGia);
        tabDocGia.setLayout(tabDocGiaLayout);
        tabDocGiaLayout.setHorizontalGroup(
            tabDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDocGiaLayout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addGroup(tabDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabDocGiaLayout.createSequentialGroup()
                        .addComponent(txtTimKiemDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTimKiemDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabDocGiaLayout.createSequentialGroup()
                        .addComponent(jButtonThemDocGia)
                        .addGap(108, 108, 108)
                        .addComponent(jButtonSuaDocGia)
                        .addGap(100, 100, 100)
                        .addComponent(jButtonXoaDocGia)
                        .addGap(95, 95, 95)
                        .addComponent(jButtonNhapMoiDocGia)
                        .addGap(287, 287, 287))))
            .addGroup(tabDocGiaLayout.createSequentialGroup()
                .addGroup(tabDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7))
                .addContainerGap())
        );

        tabDocGiaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonNhapMoiDocGia, jButtonSuaDocGia, jButtonThemDocGia, jButtonXoaDocGia});

        tabDocGiaLayout.setVerticalGroup(
            tabDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDocGiaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonThemDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSuaDocGia)
                    .addComponent(jButtonXoaDocGia)
                    .addComponent(jButtonNhapMoiDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(tabDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTimKiemDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTimKiemDocGia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7)
                .addContainerGap())
        );

        tabDocGiaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonTimKiemDocGia, txtTimKiemDocGia});

        tabDocGiaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonSuaDocGia, jButtonThemDocGia, jButtonXoaDocGia});

        jTabbedMain.addTab("Sinh Viên", new javax.swing.ImageIcon(getClass().getResource("/Icon/docgia.png")), tabDocGia); // NOI18N

        tabThongKe.setBackground(new java.awt.Color(204, 255, 204));

        jPanel20.setBackground(new java.awt.Color(204, 255, 204));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("Yêu cầu thống kê"));

        jPanel9.setBackground(new java.awt.Color(153, 255, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Khoảng thời gian"));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("đến ngày");

        jDateNgayBD.setBackground(new java.awt.Color(153, 255, 204));
        jDateNgayBD.setDateFormatString("dd/MM/yyyy");
        jDateNgayBD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateNgayKT.setBackground(new java.awt.Color(153, 255, 204));
        jDateNgayKT.setDateFormatString("dd/MM/yyyy");
        jDateNgayKT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jRadioChonNgay.setBackground(new java.awt.Color(153, 255, 204));
        GroupKhoangThoiGianTK.add(jRadioChonNgay);
        jRadioChonNgay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioChonNgay.setText("Từ ngày");
        jRadioChonNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioChonNgayActionPerformed(evt);
            }
        });

        jRadioToanThoiGian.setBackground(new java.awt.Color(153, 255, 204));
        GroupKhoangThoiGianTK.add(jRadioToanThoiGian);
        jRadioToanThoiGian.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioToanThoiGian.setText("Toàn thời gian");
        jRadioToanThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioToanThoiGianActionPerformed(evt);
            }
        });

        jRadioTuan.setBackground(new java.awt.Color(153, 255, 204));
        GroupKhoangThoiGianTK.add(jRadioTuan);
        jRadioTuan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioTuan.setText("1 Tuần");
        jRadioTuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioTuanActionPerformed(evt);
            }
        });

        jRadioThang.setBackground(new java.awt.Color(153, 255, 204));
        GroupKhoangThoiGianTK.add(jRadioThang);
        jRadioThang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioThang.setText("1 Tháng");
        jRadioThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioThangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioToanThoiGian)
                .addGap(67, 67, 67)
                .addComponent(jRadioThang)
                .addGap(80, 80, 80)
                .addComponent(jRadioTuan)
                .addGap(73, 73, 73)
                .addComponent(jRadioChonNgay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(12, 12, 12)
                .addComponent(jDateNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jDateNgayBD, jDateNgayKT});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDateNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jDateNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioChonNgay)
                    .addComponent(jRadioToanThoiGian)
                    .addComponent(jRadioTuan)
                    .addComponent(jRadioThang))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDateNgayBD, jDateNgayKT, jLabel7});

        jRadioDocGia.setBackground(new java.awt.Color(204, 255, 204));
        GroupYeuCauTK.add(jRadioDocGia);
        jRadioDocGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioDocGia.setText("Số lượt mượn theo Sinh Viên");
        jRadioDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioDocGiaActionPerformed(evt);
            }
        });

        jRadioTheLoai.setBackground(new java.awt.Color(204, 255, 204));
        GroupYeuCauTK.add(jRadioTheLoai);
        jRadioTheLoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioTheLoai.setText("Số lượt mượn theo loại đồ án");
        jRadioTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioTheLoaiActionPerformed(evt);
            }
        });

        jRadioTacGia.setBackground(new java.awt.Color(204, 255, 204));
        GroupYeuCauTK.add(jRadioTacGia);
        jRadioTacGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioTacGia.setText("Số lượt mượn theo Sinh Viên Thực hiện đồ án");
        jRadioTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioTacGiaActionPerformed(evt);
            }
        });

        jRadioNXB.setBackground(new java.awt.Color(204, 255, 204));
        GroupYeuCauTK.add(jRadioNXB);
        jRadioNXB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioNXB.setText("Số lượt mượn theo Nơi quản lý đồ án");
        jRadioNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioNXBActionPerformed(evt);
            }
        });

        jRadioSach.setBackground(new java.awt.Color(204, 255, 204));
        GroupYeuCauTK.add(jRadioSach);
        jRadioSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioSach.setText("Số lượt mượn theo Đồ Án");
        jRadioSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioSachActionPerformed(evt);
            }
        });

        jRadioSachHet.setBackground(new java.awt.Color(204, 255, 204));
        GroupYeuCauTK.add(jRadioSachHet);
        jRadioSachHet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioSachHet.setText("Đồ án đã mượn hết");
        jRadioSachHet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioSachHetActionPerformed(evt);
            }
        });

        jRadioViPham.setBackground(new java.awt.Color(204, 255, 204));
        GroupYeuCauTK.add(jRadioViPham);
        jRadioViPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioViPham.setText("Danh sách vi phạm");
        jRadioViPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioViPhamActionPerformed(evt);
            }
        });

        jRadioDGHetHan.setBackground(new java.awt.Color(204, 255, 204));
        GroupYeuCauTK.add(jRadioDGHetHan);
        jRadioDGHetHan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioDGHetHan.setText("Danh sách Sinh Viên hết hạn thẻ");
        jRadioDGHetHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioDGHetHanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioSach)
                    .addComponent(jRadioDocGia))
                .addGap(134, 134, 134)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioNXB)
                    .addComponent(jRadioTacGia))
                .addGap(145, 145, 145)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioDGHetHan)
                    .addComponent(jRadioTheLoai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioSachHet)
                    .addComponent(jRadioViPham))
                .addGap(96, 96, 96))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioSach)
                    .addComponent(jRadioNXB)
                    .addComponent(jRadioSachHet)
                    .addComponent(jRadioTheLoai))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRadioDocGia)
                    .addComponent(jRadioTacGia)
                    .addComponent(jRadioViPham)
                    .addComponent(jRadioDGHetHan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTableThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SỐ THỨ TỰ", "NỘI DUNG", "SỐ LƯỢT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableThongKe);

        jButtonThongKe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/thuchien.png"))); // NOI18N
        jButtonThongKe.setText("Thống kê");
        jButtonThongKe.setToolTipText("Chọn các yêu cầu bên trên sau đó click Thống kê");
        jButtonThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabThongKeLayout = new javax.swing.GroupLayout(tabThongKe);
        tabThongKe.setLayout(tabThongKeLayout);
        tabThongKeLayout.setHorizontalGroup(
            tabThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThongKeLayout.createSequentialGroup()
                .addGap(646, 646, 646)
                .addComponent(jButtonThongKe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabThongKeLayout.setVerticalGroup(
            tabThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtonThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3))
        );

        jTabbedMain.addTab("Thống kê ", new javax.swing.ImageIcon(getClass().getResource("/Icon/thongke.png")), tabThongKe); // NOI18N

        tabNhanVien.setBackground(new java.awt.Color(204, 255, 255));

        jPanelTTNhanVien.setBackground(new java.awt.Color(204, 255, 255));
        jPanelTTNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nhân viên"));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Tên nhân viên:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Ngày sinh:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Giới tính:");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Email:");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Điện thoại:");

        txtTenNhanVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jComboBoxGioiTinhNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxGioiTinhNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        txtDienThoaiNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtEmailNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateNgaySinhNV.setBackground(new java.awt.Color(204, 255, 255));
        jDateNgaySinhNV.setDateFormatString("dd/MM/yyyy");
        jDateNgaySinhNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Chức vụ:");

        txtChucVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Tên đăng nhập:");

        txtTenDangNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelTTNhanVienLayout = new javax.swing.GroupLayout(jPanelTTNhanVien);
        jPanelTTNhanVien.setLayout(jPanelTTNhanVienLayout);
        jPanelTTNhanVienLayout.setHorizontalGroup(
            jPanelTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTTNhanVienLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(jPanelTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTTNhanVienLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1026, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelTTNhanVienLayout.createSequentialGroup()
                        .addGroup(jPanelTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelTTNhanVienLayout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(10, 10, 10)
                                .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelTTNhanVienLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelTTNhanVienLayout.createSequentialGroup()
                                        .addComponent(jDateNgaySinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxGioiTinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addGroup(jPanelTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelTTNhanVienLayout.createSequentialGroup()
                                .addComponent(txtDienThoaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(122, 122, 122))
        );
        jPanelTTNhanVienLayout.setVerticalGroup(
            jPanelTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTTNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTTNhanVienLayout.createSequentialGroup()
                        .addGroup(jPanelTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel38)
                            .addComponent(txtDienThoaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelTTNhanVienLayout.createSequentialGroup()
                        .addGroup(jPanelTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel29)
                            .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanelTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel32)
                        .addComponent(jLabel35)
                        .addComponent(jComboBoxGioiTinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateNgaySinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jtableNhanVien.setAutoCreateRowSorter(true);
        jtableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Chức Vụ", "Giới Tính", "Ngày Sinh", "Điện Thoại", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableNhanVienMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jtableNhanVien);

        txtTimKiemNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiemNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemNVKeyPressed(evt);
            }
        });

        jButtonTimKiemNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonTimKiemNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/timkiem16.png"))); // NOI18N
        jButtonTimKiemNV.setText("Tìm Kiếm");
        jButtonTimKiemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemNVActionPerformed(evt);
            }
        });

        jButtonThemNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonThemNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/them.png"))); // NOI18N
        jButtonThemNV.setText("Thêm");
        jButtonThemNV.setToolTipText("Thêm mới 1 nhân viên.");
        jButtonThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemNVActionPerformed(evt);
            }
        });

        jButtonCapNhatNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCapNhatNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua.png"))); // NOI18N
        jButtonCapNhatNV.setText("Sửa");
        jButtonCapNhatNV.setToolTipText("Chọn 1 nhân viên rồi Sửa.");
        jButtonCapNhatNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCapNhatNVActionPerformed(evt);
            }
        });

        jButtonXoaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonXoaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/xoa.png"))); // NOI18N
        jButtonXoaNV.setText("Xóa ");
        jButtonXoaNV.setToolTipText("Chọn 1 nhân viên rồi Xóa.");
        jButtonXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaNVActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/nhapmoi.png"))); // NOI18N
        jButton1.setText("Nhập Mới");
        jButton1.setToolTipText("Nhập mới toàn bộ thông tin");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabNhanVienLayout = new javax.swing.GroupLayout(tabNhanVien);
        tabNhanVien.setLayout(tabNhanVienLayout);
        tabNhanVienLayout.setHorizontalGroup(
            tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTTNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane9)
            .addGroup(tabNhanVienLayout.createSequentialGroup()
                .addGroup(tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabNhanVienLayout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jButtonThemNV)
                        .addGap(122, 122, 122)
                        .addComponent(jButtonCapNhatNV)
                        .addGap(116, 116, 116)
                        .addComponent(jButtonXoaNV)
                        .addGap(108, 108, 108)
                        .addComponent(jButton1))
                    .addGroup(tabNhanVienLayout.createSequentialGroup()
                        .addGap(821, 821, 821)
                        .addComponent(txtTimKiemNV)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabNhanVienLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButtonCapNhatNV, jButtonThemNV, jButtonXoaNV});

        tabNhanVienLayout.setVerticalGroup(
            tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabNhanVienLayout.createSequentialGroup()
                .addComponent(jPanelTTNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCapNhatNV, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonXoaNV)
                    .addComponent(jButton1)
                    .addComponent(jButtonThemNV))
                .addGap(22, 22, 22)
                .addGroup(tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTimKiemNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
        );

        tabNhanVienLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButtonCapNhatNV, jButtonThemNV, jButtonXoaNV});

        jTabbedMain.addTab("Nhân viên ", new javax.swing.ImageIcon(getClass().getResource("/Icon/nhanvien.png")), tabNhanVien); // NOI18N

        jPanel10.setBackground(new java.awt.Color(255, 255, 204));

        jtableViPham.setAutoCreateRowSorter(true);
        jtableViPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtableViPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableViPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtableViPham);

        jButtonTimKiemVP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonTimKiemVP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/timkiem16.png"))); // NOI18N
        jButtonTimKiemVP.setText("Tìm kiếm");
        jButtonTimKiemVP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemVPActionPerformed(evt);
            }
        });

        txtTimKiemVP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiemVP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemVPKeyPressed(evt);
            }
        });

        jButtonXuLyVP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonXuLyVP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/xulyvp.png"))); // NOI18N
        jButtonXuLyVP.setText("NỘP TIỀN");
        jButtonXuLyVP.setToolTipText("Chọn đối tượng sau đó ấn XỬ LÝ");
        jButtonXuLyVP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXuLyVPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtTimKiemVP, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonTimKiemVP))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(647, Short.MAX_VALUE)
                .addComponent(jButtonXuLyVP, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(581, 581, 581))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTimKiemVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTimKiemVP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonXuLyVP, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabViPhamLayout = new javax.swing.GroupLayout(tabViPham);
        tabViPham.setLayout(tabViPhamLayout);
        tabViPhamLayout.setHorizontalGroup(
            tabViPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabViPhamLayout.setVerticalGroup(
            tabViPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedMain.addTab("Vi phạm ", new javax.swing.ImageIcon(getClass().getResource("/Icon/vipham.png")), tabViPham); // NOI18N

        jPanel13.setBackground(new java.awt.Color(255, 204, 204));

        jPanel11.setBackground(new java.awt.Color(204, 204, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Quy định"));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("* Số đồ án tối đa sinh viên có thể mượn về nhà: ");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("* Hạn sử dụng thẻ sinh viên:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("* Mất bản cứng đồ án: Tiền phạt =");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("* Mượn quá hạn: Tiền phạt =");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Số ngày quá hạn * 2000vnđ/ngày");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Giá bản cứng * 2");

        jLabelHanThe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHanThe.setText("5 Năm");

        jLabelSachToiDa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSachToiDa.setText("3 Đồ Án");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("* Thời gian mượn tối đa:");

        jLabelMuonTD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMuonTD.setText("14 Ngày");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMuonTD))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelSachToiDa))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHanThe))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabelSachToiDa))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabelHanThe))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel33))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelMuonTD))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(450, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(392, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabThongTinLayout = new javax.swing.GroupLayout(tabThongTin);
        tabThongTin.setLayout(tabThongTinLayout);
        tabThongTinLayout.setHorizontalGroup(
            tabThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabThongTinLayout.setVerticalGroup(
            tabThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedMain.addTab("Thông tin ", new javax.swing.ImageIcon(getClass().getResource("/Icon/thongtin.png")), tabThongTin); // NOI18N

        jLabelTenDN.setText("Tên đăng nhập");

        jLabelDangXuat.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabelDangXuat.setForeground(new java.awt.Color(255, 0, 51));
        jLabelDangXuat.setText("Đăng xuất");
        jLabelDangXuat.setToolTipText("Đăng xuất tài khoản.");
        jLabelDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDangXuatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedMain, javax.swing.GroupLayout.PREFERRED_SIZE, 1365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDangXuat)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTenDN)
                    .addComponent(jLabelDangXuat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedMain))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTimKiemDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemDocGiaActionPerformed
        docgiaManager.loadDataDocGiaFromDB(jtableDocGia,txtTimKiemDocGia.getText());
        jButtonSuaDocGia.setEnabled(false);
        jButtonXoaDocGia.setEnabled(false);
    }//GEN-LAST:event_jButtonTimKiemDocGiaActionPerformed

    private void jButtonThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemNVActionPerformed
        String date = new SimpleDateFormat("yyyy-MM-dd").format(jDateNgaySinhNV.getDate());
        if (txtTenNhanVien.getText().length()==0||
                txtChucVu.getText().length()==0||txtDienThoaiNV.getText().length()==0||
                txtEmailNV.getText().length()==0|| txtTenDangNhap.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin", "Thông báo", 2);
        } else {
            NhanVien nhanVien= new NhanVien();
            nhanVien.setTenNhanVien(txtTenNhanVien.getText());
            nhanVien.setChucVu(txtChucVu.getText());
            nhanVien.setGioiTinh(jComboBoxGioiTinhNV.getSelectedItem().toString());
            nhanVien.setNgaySinh(date);                
            nhanVien.setDienThoai(txtDienThoaiNV.getText());
            nhanVien.setEmail(txtEmailNV.getText()); 
            nhanVien.setTenDangNhap(txtTenDangNhap.getText()); 

            nhanvienManager.themNhanVien(nhanVien);
            NhapMoiNV(); 
            
        }
    }//GEN-LAST:event_jButtonThemNVActionPerformed

    private void jButtonXoaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaSachActionPerformed
        int table_click_id;
        int row = jtableSach.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Chưa Chọn Sách Cần Xóa !");
        } else if (row != -1) {
            int yesOrNo = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Xóa Sách Không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
            if (yesOrNo == JOptionPane.YES_OPTION) {
                table_click_id = (int) jtableSach.getModel().getValueAt(row, 0);
                sachManager.xoaSach(table_click_id);
                NhapMoiSach();
                jButtonXoaSach.setEnabled(false);
                jButtonSuaSach.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jButtonXoaSachActionPerformed

    private void jButtonThemDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemDocGiaActionPerformed
        if (txtTenDocGia.getText().length()==0||txtDienThoai.getText().length()==0||
                txtDiaChi.getText().length()==0||txtEmail.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin", "Thông báo", 2);
        } else {
            String ngaySinh = new SimpleDateFormat("yyyy-MM-dd").format(jDateNgaySinh.getDate());
            String ngayLapThe = new SimpleDateFormat("yyyy-MM-dd").format(jDateNgayLapThe.getDate());
            SinhVien docGia= new SinhVien();
            docGia.setTenDocGia(txtTenDocGia.getText());
            docGia.setNgaySinh(ngaySinh);
            docGia.setGioiTinh(jComboBoxGioiTinh.getSelectedItem().toString());
            docGia.setDiaChi(txtDiaChi.getText());
            docGia.setEmail(txtEmail.getText());
            docGia.setDienThoai(txtDienThoai.getText());
            docGia.setNgayLapThe(ngayLapThe);
            
            if(docgiaManager.themDocGia(docGia)){
                JOptionPane.showMessageDialog(null, "Đã thêm Độc giả thành công!" , "Thông báo", 1);
            }else JOptionPane.showMessageDialog(null, "Lỗi chưa được thêm" , "Thông báo", 2); 
            NhapMoiDocGia();
            jButtonSuaDocGia.setEnabled(false);
            jButtonXoaDocGia.setEnabled(false);
            docgiaManager.loadDataDocGiaMTFromDB(jtableDocGiaMT,txtTimKiemDGMT.getText());
        }
    }//GEN-LAST:event_jButtonThemDocGiaActionPerformed

    private void jButtonSuaDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaDocGiaActionPerformed
        if (txtTenDocGia.getText().length()==0||txtDienThoai.getText().length()==0||
                txtDiaChi.getText().length()==0||txtEmail.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin", "Thông báo", 2);
        } else {
            String ngaySinh = new SimpleDateFormat("yyyy-MM-dd").format(jDateNgaySinh.getDate()); 
            String ngayLapThe = new SimpleDateFormat("yyyy-MM-dd").format(jDateNgayLapThe.getDate());
            int row = jtableDocGia.getSelectedRow();         
            if (row < 0) {
            JOptionPane.showMessageDialog(null, "Chưa Chọn Độc giả Cần Sửa !");
            } else {
                int table_click_id = (int) jtableDocGia.getModel().getValueAt(row, 0);
                SinhVien docGia= new SinhVien();
                docGia.setMaDocGia(table_click_id );
                docGia.setTenDocGia(txtTenDocGia.getText());
                docGia.setNgaySinh(ngaySinh);
                docGia.setGioiTinh(jComboBoxGioiTinh.getSelectedItem().toString());
                docGia.setDiaChi(txtDiaChi.getText());
                docGia.setEmail(txtEmail.getText());
                docGia.setDienThoai(txtDienThoai.getText());  
                docGia.setNgayLapThe(ngayLapThe);

                if(docgiaManager.suaDocGia(docGia)){
                    JOptionPane.showMessageDialog(null, "Đã sửa thành công!" , "Thông báo", 1);
                    NhapMoiDocGia();
                    jButtonSuaDocGia.setEnabled(false);
                    jButtonXoaDocGia.setEnabled(false);
                    docgiaManager.loadDataDocGiaMTFromDB(jtableDocGiaMT,txtTimKiemDGMT.getText());
                }else JOptionPane.showMessageDialog(null, "Có lỗi xảy ra", "Thông báo", 2);
            }
        }
    }//GEN-LAST:event_jButtonSuaDocGiaActionPerformed

    private void jtableDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableDocGiaMouseClicked
        int row = jtableDocGia.getSelectedRow();
        if(row!= -1){
            String tenDocGia= (String) jtableDocGia.getModel().getValueAt(row, 1);
            String ngaySinh= (String) jtableDocGia.getModel().getValueAt(row, 2);
            String gioiTinh = (String) jtableDocGia.getModel().getValueAt(row, 3);
            String diaChi=(String) jtableDocGia.getModel().getValueAt(row, 4);
            String email=(String) jtableDocGia.getModel().getValueAt(row, 5);
            String dienThoai= (String) jtableDocGia.getModel().getValueAt(row, 6);
            String ngayLapThe= (String) jtableDocGia.getModel().getValueAt(row, 7);
            
            txtTenDocGia.setText(tenDocGia);             

             java.util.Date dateNS = null;
             java.util.Date dateNLT = null;
            try {
                dateNS = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinh);// truyền đúng định dạng ngày trên bảng
                dateNLT = new SimpleDateFormat("yyyy-MM-dd").parse(ngayLapThe);
            } catch (ParseException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            jDateNgaySinh.setDate(dateNS); 
            jDateNgayLapThe.setDate(dateNLT);
            for (int i=0; i< jComboBoxGioiTinh.getItemCount(); i++) {
                if (jComboBoxGioiTinh.getItemAt(i).equalsIgnoreCase(gioiTinh)) {
                    jComboBoxGioiTinh.setSelectedIndex(i);
                    break;
                }
            }
            txtDiaChi.setText(diaChi);
            txtEmail.setText(email);
            txtDienThoai.setText(dienThoai);
            jButtonSuaDocGia.setEnabled(true);
            jButtonXoaDocGia.setEnabled(true);
        }
    }//GEN-LAST:event_jtableDocGiaMouseClicked

    private void jButtonSuaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaSachActionPerformed
        String date = new SimpleDateFormat("yyyy-MM-dd").format(jDateNgayNhap.getDate());        
        int row = jtableSach.getSelectedRow();         
        if (row < 0) {
           JOptionPane.showMessageDialog(null, "Chưa Chọn Sách Cần Sửa !");
        } else if (txtTenSach.getText().length()==0||txtTacGia.getText().length()==0||
                txtNhaXuatBan.getText().length()==0||txtNamXuatBan.getText().length()==0||
                (Integer)spinnerSoTrang.getValue() <=0||(Integer)spinnerSoLuong.getValue()<=0||
                txtGiaTien.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin", "Thông báo", 2);
        } else {
            int   table_click_id = (int) jtableSach.getModel().getValueAt(row, 0);
            DoAn sach= new DoAn();
            sach.setMaSach(table_click_id );
            sach.setTenSach(txtTenSach.getText());
            sach.setTheLoai(jComboBoxTheLoai.getSelectedItem().toString());
            sach.setTacGia(txtTacGia.getText());
            sach.setNhaXuatBan(txtNhaXuatBan.getText());
            sach.setNamXuatBan(Integer.parseInt(txtNamXuatBan.getText()));
            sach.setNgayNhap(date);
            sach.setNgonNgu(txtNgonNgu.getText());
            sach.setSoTrang((Integer)spinnerSoTrang.getValue());
            sach.setSoLuong((Integer)spinnerSoLuong.getValue());
            sach.setGiaTien(Integer.parseInt(txtGiaTien.getText()));                
               
            if(sachManager.suaSach(sach)){
                JOptionPane.showMessageDialog(null, "Đã sửa Sách thành công!" , "Thông báo", 1);
            }else JOptionPane.showMessageDialog(null, "Có lỗi xảy ra", "Thông báo", 2);
            NhapMoiSach();
            jButtonSuaSach.setEnabled(false);
            jButtonXoaSach.setEnabled(false);
        }    
    }//GEN-LAST:event_jButtonSuaSachActionPerformed

    private void jButtonNhapMoiDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNhapMoiDocGiaActionPerformed
        NhapMoiDocGia();
        jButtonSuaDocGia.setEnabled(false);
        jButtonXoaDocGia.setEnabled(false);
    }//GEN-LAST:event_jButtonNhapMoiDocGiaActionPerformed

    private void jButtonXoaDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaDocGiaActionPerformed
         int table_click_id;
      int row = jtableDocGia.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Chưa Chọn Độc Giả Cần Sửa !");
        } else if (row != -1) {
            int yesOrNo = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Xóa Độc Giả", "Thông Báo", JOptionPane.YES_NO_OPTION);
            if (yesOrNo == JOptionPane.YES_OPTION) {
                table_click_id = (int) jtableDocGia.getModel().getValueAt(row, 0);
                docgiaManager.xoaDocGia(table_click_id);
                NhapMoiDocGia();
                jButtonXoaDocGia.setEnabled(false);
                jButtonSuaDocGia.setEnabled(false);
                docgiaManager.loadDataDocGiaMTFromDB(jtableDocGiaMT,txtTimKiemDGMT.getText());
            }
        }

                
    }//GEN-LAST:event_jButtonXoaDocGiaActionPerformed

    private void jButtonThemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemSachActionPerformed
        String date = new SimpleDateFormat("yyyy-MM-dd").format(jDateNgayNhap.getDate());

        if (txtTenSach.getText().length()==0||txtTacGia.getText().length()==0||
                txtNhaXuatBan.getText().length()==0||txtNamXuatBan.getText().length()==0||
                (Integer)spinnerSoTrang.getValue() <=0||(Integer)spinnerSoLuong.getValue()<=0||
                txtGiaTien.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin", "Thông báo", 2);
        } else {
            DoAn sach= new DoAn();
            sach.setTenSach(txtTenSach.getText());
            sach.setTheLoai(jComboBoxTheLoai.getSelectedItem().toString());                
            sach.setTacGia(txtTacGia.getText());
            sach.setNhaXuatBan(txtNhaXuatBan.getText());
            sach.setNamXuatBan(Integer.parseInt(txtNamXuatBan.getText()));
            sach.setNgayNhap(date);
            sach.setNgonNgu(txtNgonNgu.getText());
            sach.setSoTrang((Integer)spinnerSoTrang.getValue());
            sach.setSoLuong((Integer)spinnerSoLuong.getValue());
            sach.setGiaTien(Integer.parseInt(txtGiaTien.getText()));
            if(sachManager.themSach(sach)){
                JOptionPane.showMessageDialog(null, "Đã thêm Sách thành công!" , "Thông báo", 1);
            }else JOptionPane.showMessageDialog(null, "Có lỗi xảy ra", "Thông báo", 2);
            NhapMoiSach();  
            jButtonSuaSach.setEnabled(false);
            jButtonXoaSach.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonThemSachActionPerformed

    private void jtableSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableSachMouseClicked
        int row = jtableSach.getSelectedRow();
        if(row!= -1){
            String tenSach= (String) jtableSach.getModel().getValueAt(row, 1);        
            String theLoai= (String) jtableSach.getModel().getValueAt(row, 2);       
            String tacGia = (String) jtableSach.getModel().getValueAt(row, 4);
            String nhaXuatBan=(String) jtableSach.getModel().getValueAt(row, 5);
            int namXuatBan=(int) jtableSach.getModel().getValueAt(row, 6);
            String ngayNhap= (String) jtableSach.getModel().getValueAt(row, 7);
            String ngonNgu=(String) jtableSach.getModel().getValueAt(row, 8);
            int soTrang=(int) jtableSach.getModel().getValueAt(row, 9);
            int soLuong=(int) jtableSach.getModel().getValueAt(row, 10);
            int giaTien=(int) jtableSach.getModel().getValueAt(row, 11);

            txtTenSach.setText(tenSach);
            boolean theLoaiKhac = true;
            for (int i=0; i<jComboBoxTheLoai.getItemCount(); i++) {
                if (jComboBoxTheLoai.getItemAt(i).equalsIgnoreCase(theLoai)) {
                    jComboBoxTheLoai.setSelectedIndex(i);
                    theLoaiKhac = false;
                    break;
                }
            }
            //nếu thể loại sách trong csdl khác với các lựa chọn thì set là thể loại khác(item 7)
            if(theLoaiKhac)jComboBoxTheLoai.setSelectedIndex(7);

            txtTacGia.setText(tacGia);
            txtNhaXuatBan.setText(nhaXuatBan);
            txtNamXuatBan.setText(namXuatBan + "");     

            java.util.Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(ngayNhap);// truyền đúng định dạng ngày trên bảng           
            } catch (ParseException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            jDateNgayNhap.setDate(date);  
            txtNgonNgu.setText(ngonNgu);
            spinnerSoTrang.setValue(Integer.valueOf(soTrang));
            spinnerSoLuong.setValue(Integer.valueOf(soLuong));
            txtGiaTien.setText(giaTien+"");
            
            jButtonSuaSach.setEnabled(true);
            jButtonXoaSach.setEnabled(true);
        }
    }//GEN-LAST:event_jtableSachMouseClicked

    private void jButtonNhapMoiSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNhapMoiSachActionPerformed
        NhapMoiSach();
        jButtonSuaSach.setEnabled(false);
        jButtonXoaSach.setEnabled(false);
    }//GEN-LAST:event_jButtonNhapMoiSachActionPerformed

    private void jButtonTimKiemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemSachActionPerformed
        sachManager.loadDataSachFromDB(jtableSach,txtTimKiemSach.getText());
        jButtonSuaSach.setEnabled(false);
        jButtonXoaSach.setEnabled(false);
    }//GEN-LAST:event_jButtonTimKiemSachActionPerformed

    private void jButtonCapNhatNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCapNhatNVActionPerformed
        String date = new SimpleDateFormat("yyyy-MM-dd").format(jDateNgaySinhNV.getDate());        
        
        int row = jtableNhanVien.getSelectedRow();         
        if (row < 0) {
           JOptionPane.showMessageDialog(null, "Chưa Chọn Nhân Viên Cần Sửa !");
        } else if (txtTenNhanVien.getText().length()==0||
            txtChucVu.getText().length()==0||txtDienThoaiNV.getText().length()==0||
            txtEmailNV.getText().length()==0|| txtTenDangNhap.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin", "Thông báo", 2);
        } else {
            int   table_click_id = (int) jtableNhanVien.getModel().getValueAt(row, 0);
                NhanVien nhanVien= new NhanVien();
                nhanVien.setMaNhanVien(table_click_id );
                nhanVien.setTenNhanVien(txtTenNhanVien.getText());
                nhanVien.setChucVu(txtChucVu.getText());
                nhanVien.setNgaySinh(date);
                nhanVien.setGioiTinh(jComboBoxGioiTinhNV.getSelectedItem().toString());
                nhanVien.setDienThoai(txtDienThoaiNV.getText());
                nhanVien.setEmail(txtEmailNV.getText());             
                nhanVien.setTenDangNhap(txtTenDangNhap.getText());                
                if(nhanvienManager.suaNhanVien(nhanVien)){
                    JOptionPane.showMessageDialog(null, "Đã sửa thành công!" , "Thông báo", 1);
                    NhapMoiNV();
                    jButtonXoaNV.setEnabled(false);
                    jButtonCapNhatNV.setEnabled(false);
                }else JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!" , "Thông báo", 2);
                
        }
    }//GEN-LAST:event_jButtonCapNhatNVActionPerformed

    private void jButtonXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaNVActionPerformed
        int table_click_id;
        int row = jtableNhanVien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Chưa Chọn Nhân Viên Cần Xóa!");
        } else if (row != -1) {
            int yesOrNo = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Xóa Nhân Viên", "Thông Báo", JOptionPane.YES_NO_OPTION);
            if (yesOrNo == JOptionPane.YES_OPTION) {
                table_click_id = (int) jtableNhanVien.getModel().getValueAt(row, 0);
                nhanvienManager.xoaNhanVien(table_click_id);
                NhapMoiNV();
                jButtonXoaNV.setEnabled(false);
                jButtonCapNhatNV.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jButtonXoaNVActionPerformed

    private void jtableNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableNhanVienMouseClicked
        int row = jtableNhanVien.getSelectedRow();
        if(row!= -1){
            String tenNhanVien= (String) jtableNhanVien.getModel().getValueAt(row, 1);
            String chucVu= (String) jtableNhanVien.getModel().getValueAt(row, 2);
            String gioiTinh = (String) jtableNhanVien.getModel().getValueAt(row, 3);
            String ngaySinhNV = (String) jtableNhanVien.getModel().getValueAt(row, 4);
            String dienThoaiNV= (String) jtableNhanVien.getModel().getValueAt(row, 5);
            String emailNV=(String) jtableNhanVien.getModel().getValueAt(row, 6);
            String tenDangNhap=(String) jtableNhanVien.getModel().getValueAt(row, 7);

            txtTenNhanVien.setText(tenNhanVien);
            txtChucVu.setText(chucVu);
            for (int i=0; i<jComboBoxGioiTinhNV.getItemCount(); i++) {
                if (jComboBoxGioiTinhNV.getItemAt(i).equalsIgnoreCase(gioiTinh)) {
                    jComboBoxGioiTinhNV.setSelectedIndex(i);
                    break;
                }
            }

            java.util.Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinhNV.toString());// truyền đúng định dạng ngày trên bảng
            } catch (ParseException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            jDateNgaySinhNV.setDate(date);  
            txtDienThoaiNV.setText(dienThoaiNV);
            txtEmailNV.setText(emailNV); 
            txtTenDangNhap.setText(tenDangNhap);
            jButtonXoaNV.setEnabled(true);
            jButtonCapNhatNV.setEnabled(true);
        }
    }//GEN-LAST:event_jtableNhanVienMouseClicked

    private void jButtonTimKiemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemNVActionPerformed
        nhanvienManager.loadDataNhanVienFromDB(jtableNhanVien,txtTimKiemNV.getText());
    }//GEN-LAST:event_jButtonTimKiemNVActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        NhapMoiNV();
        jButtonXoaNV.setEnabled(false);
        jButtonCapNhatNV.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonTimKiemDGMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemDGMTActionPerformed
        docgiaManager.loadDataDocGiaMTFromDB(jtableDocGiaMT,txtTimKiemDGMT.getText());
    }//GEN-LAST:event_jButtonTimKiemDGMTActionPerformed

    private void jTimkiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTimkiem1ActionPerformed
        int row = jtableDocGiaMT.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Chưa chọn độc giả!");
        } else {
            String maDG= jtableDocGiaMT.getModel().getValueAt(row, 0).toString();
            int[] mangMaSach = new int[jtableSachChon.getRowCount()];//mảng chứa mã sách trong jtableSachChon.
            for(int i= 0; i< jtableSachChon.getRowCount(); i++){
                mangMaSach[i] = (int) jtableSachChon.getModel().getValueAt(i,0);
            }
            sachManager.loadDataSachMuonFromDB(jtableSachMT,txtTimKiemSachMT.getText(), mangMaSach, maDG);
        }
    }//GEN-LAST:event_jTimkiem1ActionPerformed

    private void jRMuonsachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRMuonsachActionPerformed
        int[] mangNull = new int[]{};// để load danh sách sách ban đầu.
        int row = jtableDocGiaMT.getSelectedRow();
        ((DefaultTableModel)jtableSachMT.getModel()).setRowCount(0);
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Độc Giả!");
        }else {
            String maDG= jtableDocGiaMT.getModel().getValueAt(row, 0).toString();
            jTimkiem1.setEnabled(true); 
            txtTimKiemSachMT.setEnabled(true);
            sachManager.loadDataSachMuonFromDB(jtableSachMT,txtTimKiemSachMT.getText(), mangNull, maDG);
            jLabelTitleSachChon.setText("Danh sách sách mượn");
            ((DefaultTableModel)jtableSachChon.getModel()).setRowCount(0);
            jButtonBaoMat.setEnabled(false);
        }
    }//GEN-LAST:event_jRMuonsachActionPerformed

    private void jRTrasachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRTrasachActionPerformed
        jTimkiem1.setEnabled(false); 
        txtTimKiemSachMT.setEnabled(false);
        int row = jtableDocGiaMT.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Độc Giả!");
        }else {
            int maDG= (int) jtableDocGiaMT.getModel().getValueAt(row, 0);
            muontraManager.loadDataTraSachFromDB(jtableSachMT,maDG);
        }
        jLabelTitleSachChon.setText("Danh sách sách trả");
        ((DefaultTableModel)jtableSachChon.getModel()).setRowCount(0);//Xóa tất cả các dòng trong bảng jtableSachChon
    }//GEN-LAST:event_jRTrasachActionPerformed

    private void jbuttonChonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonChonSachActionPerformed
        int rowMT = jtableDocGiaMT.getSelectedRow();
        if (rowMT == -1) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Độc Giả!");
        }else {
            int[] indexs = jtableSachMT.getSelectedRows();        
            Object[] row = new Object[7];
            TableModel model1 = jtableSachMT.getModel();
            DefaultTableModel model2 = (DefaultTableModel) jtableSachChon.getModel();
            DefaultTableModel model3 = (DefaultTableModel) jtableSachMT.getModel();
            if (jRTrasach.isSelected()){        //set tiêu đề mới khi chọn chế độ trả sách
                String[] colTieuDe = new String[]{ "MÃ MƯỢN TRẢ","MÃ SINH VIÊN", "TÊN SINH VIÊN",
                "MÃ ĐỒ ÁN", "TÊN ĐỒ ÁN",  "NGÀY MƯỢN", "HẠN TRẢ" };
                model2.setColumnIdentifiers(colTieuDe);
                this.jButtonBaoMat.setEnabled(true); 
            } else if (jRMuonsach.isSelected()){        //set tiêu đề mới khi chọn chế độ mượn sách
                String[] colTieuDe = new String[]{ "MÃ ĐỒ ÁN", "TÊN ĐỒ ÁN", "LOẠI ĐỒ ÁN", "NGÔN NGỮ",
                 "SINH VIÊN THỰC HIỆN ĐỒ ÁN", "NỚI QUẢN LÝ ĐỒ ÁN", "GIÁ TIỀN BẢN CỨNG" };
                model2.setColumnIdentifiers(colTieuDe);
            }

            for(int i = 0; i < indexs.length; i++) {
                row[0] = model1.getValueAt(indexs[i], 0);
                row[1] = model1.getValueAt(indexs[i], 1);
                row[2] = model1.getValueAt(indexs[i], 2);
                row[3] = model1.getValueAt(indexs[i], 3);
                row[4] = model1.getValueAt(indexs[i], 4);
                row[5] = model1.getValueAt(indexs[i], 5);
                row[6] = model1.getValueAt(indexs[i], 6);
                model2.addRow(row);
            }
            for(int i = 0; i < indexs.length; i++) {
                model3.removeRow(indexs[i]-i);
            }
        }
        jbuttonChonSach.setEnabled(false);
        if (jRMuonsach.isSelected()){
            if(jtableSachChon.getRowCount() + Integer.parseInt(jLabelDangMuon.getText()) > SACH_TOI_DA){
                JOptionPane.showMessageDialog(null, "Vượt quá số sách cho phép mượn. \nBạn cần bỏ bớt sách!", "Thông báo", 2);
            }
        }
    }//GEN-LAST:event_jbuttonChonSachActionPerformed

    private void jtableDocGiaMTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableDocGiaMTMouseClicked
        int row = jtableDocGiaMT.getSelectedRow();
        int maDG= (int) jtableDocGiaMT.getModel().getValueAt(row, 0);
        int tongmuon = muontraManager.demMuonTra(maDG + "");
        jLabelDangMuon.setText(tongmuon + "");
        ((DefaultTableModel)jtableSachMT.getModel()).setRowCount(0);
        if (jRTrasach.isSelected()){
            muontraManager.loadDataTraSachFromDB(jtableSachMT,maDG);
            ((DefaultTableModel)jtableSachChon.getModel()).setRowCount(0);
        }else if(jRMuonsach.isSelected()){
            int[] mangNull = new int[]{};
            ((DefaultTableModel)jtableSachChon.getModel()).setRowCount(0);
            sachManager.loadDataSachMuonFromDB(jtableSachMT,txtTimKiemSachMT.getText(),mangNull, maDG + "");
        }
    }//GEN-LAST:event_jtableDocGiaMTMouseClicked

    private void jbuttonBoSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonBoSachActionPerformed
        int rowSelected = jtableSachChon.getSelectedRow();
        DefaultTableModel model1 = (DefaultTableModel) jtableSachChon.getModel();
        DefaultTableModel model2 = (DefaultTableModel) jtableSachMT.getModel();
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Sách Cần Bỏ!");
        }else {
            if(jRMuonsach.isSelected()){
                model1.removeRow(rowSelected);
                int[] mangMaSach = new int[jtableSachChon.getRowCount()];
                for(int i= 0; i< jtableSachChon.getRowCount(); i++){
                    mangMaSach[i] = (int) jtableSachChon.getModel().getValueAt(i,0);
                }
                int row = jtableDocGiaMT.getSelectedRow();
                String maDG= jtableDocGiaMT.getModel().getValueAt(row, 0).toString();
                sachManager.loadDataSachMuonFromDB(jtableSachMT,txtTimKiemSachMT.getText(), mangMaSach, maDG);
            }else {
                Object[] row = new Object[7];
                row[0] = jtableSachChon.getModel().getValueAt(rowSelected, 0);
                row[1] = jtableSachChon.getModel().getValueAt(rowSelected, 1);
                row[2] = jtableSachChon.getModel().getValueAt(rowSelected, 2);
                row[3] = jtableSachChon.getModel().getValueAt(rowSelected, 3);
                row[4] = jtableSachChon.getModel().getValueAt(rowSelected, 4);
                row[5] = jtableSachChon.getModel().getValueAt(rowSelected, 5);
                row[6] = jtableSachChon.getModel().getValueAt(rowSelected, 6);
                model2.addRow(row);
                model1.removeRow(rowSelected);
                if(jtableSachChon.getRowCount() == 0){
                    this.jButtonBaoMat.setEnabled(false);  
                }
            }
        }
        this.jbuttonBoSach.setEnabled(false);
    }//GEN-LAST:event_jbuttonBoSachActionPerformed

    private void jBMuontraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMuontraActionPerformed
        Date ngayMuonTra = new java.sql.Date(jDateNgayMT.getDate().getTime()); 
        int row = jtableDocGiaMT.getSelectedRow();
        if(jtableSachChon.getRowCount()==0|| row == -1){
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn sách hoặt độc giả!" , "Thông báo", 1);
        }else {
            int maDocGia= (int) jtableDocGiaMT.getModel().getValueAt(row, 0);
            Date ngayHetHanDG= Date.valueOf((String)jtableDocGiaMT.getModel().getValueAt(row, 4));
            if(jRMuonsach.isSelected()){
                if(ngayMuonTra.before(ngayHetHanDG)){// kiểm tra thẻ còn hạn mượn sách.
                    if((jtableSachChon.getRowCount() + Integer.parseInt(jLabelDangMuon.getText())) > SACH_TOI_DA){
                        JOptionPane.showMessageDialog(null, "Vượt quá số sách cho phép mượn. \nBạn cần bỏ bớt sách!", "Thông báo", 2);
                    }else{
                        int maNV = Login.maNV;
                        boolean check = false;
                        int maPhieu = muontraManager.getMaPhieu();
                        for(int i=0; i < jtableSachChon.getRowCount();i++){
                            MuonTra muonTra = new MuonTra();
                            muonTra.setMaPhieu(maPhieu);
                            muonTra.setMaDocGia(maDocGia);
                            muonTra.setMaNhanVien(maNV);
                            muonTra.setNgayMuon(ngayMuonTra);
                            muonTra.setMaSach((int) jtableSachChon.getModel().getValueAt(i,0));
                            check = muontraManager.themMuonTra(muonTra);
                        }
                        muontraManager.loadDataMuonTraFromDB(jtableMuonTra,txtTimKiemMT.getText());
                        int tongmuon = muontraManager.demMuonTra(maDocGia+"");
                        jLabelDangMuon.setText(tongmuon + "");
                        if(check){
                            JOptionPane.showMessageDialog(null, "Độc giả mượn sách thành công!" , "Thông báo", 1);
                            jButtonToDay.doClick();
                            ((DefaultTableModel)jtableSachChon.getModel()).setRowCount(0);//Xóa tất cả các dòng trong bảng jtableSachChon
                        }else JOptionPane.showMessageDialog(null, "Lỗi mượn sách!" , "Thông báo", 2);
                    }  
                }else {
                    JOptionPane.showMessageDialog(null, "Thẻ độc giả quá hạn cho phép mượn sách!", "Thông báo", 2);
                    ((DefaultTableModel)jtableSachChon.getModel()).setRowCount(0);//Xóa tất cả các dòng trong bảng jtableSachChon
                    jbuttonBoSach.setEnabled(false);
                }
            }else if(jRTrasach.isSelected()){
                boolean check = false;
                for(int i=0; i < jtableSachChon.getRowCount();i++){
                    MuonTra muonTra = new MuonTra();
                    int maMuonTra = (int) jtableSachChon.getModel().getValueAt(i,0);
                    muonTra.setNgayTra(ngayMuonTra);
                    muonTra.setMaMuonTra(maMuonTra);
                    check = muontraManager.traSach(muonTra); 
                }
                muontraManager.loadDataMuonTraFromDB(jtableMuonTra,txtTimKiemMT.getText());
                int tongMuon = muontraManager.demMuonTra(maDocGia+"");
                jLabelDangMuon.setText(tongMuon + "");
                muontraManager.loadDataTraSachFromDB(jtableSachMT,maDocGia);
                if(check){
                    JOptionPane.showMessageDialog(null, "Độc giả trả sách thành công!" , "Thông báo", 1);
                    jButtonToDay.doClick();
                } else JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!" , "Thông báo", 2);

                ((DefaultTableModel)jtableSachChon.getModel()).setRowCount(0);//Xóa tất cả các dòng trong bảng jtableSachChon
                jbuttonBoSach.setEnabled(false);
            } else{
                JOptionPane.showMessageDialog(null, "Bạn chưa chọn tác vụ mượn hoặc trả sách!", "Thông báo", 2);
            }
            sachManager.loadDataSachFromDB(jtableSach,txtTimKiemSach.getText());
        }
    }//GEN-LAST:event_jBMuontraActionPerformed

    private void jtableMuonTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMuonTraMouseClicked
        this.jButtonXoaMuon.setEnabled(true);
         
    }//GEN-LAST:event_jtableMuonTraMouseClicked

    private void jButtonXoaMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaMuonActionPerformed
        int row = jtableMuonTra.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Chưa chọn phiếu mượn cần xóa !");
        } else {
            int yesOrNo = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Xóa Thẻ Mượn Không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
            if (yesOrNo == JOptionPane.YES_OPTION) {
                int maMuonTra = (int) jtableMuonTra.getModel().getValueAt(row, 1);
                int maSach = (int) jtableMuonTra.getModel().getValueAt(row, 4);
                
                muontraManager.xoaMuonTra(maMuonTra, maSach);  
                muontraManager.loadDataMuonTraFromDB(jtableMuonTra,txtTimKiemMT.getText());
            }
        }
        jButtonXoaMuon.setEnabled(false);
        
    }//GEN-LAST:event_jButtonXoaMuonActionPerformed

    private void jButtonBaoMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBaoMatActionPerformed
        boolean check = false;
        if(jRTrasach.isSelected()){
            Date ngayTra = new java.sql.Date(jDateNgayMT.getDate().getTime()); 
            if(jtableSachChon.getRowCount()==0){
                JOptionPane.showMessageDialog(null, "Chưa chọn sách báo mất!" , "Thông báo", 1);
            }else {
                int yesOrNo = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Báo Mất Sách Không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
                if (yesOrNo == JOptionPane.YES_OPTION) {
                    for(int i=0; i < jtableSachChon.getRowCount();i++){
                        MuonTra muonTra = new MuonTra();
                        int maMuonTra = (int) jtableSachChon.getModel().getValueAt(i,0);
                        int maDocGia = (int) jtableSachChon.getModel().getValueAt(i,1);
                        int maSach = (int) jtableSachChon.getModel().getValueAt(i,3);
                        muonTra.setNgayTra(ngayTra);
                        muonTra.setMaMuonTra(maMuonTra);
                        muonTra.setMaDocGia(maDocGia);
                        muonTra.setMaSach(maSach);
                        check = muontraManager.baoMat(muonTra); 
                    }
                    muontraManager.loadDataMuonTraFromDB(jtableMuonTra,txtTimKiemMT.getText());
                    sachManager.loadDataSachFromDB(jtableSach,txtTimKiemSach.getText());
                    int row1 = jtableDocGiaMT.getSelectedRow();
                    int maDG= (int) jtableDocGiaMT.getModel().getValueAt(row1, 0);
                    int tongMuon = muontraManager.demMuonTra(jtableDocGiaMT.getModel().getValueAt(row1, 0).toString());
                    jLabelDangMuon.setText(tongMuon + "");

                    muontraManager.loadDataTraSachFromDB(jtableSachMT,maDG);
                    ((DefaultTableModel)jtableSachChon.getModel()).setRowCount(0);
                    if(check){
                        JOptionPane.showMessageDialog(null, "Đã thêm vi phạm!" , "Thông báo", 1);
                        viphamManager.loadDataViPhamFromDB(jtableViPham, txtTimKiemVP.getText());
                    } else JOptionPane.showMessageDialog(null, "Lỗi, chưa thể báo mất" , "Thông báo", 1); 
                }
            }
        }
        jButtonBaoMat.setEnabled(false);
    }//GEN-LAST:event_jButtonBaoMatActionPerformed

    private void jButtonTimKiemMT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemMT1ActionPerformed
        muontraManager.loadDataMuonTraFromDB(jtableMuonTra,txtTimKiemMT.getText());
    }//GEN-LAST:event_jButtonTimKiemMT1ActionPerformed

    private void jLabelDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDangXuatMouseClicked
        int yesOrNo = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Đăng Xuất Không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (yesOrNo == JOptionPane.YES_OPTION) {
            Login login = new Login();
            this.setVisible(false);
            login.setVisible(true);
        }
    }//GEN-LAST:event_jLabelDangXuatMouseClicked

    private void jButtonThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThongKeActionPerformed
        ThongKeManager thongKeManager = new ThongKeManager();
        Date ngayBD;
        Date ngayKT;
        java.util.Date toDay = new java.util.Date();
        Calendar c1 = Calendar.getInstance();
        c1.setTime(toDay);
        if(jRadioChonNgay.isSelected()){
            ngayBD = new java.sql.Date(jDateNgayBD.getDate().getTime()); 
            ngayKT = new java.sql.Date(jDateNgayKT.getDate().getTime()); 
        }else if(jRadioThang.isSelected()){
            c1.roll(Calendar.MONTH, -1);
            ngayBD = new java.sql.Date(c1.getTimeInMillis());
            ngayKT = new java.sql.Date(toDay.getTime());
        }else if(jRadioTuan.isSelected()){
            c1.add(Calendar.DATE, -7);
            ngayBD = new java.sql.Date(c1.getTimeInMillis());
            ngayKT = new java.sql.Date(toDay.getTime());
        }else {
            ngayBD = java.sql.Date.valueOf("1970-01-02");
            ngayKT = new java.sql.Date(toDay.getTime());
        }
        
        ArrayList<ThongKe> lstThongKe= new ArrayList();  
        String[] colTieuDe = new String[]{ "MÃ ĐỐI TƯỢNG","THỐNG KÊ", "SỐ LƯỢT MƯỢN" };
        if (jRadioDocGia.isSelected()){
            lstThongKe= thongKeManager.getDocGiaTK(ngayBD, ngayKT);
            colTieuDe = new String[]{ "MÃ ĐỘC GIẢ","TÊN ĐỘC GIẢ", "SỐ LƯỢT MƯỢN" };
        }else if (jRadioSach.isSelected()){
            lstThongKe= thongKeManager.getSachTK(ngayBD, ngayKT);
            colTieuDe = new String[]{ "MÃ SÁCH","TÊN SÁCH", "SỐ LƯỢT MƯỢN" };
        }else if (jRadioTheLoai.isSelected()){
            lstThongKe= thongKeManager.getTheLoaiTK(ngayBD, ngayKT);
            colTieuDe = new String[]{ "SỐ THỨ TỰ","THỂ LOẠI", "SỐ LƯỢT MƯỢN" };
        }else if (jRadioTacGia.isSelected()){
            lstThongKe= thongKeManager.getTacGiaTK(ngayBD, ngayKT);
            colTieuDe = new String[]{ "SỐ THỨ TỰ","TÁC GIẢ", "SỐ LƯỢT MƯỢN" };
        }else if (jRadioNXB.isSelected()){
            lstThongKe= thongKeManager.getNhaXuatBanTK(ngayBD, ngayKT);
            colTieuDe = new String[]{ "SỐ THỨ TỰ","NHÀ XUẤT BẢN", "SỐ LƯỢT MƯỢN" };
        }else if (jRadioSachHet.isSelected()){
            lstThongKe= thongKeManager.getSachHetTK();
            colTieuDe = new String[]{ "MÃ SÁCH","TÊN SÁCH", "SỐ LƯỢNG" };
        }
        
        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
        Object[] row;
        for (ThongKe tk : lstThongKe) {
            row = new Object[3];
            row[0] = tk.getMaDoiTuong();
            row[1] = tk.getThongKe();
            row[2] = tk.getSoLuong();
            model.addRow(row);
        }       
        jTableThongKe.setModel(model);
        
        if (jRadioViPham.isSelected()){
            thongKeManager.getDanhSachViPham(jTableThongKe,ngayBD, ngayKT);
        } else if(jRadioDGHetHan.isSelected()){
            thongKeManager.getDocGiaHetHan(jTableThongKe,ngayBD, ngayKT);
        }
    
    }//GEN-LAST:event_jButtonThongKeActionPerformed

    private void jRadioSachHetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioSachHetActionPerformed
     
    }//GEN-LAST:event_jRadioSachHetActionPerformed

    private void jtableSachMTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableSachMTMouseClicked
        if(jRMuonsach.isSelected()){
            int row = jtableDocGiaMT.getSelectedRow();
            Date ngayMuonTra = new java.sql.Date(jDateNgayMT.getDate().getTime()); 
            Date ngayHetHanDG= Date.valueOf((String)jtableDocGiaMT.getModel().getValueAt(row, 4));
            if((Integer.parseInt(jLabelDangMuon.getText()) + jtableSachChon.getRowCount() < SACH_TOI_DA) && ngayMuonTra.before(ngayHetHanDG)){ //sách mượn tối đa SACH_TOI_DA quyển 1 lần.
            jbuttonChonSach.setEnabled(true); 
            }else jbuttonChonSach.setEnabled(false); 
        } else jbuttonChonSach.setEnabled(true); 
    }//GEN-LAST:event_jtableSachMTMouseClicked

    private void jtableSachChonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableSachChonMouseClicked
        this.jbuttonBoSach.setEnabled(true);
    }//GEN-LAST:event_jtableSachChonMouseClicked

    private void txtTimKiemDGMTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemDGMTKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){ 
            jButtonTimKiemDGMT.doClick();
        }
    }//GEN-LAST:event_txtTimKiemDGMTKeyPressed

    private void txtTimKiemSachMTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSachMTKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){ 
            jTimkiem1.doClick();
        } 
    }//GEN-LAST:event_txtTimKiemSachMTKeyPressed

    private void txtTimKiemMTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemMTKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){ 
            jButtonTimKiemMT1.doClick();
        }
    }//GEN-LAST:event_txtTimKiemMTKeyPressed

    private void txtTimKiemSachKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSachKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){ 
            jButtonTimKiemSach.doClick();
        }
    }//GEN-LAST:event_txtTimKiemSachKeyPressed

    private void txtTimKiemDocGiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemDocGiaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){ 
            jButtonTimKiemDocGia.doClick();
        }
    }//GEN-LAST:event_txtTimKiemDocGiaKeyPressed

    private void txtTimKiemNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemNVKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){ 
            jButtonTimKiemNV.doClick();
        }
    }//GEN-LAST:event_txtTimKiemNVKeyPressed

    private void jButtonToDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonToDayActionPerformed
        java.util.Date toDay = new java.util.Date();
        jDateNgayMT.setDate(toDay);
    }//GEN-LAST:event_jButtonToDayActionPerformed

    private void jButtonXuLyVPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXuLyVPActionPerformed
        int row = jtableViPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Chưa chọn vi phạm cần xử lý!", "Thông báo", 2);
        } else {
            int maViPham= (int) jtableViPham.getModel().getValueAt(row, 0);
            if(viphamManager.xulyViPham(maViPham)){
                JOptionPane.showMessageDialog(null, "Đã xử lý vi phạm!", "Thông báo", 1);
                viphamManager.loadDataViPhamFromDB(jtableViPham, txtTimKiemVP.getText());
            } else JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!", "Thông báo", 2);
        }
        jButtonXuLyVP.setEnabled(false);
    }//GEN-LAST:event_jButtonXuLyVPActionPerformed

    private void jButtonTimKiemVPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemVPActionPerformed
        viphamManager.loadDataViPhamFromDB(jtableViPham, txtTimKiemVP.getText());
    }//GEN-LAST:event_jButtonTimKiemVPActionPerformed

    private void txtTimKiemVPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemVPKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){ 
            jButtonTimKiemVP.doClick();
        }
    }//GEN-LAST:event_txtTimKiemVPKeyPressed

    private void jRadioChonNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioChonNgayActionPerformed

    }//GEN-LAST:event_jRadioChonNgayActionPerformed

    private void jRadioToanThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioToanThoiGianActionPerformed

    }//GEN-LAST:event_jRadioToanThoiGianActionPerformed

    private void jtableViPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableViPhamMouseClicked
        jButtonXuLyVP.setEnabled(true);
    }//GEN-LAST:event_jtableViPhamMouseClicked

    private void jRadioSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioSachActionPerformed
      
    }//GEN-LAST:event_jRadioSachActionPerformed

    private void jRadioDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioDocGiaActionPerformed

    }//GEN-LAST:event_jRadioDocGiaActionPerformed

    private void jRadioNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioNXBActionPerformed
   ;
    }//GEN-LAST:event_jRadioNXBActionPerformed

    private void jRadioTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioTacGiaActionPerformed
     
    }//GEN-LAST:event_jRadioTacGiaActionPerformed

    private void jRadioTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioTheLoaiActionPerformed

    }//GEN-LAST:event_jRadioTheLoaiActionPerformed

    private void jRadioDGHetHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioDGHetHanActionPerformed

    }//GEN-LAST:event_jRadioDGHetHanActionPerformed

    private void jRadioViPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioViPhamActionPerformed

    }//GEN-LAST:event_jRadioViPhamActionPerformed

    private void jRadioTuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioTuanActionPerformed

    }//GEN-LAST:event_jRadioTuanActionPerformed

    private void jRadioThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioThangActionPerformed
  
    }//GEN-LAST:event_jRadioThangActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GroupKhoangThoiGianTK;
    private javax.swing.ButtonGroup GroupMuonTra;
    private javax.swing.ButtonGroup GroupYeuCauTK;
    private javax.swing.JButton jBMuontra;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBaoMat;
    private javax.swing.JButton jButtonCapNhatNV;
    private javax.swing.JButton jButtonNhapMoiDocGia;
    private javax.swing.JButton jButtonNhapMoiSach;
    private javax.swing.JButton jButtonSuaDocGia;
    private javax.swing.JButton jButtonSuaSach;
    private javax.swing.JButton jButtonThemDocGia;
    private javax.swing.JButton jButtonThemNV;
    private javax.swing.JButton jButtonThemSach;
    private javax.swing.JButton jButtonThongKe;
    private javax.swing.JButton jButtonTimKiemDGMT;
    private javax.swing.JButton jButtonTimKiemDocGia;
    private javax.swing.JButton jButtonTimKiemMT1;
    private javax.swing.JButton jButtonTimKiemNV;
    private javax.swing.JButton jButtonTimKiemSach;
    private javax.swing.JButton jButtonTimKiemVP;
    private javax.swing.JButton jButtonToDay;
    private javax.swing.JButton jButtonXoaDocGia;
    private javax.swing.JButton jButtonXoaMuon;
    private javax.swing.JButton jButtonXoaNV;
    private javax.swing.JButton jButtonXoaSach;
    private javax.swing.JButton jButtonXuLyVP;
    private javax.swing.JComboBox<String> jComboBoxGioiTinh;
    private javax.swing.JComboBox<String> jComboBoxGioiTinhNV;
    private javax.swing.JComboBox<String> jComboBoxTheLoai;
    private com.toedter.calendar.JDateChooser jDateNgayBD;
    private com.toedter.calendar.JDateChooser jDateNgayKT;
    private com.toedter.calendar.JDateChooser jDateNgayLapThe;
    private com.toedter.calendar.JDateChooser jDateNgayMT;
    private com.toedter.calendar.JDateChooser jDateNgayNhap;
    private com.toedter.calendar.JDateChooser jDateNgaySinh;
    private com.toedter.calendar.JDateChooser jDateNgaySinhNV;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDangMuon;
    private javax.swing.JLabel jLabelDangXuat;
    private javax.swing.JLabel jLabelHanThe;
    private javax.swing.JLabel jLabelMuonTD;
    private javax.swing.JLabel jLabelSachToiDa;
    private javax.swing.JLabel jLabelTenDN;
    private javax.swing.JLabel jLabelTitleSachChon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    javax.swing.JPanel jPanel17;
    javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    javax.swing.JPanel jPanel38;
    javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelTTNhanVien;
    private javax.swing.JRadioButton jRMuonsach;
    private javax.swing.JRadioButton jRTrasach;
    private javax.swing.JRadioButton jRadioChonNgay;
    private javax.swing.JRadioButton jRadioDGHetHan;
    private javax.swing.JRadioButton jRadioDocGia;
    private javax.swing.JRadioButton jRadioNXB;
    private javax.swing.JRadioButton jRadioSach;
    private javax.swing.JRadioButton jRadioSachHet;
    private javax.swing.JRadioButton jRadioTacGia;
    private javax.swing.JRadioButton jRadioThang;
    private javax.swing.JRadioButton jRadioTheLoai;
    private javax.swing.JRadioButton jRadioToanThoiGian;
    private javax.swing.JRadioButton jRadioTuan;
    private javax.swing.JRadioButton jRadioViPham;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedMain;
    private javax.swing.JTable jTableThongKe;
    private javax.swing.JButton jTimkiem1;
    private javax.swing.JButton jbuttonBoSach;
    private javax.swing.JButton jbuttonChonSach;
    private javax.swing.JTable jtableDocGia;
    private javax.swing.JTable jtableDocGiaMT;
    private javax.swing.JTable jtableMuonTra;
    private javax.swing.JTable jtableNhanVien;
    private javax.swing.JTable jtableSach;
    private javax.swing.JTable jtableSachChon;
    private javax.swing.JTable jtableSachMT;
    private javax.swing.JTable jtableViPham;
    private javax.swing.JSpinner spinnerSoLuong;
    private javax.swing.JSpinner spinnerSoTrang;
    private javax.swing.JPanel tabDocGia;
    private javax.swing.JPanel tabMuonTra;
    private javax.swing.JPanel tabNhanVien;
    private javax.swing.JPanel tabSach;
    private javax.swing.JPanel tabThongKe;
    private javax.swing.JPanel tabThongTin;
    private javax.swing.JPanel tabViPham;
    private javax.swing.JTextField txtChucVu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtDienThoaiNV;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailNV;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtNamXuatBan;
    private javax.swing.JTextField txtNgonNgu;
    private javax.swing.JTextField txtNhaXuatBan;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenDangNhap;
    private javax.swing.JTextField txtTenDocGia;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTimKiemDGMT;
    private javax.swing.JTextField txtTimKiemDocGia;
    private javax.swing.JTextField txtTimKiemMT;
    private javax.swing.JTextField txtTimKiemNV;
    private javax.swing.JTextField txtTimKiemSach;
    private javax.swing.JTextField txtTimKiemSachMT;
    private javax.swing.JTextField txtTimKiemVP;
    // End of variables declaration//GEN-END:variables

    
}
