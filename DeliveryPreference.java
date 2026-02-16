public class DeliveryPreference {
	private int _preferenceId;
	/**
	 * Paper or Mail
	 */
	private String _deliveryMethod;
	private String _effectiveDate;
	private String _changeRequestedDate;
	private String _changeTakesEffectDate;
	private boolean _paperFreeEnabled;
	public Account _unnamed_Account_;

	public void requestChange(Object aNewMethod) {
		throw new UnsupportedOperationException();
	}

	public boolean isEffectiveOn(Object aCheckDate) {
		throw new UnsupportedOperationException();
	}
}