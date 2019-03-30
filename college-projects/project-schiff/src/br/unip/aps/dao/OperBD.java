package br.unip.aps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unip.aps.models.ContaUsuario;
import br.unip.aps.models.Pessoa;
import br.unip.aps.models.Embarcacao;
import br.unip.aps.models.Carga;

public class OperBD {

	 
    public static ContaUsuario findUser(Connection conn, String login, String senha) throws SQLException {
 
        String sql = "SELECT USR.matricula,p.nome, USR.login,USR.senha,PERMISSAO.descricao\n" + 
        		"FROM CONTA_USUARIO AS USR\n" + 
        		"INNER JOIN  TIPO_USUARIO AS PERMISSAO ON (USR.tipoacesso = PERMISSAO.tipo)\n" + 
        		"INNER JOIN PESSOA AS p ON (USR.matricula = p.matricula) WHERE USR.login = ? AND USR.senha = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, login);
        pstm.setString(2, senha);
        ResultSet rs = pstm.executeQuery();
        
        if (rs.next()) {
            int matricula = rs.getInt("matricula");
            String nome = rs.getString("nome");
            String desc = rs.getString("descricao");
            ContaUsuario user = new ContaUsuario();
            user.setMatricula(matricula);
            user.setNome(nome);
            user.setLogin(login);
            user.setSenha(senha);
            user.setTipoacesso(desc);
            return user;
        }
        return null;
    }
 
