/*
quangvinh.gulang@gmail.com
 */
package Manager;

import Model.SinhVien;
import Model.MuonTra;
import connectDataBase.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quangvinh.gulang@gmail.com
 */
public class MuonTraManager {
    Connection conn;
    ArrayList<MuonTra> lstMuonTra= new ArrayList();  
    private PreparedStatement st, st1;
    public static final int MUON_TOI_DA = 14;// số ngày quy định cho phép mượn tối đa
    public MuonTraManager() {
        conn = new ConnectionDB().getConnection();
    }
    
    
     public ArrayList<MuonTra> getAllMuonTra(String search)
     {                           
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT maphieu,mamuontra,m.madocgia,tendocgia,"
                    + "m.masach,tensach,ngaymuon FROM pmqltv.muontra m, pmqltv.sach s, pmqltv.docgia d "
                    + "WHERE m.ngaytra IS NULL AND lower(concat(m.madocgia,d.tendocgia,m.mamuontra,s.tensach)) like lower('%"+search+"%')"
                    + " AND s.masach = m.masach AND d.madocgia = m.madocgia ORDER BY mamuontra DESC");            
            ResultSet rs = pst.executeQuery();       
            while(rs.next()) {
                MuonTra mt = new MuonTra();
                mt.setMaPhieu(rs.getInt("maphieu"));
                mt.setMaMuonTra(rs.getInt("mamuontra"));
                mt.setMaDocGia(rs.getInt("madocgia"));
                mt.setTenDocGia(rs.getString("tendocgia"));
                mt.setMaSach(rs.getInt("masach"));
                mt.setTenSach(rs.getString("tensach"));
                mt.setNgayMuon(rs.getDate("ngaymuon"));
                  
               lstMuonTra.add(mt);              
            }
        } catch (SQLException ex) {
               System.out.println(ex.toString());  
        }
        return  lstMuonTra;
    }
     
    public boolean themMuonTra(MuonTra muonTra) {
        boolean check = false; 
        try {
            MuonTra mt = muonTra;
            st = conn.prepareStatement("insert into muontra(madocgia, masach, manhanvien,"
                    + " ngaymuon, maphieu) values(?,?,?,?,?)");
            st.setInt(1, mt.getMaDocGia());
            st.setInt(2, mt.getMaSach());
            st.setInt(3, mt.getMaNhanVien());
            st.setDate(4, mt.getNgayMuon());
            st.setInt(5, mt.getMaPhieu());

            st1 = conn.prepareStatement("UPDATE pmqltv.sach SET  damuon = damuon + 1  WHERE masach =?" );
            st1.setInt(1, mt.getMaSach());
            
            int result = st.executeUpdate();
            st1.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Độc giả mượn sách thành công!" , "Thông báo", 1);
            check = result != 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Sách chưa được mượn" , "Thông báo", 1); 
        }
        return check;
    }
    
    public boolean traSach(MuonTra muonTra) {
        boolean check = false;
        MuonTra mt = muonTra;
        int quaHan = 0;
        try {
            st = conn.prepareStatement("UPDATE pmqltv.muontra, pmqltv.sach SET  ngaytra = ?,"
                    +" damuon= damuon-1  WHERE mamuontra =? and sach.masach= muontra.masach" );
            
            st.setDate(1, mt.getNgayTra());
            st.setInt(2, mt.getMaMuonTra());
            int result = st.executeUpdate();            
            check = result != 0;
            
            PreparedStatement pst = conn.prepareStatement("SELECT DATEDIFF(ngaytra,ngaymuon) FROM"
                    +" pmqltv.muontra WHERE mamuontra = "+ mt.getMaMuonTra()+"");   
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                quaHan = rs.getInt("DATEDIFF(ngaytra,ngaymuon)") - MUON_TOI_DA;
            }
            if(quaHan> 0){
                try{
                    st = conn.prepareStatement("insert into vipham(mamuontra, quahan, lydo) values(?,"+quaHan+",?)");
                    st.setInt(1, muonTra.getMaMuonTra());
                    st.setString(2, "Quá hạn");
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Độc giả trả quá hạn!" , "Thông báo", 1); 
                } catch (SQLException ex) {
                System.out.println(ex.toString());  
                JOptionPane.showMessageDialog(null, "Lỗi thêm vi phạm" , "Thông báo", 2); 
                }
            }
        } catch (SQLException ex) {
               System.out.println(ex.toString());  
               JOptionPane.showMessageDialog(null, "Lỗi trả sách" , "Thông báo", 1); 
        }
        return check;
    }
    
    
    public boolean baoMat(MuonTra muonTra) {//báo mất sách,số lượng và đã mượn giảm 1, thêm ngày trả vào thẻ mượn. thêm vi phạm, tiền phạt = giá sách * 2
        boolean check = false;
        MuonTra mt = muonTra;
        try {
            // thêm vi phạm
            st = conn.prepareStatement("insert into vipham(mamuontra,lydo,quahan)"
                    +" values(?,?,((SELECT giatien FROM pmqltv.sach WHERE sach.masach= ?)/1000))");
            st.setInt(1, mt.getMaMuonTra());
            st.setString(2, "Mất sách");
            st.setInt(3, mt.getMaSach());
            int result = st.executeUpdate();
            if(result!= 0){
                //giảm số lượng sách, giảm đã mượn và set ngày trả
                st1 = conn.prepareStatement("UPDATE pmqltv.sach, pmqltv.muontra SET "
                        +" soluong= soluong - 1, damuon = damuon - 1, ngaytra=?  WHERE "
                        +"sach.masach = muontra.masach AND mamuontra = ?" );
                st1.setDate(1, mt.getNgayTra());
                st1.setInt(2, mt.getMaMuonTra());
                int result1 = st1.executeUpdate();
                
                //xóa sách nếu số lượng sách về 0.
//                st0 = conn.prepareStatement("UPDATE pmqltv.sach SET  trangthai= ?  WHERE soluong= 0 AND masach= ?" );
//                st0.setString(1, "đã xóa");
//                st0.setInt(2, mt.getMaSach());
//                int result2 =st0.executeUpdate();
//                if(result2==0){
//                    System.out.println("Xảy ra tại xóa sách khi số lượng về 0.");
//                }
                check = (result1 != 0);
            } else System.out.println ("chưa thêm vi phạm khi báo mất!");
        } catch (SQLException ex) {
            System.out.println(ex.toString());  
        }
        return check;
    }
    
    public void xoaMuonTra(int maMuonTra, int maSach) {
        try {
            st = conn.prepareStatement("delete from muontra where mamuontra = ?");
            st.setInt(1, maMuonTra);
            int delete = st.executeUpdate();
            if(delete!= 0){
                try{
                    st1 = conn.prepareStatement("UPDATE pmqltv.sach SET damuon = damuon - 1  WHERE masach = ?");
                    st1.setInt(1, maSach);            
                    st1.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Đã xóa thẻ mượn!" , "Thông báo", 1);
                } catch (SQLException ex) {
                    System.out.println("Lỗi giảm đã mượn của sách khi xóa thẻ mượn.");  
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!" , "Thông báo", 2); 
        }
    }

    public int demMuonTra(String maDocGia){
        int tongmuon = 0;
        try {
            String sql = "SELECT COUNT(masach) FROM pmqltv.muontra WHERE madocgia = "+maDocGia+" AND ngaytra IS NULL";
            PreparedStatement pst = conn.prepareStatement(sql);   
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                tongmuon= rs.getInt("COUNT(masach)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MuonTraManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tongmuon;
    }
    
    public int getMaPhieu(){
        int maPhieu = 0;
        try {
            String sql = "SELECT MAX(maphieu) AS mp FROM pmqltv.muontra";
            PreparedStatement pst = conn.prepareStatement(sql);   
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                maPhieu= rs.getInt("mp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MuonTraManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maPhieu+1;
    }
    
    public void loadDataMuonTraFromDB(JTable jtableMuonTra,String search) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        MuonTraManager muontraManager = new MuonTraManager();    
        if(search.equals("Nhập mã mượn trả/ mã hoặc tên sinh viên/ tên đồ án")){
            search = "";
        }
        lstMuonTra= muontraManager.getAllMuonTra(search);
        //Dua danh sach muon tra len jTable
        String[] colTieuDe = new String[]{ "MÃ PHIẾU","MÃ MƯỢN TRẢ","MÃ SINH VIÊN", "TÊN SINH VIÊN",
            "MÃ ĐỒ ÁN", "TÊN ĐỒ ÁN",  "NGÀY MƯỢN", "HẠN TRẢ" };
        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
        Object[] row;
        for (MuonTra mt : lstMuonTra) {
            row = new Object[8];
            row[0] = mt.getMaPhieu();
            row[1] = mt.getMaMuonTra();
            row[2] = mt.getMaDocGia();
            row[3] = mt.getTenDocGia();
            row[4] = mt.getMaSach();
            row[5] = mt.getTenSach();
            row[6] = mt.getNgayMuon();

            Calendar c1 = Calendar.getInstance();
            c1.setTime(mt.getNgayMuon());
            c1.add(Calendar.DATE, MUON_TOI_DA);                

            row[7] = dateFormat.format(c1.getTime());//hạn trả sách sau MUON_TOI_DA ngày.
            model.addRow(row);
        }       
        jtableMuonTra.setModel(model);
    } 
    
    public void loadDataTraSachFromDB(JTable jtableMuonTra,int maDocGia) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        String[] colTieuDe = new String[]{ "MÃ MƯỢN TRẢ", "MÃ SINH VIÊN", "TÊN SINH VIÊN",
            "MÃ ĐỒ ÁN", "TÊN ĐỒ ÁN", "NGÀY MƯỢN", "HẠN TRẢ" };
        
        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
        Object[] row;
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT mamuontra,m.madocgia,tendocgia,"
                    + "m.masach,tensach,ngaymuon FROM pmqltv.muontra m, pmqltv.sach s, pmqltv.docgia d "
                    + "WHERE m.ngaytra IS NULL AND m.madocgia = "+maDocGia+" "
                    + " AND s.masach = m.masach AND d.madocgia = m.madocgia ORDER BY mamuontra DESC");            
            ResultSet rs = pst.executeQuery();       
            while(rs.next()) {
                row = new Object[7];
                row[0] = rs.getInt("mamuontra");
                row[1] = rs.getInt("madocgia");
                row[2] = rs.getString("tendocgia");
                row[3] = rs.getInt("masach");
                row[4] = rs.getString("tensach");
                row[5] = rs.getDate("ngaymuon");
                
                Calendar c1 = Calendar.getInstance();
                c1.setTime(rs.getDate("ngaymuon"));
                c1.add(Calendar.DATE, MUON_TOI_DA);                
                
                row[6] = dateFormat.format(c1.getTime());//hạn trả sách sau 14 ngày.
                model.addRow(row);
            }
        } catch (SQLException ex) {
               System.out.println(ex.toString());  
        }
        jtableMuonTra.setModel(model);
    }
    
    public void printMuonTra(int maMuonTra, SinhVien docGia, MuonTra muonTra){
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT d.*, s.*, m.ngaymuon FROM"
                    +" pmqltv.muontra m, pmqltv.sach s, pmqltv.docgia d "
                    + "WHERE m.mamuontra = "+ maMuonTra +" AND s.masach = m.masach AND d.madocgia = m.madocgia");            
            ResultSet rs = pst.executeQuery();       
            while(rs.next()) {
                docGia.setTenDocGia(rs.getString("d.tendocgia"));
                docGia.setDiaChi(rs.getString("d.diachi"));
                docGia.setEmail(rs.getString("d.email"));
                docGia.setGioiTinh(rs.getString("d.gioitinh"));
                docGia.setDienThoai(rs.getString("d.dienthoai"));
                docGia.setNgaySinh(rs.getString("d.ngaysinh"));
                docGia.setMaDocGia(rs.getInt("d.madocgia"));
                muonTra.setNgayMuon(rs.getDate("m.ngaymuon"));
            }
        } catch (SQLException ex) {
               System.out.println(ex.toString());  
        }
    }
}
