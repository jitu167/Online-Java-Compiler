import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Choice extends JFrame implements ActionListener
{
	Font font1;
	JButton search,remove,add,modify;
	String trimaddress,trimphone;
	ArrayList arr=new ArrayList(10);
	public Choice()
	{
		super("Choice Menu");
		setLayout(null);
		search=new JButton("Search");
		remove=new JButton("Remove");
		add=new JButton("Add");
		Image img=Toolkit.getDefaultToolkit().getImage("jitu-web.png");
		setIconImage(img);
		modify=new JButton("Modify");
	    font1 = new Font("Segoe Print", Font.ITALIC, 20);
	    search.setFont(font1);
	    remove.setFont(font1);
	    add.setFont(font1);
	    modify.setFont(font1);
	    search.setForeground(Color.GREEN);
	    remove.setForeground(Color.GREEN);
	    add.setForeground(Color.GREEN);
	    modify.setForeground(Color.GREEN);
		search.setBounds(10,20,190,20);
		remove.setBounds(10,80,190,20);
		add.setBounds(10,140,190,20);
		modify.setBounds(10,200,190,20);
	    add(remove);
	    add(search);
	    add(add);
	    add(modify);
		search.addActionListener(this);
		remove.addActionListener(this);
		add.addActionListener(this);
		modify.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==search)
		{
			Search c=new Search();
		     c.setVisible(true);
		     c.setResizable(false);
		     c.setSize(400,300);	
			 
			 
		}
		else if(ae.getSource()==remove)
		{
		
			Remove add=new Remove();
			add.setVisible(true);
		    add.setResizable(false);
		    add.setSize(400,300);	
		}
		else if(ae.getSource()==add)
		{
			 	
			Add add=new Add();
			add.setVisible(true);
		    add.setResizable(false);
		    add.setSize(400,300);	
		}
		else if(ae.getSource()==modify)
		{
			Modify add=new Modify();
			add.setVisible(true);
		    add.setResizable(false);
		    add.setSize(400,300);	
		}
	}

	class Search extends JFrame implements ActionListener
{
	JTextField txtname,txtphone,txtaddress;
	JLabel name,phone,address;
	JButton search;
	public Search()
	{
       super("Search Employees");
       setLayout(null);
       Font font1;	
	   font1=new Font("Segoe Print",Font.ITALIC,20);
	   name=new JLabel("Employee Name");
	   
	   txtname=new JTextField(10);
	   search=new JButton("Search");
	   txtphone=new JTextField(10);
	   
	   txtaddress=new JTextField(10);
	   phone=new JLabel("Employee Phone");
	   address=new JLabel("Employee Adress");
	   name.setFont(font1);
	   search.setFont(font1);
	   name.setBounds(10,20,190,20);
	   txtname.setBounds(190,20,190,20);
	   search.setBounds(10,100,200,20);
	   address.setBounds(10,150,190,20);
	   txtaddress.setBounds(190,150,190,20);
	   phone.setBounds(10,200,100,20);
	   txtphone.setBounds(190,200,190,20);
	  
	   add(phone);
	   add(address);
	   txtphone.setEditable(false);
	   txtaddress.setEditable(false);
	   add(txtaddress);
	   add(txtphone);
	   add(search);
	   add(name);
	   add(txtname);
		search.addActionListener(this);
		}
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==search)
			{
				String name=txtname.getText();
			employeeSearch(name);
			txtaddress.setText(trimaddress);
					txtphone.setText(trimphone);
		}
}
}
	class Add extends JFrame implements ActionListener
{
	JTextField txtname,txtaddress,txtphone;
	JLabel name,address,phone,sex;
	JRadioButton male,female;
	ButtonGroup gr;
	JButton search,cancel;
	public Add()
	{
       super("Add Employees");
       setLayout(null);
	   name=new JLabel("Employee Name");
	   txtname=new JTextField(10);
	   address=new JLabel(" Address");
	   txtaddress=new JTextField(10);
	   phone=new JLabel("Employee Phone");
	   txtphone=new JTextField(10);
	   search=new JButton("Add");
	   cancel=new JButton("Cancel");
	   sex=new JLabel("Sex");
	   male=new JRadioButton("Male");
	   female=new JRadioButton("Female");
	   gr=new ButtonGroup();
	   gr.add(male);
	   gr.add(female);
	   name.setBounds(10,20,100,20);
	   txtname.setBounds(120,20,100,20);
	   address.setBounds(10,50,100,20);
	   txtaddress.setBounds(120,50,100,20);
	   sex.setBounds(10,90,100,20);
	   male.setBounds(120,90,80,20);
	   female.setBounds(200,90,100,20);
	   phone.setBounds(10,120,100,20);
	   txtphone.setBounds(120,120,100,20);
	   cancel.setBounds(10,170,100,20);
	   search.setBounds(120,170,100,20);
	   add(name);
	   add(txtname);
		add(phone);
	   add(txtphone);
		add(address);
	   add(txtaddress);
		add(male);
	   add(female);
		add(sex);
	   add(search);
	   add(cancel);
	   search.addActionListener(this);
	   cancel.addActionListener(this);
		}
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==search)
			{
				int x;
				try
				{
				String tempname=txtname.getText();
				String tempphone=txtphone.getText();
				String tempaddress=txtaddress.getText();
			    long  tempphone1=Long.parseLong(tempphone);
				String total=tempname+" "+tempaddress+" "+tempphone;
				arr.add(total);
				txtname.setText("");
				txtphone.setText("0");
				txtaddress.setText("");
				Object aa=arr.get(0);
				System.out.print(aa);
				}
				catch(Exception e)
				{
					x=JOptionPane.showConfirmDialog(this,"Only Numbers are allowed");
					if(x==0)
					{
						txtphone.setText("0");
					}
				}
		
				}
				
			
			if(ae.getSource()==cancel)
			{
				txtname.setText("");
				txtphone.setText("");
				txtaddress.setText("");
				this.dispose();
			}
		}
}
class Remove extends JFrame implements ActionListener
{
	JTextField txtname;
	JLabel name;
	JButton search,cancel;
	public Remove()
	{
       super("Remove Employees");
       setLayout(null);
	   name=new JLabel("Employee Name");
	   txtname=new JTextField(10);
	   search=new JButton("Remove");
	   cancel=new JButton("Cancel");
	   name.setBounds(10,20,100,20);
	   txtname.setBounds(120,20,100,20);
	   
	   cancel.setBounds(10,170,100,20);
	   search.setBounds(120,170,100,20);
	   add(name);
	   add(txtname);
	   add(search);
	   add(cancel);
	   search.addActionListener(this);
	   cancel.addActionListener(this);
		}
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==search)
			{
				String ename=txtname.getText();
				String tempname=null;
				String trimname=null;
				for(int i=0;i<arr.size();i++)
				{
				tempname=(String)arr.get(i);
				int space=tempname.indexOf(" ");
				 trimname=tempname.substring(0,space);
				if(ename.compareTo(trimname)==0)
				{
					int x=JOptionPane.showConfirmDialog(this,"Sure to Delete","Delete",JOptionPane.YES_NO_OPTION);
					if(x==0)
					{
						arr.remove(i);
						int x1=JOptionPane.showConfirmDialog(this,"Yes Or No","Do you want to remove More",JOptionPane.YES_NO_OPTION);
						if(x1==1)
						{
							this.dispose();
						}
					}
				}
				}
				if(ename.compareTo(trimname)!=0)
				{
					int x=0;
					x=JOptionPane.showConfirmDialog(this,"Not Found","Error!!!",JOptionPane.YES_NO_OPTION);
					if(x==1)
					{
					

							this.dispose();
						}
					}
				
				
			}
			if(ae.getSource()==cancel)
			{
				this.dispose();
			}
		}
}
public int employeeSearch(String name)
{
            	String ename=name;
				String tempname=null;
				int i=0,k=0;
				for(i=0;i<arr.size();i++)
				{
				tempname=(String)arr.get(i);
				int space=tempname.indexOf(" ");
				String trimname=tempname.substring(0,space);
				String text=tempname.substring(space+1);
				if(ename.compareTo(trimname)==0)
				{
					int space1=text.indexOf(" ");
				    trimaddress=text.substring(0,space1);
				    String text1=text.substring(space1+1);
					trimphone=text1;
					System.out.print(trimname+"\n"+trimphone+"\n"+"\n"+trimaddress);
					System.out.print(trimname);
					k++;
					break;
				}
				
				}
				if(i==arr.size())
				{
					JOptionPane.showConfirmDialog(this,"NotFound","NOT FOUND",JOptionPane.YES_OPTION);
				}
				return k;
}
	class Modify extends JFrame implements ActionListener
{
	JTextField txtname,txtaddress,txtphone;
	JLabel name,address,phone,sex;
	JRadioButton male,female;
	ButtonGroup gr;
	JButton search,cancel,modify;
	public Modify()
	{
       super("Add Employees");
       setLayout(null);
	   name=new JLabel("Employee Name");
	   txtname=new JTextField(10);
	   address=new JLabel(" Address");
	   txtaddress=new JTextField(10);
	   phone=new JLabel("Employee Phone");
	   txtphone=new JTextField(10);
	   search=new JButton("Search");
	   modify=new JButton("Modify");
	   cancel=new JButton("Cancel");
	   sex=new JLabel("Sex");
	   male=new JRadioButton("Male");
	   female=new JRadioButton("Female");
	   gr=new ButtonGroup();
	   gr.add(male);
	   gr.add(female);
	   name.setBounds(10,20,100,20);
	   txtname.setBounds(120,20,100,20);
	   search.setBounds(10,50,100,20);
	   address.setBounds(10,80,100,20);
	   txtaddress.setBounds(120,80,100,20);
	   sex.setBounds(10,120,100,20);
	   male.setBounds(120,120,80,20);
	   female.setBounds(200,120,100,20);
	   phone.setBounds(10,150,100,20);
	   txtphone.setBounds(120,150,100,20);
	   cancel.setBounds(10,180,100,20);
	   modify.setBounds(120,180,100,20);
	   add(name);
	   add(txtname);
		add(phone);
	   add(txtphone);
		add(address);
	   add(txtaddress);
		add(male);
	   add(female);
		add(sex);
	   add(search);
	   add(cancel);
	   add(modify);
	   search.addActionListener(this);
	   cancel.addActionListener(this);
	   modify.addActionListener(this);
		}
		public void actionPerformed(ActionEvent ae)
		{
			int i=0;
			if(ae.getSource()==search)
			{
				String name=txtname.getText();
				i=employeeSearch(name);
				txtaddress.setText(trimaddress);
				txtphone.setText(trimphone);
			}
			if(ae.getSource()==modify)
			{
				int x=JOptionPane.showConfirmDialog(this,"Modify","Do you Want to Modify It",JOptionPane.YES_NO_OPTION);
				if(x==0)
				{
				String name=txtname.getText();
				String address=txtaddress.getText();
				String phone=txtphone.getText();
				String tot=name+" "+address+" "+phone;
				System.out.print("\n"+tot);
				arr.remove(i);
				arr.add(i,tot);
				}
				else{
					txtphone.setText("0");
					txtaddress.setText("");
				}
			}
			if(ae.getSource()==cancel)
			{
					txtaddress.setText("");
				txtphone.setText("");
			}
		}
}

}