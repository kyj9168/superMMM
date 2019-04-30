package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Join extends JPanel {
	
	ImageIcon icon;
	private MainFrame mf;
	private JTextField nameField;
	private JTextField idField;
	private JPasswordField passwordField;
	private JTextField hpField;
	private JPanel op;

	public Join(MainFrame mf) {
		this.mf = mf;
		this.op = this;
		this.setVisible(true);
		this.setLayout(null);

		JLabel label = new JLabel(
				new ImageIcon(new ImageIcon("images/gamebackground.jpg").getImage().getScaledInstance(1000, 800, 0)));
		label.setBounds(0, 0, 1000, 800);

		JLabel lblName = new JLabel();
		Image name = new ImageIcon("images/NAME.png").getImage().getScaledInstance(200, 50, 0);
		lblName.setIcon(new ImageIcon(name));
		lblName.setBounds(100, 90, 320, 50);
		this.add(lblName);

		nameField = new JTextField();
		nameField.setBounds(380, 90, 320, 40);
		this.add(nameField);
		nameField.setColumns(10);

		JLabel lblId = new JLabel();
		Image id = new ImageIcon("images/ID.png").getImage().getScaledInstance(200, 50, 0);
		lblId.setIcon(new ImageIcon(id));
		lblId.setBounds(100, 180, 320, 50);
		this.add(lblId);

		idField = new JTextField();
		idField.setBounds(380, 180, 320, 40);
		this.add(idField);
		idField.setColumns(10);

		JLabel lblPw = new JLabel();
		Image pw = new ImageIcon("images/PASSWORD.png").getImage().getScaledInstance(200, 50, 0);
		lblPw.setIcon(new ImageIcon(pw));
		lblPw.setBounds(100, 280, 320, 50);
		this.add(lblPw);

		passwordField = new JPasswordField();
		passwordField.setBounds(380, 280, 320, 40);
		this.add(passwordField);

		JLabel lblHp = new JLabel();
		Image hp = new ImageIcon("images/H.P.png").getImage().getScaledInstance(200, 50, 0);
		lblHp.setIcon(new ImageIcon(hp));
		lblHp.setBounds(100, 380, 320, 50);
		this.add(lblHp);

		hpField = new JTextField();
		hpField.setBounds(380, 380, 320, 40);
		this.add(hpField);

		JButton lblJoin = new JButton();
		Image login = new ImageIcon("images/joinus.png").getImage().getScaledInstance(300, 60, 0);
		lblJoin.setIcon(new ImageIcon(login));
		lblJoin.setBounds(260, 450, 300, 200);

		lblJoin.setContentAreaFilled(false);
		lblJoin.setBorderPainted(false);

		lblJoin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, op, new BackgroundPanel(mf));
				try{
					BufferedWriter bos = new BufferedWriter(new FileWriter("ȸ�����.txt",true));
					bos.write(nameField.getText()+"/");
					bos.write(idField.getText()+"/");
					bos.write(passwordField.getText()+"/");
					bos.write(hpField.getText()+"/");
					bos.write(0+"\r\n");
					
					bos.close();
					JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�!!");
					
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�.");
				}
				
				
			}
		});

		this.add(lblJoin);
		
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
        
        JButton overlapId = new JButton();
        Image overlap = new ImageIcon("images/ovarlapId.png").getImage().getScaledInstance(130, 60, 0);
        overlapId.setIcon(new ImageIcon(overlap));
        overlapId.setBounds(750, 175, 130, 60);
        overlapId.setOpaque(false);
        overlapId.setContentAreaFilled(false);
        overlapId.setBorderPainted(false);
        overlapId.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              BufferedReader br = null;
                          try{
					String s = null;


	                boolean result = true;
					br = new BufferedReader(new FileReader("ȸ�����.txt"));


					while((s=br.readLine()) != null){

						String [] array=s.split("/");

						if(idField.getText().equals(array[0])) {

							
								 result = false;
								JOptionPane.showMessageDialog(null, "�ߺ��� ���̵� �Դϴ�.");
								return;

							
						}
					}if(result) {
		                   JOptionPane.showMessageDialog(null, "��� ������ ���̵� �Դϴ�.");
		                   return;
		                }

					
				}catch (IOException E10){
					E10.printStackTrace();
				}
			}
		});

        this.add(overlapId);


		this.add(label);
		this.setSize(1000, 800);
	}
//0421
}