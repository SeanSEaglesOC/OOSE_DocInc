public class SupportUser extends EmployeeUser {
	private String _supportUserId;
	private String _name;
	private String _email;

	public void searchUser(Object aQuery) {
		throw new UnsupportedOperationException();
	}

	public void viewUserStatements(Object aUserId) {
		throw new UnsupportedOperationException();
	}

	public void updateUserEmail(Object aUserId, Object aNewEmail) {
		throw new UnsupportedOperationException();
	}
}