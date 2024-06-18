import ij.IJ;
import ij.ImagePlus;
import ij.plugin.ContrastEnhancer;
import ij.process.ImageConverter;
import ij.process.ImageProcessor;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bouncycastle.jce.ECNamedCurveTable;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;


public class DImage extends javax.swing.JFrame {

    String id, pname, iname, txt, sk, sta;
    String a, pu;

    PrivateKey privateKey;
    String dpubkey, dprikey, curve, encodedPublicKey, encodedPrivateKey;
    PublicKey publicKey;
    SecretKeySpec secretKey;
    byte[] sharedSecretBob;
    KeyPair bobKeyPair;
String encryptedbobPublicKeyString; String encodedKey; SecretKey sharedAESKey ;

       
    public DImage() {
        initComponents();
        Security.addProvider(new BouncyCastleProvider());
   
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        msg = new javax.swing.JTextField();
        img = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        patient = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        inp = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        pri = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pub = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 121, 153));

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Patient Records");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTable4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Username", "Cloud_ID", "Request_File"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 35, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 35, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton8)
                .addContainerGap(215, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 70, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(153, 121, 153));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Message");

        msg.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        msg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msgActionPerformed(evt);
            }
        });

        img.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("File Name");

        patient.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        patient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Patient Name");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(patient, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(18, 18, 18)
                    .addComponent(patient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(17, 17, 17)
                    .addComponent(jLabel3)
                    .addGap(8, 8, 8)
                    .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(17, 17, 17)
                    .addComponent(jLabel8)
                    .addGap(18, 18, 18)
                    .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel4.setBackground(new java.awt.Color(153, 121, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Enter Secret parameter");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 11, 190, 40));

        inp.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        inp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpActionPerformed(evt);
            }
        });
        jPanel4.add(inp, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 63, 200, -1));

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Generate  Key");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 157, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Private Key");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 105, -1, -1));

        pri.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priActionPerformed(evt);
            }
        });
        jPanel4.add(pri, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 154, 200, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Public Key");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 114, -1, -1));

        pub.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pubActionPerformed(evt);
            }
        });
        jPanel4.add(pub, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 225, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Share Public Key");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 150, -1));

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jLabel1)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton5)
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 790));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ECDHH", "root", "")) {

                String sql = "SELECT id, patientname, imgname, msg,status,secKey FROM patient where did='"+ DLogin.uid2+"'";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID");
                model.addColumn("Patient Name");
                model.addColumn("Image Name");
                model.addColumn("Message");
                model.addColumn("Status");
                model.addColumn("Seckey");
                while (rs.next()) {
                    Object[] row = new Object[]{
                        rs.getInt("id"),
                        rs.getString("patientname"),
                        rs.getString("imgname"),
                        rs.getString("msg"),
                        rs.getString("status"),  rs.getString("secKey"),};
                    model.addRow(row);
                }

                jTable4.setModel(model);

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        int row = jTable4.getSelectedRow();
        id = (jTable4.getModel().getValueAt(row, 0).toString());

        pname = (jTable4.getModel().getValueAt(row, 1).toString());
        iname = (jTable4.getModel().getValueAt(row, 2).toString());
        txt = (jTable4.getModel().getValueAt(row, 3).toString());
        sta = (jTable4.getModel().getValueAt(row, 4).toString());
        encodedKey = (jTable4.getModel().getValueAt(row, 5).toString());
        patient.setText(pname);
        img.setText(iname);
        msg.setText(txt);
    }//GEN-LAST:event_jTable4MouseClicked

    private void msgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_msgActionPerformed

    private void imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imgActionPerformed

    private void patientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientActionPerformed

    private void inpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (sta.equals("Approved")) {
            JOptionPane.showMessageDialog(this, "Already Approved!");

            new DImage().setVisible(true);
            this.dispose();
        }
        if (sta.equals("Uploaded")) {
            JOptionPane.showMessageDialog(this, "Already Uploaded.  Need to decrypt!");

            new DImage().setVisible(true);
            this.dispose();
        }
        if (sta.equals("Downloaded")) {
            JOptionPane.showMessageDialog(this, "Already Decrypted.");

            new DImage().setVisible(true);
            this.dispose();
        } else {

            String a = inp.getText();
            try {

                curve = "secp256r1";

                ECNamedCurveParameterSpec bobCurveSpec = ECNamedCurveTable.getParameterSpec(curve);
                ECParameterSpec bobSpec = new ECNamedCurveSpec(
                    curve,
                    bobCurveSpec.getCurve(),
                    bobCurveSpec.getG(),
                    bobCurveSpec.getN());

                System.out.println("\nBob's parameters:");
                System.out.println("p (prime): " + bobCurveSpec.getCurve().getField().getCharacteristic());
                System.out.println("a: " + bobCurveSpec.getCurve().getA());
                System.out.println("b: " + bobCurveSpec.getCurve().getB());
                System.out.println("G (generator): " + bobCurveSpec.getG());
                System.out.println("n (order): " + bobCurveSpec.getN());
                System.out.println("h (cofactor): " + bobCurveSpec.getH());

                bobKeyPair = generateKeyPair(Integer.parseInt(a), curve);
                publicKey = bobKeyPair.getPublic();
                privateKey = bobKeyPair.getPrivate();
                JOptionPane.showMessageDialog(this, "Key pair is generated!");

                pri.setText(((ECPrivateKey) bobKeyPair.getPrivate()).getS().toString());
                //            pub.setText(((ECPublicKey) bobKeyPair.getPublic()).getW().toString());

                byte[] publicKeyBytes = publicKey.getEncoded();

                encodedPublicKey = Base64.getEncoder().encodeToString(publicKeyBytes);

                byte[] privateKeyBytes = privateKey.getEncoded();

                encodedPrivateKey = Base64.getEncoder().encodeToString(privateKeyBytes);
                System.out.println("Bob's Private Key: " + ((ECPrivateKey) bobKeyPair.getPrivate()).getS());
                ECPoint bobPublicPoint = ((ECPublicKey) bobKeyPair.getPublic()).getW();
                pub.setText(bobPublicPoint.getAffineX() + ", " + bobPublicPoint.getAffineY());
                System.out.println("Bob's Public Key: (" + bobPublicPoint.getAffineX() + ", " + bobPublicPoint.getAffineY() + ")");

            
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid parameter!");
                System.out.println(ex);
            }

        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void priActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priActionPerformed

    private void pubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pubActionPerformed
 public static SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256); // AES key size
        return keyGenerator.generateKey();
    }public static String encodeKeyToString(SecretKey key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
 public static byte[] encryptWithAES(byte[] data, SecretKey key) throws Exception {
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, key);
        return aesCipher.doFinal(data);
    }
