import javax.swing.*;
import java.util.Scanner;
import java.util.Scanner;
import java.io.*;



public class Main {
    public static String[][] splitFicheiro(File ficheiro) throws FileNotFoundException{

        Scanner in = new Scanner(new File(ficheiro.toURI()));

        String[] separar = new String[9];
        int i=0;
        String linha = in.nextLine();
        String[][] dados = new String[100][9];
        while (in.hasNextLine()) {

            linha = in.nextLine();
            separar = linha.split(";");

            dados[i][0]=separar[0];
            dados[i][1]=separar[1];
            dados[i][2]=separar[2];
            dados[i][3]=separar[3];
            dados[i][4]=separar[4];
            dados[i][5]=separar[5];
            dados[i][6]=separar[6];
            dados[i][7]=separar[7];
            dados[i][8]=separar[8];

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
        //System.out.println("Numero total de vendas: " + sum);
        //Sstem.out.println("Valor Total : " + total);

        return resultado;
    }

    public static double lucro(double [] arrayGenerico){

        double lucro = arrayGenerico[1] * 0.1;

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

                        System.out.println("O valor do lucro é: "+lucro(vendasFicheiro(meuFicheiro))+"€");
                        break;

                    case 4:
                        Cliente(meuFicheiro);
                        break;


                    case 5:
                        Editora(meuFicheiro);
                        break;


                    case 6:
                        String nomeJogoCaro = valorMaior(meuFicheiro);

                        String [][] matriz =  splitFicheiro(ficheiro);
                        System.out.println("O jogo mais caro é: " + nomeJogoCaro + " ");
                        System.out.println("Comprado por: ");
                        for (int i = 0; i < matriz.length ; i++) {
                            for (int j = 7; j < matriz[i].length ; j+=8) {
                                if (matriz[i][j].equals(nomeJogoCaro) ){
                                    System.out.println( matriz[i][2]);
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

    private static void Editora(String[][] matrizGenerica) {
        int op;
        do {
            op=Integer.parseInt(JOptionPane.showInputDialog("Escolha a editora:\n" +
                    "1-CD Projekt Red\n" +
                    "2-Team Cherry\n" +
                    "3-Xbox Game Studion\n" +
                    "4-Sony\n" +
                    "5-EA\n" +
                    "6-CAPCOM\n" +
                    "7-Bandai Namco\n" +
                    "8-IO Interactive\n" +
                    "9-Activision\n" +
                    "10-Team17\n" +
                    "11-FromSoftware\n" +
                    "12-Polyphony Digital\n" +
                    "13-NetherRealm\n" +
                    "14-Ubisoft\n" +
                    "15-Santa Monica\n" +
                    "16-Giants\n" +
                    "17-Coffee Stain\n" +
                    "18-Annapuma\n" +
                    "19-Naughty Dog\n" +
                    "20-Nintendo\n" +
                    "21-Rockstar\n" +
                    "22-Valve\n" +
                    "23-Beteshda\n" +
                    "24-Paradox\n" +
                    "25-Blizzard\n" +
                    "26-Riot\n" +
                    "27-Sega\n" +
                    "28-2K\n" +
                    "29-Firaxis\n" +
                    "30-Avalanche\n" +
                    "31-Astragon\n" +
                    "32-Big Cheese\n" +
                    "33-Haemimont\n" +
                    "0-Voltar ao menu anterior"


            ));

            switch (op){

                case 0:
                    break;

                case 1:

                    EditoraEscolhida(matrizGenerica,"CD Projekt Red");
                    break;

                case 2:
                    EditoraEscolhida(matrizGenerica,"Team Cherry");
                    break;

                case 3:
                    EditoraEscolhida(matrizGenerica,"Xbox Game Studion");
                    break;

                case 4:
                    EditoraEscolhida(matrizGenerica,"Sony");
                    break;

                case 5:
                    EditoraEscolhida(matrizGenerica,"EA");
                    break;

                    case 6:
                        EditoraEscolhida(matrizGenerica,"CAPCOM");
                    break;

                case 7:
                    EditoraEscolhida(matrizGenerica,"Bandai Namco");
                    break;

                case 8:
                    EditoraEscolhida(matrizGenerica,"IO Interactive");
                    break;

                case 9:
                    EditoraEscolhida(matrizGenerica,"Activision");
                    break;

                case 10:
                    EditoraEscolhida(matrizGenerica,"Team17");
                    break;

                case 11:
                    EditoraEscolhida(matrizGenerica,"FromSoftware");
                    break;

                case 12:
                    EditoraEscolhida(matrizGenerica,"Polyphony Digital");
                    break;

                case 13:
                    EditoraEscolhida(matrizGenerica,"NetherRealm");
                    break;

                case 14:
                    EditoraEscolhida(matrizGenerica,"Ubisoft");
                    break;

                case 15:
                    EditoraEscolhida(matrizGenerica,"Santa Monica");
                    break;

                case 16:
                    EditoraEscolhida(matrizGenerica,"Giants");
                    break;
                case 17:
                    EditoraEscolhida(matrizGenerica,"Coffee Stain");
                    break;
                case 18:
                    EditoraEscolhida(matrizGenerica,"Annapuma");
                    break;
                case 19:
                    EditoraEscolhida(matrizGenerica,"Naughty Dog");
                    break;
                case 20:
                    EditoraEscolhida(matrizGenerica,"Nintendo");
                    break;
                case 21:
                    EditoraEscolhida(matrizGenerica,"Rockstar");
                    break;
                case 22:
                    EditoraEscolhida(matrizGenerica,"Valve");
                    break;
                case 23:
                    EditoraEscolhida(matrizGenerica,"Beteshda");
                    break;
                case 24:
                    EditoraEscolhida(matrizGenerica,"Paradox");
                    break;
                case 25:
                    EditoraEscolhida(matrizGenerica,"Blizzard");
                    break;
                case 26:
                    EditoraEscolhida(matrizGenerica,"Riot");
                    break;
                case 27:
                    EditoraEscolhida(matrizGenerica,"Sega");
                    break;
                case 28:
                    EditoraEscolhida(matrizGenerica,"2K");
                    break;
                case 29:
                    EditoraEscolhida(matrizGenerica,"Firaxis");
                    break;
                case 30:
                    EditoraEscolhida(matrizGenerica,"Avalanche");
                    break;
                case 31:
                    EditoraEscolhida(matrizGenerica,"Astragon");
                    break;
                case 32:
                    EditoraEscolhida(matrizGenerica,"Big Cheese");
                    break;
                case 33:
                    EditoraEscolhida(matrizGenerica,"Haemimont");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção invalida, tente novamente!");
                    break;




            }
        }while(op!=0);

    }

    public static void EditoraEscolhida(String[][]matriz,String editora) {


        for (int i=0; i< matriz.length;i++){

                if (matriz[i][5].equals(editora)){
                    System.out.println(matriz[i][6]);
                    System.out.println(matriz[i][7]);
                }
        }
    }

    private static void Cliente(String[][] matrizGenerica) {
            int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Escolha o numero de id:"));
            int id=0;
            boolean stop=false;
            for (int i = 0; i< matrizGenerica.length;i++){
                id=Integer.parseInt(matrizGenerica[i][1]);
                if (id == idCliente && !stop){

                    System.out.println(matrizGenerica[i][2]);
                    System.out.println(matrizGenerica[i][3]);
                    System.out.println(matrizGenerica[i][4]);
                    stop = true;
                }





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