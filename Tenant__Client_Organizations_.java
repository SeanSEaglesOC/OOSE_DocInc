import java.util.Vector;

public class Tenant__Client_Organizations_ {
	private int _tenantID;
	private String _name;
	private String _domain;
	private boolean _isActive;
	public Vector<User> _unnamed_User_ = new Vector<User>();
	public Account _unnamed_Account_;
	public RetentionPolicy _unnamed_RetentionPolicy_;
	public Vector<UploadBatch> _unnamed_UploadBatch_ = new Vector<UploadBatch>();
	public Vector<AuditLogEntry> _unnamed_AuditLogEntry_ = new Vector<AuditLogEntry>();
	public Vector<EmployeeUser> _unnamed_EmployeeUser_ = new Vector<EmployeeUser>();

	public void addAdmin(Object aAdmin) {
		throw new UnsupportedOperationException();
	}

	public void deactivate() {
		throw new UnsupportedOperationException();
	}
}