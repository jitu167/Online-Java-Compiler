import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
class Delete extends JFrame implements ActionListener
{
	JLabel lblh1;
	JButton btndelete;
	JComboBox cbecode;
	int i=0;
	String[] stecode=new String[100];
	
	public Delete()
	{
		super("Insert employee code/name for delete");
		setLayout(null);
 		
 		lblh1=new JLabel("Select employee code",JLabel.RIGHT);
 		btndelete=new JButton("Delete");
 		
 	//	String[] stecode=new String[100];
 		
 	//	int i=0;
 		//fetching ecode
 			try
 			{
 			Connection con=null;
			Statement stmt=null;
			ResultSet rs=null;
 			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","project","project");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select ecode from employee");
			while(rs.next())
				{
					stecode[i]=rs.getString("ecode");
					i++;
				}
			
			
 			}
 			catch(Exception e)
 			{
 			
 			}
 		
 		
 		
 		cbecode=new JComboBox(stecode);
 		
 		//settting bounds
 		
 		lblh1.setBounds(20,50,150,20);
 		cbecode.setBounds(180,50,80,20);
 		btndelete.setBounds(130,80,80,20);
 		
 		btndelete.addActionListener(this);
 		//adding component to frame
 		
 		add(lblh1);
 		add(cbecode);
 		add(btndelete);
 		
 	}
 	public void actionPerformed(ActionEvent ae) 
 	{	
 		if(ae.getSource()==btndelete)
 		{	
 			String secode=(String)cbecode.getSelectedItem();
 			
 			int result=JOptionPane.showConfirmDialog(this," Are you sure to delet "+secode,"Confirm Button",JOptionPane.YES_NO_OPTION);
			if (result==JOptionPane.YES_OPTION)
			{
					
				
 			
 			//deleting from employeedatabase
				Connection con=null;
				Statement stmt=null;
				ResultSet rs=null;	
				
					try
					{
					Class.forName("oracle.jdbc.driver.OracleDriver");

		
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","project","project");
					stmt=con.createStatement();	
					String query;
					query="delete from employee where ecode='"+secode+"'";
					stmt.executeUpdate(query);
					this.dispose();
					}
					
					catch(Exception e)
					{
						
					}
					
					
			}	
			
			
				
 		}
 	
 
 		
 	}
 	
	
	
}
class Search extends JFrame implements ActionListener
{
	JLabel h1,h2,h3,lblecode,lblename,lblsal,lblct,lblsex,lbll1,lbll2,lblstate,lblpincode,lblmobile,lblsalary,lblda,lblta;
	JLabel lblpf,lblhra,lblit,lblns,l1,l2,l3,lbldob;
	JTextField txtecode,txtename,txtl1,txtl2,txtpincode,txtmobile,txtsalary,txtda,txtta,txtpf,txthra,txtit,txtsal;
	JButton btnsubmit,btnclose;
	JRadioButton male,female;
	String cities[]={"Cuttack","Bbsr","khurda","Sambalpur","Bargarh"};
	String state[]={"ORISSA","BIHAR"};
	JComboBox ct,st;
    Font font = new Font("Segoe Print", Font.ITALIC, 14);
    float sal,hra,da,ta,it,ns,gs,pf;
    String secode,sename,ssex,sl1,sl2,scity,sstate,spincode,smobile,ssa;
	ButtonGroup bg;

