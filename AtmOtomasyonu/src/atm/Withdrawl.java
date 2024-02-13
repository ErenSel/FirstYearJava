
package atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;


public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pin;
    Withdrawl(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(Withdrawl.class.getResource("/atm/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);
        
        l1 = new JLabel("ÇEKMEK İSTEDİĞİNİZ TUTARI GİRİNİZ");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        l2 = new JLabel("LÜTFEN TUTARI GİRİN");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        b1 = new JButton("ÇEK");
        b2 = new JButton("GERİ");
        
        setLayout(null);
        
        l1.setBounds(190,350,400,20);
        l3.add(l1);
        
        l2.setBounds(190,400,400,20);
        l3.add(l2);
        
        t1.setBounds(190,450,330,30);
        l3.add(t1);
        
        b1.setBounds(390,588,150,35);
        l3.add(b1);
        
        b2.setBounds(390,633,150,35);
        l3.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
    	 String amount = t1.getText(); 
    	    
    	    if (ae.getSource()==b1) {
				
    	    	if (amount.isEmpty() || !amount.matches("\\d+")) {
        	        JOptionPane.showMessageDialog(this, "Lütfen geçerli bir tutar girin.", "Hata", JOptionPane.ERROR_MESSAGE);
        	        return;
        	        }
			}
    	    else if(ae.getSource()==b2){
                setVisible(false);
                new KullaniciSayfasi(pin).setVisible(true);
            }
    	
    }
        
    
    
    public static void main(String[] args){
        new Withdrawl("").setVisible(true);
    }
}
