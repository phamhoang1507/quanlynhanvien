/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package btl.FormBai;

import btl.dulieu.ketnoicsdl;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author MSI
 */
public class TimKiemCongViec extends javax.swing.JFrame {

    /**
     * Creates new form TimKiemCongViec
     */
    public static int quyen;
    public static String us,pw;
    public TimKiemCongViec(int q,String tk,String mk) {
        initComponents();
        us=tk;
        pw=mk;
        quyen=q;
        Loai();
         setLocationRelativeTo(null);
    }
    public void Loai()
    {
        
           DefaultComboBoxModel model1 = (DefaultComboBoxModel)txtLoai.getModel();
        
        try {
            
            ketnoicsdl kn= new ketnoicsdl();
            ResultSet rs=kn.GetData("tbchucvu");
            int i=0;
            while(rs.next())
            {
                model1.addElement(rs.getString("loainv"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                DefaultComboBoxModel model2 = (DefaultComboBoxModel)txtCa.getModel();
        
        try {
            
            ketnoicsdl kn= new ketnoicsdl();
            ResultSet rs=kn.GetData("tbcalam");
            int i=0;
            while(rs.next())
            {
                model2.addElement(rs.getString("macalam"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int DemTen()
    {
        int dem=0;
        try {
            
            ketnoicsdl kn= new ketnoicsdl();
                 String Giong=txtTen.getText();
                ResultSet rs1=kn.tkmatuten(Giong);            
                //String ma=kn.ma(Giong);
                while(rs1.next())
                {
                    String ma=rs1.getString("manv");
                        ResultSet rs=kn.TimKiemCV("manv", ma);
                     while(rs.next())
                    {
                        dem++;
                    }
                }      
           
        } catch (SQLException ex) {
            Logger.getLogger(FormNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dem;
    }
    public void ShowTableTen()
    {
        DefaultTableModel model =(DefaultTableModel)tbCongViec.getModel();
        model.setRowCount(DemTen());
        try {
            ketnoicsdl kn= new ketnoicsdl();
                 String Giong=txtTen.getText();
                ResultSet rs1=kn.tkmatuten(Giong);            
                //String ma=kn.ma(Giong);
                int i=0;
                while(rs1.next())
                {
                    
                    String ma=rs1.getString("manv");
                        ResultSet rs=kn.TimKiemCV("manv", ma);
                     while(rs.next())
                    {
                        tbCongViec.setValueAt(rs1.getString("tennv"), i, 2);
                            tbCongViec.setValueAt(rs1.getString("loainv"), i, 3);
                            
                           tbCongViec.setValueAt(rs.getString("manv"), i, 0);
                            tbCongViec.setValueAt(rs.getString("macalam"), i, 1);        
                               tbCongViec.setValueAt(rs.getString("ngaylam"), i, 4);
                                tbCongViec.setValueAt(rs.getString("ghichu"), i, 5);
                                    i++;
                    }
                } 
            
           
           
        } catch (SQLException ex) {
            Logger.getLogger(FormNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int DemCa()
    {
        int dem=0;
        try {
            
            ketnoicsdl kn= new ketnoicsdl();
                 String Giong=(String) txtCa.getSelectedItem();
                ResultSet rs=kn.TimKiemCV("macalam", Giong);
                //String ma=kn.ma(Giong);
                
                     while(rs.next())
                    {
                        dem++;
                    }
                    
           
        } catch (SQLException ex) {
            Logger.getLogger(FormNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dem;
    }
     public void ShowTableCa()
    {
        DefaultTableModel model =(DefaultTableModel)tbCongViec.getModel();
        model.setRowCount(DemCa());
        try {
            ketnoicsdl kn= new ketnoicsdl();
                 String Giong=(String) txtCa.getSelectedItem();
                ResultSet rs1=kn.GetData("tbnhanvien");
                //String ma=kn.ma(Giong);
                int i=0;
                while(rs1.next())
                {
                    
                    
                        ResultSet rs=kn.TimKiemCV("macalam", Giong);
                     while(rs.next())
                    {
                        if(rs.getString("manv").equalsIgnoreCase(rs1.getString("manv")))
                        {
                            tbCongViec.setValueAt(rs1.getString("tennv"), i, 2);
                            tbCongViec.setValueAt(rs1.getString("loainv"), i, 3);
                            
                           tbCongViec.setValueAt(rs.getString("manv"), i, 0);
                            tbCongViec.setValueAt(rs.getString("macalam"), i, 1);        
                               tbCongViec.setValueAt(rs.getString("ngaylam"), i, 4);
                                tbCongViec.setValueAt(rs.getString("ghichu"), i, 5);
                                    i++;
                        }  
                    }
                } 
        } catch (SQLException ex) {
            Logger.getLogger(FormNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  public int DemLoai()
    {
        int dem=0;
        try {
            
            ketnoicsdl kn= new ketnoicsdl();
                 String Giong=(String) txtLoai.getSelectedItem();
               
               
                     
                ResultSet rs1=kn.tkmatuloai(Giong);            
                //String ma=kn.ma(Giong);
                while(rs1.next())
                {
                    String ma=rs1.getString("manv");
                        ResultSet rs=kn.TimKiemCV("manv", ma);
                     while(rs.next())
                    {
                        dem++;
                    }
                }   
           
        } catch (SQLException ex) {
            Logger.getLogger(FormNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dem;
    }
     public void ShowTableLoai()
    {
        DefaultTableModel model =(DefaultTableModel)tbCongViec.getModel();
        model.setRowCount(DemLoai());
        try {
            ketnoicsdl kn= new ketnoicsdl();
                 String Giong=(String) txtLoai.getSelectedItem();
                ResultSet rs1=kn.tkmatuloai(Giong);
                //String ma=kn.ma(Giong);
                int i=0;
                while(rs1.next())
                {
                    
                        String ma=rs1.getString("manv");
                        ResultSet rs=kn.TimKiemCV("manv", ma);
                     while(rs.next())
                    {
                        
                             tbCongViec.setValueAt(rs1.getString("tennv"), i, 2);
                            tbCongViec.setValueAt(rs1.getString("loainv"), i, 3);
                            
                           tbCongViec.setValueAt(rs.getString("manv"), i, 0);
                            tbCongViec.setValueAt(rs.getString("macalam"), i, 1);        
                               tbCongViec.setValueAt(rs.getString("ngaylam"), i, 4);
                                tbCongViec.setValueAt(rs.getString("ghichu"), i, 5);
                                    i++;
                        
                       
                    }
                } 
        } catch (SQLException ex) {
            Logger.getLogger(FormNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public int DemNgay()
    {
        int dem=0;
        try {
            
            ketnoicsdl kn= new ketnoicsdl();
                 String Giong=(String) txtNgayLam.getText();
                ResultSet rs=kn.TimKiemCV("ngaylam", Giong);
                //String ma=kn.ma(Giong);
                
                     while(rs.next())
                    {
                        dem++;
                    }
                    
           
        } catch (SQLException ex) {
            Logger.getLogger(FormNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dem;
    }
     public void ShowTableNgay()
    {
        DefaultTableModel model =(DefaultTableModel)tbCongViec.getModel();
        model.setRowCount(DemNgay());
        try {
            ketnoicsdl kn= new ketnoicsdl();
                 String Giong=(String) txtNgayLam.getText();
                ResultSet rs1=kn.GetData("tbnhanvien");
                //String ma=kn.ma(Giong);
                int i=0;
                while(rs1.next())
                {
                    
                    
                        ResultSet rs=kn.TimKiemCV("ngaylam", Giong);
                     while(rs.next())
                    {
                        
                             tbCongViec.setValueAt(rs1.getString("tennv"), i, 2);
                            tbCongViec.setValueAt(rs1.getString("loainv"), i, 3);
                            
                           tbCongViec.setValueAt(rs.getString("manv"), i, 0);
                            tbCongViec.setValueAt(rs.getString("macalam"), i, 1);        
                               tbCongViec.setValueAt(rs.getString("ngaylam"), i, 4);
                                tbCongViec.setValueAt(rs.getString("ghichu"), i, 5);
                                    i++;
                        
                       
                    }
                } 
        } catch (SQLException ex) {
            Logger.getLogger(FormNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void TimKiem()
    {
        
        if(rdTen.isSelected())
        {
            ShowTableTen();
        }
        if(rdCa.isSelected())
        {
            ShowTableCa();
        }
        if(rdNgayLam.isSelected())
        {
            ShowTableNgay();
        }
        if(rdLoai.isSelected())
        {
            ShowTableLoai();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNgayLam = new javax.swing.JTextField();
        txtLoai = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        txtDiaChi1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCa = new javax.swing.JComboBox<>();
        rdCa = new javax.swing.JRadioButton();
        rdTen = new javax.swing.JRadioButton();
        rdLoai = new javax.swing.JRadioButton();
        rdNgayLam = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCongViec = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Tìm Kiếm Công Việc");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Tên Nhân Viên");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 57, -1, -1));

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenActionPerformed(evt);
            }
        });
        jPanel2.add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 234, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Loại Nhân Viên");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 117, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Ngày Làm");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        txtNgayLam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtNgayLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 234, -1));

        txtLoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtLoai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtLoaiItemStateChanged(evt);
            }
        });
        jPanel2.add(txtLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 230, -1));

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseEntered(evt);
            }
        });
        jPanel2.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, -1, -1));

        btnThoat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatMouseClicked(evt);
            }
        });
        jPanel2.add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, -1, -1));

        txtDiaChi1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtDiaChi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 234, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Mã Ca Làm");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        txtCa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtCaItemStateChanged(evt);
            }
        });
        jPanel2.add(txtCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 230, -1));

        buttonGroup1.add(rdCa);
        rdCa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdCa.setText("Theo Ca");
        rdCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCaActionPerformed(evt);
            }
        });
        jPanel2.add(rdCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, -1, -1));