	public Search()
	{
		super("Employee data insert Form");
		setLayout(null);
		
		h1=new JLabel("PERSONAL DETAIL");
		l1=new JLabel("=====================================================");
		lblecode=new JLabel("Employee Code : *",JLabel.RIGHT);
		lblename=new JLabel("Employee Name : *",JLabel.RIGHT);
		lblsex=new JLabel("Sex",JLabel.RIGHT);
		lbldob=new JLabel("Dob",JLabel.RIGHT);
		h2=new JLabel("ADDRESS");
		l2=new JLabel("=====================================================");
		lbll1=new JLabel("Line1*",JLabel.RIGHT);
		lbll2=new JLabel("Line2",JLabel.RIGHT);
		lblct=new JLabel("City",JLabel.RIGHT);
		lblstate=new JLabel("State",JLabel.RIGHT);
		lblpincode=new JLabel("Picode",JLabel.RIGHT);
		lblmobile=new JLabel("Mobile",JLabel.RIGHT);
		lbll1=new JLabel("Line1",JLabel.RIGHT);
		h3=new JLabel("SALARY BACKUP");
		l3=new JLabel("======================================================");
		lblsalary=new JLabel("Salary *",JLabel.RIGHT);
		lblda=new JLabel("Da",JLabel.RIGHT);
		lblta=new JLabel("Ta",JLabel.RIGHT);
		lblpf=new JLabel("Pf",JLabel.RIGHT);
		lblit=new JLabel("It",JLabel.RIGHT);
		lblhra=new JLabel("Hra",JLabel.RIGHT);
		lblsal=new JLabel("Net Salary :",JLabel.RIGHT);	
		
	
	
	    
	    male=new JRadioButton("male");
	    female=new JRadioButton("female");
	    
	    
	     
	     bg=new ButtonGroup();
	     bg.add(male);
	     bg.add(female);
	      
	     ct=new JComboBox(cities);
	     st=new JComboBox(state);
	     
		txtecode=new JTextField(10);
		txtename=new JTextField(30);
		txtl1=new JTextField(10);
		txtl2=new JTextField(10);
		txtpincode=new JTextField(10);
		txtmobile=new JTextField(10);
		txtsalary=new JTextField(10);
		txtda=new JTextField(10);
		txtta=new JTextField(10);
		txtpf=new JTextField(10);
		txthra=new JTextField(10);
		txtit=new JTextField(10);
		txtsal=new JTextField(15);
		
		
	;
		btnsubmit=new JButton("Submit");
		btnclose=new JButton("close");
		
		//setBounds() method for absolute positioning.
		h1.setBounds(20,20,160,20);
		l1.setBounds(20,36,160,5);
		lblecode.setBounds(20,70,170,20);
		txtecode.setBounds(200,70,180,20);
		lblename.setBounds(20,100,170,20);
		txtename.setBounds(200,100,180,20);
		lblsex.setBounds(20,130,170,20);
		male.setBounds(200,130,60,20);
		female.setBounds(260,130,90,20);
		lbldob.setBounds(20,160,170,20);
		h2.setBounds(20,190,180,20);
		l2.setBounds(20,206,180,5);
		lbll1.setBounds(20,220,160,20);
		txtl1.setBounds(200,220,180,20);
		lbll2.setBounds(20,250,160,20);
		txtl2.setBounds(200,250,180,20);
		
		lblct.setBounds(20,280,80,20);
		ct.setBounds(100,280,80,20);
		lblstate.setBounds(200,280,80,20);
		st.setBounds(300,280,80,20);
		lblpincode.setBounds(20,310,80,20);
		txtpincode.setBounds(100,310,80,20);
		lblmobile.setBounds(200,310,80,20);
		txtmobile.setBounds(300,310,80,20);
		h3.setBounds(20,340,180,20);
		l3.setBounds(20,356,180,5);
		lblsalary.setBounds(20,390,70,20);
		txtsalary.setBounds(100,390,80,20);
		lblda.setBounds(200,390,70,20);
		txtda.setBounds(300,390,80,20);
		lblta.setBounds(20,420,70,20);
		txtta.setBounds(100,420,80,20);
		lblpf.setBounds(200,420,70,20);
		txtpf.setBounds(300,420,80,20);
		lblhra.setBounds(20,450,70,20);
		txthra.setBounds(100,450,80,20);
		lblit.setBounds(200,450,70,20);
		txtit.setBounds(300,450,80,20);
		lblsal.setBounds(20,480,70,20);
		txtsal.setBounds(100,480,80,20);
		btnsubmit.setBounds(240,510,80,20);
		btnclose.setBounds(340,510,80,20);
		
		
		h1.setFont(font);
		h2.setFont(font);
		h3.setFont(font);
		h1.setForeground(Color.blue);
		h2.setForeground(Color.blue);
		h3.setForeground(Color.blue);
		l1.setForeground(Color.orange);
		l2.setForeground(Color.orange);
		l3.setForeground(Color.orange);

		//button to execute the program
		
		btnsubmit.addActionListener(this);
		btnclose.addActionListener(this);
		
		
		

		
		
		//add components
		add(h1);
		add(l1);
		add(lblecode);
		add(txtecode);
		add(lblename);
		add(txtename);
		add(lblsex);
		add(male);
		add(female);
		add(lbldob);
		add(h2);
		add(l2);
		add(lbll1);
		add(txtl1);
		add(lbll2);
		add(txtl2);
		add(lblstate);
		add(st);
		add(lblct);
		add(ct);
		add(lblpincode);
		add(txtpincode);
		add(lblmobile);
		add(txtmobile);
		add(h3);
		add(l3);
		add(lblsalary);
		add(txtsalary);
		add(lblda);
		add(txtda);
		add(lblta);
		add(txtta);
		add(lblpf);
		add(txtpf);
		add(lblhra);
		add(txthra);
		add(lblit);
		add(txtit);
		add(lblsal);
		add(txtsal);
		add(btnsubmit);
		add(btnclose);
		
		txtta.setEditable(false);
		txtda.setEditable(false);
		txtit.setEditable(false);
		txtsal.setEditable(false);
		txtpf.setEditable(false);
		txthra.setEditable(false);
		
		txtta.setBackground(Color.gray);
		txtda.setBackground(Color.gray);
		txtit.setBackground(Color.gray);
		txtsal.setBackground(Color.gray);
		txtpf.setBackground(Color.gray);
		txthra.setBackground(Color.gray);
		
		txtsalary.setText("0");
	
	}
		public void actionPerformed(ActionEvent ae) 
 		{
 			if(ae.getSource()==btnsubmit)
 			{
 				int result=JOptionPane.showConfirmDialog(this," Are you sure to submit it","Confirm Button",JOptionPane.YES_NO_OPTION);
				if (result==JOptionPane.YES_OPTION)
					{
		 		sename=txtename.getText();
		 		secode=txtecode.getText();
		 		
		 	//condition check for sex
		 		if(male.isSelected())
		 		{
		 			ssex="m";
		 		}
		 		else if(female.isSelected())
		 		{
		 			ssex="f";
		 		}
		 		
		 		
		 		sl1=txtl1.getText();
		 		sl2=txtl2.getText();
		 		scity=(String)ct.getSelectedItem();
		 		sstate=(String)st.getSelectedItem();
		 		spincode=txtpincode.getText();
		 		smobile=txtmobile.getText();
		 		
		 		ssa=txtsalary.getText();
		 		
		 		
		 		sal=Float.parseFloat(ssa);
		 		
		 		
		 		if(secode.length()==0)
		 		JOptionPane.showMessageDialog(this,"Enter employee code");
		 		else if(sename.length()==0)
		 		JOptionPane.showMessageDialog(this,"Enter employee name");
		 		
		 		else if(male.isSelected()==false&&female.isSelected()==false)
		 		JOptionPane.showMessageDialog(this,"Select sex");
		 		else if(sl1.length()==0)
		 		JOptionPane.showMessageDialog(this,"Enter employee address in line1");
		 		else if(spincode.length()==0)
		 		JOptionPane.showMessageDialog(this,"Enter pincode");
		 		else if(smobile.length()==0)
		 		JOptionPane.showMessageDialog(this,"Enter mobile number");
		 		else if(ssa.length()==1)
		 		JOptionPane.showMessageDialog(this,"Enter employee salary");		 		
		 		
		 		
		 		
		 		else
		 			{
		 		
		 			
		 			hra=(float)(sal*0.3);
		 			da=(float)(sal*0.2);
		 			ta=(float)(sal*0.1);
		 			ns=(float)(sal+da+ta+hra);
		 			pf=(float)(sal*0.07);
		 			it=(float)((ns+pf)*0.15);
		 			gs=(float)(ns-pf-it);
		 			
		 			txthra.setText(""+hra);
		 			txtda.setText(""+da);
		 			txtta.setText(""+ta);
		 			txtpf.setText(""+pf);
		 			txtit.setText(""+it);
		 			txtsal.setText(""+gs);	
		 			JOptionPane.showMessageDialog(this,"Salary is calculated");
		 			JOptionPane.showMessageDialog(this,"Data inserted to data base");
		 			
		 			Connection con=null;
					Statement stmt=null;
					ResultSet rs=null;
				
					try
					{
					Class.forName("oracle.jdbc.driver.OracleDriver");

		
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","project","project");
					stmt=con.createStatement();	
					String query;
					
					query="delete from employee where ecode='"+secode+"'";
					stmt.executeUpdate(query);
					
					query="insert into employee (ecode,ename,sex,address1,address2,city,state,pincode,contact,sal,da,ta,pf,hra,it,gross) values ('"+secode+"','"+sename+"','"+ssex+"','"+sl1+"','"+sl2+"','"+scity+"','"+sstate+"','"+spincode+"','"+smobile+"',"+sal+","+da+","+ta+","+pf+","+hra+","+it+","+gs+")";
					stmt.executeUpdate(query);
					
					}
					catch(Exception e)
					{
						
					}	
		 			
		 			}
		 		}	
		 			
		
				
					
 			}
 	
 			if(ae.getSource()==btnclose)
 			{
 				this.dispose();
 			}
 		
 		
 		}
 		
 		
		
	
	
	
}

