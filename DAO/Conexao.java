package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Conexao {

    private Connection conexao = null;
    private PreparedStatement stmt;
    private String dsn = "jdbc:mysql://10.76.64.77/teste"; 
    private String usr = "root";
    private String pass = "123";

    public Conexao() throws SQLException {
        this.Conectar();
    }

    private Connection Conectar() throws SQLException {
        try {
            conexao = DriverManager.getConnection(dsn, usr, pass);
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar! " + e.getMessage());
        }
        return this.conexao;
    }

    public void desconectar() throws SQLException {
        this.conexao.close();
    }

    private PreparedStatement prepare(StringBuilder sql) throws SQLException {
        PreparedStatement stmt = this.conexao.prepareStatement(sql.toString());
        return stmt;
    }

    public int Inserir(String tableName, ArrayList colunas, ArrayList dados) throws SQLException, InstantiationException, IllegalAccessException {
        StringBuilder sql = new StringBuilder();
        colunas.remove(0);
        sql.append("INSERT INTO ");
        sql.append(tableName);
        sql.append(" (");

        Iterator it = colunas.iterator();
        while (it.hasNext()) {
            sql.append(it.next());
            if (it.hasNext()) {
                sql.append(", ");
            }
        }
        
        sql.append(")");
        sql.append(" VALUES ('");

        Iterator it2 = dados.iterator();
        while (it2.hasNext()) {
            sql.append(it2.next());
            if (it2.hasNext()) {
                sql.append("', '");
            }
        }

        sql.append("')");
        

        this.stmt = this.prepare(sql);
        return this.stmt.executeUpdate(sql.toString());

    }
    
     public ResultSet Select(String tableName, ArrayList colunas) throws SQLException {
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT ");

        Iterator it = colunas.iterator();
        while (it.hasNext()) {
            sql.append(it.next());
            if (it.hasNext()) {
                sql.append(", ");
            }
        }

        sql.append(" FROM ");
        sql.append(tableName);
        
        this.stmt = this.prepare(sql);
        return this.stmt.executeQuery(sql.toString());

    }
     
    public int excluir(String tableName, ArrayList colunas,int id) throws SQLException{
    StringBuilder sql = new StringBuilder();

        sql.append("DELETE FROM ");
        sql.append(tableName);
        sql.append(" WHERE ");
        sql.append(colunas.get(0));
        sql.append("=");
        sql.append(id);

        this.stmt = this.prepare(sql);
        return this.stmt.executeUpdate(sql.toString());
        
    }
    
    public int Editar (String tableName, ArrayList colunas, ArrayList dados,int id) throws SQLException{
      
      StringBuilder sql = new StringBuilder();
      
      Object coluna_id = colunas.get(0);      
      colunas.remove(0);
      
        sql.append("UPDATE ");
        sql.append(tableName);
        sql.append(" SET ");
        
        
        int tam = colunas.size();
           
        for (int i=0; i<tam;i++){
            int j=i;
        sql.append(colunas.get(i));
        sql.append("='");
        sql.append(dados.get(i));
        sql.append("'");
            if (++j<tam){
            sql.append(",");
            
            }
        }
          sql.append(" WHERE ");
          sql.append(coluna_id);
          sql.append("=");
          sql.append(id);
        
        
        
        System.err.println(sql);
        
        
        this.stmt = this.prepare(sql);
        return this.stmt.executeUpdate(sql.toString());
    
    }
    
       
}
