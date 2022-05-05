package projektDatabaze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SqlConnection {
	private static volatile Connection dbConnection;
	public static Connection getConnection() {
	    if (dbConnection == null) {
	        synchronized (SqlConnection.class) {
	          if (dbConnection == null) {
	            try {
	              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	              dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/databaze","root","ahojahoj1");
	            } catch (SQLException | ClassNotFoundException e) {
	            	System.out.println("chyba pripojeni");
	            	e.printStackTrace();
	            }
	          }
	        }
	      }
	      return dbConnection;
		
	}
	public void insertToSQL(int id, String jmeno, String prijmeni, float znamka, String obor,int rok, int mesic, int den) {
		Connection conn = SqlConnection.getConnection();
		String sql = "INSERT INTO tabulka" + "( jmeno, prijmeni,rok,znamka,obor,mesic, den)" + "VALUES(?,?,?,?,?,?,?)";
		try(PreparedStatement prStmt = conn.prepareStatement(sql)) {
			prStmt.setString(1,jmeno);
			prStmt.setString(2, prijmeni);
			prStmt.setInt(3,rok);
			prStmt.setFloat(4,znamka);
			prStmt.setString(5,obor);
			prStmt.setInt(6,mesic);
			prStmt.setInt(7,den);
			prStmt.executeUpdate();
			System.out.println("uspesne pridano do databaze");
		} catch (SQLException e) {
			System.out.println("chyba");
			e.printStackTrace();
		}

	}
	
	public Student loadFromSQL(int id) {
		Student student;
		Connection conn = SqlConnection.getConnection();
		String sql = "SELECT id, jmeno, prijimeni, narozeni, znamka,role FROM student WHERE id = ?";
		try(PreparedStatement prStmt = conn.prepareStatement(sql)) {
			prStmt.setInt(1,id);
			ResultSet rs = prStmt.executeQuery();
			if (rs.next()) {
				if(rs.getString("obor") == "tech") {
					student = new techStudent(rs.getString("jmeno"),rs.getString("prijimeni"),
							rs.getInt("rok"), rs.getInt("mesic"), rs.getInt("den"));
					student.setZnamky(rs.getInt("znamka"));
					return (techStudent)student;
				}if(rs.getString("obor") == "hum") {
					student = new humStudent(rs.getString("jmeno"),rs.getString("prijimeni"),
							rs.getInt("rok"), rs.getInt("mesic"), rs.getInt("den"));
					student.setZnamky(rs.getInt("znamka"));
					return (humStudent)student;
				}if(rs.getString("obor") == "ob") {
					student = new obStudent(rs.getString("jmeno"),rs.getString("prijimeni"),
							rs.getInt("rok"), rs.getInt("mesic"), rs.getInt("den"));
					student.setZnamky(rs.getInt("znamka"));
					return (obStudent)student;
				}
			}
		} catch (Exception e) {
			System.out.println("chyba stazeni");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnection() {
		    try {
		      dbConnection.close();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		  }
}