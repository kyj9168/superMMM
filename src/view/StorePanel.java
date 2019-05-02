package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StorePanel extends JPanel {

	private JPanel panel;
	private JFrame mf;

	public StorePanel(JFrame mf) {
		JTextField tf = new JTextField(10);
		this.mf = mf;
		panel = this;

		this.setLayout(null);

		JLabel label = new JLabel(
				new ImageIcon(new ImageIcon("images/store background.PNG").getImage().getScaledInstance(1000, 800, 0)));
		label.setBounds(0, 0, 1000, 800);

		JButton buy1 = new JButton(
				new ImageIcon(new ImageIcon("images/buy.PNG").getImage().getScaledInstance(200, 100, 0)));
		buy1.setBounds(700, 350, 180, 80);
		buy1.setContentAreaFilled(false);
		buy1.setBorderPainted(false);
		buy1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,"아메리카노 쿠폰을 구매 하시겠습니까?","confirm",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					tf.setText("just closed without selection");
					ChangePanel cp = new ChangePanel(mf, panel);
					StorePanel sp = new StorePanel(mf);
					cp.replacePanel(sp);				}
				else if(result == JOptionPane.YES_OPTION) {
					tf.setText("Yes");
					JOptionPane.showMessageDialog(null, "구매가 완료되었습니다.");
					ChangePanel cp = new ChangePanel(mf, panel);
					StorePanel sp = new StorePanel(mf);
					cp.replacePanel(sp);				}
				else {
					tf.setText("No");
					JOptionPane.showMessageDialog(null, "구매를 취소하였습니다.");
					ChangePanel cp = new ChangePanel(mf, panel);
					StorePanel sp = new StorePanel(mf);
					cp.replacePanel(sp);				}
			}
		});
		
		
		JButton buy2 = new JButton(
				new ImageIcon(new ImageIcon("images/buy.PNG").getImage().getScaledInstance(200, 100, 0)));

		buy2.setBounds(700, 650, 180, 80);
		buy2.setContentAreaFilled(false);
		buy2.setBorderPainted(false);
		

		buy2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,"한식 뷔페 쿠폰을 구매 하시겠습니까?","confirm",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					tf.setText("just closed without selection");
					ChangePanel cp = new ChangePanel(mf, panel);
					StorePanel sp = new StorePanel(mf);
					cp.replacePanel(sp);
				}
				else if(result == JOptionPane.YES_OPTION) {
					tf.setText("Yes");
					JOptionPane.showMessageDialog(null, "구매가 완료되었습니다.");
					ChangePanel cp = new ChangePanel(mf, panel);
					StorePanel sp = new StorePanel(mf);
					cp.replacePanel(sp);
				}
				else {
					tf.setText("No");
					JOptionPane.showMessageDialog(null, "구매를 취소하였습니다.");
					ChangePanel cp = new ChangePanel(mf, panel);
					StorePanel sp = new StorePanel(mf);
					cp.replacePanel(sp);
				}
				
			}
		});
		
		JButton home = new JButton(
				new ImageIcon(new ImageIcon("images/home.png").getImage().getScaledInstance(80, 80, 0)));
		home.setBounds(0, 0, 80, 80);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				todayCoin tc = new todayCoin(mf);
				cp.replacePanel(tc);
			}
		});
		this.add(label);
		this.add(buy1);
		this.add(buy2);
		this.add(home);
		
		this.setComponentZOrder(label, 3);
		this.setSize(1000, 800);
	}
}
