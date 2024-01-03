package Services;

public class Log {

    private int transactionId;
    private String logDetails;

   
    public Log() {
    }

   
    public Log(int transactionId, String logDetails) {
        this.transactionId = transactionId;
        this.logDetails = logDetails;
    }

   
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

   
    public String getLogDetails() {
        return logDetails;
    }

 
    public void setLogDetails(String logDetails) {
        this.logDetails = logDetails;
    }
}