class Searchbyename extends JFrame implements ActionListener
{
	JLabel lblh1;
	JButton search;
	JComboBox cbename;
	public Searchbyename()
	{
		super("select employee name for search");
		setLayout(null);
 		
 		lblh1=new JLabel("Select employee name",JLabel.RIGHT);
 		search=new JButton("Search");
 		
 		String[] stename=new String[100];
 		
 		int i=0;
 		//fetching ename
 			try
 			{
 			Connection con=null;
			Statement stmt=null;
			ResultSet rs=null;
 			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","project","project");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select ename from employee");
			while(rs.next())
				{
					stename[i]=rs.getString("ename");
					i++;
				}
			
			
 			}
 			catch(Exception e)
 			{
 			
 			}
 		
 		
 		
 		cbename=new JComboBox(stename);
 		
 		//settting bounds
 		
 		lblh1.setBounds(20,50,150,20);
 		cbename.setBounds(180,50,80,20);
 		search.setBounds(130,80,80,20);
 		
 		search.addActionListener(this);
 		//adding component to frame
 		
 		add(lblh1);
 		add(cbename);
 		add(search);
 		
 	}
 	public void actionPerformed(ActionEvent ae) 
 	{
 		if(ae.getSource()==search)
 		{
 			String sename=(String)cbename.getSelectedItem();
 			
 			
			Connection con=null;
			Statement stmt=null;
			ResultSet rs=null;	
			
			try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","project","project");
					stmt=con.createStatement();
					rs=stmt.executeQuery("select ecode,ename,sex,address1,address2,city,state,pincode,contact,sal,da,ta,pf,hra,it,gross from employee where ename='"+sename+"'");
				
					while(rs.next())
					{
					
					
					String secode=rs.getString("ecode");
					sename=rs.getString("ename");
					String sex=rs.getString("sex");
					String sl1=rs.getString("address1");
					String sl2=rs.getString("address2");
					String city=rs.getString("city");
					String state=rs.getString("state");
					String pincode=rs.getString("pincode");
					String mobile=rs.getString("contact");
					String salary=rs.getString("sal");
					String da=rs.getString("da");
					String ta=rs.getString("ta");
					String pf=rs.getString("pf");
					String hra=rs.getString("hra");
					String it=rs.getString("it");
					String ns=rs.getString("gross");
					
					
					
					
					Search sr=new Search();
					sr.setSize(600,700);
					sr.setVisible(true);
					
					sr.txtecode.setText(secode);
					sr.txtename.setText(sename);
					
					sr.txtl1.setText(sl1);
					sr.txtl2.setText(sl2);
					sr.txtpincode.setText(pincode);
					sr.txtmobile.setText(mobile);
					sr.ct.setSelectedItem(city);
					sr.st.setSelectedItem(state);
				
				//condition statement for sex
					String s="m";
					if(sex.equalsIgnoreCase(s))
					sr.male.setSelected(true);
					else
					sr.female.setSelected(true);
		 			sr.txtsalary.setText(salary);
		 			sr.txthra.setText(""+hra);
		 			sr.txtda.setText(""+da);
		 			sr.txtta.setText(""+ta);
		 			sr.txtpf.setText(""+pf);
		 			sr.txtit.setText(""+it);
		 			sr.txtsal.setText(""+ns);
					
				
					
					
					}
										
					
				}
				
					catch(Exception e)
					{
						
					}
			
			
				
 		}
 	
 
 		
 	}
 	
 	
}

