import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //data atual
        LocalDate dataAtual = LocalDate.now();
        System.out.println("data atual");
        System.out.println(dataAtual);
        //mascara
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = formatador.format(dataAtual);
        System.out.println(dataFormatada);

        LocalDate outraData = LocalDate.of(1993, 6, 11);
        System.out.println("Outra data:");
        System.out.println(outraData);

        System.out.println("-".repeat(10));
        if (dataAtual.isAfter(outraData)) {
            System.out.println("A data atual é posterior à data 11/06/1993");
        }

        if (dataAtual.isBefore(outraData)) {
            System.out.println("A data atual é anterior à data 11/06/1993");
        }



        Month mes = dataAtual.getMonth();
        //coloca o mes em portugues
        String mesEmPtBr = mes.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("pt-BR"));
        System.out.println("Mês atual em português:");
        System.out.println(mesEmPtBr);
        System.out.println("-".repeat(10));


        DayOfWeek diaDaSemana = dataAtual.getDayOfWeek();//metodo para pegar o dia da semana
        System.out.println("Dia da semana atual:");
        System.out.println(diaDaSemana);

        Integer diaNumerico = dataAtual.getDayOfWeek().getValue();
        switch (diaNumerico) {
            case 1 -> System.out.println("Segundou...");
            case 2 -> System.out.println("Terçou...");
            case 3 -> System.out.println("Quarta...");
            case 4 -> System.out.println("Quinta, quase lá...");
            case 5 -> System.out.println("Sextouuu...");
            case 6 -> System.out.println("Sabadaço...");
            case 7 -> System.out.println("Domingou...");
            default -> System.out.println("Dia inválido");
        }

        LocalDateTime dataHoraAtual = LocalDateTime.now();
        System.out.println("Data e hora atuais:");
        System.out.println(dataHoraAtual);
    }
}