public static SecretKey decodeStringToKey(String encodedKey) {
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        return new javax.crypto.spec.SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       // TODO add your handling code here:
        try {
         sharedAESKey=decodeStringToKey(encodedKey);   
            byte[] encryptedbobPublicKey = encryptWithAES(publicKey.getEncoded(), sharedAESKey);
      encryptedbobPublicKeyString = Base64.getEncoder().encodeToString(encryptedbobPublicKey);
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ECDHH", "root", "");
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs;
            String sql = "UPDATE patient SET dpri = '" + encodedPrivateKey + "'  , dpub = '" + encryptedbobPublicKeyString + "', status='Approved' WHERE id = '" + id + "'";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Key shared Successfully!");

        } catch (SQLException ex) {

            System.out.println(ex);
        } catch (Exception ex) {
            Logger.getLogger(DImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new Doctor().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed


    public static void decryptImage(String encryptedImagePath, byte[] sharedSecret, String decryptedImagePath) {
        try {
            byte[] encryptedData = Files.readAllBytes(Paths.get(encryptedImagePath));

            byte[] validKey = new byte[256 / 8];
         
            if (sharedSecret.length >= validKey.length) {
                System.arraycopy(sharedSecret, 0, validKey, 0, validKey.length);
            } else {
                System.arraycopy(sharedSecret, 0, validKey, 0, sharedSecret.length);
            }

            SecretKeySpec aesKey = new SecretKeySpec(validKey, "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);

            byte[] decryptedData = cipher.doFinal(encryptedData);

            FileOutputStream fos = new FileOutputStream(decryptedImagePath);
            fos.write(decryptedData);
            fos.close();

            JOptionPane.showMessageDialog(null, "Record is downloaded and decrypted!");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }    private static KeyPair generateKeyPair(int privateKeyParameter, String Curve) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        ECGenParameterSpec ecSpec = new ECGenParameterSpec(Curve);
        keyPairGenerator.initialize(ecSpec, new SecureRandom(new byte[]{(byte) privateKeyParameter}));
        return keyPairGenerator.generateKeyPair();
    }
   

    public static byte[] encrypt(byte[] input, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(input);
    } public static byte[] decrypt(byte[] input, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(input);
    }
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
            java.util.logging.Logger.getLogger(DImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DImage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField img;
    private javax.swing.JTextField inp;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField msg;
    private javax.swing.JTextField patient;
    private javax.swing.JTextField pri;
    private javax.swing.JTextField pub;
    // End of variables declaration//GEN-END:variables
}
