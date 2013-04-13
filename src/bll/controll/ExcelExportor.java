package bll.controll;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import vl.util.NWEDialog;

public class ExcelExportor {

	private static ExcelExportor exportor;

	private static HSSFWorkbook wb;
	private static HSSFSheet hs;
	private static HSSFCellStyle datastyle;
	private static HSSFCellStyle titlestyle;

	private ExcelExportor() {

		wb = new HSSFWorkbook();
		hs = wb.createSheet();

		datastyle = wb.createCellStyle();
		HSSFFont datafont = wb.createFont();

		datafont.setFontHeightInPoints((short) 11);

		datastyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		datastyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		datastyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		datastyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		datastyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
		datastyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		datastyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		datastyle.setFont(datafont);

		titlestyle = wb.createCellStyle();
		HSSFFont titlefont = wb.createFont();

		titlefont.setFontHeightInPoints((short) 11);

		titlestyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		titlestyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		titlestyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		titlestyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		titlestyle.setFillForegroundColor(HSSFColor.RED.index);
		titlestyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		titlestyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		titlestyle.setFont(titlefont);

	}

	public static ExcelExportor getInstance() {

		exportor = new ExcelExportor();

		return exportor;

	}

	public boolean export(JTable table, File file) {

		try {

			FileOutputStream fos = new FileOutputStream(file);

			TableModel tm = table.getModel();
			int row = tm.getRowCount();
			int cloumn = tm.getColumnCount();

			for (int i = 0; i < row + 1; i++) {

				HSSFRow hr = hs.createRow(i);

				for (int j = 0; j < cloumn; j++) {

					if (i == 0) {

						String value = tm.getColumnName(j);
						int len = value.length();

						hs.setColumnWidth(j, (len * 800));

						HSSFRichTextString srts = new HSSFRichTextString(value);
						HSSFCell hc = hr.createCell(j);

						hc.setCellStyle(titlestyle);
						hc.setCellValue(srts);

					} else {

						String value;
						Object o = tm.getValueAt(i - 1, j);
						
						if (o != null) {
							value = o.toString();
						} else {
							value = "";
						}

						HSSFRichTextString srts = new HSSFRichTextString(value);

						HSSFCell hc = hr.createCell(j);

						hc.setCellStyle(datastyle);

						if (value.equals("") || value == null) {

							hc.setCellValue(new HSSFRichTextString(""));

						} else {

							hc.setCellValue(srts);

						}
					}
				}
			}

			wb.write(fos);
			fos.close();
			
			return true;

		} catch (IOException e) {

			NWEDialog.exportFailed();
			
			return false;

		}
	}
}
