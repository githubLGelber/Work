
package java2project;
import java.util.*;

public class ImportResult {
    private int totalRows;
    public int getTotalRows()
    {
        return totalRows;
    }
    public void setTotalRows(int totalRows)
    {
        this.totalRows=totalRows;
    }
    private int importedRows;
    public int getImportedRows()
    {
        return importedRows;
    }
    public void setImportedRows(int importedRows)
    {
        this.importedRows=importedRows;
    }
    private int failedRows;
    public int getFailedRows()
    {
        return failedRows;
    }
    public void setFailedRows(int failedRows)
    {
        this.failedRows=failedRows;
    }
    private ArrayList<String> errorMessages=new ArrayList<>();
    public ArrayList<String> getErrorMessages()
    {
        return errorMessages;
    }
    public ImportResult()
    {
        this.totalRows=0;
        this.importedRows=0;
        this.failedRows=0;
        errorMessages.clear();
    }
}
