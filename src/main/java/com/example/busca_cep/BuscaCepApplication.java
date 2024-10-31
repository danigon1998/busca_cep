package com.example.busca_cep;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.busca_cep.services.buscaCep;

@SpringBootApplication
public class BuscaCepApplication {

	public static void main(String[] args) throws IOException{
		buscaCep buscaCep = new buscaCep();
		String cep = "00000000";
		Scanner sc = new Scanner(System.in);
		while(cep != "1") {
			System.out.println("Digite um CEP válido, somente números. Digite 1 para sair: ");
			cep = sc.nextLine();
			if(cep.equals("1")) {
				break;
			}
			try {
				validarNumero(cep);
				String endereco = buscaCep.buscaEndereco(cep);
				if(endereco != null) {
					FileWriter escritor = new FileWriter(cep + ".json");
					escritor.write(endereco);
					escritor.close();
				}
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void validarNumero(String str) throws IllegalArgumentException{
		if(!str.matches("\\d+")) {
			throw new IllegalArgumentException("Entrada inválida. Apenas números são permitidos.");
		}
		else if(str.length() != 8) {
			throw new IllegalArgumentException("Entrada inválida. O CEP deve conter 8 dígitos.");
		}
	}

}
