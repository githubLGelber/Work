
package java2project;

public abstract class BaseImporter implements Runnable {
    public abstract void run();
    public String fileName;
    public BaseImporter(String fileName)
    {
        this.fileName=fileName;
    }
    private ImportResult result;
    public ImportResult getResult()
    { 
        return result;
    }
    public void setResult(ImportResult result)
    {
        this.result=result;
    }
}
