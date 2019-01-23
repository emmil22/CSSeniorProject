package Reference;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;


public class CustomerOrderData implements ActionListener{
	
	private JLabel JLab1;
	private JLabel JLab2;
	private JFrame frame2;
	private JScrollPane jscrlp;
	private boolean tableCreated = false;
	
	private JTextField t1;
	private JTextField t2;

	private JRadioButton rb1;
	private JRadioButton rb2;
	private ButtonGroup bg;
	private String blah;
	private JTable table;
	private ArrayList<CustomerOrder> blurb = new ArrayList<CustomerOrder>();
	private Object[][] obj;
	private CustomerOrder c;
	private CustomerOrder c1;
	
	private JLabel alabel;
	private JComboBox<String> flavor;
	private JComboBox<String> topping;

	String[] flavors = {"Chocolate", "Vanilla", "Chocolate Chip Mint", "Rocky Road", "Strawberry"};
	String[] toppings = {"Sprinkles", "Chocolate Syrup", "Whipped Cream", "Pineapple", 
			"Bacon Bits(NEW!)", "No Topping"};
	String [] headings = {"First Name", "Last Name", "Flavor", "Topping", 
			"Cup or Cone.","Price", "Order Date"};
	DBConnectionManagerSingleton dbc;
	Connection conn;
	Statement stmt;
	CustomerOrderData ()  {
		
		try {
			dbc = DBConnectionManagerSingleton.getInstance();
		} catch (Exception e) {
		}
		
		conn = dbc.getConnection();
		stmt = dbc.getStatement();
			
			String viewRec = "SELECT * from CUSTOMER_ORDER";
			ResultSet rs;
			try {
				rs = stmt.executeQuery(viewRec);
			
			

				while (rs.next()) {
					String fn = rs.getString("FIRST_NAME");
					String ln = rs.getString("LAST_NAME");
					String f = rs.getString("FLAVOR");
					String t = rs.getString("TOPPING");
					String coc = rs.getString("COC");
					String p = rs.getString("PRICE");
					String od = rs.getString("ORDER_DATE");
					CustomerOrder c= new CustomerOrder(fn, ln, f, t, coc, p, od);
					blurb.add(c);
					System.out.println(fn);
				}
			}catch (SQLException e) {
	
				e.printStackTrace();
			}
		JFrame frame = new JFrame("Customer Order Data");
		frame.getContentPane().setLayout(new GridLayout(7, 2, 1, 1));
		frame.setVisible(true);
		frame.setSize(300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame2 = new JFrame("Customer Order Data");
		frame2.getContentPane().setLayout(new FlowLayout());
		frame2.setSize(1000, 500);
		frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		updateTable();
		JLabel label1 = new JLabel("First Name: ");
		JLabel label2 = new JLabel("Last Name: ");
		JLabel label3 = new JLabel("Flavor: ");
		JLabel label4 = new JLabel("Topping: ");
		alabel = new JLabel("Cup or Cone ");
		JLabel label6 = new JLabel("");
		JLabel label7 = new JLabel("");
		
		
		rb1= new JRadioButton("Cup", true);
		rb2 = new JRadioButton("Cone");
		
		flavor = new JComboBox<String>(flavors);
		
		flavor.addActionListener(this);
		flavor.setEditable(true);
		
		topping = new JComboBox<String>(toppings);
		
		topping.addActionListener(this);
		topping.setEditable(true);
		
		
		
		bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		
		 t1 = new JTextField("");
		 t2 = new JTextField("");

		
		JButton b1 = new JButton("Submit Order");
		JButton b2 = new JButton("Display Table");
		
		label1.setHorizontalAlignment(SwingConstants.LEFT);
		label2.setHorizontalAlignment(SwingConstants.LEFT);
		label3.setHorizontalAlignment(SwingConstants.LEFT);
		
		frame.getContentPane().add(label1);
		frame.getContentPane().add(t1);
		frame.getContentPane().add(label2);
		frame.getContentPane().add(t2);
		frame.getContentPane().add(label3);
		frame.add(flavor);
		frame.getContentPane().add(label4);
		frame.add(topping);
		frame.add(alabel);
		frame.add(rb1);
		frame.add(label6);
		frame.add(rb2);
		frame.getContentPane().add(b1);
		frame.getContentPane().add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	}
	
	
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getActionCommand().equals("Submit Order")) {
			if(t1.getText().length() == 0 || t2.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Please enter values in all fields");
			}
			else {
				if (rb1.isSelected()) {
					
					c = new CustomerOrder(t1.getText(),t2.getText(), (String) flavor
							.getSelectedItem(),(String) topping.getSelectedItem(), "Cup");
					try {
						stmt.executeUpdate("Insert into CUSTOMER_ORDER values("+"'" + t1.getText() + "',' "
					+ t2.getText() + "','" + (String)flavor.getSelectedItem() + "','" + 
								(String)topping.getSelectedItem() + "', 'Cup'," + c.getprice() + ",'"
								+ c.getCurrentDate() + "')");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else{
					c = new CustomerOrder (t1.getText(),t2.getText(), (String) flavor
							.getSelectedItem(),(String) topping.getSelectedItem(), "Cone");
					try {
						stmt.executeUpdate("Insert into CUSTOMER_ORDER values("+"'" + t1.getText() +
					"',' " + t2.getText() + "','" + (String)flavor.getSelectedItem() + "','" + 
								(String)topping.getSelectedItem() + "',' Cone'," + c.getprice() + ",'"
								+ c.getCurrentDate() + "')");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				

				this.blurb.add(c);
				updateTable();
				
				t1.setText("");
				t2.setText("");
			
				
				
			}
			
		}
		if(ae.getActionCommand().equals("Display Table")) {
			frame2.setVisible(true);
		}
	}
	
public void updateTable() {
	
	
		if (tableCreated) {
			frame2.remove(jscrlp);
		}
	
		tableCreated = true;
		
		 obj = new Object[blurb.size()][20];
		for(int i = 0; i < blurb.size(); i++) {
			obj[i][0] = this.blurb.get(i).getfirstName();
			obj[i][1] = this.blurb.get(i).getlastName();
			obj[i][2] = this.blurb.get(i).getflavor();
			obj[i][3] = this.blurb.get(i).gettopping();
			obj[i][4] = this.blurb.get(i).getcoc();
			obj[i][5] = this.blurb.get(i).getprice();
			obj[i][6] = this.blurb.get(i).getCurrentDate();
		}
		
		table = new JTable(obj, headings)
		{
		    public boolean isCellEditable(int row, int column) {                
		        return false;               
		    };
		};
		jscrlp = new JScrollPane(table);
		table.getTableHeader().setReorderingAllowed(false);

		table.setPreferredScrollableViewportSize(new Dimension(980, 500));
		
		frame2.add(jscrlp);

		if (frame2.isVisible()) {
			frame2.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CustomerOrderData();
			}
		});
	}
}
