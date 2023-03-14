import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class GetCellTextColor {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("path/to/excel/file.xlsx");
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);

        // Get the font of the cell
        Font font = workbook.getFontAt(cell.getCellStyle().getFontIndex());

        // Get the color code of the font
        short colorIndex = font.getColor();
        XSSFColor color = (XSSFColor)IndexedColors.fromInt(colorIndex).getColor();
        String colorCode = color.getARGBHex();

        System.out.println("Text color code of the cell is: " + colorCode);
    }
}
