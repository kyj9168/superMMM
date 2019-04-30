package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class findpwPanel extends JPanel {
     
   ImageIcon icon;
   private JTextField idField;
   private JTextField nameField;
   private MainFrame mf;
   private JPanel op;
   
   public findpwPanel(MainFrame mf) {
      this.mf = mf;
      this.op = this;
      JLabel label = new JLabel(
            new ImageIcon(new ImageIcon("images/findpwbackground.png").getImage().getScaledInstance(1000, 800, 0)));
      label.setBounds(0, 0, 1000, 800);

      JLabel lblPw = new JLabel();
      lblPw.setBounds(100, 480, 200, 40);
      this.add(lblPw);
      
      
      //���̵� �Է� ĭ 
      idField = new JTextField();
      idField.setBounds(420, 300, 260, 40);
      this.add(idField);
      idField.setColumns(10);

      //�̸� �Է� ĭ
      nameField = new JTextField();
      nameField.setBounds(420, 420, 260, 40);
      this.add(nameField);
      nameField.setColumns(10);
      

      //��й�ȣ ã�� ��
      JButton lblFindpw = new JButton();
      Image findpw = new ImageIcon("images/findpw2.png").getImage().getScaledInstance(300, 60, 0);
      lblFindpw.setIcon(new ImageIcon(findpw));
      lblFindpw.setBounds(380, 570, 300, 200);
      lblFindpw.setContentAreaFilled(false);
      lblFindpw.setBorderPainted(false);
      
      lblFindpw.addActionListener(new ActionListener() {
         
        
        	 @Override

 			public void actionPerformed(ActionEvent e) {

 				try{
 					String s = null;
 					 boolean result = true;

 					BufferedReader br = new BufferedReader(new FileReader("ȸ�����.txt"));


 					while((s=br.readLine()) != null){

 						String [] array=s.split("/");

 						if(idField.getText().equals(array[1])) {

 							if(nameField.getText().equals(array[0]))
 							{
 								 result = false;
 								JOptionPane.showMessageDialog(null, "��й�ȣ�´� " + array[2] + "�Դϴ�.");
 								ChangePanel.changePanel(mf, op, new Login(mf));

 							}
 						}
 					}
 				if(result) {
	                   JOptionPane.showMessageDialog(null, "���� �����Դϴ�. �ٽ� �Է��Ͻÿ�.");
	                   return;
	                }



 					








 				}catch (IOException E10){
 					E10.printStackTrace();
 				}
 			}
 		});
      
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
            ChangePanel.changePanel(mf, op, new Login(mf));
         }
      });
      this.add(lblback);
      
      this.add(lblFindpw);
      this.add(label);
      this.setSize(1000, 800);
      
   }


}