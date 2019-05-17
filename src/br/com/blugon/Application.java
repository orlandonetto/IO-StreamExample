package br.com.blugon;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@SuppressWarnings("resource")
public class Application {

	public static void main(String[] args) {

		// Normal
		output();
		input();

		// With Buffer
		outputBuffer();
		inputBuffer();
	}

	/*
	 * ******************************* Help ***************************************
	 * -- Site com imagem das ramifica��es das classes InputStream e OutputStream --
	 * ******** https://www.tutorialspoint.com/java/images/file_io.jpg ********
	 * ************ -> Imagem tamb�m no dir�t�rio: dir/file_io.png ************
	 * 
	 * 
	 * Output = Escrita dos dados | Input = Leitura dos dados
	 * 
	 * Output.Write(Byte) -> Escrever no file os bytes. *************************
	 * 
	 * construtor (String, Boolean) -> Boolean = persistencia dos dados anteriores.
	 * FileOutputStream("diret�rio/nomeArquivo.extensao", true or false)
	 * 
	 * FileInputStream("diret�rio/arquivo.extensao"); *****************************
	 * leitor.read() -> Quando for -1 � por que foi conclu�do a remontagem dos bytes
	 * Cada vez que executa o m�todo leitor.read() pe lido um byte do arquivo. por
	 * isso deve ser colocado dentro do while uma vari�vel, e verificar atrav�s dela
	 * 
	 * BufferedOutputStream(FileOutputSteam); -> Forma de se salvar os dados em um
	 * buffer na mem�ria, de modo a otimizar o processo. *************************
	 * BufferedOutputStream.flush() � uma boa pratica para evitar erro se por acaso
	 * der problema no streaming dos bytes, descartando tudo o que estiver no buffer
	 * 
	 */

	// Sa�da (Gravar)
	public static void output() {

		byte[] dados = { 65, 67, 68, 69, 70 };

		try {
			FileOutputStream out = new FileOutputStream("dir/Dados.txt", true);
			out.write(dados);

			System.out.println("Dados gravados com sucesso!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// Entrada (Ler)
	public static void input() {

		try {
			FileInputStream input = new FileInputStream("dir/Dados.txt");

			int in;
			while ((in = input.read()) != -1) {

				byte b = (byte) in;

				System.out.println("b: " + String.valueOf((char) (b)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Dados Lidos com sucesso!");
		}

	}

	/*
	 * BUFFERED MODE
	 */

	public static void outputBuffer() {

		try {
			BufferedOutputStream outputBuffer = new BufferedOutputStream(new FileOutputStream("dir/DadosBuffered.txt"));

			byte[] b = { 80, 81, 82, 83, 84 };

			outputBuffer.write(b);
			outputBuffer.flush();

			System.out.println("Dados gravados com sucesso!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void inputBuffer() {

		try {
			BufferedInputStream inputBuffer = new BufferedInputStream(new FileInputStream("dir/DadosBuffered.txt"));

			int in;
			while ((in = inputBuffer.read()) != -1) {

				byte b = (byte) in;

				System.out.println("Buffered B: " + String.valueOf((char) b));

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Dados Lidos com sucesso!");
		}

	}

}
