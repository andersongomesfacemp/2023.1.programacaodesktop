package aula1;

import java.util.Scanner;

import javax.swing.JOptionPane;

import java.sql.*;
import org.sqlite.JDBC;


public class inicio {
	
		public static void main(String[] args) throws SQLException, ClassNotFoundException {
		float pesos = 0;
		float somapesos = 0;
		float media = 0;
		int qtd=0;
		
		Scanner entradas = new Scanner(System.in);
		qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite numero de familiares:"));
		
		 
		
		for (int i = 0; i < qtd; i++) {
			
			pesos = Integer.parseInt(JOptionPane.showInputDialog("Digite o peso:"));
			somapesos = somapesos + pesos;
		}
		media = somapesos / qtd;
		
		System.out.println("Media  " + media );
		entradas.close();
		
		  Class.forName("org.sqlite.JDBC");
		  java.sql.Connection c = DriverManager.getConnection("jdbc:sqlite:C:\\Mediapeso.db");
		  java.sql.Statement s = c.createStatement();
		  
		  s.execute(" insert into pesos (nomefamilia, media) values ('" + qtd +"'," + media + ")");
		  s.execute(" delete from pesos where nomefamilia = '1'");
		  ResultSet rs = s.executeQuery("SELECT * FROM PESOS");
		  
		  
		  while(rs.next()) {
		    // Ler os dados inseridos
			  JOptionPane.showInternalMessageDialog( null, rs.getString("nomefamilia"));
		    //System.out.println("PESO : " + rs.getFloat("MEDIA"));
		  }
		  
	}

}
