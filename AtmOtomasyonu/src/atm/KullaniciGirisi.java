package atm;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class KullaniciGirisi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField passwordField;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    KullaniciGirisi frame = new KullaniciGirisi();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void showKullaniciSayfasi() {
    	KullaniciSayfasi kSayfasi = new KullaniciSayfasi(" ");
    	kSayfasi.setVisible(true);
    	dispose();
    }

    private void showLoginFrame() {
        Login loginFrame = new Login();
        loginFrame.setVisible(true);
        dispose(); 
    }

    /**
     * Create the frame.
     */
    public KullaniciGirisi() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1104, 783);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("KULLANICI GİRİŞ SAYFASI");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel.setBounds(212, 84, 640, 109);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Kart Numarası : ");
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
                showKullaniciSayfasi();
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
