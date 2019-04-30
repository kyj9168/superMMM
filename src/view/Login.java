package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Login extends JPanel {
   
   ImageIcon icon;
   private JTextField idField;
   private JPasswordField passwordField;
   private MainFrame mf;
   private JPanel op;

   public Login(MainFrame mf) {
      this.mf = mf;
      this.op = this;

      this.setVisible(true);
      this.setLayout(null);

      JLabel label = new JLabel(
            new ImageIcon(new ImageIcon("images/gamebackground.jpg").getImage().getScaledInstance(1000, 800, 0)));
      label.setBounds(0, 0, 1000, 800);

      JLabel lblId = new JLabel();
      Image id = new ImageIcon("images/ID2.png").getImage().getScaledInstance(320, 50, 0);
      lblId.setIcon(new ImageIcon(id));
      lblId.setBounds(320, 180, 320, 50);
      this.add(lblId);

      idField = new JTextField();
     idField.setBounds(400, 180, 220, 50);
      this.add(idField);
     idField.setColumns(10);

      JLabel lblPw = new JLabel("PW");
      Image pw = new ImageIcon("images/PW.png").getImage().getScaledInstance(320, 50, 0);
      lblPw.setIcon(new ImageIcon(pw));
      lblPw.setBounds(320, 300, 320, 50);
      this.add(lblPw);

      passwordField = new JPasswordField();
      passwordField.setBounds(400, 300, 220, 50);
      this.add(passwordField);

      JButton lblLogin = new JButton(
            new ImageIcon(new ImageIcon("images/login.PNG").getImage().getScaledInstance(170, 170, 0)));
      lblLogin.setBounds(700, 170, 200, 200);
      lblLogin.setOpaque(false);
      lblLogin.setContentAreaFilled(false);
      lblLogin.setBorderPainted(false);

      lblLogin.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
             
             try{
                String s = null;
                
                boolean result = true;
                BufferedReader br = new BufferedReader(new FileReader("ȸ�����.txt"));
                

                while((s=br.readLine()) != null){
                   
                   String [] array=s.split("/");
                   
                   if(idField.getText().equals(array[1])) {

                      if(passwordField.getText().equals(array[2]))
                      {
                         result = false;
                         JOptionPane.showMessageDialog(null, "�α����� �Ǿ����ϴ�!!");
                         ChangePanel.changePanel(mf, op, new todayCoin(mf));
                         
                      }
                   }
                }
                if(result) {
                   JOptionPane.showMessageDialog(null, "�α��� ����");
                   return;
                }
                   
                
                
                
             }catch (IOException E10){
                E10.printStackTrace();
             }
             
          }
       });

       this.add(lblLogin);

      JButton lblFindId = new JButton();
      Image findId = new ImageIcon("images/findid.png").getImage().getScaledInstance(170, 80, 0);
      lblFindId.setIcon(new ImageIcon(findId));
      lblFindId.setBounds(300, 570, 170, 80);
      lblFindId.setOpaque(false);
      lblFindId.setContentAreaFilled(false);
      lblFindId.setBorderPainted(false);
      
      lblFindId.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            ChangePanel.changePanel(mf, op, new findIdPanel(mf));
         }
      });
      this.add(lblFindId);
      

      JButton lblback = new JButton();
      Image back = new ImageIcon("images/backbutton.png").getImage().getScaledInstance(50, 50, 0);
      lblback.setIcon(new ImageIcon(back));
      lblback.setBounds(0, 0, 170, 80);
      lblback.setOpaque(false);
      lblback.setContentAreaFilled(false);
      lblback.setBorderPainted(false);
      
      lblback.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            ChangePanel.changePanel(mf, op, new BackgroundPanel(mf));
         }
      });
      this.add(lblback);

      JButton lblFindPw = new JButton();
      Image findPw = new ImageIcon("images/findpw.png").getImage().getScaledInstance(170, 80, 0);
      lblFindPw.setIcon(new ImageIcon(findPw));
      lblFindPw.setBounds(600, 570, 170, 80);
      lblFindPw.setOpaque(false);
      lblFindPw.setContentAreaFilled(false);
      lblFindPw.setBorderPainted(false);
      
      
      lblFindPw.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            ChangePanel.changePanel(mf, op, new findpwPanel(mf));
         }
      });
      
      this.add(lblFindPw);
      this.add(label);
      this.setSize(1000, 800);

   }

   
   
   

}