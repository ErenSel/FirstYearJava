package atm;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton_2;
	private KullaniciGirisi kullaniciGirisiFrame;
	
	
		private void showLoginFrame() {
	        if (kullaniciGirisiFrame == null) {
	            kullaniciGirisiFrame = new KullaniciGirisi();
	        }
	        kullaniciGirisiFrame.setVisible(true);
	        this.setVisible(false); 
	        
	    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1055, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Kullanıcı Girisi");
		btnNewButton.setBounds(494, 298, 152, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Personel Girisi");
		btnNewButton_1.setBounds(494, 377, 152, 39);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                                             
                PersonelGirisi personelGirisiFrame = new PersonelGirisi();
                personelGirisiFrame.setVisible(true);
            }
        });
		
		btnNewButton_2 = new JButton("Kayıt Ol");
		btnNewButton_2.setBounds(494, 454, 152, 39);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("SEL BANKASINA HOŞGELDİNİZ");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(416, 96, 349, 97);
		contentPane.add(lblNewLabel);
		
		JLabel iconlb = new JLabel("New ");
		iconlb.setHorizontalAlignment(SwingConstants.CENTER);
		iconlb.setIcon(new ImageIcon(Login.class.getResource("/atm/logo.jpg")));
		iconlb.setBounds(45, 38, 276, 238);
		contentPane.add(iconlb);
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                                             
                KullaniciGirisi kullaniciGirisiFrame = new KullaniciGirisi();
                kullaniciGirisiFrame.setVisible(true);
            }
        });
		btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                                             
                KayitOl kayitOlFrame = new KayitOl();
                kayitOlFrame.setVisible(true);
                
            }
        });
	}
}
