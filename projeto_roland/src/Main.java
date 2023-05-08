import javax.swing.*;
import java.util.Scanner;
import java.util.Scanner;
import java.io.*;



public class Main {
    public static String[][] splitFicheiro(File ficheiro) throws FileNotFoundException{

        Scanner in = new Scanner(new File(ficheiro.toURI()));

        String[] div = new String[9];
        int i=0;
        String linha = in.nextLine();
        String[][] dados = new String[100][9];
        while (in.hasNextLine()) {

            linha = in.nextLine();
            div = linha.split(";");

            dados[i][0]=div[0];  //     guarda idVenda
            dados[i][1]=div[1];  //     guarda idCliente
            dados[i][2]=div[2];    // nomeCliente
            dados[i][3]=div[3]; // contacto
            dados[i][4]=div[4]; // email
            dados[i][5]=div[5]; // editora
            dados[i][6]=div[6]; // categoria
            dados[i][7]=div[7]; //jogo
            dados[i][8]=div[8]; //valor

            i++;

        }
        return dados;
    }



    public static double [] vendasFicheiro(String[][] x){

        int sum = 0;
        double num, total = 0;

        for (int j = 0; j < x.length; j++) {
            num = Double.parseDouble(x[j][8]);

            total += num;
            sum++;

        }
            double resultado [] = {
                sum,total
            };
                      //ystem.out.println("Numero total de vendas: " + sum);
        //stem.out.println("Valor Total : " + total);

        return resultado;
    }

    public static double lucro(double [] abc){

        double lucro = abc[1] * 0.1;

        return lucro;
    }

    public static String valorMaior(String [][] matriz){



        double maiorValor = 0;
        String lineMaiorNome = "", nomeClientes = "";


        for(int line=0;line< matriz.length;line++){
            for(int col=8;col<matriz[0].length;col+=8){



                double preco = Double.parseDouble(matriz[line][col]);

                if (preco > maiorValor) {
                    maiorValor = preco;
                    lineMaiorNome = matriz[line][7];
                    nomeClientes = matriz[line][2];



                }


            }

        }





        return lineMaiorNome;
    }









    public static void menu(File ficheiro) throws FileNotFoundException {


        int opcaoMenu;
        String[][] meuFicheiro = splitFicheiro(ficheiro);
        try {


            do {
                opcaoMenu = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opções: \n1 - Ler ficheiro \n 2 - Exibir número de vendas e total \n 3 - Ver Lucro  \n4 - Exibir dados de clientes \n5 - Opções de jogos e gêneros \n6 - Jogo mais caro \n 7 - sair"));
                switch (opcaoMenu){

                    case 1:
                        meuFicheiro = splitFicheiro(ficheiro);

                        for (int i = 0; i < meuFicheiro.length ; i++)
                        {
                            for (int j = 0; j <meuFicheiro[i].length ; j++) {
                               System.out.println(meuFicheiro[i][j] ) ;
                            }
                        }


                        break;

                    case 2:

                         double resultado [] = vendasFicheiro(meuFicheiro);
                        System.out.println("Foram realizadas " + resultado[0] + " vendas. " + " O valor total é: " + resultado[1]);

                        break;

                    case 3:

                        System.out.println(lucro(vendasFicheiro(meuFicheiro)));
                        break;

                    case 4:

                        break;


                    case 5:

                        break;


                    case 6:
                        String nomeJogoCaro = valorMaior(meuFicheiro);

                        String [][] matriz =  splitFicheiro(ficheiro);
                        System.out.print("O jogo mais caro é: " + nomeJogoCaro + " ");
                        for (int i = 0; i < matriz.length ; i++) {
                            for (int j = 7; j < matriz[i].length ; j+=8) {
                                if (matriz[i][j].equals(nomeJogoCaro) ){
                                    System.out.print(" Compador: " + matriz[i][2]);
                                }
                            }
                        }

                        break;


                    case 7:

                        JOptionPane.showMessageDialog(null,"Programa desligado");
                        break;




                }

            } while (opcaoMenu != 7);
        }catch (FileNotFoundException exc){
            System.out.println("Ficheiro não encontrado Error!!!!!");
        }
    }

    public static void main(String[] args) {

        try{
            File ficheiro = new File("GameStart.csv");
            menu(ficheiro);

        } catch(FileNotFoundException exc){

            System.out.print("Not found");
        }





    }
}