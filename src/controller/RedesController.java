package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	public String os() {
		String sys = System.getProperty("os.name");
		return sys;
	}
	
	public void ip() {
		String sistema = new String();
		String Win = "ipconfig";
		String Unix = "ifconfig";
		sistema = os();
			
		if(sistema.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec(Win);
				InputStream dados = p.getInputStream();
				InputStreamReader ler = new InputStreamReader(dados);
				BufferedReader buffer = new BufferedReader(ler);
					
				String linha = buffer.readLine();
				while(linha!=null) {
					if(linha.contains("IPv4")||linha.contains("adapter")||linha.contains("Ethernet")||linha.contains("Wireless")||linha.contains("Adaptador")){
						System.out.println(linha);
						}
					linha = buffer.readLine();
					}
				buffer.close();
				ler.close();
				dados.close();
				
				} catch(Exception e) {
					String err = e.getMessage();
					System.out.println(err);
				}
			}
		else {
			try {
				Process p = Runtime.getRuntime().exec(Unix);
				InputStream dados = p.getInputStream();
				InputStreamReader ler = new InputStreamReader(dados);
				BufferedReader buffer = new BufferedReader(ler);
					
				String linha = buffer.readLine();
				while(linha!=null) {
					if(linha.contains("IPv4")||linha.contains("adapter")||linha.contains("Ethernet")||linha.contains("Wireless")||linha.contains("Adaptador")){
						System.out.println(linha);
						}
					linha = buffer.readLine();
					}
				dados.close();
				ler.close();
				buffer.close();
				} catch(Exception e) {
					String err = e.getMessage();
					System.out.println(err);
				}
		}
	}
	
	public void ping() {
		String os = os();
		String Win = "ping -4 -n 10 www.google.com.br";
		String Unix = "ping -4 -c 10 www.google.com.br";
		if (os.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec(Win);
				InputStream dados = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(dados);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while (linha != null) {
					if(linha.contains("Average")) {
						linha.split(",");
						System.out.println(linha);
					}
					
					linha = buffer.readLine();
				}

				buffer.close();
				leitor.close();
				dados.close();
				
			} catch (Exception e) {
				String err = e.getMessage();
				System.out.println(err);
			}
		} else {
			try {
				Process p = Runtime.getRuntime().exec(Unix);
				InputStream dados = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(dados);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}

				buffer.close();
				leitor.close();
				dados.close();

			} catch (Exception e) {
				String err = e.getMessage();
				System.out.println(err);
			}
		}
	}
}