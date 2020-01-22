package br.com.rsinet.hub_tdd.excel;

import br.com.rsinet.hub_tdd.excel.ExcelUtilitarios;

public class MassaDeDados {

	public String usuario() throws Exception {
		ExcelUtilitarios.setExcelFile("C:\\Users\\angra.souza\\Desktop\\dadosCadastro.xlsx", "Cadastro");
		String username = ExcelUtilitarios.getCellData(1, 0);
		return username;
	}

	public String email() throws Exception {
		String email = ExcelUtilitarios.getCellData(1, 1);
		return email;
	}

	public String senha() throws Exception {
		String senha = ExcelUtilitarios.getCellData(1, 2);
		return senha;
	}

	public String confirmeSenha() throws Exception {
		String confirmeSenha = ExcelUtilitarios.getCellData(1, 3);
		return confirmeSenha;
	}

	public String primeiroNome() throws Exception {
		String primeiroNome = ExcelUtilitarios.getCellData(1, 4);
		return primeiroNome;
	}

	public String ultimoNome() throws Exception {
		String ultimoNome = ExcelUtilitarios.getCellData(1, 5);
		return ultimoNome;
	}

	public String telefone() throws Exception {
		String telefone = ExcelUtilitarios.getCellData(1, 6);
		return telefone;
	}

	public String pais() throws Exception {
		String pais = ExcelUtilitarios.getCellData(1, 7);
		return pais;
	}

	public String cidade() throws Exception {
		String cidade = ExcelUtilitarios.getCellData(2, 8);
		return cidade;
	}

	public String endereco() throws Exception {
		String endereco = ExcelUtilitarios.getCellData(1, 9);
		return endereco;
	}

	public String estado() throws Exception {
		String estado = ExcelUtilitarios.getCellData(1, 10);
		return estado;
	}

	public String cartaoPostal() throws Exception {
		String cartaoPostal = ExcelUtilitarios.getCellData(1, 11);
		return cartaoPostal;
	}

}
