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

public class findIdPanel extends JPanel {
	

	ImageIcon icon;
	private JTextField nameField;
	private JTextField hpField;
	private MainFrame mf;
	private JPanel op;

	public findIdPanel(MainFrame mf) {
		this.mf = mf;
		this.op = this;
		JLabel label = new JLabel(
				new ImageIcon(new ImageIcon("images/findid background.png").getImage().getScaledInstance(1000, 800, 0)));
		label.setBounds(0, 0, 1000, 800);

		JLabel lblId = new JLabel();
		lblId.setBounds(100, 480, 200, 40);
		this.add(lblId);

		nameField = new JTextField();
		nameField.setBounds(415, 300, 260, 40);
		this.add(nameField);
		nameField.setColumns(10);

		hpField = new JTextField();
		hpField.setBounds(415, 450, 260, 40);
		this.add(hpField);


		JButton lblFindId = new JButton();
		Image findId = new ImageIcon("images/findid2.png").getImage().getScaledInstance(300, 100, 0);
		lblFindId.setIcon(new ImageIcon(findId));
		lblFindId.setBounds(400, 570, 300, 200);
		lblFindId.setContentAreaFilled(false);
		lblFindId.setBorderPainted(false);

		lblFindId.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				try{
					String s = null;


	                boolean result = true;
					BufferedReader br = new BufferedReader(new FileReader("ȸ�����.txt"));


					while((s=br.readLine()) != null){

						String [] array=s.split("/");

						if(nameField.getText().equals(array[0])) {

							if(hpField.getText().equals(array[3]))
							{
								 result = false;
								JOptionPane.showMessageDialog(null, "���̵�� " + array[1] + "�Դϴ�.");
								ChangePanel.changePanel(mf, op, new Login(mf));

							}
						}
					}if(result) {
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


		this.add(lblFindId);
		this.add(label);
		this.setSize(1000, 800);

	}

}
