package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.User;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Nome: ");
			String name = sc.nextLine();
			System.out.println("Email: ");
			String email = sc.nextLine();
			System.out.println("Data de aniversario (dd/mm/yyyy): ");
			Date birthdayUser = sdf.parse(sc.next());
			User user = new User(name, email, birthdayUser);

			System.out.println("Senha: ");
			sc.nextLine();
			String password = sc.nextLine();
			System.out.println("Digite a senha novamente: ");
			String testPassword = sc.nextLine();
			user.writePassword(password, testPassword);

			System.out.println("Você deseja trocar sua senha ?");
			System.out.println("(1 - sim / 2 - não)");
			int option = sc.nextInt();
			if (functionOptionUpdatePassword(option) == true) {
				System.out.println("Senha: ");
				sc.nextLine();
				password = sc.nextLine();
				System.out.println("Digite a senha novamente: ");
				testPassword = sc.nextLine();
				user.updatePassword(password, testPassword);

			} else {
				System.out.println("Saindo...................");
			}

			System.out.println("Deseja ver seus dados ? (1 - sim / 2 - não)");
			int showData = sc.nextInt();
			System.out.println(user.showData(functionShowData(showData)));

		}

		catch (RuntimeException e) {
			System.out.println("erro inesperado");

		}

		catch (ParseException e) {
			System.out.println("Formato invalido");
		}

		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		sc.close();

	}

	public static boolean functionShowData(int showData) {
		if (showData != 1) {
			return false;
		}
		return true;

	}

	public static Boolean functionOptionUpdatePassword(int option) {
		if (option == 1) {
			return true;
		}
		return false;

	}
}
