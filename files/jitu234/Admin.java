import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.*;
public class Admin extends JFrame implements ActionListener
{
    static Admin ad;
	JLabel lbl1,lbl2;
	JTextField txt1,txt2;
	Font font1;
	JButton btnsub,btncancel;
	public Admin()
	{
		super("Administration Login");
		setLayout(null);
		lbl1=new JLabel("User Name");
		lbl2=new JLabel("Password");
		txt1=new JTextField(10);
		txt2=new JTextField(10);
		btnsub=new JButton("Submit");
		btncancel=new JButton("Cancel");
	    font1 = new Font("Segoe Print", Font.ITALIC, 20);
	    lbl1.setFont(font1);
	    lbl2.setFont(font1);
	    btncancel.setFont(font1);
	    btncancel.setForeground(Color.GREEN);
	     btnsub.setForeground(Color.GREEN);
	    btnsub.setFont(font1);
		lbl1.setBounds(10,20,190,20);
		lbl2.setBounds(10,100,190,20);
		txt1.setBounds(190,20,100,20);
		txt2.setBounds(190,100,100,20);
		btncancel.setBounds(10,220,190,20);
		btnsub.setBounds(200,220,190,20);
		add(btncancel);
		add(btnsub);
		add(lbl1);
		add(lbl2);
		add(txt1);
		add(txt2);
		btncancel.addActionListener(this);
		btnsub.addActionListener(this);
		Image img=Toolkit.getDefaultToolkit().getImage("jitu-web.png");
		setIconImage(img);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btncancel)
		{
			txt1.setText("");
			txt2.setText("");
		}
		if(ae.getSource()==btnsub)
		{
			 check();
		     
	}
	}
	public void check()
	{
		String name=txt1.getText();
		String pass=txt2.getText();
		if(name.compareTo("Admin")==0 &&pass.compareTo("Admin")==0)
		{
			Choice c=new Choice();
		     c.setVisible(true);
		     //c.setResizable(false);
		     c.setSize(400,300);	
			 ad.dispose();
			 	WindowListener lst=new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		};
		//c.addWindowListener(lst);
		}
		else{
			JOptionPane.showConfirmDialog(this,"User name or password is incorrect","Error",JOptionPane.CANCEL_OPTION);
			txt1.setText("");
			txt2.setText("");
		}
		}
	
	public static void main (String[] args) {
		 try {
            // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }

		ad=new Admin();
		ad.setVisible(true);
		ad.setResizable(false);
		ad.setSize(400,300);
			WindowListener lst=new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		};
		ad.addWindowListener(lst);
}

}