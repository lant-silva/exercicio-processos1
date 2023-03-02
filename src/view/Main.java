//Exercicio 1
package view;
import controller.RedesController;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		RedesController control = new RedesController();
		Scanner input = new Scanner(System.in);		
		
		// Escolhi fazer um switch case para que a
		// execução dos métodos ficassem mais organizadas,
		// e que todas as classes pudessem ser observadas
		// ao mesmo tempo na hora de executar.
		
		int escolha=0;
		String menu = "Escolha um método para ser executado\n1- Nome do sistema\n2- Ip Config\n3- Fazer um ping no site Google\n9- Sair";
		System.out.println(menu);
		while (escolha != 9) {
			escolha = input.nextInt();
			switch (escolha) {
			case 1:
				String sistema = control.os();
				System.out.println(sistema);
				System.out.println(menu);
				break;
			case 2:
				control.ip();
				System.out.println(menu);
				break;
			case 3:
				control.ping();
				System.out.println(menu);
				break;
			case 9:
				System.out.println("Programa finalizado.");
				break;
			}
		}
		input.close();
	}
}
