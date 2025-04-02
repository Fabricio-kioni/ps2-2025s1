package ps2.lab06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class Lab06Application implements CommandLineRunner {
    public static void main (String[] args){
        SpringApplication.run(Lab06Application.class, args);
    }
    @Override
	public void run(String... args) {
		System.out.println("# Gerenciador de Professores e Faculdades!");
        boolean sair = false;
        while (!sair){
            System.out.println("\nMenu");
            System.out.println("(1) Criar Faculdade");
            System.out.println("(2) Listar Faculdades");
            System.out.println("(3) Criar Professor");
            System.out.println("(4) Listar Professor");
            System.out.println("(0) Sair");
            System.out.print(" Escolha uma opção: ");
            int opcao = Integer.parseInt(entrada.nextLine());
            switch(opcao){
                case 1: cadastrarFaculdade(entrada, FaculdadeRepo);
                        break;
                case 2: listarFaculdades(FaculdadeRepo);
                        break;
                case 3: cadastrarProfessor(entrada, FaculdadeRepo, ProfessorRepo);
                        break;
                case 4: listarProfessores(ProfessorRepo);
                        break;
                case 0: sair = true; break;
                default:
                    System.out.print("Opção Inválida");
            }
        }
        entrada.close();
        System.out.println("Programa Encerrado.");
    }
    private void cadastrarFaculdade(Scanner entrada, FaculdadeRepo faculdadeRepo) {
        System.out.print("Nome da nova faculdade: ");
        String nome = entrada.nextLine();
        System.out.print("Ano de fundação da faculdade: ");
        int anoFundacao = Integer.parseInt(entrada.nextLine());
        Faculdade faculdade = new Faculdade(nome, anoFundacao);
        faculdadeRepo.save(faculdade);
        System.out.println("Faculdade cadastrada com sucesso!");
    }
    private void listarFaculdades(FaculdadeRepo faculdadeRepo) {
        Iterable<Faculdade> faculdades = faculdadeRepo.findAll();
        if (faculdades.isEmpty()) {
            System.out.println("Não há faculdades cadastradas.");
            return;
        }
        System.out.println("\nLista de Faculdades:");
        System.out.printf("%-5s %-30s %-15s%n", "ID", "NOME", "ANO FUNDAÇÃO");
        
        for (Faculdade faculdade : faculdades) {
            System.out.printf("%-5d %-30s %-15d%n", 
                       faculdade.getId(), 
                       faculdade.getNome(), 
                       faculdade.getAnoFundacao());
        }
    }
    private void cadastrarProfessor(Scanner entrada, FaculdadeRepo faculdadeRepo, ProfessorRepo professorRepo) {
        System.out.print("Nome do novo professor: ");
        String nome = entrada.nextLine();
        
        System.out.print("CPF do novo professor: ");
        String cpf = entrada.nextLine();
        
        System.out.print("Matrícula do novo professor: ");
        int matricula = Integer.parseInt(entrada.nextLine());
        
        Iterable<Faculdade> faculdades = faculdadeRepo.findAll();
        
        if (faculdades.isEmpty()) {
            System.out.println("Não há faculdades cadastradas. Cadastre uma faculdade primeiro.");
            return;
        }
        
        System.out.println("Faculdade do novo professor (selecione um dos números abaixo)");
        for (int i = 0; i < faculdades.size(); i++) {
            System.out.printf("- (%d) %s%n", i + 1, faculdades.get(i).getNome());
        }
        
        System.out.print("Entre o número da faculdade: ");
        int faculdadeIndex = Integer.parseInt(entrada.nextLine());
        
        if (faculdadeIndex < 1 || faculdadeIndex > faculdades.size()) {
            System.out.println("Número de faculdade inválido!");
            return;
        }
        
        Faculdade faculdadeEscolhida = faculdades.get(faculdadeIndex - 1);
        Professor professor = new Professor(nome, cpf, matricula);
        professor.setFaculdade(faculdadeEscolhida);
        professorRepo.save(professor);
        
        System.out.println("Professor cadastrado com sucesso!");
    }
    
    private void listarProfessores(ProfessorRepo professorRepo) {
        Iterable<Professor> professores = professorRepo.findAll();
        if (professores.isEmpty()) {
            System.out.println("Não há professores cadastrados.");
            return;
        }
        
        System.out.println("\nLista de Professores:");
        System.out.printf("%-5s %-20s %-15s %-15s %-30s%n", "ID", "NOME", "CPF", "MATRÍCULA", "FACULDADE");
        
        for (Professor professor : professores) {
            String nomeFaculdade = "Não atribuída";
            
            if (professor.getFaculdade() != null) {
                nomeFaculdade = professor.getFaculdade().getNome();
            }
            
            System.out.printf("%-5d %-20s %-15s %-15d %-30s%n", 
                       professor.getId(), 
                       professor.getNome(), 
                       professor.getCpf(), 
                       professor.getMatricula(),
                       nomeFaculdade);
        }
    }
}