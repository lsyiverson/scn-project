package web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.struts2.util.ServletContextAware;

import utils.Utils;
import bean.ProjectInfo;

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
/**
 * 读取excel文件
 * @return
 */
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
        if (null == wb) {
            return false;
        }
        for (int k = 0; k < wb.getNumberOfSheets(); k++) {
            Sheet sheet = wb.getSheetAt(k);
            int rows = sheet.getPhysicalNumberOfRows();
            Utils.Log("Sheet " + k + " \"" + wb.getSheetName(k) + "\" has "
                    + rows + " row(s).");
            for (int r = 4; r < rows; r++) {
                Row row = sheet.getRow(r);
                if (row == null) {
                    continue;
                }

                int cells = row.getPhysicalNumberOfCells();
                if (r < 20)
                    Utils.Log("\nROW " + row.getRowNum() + " has " + cells
                            + " cell(s).");
                for (int c = 0; c < cells; c++) {
                    Cell cell = row.getCell(c);
                    if (null == cell) {
                        continue;
                    }
                    String value = null;

                    switch (cell.getCellType()) {

                    case Cell.CELL_TYPE_FORMULA:
                        value = cell.getCellFormula();
                        break;

                    case Cell.CELL_TYPE_NUMERIC:
                        value = String.valueOf(cell.getNumericCellValue());
                        break;

                    case Cell.CELL_TYPE_STRING:
                        value = cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        value = String.valueOf(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_BLANK:
                        value = "";
                    case Cell.CELL_TYPE_ERROR:
                        Utils.Log("CELL col=" + cell.getColumnIndex()
                                + " VALUE = ERROR");
                        break;
                    default:
                    }
                    if (r < 20)
                        Utils.Log("CELL col=" + cell.getColumnIndex()
                                + " VALUE=" + value);
                    if(!StringUtils.isEmpty(value)){
                        creatProjectInfo(value, c);
                    }
                }
            }
        }
        return true;
    }
    /**
     * 创建excel数据对象
     * @param value 数据值
     * @param columnNum 列号
     * @return
     */
    private ProjectInfo creatProjectInfo(String value, int columnNum){
        return null;
    }
    
    /*
     * 以下为excel列编号
     */
    private static final int NUMBER = 0;
    private static final int ITEM_SOURCE_GROUP = 1;
    private static final int ITEM_DATE = 2;
    private static final int ITEM_NAME = 3;
    private static final int PRO_NUMBER = 4;
    private static final int PRO_NAME = 5;
    private static final int PRO_PROPERTY_GROUP = 6;
    private static final int PRO_TYPE_GROUP = 7;
    private static final int PRO_ADDRESS = 8;
    private static final int A_MATERIAL_CST = 9;
    private static final int A_MATERIAL_BILL = 10;
    private static final int B_MATERIAL_CST = 11;
    private static final int B_MATERIAL_BILL = 12;
    private static final int LABOR_COST = 13;
    private static final int LABOR_CST_BILL = 14;
    private static final int COORDINATION_FEE = 15;
    private static final int TOTAL_FEE = 16;
    private static final int MATERIAL_QUA = 17;
    private static final int CONS_METHOD_GROUP = 18;
    private static final int PRO_OA_DATE = 19;
    private static final int PRO_PAPER_DATE = 20;
    private static final int DISPATCH_DATE = 21;
    private static final int AUDIT_RECORD_DATE = 22;
    private static final int CONTRACT_NUMBER = 23;
    private static final int CONTRACT_ACCOUNT = 24;
    private static final int FIRST_PAYMENT_AMOUNT = 25;
    private static final int SECOND_PAYMENT_AMOUNT = 26;
    private static final int APPROACH_TIME = 27;
    private static final int APPROACH_EXPECT_MATERIAL = 28;
    private static final int PRO_LEADER = 29;
    private static final int CONSTRUCTION_UNIT = 30;
    private static final int MONTH_PROGRESS = 31;
    private static final int LAST_MONTH_PROGRESS = 32;
    private static final int HOUSE_HOLDS = 33;
    private static final int ROUTE_LENGTH = 34;
    private static final int REFORM_WAY = 35;
    private static final int CONS_STAGE_GROUP = 36;
    private static final int CONCEALED_WORK = 37;
    private static final int HOOKING_ORTUBE = 38;
    private static final int ORDER_CHANGE_NO = 39;
    private static final int ORDER_CHANGE_ACCOUNT = 40;
    private static final int CONSTRUCTION = 41;
    private static final int COMPLETED_DATE = 42;
    private static final int SUBMIT_COMPLETION_DATA = 43;
    private static final int ACCEPTANCE = 44;
    private static final int ACTUAL_INSTALL = 45;
    private static final int ASSETS_TRANSFER = 46;
    private static final int ASSETS_GIS = 47;
    private static final int COMPLETION_DOC_NO = 48;
    private static final int DATA_TRANSFER = 49;
    private static final int IMPORTANT_DATA_SUBMIT = 50;
    private static final int SETTLEMENT_AMOUNT = 51;
    private static final int IMPORTANT_PRO_AMOUNT = 52;
    private static final int SETTLEMENT_PAYABLE = 53;
    private static final int SETTLEMENT_PAY_MERCHANTS = 54;
    private static final int OWED_AMOUNT = 55;
    private static final int THIRD_PAYMENT_AMOUNT = 56;
    private static final int RETENTION_AMOUNT = 57;
    private static final int RETENTION_EXPIRES = 58;
    private static final int NEXT_MONTH_PAY_AMOUNT = 59;
    private static final int OPTICAL_NODE = 60;
    private static final int CABLE = 61;
    private static final int CHARGE_CONSTRUCTION = 62;
}
