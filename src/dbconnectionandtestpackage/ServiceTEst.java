//package  dbconnectionandtestpackage;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//public class ServiceTEst {
//int i=0;
//    private PreparedStatement preparedStatement = null;
//    private ResultSet resultSet = null;
//    private  List<String> resultList;
//
//    public List<String> getMeaning(){
//
//        resultList = new ArrayList<>();
//
//
//        try(Connection con = DbConnection.getConnection()){
//
//            String query = "select LastName from studentinfo";
//            preparedStatement = con.prepareStatement(query);
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//            	String name = resultSet.getString("LastName");
//                resultList.add(name);
//            }
//        }  catch (SQLException ex) {
//        	ex.printStackTrace();
//        }
//        return resultList;
//    }
//
//}