class Searchbyecode extends JFrame implements ActionListener
{
	JLabel lblh1;
	JButton search;
	JComboBox cbecode;
	public Searchbyecode()
	{
		super("Insert employee code for search");
		setLayout(null);
 		
 		lblh1=new JLabel("Select employee code",JLabel.RIGHT);
 		search=new JButton("Search");
 		
 		String[] stecode=new String[100];
 		
 		int i=0;
 		//fetching ecode
 			try
 			{
 			Connection con=null;
			Statement stmt=null;
			ResultSet rs=null;
 			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","project","project");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select ecode from employee");
			while(rs.next())
				{
					stecode[i]=rs.getString("ecode");
					i++;
				}
			
			
 			}
 			catch(Exception e)
 			{
 			
 			}
 		
 		
 		
 		cbecode=new JComboBox(stecode);
 		
 		//settting bounds
 		
 		lblh1.setBounds(20,50,150,20);
 		cbecode.setBounds(180,50,80,20);
 		search.setBounds(130,80,80,20);
 		
 		search.addActionListener(this);
 		//adding component to frame
 		
 		add(lblh1);
 		add(cbecode);
 		add(search);
 		
 	}
 	public void actionPerformed(ActionEvent ae) 
 	{
 		if(ae.getSource()==search)
 		{
 			String secode=(String)cbecode.getSelectedItem();
 			
 			
			Connection con=null;
			Statement stmt=null;
			ResultSet rs=null;	
			
			try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","project","project");
					stmt=con.createStatement();
					rs=stmt.executeQuery("select ecode,ename,sex,address1,address2,city,state,pincode,contact,sal,da,ta,pf,hra,it,gross from employee where ecode='"+secode+"'");
				
					while(rs.next())
					{
					
					
					secode=rs.getString("ecode");
					String sename=rs.getString("ename");
					String sex=rs.getString("sex");
					String sl1=rs.getString("address1");
					String sl2=rs.getString("address2");
					String city=rs.getString("city");
					String state=rs.getString("state");
					String pincode=rs.getString("pincode");
					String mobile=rs.getString("contact");
					String salary=rs.getString("sal");
					String da=rs.getString("da");
					String ta=rs.getString("ta");
					String pf=rs.getString("pf");
					String hra=rs.getString("hra");
					String it=rs.getString("it");
					String ns=rs.getString("gross");
					
					
					
					
					Search sr=new Search();
					sr.setSize(600,700);
					sr.setVisible(true);
					
					sr.txtecode.setText(secode);
					sr.txtename.setText(sename);
					
					sr.txtl1.setText(sl1);
					sr.txtl2.setText(sl2);
					sr.txtpincode.setText(pincode);
					sr.txtmobile.setText(mobile);
					sr.ct.setSelectedItem(city);
					sr.st.setSelectedItem(state);
				
				//condition statement for sex
					String s="m";
					if(sex.equalsIgnoreCase(s))
					sr.male.setSelected(true);
					else
					sr.female.setSelected(true);
		 			sr.txtsalary.setText(salary);
		 			sr.txthra.setText(""+hra);
		 			sr.txtda.setText(""+da);
		 			sr.txtta.setText(""+ta);
		 			sr.txtpf.setText(""+pf);
		 			sr.txtit.setText(""+it);
		 			sr.txtsal.setText(""+ns);
					
				
					
					
					}
										
					
				}
				
					catch(Exception e)
					{
						
					}
			
			
				
 		}
 	
 
 		
 	}
 	
 	
}

