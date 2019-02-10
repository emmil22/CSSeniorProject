package IA;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Admin extends User{
	
	DBConnectionManagerSingleton dbc;
	Connection conn;
	Statement stmt;
	private Musical m;
	ArrayList<Musical> musical = new ArrayList<Musical>();
	private JFrame musicalFrame;
	private JScrollPane jscrlp;
	private boolean tableCreated = false;
	private Object[][] obj;
	private JTable table;
	String [] headings = {"Musical", "Actor Name", "Role", "Songs In"};

	
		 
	public void createMusical(List<Musical> musicallist) {
		
		try {
			dbc = DBConnectionManagerSingleton.getInstance();
		} catch (Exception e) {
		}
		
		
		conn = dbc.getConnection();
		stmt = dbc.getStatement();
			
			String viewRec = "SELECT * from USER_INFO";
			ResultSet rs;
			try {
				rs = stmt.executeQuery(viewRec);
			
			

				while (rs.next()) {
					String mName = rs.getString("MUSICAL_NAME");
				String	actor = rs.getString("ACTOR");
					String roles = rs.getString("ROLES");
					String songsin = rs.getString("SONGS_IN");
					Musical m = new Musical(mName, actor, roles, songsin);
					musical.add(m);
					System.out.println(mName);
				}
			}catch (SQLException e) {
	
				e.printStackTrace();
			}
		
		musicalFrame = new JFrame("User Data");
	
		musicalFrame.getContentPane().setLayout(new FlowLayout());
		musicalFrame.setSize(1000, 500);
		musicalFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		updateTable();
		
		for (Musical musicallist1 : musicallist)
        {
			m = new Musical(musicallist1.getmName(), musicallist1.getactors()
					,musicallist1.getrole(), musicallist1.getsongsin());
			try {
				stmt.executeUpdate("Insert into USER_INFO values("+"'" + musicallist1.getmName() +
						"',' "
			+ musicallist1.getactors() + "','" + musicallist1.getrole()   +"')");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
        }
		

		this.musical.add(m);
		updateTable();
	}
public void updateTable() {
		
		
		if (tableCreated) {
			musicalFrame.remove(jscrlp);
		}
	
		tableCreated = true;
		
		 obj = new Object[musical.size()][20];
		for(int i = 0; i < musical.size(); i++) {
			obj[i][0] = this.musical.get(i).getmName();
			obj[i][1] = this.musical.get(i).getactors();
			obj[i][2] = this.musical.get(i).getrole();
			obj[i][3] = this.musical.get(i).getsongsin();
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
		
		musicalFrame.add(jscrlp);
		
			musicalFrame.setVisible(true);
		}
		
	}

	

