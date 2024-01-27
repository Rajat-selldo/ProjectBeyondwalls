package pom.beyondwalls.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;

	public XLUtils(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
	}

	public int getCellCount(String sheetName, int rownum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
	}

	public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell); // Returns the formatted value of a cell as a String regardless of
													// the cell type.
		} catch (Exception e) {
			data = "";
		}
		workbook.close();
		fi.close();
		return data;
	}

	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
		File xlfile = new File(path);
		if (!xlfile.exists()) // If file not exists then create new file
		{
			workbook = new XSSFWorkbook();
			fo = new FileOutputStream(path);
			workbook.write(fo);
		}

		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);

		if (workbook.getSheetIndex(sheetName) == -1) // If sheet not exists then create new Sheet
			workbook.createSheet(sheetName);

		sheet = workbook.getSheet(sheetName);

		if (sheet.getRow(rownum) == null) // If row not exists then create new Row
			sheet.createRow(rownum);
		row = sheet.getRow(rownum);

		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}

	public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);

		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		style = workbook.createCellStyle();

		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}

	public void fillRedColor(String sheetName, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		style = workbook.createCellStyle();

		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}

	public static void main(String[] args) throws IOException {
		XLUtils sl = new XLUtils(System.getProperty("user.dir") + "/campainID2.xlsx");
		String ary[] = { "587ddb375a9db31da9000183", "587ddb3a5a9db31da9000185", "587ddb3b5a9db31da9000187",
				"587ddb3c5a9db31da9000189", "587de81926300a3aca00000d", "587e12a15a9db34bcc000003",
				"588596035a9db34f0c000004", "58abf0145a9db35f30000011", "58de60f05a9db347e6000003",
				"58f0c7cc5a9db3bee4000003", "58f727c35a9db3208500000c", "5909b4005a9db3129a00003a",
				"5909e3ef5a9db330ad0000ca", "590ad2b95a9db3d41b000009", "59198a1d5a9db3b32f000003",
				"591eb58b5a9db31ed4000012", "592facda5a9db32be6000002", "5931398d5a9db3e3bc00025d",
				"5941279f5a9db3043c000002", "594280625a9db35bc700000c", "5943dc315a9db33507000064",
				"594921c75a9db330ae0000e7", "594ba0675a9db3a9fe000051", "596de21a5a9db3dd130000f2",
				"596df4a55a9db3dd13000142", "596e07b65a9db3dd130001f3", "596eeb355a9db3dd13000235",
				"5982fedb5a9db34b9f000036", "5996b7ca5a9db3d9ed00001a", "59af98eb5a9db39436000015",
				"59c8d4c85a9db393090000a8", "59ddd21a5a9db31e2f877948", "59dddb535a9db31e2f877958",
				"5a3a5d3b8e7b6d2f989cd15f", "5a3bb5ab8e7b6d6ed9d5c6d1", "5a3ce1f88e7b6d1cd08580f8",
				"5a4335168e7b6d66a7e4950c", "5a545a1d8e7b6d4b9bd5a5ac", "5a6976c08e7b6d4b839ac139",
				"5ac760ef8e7b6d685883e63a", "5acc6a618e7b6d1fc2dca72e", "5acc6ac98e7b6d1fc2dca739",
				"5acdb5d08e7b6d5c9dbb51d9", "5acef9348e7b6d3d50f976df", "5ae370258e7b6d78563bfb34",
				"5ae47fc88e7b6d78563bfb45", "5aeaa7c78e7b6d1c22fb41df", "5aec419f8e7b6d3dddbca102",
				"5aec53df8e7b6d4d10d49d10", "5aec548d8e7b6d4d10d49d1c", "5aec6b948e7b6d606375bf9f",
				"5b22502e8e7b6d635c8a5598", "5b236fbf8e7b6d1fe4660afb", "5b2ba0968e7b6d41110ebe3a",
				"5b3343348e7b6d2df69fdc4b", "5b34b9418e7b6d48e5c47aa0", "5b34c6f08e7b6d48e5c47ac6",
				"5b39cb108e7b6d47ef0e3636", "5b3b72658e7b6d35ac041439", "5b4872b28e7b6d2334ddd36b",
				"5b4c89928e7b6d5bbbf74bdf", "5b4c8b2b8e7b6d5bbbf74c02", "5b4d92718e7b6d070ed75195",
				"5b6972c18e7b6d57432e12e8", "5b699b0a8e7b6d7ed3fad29a", "5b699e948e7b6d1946831fa9",
				"5b6d812b8e7b6d2162f2b622", "5b87d7938e7b6d5752b04c73", "5ba378898e7b6d38634127dc",
				"5ba4b73a8e7b6d32d0eedfe4", "5bae17988e7b6d60dcb30f5d", "5bb1fee18e7b6d40a89ef3dc",
				"5bb202208e7b6d40a89ef421", "5bb472f98e7b6d0faa57e930", "5bb5ff6c8e7b6d66d445a3c3",
				"5bbca87b8e7b6d5a0dfefc0e", "5bbcaa288e7b6d5a0dfefc3f", "5bbcabe98e7b6d5a0dfefcb8",
				"5bbcad418e7b6d5a0dfefcca", "5bbdb04a8e7b6d3fd0fcdc17", "5bbdb4778e7b6d3fd0fcdc30",
				"5bbdb5358e7b6d3fd0fcdc38", "5bbdbbd98e7b6d3fd0fcdc42", "5bbdbd158e7b6d3fd0fcdc46",
				"5bbde53c8e7b6d5c5dbf4a18", "5bbde7cb8e7b6d5c5dbf4a28", "5bbde94a8e7b6d5c5dbf4a32",
				"5bbde9ee8e7b6d5c5dbf4a38", "5bbdee7a8e7b6d5c5dbf4b84", "5bbee6ff8e7b6d1866048ead",
				"5bbee8078e7b6d1866048eb8", "5bbefa848e7b6d1866049085", "5bbf1a248e7b6d55a8669ed4",
				"5bbf237a8e7b6d49e17a2833", "5bbf2eb68e7b6d49e17a2869", "5bbf46338e7b6d7114bee192",
				"5bbf49f28e7b6d7114bee19f", "5bbf4b858e7b6d7114bee1a8", "5bbf4da38e7b6d7114bee1b5",
				"5bbf50968e7b6d7114bee1bf", "5bbf53398e7b6d7114bee1cc", "5bbf56da8e7b6d7114bee1db",
				"5bbf57ee8e7b6d7114bee1e5", "5bbf593f8e7b6d7114bee1ef", "5bbf59fd8e7b6d7114bee1f9",
				"5bc03c248e7b6d564ab901a6", "5bc06c678e7b6d15b66cfce0", "5bc06e568e7b6d15b66cfcea",
				"5bc070638e7b6d15b66cfcf4", "5bc0719c8e7b6d1fc364c0b0", "5bc074858e7b6d15b66cfd0f",
				"5bc5839f8e7b6d0b869c326e", "5bc586ab8e7b6d0b869c328e", "5bc587ca8e7b6d0b869c3292",
				"5bc5925a8e7b6d193a2f6711", "5c0909608e7b6d2c304980b9", "5d5a39b20c739279e383f10a",
				"5d68c92e0c73920e24fd5bff", "5d80c0120c73922f071a67d5", "5ed660230c739210943dac1e",
				"5f02c02b0c739267d3f1da6e", "6124dc110c739229d4f0e8a6", "617b8ebe0c739205d1eb8e90",
				"61f8e2770c739217acdca060", "62066be50c73923a38179233", "620faeeb0c7392615da263da",
				"625549200c73923236d0ee20", "625d323e0c73927b19a5da19", "626291100c739265e931620a",
				"626296420c739265e931623b", "6262a3720c739265e931624d", "62988f9eb08345593813d73b",
				"62988fcbb08345593813db28", "62988ff3b08345593813db2f", "6298ce14b0834546c77bd74a",
				"62d65619b0834544dcffe5ad", "62d8099ab08345c5f77e2df0", "62da55a5b08345642f97acbb",
				"63294928b08345e2145d5c9f", "6329930db083457a8504c58d", "63299676b083457a8504c598",
				"63341d34b08345c704e3cfdd", "63359bdcb083455892c14513", "6335a104b083455892c14688",
				"6335a546b083455892c146df", "6347f06cb083459dc7106558", "634f910fb083458d3b350870",
				"637381b9b08345d19e877998", "6374bdd6b08345f001d8470c", "637de4deb0834529a4866c2d",
				"6391b3a6b08345750f918c25", "63abe2c2b083455b76cb0cd4", "63c79829b08345850b00f174",
				"640193a4b0834525f0e98fe8", "6409f417b08345e85903fc98", "640a003db083450e7d9af67d",
				"640a13f5b083454bb1e9254f", "641adb2db0834542aa356b4f", "641b2258b0834507c0c97c5e",
				"642d4a1db083457249fe784b", "642d4aa8b083457249fe7851", "642d5879b08345957332fd9e",
				"6479eab3b083450345628a69" };
		for (int i = 0; i < ary.length; i++) {
			sl.setCellData("sheet1", i, 0, ary[i]);
		}

	}
}
