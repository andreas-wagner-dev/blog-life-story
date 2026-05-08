package manuscript.backstage.payment;

import manuscript.Media;

public class Transaction extends Media.Default {
	private String fromAccount;
	private String toAccount;

	public Transaction(String fromAccount, String toAccount) {
		validate(fromAccount);
		validate(toAccount);
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
	}

	private void validate(String accountId) {
		if (accountId == null || accountId.trim().isEmpty()) {
			throw new IllegalArgumentException("Account-Id must not be null or empty!");
		}
	}

	public String from() {
		return fromAccount;
	}

	public String to() {
		return toAccount;
	}
}