class Insert extends JFrame implements ActionListener
 {
 	JLabel h1,h2,h3,lblecode,lblename,lblsal,lblct,lblsex,lbll1,lbll2,lblstate,lblpincode,lblmobile,lblsalary,lblda,lblta;
	JLabel lblpf,lblhra,lblit,lblns,l1,l2,l3,lbldob;
	JTextField txtecode,txtename,txtl1,txtl2,txtpincode,txtmobile,txtsalary,txtda,txtta,txtpf,txthra,txtit,txtsal;
	JButton btncalculate, btnReset,btnsubmit,btnclose;
	JRadioButton male,female;
	String cities[]={"Cuttack","Bbsr","khurda","Sambalpur","Bargarh"};
	String state[]={"ORISSA","BIHAR"};
	JComboBox ct,st;
    Font font = new Font("Segoe Print", Font.ITALIC, 14);
    float sal,hra,da,ta,it,ns,gs,pf;
    String secode,sename,ssex,sl1,sl2,scity,sstate,spincode,smobile,ssa;
	ButtonGroup bg;

	public Insert()
	{
		super("Employee data insert Form");
		setLayout(null);
		
		h1=new JLabel("PERSONAL DETAIL");
		l1=new JLabel("=====================================================");
		lblecode=new JLabel("Employee Code : *",JLabel.RIGHT);
		lblename=new JLabel("Employee Name : *",JLabel.RIGHT);
		lblsex=new JLabel("Sex",JLabel.RIGHT);
		lbldob=new JLabel("Dob",JLabel.RIGHT);
		h2=new JLabel("ADDRESS");
		l2=new JLabel("=====================================================");
		lbll1=new JLabel("Line1*",JLabel.RIGHT);
		lbll2=new JLabel("Line2",JLabel.RIGHT);
		lblct=new JLabel("City",JLabel.RIGHT);
		lblstate=new JLabel("State",JLabel.RIGHT);
		lblpincode=new JLabel("Picode",JLabel.RIGHT);
		lblmobile=new JLabel("Mobile",JLabel.RIGHT);
		lbll1=new JLabel("Line1",JLabel.RIGHT);
		h3=new JLabel("SALARY BACKUP");
		l3=new JLabel("======================================================");
		lblsalary=new JLabel("Salary *",JLabel.RIGHT);
		lblda=new JLabel("Da",JLabel.RIGHT);
		lblta=new JLabel("Ta",JLabel.RIGHT);
		lblpf=new JLabel("Pf",JLabel.RIGHT);
		lblit=new JLabel("It",JLabel.RIGHT);
		lblhra=new JLabel("Hra",JLabel.RIGHT);
		lblsal=new JLabel("Net Salary :",JLabel.RIGHT);	
		
	
	
	    
	    male=new JRadioButton("male");
	    female=new JRadioButton("female");
	    
	    
	     
	     bg=new ButtonGroup();
	     bg.add(male);
	     bg.add(female);
	      
	     ct=new JComboBox(cities);
	     st=new JComboBox(state);
	     
		txtecode=new JTextField(10);
		txtename=new JTextField(30);
		txtl1=new JTextField(10);
		txtl2=new JTextField(10);
		txtpincode=new JTextField(10);
		txtmobile=new JTextField(10);
		txtsalary=new JTextField(10);
		txtda=new JTextField(10);
		txtta=new JTextField(10);
		txtpf=new JTextField(10);
		txthra=new JTextField(10);
		txtit=new JTextField(10);
		txtsal=new JTextField(15);
		
		
		btncalculate=new JButton("Calculate");
		btnReset=new JButton("Reset");
		btnsubmit=new JButton("submit");
		btnclose=new JButton("close");
		
		//setBounds() method for absolute positioning.
		h1.setBounds(20,20,160,20);
		l1.setBounds(20,36,160,5);
		lblecode.setBounds(20,70,170,20);
		txtecode.setBounds(200,70,180,20);
		lblename.setBounds(20,100,170,20);
		txtename.setBounds(200,100,180,20);
		lblsex.setBounds(20,130,170,20);
		male.setBounds(200,130,60,20);
		female.setBounds(260,130,90,20);
		lbldob.setBounds(20,160,170,20);
		h2.setBounds(20,190,180,20);
		l2.setBounds(20,206,180,5);
		lbll1.setBounds(20,220,160,20);
		txtl1.setBounds(200,220,180,20);
		lbll2.setBounds(20,250,160,20);
		txtl2.setBounds(200,250,180,20);
		
		lblct.setBounds(20,280,80,20);
		ct.setBounds(100,280,80,20);
		lblstate.setBounds(200,280,80,20);
		st.setBounds(300,280,80,20);
		lblpincode.setBounds(20,310,80,20);
		txtpincode.setBounds(100,310,80,20);
		lblmobile.setBounds(200,310,80,20);
		txtmobile.setBounds(300,310,80,20);
		h3.setBounds(20,340,180,20);
		l3.setBounds(20,356,180,5);
		lblsalary.setBounds(20,390,70,20);
		txtsalary.setBounds(100,390,80,20);
		lblda.setBounds(200,390,70,20);
		txtda.setBounds(300,390,80,20);
		lblta.setBounds(20,420,70,20);
		txtta.setBounds(100,420,80,20);
		lblpf.setBounds(200,420,70,20);
		txtpf.setBounds(300,420,80,20);
		lblhra.setBounds(20,450,70,20);
		txthra.setBounds(100,450,80,20);
		lblit.setBounds(200,450,70,20);
		txtit.setBounds(300,450,80,20);
		lblsal.setBounds(20,480,70,20);
		txtsal.setBounds(100,480,80,20);
		btncalculate.setBounds(20,510,80,20);
		btnReset.setBounds(120,510,80,20);
		btnsubmit.setBounds(240,510,80,20);
		btnclose.setBounds(340,510,80,20);
		
		
		h1.setFont(font);
		h2.setFont(font);
		h3.setFont(font);
		h1.setForeground(Color.blue);
		h2.setForeground(Color.blue);
		h3.setForeground(Color.blue);
		l1.setForeground(Color.orange);
		l2.setForeground(Color.orange);
		l3.setForeground(Color.orange);

		//button to execute the program
		btncalculate.addActionListener(this);
		btnReset.addActionListener(this);
		btnclose.addActionListener(this);
		btnsubmit.addActionListener(this);
		
		

		
		
		//add components
		add(h1);
		add(l1);
		add(lblecode);
		add(txtecode);
		add(lblename);
		add(txtename);
		add(lblsex);
		add(male);
		add(female);
		add(lbldob);
		add(h2);
		add(l2);
		add(lbll1);
		add(txtl1);
		add(lbll2);
		add(txtl2);
		add(lblstate);
		add(st);
		add(lblct);
		add(ct);
		add(lblpincode);
		add(txtpincode);
		add(lblmobile);
		add(txtmobile);
		add(h3);
		add(l3);
		add(lblsalary);
		add(txtsalary);
		add(lblda);
		add(txtda);
		add(lblta);
		add(txtta);
		add(lblpf);
		add(txtpf);
		add(lblhra);
		add(txthra);
		add(lblit);
		add(txtit);
		add(lblsal);
		add(txtsal);
		add(btncalculate);
		add(btnReset);
		add(btnsubmit);
		add(btnclose);
		
		
		txtta.setEditable(false);
		txtda.setEditable(false);
		txtit.setEditable(false);
		txtsal.setEditable(false);
		txtpf.setEditable(false);
		txthra.setEditable(false);
		
		txtta.setBackground(Color.gray);
		txtda.setBackground(Color.gray);
		txtit.setBackground(Color.gray);
		txtsal.setBackground(Color.gray);
		txtpf.setBackground(Color.gray);
		txthra.setBackground(Color.gray);
		
		txtsalary.setText("0");
	
	}
		public void actionPerformed(ActionEvent ae) 
		{
		
		//action event for btncalculate
			if(ae.getSource()==btncalculate)
			{
				ssa=txtsalary.getText();
				sal=Float.parseFloat(ssa);
				if(ssa.length()==1)
				JOptionPane.showMessageDialog(this,"Enter employee salary");
				else
				{
					hra=(float)(sal*0.3);
		 			da=(float)(sal*0.2);
		 			ta=(float)(sal*0.1);
		 			ns=(float)(sal+da+ta+hra);
		 			pf=(float)(sal*0.07);
		 			it=(float)((ns+pf)*0.15);
		 			gs=(float)(ns-pf-it);
		 			
		 			txthra.setText(""+hra);
		 			txtda.setText(""+da);
		 			txtta.setText(""+ta);
		 			txtpf.setText(""+pf);
		 			txtit.setText(""+it);
		 			txtsal.setText(""+gs);	
		 			JOptionPane.showMessageDialog(this,"Salary is calculated");
				}
				
			}
		 // action event for btnsubmit
		 	if(ae.getSource()==btnsubmit)
		 	
		 	{
		 		sename=txtename.getText();
		 		secode=txtecode.getText();
		 		
		 	//condition check for sex
		 		if(male.isSelected())
		 		{
		 			ssex="m";
		 		}
		 		else if(female.isSelected())
		 		{
		 			ssex="f";
		 		}
		 		
		 		
		 		sl1=txtl1.getText();
		 		sl2=txtl2.getText();
		 		scity=(String)ct.getSelectedItem();
		 		sstate=(String)st.getSelectedItem();
		 		spincode=txtpincode.getText();
		 		smobile=txtmobile.getText();
		 		
		 		ssa=txtsalary.getText();
		 		
		 		
		 		sal=Float.parseFloat(ssa);
		 		
		 		
		 		if(secode.length()==0)
		 		JOptionPane.showMessageDialog(this,"Enter employee code");
		 		else if(sename.length()==0)
		 		JOptionPane.showMessageDialog(this,"Enter employee name");
		 		
		 		else if(male.isSelected()==false&&female.isSelected()==false)
		 		JOptionPane.showMessageDialog(this,"Select sex");
		 		else if(sl1.length()==0)
		 		JOptionPane.showMessageDialog(this,"Enter employee address in line1");
		 		else if(spincode.length()==0)
		 		JOptionPane.showMessageDialog(this,"Enter pincode");
		 		else if(smobile.length()==0)
		 		JOptionPane.showMessageDialog(this,"Enter mobile number");
		 		else if(ssa.length()==1)
		 		JOptionPane.showMessageDialog(this,"Enter employee salary");		 		
		 		
		 		
		 		
		 		else
		 			{
		 		
		 			
		 			hra=(float)(sal*0.3);
		 			da=(float)(sal*0.2);
		 			ta=(float)(sal*0.1);
		 			ns=(float)(sal+da+ta+hra);
		 			pf=(float)(sal*0.07);
		 			it=(float)((ns+pf)*0.15);
		 			gs=(float)(ns-pf-it);
		 			
		 			txthra.setText(""+hra);
		 			txtda.setText(""+da);
		 			txtta.setText(""+ta);
		 			txtpf.setText(""+pf);
		 			txtit.setText(""+it);
		 			txtsal.setText(""+gs);	
		 			JOptionPane.showMessageDialog(this,"Salary is calculated");
		 			JOptionPane.showMessageDialog(this,"Data inserted to data base");
		 			
		 			Connection con=null;
					Statement stmt=null;
					ResultSet rs=null;
				
					try
					{
					Class.forName("oracle.jdbc.driver.OracleDriver");

		
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","project","project");
					stmt=con.createStatement();	
					String query;
					query="insert into employee (ecode,ename,sex,address1,address2,city,state,pincode,contact,sal,da,ta,pf,hra,it,gross) values ('"+secode+"','"+sename+"','"+ssex+"','"+sl1+"','"+sl2+"','"+scity+"','"+sstate+"','"+spincode+"','"+smobile+"',"+sal+","+da+","+ta+","+pf+","+hra+","+it+","+gs+")";
					stmt.executeUpdate(query);
					
					}
					catch(Exception e)
					{
						
					}	
		 			
		 			}
		 		}	
		 			
		//action event for btn reset
			if(ae.getSource()==btnReset)
			{
									
					txtsalary.setText("");
					txthra.setText("");
		 			txtda.setText("");
		 			txtta.setText("");
		 			txtpf.setText("");
		 			txtit.setText("");
		 			txtsal.setText("");
		 			JOptionPane.showMessageDialog(this,"Fields have reseted");
			}
		
		//action event for btnclose
			if(ae.getSource()==btnclose)
			{
				this.dispose();
			}
			
			
		
				
		}
 }
 
 
