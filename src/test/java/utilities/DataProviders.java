package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "login")
	public String[][] logindata() throws IOException {

		String path = System.getProperty("user.dir") + "\\testdata\\OpenCartLogin.xlsx";
		ExcelUtility util = new ExcelUtility(path);
		int rows = util.getRowCount("Sheet1");
		int cells = util.getCellCount("Sheet1", 1);

		String[][] data = new String[rows][cells];
		// Reading excel data
		for (int r = 1; r <= rows; r++) {
			for (int c = 0; c < cells; c++) {
				data[r - 1][c] = util.getCellData("Sheet1", r, c);
			}
		}
		return data;

	}
}
