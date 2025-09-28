import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Cachorro> lista=new ArrayList<>();
        //objeto
        lista.add(new Cachorro(1,"Zeus","Grande",55.0));
        lista.add(new Cachorro(2,"Cacau","Grande",58.0));
        lista.add(new Cachorro(3,"Minnie","Pequeno",16.0));
        lista.add(new Cachorro(4,"Flopy","Medio",30.0));
        lista.add(new Cachorro(5,"Maya","Grande",60.0));

        //lista e nome do arquivocsv por parametro
        gravarArquivoCSV(lista,"dogs");
        //exibiArquivoCSV("dogs"); //exibe com scanner
        importarArquivoCSV("dogs"); //forma mais comum
    }
    public static void gravarArquivoCSV(List<Cachorro> lista,String nomeArq){
        //biblioteca
        OutputStreamWriter saida =null;
        Boolean falha=false;
        nomeArq+=".csv";

        try{
            saida=new OutputStreamWriter(new FileOutputStream(nomeArq),
                    StandardCharsets.UTF_8);
        }catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        try{
            saida.append("ID;Nome;Porte;Peso\n");
            for(Cachorro dog:lista){
                saida.write(String.format("%d;%s;%s;%.1f\n",dog.getId(),dog.getNome(),dog.getPorte(),dog.getPeso()));
            }
        }catch (IOException erro){
            System.out.println("Erro ao gravar no arquivo");
            erro.printStackTrace();
            falha=true;
        }finally {
            try {
                saida.close();
            }catch (IOException erro){
                System.out.println("erro ao feixar o arquivo");
                falha=true;
            }
            if (falha){
                System.exit(1);
            }
        }

        System.out.println("lendo o arquivo");

    }

    public static void exibiArquivoCSV(String nomeArq){
        FileReader arq=null;
        Scanner entrada=null;
        Boolean falha=false;
        nomeArq+=".csv";

        try {
            arq=new FileReader(nomeArq);
            entrada=new Scanner(arq).useDelimiter(";|\\n");
        }catch (FileNotFoundException erro){
            System.out.println("Arquivo não existe");
            System.exit(1);
        }

        try {
            Boolean cabecalho=true;
            while (entrada.hasNext()){
                if (cabecalho){
                    String titulo1=entrada.next();
                    String titulo2=entrada.next();
                    String titulo3=entrada.next();
                    String titulo4=entrada.next();

                    System.out.printf("%s;%s;%s;%s\n",titulo1,titulo2,titulo3,titulo4);
                    cabecalho=false;
                }else{
                    Integer id = entrada.nextInt();
                    String nome = entrada.next();
                    String porte = entrada.next();
                    Double peso = entrada.nextDouble();
                    
                    System.out.printf("%d;%s;%s;%.1f\n",id,nome,porte,peso);
                }
            }
        }catch (NoSuchElementException erro){
            System.out.println();
        }catch (IllegalStateException erro){
            System.out.println();
        }
        finally {
            try {
                entrada.close();
                arq.close();
            }catch (IOException erro){
                System.out.println("erro ao feixar o arquivo");
                falha=true;
            }
            if (falha){
                System.exit(1);
            }
        }
    }

    public static void importarArquivoCSV(String nomeArq){
        Reader arq = null; //arq eh o objeto que corresponde o arquivo
        BufferedReader entrada =null; //entrada eh o objeto usado para ler do arquivo
        nomeArq+=".csv";
        List<Cachorro> listaLido=new ArrayList<>();

        //bloco trycatch para abrir o arquivo
        try {
            arq=new InputStreamReader(new FileInputStream(nomeArq),"UTF-8");
            entrada=new BufferedReader(arq);
        }catch (IOException erro){
            System.out.println("Erro na abertura do arquivo");
            System.exit(1);
        }

        try {
            String[] registro; //registro é um vetor que armazenará toda as linhas do arquivo
            String linha=entrada.readLine(); //le somenta uma linha inteira
            registro=linha.split(";");
            System.out.printf("%4s %-19s %-9s %4s \n",registro[0],registro[1],registro[2],registro[3]);

            //ler a segunda linha do arquivo
            linha = entrada.readLine();
            while (linha!=null){
                registro = linha.split(";");
                Integer id=Integer.valueOf(registro[0]);
                String nome= registro[1];
                String porte= registro[2];
                Double peso = Double.valueOf(registro[3].replace(",","."));
                Cachorro dog=new Cachorro(id,nome,porte,peso);
                listaLido.add(dog);
                System.out.printf("%4d;%-19s;%-9s;%4.1f\n",id,nome,porte,peso);
                linha =entrada.readLine();
            }
        }catch (IOException erro){
            System.out.println("erro ao ler arquivo");
            erro.printStackTrace();
        }
        finally {
            try {
                entrada.close();
                arq.close();
            }catch (IOException erro){
                System.out.println("Erro ao fechar o arquivo");
            }
        }
        System.out.println("\nLista lida do arquivo");
        for (Cachorro dog:listaLido){
            System.out.println(dog);
        }

    }
}