public class Employee extends JFrame implements ActionListener
{
	JMenuBar menubar;
	JMenu menu,transaction,edit;
	JMenu search;
	
	JLabel lbl1,lbl2;
	
	
	JMenuItem New,open,close,save,saveas,saveall,exit;
	JMenuItem insert,update,delete;
	JMenuItem bysecode,bysename;
	
	Font font1 = new Font("Segoe Print", Font.ITALIC, 30);
	Font font3=new Font("Constantia",Font.BOLD,20);
	
	
	
	public Employee()
	{
		super("Employee Database");
	
		//initialization inside constructor
		
		lbl1=new JLabel("Welcome to Employee Database");
		lbl2=new JLabel("Sohan kumar pande",JLabel.RIGHT);
		
		lbl1.setFont(font1);
		lbl2.setFont(font3);
		
		lbl1.setForeground(Color.green);
		lbl2.setForeground(Color.blue);
		
		menubar=new JMenuBar();
		
		menu= new JMenu("File");
		transaction=new JMenu("Transaction");
		search=new JMenu("Search");
		
		New=new JMenuItem("New");
		open=new JMenuItem("Open");
		close=new JMenuItem("Close");
		save=new JMenuItem("Save");
		saveas=new JMenuItem("SaveAs");
		saveall=new JMenuItem("saveAll");
		exit=new JMenuItem("Exit");
		insert=new JMenuItem("Insert");
		update=new JMenuItem("Update");
		delete=new JMenuItem("Delete");
		bysecode=new JMenuItem("By ecode");
		bysename=new JMenuItem("By ename");
		
		
		//add menubar
		setJMenuBar(menubar);
		//add menu to menubar
		menubar.add(menu);
		menubar.add(transaction);
		
		//add menu items
		menu.add(New);
		menu.add(open);
		menu.add(close);
		menu.addSeparator();
		menu.add(save);
		menu.add(saveas);
		menu.add(saveall);
		menu.addSeparator();
		menu.add(exit);
		
		transaction.add(insert);
		transaction.add(search);
		transaction.add(update);
		transaction.add(delete);
		
		search.add(bysecode);
		search.add(bysename);
		
		insert.addActionListener(this);
		bysecode.addActionListener(this);
		bysename.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		exit.addActionListener(this);
		
		setLayout(null);
		
		lbl1.setBounds(20,50,500,50);
		lbl2.setBounds(20,300,500,20);	
		
		add(lbl1);
		add(lbl2);
		
			
	}
	
