package dao;

import java.sql.*;
import java.util.*;

import concursos.Concurso;

public class ConcursoDAO  extends DAO{
	public ConcursoDAO(){
		super();
		conectar();
	}
	
	public boolean insert(Concurso concurso) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO concursos(codigo, nome, categoria, banca, localizacao) " + "VALUES(" 
		            + concurso.getCodigoConcurso() + ", '" 
		            + concurso.getNomeConcurso() + "', '" 
		            + concurso.getCategoria() + "', '" 
		            + concurso.getBanca() + "', '" 
		            + concurso.getLocalizacao() + "');";
			System.out.println(sql);;
			st.executeUpdate(sql);
			System.out.println(14);
			st.close();
			status = true;
		}catch (Exception e) {
			System.out.println(11);
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean update(Concurso concurso) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE concursos SET nome = '" + concurso.getNomeConcurso() 
				+ "', categoria = '" + concurso.getCategoria() + "', banca = '" + concurso.getBanca() + "', localizacao = '"
				+ concurso.getLocalizacao() +  "'" + " WHERE codigo = " + concurso.getCodigoConcurso();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		}catch (Exception e) { 
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean delete(int codigo) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM concursos WHERE codigo = " + codigo;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		}catch (Exception e) { 
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public Concurso getConcurso(int id) {
	    Concurso concurso = null;
	    String sql = "SELECT * FROM concursos WHERE codigo = ?";
	    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	        stmt.setInt(1, id);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                concurso = new Concurso(
	                    rs.getInt("codigo"),
	                    rs.getString("nome"),
	                    rs.getString("categoria"),
	                    rs.getString("banca"),
	                    rs.getString("localizacao")
	                );
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return concurso;
	}
	
}
