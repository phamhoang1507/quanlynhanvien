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
public class ketnoidltaikhoan {
    public Connection conn;
    
    public ketnoidltaikhoan()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/qlnhanvien";
            try {
                this.conn=DriverManager.getConnection(url,"root","");
            } catch (SQLException ex) {
                Logger.getLogger(ketnoidltaikhoan.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ketnoidltaikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet GetTK()
    {
        ResultSet rs=null;
        try {
            
            Statement st= this.conn.createStatement();
            String sql="select *from tbtaikhoan";
            rs=st.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(ketnoidltaikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public void ThemTK(String tk,String mk)
    {
         try {
            
            Statement st= this.conn.createStatement();
            String sql="insert into tbtaikhoan values ('"+tk+"','"+mk+"',2)";
                st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoidltaikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void ThemTKAD(String tk,String mk,int quyen)
    {
         try {
            Statement st= this.conn.createStatement();
            String sql="insert into tbtaikhoan values ('"+tk+"','"+mk+"',"+quyen+")";
                st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoidltaikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void SuaTKAD(String tk,String mk,int quyen)
     {
        try {
            Statement st=this.conn.createStatement();
            String sql="update tbtaikhoan set matkhau='"+mk+"',quyen="+quyen+" where taikhoan='"+tk+"'";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoidltaikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
      public void XoaTKAD(String tk)
     {
        try {
            Statement st=this.conn.createStatement();
            String sql="delete from tbtaikhoan where taikhoan='"+tk+"'";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoidltaikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
      public ResultSet TKtheoQuyen(int quyen)
    {
        ResultSet rs=null;
        try {
            
            Statement st= this.conn.createStatement();
            String sql="select *from tbtaikhoan where quyen="+quyen+"";
            rs=st.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(ketnoidltaikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
      public void DoiMatKhau(String tk,String mk)
     {
        try {
            Statement st=this.conn.createStatement();
            String sql="update tbtaikhoan set matkhau='"+mk+"' where taikhoan='"+tk+"'";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ketnoidltaikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
}
