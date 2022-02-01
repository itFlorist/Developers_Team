package FilePrueba;

// Creating a text File using FileWriter
import java.io.FileWriter;
import java.io.IOException;

class MainFile {
	public static void main(String[] args) throws IOException {
		// Accept a string
		String str = "55::Pino::4.0::Tree::1.0::null::null";

		// attach a file to FileWriter
		FileWriter fw = new FileWriter("florist.txt");

		// read character wise from string and write
		// into FileWriter
		for (int i = 0; i < str.length(); i++)
			fw.write(str.charAt(i));

		System.out.println("Writing successful");
		// close the file
		fw.close();
	}

}
