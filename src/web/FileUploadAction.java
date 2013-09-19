package web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport implements
        ServletContextAware {
    private static final long serialVersionUID = -5016873153441103539L;

    private File doc;
    private String fileName;
    private String contentType;
    private File target;

    private ServletContext context;

    public void setDoc(File file) {
        this.doc = file;
    }

    public void setDocFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setDocContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getDocFileName() {
        return fileName;
    }

    public String getDocContentType() {
        return contentType;
    }

    public File getDoc() {
        return doc;
    }

    public void setServletContext(ServletContext context) {
        this.context = context;
    }

    public String execute() throws Exception {
        String targetDirectory = context.getRealPath("/upload");
        target = new File(targetDirectory, fileName);
        if (!target.getParentFile().exists())
            target.getParentFile().mkdirs();
        FileUtils.copyFile(doc, target);
        readExcel();

        return SUCCESS;
    }

    private boolean readExcel() {
        Workbook wb = null;
        try {
            try {
                wb = WorkbookFactory.create(target);
            } catch (InvalidFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        if(null == wb){
            return false;
        }
        for (int k = 0; k < wb.getNumberOfSheets(); k++) {
            Sheet sheet = wb.getSheetAt(k);
            int rows = sheet.getPhysicalNumberOfRows();
            System.out.println("Sheet " + k + " \"" + wb.getSheetName(k)
                    + "\" has " + rows + " row(s).");
            for (int r = 4; r < rows; r++) {
                Row row = sheet.getRow(r);
                if (row == null) {
                    continue;
                }

                int cells = row.getPhysicalNumberOfCells();
                if(r<20)
                System.out.println("\nROW " + row.getRowNum() + " has " + cells
                        + " cell(s).");
                for (int c = 0; c < cells; c++) {
                    Cell cell = row.getCell(c);
                    if(null == cell){
                        continue;
                    }
                    String value = null;

                    switch (cell.getCellType()) {

                    case Cell.CELL_TYPE_FORMULA:
                        value = "FORMULA value=" + cell.getCellFormula();
                        break;

                    case Cell.CELL_TYPE_NUMERIC:
                        value = "NUMERIC value=" + cell.getNumericCellValue();
                        break;

                    case Cell.CELL_TYPE_STRING:
                        value = "STRING value=" + cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        value = "BOOLEAN value=" + cell.getBooleanCellValue();
                        break;
                    case Cell.CELL_TYPE_BLANK:
                        value = "BLANK value=BLANK";
                    case Cell.CELL_TYPE_ERROR:
                        value = "ERROR value= ERROR";
                        break;
                    default:
                    }
                    if(r<20)
                    System.out.println("CELL col=" + cell.getColumnIndex()
                            + " VALUE=" + value);
                }
            }
        }
        return true;
    }
}
