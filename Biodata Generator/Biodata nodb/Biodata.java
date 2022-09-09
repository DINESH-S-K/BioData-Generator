// Java program to implement a Simple Registration Form using Java Swing 

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.io.*;
import java.text.NumberFormat;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import java.io.FileNotFoundException;

class MyFrame extends JFrame implements ActionListener { 
	
	public int f = 0;
	public String dfinal;
	// Components of the Form 
        private Container d; 
	private JLabel title; 
	private JLabel name; 
	private JTextField dname; 
	private JLabel mbno; 
	private JTextField dmbno; 
	private JLabel gender; 
	private JRadioButton male; 
	private JRadioButton female; 
	private ButtonGroup gengroup; 
	private JLabel dob; 
	private JComboBox date; 
	private JComboBox month; 
	private JComboBox year; 
	private JLabel addr; 
	private JTextArea daddr; 
	private JCheckBox terms; 
	private JButton submit; 
	private JButton reset; 
	private JTextArea dout; 
	private JLabel res;  
	private JButton download;
	private JLabel quali;
	private JComboBox qualification;
	private JLabel pin;
	private JTextField dpin;
	//private JLabel pinlabel;
	private JLabel twlm;
	private JTextField dtwlm;
	private JLabel tenm;
	private JTextField dtenm;
	private JLabel plk;
	private JTextField dplk;

