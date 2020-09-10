import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class minifyCSS {

	private String allContent;
	private Scanner sc;

	public String getInputFile() {

		String cssInPath = "";

		do {
			System.out.println("Enter path to input file:");
			cssInPath = this.sc.nextLine();
		} while (cssInPath == "");

		return cssInPath;
	}

	public String getOutputFile() {
		String cssOutPath = "";

		do {
			System.out.println("Enter path to output file:");
			cssOutPath = this.sc.nextLine();
		} while (cssOutPath == "");

		return cssOutPath;
	}

	public void cssIn() {
		BufferedReader inFile = null;

		try {
			String path = this.getInputFile();

			inFile = new BufferedReader(new FileReader(path));
			String currLine = inFile.readLine();
			String tempContent = "";

			this.allContent += "/* CSS minified by minifyCSS - github.com/JackLangdon */\n";

			while (currLine != null) {
				tempContent += currLine;
				currLine = inFile.readLine();
			}

			tempContent = tempContent.replaceAll(" ", "");

			this.allContent += tempContent;

			inFile.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}

	public void cssOut() {
		BufferedWriter outFile = null;
		try {
			String path = this.getOutputFile();

			outFile = new BufferedWriter(new FileWriter(path));

			outFile.write(this.allContent);

			outFile.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}

	public minifyCSS() {
		// Initializing "allContent" prevents "null" as first entry
		this.allContent = "";
		this.sc = new Scanner(System.in);
		cssIn();
		cssOut();
		this.sc.close();
	}

	public static void main(String[] args) {
		minifyCSS minifyCSS = new minifyCSS();
	}

}
