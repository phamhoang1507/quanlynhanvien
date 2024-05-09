/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package btl.FormBai;

import btl.dangkydangnhap.DangNhap;

/**
 *
 * @author MSI
 */
public class FormQuanLy extends javax.swing.JFrame {

    /**
     * Creates new form FormQuanLy
     */
    public static int quyen;
    public static String tk,mk;
    public FormQuanLy(int q,String us,String pw) {
        initComponents();
        quyen=q;
        tk=us;
        mk=pw;
        shownut();
         setLocationRelativeTo(null);
    }
    
//     public int  quyenADMIN(int q)
//    {
//        return q;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDangXuat = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        btnQuanLTK = new javax.swing.JMenu();
        btnChucVu = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        btnDoiMatKhau = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Nhân Viên");
        setBackground(new java.awt.Color(255, 102, 255));
        setName("Quản Lý Nhân Viên"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setForeground(new java.awt.Color(153, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btl/Images/dong-phuc-kfc-02.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 800, 450));

        jLabel2.setText("By Phạm Hoàng");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 510));

        btnDangXuat.setBackground(new java.awt.Color(255, 153, 255));
        btnDangXuat.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 255)));
        btnDangXuat.setForeground(new java.awt.Color(102, 102, 255));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenu1.setText("Home");
        btnDangXuat.add(jMenu1);

        jMenu2.setText("Thông Tin Nhân Viên");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        btnDangXuat.add(jMenu2);

        jMenu3.setText("Ca Làm");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        btnDangXuat.add(jMenu3);

        jMenu4.setText("Lương");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        btnDangXuat.add(jMenu4);

        jMenu5.setText("Công Việc");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        btnDangXuat.add(jMenu5);

        btnQuanLTK.setText("Quản Lý Tài Khoản");
        btnQuanLTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLTKMouseClicked(evt);
            }
        });
        btnDangXuat.add(btnQuanLTK);

        btnChucVu.setText("Chức Vụ");
        btnChucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChucVuMouseClicked(evt);
            }
        });
        btnDangXuat.add(btnChucVu);

        jMenu6.setText("Tài Khoản");

        btnDoiMatKhau.setText("Đổi Mật Khẩu");
        btnDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoiMatKhauMouseClicked(evt);
            }
        });
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });
        jMenu6.add(btnDoiMatKhau);

        jMenu7.setText("Đăng Xuất");
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenu6.add(jMenu7);

        btnDangXuat.add(jMenu6);

        setJMenuBar(btnDangXuat);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void shownut()
    {
        if(quyen!=1)
        {
            btnQuanLTK.setVisible(false);
            btnChucVu.setVisible(false);
        }
    }
    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        this.dispose();
        FormNhanVien a= new FormNhanVien(quyen,tk,mk);
       // a.nhanquyen(nhanquyen());
       
        a.setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        this.dispose();
         FomCaLam a= new FomCaLam(quyen,tk,mk);
       // a.nhanquyen(nhanquyen());
       
        a.setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
          this.dispose();
        FormCongViec a= new FormCongViec(quyen,tk,mk);
       // a.nhanquyen(nhanquyen());
       
        a.setVisible(true);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        this.dispose();
        FromLuong a= new FromLuong(quyen,tk,mk);
       // a.nhanquyen(nhanquyen());
       
        a.setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void btnQuanLTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLTKMouseClicked
        // TODO add your handling code here:
        this.dispose();
        FormTaiKhoan a= new FormTaiKhoan(quyen,tk,mk);
       // a.nhanquyen(nhanquyen());
       
        a.setVisible(true);
    }//GEN-LAST:event_btnQuanLTKMouseClicked

    private void btnChucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChucVuMouseClicked
        // TODO add your handling code here:'
        this.dispose();
        FormChucVu a= new FormChucVu(quyen,tk,mk);
       // a.nhanquyen(nhanquyen());
       
        a.setVisible(true);
    }//GEN-LAST:event_btnChucVuMouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        // TODO add your handling code here:
        this.dispose();
        DangNhap a= new DangNhap();
       // a.nhanquyen(nhanquyen());
       
        a.setVisible(true);
    }//GEN-LAST:event_jMenu7MouseClicked

    private void btnDoiMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMatKhauMouseClicked
        // TODO add your handling code here:
        //this.dispose();
        FormDoiMK a= new FormDoiMK(quyen,tk,mk);
        a.setVisible(true);
    }//GEN-LAST:event_btnDoiMatKhauMouseClicked

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        // TODO add your handling code here:
        FormDoiMK a= new FormDoiMK(quyen,tk,mk);
        a.setVisible(true);
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

   
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
            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FormQuanLy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnChucVu;
    private javax.swing.JMenuBar btnDangXuat;
    private javax.swing.JMenuItem btnDoiMatKhau;
    private javax.swing.JMenu btnQuanLTK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
