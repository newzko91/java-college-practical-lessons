package br.com.unip.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.unip.models.*;

public class OperBD {

	public static ContaUsuario findUser(Connection conn, String login, String senha) throws SQLException {

		String sql = "SELECT USR.matricula,p.nome, USR.login, USR.senha, PERMISSAO.tipo_emp\n" + 
				"FROM CONTA_USUARIO AS USR\n" + 
				"INNER JOIN TIPO_ACESSO AS PERMISSAO ON (USR.tipoacesso = PERMISSAO.id)\n" + 
				"INNER JOIN PESSOA AS p ON (USR.matricula = p.matricula) WHERE USR.login = ? AND USR.senha = ?";


		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, login);
		pstm.setString(2, senha);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			int matricula = rs.getInt("matricula");
			String nome = rs.getString("nome");
			String tipoacesso = rs.getString("tipo_emp");
			ContaUsuario user = new ContaUsuario();
			user.setMatricula(matricula);
			user.setNome(nome);
			user.setLogin(login);
			user.setSenha(senha);
			user.setTipoacesso(tipoacesso);
			return user;
		}
		return null;
	}

	public static ContaUsuario findUser(Connection conn, String login) throws SQLException {

		String sql = "SELECT USR.matricula,p.nome, USR.login, USR.senha, PERMISSAO.tipo_emp\n" + 
				"FROM CONTA_USUARIO AS USR\n" + 
				"INNER JOIN TIPO_ACESSO AS PERMISSAO ON (USR.tipoacesso = PERMISSAO.id)\n" + 
				"INNER JOIN PESSOA AS p ON (USR.matricula = p.matricula) WHERE USR.login = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, login);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			int matricula = rs.getInt("matricula");
			String nome = rs.getString("nome");
			String senha = rs.getString("senha");
			String tipoacesso = rs.getString("tipo_emp");
			ContaUsuario user = new ContaUsuario();
			user.setMatricula(matricula);
			user.setNome(nome);
			user.setLogin(login);
			user.setSenha(senha);
			user.setTipoacesso(tipoacesso);
			return user;
		}
		return null;
	}

	public static ContaUsuario findUserAdmin(Connection conn, String matricula) throws SQLException {
		String sql = "SELECT p.nome,USR.login,USR.senha,PERMISSAO.tipo_emp FROM CONTA_USUARIO USR\n" +
				"INNER JOIN TIPO_ACESSO AS PERMISSAO ON (USR.tipoacesso = PERMISSAO.id)\n" +
				"INNER JOIN PESSOA AS p ON (USR.matricula = p.matricula)\n" + 
				"WHERE USR.matricula=?";


		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, matricula);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			int matriculav = Integer.parseInt(matricula);
			String nome = rs.getString("nome");
			String login = rs.getString("login");
			String senha = rs.getString("senha");
			String tipac = rs.getString("tipo_emp");

			ContaUsuario user = new ContaUsuario (matriculav,nome,login,senha,tipac);

			return user;
		}
		return null;
	}

	public static String isAdmin(Connection conn, String login) throws SQLException {
		String sql = "SELECT type.descricao\n" + 
				"FROM CONTA_USUARIO AS USR\n" + 
				"INNER JOIN TIPO_ACESSO AS type ON (USR.tipoacesso = type.id)\n" + 
				"WHERE USR.login=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, login);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {

			String tipoacesso = rs.getString("descricao");

			return tipoacesso;
		}
		return null;
	}

	public static List<ContaUsuario> queryUsers(Connection conn) throws SQLException {
		String sql = "SELECT USR.matricula,p.nome, USR.login,USR.senha,PERMISSAO.tipo_emp\n" + 
				"FROM CONTA_USUARIO AS USR\n" + 
				"INNER JOIN  TIPO_ACESSO AS PERMISSAO ON (USR.tipoacesso = PERMISSAO.id)\n" + 
				"INNER JOIN PESSOA AS p ON (USR.matricula = p.matricula)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<ContaUsuario> list = new ArrayList<ContaUsuario>();
		while (rs.next()) {
			int matricula = rs.getInt("matricula");
			String nome = rs.getString("nome");
			String login = rs.getString("login");
			String senha = rs.getString("senha");
			String  tipoacesso = rs.getString("tipo_emp");

			ContaUsuario user = new ContaUsuario();

			user.setMatricula(matricula);
			user.setNome(nome);
			user.setLogin(login);
			user.setSenha(senha);
			user.setTipoacesso(tipoacesso);
			list.add(user);
		}
		return list;
	}

	public static void updateUser(Connection conn, ContaUsuario user) throws SQLException {
		String sql = "UPDATE CONTA_USUARIO SET login=?, senha=?, tipoacesso=? WHERE matricula=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, user.getLogin());
		pstm.setString(2, user.getSenha());
		pstm.setString(3, user.getTipoacesso());
		pstm.setInt(4, user.getMatricula());
		pstm.executeUpdate();
	}

	public static Pessoa findPessoa(Connection conn, String matricula) throws SQLException {
		String sql = "SELECT p.matricula,p.nome,p.endereco,p.telefone,p.email,p.rg,p.cpf,p.cnpj,s.descricao AS status,tp.tipo_pessoa,ta.tipo_emp\n" + 
				"FROM PESSOA as p\n" + 
				"INNER JOIN STATUS AS s ON (p.status = s.id)\n" + 
				"INNER JOIN TIPO_ACESSO AS ta ON (p.tipo_acesso = ta.id)\n" +  
				"INNER JOIN TIPO_PESSOA AS tp ON (p.tipo = tp.id)\n" + 
				"WHERE p.matricula =?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, matricula);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			int matriculav = Integer.parseInt(matricula);
			String nome = rs.getString("nome");
			String endereco = rs.getString("endereco");
			String telefone = rs.getString("telefone");
			String email = rs.getString("email");
			String rg = rs.getString("rg");
			String cpf = rs.getString("cpf");
			String cnpj = rs.getString("cnpj");
			String status = rs.getString("status");
			String tipo = rs.getString("tipo_pessoa");
			String tipo_acesso = rs.getString("tipo_emp");

			Pessoa p = new Pessoa(matriculav, nome, endereco,  telefone,  email, rg,
					cpf, cnpj,  status,  tipo,  tipo_acesso);

			return p;
		}
		return null;
	}
	
	public static List<Pessoa> queryPessoa(Connection conn) throws SQLException {
		String sql = "SELECT p.matricula,p.nome,p.endereco,p.telefone,p.email,p.rg,p.cpf,p.cnpj,s.descricao AS status,tp.tipo_pessoa,ta.tipo_emp\n" + 
				"FROM PESSOA as p\n" + 
				"INNER JOIN STATUS AS s ON (p.status = s.id)\n" + 
				"INNER JOIN TIPO_ACESSO AS ta ON (p.tipo_acesso = ta.id)\n" +  
				"INNER JOIN TIPO_PESSOA AS tp ON (p.tipo = tp.id)";


		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Pessoa> list = new ArrayList<Pessoa>();

		while (rs.next()) {

			int matricula = rs.getInt("matricula");
			String nome = rs.getString("nome");
			String endereco = rs.getString("endereco");
			String telefone = rs.getString("telefone");
			String email = rs.getString("email");
			String rg = rs.getString("rg");
			String cpf = rs.getString("cpf");
			String cnpj = rs.getString("cnpj");
			String status = rs.getString("status");
			String tipo = rs.getString("tipo_pessoa");
			String tipo_acesso = rs.getString("tipo_emp");


			Pessoa p = new Pessoa();

			p.setMatricula(matricula);
			p.setNome(nome);
			p.setEndereco(endereco);
			p.setTelefone(telefone);
			p.setEmail(email);
			p.setRg(rg);
			p.setCpf(cpf);
			p.setCnpj(cnpj);
			p.setStatus(status);
			p.setTipo(tipo);
			p.setTipo_acesso(tipo_acesso);
			list.add(p);
		}
		return list;
	}

	public static void updatePessoa(Connection conn, Pessoa p) throws SQLException {
		String sql = "UPDATE PESSOA SET nome=?, endereco=?, telefone=?, email=?, rg=?, cpf=?, cnpj=?, status=?, tipo=?, tipo_acesso=? WHERE matricula=?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, p.getNome());
		pstm.setString(2, p.getEndereco());
		pstm.setString(3, p.getTelefone());
		pstm.setString(4, p.getEmail());
		pstm.setString(5, p.getRg());
		pstm.setString(6, p.getCpf());
		pstm.setString(7, p.getCnpj());
		pstm.setString(8, p.getStatus());
		pstm.setString(9, p.getTipo());
		pstm.setString(10, p.getTipo_acesso());
		pstm.setInt(11, p.getMatricula());

		pstm.executeUpdate();
	}
	
	public static void deletePessoa(Connection conn, String matriculaStr) throws SQLException {
		String sql = "DELETE FROM PESSOA WHERE matricula= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, matriculaStr);

		pstm.executeUpdate();
	}

	public static void insertPessoa(Connection conn, Pessoa p) throws SQLException {
		String sql = "INSERT INTO PESSOA(matricula, nome, endereco, telefone, email, rg, cpf, cnpj, status, tipo, tipo_acesso)\n" + 
				"VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, p.getMatricula());
		pstm.setString(2, p.getNome());
		pstm.setString(3, p.getEndereco());
		pstm.setString(4, p.getTelefone());
		pstm.setString(5, p.getEmail());
		pstm.setString(6, p.getRg());
		pstm.setString(7, p.getCpf());
		pstm.setString(8, p.getCnpj());
		pstm.setString(9, p.getStatus());
		pstm.setString(10, p.getTipo());
		pstm.setString(11, p.getTipo_acesso());

		pstm.executeUpdate();
	}

	public static void deleteUser(Connection conn, String matriculaStr) throws SQLException {
		String sql = "DELETE FROM CONTA_USUARIO WHERE matricula=?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, matriculaStr);

		pstm.executeUpdate();
	}

	public static void insertUser(Connection conn, ContaUsuario user) throws SQLException {
		String sql = "INSERT INTO CONTA_USUARIO(matricula, login, senha, tipoacesso)\n" + 
				"VALUES (?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, user.getMatricula());
		pstm.setString(2, user.getLogin());
		pstm.setString(3, user.getSenha());
		pstm.setString(4, user.getTipoacesso());

		pstm.executeUpdate();
	}
	
	public static List<Evento> queryEventos(Connection conn) throws SQLException {
		String sql = "SELECT e.id,e.nome,e.descricao,e.data,p.nome as palestrante,l.nome as sala FROM EVENTO AS e\n" + 
				"INNER JOIN PESSOA AS p ON (e.palestrante = p.matricula)\n" + 
				"INNER JOIN ESPACO AS l ON (e.local = l.id) ORDER BY e.data";
	

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Evento> list = new ArrayList<Evento>();

		while (rs.next()) {

			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String descricao = rs.getString("descricao");
			String palestrante = rs.getString("palestrante");
			String sala = rs.getString("sala");
			String data = rs.getString("data");


			Evento e = new Evento();

			e.setId(id);
			e.setNome(nome);
			e.setDescricao(descricao);
			e.setPalestrante(palestrante);
			e.setLocal(sala);
			e.setData(data);
			list.add(e);
		}
		return list;
	}

	public static Evento findEvento(Connection conn, String id) throws SQLException {
		String sql = "SELECT e.id,e.nome,e.descricao,e.data,p.nome as palestrante,l.nome as sala FROM EVENTO AS e\n" + 
				"INNER JOIN PESSOA AS p ON (e.palestrante = p.matricula)\n" + 
				"INNER JOIN ESPACO AS l ON (e.local = l.id)" + 
				"WHERE e.id =?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			int idv = Integer.parseInt(id);
			String nome = rs.getString("nome");
			String descricao = rs.getString("descricao");
			String data = rs.getString("data");
			String palestrante = rs.getString("palestrante");
			String local = rs.getString("sala");

			Evento e = new Evento(idv, nome,descricao,palestrante,local, data);

			return e;
		}
		return null;
	}
	
	public static void updateEvento(Connection conn, Evento e) throws SQLException {
		String sql = "UPDATE EVENTO SET nome=?, descricao=?, palestrante=?, local=?, data=? WHERE id=?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, e.getNome());
		pstm.setString(2, e.getDescricao());
		pstm.setString(3, e.getPalestrante());
		pstm.setString(4, e.getLocal());
		pstm.setString(5, e.getData());
		pstm.setInt(6, e.getId());

		pstm.executeUpdate();
	}

	public static void deleteEvento(Connection conn, String idStr) throws SQLException {
		String sql = "DELETE FROM EVENTO WHERE id= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, idStr);

		pstm.executeUpdate();
	}

	public static void insertEvento(Connection conn, Evento e) throws SQLException {
		String sql = "INSERT INTO EVENTO(id, nome,descricao,palestrante,local, data)\n" + 
				"VALUES (?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, e.getId());
		pstm.setString(2, e.getNome());
		pstm.setString(3, e.getDescricao());
		pstm.setString(4, e.getPalestrante());
		pstm.setString(5, e.getLocal());
		pstm.setString(6, e.getData());


		pstm.executeUpdate();
	}
	

	public static List<Participante> queryParticipantes(Connection conn, String id) throws SQLException {
		String sql = "SELECT e.id,e.nome,p.nome as participante, prt.id_pessoa as matricula FROM PARTICIPANTES AS prt\n" + 
				"INNER JOIN EVENTO AS e ON (prt.id_evento = e.id)\n" + 
				"INNER JOIN PESSOA AS p ON (prt.id_pessoa = p.matricula)" + 
				"WHERE prt.id_evento = ?\n" +
				"LIMIT 30";
	

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);
		ResultSet rs = pstm.executeQuery();
		
		List<Participante> list = new ArrayList<Participante>();

		while (rs.next()) {
			
			int idv = Integer.parseInt(id);
			String nome = rs.getString("nome");
			String pessoa = rs.getString("participante");
			String matricula = rs.getString("matricula");


			Participante e = new Participante();

			e.setId(idv);
			e.setNome(nome);
			e.setPessoa(pessoa);
			e.setMatricula(matricula);
			list.add(e);
		}
		return list;
	}
	
	public static void deleteParticipante(Connection conn, String matricula, String id) throws SQLException {
		String sql = "DELETE FROM PARTICIPANTES WHERE id_pessoa= ? AND id_evento = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, matricula);
		pstm.setString(2, id);

		pstm.executeUpdate();
	}
	
	public static void insertParticipante(Connection conn, String matricula, String id) throws SQLException {
		String sql = "INSERT INTO PARTICIPANTES(id_evento, id_pessoa)\n" + 
				"VALUES (?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, id);
		pstm.setString(2, matricula);



		pstm.executeUpdate();
	}
	
	public static List<Espaco> queryEspacos(Connection conn) throws SQLException {
		String sql = "SELECT s.id, s.nome FROM ESPACO AS s";
	

		PreparedStatement pstm = conn.prepareStatement(sql);

		
		ResultSet rs = pstm.executeQuery();
		List<Espaco> list = new ArrayList<Espaco>();

		while (rs.next()) {

			int id = rs.getInt("id");
			String nome = rs.getString("nome");

			Espaco e = new Espaco();

			e.setId(id);
			e.setNome(nome);
			list.add(e);
		}
		return list;
	}
	
	public static List<Evento> queryMeusEventos(Connection conn, int matricula) throws SQLException {
		String sql = "SELECT e.id, e.nome,e.data FROM PARTICIPANTES AS prt\n" + 
				"INNER JOIN EVENTO AS e ON (prt.id_evento = e.id)\n" + 
				"INNER JOIN PESSOA AS p ON (prt.id_pessoa = p.matricula)\n" +
				"WHERE p.matricula = ? ORDER BY e.data";
	
		

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, matricula);
		
		ResultSet rs = pstm.executeQuery();
		
		List<Evento> list = new ArrayList<Evento>();

		while (rs.next()) {

			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String data = rs.getString("data");


			Evento e = new Evento();

			e.setId(id);
			e.setNome(nome);
			e.setData(data);
			list.add(e);
		}
		return list;
	}
	
	public static void insertLocal(Connection conn, Espaco e) throws SQLException {
		String sql = "INSERT INTO ESPACO(id,nome) \n" + 
				"VALUES (?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);


		pstm.setInt(1, e.getId());
		pstm.setString(2, e.getNome());

		pstm.executeUpdate();
	}

	public static Espaco findLocal(Connection conn, String id) throws SQLException {
		String sql = "SELECT e.id,e.nome FROM ESPACO as e\n" + 
				"WHERE e.id =?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			int idv = Integer.parseInt(id);
			String nome = rs.getString("nome");

			Espaco e = new Espaco(idv, nome);

			return e;
		}
		return null;
	}

	public static void updateLocal(Connection conn, Espaco e) throws SQLException {
		String sql = "UPDATE ESPACO SET nome=? WHERE id=?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, e.getNome());
		pstm.setInt(2, e.getId());

		pstm.executeUpdate();
	}
	
}