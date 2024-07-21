package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        //Testando análise do candidato
        //analisarCandidato(1900.0);
        //analisarCandidato(2200.0);
        //analisarCandidato(2000.0);

        //case 2 selecaoCandidatos();
        // case 3 imprimirSelecionados();

        //Case 4
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};
        for (String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }
    //Case 4
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            //continuarTentando e tentativasRealizadas em algum momento da aplicação elas precisarão sofrer alterações para não virar um looping infinito
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else System.out.println("Contato realizado com sucesso!");
        }while (continuarTentando && tentativasRealizadas <3);

        if (atendeu) System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa.");
        else System.out.println("Não conseguimos contato com " + candidato + ", número máximo de tentativas " + tentativasRealizadas + " realizada.");
    }

    //case 4 - método auxiliar - Simula através de uma expressão randômica que se o valor entre 1 e 3 = 1, ele atendeu e força a tentativa de ligar
    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    //Case 3
    static void imprimirSelecionados(){
        //Array com os Candidatos
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};
        System.out.println("Imprimindo a lista de candidatos informando o índice do elemento");
        //utilizando for tradicional pois necessita imprimir o índice na lista.
        for (int indice = 0; indice < candidatos.length; indice++){
            System.out.println("O candidato de índice " + (indice+1) + " é " + candidatos[indice]);
        }

        //Forma abreviada
        System.out.println("Forma abreviada de interação for each");
        for (String candidato: candidatos){
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    //Case 2
    static void selecaoCandidatos(){
        //Array com os Candidatos
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRíCIO","MIRELA","DANIELA","JORGE"};
        //Tem por enquanto 0 candidatos selecionados
        int candidatosSelecionados = 0;
        //candidatoAtual = 0 (índíce do array)
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while  (candidatosSelecionados < 5 && candidatoAtual < candidatos.length){ // && candidatoAtual < candidatos.length - regra de interrupção
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O canditado" + candidato + "Solicitou este valor de salário " + salarioPretendido);
            if (salarioBase >= salarioPretendido){
                System.out.print("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }
    //Case 2 - Método que simula o valor sugerido retornando valor double
    static  double valorPretendido(){
        return  ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    //Case 1 - Análise do Candidato pelo salário pretendido/base
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato.");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta.");
        }else{
            System.out.println("Aguardar o resultado dos demais candidatos.");

        }
    }

}
