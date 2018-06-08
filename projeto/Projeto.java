package projeto;

import BAL.FuncionarioBAL;
import DAO.Conexao;
import DAO.FuncionarioDAO;
import VO.FuncionarioVO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class Projeto {

    public static void main(String[] args) {
Date nasc=Date.valueOf(LocalDate.now());
        try {
            
            ArrayList<FuncionarioVO> lista = new ArrayList();
     
             FuncionarioVO f1 = new FuncionarioVO(
             "TesteUpdate", 
             Date.valueOf("2015-12-25"), 
             BigDecimal.valueOf(99.11),
             "testeFoto"); 

             FuncionarioVO f2 = new FuncionarioVO(
             "TesteUpdate2",
             Date.valueOf("2015-12-25"),
             BigDecimal.valueOf(999.36),
             "testeFoto");

             lista.add(f1);
             lista.add(f2);

         
          
           
            Iterator<FuncionarioVO> it = lista.iterator();
            while (it.hasNext()) {
               System.out.println(it.next().getNome());            
            }
            
        
            
            
            /*
            Date dt = Date.valueOf( LocalDate.now() );           
            if ( nasc.after(Date.valueOf( LocalDate.now() )))
            if ( nasc.before(Date.valueOf("1900-01-01")))
     
        System.out.println(dt);
        /*
            BigDecimal valor1 = new BigDecimal(5);
            BigDecimal valor2 = new BigDecimal(1);

            if (valor1.compareTo(valor2) == 1) {
                System.out.println("valor1 é maior");
            } else if (valor2.compareTo(valor1) == 1) {
                System.out.println("valor2 é maior");
            }

            /*
            
             BigDecimal teste1 = new BigDecimal(99.123).setScale(22, RoundingMode.CEILING);
             BigDecimal teste2 = new BigDecimal(99.123).setScale(22, RoundingMode.FLOOR);
                        
             BigDecimal teste3 = new BigDecimal(99.123).setScale(22, RoundingMode.UP);
             BigDecimal teste4 = new BigDecimal(99.123).setScale(22, RoundingMode.DOWN);
            
             BigDecimal teste5 = new BigDecimal(99.123).setScale(22, RoundingMode.HALF_EVEN);
            
             System.out.println(teste1);
             System.out.println(teste2);
             System.out.println(teste3);
             System.out.println(teste4);
             System.out.println(teste5);
              
            
            
            
            
            
            
             /*
             BigDecimal d1 = new BigDecimal(123.456);
             BigDecimal d2 = new BigDecimal("123.456");
            
             BigDecimal salario1 = new BigDecimal(JOptionPane.showInputDialog(null, "Digite o Salário:"));
             BigDecimal salario2 = BigDecimal.valueOf(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o Salário Salário:")));             
             BigDecimal salario3 = BigDecimal.valueOf(123.456);
            
            
             System.out.println(
             "d1: "+d1+"\n"+
             "d2: "+d2+"\n"+
                    
             "salario1: "+salario1+"\n"+
             "salario2: "+salario2+"\n"+                    
             "salario3: "+salario3+"\n"
            
             );




            
            
            
            
             /*Exercico 1
             StringBuilder frase = new StringBuilder();
             String nome="";
             int idade;
            
             nome = JOptionPane.showInputDialog(null, "Digite o Nome:");
             idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade:")); 
             frase.append("Meu nome é ");
             frase.append(nome);
             frase.append(" e tenho ");
             frase.append(idade);
             frase.append(" anos");            
             System.out.println(frase);
             */
            /*/Exercício 2
             StringBuilder frase = new StringBuilder();
             BigDecimal salario;
             Date admissao;

            
             salario = new BigDecimal(JOptionPane.showInputDialog(null, "Digite o Salário:"));
             admissao = Date.valueOf(JOptionPane.showInputDialog(null, "Digite a data de nascimento:")); 
             frase.append("Comecei a trabalhar dia ");
             frase.append(admissao);
             frase.append(" ganhando R$ ");
             frase.append(salario);            
             System.out.println(frase);
             */
            /*Exercício 3            
             StringBuilder frase = new StringBuilder();
             BigDecimal salario;
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");                      
           
             salario = new BigDecimal(JOptionPane.showInputDialog(null, "Digite o Salário:"));
             LocalDate dt = LocalDate.parse(JOptionPane.showInputDialog(null, "Digite a data de nascimento:"),dtf); 
            
             frase.append("Comecei a trabalhar dia ");
             frase.append(dt.format(dtf));
             frase.append(" ganhando R$ ");
             frase.append(salario);            
            
             System.out.println(frase);
             */
          //Exercicio4
            /*
             Date data1;
             ArrayList<FuncionarioVO> lista = new ArrayList();
     
             FuncionarioVO f1 = new FuncionarioVO(
             "TesteUpdate", 
             Date.valueOf("2015-12-25"), 
             BigDecimal.valueOf(99.11),
             "testeFoto"); 

             FuncionarioVO f2 = new FuncionarioVO(
             "TesteUpdate2",
             Date.valueOf("2015-12-25"),
             BigDecimal.valueOf(999.36),
             "testeFoto");

             lista.add(f1);
             lista.add(f2);

             
             for(FuncionarioVO f: lista){  
             System.out.println(f.getSalario().toString());
      
             }
 

            
            
            
            
             /*       
             System.out.println(dt);
             System.out.println(dt.format(dtf));
             String nome="";         
             Date nasc=null;
             BigDecimal salario=null;
             String foto="";
           
             
                   
             
                     
            
             /* ver a diferça entre
            
            
             String s1 = "10";
             e
             String s1 = new String("10");
            
            
             int i1=10;
                       
             double d1 = 10;
             String s1 = "10";
             String s2 = "10";
            
            
            
             if (i1==d1)
             System.out.println("iguais");
                        
             if (s1.equals(i1))
             System.out.println("iguais");
            
             else
             System.out.println("nnn iguais");
            
             if (s1==s2)
             System.out.println("iguais");
             else
             System.out.println("nnn iguais");
             */
            /**
             * ************
             * DADOS ************ nome = JOptionPane.showInputDialog(null,
             * "Digite o Nome:"); nasc =
             * Date.valueOf(JOptionPane.showInputDialog(null, "Digite a data de
             * nascimento:")); salario = new
             * BigDecimal(JOptionPane.showInputDialog(null, "Digite o Salário
             * Salário:")); foto = JOptionPane.showInputDialog(null, "foto:");
             *
             *
             *
             *
             * FuncionarioVO funVO = new FuncionarioVO(nome, nasc, salario,
             * foto); FuncionarioDAO funDAO = new FuncionarioDAO();
             * FuncionarioBAL funBAL = new FuncionarioBAL();
             *
             *
             * funBAL.VerificarFuncionario(funVO); /* funDAO.Inserir(funVO);
             * funDAO.excluir(4);
             *
             * funVO = new FuncionarioVO("TesteUpdate",
             * Date.valueOf("2015-12-25"),
             * BigDecimal.valueOf(9999.11),"testeFoto"); funDAO.Editar(4,funVO);
             */
            /**
             * ************
             * LISTAR ************ ResultSet rs = funDAO.Listar(); if
             * (!rs.isBeforeFirst()) { System.out.println("Não retornou nada");
             * } while (rs.next()) { int id = rs.getInt("id"); nome =
             * rs.getString("nome"); nasc = rs.getDate("nasc"); salario =
             * rs.getBigDecimal("salario"); foto = rs.getString("foto");
             *
             * FuncionarioVO funvo = new FuncionarioVO(id, nome, nasc, Salario,
             * foto); //Imprimir }
             */
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
