package atm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class KayitOl extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JRadioButton r1,r2,r3,r4,r5;
    JButton b;
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected Map<String, String> userData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new KayitOl().setVisible(true);
	}
	

	/**
	 * Create the frame.
	 */
	public KayitOl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b = new JButton("Kaydet");
		setBounds(100, 100, 1085, 777);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		b.addActionListener(this);
        userData = new HashMap<>();
        

		setContentPane(contentPane);
		contentPane.setLayout(null);
setTitle("Yeni Kayıt Formu");
        
        ImageIcon i1 = new ImageIcon(KayitOl.class.getResource("/atm/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(20, 0, 100, 100);
        getContentPane().add(l11);
        
        l1 = new JLabel("FORM NO. "+first);
        l1.setFont(new Font("Raleway", Font.BOLD, 38));
        
        l2 = new JLabel("Sayfa 1: Kişisel Detaylar");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l3 = new JLabel("İsim:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l4 = new JLabel("TC No:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l5 = new JLabel("Doğum Tarihi:");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l6 = new JLabel("Cinsiyet:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l7 = new JLabel("Email Adresi:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l8 = new JLabel("Evlilik Durumu:");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l9 = new JLabel("Adres:");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l10 = new JLabel("Şehir:");
        l10.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l11 = new JLabel("İlçe:");
        l11.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l12 = new JLabel("Şifre:");
        l12.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l13 = new JLabel("Gün");
        l13.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l14 = new JLabel("Ay");
        l14.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l15 = new JLabel("Yıl");
        l15.setFont(new Font("Raleway", Font.BOLD, 14));
        
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t6 = new JTextField();
        t6.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t7 = new JTextField();
        t7.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t8 = new JTextField();
        t8.setFont(new Font("Raleway", Font.BOLD, 14));
        
       
        
        b = new JButton("Kaydet");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        r1 = new JRadioButton("Erkek");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("Kadın");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        
        r3 = new JRadioButton("Evli");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        
        r4 = new JRadioButton("Bekar");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        
        r5 = new JRadioButton("Diğer");
        r5.setFont(new Font("Raleway", Font.BOLD, 14));
        r5.setBackground(Color.WHITE);
        
        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(r3);
        groupstatus.add(r4);
        groupstatus.add(r5);
        getContentPane().setLayout(null);
        l1.setBounds(140,20,600,40);
        getContentPane().add(l1);
        
        l2.setBounds(290,80,600,30);
        getContentPane().add(l2);
        
        l3.setBounds(100,140,100,30);
        getContentPane().add(l3);
        
        t1.setBounds(300,140,400,30);
        getContentPane().add(t1);
        
        l4.setBounds(100,190,200,30);
        getContentPane().add(l4);
        
        t2.setBounds(300,190,400,30);
        getContentPane().add(t2);
        
        l5.setBounds(100,240,200,30);
        getContentPane().add(l5);
        t8.setBounds(300, 240, 400, 30);
        getContentPane().add(t8);
        
        
        
        l6.setBounds(100,290,200,30);
        getContentPane().add(l6);
        
        r1.setBounds(300,290,80,30);
        getContentPane().add(r1);
        
        r2.setBounds(450,290,90,30);
        getContentPane().add(r2);
        
        l7.setBounds(100,340,200,30);
        getContentPane().add(l7);
        
        t3.setBounds(300,340,400,30);
        getContentPane().add(t3);
        
        l8.setBounds(100,390,200,30);
        getContentPane().add(l8);
        
        r3.setBounds(300,390,100,30);
        getContentPane().add(r3);
        
        r4.setBounds(450,390,100,30);
        getContentPane().add(r4);
        
        r5.setBounds(635,390,100,30);
        getContentPane().add(r5);
        
        
        
        l9.setBounds(100,440,200,30);
        getContentPane().add(l9);
        
        t4.setBounds(300,440,400,30);
        getContentPane().add(t4);
        
        l10.setBounds(100,490,200,30);
        getContentPane().add(l10);
        
        t5.setBounds(300,490,400,30);
        getContentPane().add(t5);
        
        l11.setBounds(100,540,200,30);
        getContentPane().add(l11);
        
        t6.setBounds(300,540,400,30);
        getContentPane().add(t6);
        
        l12.setBounds(100,590,200,30);
        getContentPane().add(l12);
        
        t7.setBounds(300,590,400,30);
        getContentPane().add(t7);
        
        b.setBounds(620,660,100,30);
        getContentPane().add(b);
        
        b.addActionListener(this); 
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(500,120);
        setVisible(true);
	}
public void actionPerformed(ActionEvent ae){
        
        String formno = first;
        String name = t1.getText();
        String fname = t2.getText();
        
        
        String gender = null;
        if(r1.isSelected()){ 
            gender = "Male";
        }else if(r2.isSelected()){ 
            gender = "Female";
        }
            
        String email = t3.getText();
        String marital = null;
        if(r3.isSelected()){ 
            marital = "Married";
        }else if(r4.isSelected()){ 
            marital = "Unmarried";
        }else if(r5.isSelected()){ 
            marital = "Other";
        }
           
        String address = t4.getText();
        String city = t5.getText();
        String pincode = t6.getText();
        String state = t7.getText();
        

        try{
           
            if(t6.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Bütün alanları doldurun");
            }else{
            	userData.put("FormNo", formno);
                userData.put("Name", name);
                userData.put("FName", fname);
                userData.put("Gender", gender);
                userData.put("Email", email);
                userData.put("MaritalStatus", marital);
                userData.put("Address", address);
                userData.put("City", city);
                userData.put("Pincode", pincode);
                userData.put("State", state);

                
                System.out.println("User Data: " + userData);
                
                
            }
            
        }catch(Exception e){
             e.printStackTrace();
        }
        
    }
}
