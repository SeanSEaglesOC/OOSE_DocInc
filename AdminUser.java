public class AdminUser extends EmployeeUser {
	private int _adminUserId;
	private String _name;
	private String _email;
	private String _role;

	public void createUser(Object aUserData) {
		throw new UnsupportedOperationException();
	}

	public void updateUser(Object aUserId, Object aChanges) {
		throw new UnsupportedOperationException();
	}

	public void deleteUser(Object aUserId) {
		throw new UnsupportedOperationException();
	}

	public void setRetentionPolicy(Object aDays) {
		throw new UnsupportedOperationException();
	}

	public void viewTenantLogs(Object aDateRange) {
		throw new UnsupportedOperationException();
	}
}