    public static ContaUsuario findUser(Connection conn, String login) throws SQLException {
 
        String sql = "SELECT USR.matricula,p.nome, USR.login,USR.senha,PERMISSAO.descricao\n" + 
        		"FROM CONTA_USUARIO AS USR\n" + 
        		"INNER JOIN  TIPO_USUARIO AS PERMISSAO ON (USR.tipoacesso = PERMISSAO.tipo)\n" + 
        		"INNER JOIN PESSOA AS p ON (USR.matricula = p.matricula) WHERE USR.login = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, login);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
        	   	int matricula = rs.getInt("matricula");
            String nome = rs.getString("nome");
            String senha = rs.getString("senha");
            String desc = rs.getString("descricao");
            ContaUsuario user = new ContaUsuario();
            user.setMatricula(matricula);
            user.setNome(nome);
            user.setLogin(login);
            user.setSenha(senha);
            user.setTipoacesso(desc);
            return user;
        }
        return null;
    }
 
   
   public static ContaUsuario findUserAdmin(Connection conn, String matricula) throws SQLException {
       String sql = "SELECT USR.matricula,p.nome,USR.login,USR.senha,USR.tipoacesso FROM CONTA_USUARIO USR\n" + 
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
    	   		String tipoacesso = rs.getString("tipoacesso");
           
           ContaUsuario user = new ContaUsuario (matriculav,nome,login,senha,tipoacesso);
           
           return user;
       }
       return null;
   }
   
   public static String isAdmin(Connection conn, String login) throws SQLException {
       String sql = "SELECT type.descricao\n" + 
       		"FROM CONTA_USUARIO AS USR\n" + 
       		"INNER JOIN TIPO_USUARIO AS type ON (USR.tipoacesso = type.tipo)\n" + 
       		"WHERE USR.login==?";

       PreparedStatement pstm = conn.prepareStatement(sql);
       pstm.setString(1, login);

       ResultSet rs = pstm.executeQuery();

       while (rs.next()) {
   
    	   		String tipoacesso = rs.getString("descricao");
           
           return tipoacesso;
       }
       return null;
   }
   
   public static Pessoa findPessoa(Connection conn, String matricula) throws SQLException {
       String sql = "SELECT p.matricula,p.nome,p.endereco,p.telefone,p.email,p.rg,p.cpf_cnpj,s.descricao AS status,pt.descricao AS tipopessoa, emp.tipo_emp AS tipoRH,dep.departamento as Departamento,c.cargo as Cargo\n" + 
       		"FROM PESSOA AS p\n" + 
       		"INNER JOIN  STATUS AS s ON (p.status = s.tipo)\n" + 
       		"INNER JOIN TIPO_PESSOA AS pt ON (p.tipo = pt.tipo)\n" + 
       		"INNER JOIN TIPO_EMP as emp ON (p.tipo_emp = emp.id)\n" + 
       		"INNER JOIN DEPARTAMENTO as dep ON (p.depto = dep.id)\n" + 
       		"INNER JOIN CARGO as c ON (p.cargo = c.id)\n" + 
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
       		String cpf_cnpj = rs.getString("cpf_cnpj");
       		String status = rs.getString("status");
       		String tipo = rs.getString("tipopessoa");
       		String tipo_emp = rs.getString("tipoRH");
       		String depto = rs.getString("Departamento");
       		String cargo = rs.getString("Cargo");
          
          //Pessoa p = new Pessoa (matriculav,nome,endereco,telefone,email,rg,cpf_cnpj,status,tipo,tipo_emp,tipo_emp,depto,cargo);
          
        Pessoa p = new Pessoa(matriculav, nome, endereco,  telefone,  email, rg,
    			 cpf_cnpj,  status,  tipo,  tipo_emp,  depto,  cargo);
       		
        			return p;
           }
           return null;
       }
   
   public static Embarcacao findEmbarcacao(Connection conn, String id) throws SQLException {
       String sql = "SELECT emb.id,emb.descricao, emb.fabricante, emb.ano_fab,emb.responsavel as matricula_responsavel, p.nome as responsavel, embsize.id AS porte,embsize.tamanho, embsize.gasto_combustivel FROM EMBARCACAO AS emb\n" + 
       		"INNER JOIN PORTE_EMBARCACAO as embsize ON (emb.tamanho = embsize.id)\n" + 
       		"INNER JOIN PESSOA as p ON (emb.responsavel = p.matricula) WHERE emb.id=?";

       PreparedStatement pstm = conn.prepareStatement(sql);
       pstm.setString(1, id);

       ResultSet rs = pstm.executeQuery();

       while (rs.next()) {
    	   		int idv = Integer.parseInt(id);
    	   		String descricao = rs.getString("descricao");
       		String fabricante = rs.getString("fabricante");
       		String ano_fab = rs.getString("ano_fab");
       		int responsavel = rs.getInt("matricula_responsavel");
       		String responsavel_nome = rs.getString("responsavel");
       		String porte = rs.getString("porte");
       		String tamanho = rs.getString("tamanho");
       		String nivelgasto_combustivel = rs.getString("gasto_combustivel");
           
           Embarcacao emb = new Embarcacao (idv,descricao,fabricante,ano_fab,tamanho,porte,nivelgasto_combustivel,responsavel,responsavel_nome);
           
           return emb;
       }
       return null;
   }
   
   public static Carga findCarga(Connection conn, String id) throws SQLException {
       String sql = "SELECT c.id,c.descricao,p.matricula as matricula_responsavel ,p.nome as responsavel, emb.id as registro_navio_transportador,emb.descricao as nome_navio_transportador,\n" + 
       		"       tipo_c.descricao as tipo_carga,c.tempotransporte\n" + 
       		"FROM CARGA AS c\n" + 
       		"INNER JOIN PESSOA as p ON (c.responsavel = p.matricula)\n" + 
       		"INNER JOIN EMBARCACAO as emb ON (c.transportador = emb.id)\n" + 
       		"INNER JOIN TIPO_CARGA as tipo_c ON (c.tipo_carga = tipo_c.id) WHERE c.id=?";

       PreparedStatement pstm = conn.prepareStatement(sql);
       pstm.setString(1, id);

       ResultSet rs = pstm.executeQuery();

       while (rs.next()) {
    	   		int idv = Integer.parseInt(id);
    	   		int responsavel_matricula = rs.getInt("matricula_responsavel");
           	int registro_navio = rs.getInt("registro_navio_transportador");
           	String descricao = rs.getString("descricao");
           	String responsavel_nome = rs.getString("responsavel");
           	String navio_transportador = rs.getString("nome_navio_transportador");
           	String desc_tipo_carga = rs.getString("tipo_carga");
           	String tempotransporte = rs.getString("tempotransporte");
           
       		Carga c = new Carga(idv,descricao, responsavel_matricula, responsavel_nome, registro_navio,
       				navio_transportador, desc_tipo_carga, tempotransporte);
      
           return c;
       }
       return null;
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
   
   public static void updatePessoa(Connection conn, Pessoa p) throws SQLException {
       String sql = "UPDATE PESSOA SET nome=?, endereco=?, telefone=?, email=?, rg=?, cpf_cnpj=?, status=?, tipo=?, tipo_emp=?, depto=?, cargo=? WHERE matricula=?";

       PreparedStatement pstm = conn.prepareStatement(sql);
       
       pstm.setString(1, p.getNome());
       pstm.setString(2, p.getEndereco());
       pstm.setString(3, p.getTelefone());
       pstm.setString(4, p.getEmail());
       pstm.setString(5, p.getRg());
       pstm.setString(6, p.getCpf_cnpj());
       pstm.setString(7, p.getStatus());
       pstm.setString(8, p.getTipo());
       pstm.setString(9, p.getTipo_emp());
       pstm.setString(10, p.getDepto());
       pstm.setString(11, p.getCargo());
       pstm.setInt(12, p.getMatricula());
     
       pstm.executeUpdate();
   }
   
   public static void updateEmbarcacao(Connection conn, Embarcacao emb) throws SQLException {
       String sql = "UPDATE EMBARCACAO SET descricao=?, fabricante=?, ano_fab=?, tamanho=?,responsavel=? WHERE id=?";

       PreparedStatement pstm = conn.prepareStatement(sql);

       pstm.setString(1, emb.getDescricao());
       pstm.setString(2, emb.getFabricante());
       pstm.setString(3, emb.getAno_fab());
       pstm.setString(4, emb.getTamanho());
       pstm.setInt(5, emb.getResponsavel());
       pstm.setInt(6, emb.getId());

       pstm.executeUpdate();
   }
   
   public static void updateCarga(Connection conn, Carga c) throws SQLException {
       String sql = "UPDATE CARGA SET descricao=?, responsavel=?, transportador=?, tipo_carga=?, tempotransporte=? WHERE id=?";

       PreparedStatement pstm = conn.prepareStatement(sql);

       pstm.setString(1, c.getDescricao());
       pstm.setInt(2, c.getResponsavel_matricula());
       pstm.setInt(3, c.getTransportador());
       pstm.setString(4, c.getTipo_carga());
       pstm.setString(5, c.getTempotransporte());
       pstm.setInt(6, c.getId());
 

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
   
   public static void insertPessoa(Connection conn, Pessoa p) throws SQLException {
       String sql = "INSERT INTO PESSOA(matricula, nome, endereco, telefone, email, rg, cpf_cnpj, status, tipo, tipo_emp, depto, cargo)\n" + 
       		"VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

       PreparedStatement pstm = conn.prepareStatement(sql);
       
       pstm.setInt(1, p.getMatricula());
       pstm.setString(2, p.getNome());
       pstm.setString(3, p.getEndereco());
       pstm.setString(4, p.getTelefone());
       pstm.setString(5, p.getEmail());
       pstm.setString(6, p.getRg());
       pstm.setString(7, p.getCpf_cnpj());
       pstm.setString(8, p.getStatus());
       pstm.setString(9, p.getTipo());
       pstm.setString(10, p.getTipo_emp());
       pstm.setString(11, p.getDepto());
       pstm.setString(12, p.getCargo());
       

       pstm.executeUpdate();
   }
   
   public static void insertEmbarcacao(Connection conn, Embarcacao emb) throws SQLException {
       String sql = "INSERT INTO EMBARCACAO (id,descricao, fabricante, ano_fab, tamanho,responsavel)\n" + 
       		"VALUES (?,?,?,?,?,?)";

       PreparedStatement pstm = conn.prepareStatement(sql);
       
       pstm.setInt(1, emb.getId());
       pstm.setString(2, emb.getDescricao());
       pstm.setString(3, emb.getFabricante());
       pstm.setString(4, emb.getAno_fab());
       pstm.setString(5, emb.getTamanho());
       pstm.setInt(6, emb.getResponsavel());

       pstm.executeUpdate();
   }
   
   public static void insertCarga(Connection conn, Carga c) throws SQLException {
       String sql = "INSERT INTO CARGA(id, descricao, responsavel, transportador, tipo_carga, tempotransporte)\n" + 
       		"VALUES (?,?,?,?,?,?)";

       PreparedStatement pstm = conn.prepareStatement(sql);
       
       pstm.setInt(1, c.getId());
       pstm.setString(2, c.getDescricao());
       pstm.setInt(3, c.getResponsavel_matricula());
       pstm.setInt(4, c.getTransportador());
       pstm.setString(5, c.getTipo_carga());
       pstm.setString(6, c.getTempotransporte());

       pstm.executeUpdate();
   }
   
   public static void deleteUser(Connection conn, String matriculaStr) throws SQLException {
       String sql = "DELETE FROM CONTA_USUARIO WHERE matricula=?";

       PreparedStatement pstm = conn.prepareStatement(sql);
       
       pstm.setString(1, matriculaStr);

       pstm.executeUpdate();
   }
   
   public static void deletePessoa(Connection conn, String matriculaStr) throws SQLException {
       String sql = "DELETE FROM PESSOA WHERE matricula= ?";

       PreparedStatement pstm = conn.prepareStatement(sql);
       
       pstm.setString(1, matriculaStr);

       pstm.executeUpdate();
   }
   
   public static void deleteEmbarcacao(Connection conn, String idStr) throws SQLException {
       String sql = "DELETE FROM EMBARCACAO WHERE id= ?";

       PreparedStatement pstm = conn.prepareStatement(sql);
       
       pstm.setString(1, idStr);

       pstm.executeUpdate();
   }
   
   public static void deleteCarga(Connection conn, String idStr) throws SQLException {
       String sql = "DELETE FROM CARGA WHERE id= ?";

       PreparedStatement pstm = conn.prepareStatement(sql);
       
       pstm.setString(1, idStr);

       pstm.executeUpdate();
   }
   
   public static List<ContaUsuario> queryUsers(Connection conn) throws SQLException {
       String sql = "SELECT USR.matricula,p.nome, USR.login,USR.senha,PERMISSAO.descricao\n" + 
       		"FROM CONTA_USUARIO AS USR\n" + 
       		"INNER JOIN  TIPO_USUARIO AS PERMISSAO ON (USR.tipoacesso = PERMISSAO.tipo)\n" + 
       		"INNER JOIN PESSOA AS p ON (USR.matricula = p.matricula)";

       PreparedStatement pstm = conn.prepareStatement(sql);

       ResultSet rs = pstm.executeQuery();
       List<ContaUsuario> list = new ArrayList<ContaUsuario>();
       while (rs.next()) {
       		int matricula = rs.getInt("matricula");
       		String nome = rs.getString("nome");
       		String login = rs.getString("login");
       		String senha = rs.getString("senha");
           String  tipoacesso = rs.getString("descricao");
       		
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
   
   public static List<Pessoa> queryPessoa(Connection conn) throws SQLException {
      String sql = "SELECT p.matricula,p.nome,p.endereco,p.telefone,p.email,p.rg,p.cpf_cnpj,s.descricao AS status,pt.descricao AS tipopessoa, emp.tipo_emp AS tipoRH,dep.departamento as Departamento,c.cargo as Cargo\n" + 
       		"FROM PESSOA AS p\n" + 
       		"INNER JOIN  STATUS AS s ON (p.status = s.tipo)\n" + 
       		"INNER JOIN TIPO_PESSOA AS pt ON (p.tipo = pt.tipo)\n" + 
       		"INNER JOIN TIPO_EMP as emp ON (p.tipo_emp = emp.id)\n" + 
       		"INNER JOIN DEPARTAMENTO as dep ON (p.depto = dep.id)\n" + 
       		"INNER JOIN CARGO as c ON (p.cargo = c.id)";
	   
	   

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
    		String cpf_cnpj = rs.getString("cpf_cnpj");
    		String status = rs.getString("status");
    		String tipo = rs.getString("tipopessoa");
    		String tipo_emp = rs.getString("tipoRH");
    		String depto = rs.getString("Departamento");
    		String cargo = rs.getString("Cargo");
       		
           Pessoa p = new Pessoa();
           
           p.setMatricula(matricula);
           p.setNome(nome);
           p.setEndereco(endereco);
           p.setTelefone(telefone);
           p.setEmail(email);
           p.setRg(rg);
           p.setCpf_cnpj(cpf_cnpj);
           p.setStatus(status);
           p.setTipo(tipo);
           p.setTipo_emp(tipo_emp);
           p.setDepto(depto);
           p.setCargo(cargo);
           list.add(p);
       }
       return list;
   }
   
   public static List<Embarcacao> queryEmbarcacoes(Connection conn) throws SQLException {
       String sql = "SELECT emb.id,emb.descricao, emb.fabricante, emb.ano_fab,emb.responsavel as matricula_responsavel, p.nome as responsavel, embsize.id AS porte,embsize.tamanho, embsize.gasto_combustivel FROM EMBARCACAO AS emb\n" + 
       		"INNER JOIN PORTE_EMBARCACAO as embsize ON (emb.tamanho = embsize.id)\n" + 
       		"INNER JOIN PESSOA as p ON (emb.responsavel = p.matricula)";

       PreparedStatement pstm = conn.prepareStatement(sql);

       ResultSet rs = pstm.executeQuery();
       List<Embarcacao> list = new ArrayList<Embarcacao>();
       while (rs.next()) {
       		int id = rs.getInt("id");
       		String descricao = rs.getString("descricao");
       		String fabricante = rs.getString("fabricante");
       		String ano_fab = rs.getString("ano_fab");
       		int responsavel = rs.getInt("matricula_responsavel");
       		String responsavel_nome = rs.getString("responsavel");
       		String porte = rs.getString("porte");
       		String tamanho = rs.getString("tamanho");
       		String nivelgasto_combustivel = rs.getString("gasto_combustivel");
       		
       		Embarcacao emb = new Embarcacao();
           
           emb.setId(id);
           emb.setDescricao(descricao);
           emb.setFabricante(fabricante);
           emb.setAno_fab(ano_fab);
           emb.setResponsavel(responsavel);
           emb.setResponsavel_nome(responsavel_nome);
           emb.setPorte(porte);
           emb.setTamanho(tamanho);
           emb.setNivelgasto_combustivel(nivelgasto_combustivel);
           list.add(emb);
       }
       return list;
       
       
   }
   
   public static List<Carga> queryCargas(Connection conn) throws SQLException {
       String sql = "SELECT c.id,c.descricao,p.matricula as matricula_responsavel ,p.nome as responsavel, emb.id as registro_navio_transportador,emb.descricao as nome_navio_transportador,\n" + 
       		"       tipo_c.descricao as tipo_carga,c.tempotransporte\n" + 
       		"FROM CARGA AS c\n" + 
       		"INNER JOIN PESSOA as p ON (c.responsavel = p.matricula)\n" + 
       		"INNER JOIN EMBARCACAO as emb ON (c.transportador = emb.id)\n" + 
       		"INNER JOIN TIPO_CARGA as tipo_c ON (c.tipo_carga = tipo_c.id)";

       PreparedStatement pstm = conn.prepareStatement(sql);

       ResultSet rs = pstm.executeQuery();
       List<Carga> list = new ArrayList<Carga>();
       while (rs.next()) {
       		int id = rs.getInt("id");
       		int responsavel_matricula = rs.getInt("matricula_responsavel");
       		int registro_navio = rs.getInt("registro_navio_transportador");
       		String descricao = rs.getString("descricao");
       		String responsavel_nome = rs.getString("responsavel");
       		String navio_transportador = rs.getString("nome_navio_transportador");
       		String desc_tipo_carga = rs.getString("tipo_carga");
       		String tempotransporte = rs.getString("tempotransporte");
       		
       		
       		Carga c = new Carga();
       		c.setId(id);
       		c.setResponsavel_matricula(responsavel_matricula);
       		c.setTransportador(registro_navio);
       		c.setDescricao(descricao);
       		c.setResponsavel_nome(responsavel_nome);
       		c.setTransportador_nome(navio_transportador);
       		c.setTipo_carga(desc_tipo_carga);
       		c.setTempotransporte(tempotransporte);
           
       		list.add(c);
       }
       return list;
   }
  
}
