

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Datadriven2 {
	@Test(dataProvider="TestAdd")
	public void Add(String a,String b,String c) {
		int x=Integer.parseInt(a);
		int y=Integer.parseInt(b);
		int z=Integer.parseInt(c);
		int res=x+y+z;
		System.out.println(res);
	}

	@DataProvider(name="TestAdd")
	public Object[][] Addition() throws BiffException, IOException {
		String path="C:\\Users\\sapna\\Desktop\\selenium\\Addition.xls";
		File f1=new File(path.trim());
		Workbook w=Workbook.getWorkbook(f1);
		Sheet s=w.getSheet("Sheet1");
		int rows=s.getRows();
		int column=s.getColumns();
		String Data[][]=new String[rows][column];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<column;j++) {
				Cell c=s.getCell(j, i);
			     Data[i][j]=c.getContents();
				System.out.println(Data[i][j]);
			}
		}
		return Data;
		}

}
