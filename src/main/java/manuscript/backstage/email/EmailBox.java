package manuscript.backstage.email;

import manuscript.backstage.PostBox;

/**
 * Connects the EmailBox on server.
 */
public class EmailBox implements PostBox<Email> {

	public EmailBox(String serverAddress) {
		System.out.println("📫 Connect to mail server: " + serverAddress);
	}

	@Override
	public void put(Email mail) {
		// simulate send email
		System.out.println("📧 Send mail: " + mail.toString());
	}

}