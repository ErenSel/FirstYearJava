package atm;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PersonelGirisi extends JFrame {
	 private JPanel contentPane;
	 private JPasswordField passwordField;
	 private JTextArea textArea;
	private static final long serialVersionUID = 1L;
	private static final String MUDUR_TC = "123456789";
	private static final String MUDUR_SIFRE = "123456789";
	static Map<Integer, Personel> personelListesi = new HashMap<>();
	
	static class Personel {
        private String ad;
        private String soyad;
        private String pozisyon;
        private String tcNo;
        private String sifre;

        public Personel(String ad, String soyad, String pozisyon, String tcNo, String sifre) {
            this.ad = ad;
            this.soyad = soyad;
            this.pozisyon = pozisyon;
            this.tcNo = tcNo;
            this.sifre = sifre;
        }

        public String getAd() {
            return ad;
        }

        public String getSoyad() {
            return soyad;
        }

        public String getPozisyon() {
            return pozisyon;
        }

        public String getTcNo() {
            return tcNo;
        }

        public String getSifre() {
            return sifre;
        }
    }
	
	static {
        personelListesi.put(1, new Personel("Ali", "Veli", "Müdür", "123456789", "sifre1"));
        personelListesi.put(2, new Personel("Ayşe", "Fatma", "Müdür Yardımcısı", "987654321", "sifre2"));
        personelListesi.put(3, new Personel("Ahmet", "Mehmet", "Muhasebe", "555555555", "sifre3"));
        personelListesi.put(4, new Personel("Zeynep", "Can", "Müşteri Temsilcisi", "111111111", "sifre4"));
    }

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonelGirisi frame = new PersonelGirisi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	 private void showPersonelSayfasi() {
	        
	        String tcNo = textArea.getText(); 
	        String sifre = new String(passwordField.getPassword()); 

	        
	        boolean dogruBilgiler = kontrolEt(tcNo, sifre);

	        if (dogruBilgiler) {
	            
	            if (kullaniciMudurMu(tcNo, sifre)) {
	            	showMudurSayfasi();
	               
	            } 
	            else {
	                
	                PersonelSayfasi personelFrame = new PersonelSayfasi();
	                personelFrame.setVisible(true);
	                dispose(); 
	            }
	        } 
	        else {
	            
	            JOptionPane.showMessageDialog(null, "Geçersiz TC No veya şifre.");
	        }
	    }
	 private boolean kontrolEt(String tcNo, String sifre) {
		 for (Personel personel : personelListesi.values()) {
			 if (personel.getTcNo().equals(tcNo) && personel.getSifre().equals(sifre)) {
				 return true;
			}
		}
		 if (kullaniciMudurMu(tcNo, sifre)) {
			 return true;
			
		}
		 
		 else {
			return false;
		}
	    
		}
	 
	    private boolean kullaniciMudurMu(String tcNo, String şifre) {
	    	if(tcNo.equals(MUDUR_TC) && şifre.equals(MUDUR_SIFRE)) {
	    		showMudurSayfasi();
	    		return true;
	    	}
	        
	        return false; 
	    }
	
	private void showLoginFrame() {
        Login loginFrame = new Login();
        loginFrame.setVisible(true);
        dispose(); 
    }
	private void showMudurSayfasi() {
	    MudurSayfasi mudurFrame = new MudurSayfasi();
	    mudurFrame.setVisible(true);
	    dispose(); 
	}

	/**
	 * Create the frame.
	 */
	public PersonelGirisi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1104, 783);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("PERSONEL GİRİŞ SAYFASI");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel.setBounds(212, 84, 640, 109);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("      TC NO : ");
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNewLabel_1.setBounds(265, 354, 126, 45);
        contentPane.add(lblNewLabel_1);

        textArea = new JTextArea();
        textArea.setRows(1);
        textArea.setTabSize(4);
        textArea.setFont(new Font("Segoe UI", Font.BOLD, 16));
        textArea.setBounds(401, 359, 296, 30);
        contentPane.add(textArea);

        JLabel lblNewLabel_2 = new JLabel("Şifre : ");
        lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNewLabel_2.setBounds(301, 425, 100, 45);
        contentPane.add(lblNewLabel_2);

        passwordField = new JPasswordField();
        passwordField.setBounds(401, 436, 296, 30);
        contentPane.add(passwordField);

        JButton btnNewButton = new JButton("Giriş");
        btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnNewButton.setBounds(401, 531, 100, 30);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPersonelSayfasi();
            }
        });

        JButton btnTemizle = new JButton("Temizle");
        btnTemizle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnTemizle.setBounds(597, 531, 100, 30);
        contentPane.add(btnTemizle);

        JButton btnGeri = new JButton("Geri");
        btnGeri.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnGeri.setBounds(498, 587, 100, 30);
        btnGeri.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLoginFrame();
            }
        });
        contentPane.add(btnGeri);

        
        btnTemizle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                passwordField.setText("");
            }
        });
	}
	
}
