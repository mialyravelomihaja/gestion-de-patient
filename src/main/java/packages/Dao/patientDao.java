package packages.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import patient.bean.patient;

public class patientDao {
	private String jdbcUrl = "jdbc:mysql://localhost:3306/gestionConsulatation?useSSL=false";
	private String jdbcUsername ="mialy";
	private String jdbcPassword ="Mialy1012!";
	private String jdbcDriver ="com.mysql.jdbc.Driver";
	
	private static final String SELECT_PATIENT_BY_ID ="select *from consultation where id=?";
	private static final String SELECT_ALL_PATIENTS = "select *from consultation ";
	private static final String DELETE_PATIENT_SQL = "delete from consultation where id=?";
	private static final String UPDATE_PATIENT_SQL = "update consultation set nomPat=? , prenomPAt=?,agePAt=?, telPat=? , date=?, resultat=? where id=?";
	public patientDao() {
		
	}
	 protected Connection getConnection() {
		 Connection connection=null;
		try {
			Class.forName("jdbcDriver");
			connection = DriverManager.getConnection(jdbcUrl,jdbcUsername,jdbcPassword);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	 }
	 
	 //select patient by id 
	 
	 public patient SelectPatient(int id) throws SQLException {
		 patient patients =null;
		 try(Connection connection = getConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PATIENT_BY_ID);)
		 {
			 preparedStatement.setInt(1, id);
			 System.out.println(preparedStatement);
			 	ResultSet rs = preparedStatement.executeQuery();
			 	while (rs.next()){
			 		String nomPat = rs.getString("nomPat");
			 		String prenomPat = rs.getString("prenomPat");
			 		String agePat = rs.getString("agePat");
			 		String telPat = rs.getString("telPat");
			 		String date = rs.getString("date");
			 		String resultat = rs.getString("resultat");
			 		patients = new patient(id,nomPat,prenomPat,agePat,telPat,date,resultat);
			 	}
		 }catch(SQLException e) {
			 printSQLException(e);
		 }
		return patients;
		 
	 }
	 
	 //select all patient
	 public List<patient> selectAllPatients(){
		 List<patient> patients = new ArrayList<>();
		 try(Connection connection = getConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PATIENTS);)
		 {
			 
			 System.out.println(preparedStatement);
			 	ResultSet rs = preparedStatement.executeQuery();
			 	while (rs.next()){
			 		int id =rs.getInt("id");
			 		String nomPat = rs.getString("nomPat");
			 		String prenomPat = rs.getString("prenomPat");
			 		String agePat = rs.getString("agePat");
			 		String telPat = rs.getString("telPat");
			 		String date = rs.getString("date");
			 		String resultat = rs.getString("resultat");
			 		patients.add(new patient(id,nomPat,prenomPat,agePat,telPat,date,resultat));
			 	}
		 }catch(SQLException e) {
			 printSQLException(e);
		 }
		return patients;
		 
	 }
	 
	 //update patient
	 public boolean updatePatient(patient patients)throws SQLException{
		 boolean rowUpdated;
		 try(Connection connection = getConnection();
				 PreparedStatement statement = connection.prepareStatement(UPDATE_PATIENT_SQL);)
		 {
			 
			 System.out.println("updated patient:"+statement);
			 statement.setString(1, patient.getNomPat());
			 statement.setString(2, patient.getPrenomPat());
			 statement.setString(3, patient.getAgePat());
			 statement.setString(4, patient.getTelPat());
			 statement.setString(5, patient.getDate());
			 statement.setString(6, patient.getResultat());
			 statement.setInt(7, patient.getId());
			 
			 rowUpdated = statement.executeUpdate()>0;
			 }
		return rowUpdated;
		 
	 }
	 
	 //delete patient
	 public boolean deletePatient(int id) throws SQLException{
		 boolean rowDeleted;
		 try(Connection connection = getConnection();
				 PreparedStatement statement = connection.prepareStatement(DELETE_PATIENT_SQL);)
		 {
			 statement.setInt(1, id);
			 rowDeleted = statement.executeUpdate()>0;
		 }
		return rowDeleted;
	 }
	 
	 private void printSQLException(SQLException ex) {
		 for(Throwable e :ex) {
			 e.printStackTrace(System.err);
			 System.err.println("SQLState:" + ((SQLException) e).getSQLState());
			 System.err.println("Error Code:" + ((SQLException) e).getErrorCode());
			 System.err.println("Messqge:" + e.getMessage());
			 Throwable t = ex.getCause();
			 while(t != null) {
				 System.out.println("Cause:" +t);
				 t = t.getCause();
			 }
		 }
	 }

}
