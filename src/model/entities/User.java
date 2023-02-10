package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.exceptions.DomainException;

public class User {

	private String nameUser;
	private String emailUser;
	private String passwordUser;
	private Date birthdayUser;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public User(String nameUser, String emailUser, String passwordUser, Date birthdayUser) {
		super();
		this.nameUser = nameUser;
		this.emailUser = emailUser;
		this.passwordUser = passwordUser;
		this.birthdayUser = birthdayUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public Date getBirthdayUser() {
		return birthdayUser;
	}

	public void setBirthdayUser(Date birthdayUser) {
		this.birthdayUser = birthdayUser;
	}

	public void updatePassword(String password, String testPassword) {
		if (password.compareTo(password) == 0) {
			throw new DomainException("A senha digita é a senha atual!!");
		}
		if (password.compareTo(testPassword) != 0) {

			throw new DomainException("As senhas não são iguais!!");

		}

	}

	public String showData(Boolean showData) {
		if (showData == true) {
			return "Seus dados: " + "/n" + "Nome: " + nameUser + "/n" + "Email: " + emailUser + "/n" + "Senha: "
					+ passwordUser + "/n" + "Aniversario: " + sdf.format(birthdayUser);
		} else {
			return "Certo saindo....";
		}
	}

	public String toString() {
		StringBuilder stb = new StringBuilder();

		stb.append("Bem vindo ao sistema: " + nameUser + "/n");
		stb.append("Email: " + emailUser);

		return stb.toString();
	}

}
