package mocking;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadFromCSVFile {
	
	public static void main(String []args) throws IOException, CsvException {
		
			CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir")+ "\\src\\test\\java\\test_data.csv" ));
		List<String[]> rows = reader.readAll();
		
		for(String[] row : rows) {
			
			System.out.println("userName : " + row[0]);
			System.out.println("password : " + row[1]);
		}
		
	}

}