		public void actionPerformed(ActionEvent ae)
		{
		
		//adding insert form to action of menu item	
			if(ae.getSource()==insert)
			{
				Insert ins=new Insert();
				ins.setSize(600,700);
				ins.setVisible(true);
			}
		//adding search by ecode form to menu item
			if(ae.getSource()==bysecode)
			{
				Searchbyecode sf=new Searchbyecode();
				sf.setSize(600,700);
				sf.setVisible(true);
			}	
		
		//adding search by ename form to menu item
			if(ae.getSource()==bysename)
			{
				Searchbyename sf=new Searchbyename();
				sf.setSize(600,700);
				sf.setVisible(true);
			}
		
		//adding update form to menu item
			if(ae.getSource()==update)
			{
				Searchbyecode sf=new Searchbyecode();
				sf.setSize(600,700);
				sf.setVisible(true);
			}	
		//adding delete form to menu item
			if(ae.getSource()==delete)
			{
				Delete del=new Delete();
				del.setSize(600,700);
				del.setVisible(true);
			}
			if(ae.getSource()==exit)
			{
				System.exit(0);
				
			}
		
		
		
	
		}
		
		public static void main(String args[])
		{
			Employee frmEmp=new Employee();
			frmEmp.setSize(600,400);
			frmEmp.setVisible(true);
			
			frmEmp.setResizable(false);
			WindowListener lst=new WindowAdapter()
			{
				public void windowClosing(WindowEvent we)
				{
					System.exit(0);
				}
			};
			frmEmp.addWindowListener(lst);
		}
	
	
}