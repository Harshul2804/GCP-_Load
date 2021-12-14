import com.google.cloud.bigquery.*;

// Sample to load CSV data from Cloud Storage into a new BigQuery table
public class GcsToBq {

    public static void loadCsvFromGcs(
            String datasetName, String tableName, String sourceUri, String type) {
        try {
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            //CsvOptions csvOptions = CsvOptions.newBuilder().setSkipLeadingRows(1).build();
            TableId tableId = TableId.of(datasetName, tableName);
            LoadJobConfiguration loadConfig =
//                    LoadJobConfiguration.newBuilder(tableId, sourceUri, csvOptions).setSchema(schema).build();
                    LoadJobConfiguration.newBuilder(tableId, sourceUri).setFormatOptions(FormatOptions.json()).setWriteDisposition(JobInfo.WriteDisposition.WRITE_TRUNCATE).setAutodetect(true).build();

            Job job = bigquery.create(JobInfo.of(loadConfig));
            job = job.waitFor();
            if (job.isDone()) {
                System.out.println("CSV from GCS successfully added during load append job");
            } else {
                System.out.println(
                        "BigQuery was unable to load into the table due to an error:"
                                + job.getStatus().getError());
            }
        } catch (BigQueryException | InterruptedException e) {
            System.out.println("Column not added during load append \n" + e.toString());
        }
    }
}