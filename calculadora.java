package com.mycompany.calculadora;

import java.util.Scanner;

/**
 *
 * @author talita
 */

public class calculadora{
    
    //Função pra calcular o número de pessoas que visualizaram o anúncio original
    public static int visualizaOriginal(double investimento){ 
        
        double pessoas = 0.0;       
        /*O anúnco possui 30 visualizações a cada 1 real investido, ou seja
        cada visualização equivale a aproximadamente 0,033 centavos*/
        pessoas = (investimento/0.033);
        return (int)pessoas;
    }
    
    public static int clicksAnuncio(int visualizacoes){
        
        return ((12 * visualizacoes)/100);
    }
    
    //função pra calcular a quantidade de compartilhamentos através das visualizações
    public static int compartilhados(int visualizacoes){
        // 12% das pessoas clicam no anúncio
        int clicks = clicksAnuncio(visualizacoes);
        // 15% das pessoas que clicam, compartilham nas redes sociais
        int anunciosCompartilhados = ((15 * clicks)/100);
        
        return anunciosCompartilhados;
    }
    
    public static int engajamento(int anuncios){
        if (anuncios == 0) { //critério de parada da função
            return 0;
        }
        else{
            int visualizacoes = anuncios * 40;           
            //quantidade de compartilhamentos que essas visualizações renderam
            int novosCompartilhamentos = compartilhados(visualizacoes);           
            /*Função recursiva que soma a quantidade de visualizações atuais,
            com as visualizações provindas dos novos anúncios compartilhados
            */
            return visualizacoes + engajamento(novosCompartilhamentos);
        }
    }
    
    public static int visualizacaoTotal(double dinheiroInvestido){
        Scanner sc = new Scanner(System.in);
               
        //número de visualizações que o anúncio original teve
        int visualizacoesOriginal = visualizaOriginal(dinheiroInvestido);
        
        //quantidade de vezes que o anúncio original foi compartilhado
        int compartilhamentoInicial = compartilhados(visualizacoesOriginal);
        
        //numero de visualizações que os anuncios compartilhados tiveram
        int visualizacoesCompartilhados = engajamento(compartilhamentoInicial);
        
        int visualizacaoTotal = visualizacoesOriginal + visualizacoesCompartilhados;

        return visualizacaoTotal;
    }
    
    public static void main(String[] args) {
        System.out.println("Quanto deseja investir?");
        Scanner sc = new Scanner(System.in);
        double investimento = sc.nextDouble();
        
        System.out.println("Este anúncio terá aproximadamente " + visualizacaoTotal(investimento) + " visualizações." );
        
    }
    
}

