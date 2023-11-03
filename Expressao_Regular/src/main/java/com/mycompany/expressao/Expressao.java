package com.mycompany.expressao;

import Classes.Expressoes_Regulares;
import java.util.Scanner;

/**
 *
 * @author steph
 */
public class Expressao {

    public static void main(String[] args) {
        Expressoes_Regulares ER = new Expressoes_Regulares();
        Scanner lerOpcao = new Scanner(System.in);
        int opcao=0;

        do{
            System.out.println("** Menu de opções **");

            System.out.println();
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Verificar assinatura");
            System.out.println("2 - Verificar parâmetros");
            System.out.println("3 - Verificar condição");
            System.out.println("4 - Verificar expressão matemática");
            System.out.println("5 - Verificar número binário impar positivo");
            System.out.println("6 - Verificar número binário par negativo");
            System.out.println("7 - Verificar data");
            System.out.println("8 - Sair");
            
            opcao = lerOpcao.nextInt();

            switch (opcao) {
                case 1 -> ER.fill("Assinatura");
                case 2 -> ER.fill("Parametro");
                case 3 -> ER.fill("Condicao");
                case 4 -> ER.fill("Operacao");
                case 5 -> ER.fill("BinarioPositivo");
                case 6 -> ER.fill("BinarioNegativo");
                case 7 -> ER.fill("Data");
                case 8 -> System.out.println("Até mais");
                default -> System.err.println("Opção inválida");
            }
        }while(opcao!=8);
    }
}
