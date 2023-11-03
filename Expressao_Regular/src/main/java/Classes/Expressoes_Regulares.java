/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author steph
 */
public class Expressoes_Regulares {
    protected String LETRA ="([A-Za-z])";
    protected String LETRAS ="(" + LETRA + "*)";
    
    protected String BRANCO ="\\s";
    protected String BRANCOS = BRANCO+"*";
    
    protected String CONDICIONAL = "[<>]?=|\\!=|\\&&|\\||";
    protected String OPERADORES =  "[\\+|\\-|\\/|\\*|\\%]";
    protected String CARACTERES_ESPECIAIS = "\\(|\\)|\\.|\\[|\\]|\\_";
    
    protected String DIGITO ="([0-9])";
    protected String DIGITOS = "("+DIGITO +"*)";
    protected String INTEIRO="((-?|\\+?)" + DIGITOS + ")";        
    protected String FRACAO = "(" + DIGITOS + "/" + DIGITOS + ")";
    protected String DECIMAL = "(\\.|\\," + DIGITOS + ")";
    protected String EXPONENCIAL = "(E\\^" + INTEIRO + ")";
    protected String RAIZ = "(" + DIGITOS + "\\^" + FRACAO + ")";
    protected String RAIZQ = "(√" + DIGITOS + ")";
    protected String POTENCIA = "(" + DIGITOS + "\\^" + DIGITOS + ")";
    protected String REAL = "(" + DIGITOS + "|" + INTEIRO + "|" + FRACAO + "|" + DECIMAL + "|" + RAIZ + "|" + RAIZQ + ")";

    protected String TIPO = "(int|float|char|void|double|bolean|String)";
    protected String ESTRUTURA = "(if|else|else if|elseif|for|while|do)*";
    
    protected String VARIAVEL = "(((" + LETRAS + DIGITOS + ")*)|(" + LETRAS + CARACTERES_ESPECIAIS + LETRAS + ")|(" + CARACTERES_ESPECIAIS + LETRAS + ")|(" + LETRAS + ")|(" + "(" + CARACTERES_ESPECIAIS + "("+ LETRAS + DIGITOS + ")*)))";
    
    protected String VETOR = "(" + VARIAVEL + "\\[" + VARIAVEL + "\\]" + ")";
    protected String VETORCOMP = "(" + VETOR + "((" + "\\." + VARIAVEL + "|" + VETOR + ")*))";
    protected String PARAMETRO ="("+TIPO+BRANCOS+VARIAVEL+")";
 
    protected String DIA = "((0*[1-9])" + "|([1|2](" + DIGITO + "))" + "|(30|31))"; 
    protected String MES = "(0*[1-9]|10|11|12)";
    protected String ANO = "(" + DIGITO + DIGITO + DIGITO + DIGITO + ")";
    protected String VIRGULA=",";
   
    protected String EXPRESSAO_BINARIO_POSITIVO = "(1)?(0*)(1)+";
    protected String EXPRESSAO_BINARIO_NEGATIVO ="(-1)?(0*)1*(0)+";
    protected String EXPRESSAO_PARAMETROS = PARAMETRO+VIRGULA+PARAMETRO;        
    protected String EXPRESSAO_ASSINATURA = TIPO+ BRANCOS + VARIAVEL + BRANCOS +"\\("+((PARAMETRO)+(",*"+ PARAMETRO))+"\\)";
    protected String EXPRESSAO_CONDICOES =ESTRUTURA + VARIAVEL + CONDICIONAL + VARIAVEL;
    protected String EXPRESSAO_OPERACAO = VARIAVEL+ OPERADORES + VARIAVEL;
    protected String EXPRESSAO_DATA = "(" + DIA + "/" + MES + "/" + ANO + ")";
    
    protected Map<String, String> EXPRESSAO = new HashMap<>();
    
    public Expressoes_Regulares() {
        EXPRESSAO = new HashMap<>();
        EXPRESSAO.put("Assinatura", EXPRESSAO_ASSINATURA);
        EXPRESSAO.put("Parametro", EXPRESSAO_PARAMETROS);
        EXPRESSAO.put("Condicao", EXPRESSAO_CONDICOES);
        EXPRESSAO.put("Operacao", EXPRESSAO_OPERACAO);        
        EXPRESSAO.put("BinarioPositivo", EXPRESSAO_BINARIO_POSITIVO);
        EXPRESSAO.put("BinarioNegativo", EXPRESSAO_BINARIO_NEGATIVO);
        EXPRESSAO.put("Data",  EXPRESSAO_DATA);
    }  
    
    public void fill(String tipo){
        System.out.println("\nDigite a setença: ");
        Scanner ler = new Scanner(System.in);
        String sentença = ler.nextLine();
        confere(EXPRESSAO.get(tipo),sentença);
    }
    
     protected void confere (String expressao, String sentenca){
        if(sentenca.isEmpty()){
            System.err.println("Sentença vazia.\n");
        }else if (sentenca.matches(expressao)){
            System.out.println("Palavra aceita!\n");
        }else{
            System.err.println("Palavra rejeitada!\n");
        }
    }  
}
