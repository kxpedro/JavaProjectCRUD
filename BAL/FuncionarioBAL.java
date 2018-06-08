package BAL;

import DAO.FuncionarioDAO;
import VO.FuncionarioVO;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FuncionarioBAL {

    public String VerificarNome(String nome) throws Exception {

        if (nome.isEmpty()) {
            throw new Exception("Nome é obrigatório");
        }

        if (nome.length() < 3) {
            throw new Exception("Nome tem que ter pelo menos 3(três) caracteres");
        }

        if (nome.length() > 20) {
            throw new Exception("Nome tem que ter no máximo 20(vinte) caracteres");
        }

        return nome;

    }

    public Date VerificarNasc(String nasc) throws Exception {
        LocalDate dt;

        if (nasc.isEmpty()) {
            throw new Exception("Data de Nacimento é obrigatório");
        }

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dt = LocalDate.parse(nasc, dtf);

        } catch (Exception e) {
            throw new Exception("Data de Nacimento inválida");
        }

        Date nasc1 = Date.valueOf(dt);
        
        if (nasc1.after(Date.valueOf(LocalDate.now()))) {
            throw new Exception("Data não pode ser superior a data de hoje");
        }
        if (nasc1.before(Date.valueOf("1900-01-01"))) {
            throw new Exception("Data Inválida: " + nasc1.toString());
        }

        return nasc1;
    }

    public BigDecimal VerificarSal(String sal) throws Exception {
        BigDecimal retorno = null;

        if (sal.isEmpty()) {
            throw new Exception("Salario é obrigatório");
        }
        try {
            retorno = new BigDecimal(sal);
        } catch (Exception e) {
            throw new Exception("Formato do salário é inválido");
        }

        return retorno;
    }

    public int Inserir(FuncionarioVO funvo) throws SQLException, Exception {
        int retorno;
        
        FuncionarioDAO fundao = new FuncionarioDAO();
        retorno = fundao.Inserir(funvo);

        return retorno;
    }

    public ArrayList CarregaTable() throws SQLException {
        FuncionarioDAO funDAO = new FuncionarioDAO();
        ArrayList lista = new ArrayList();
        ResultSet rs = funDAO.Listar();
        if (!rs.isBeforeFirst()) {
            return null;
        }
        
        
        
        while (rs.next()) {
            FuncionarioVO funvo = new FuncionarioVO(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDate("nasc"),
                    rs.getBigDecimal("salario"),
                    rs.getString("foto")
            );
            lista.add(funvo);
        }

        return lista;
    }

    
    public int Excluir(String id_txt) throws SQLException{
        int retorno;
        int id =Integer.parseInt(id_txt);
        
        FuncionarioDAO fundao = new FuncionarioDAO();
        retorno = fundao.excluir(id);
        return retorno;
    
    
    }
    
    
    
    public int Editar(String txt_id, FuncionarioVO funvo) throws SQLException, Exception {
        
        int retorno;
        int id = Integer.parseInt(txt_id);
        
        FuncionarioDAO fundao = new FuncionarioDAO();
        retorno = fundao.Editar(id, funvo);

        return retorno;
    }
    /*
    
     if (foto.isEmpty())
     throw new Exception ("Foto é obrigatório");
    
     if (foto.length()<3)
     throw new Exception ("Foto tem que ter pelo menos 3(três) caracteres");
    
     if (foto.length()>80)
     throw new Exception ("Foto tem que ter no máximo 80(vinte) caracteres");
    
     //System.out.println(Date.valueOf(LocalDate.now()));
    
    
     if ( nasc.after(Date.valueOf(LocalDate.now() )))
     throw new Exception ("Data não pode ser superior a data de hoje");
    
     if ( nasc.before(Date.valueOf("1900-01-01")) )            
     throw new Exception ("Data Inválida: "+nasc.toString());
    
     */
    /*//if (sal.equals(BigDecimal.ZERO))
     BigDecimal bigD = new BigDecimal("55");
     if (sal.compareTo(BigDecimal.ZERO)<=0)
     throw new Exception ("Salário deve ser maior que zero: "+sal.toString());
    
     System.out.println(sal+" - "+FuncionarioVO.maiorSal.toString()+ " = "+(sal.compareTo(FuncionarioVO.maiorSal) >0)); 
     if (sal.compareTo(FuncionarioVO.maiorSal) >0 )
     throw new Exception ("Salário deve ser menor que o maior salario:\n Maior salário: "+FuncionarioVO.maiorSal+"\n Salário Digitado: "+sal);
     
     */
}
