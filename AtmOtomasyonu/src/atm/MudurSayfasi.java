package atm;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class MudurSayfasi extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel w_pane;
	
	private JTextField fld_namePersonel;
	private JTextField fld_tcPersonel;
	private JTextField fld_ID;
	private JPasswordField fld_passwordPersonel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MudurSayfasi frame = new MudurSayfasi();
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
	public MudurSayfasi() {
		
	
		
		setTitle("Banka Yoneticisi");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		w_pane = new JPanel();
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hosgeldiniz, Sayin Müdür");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 11, 240, 18);
		w_pane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cikis Yap");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton.setBounds(586, 7, 102, 23);
		w_pane.add(btnNewButton);
		
		JButton btn_eklePersonel = new JButton("Personel Ekle");
		btn_eklePersonel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_eklePersonel.setBounds(22, 235, 138, 37);
		w_pane.add(btn_eklePersonel);
		
		
		JButton btn_personelSil = new JButton("Personel Sil");
		btn_personelSil.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_personelSil.setBounds(20, 363, 140, 37);
		w_pane.add(btn_personelSil);
		
		JButton btn_personelList = new JButton("Personel Listesi");
		btn_personelList.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_personelList.setBounds(331, 76, 140, 37);
		w_pane.add(btn_personelList);
		
		JButton btnNewButton_1_3 = new JButton("Kredi Onayi");
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_3.setBounds(331, 124, 140, 37);
		w_pane.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("Musteri Sil");
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_4.setBounds(170, 363, 140, 37);
		w_pane.add(btnNewButton_1_4);
		
		
		JButton btnNewButton_1_4_1 = new JButton("Musteri Listesi");
		btnNewButton_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_4_1.setBounds(499, 76, 140, 37);
		w_pane.add(btnNewButton_1_4_1);
		
		
		
		JLabel lbl_adSoyad = new JLabel("Ad Soyad");
		lbl_adSoyad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_adSoyad.setBounds(22, 64, 140, 18);
		w_pane.add(lbl_adSoyad);
		
		fld_namePersonel = new JTextField();
		fld_namePersonel.setBounds(22, 87, 140, 23);
		w_pane.add(fld_namePersonel);
		fld_namePersonel.setColumns(10);
		
		JLabel lbl_adSoyad_1 = new JLabel("T.C No");
		lbl_adSoyad_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_adSoyad_1.setBounds(20, 124, 140, 18);
		w_pane.add(lbl_adSoyad_1);
		
		fld_tcPersonel = new JTextField();
		fld_tcPersonel.setColumns(10);
		fld_tcPersonel.setBounds(20, 147, 140, 23);
		w_pane.add(fld_tcPersonel);
		
		JLabel lbl_adSoyad_2 = new JLabel("Sifre");
		lbl_adSoyad_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_adSoyad_2.setBounds(22, 178, 140, 18);
		w_pane.add(lbl_adSoyad_2);
		
		fld_ID = new JTextField();
		fld_ID.setColumns(10);
		fld_ID.setBounds(20, 335, 140, 23);
		w_pane.add(fld_ID);
		
		JLabel lbl_personelID = new JLabel("ID No");
		lbl_personelID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_personelID.setBounds(22, 306, 140, 18);
		w_pane.add(lbl_personelID);
		
		fld_passwordPersonel = new JPasswordField();
		fld_passwordPersonel.setBounds(20, 204, 140, 23);
		w_pane.add(fld_passwordPersonel);
		
	
		
	}

}
	
	
	