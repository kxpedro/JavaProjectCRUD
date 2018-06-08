package VO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;


public class FuncionarioVO {
    private int id;
    private String nome;
    private Date nasc;
    private BigDecimal salario;
    private String foto;
    public static  BigDecimal maiorSal = new BigDecimal(99.99).setScale(2, RoundingMode.UP);
     

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getNasc() {
        return nasc;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFoto() {
        return foto;
    }

    public FuncionarioVO(int id, String nome, Date nasc, BigDecimal salario, String foto) {
        this.id = id;
        this.nome = nome;
        this.nasc = nasc;
        this.salario = salario;
        this.foto = foto;
    }

    public FuncionarioVO(String nome, Date nasc, BigDecimal salario, String foto) {
        this.nome = nome;
        this.nasc = nasc;
        this.salario = salario;
        this.foto = foto;
        
       
    }   
    
}