	private String dates[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",                                    "24", "25", "26", "27", "28", "29", "30", "31" }; 
	private String months[] = { "Jan", "feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec" }; 
	private String years[] = { "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", 
                                   "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019" }; 

	private String qualifications[] = {"","SSLC","12th Grade","B.E","M.E","PhD","BSc","MSc"};

	// constructor, to initialize the components 
	// with default values. 
	public MyFrame() throws IOException
	{
		setTitle("Registration Form"); 
		setBounds(150,90,1000,900); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(true); 

		d = getContentPane(); 
		d.setLayout(null); 

		title = new JLabel("BIODATA FORM"); 					//Code to add buttons,labels,and textarea to container
		title.setFont(new Font("Arial", Font.PLAIN, 30)); 
		title.setSize(300, 30); 
		title.setLocation(300, 30); 
		d.add(title); 

		name = new JLabel("Name"); 
		name.setFont(new Font("Arial", Font.PLAIN, 20)); 
		name.setSize(100, 20); 
		name.setLocation(100, 100); 
		d.add(name); 

		dname = new JTextField(); 
		dname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		dname.setSize(190, 20); 
		dname.setLocation(200, 100); 
		d.add(dname); 

		mbno = new JLabel("Mobile NO:"); 
		mbno.setFont(new Font("Arial", Font.PLAIN, 20)); 
		mbno.setSize(100, 20); 
		mbno.setLocation(100, 130); 
		d.add(mbno); 

		dmbno = new JTextField(); 
		dmbno.setFont(new Font("Arial", Font.PLAIN, 15)); 
		dmbno.setSize(150, 20); 
		dmbno.setLocation(200, 130); 
		d.add(dmbno); 

		gender = new JLabel("Gender"); 
		gender.setFont(new Font("Arial", Font.PLAIN, 20)); 
		gender.setSize(100, 20); 
		gender.setLocation(100,160); 
		d.add(gender); 

		male = new JRadioButton("Male"); 
		male.setFont(new Font("Arial", Font.PLAIN, 15)); 
		male.setSelected(true); 
		male.setSize(75, 20); 
		male.setLocation(200, 160); 
		d.add(male); 

		female = new JRadioButton("Female"); 
		female.setFont(new Font("Arial", Font.PLAIN, 15)); 
		female.setSelected(false); 
		female.setSize(80, 20); 
		female.setLocation(275, 160); 
		d.add(female); 

		gengroup = new ButtonGroup(); 
		gengroup.add(male); 
		gengroup.add(female); 

		dob = new JLabel("DOB"); 
		dob.setFont(new Font("Arial", Font.PLAIN, 20)); 
		dob.setSize(100, 20); 
		dob.setLocation(100, 190); 
		d.add(dob); 

		date = new JComboBox(dates); 
		date.setFont(new Font("Arial", Font.PLAIN, 15)); 
		date.setSize(50, 20); 
		date.setLocation(200, 190); 
		d.add(date); 

		month = new JComboBox(months); 
		month.setFont(new Font("Arial", Font.PLAIN, 15)); 
		month.setSize(60, 20); 
		month.setLocation(250, 190); 
		d.add(month); 

		year = new JComboBox(years); 
		year.setFont(new Font("Arial", Font.PLAIN, 15)); 
		year.setSize(60, 20); 
		year.setLocation(320, 190); 
		d.add(year); 

		addr = new JLabel("Address"); 
		addr.setFont(new Font("Arial", Font.PLAIN, 20)); 
		addr.setSize(100, 20); 
		addr.setLocation(100, 220); 
		d.add(addr); 

		daddr = new JTextArea(); 
		daddr.setFont(new Font("Arial", Font.PLAIN, 15)); 
		daddr.setSize(200, 75); 
		daddr.setLocation(200, 220); 
		daddr.setLineWrap(true); 
		d.add(daddr);
	
		pin = new JLabel("PinCode");
		pin.setFont(new Font("Arial", Font.PLAIN, 20));
		pin.setSize(100,20);
		pin.setLocation(100,300);
		d.add(pin);

		dpin = new JTextField();
		dpin.setFont(new Font("Arial", Font.PLAIN, 15));
		dpin.setSize(150,20);
		dpin.setLocation(200,300);
		d.add(dpin);

		quali = new JLabel("Educational Qualifications");
		quali.setFont(new Font("Arial", Font.PLAIN, 20));
		quali.setSize(300,20);
		quali.setLocation(100,330);
		d.add(quali);

		qualification = new JComboBox(qualifications);
		qualification.setFont(new Font("Arial", Font.PLAIN, 15));
		qualification.setSize(100, 20); 
		qualification.setLocation(330,330);
		d.add(qualification);
        
		tenm = new JLabel("10th Percentage");
		tenm.setFont(new Font("Arial", Font.PLAIN, 18));
		tenm.setSize(200,20);
		tenm.setLocation(100,360);
		d.add(tenm);
 
		dtenm = new JTextField();
		dtenm.setFont(new Font("Arial", Font.PLAIN, 20));
		dtenm.setSize(200,25);
		dtenm.setLocation(240,360);
		d.add(dtenm);		

		twlm = new JLabel("12th Percentage");
		twlm.setFont(new Font("Arial", Font.PLAIN, 18));
		twlm.setSize(200,20);
		twlm.setLocation(100,390);
		d.add(twlm);

		dtwlm = new JTextField();
		dtwlm.setFont(new Font("Arial", Font.PLAIN, 20));
		dtwlm.setSize(200,25);
		dtwlm.setLocation(240,390);
		d.add(dtwlm);


		plk = new JLabel("Programming Languages Known");
		plk.setFont(new Font("Arial", Font.PLAIN, 18));
		plk.setSize(300,20);
		plk.setLocation(100,420);
		d.add(plk);

		dplk = new JTextField();
		dplk.setFont(new Font("Arial", Font.PLAIN, 20));
		dplk.setSize(200,25);
		dplk.setLocation(150,455);
		d.add(dplk);
		

		terms = new JCheckBox("Accept Terms And Conditions."); 
		terms.setFont(new Font("Arial", Font.PLAIN, 15)); 
		terms.setSize(400, 25); 
		terms.setLocation(100,485); 
		d.add(terms); 

		submit = new JButton("Submit"); 
		submit.setFont(new Font("Arial", Font.PLAIN, 15)); 
		submit.setSize(100, 20); 
		submit.setLocation(150,520); 
		submit.addActionListener(this); 
		d.add(submit); 

		reset = new JButton("Reset"); 
		reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
		reset.setSize(100, 20); 
		reset.setLocation(270,520); 
		reset.addActionListener(this); 
		d.add(reset); 

		dout = new JTextArea(); 
		dout.setFont(new Font("Arial", Font.PLAIN, 15)); 
		dout.setSize(500, 400); 
		dout.setLocation(500, 100); 
		dout.setLineWrap(true); 
		dout.setEditable(false); 
		d.add(dout); 

		res = new JLabel(""); 
		res.setFont(new Font("Arial", Font.PLAIN, 20)); 
		res.setSize(500, 25); 
		res.setLocation(100,540); 
		d.add(res); 

		download = new JButton("Download PDF");
		download.setFont(new Font("Arial",Font.PLAIN,20));
		download.setSize(200,50);
		download.setLocation(500,550);
		download.setVisible(false);
		download.addActionListener(this);
		d.add(download);

		setVisible(true); 
		
		
	} 

	// method actionPerformed() 
	// to get the action performed 
	// by the user and act accordingly 
	
	public void actionPerformed(ActionEvent a)
	{ 
		f = 0;
		if (a.getSource() == submit) { 
			if (terms.isSelected()) { 
		String gender1; 
		String namembno = "Name : " + dname.getText() + "\n" + "Mobile : " + dmbno.getText() + "\n"; 
		if(!isStringOnlyAlphabet(dname.getText()) || dname.getText() == "")                //Name field cannot be empty,so checking whether name is empty                                                                                                       
				{
					dname.setText("");
					f = 1;
					res.setText("Invalid Name value");
				}
				if(!isNumeric(dmbno.getText()) || dmbno.getText() == "")				//Checking whether mobile number is empty or not
				{
					dmbno.setText("");
					f = 1;
					res.setText("Invalid Mobile Number");
				}
				if (male.isSelected()) 
					gender1 = "Gender : Male" + "\n"; 
				else
					gender1 = "Gender : Female"+ "\n";
                      String dob2 = "DOB : " + (String)date.getSelectedItem() + "/" + (String)month.getSelectedItem() + "/" + (String)year.getSelectedItem() + "\n";                                                         

				String addr3 = "Address : " + daddr.getText() + "\n";
				String edu4 = "Educational Qualifications : " + (String)qualification.getSelectedItem() + "\n";
				String pin5 = dpin.getText();
                                String ten6 = dtenm.getText();
				String twl7 = dtwlm.getText();
				String plk8 = dplk.getText();
				if(!isNumeric(pin5))							//Checking any alphabets present in pincode
				{
					dpin.setText("");
					res.setText("Invalid Pincode");
					f = 1;
				}
				if(f==0){
					pin5 = "Pincode : " + pin5 + "\n";
					twl7 = "12th Percentage : " + twl7 + "%\n";
					ten6 = "10th Percentage : " + ten6 + "%\n";
					plk8 = "Programming Languages known : " + plk8 + "\n";
					dfinal = namembno + gender1 + dob2 + addr3 + edu4 + pin5 + ten6 + twl7 + plk8; 
				
					dout.setText(dfinal); 
					dout.setEditable(false); 
					res.setText("Registration Successfully..");
					System.out.println("*"+dname.getText()+"*");
					download.setVisible(true); 
					try{
						File file = new File("output.txt");		//generate a txt file 
						file.createNewFile();
						FileWriter out = new FileWriter(file);
						out.write(dfinal);
						out.flush();
						out.close();
					}
					catch(Exception exp){
						System.out.println("Exception occured");
					}
				}
				
			} 
			else { 
				dout.setText(""); 							//Checking terms & conditions is accepted or not
				res.setText("Please accept the"+"terms & conditions.."); 
				
			} 
			
		} 

		else if (a.getSource() == reset) { 						//Reset operation
			String def = ""; 
			dname.setText(def); 
			daddr.setText(def); 
			dmbno.setText(def); 
			res.setText(def); 
			dout.setText(def); 
			terms.setSelected(false); 
			date.setSelectedIndex(0); 
			month.setSelectedIndex(0); 
			year.setSelectedIndex(0); 
			download.setVisible(false);
			dpin.setText(def);
			qualification.setSelectedIndex(0);
			
		} 
		if (a.getSource() == download){								// generate pdf 
			System.out.println("Downloaded PDF");
			Document document = new Document();
			BufferedReader in;
			try {
				in = new BufferedReader(new FileReader("E:/codings/output.txt"));
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("E:/codings/BIODATA.pdf"));
				document.open();
				String temp = in.readLine();
				while(temp != null )
				{
					Paragraph p = new Paragraph(temp);
					document.add(p);
					temp = in.readLine();
				}
				document.close();
				writer.close();
			}
			catch(DocumentException e1)
			{
				e1.printStackTrace();
			}
			catch(FileNotFoundException e2)
			{
				e2.printStackTrace();
			}
			catch(IOException e3)
			{
				e3.printStackTrace();
			}
		}
		
	}
	public static boolean isNumeric(String str) { 						//check the string is numeric or not
  		try {  
    			Double.parseDouble(str);  
    			return true;
  		} catch(NumberFormatException e){  
    			return false;  
  		}  
	} 
	
	public static boolean isStringOnlyAlphabet(String str) 					//check the string is only alphabet or not
	{ 
    		return ((!str.equals("")) && (str != null) && (str.matches("^[ A-Za-z]+$"))); 
	}
	
	
} 

public class Biodata { 

	public static void main(String[] args) throws Exception 
	{ 
           MyFrame f = new MyFrame();	
	} 
} 