        buttonGroup1.add(rdTen);
        rdTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdTen.setText("Theo Tên");
        jPanel2.add(rdTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        buttonGroup1.add(rdLoai);
        rdLoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdLoai.setText("Theo Loại");
        rdLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdLoaiActionPerformed(evt);
            }
        });
        jPanel2.add(rdLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        buttonGroup1.add(rdNgayLam);
        rdNgayLam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdNgayLam.setText("Theo Ngày Làm");
        rdNgayLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNgayLamActionPerformed(evt);
            }
        });
        jPanel2.add(rdNgayLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 840, 350));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Công Việc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        jPanel3.setFocusable(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbCongViec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Mã Ca Làm", "Tên Nhân Viên", "Loai Nhân Viên", "Ngày Làm", "Ghi Chú"
            }
        ));
        tbCongViec.setRowHeight(35);
        tbCongViec.setShowVerticalLines(true);
        tbCongViec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCongViecMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCongViec);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 820, 260));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 840, 310));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenActionPerformed

    private void txtLoaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtLoaiItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoaiItemStateChanged

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        // TODO add your handling code here:
        TimKiem();

    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMouseClicked
        // TODO add your handling code here:
        this.dispose();
        FormQuanLy a= new FormQuanLy(quyen,us,pw);
        a.setVisible(true);
    }//GEN-LAST:event_btnThoatMouseClicked

    private void txtCaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtCaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCaItemStateChanged

    private void rdCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdCaActionPerformed

    private void rdLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdLoaiActionPerformed

    private void rdNgayLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNgayLamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdNgayLamActionPerformed

    private void tbCongViecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCongViecMouseClicked
        // TODO add your handling code here:
//        int vitri=tbCongViec.getSelectedRow();
//        txtMa.setSelectedItem((String) tbCongViec.getValueAt(vitri, 0));
//        txtCa.setSelectedItem((String) tbCongViec.getValueAt(vitri, 1));
//        txtNgayLam.setText((String) tbCongViec.getValueAt(vitri, 4));
//        txtGhiChu.setText((String) tbCongViec.getValueAt(vitri, 5));

    }//GEN-LAST:event_tbCongViecMouseClicked

    private void btnTimKiemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemMouseEntered

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
            java.util.logging.Logger.getLogger(TimKiemCongViec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimKiemCongViec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimKiemCongViec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimKiemCongViec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new TimKiemCongViec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdCa;
    private javax.swing.JRadioButton rdLoai;
    private javax.swing.JRadioButton rdNgayLam;
    private javax.swing.JRadioButton rdTen;
    private javax.swing.JTable tbCongViec;
    private javax.swing.JComboBox<String> txtCa;
    private javax.swing.JTextField txtDiaChi1;
    private javax.swing.JComboBox<String> txtLoai;
    private javax.swing.JTextField txtNgayLam;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
