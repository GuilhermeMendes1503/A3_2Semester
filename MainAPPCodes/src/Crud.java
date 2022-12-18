import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Crud {
	private final static String usuario = "root";
	private final static String senha = "";
	private final static String host = "localhost";
	private final static String porta = "3306";
	private final static String banco = "consultacnpj";
	private final static String url = "jdbc:mysql://" + host + ":" + porta + "/" + banco;
	private static Connection conexao = null;
	
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(url, usuario, senha);
		} catch (Exception e) {
			System.out.println("Deu ruim");
			e.printStackTrace(); 
		}
		return conexao;
	}

	public void fechar() {
		try {
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void exec(String cod) {
		try {
			java.sql.PreparedStatement sqlPrep = conectar().prepareStatement(cod);
			sqlPrep.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insert(String NomeFantasia, String RazaoSocial, String CNPJ, String CNAE, String CNAECodigo, String CEP, String Abertura, String Telefone, String Email, String Logradouro, String status) {
		String sql = "INSERT INTO `atributos` ( `NomeFantasia`, `RazaoSocial`, `CNPJ`, `CNAE`, `CNAECodigo`, `CEP`, `Abertura`, `Telefone`, `Email`, `Logradouro`, `status`) "
				+ "VALUES ('" + NomeFantasia + "','" + RazaoSocial + "','" + CNPJ + "','" + CNAE + "','" + CNAECodigo + "','" + CEP + "','" + Abertura + "','" + Telefone + "','" + Email + "','" + Logradouro + "','" + status + "');";
		exec(sql);
	}
	
	public static void delete(String id) {
		String sql = "DELETE FROM `atributos` WHERE CNPJ ='" + id + "';";
		exec(sql);

	}
	
	public static void update(String NomeFantasia, String RazaoSocial, String CNPJ, String CNAE, String CNAECodigo, String CEP, String Abertura, String Telefone, String Email, String Logradouro) {
		String sql = "UPDATE atributos "
				+ "SET NomeFantasia = '" + NomeFantasia + "', RazaoSocial = '" + RazaoSocial + "', CNPJ ='" + CNPJ + "', CNAE = '" +
	CNAE + "', CNAECodigo = '" + CNAECodigo + "', CEP = '" + CEP + "', Abertura = '" + Abertura + "', Telefone = '" + Telefone + "', Email = '" + Email + "', Logradouro = '" + 
				Logradouro + "'  WHERE CNPJ ='" + CNPJ + "';";
		exec(sql);
	}
	public static String[] readcnpj(String cnpj) {
		ResultSet result = null;
		String RS[] = new String[11];
		try {
			result = conectar().prepareStatement("SELECT * FROM `atributos` WHERE CNPJ = '" + cnpj +  "';").executeQuery();

			while (result.next()) {
				RS[0] = result.getString(2);
				RS[1] = result.getString(3);
				RS[2] = result.getString(4);
				RS[3] = result.getString(5);
				RS[4] = result.getString(6);
				RS[5] = result.getString(7);
				RS[6] = result.getString(8);
				RS[7] = result.getString(9);
				RS[8] = result.getString(10);
				RS[9] = result.getString(11);
				RS[10] = result.getString(12);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return RS;
	}
	public List<Atributos> read(){
		
		List<Atributos> atributos = new ArrayList<>();
		
		try {
			ResultSet rs = conectar().prepareStatement("SELECT * FROM `atributos`").executeQuery();
			
			while(rs.next()) {
				Atributos atributo = new Atributos();
				
				atributo.setNomeFantasia(rs.getString(2));
				atributo.setRazaoSocial(rs.getString(3));
				atributo.setCNPJ(rs.getString(4));
				atributo.setCNAE(rs.getString(5));
				atributo.setCNAECodigo(rs.getString(6));
				atributo.setCEP(rs.getString(7));
				atributo.setAbertura(rs.getString(8));
				atributo.setTelefone(rs.getString(9));
				atributo.setEmail(rs.getString(10));
				atributo.setLogradouro(rs.getString(11));
				atributo.setstatus(rs.getString(12));
				atributos.add(atributo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return atributos;
		
	}
	

}
	
	
