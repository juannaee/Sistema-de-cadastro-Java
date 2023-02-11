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

	public User(String nameUser, String emailUser, Date birthdayUser) {
		super();
		this.nameUser = nameUser;
		this.emailUser = emailUser;

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

	public void writePassword(String password, String repeatPassword) throws DomainException {
		if (!password.equals(repeatPassword)) {
			throw new DomainException("As senhas não são iguais!!");
		}
		this.passwordUser = password;

	}

	public void updatePassword(String repeatPassword, String newPassword) throws DomainException {
		if (newPassword.equals(this.passwordUser)) {
			throw new DomainException("A senha digitada é a senha atual!!");
		}
		if (!repeatPassword.equals(newPassword)) {
			throw new DomainException("As senhas não são iguais!!");
		}
		this.passwordUser = newPassword;

	}

	public String showData(Boolean showData) {
		if (showData != true) {
			return "Certo saindo....";
		}

		return "Seus dados: " + "\n" + "Nome: " + nameUser + "\n" + "Email: " + emailUser + "\n" + "Senha: "
				+ passwordUser + "\n" + "Aniversario: " + sdf.format(birthdayUser);
	}

	public String toString() {
		StringBuilder stb = new StringBuilder();

		stb.append("Bem vindo ao sistema: " + nameUser + "\n");
		stb.append("Email: " + emailUser);

		return stb.toString();
	}

}
