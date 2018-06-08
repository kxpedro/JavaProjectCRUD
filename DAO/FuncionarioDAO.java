package DAO;

import VO.FuncionarioVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDAO {

    private ArrayList colunas = new ArrayList();

    public FuncionarioDAO() {
        this.colunas.add("id");
        this.colunas.add("nome");
        this.colunas.add("nasc");
        this.colunas.add("salario");
        this.colunas.add("foto");
    }
 
    public int Inserir(FuncionarioVO funVO) throws SQLException, InstantiationException, IllegalAccessException {        
        Conexao con = new Conexao();
        
        ArrayList dados = new ArrayList();
        
        dados.add(funVO.getNome());
        dados.add(funVO.getNasc());
        dados.add(funVO.getSalario());
        dados.add(funVO.getFoto());
        
        return con.Inserir("funcionario", colunas, dados);        
    }
    
     public ResultSet Listar() throws SQLException {
        Conexao con = new Conexao();        
        ArrayList dados = new ArrayList();        
        return con.Select("funcionario", colunas);   
    }   
     
     public int excluir (int id) throws SQLException{
     Conexao con = new Conexao();
     return con.excluir("funcionario", colunas, id);
    
    }
     
     public int Editar (int id, FuncionarioVO funVO) throws SQLException{
     Conexao con = new Conexao();
     ArrayList dados = new ArrayList();
        
        dados.add(funVO.getNome());
        dados.add(funVO.getNasc());
        dados.add(funVO.getSalario());
        dados.add(funVO.getFoto());
        
     return con.Editar("funcionario", colunas, dados,id);
    
    }
    
}
