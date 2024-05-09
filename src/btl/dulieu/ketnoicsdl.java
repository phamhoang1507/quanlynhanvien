/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl.dulieu;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MSI
 */
public class ketnoicsdl {
    public Connection conn;
    
    public  ketnoicsdl()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/qlnhanvien";
            try {
                this.conn=DriverManager.getConnection(url,"root","");
            } catch (SQLException ex) {
                Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet GetData(String Table)
    {
        ResultSet rs=null;
        try {
            
            Statement st= this.conn.createStatement();
            String sql="select *from "+Table;
            rs=st.executeQuery(sql);
           
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
    }
    public void ThemNV(String manv,String tennv,String loainv,String date,String sdt,String DiaChi ,String macalam)
    {
        try {
            String sql="insert into tbnhanvien values('"+manv+"','"+
                    tennv+"','"+loainv+"','"+date+"','"+sdt+"','"+DiaChi+"','"+macalam+"')";
            Statement st= this.conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void SuaNV(String manv,String tennv,String loainv,String date,String sdt,String DiaChi ,String macalam)
    {
        try {
            String sql="update tbnhanvien set tennv='"+
                    tennv+"',loainv='"+loainv+"',ngaysinh='"+date+
                    "',sodienthoai='"+sdt+"',diachi='"+DiaChi+"',macalam='"+macalam+"'where manv='"
                    +manv+"'";
            Statement st= this.conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void XoaNV(String manv)
    {
        try {
            String sql="delete from tbnhanvien where manv='"+manv+"'";
            Statement st= this.conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet TimKiem(String GT,String Giong)
    {
        ResultSet rs=null;
        try {
            
            Statement st= this.conn.createStatement();
            String sql="select *from tbnhanvien where "+ GT +" LIKE'%"+Giong+"%'";
            rs=st.executeQuery(sql);
           
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
    }
    public void ThemCaLam(String maca,String tenca,int batdau,int ketthuc)
    {
        try {
            Statement st= this.conn.createStatement();
            String sql="insert into tbcalam values('"+maca+"','"+tenca+"',"+batdau+","+ketthuc+")";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void SuaCaLam(String maca,String tenca,int batdau,int ketthuc)
    {
        try {
            Statement st= this.conn.createStatement();
            String sql="update tbcalam set tencalam='"+tenca+"',batdau="+batdau+",ketthuc="+ketthuc+" where macalam='"+maca+"'";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void XoaCaLam(String maca)
    {
        try {
            Statement st= this.conn.createStatement();
            String sql="delete from tbcalam where macalam='"+maca+"'";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void ThemCongViec(String manv,String maca,String ngaylam,String ghichu)
    {
        try {
            Statement st= this.conn.createStatement();
            String sql="insert into tbcongviec values('"+manv+"','"+maca+"','"+ngaylam+"','"+ghichu+"')";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void SuaCongViec(String manv,String maca,String ngaylam,String ghichu)
    {
        try {
            Statement st= this.conn.createStatement();
            String sql="update tbcongviec set ngaylam='"+ngaylam+"',ghichu='"+ghichu+"'where manv='"+manv+"' and  macalam='"+maca+"'";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void XoaCongViec(String maca,String manv)
    {
        try {
            Statement st= this.conn.createStatement();
            String sql="delete from tbcongviec where macalam='"+maca+"'and manv='"+manv+"'";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public ResultSet TimKiemCV(String GT,String Giong)
    {
        ResultSet rs=null;
        try {
            
            Statement st= this.conn.createStatement();
            String sql="select *from tbcongviec where "+ GT +" LIKE '%"+Giong+"%'";
            rs=st.executeQuery(sql);
           
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
    }
      
       public String ma(String ten)
    {
        String manv = null; // Khởi tạo giá trị mặc định là null

    try {
        Statement st = this.conn.createStatement();
        String sql = "SELECT manv FROM tbnhanvien WHERE tennv LIKE '%" + ten + "%'";
        ResultSet rs = st.executeQuery(sql);

        if (rs.next()) {
            manv = rs.getString("manv"); // Lấy m nhân viên từ cột "tennv"
        }
        rs.close();
        st.close();
    } catch (SQLException ex) {
        Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return manv;
    }
       
       
          public ResultSet tkmatuten (String ten)
    {
            ResultSet rs=null;
       try {
           Statement st = this.conn.createStatement();
           String sql = "SELECT *FROM tbnhanvien WHERE tennv LIKE '%" + ten + "%'";
           rs = st.executeQuery(sql);

       } catch (SQLException ex) {
           Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
       }
       return rs;
    }
            public ResultSet tkmatuloai (String loai)
    {
            ResultSet rs=null;
       try {
           Statement st = this.conn.createStatement();
           String sql = "SELECT *FROM tbnhanvien WHERE loainv = '" + loai + "'";
           rs = st.executeQuery(sql);

       } catch (SQLException ex) {
           Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
       }
       return rs;
    }
             public ResultSet GetDataTang()
    {
        ResultSet rs=null;
        try {
            
            Statement st= this.conn.createStatement();
          
            String sql="select *from tbluong order by luong asc";
            rs=st.executeQuery(sql);
           
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
    }
                public ResultSet GetDataGiam()
    {
        ResultSet rs=null;
        try {
            
            Statement st= this.conn.createStatement();
            String sql="select *from tbluong order by luong desc";
            rs=st.executeQuery(sql);
           
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
    }
        
        public ResultSet TimKiemLuong(String ma)
    {
        ResultSet rs=null;
        try {
            
            Statement st= this.conn.createStatement();
            String sql="select *from tbluong where manv='"+ ma +"'";
            rs=st.executeQuery(sql);
           
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
    }
        
     public void UpdateGioLam() {

        try {
            Statement st= this.conn.createStatement();
                        String sql="UPDATE tbluong " +
                "SET sogiolam = (SELECT SUM(tbcalam.ketthuc - tbcalam.batdau) " +
                               "FROM tbcongviec " +
                               "JOIN tbcalam ON tbcongviec.macalam = tbcalam.macalam " +
                               "WHERE tbcongviec.manv = tbluong.manv) " +
                "WHERE tbluong.manv IN (SELECT tbcongviec.manv FROM tbcongviec)";
                        
                        
                        
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
     }
     public void UpdateLuong() {

        try {
            Statement st= this.conn.createStatement();
                        String sql=    "UPDATE tbluong " +
                "INNER JOIN tbchucvu ON tbluong.loainv = tbchucvu.loainv " +
                "SET tbluong.luong = tbluong.sogiolam * tbchucvu.dongia " +
                "WHERE tbluong.sogiolam IS NOT NULL";
                        
                        
                        
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
     }
     public void themchuvu(String ma,String ten,double gia)
     {
        try {
            String sql="insert into tbchucvu values('"+ma+"','"+ten+"',"+gia+")";
            Statement st= this.conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     public void suachuvu(String ma,String ten,double gia)
     {
        try {
            String sql="update tbchucvu set tenloai='"+ten+"',dongia='"+gia+"'where loainv='"+ma+"'";
            Statement st= this.conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     public void xoachucvu(String ma)
     {
        try {
            String sql="delete from tbchucvu where loainv='"+ma+"'";
            Statement st= this.conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     public void themluong(String ma,String loai,double gio,double luong)
     {
        try {
            String sql="insert into tbluong values('"+ma+"','"+loai+"',"+gio+","+luong+")";
            Statement st= this.conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
      public ResultSet MaNVLam()
    {
        ResultSet rs=null;
        try {
            
            Statement st= this.conn.createStatement();
            String sql="select distinct manv from tbcongviec ";
            rs=st.executeQuery(sql);
           
        } catch (SQLException ex) {
            Logger.getLogger(ketnoicsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
    }
}
