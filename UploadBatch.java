import java.util.Vector;
import Deployment_Diagram___Doc_Inc.PageRangeMapping;

public class UploadBatch {
	private String _batchId;
	private String _uploadTimeStamp;
	/**
	 * BatchStatus (enum)
	 */
	private String _status;
	private String _sourceFilename;
	public Tenant__Client_Organizations_ _unnamed_Tenant__Client_Organizations__;
	public Vector<PageRangeMapping> _unnamed_PageRangeMapping_ = new Vector<PageRangeMapping>();

	public void validateMetaData() {
		throw new UnsupportedOperationException();
	}

	public boolean enqueueProcessingJobs() {
		throw new UnsupportedOperationException();
	}
}