package manuscript.backstage.email;

import manuscript.backstage.PostBox;

public class EmailBox implements PostBox<Email> {

	public EmailBox(String serverAddress) {
		System.out.println("📫 connect to mail serve: " + serverAddress);
	}

	@Override
	public void put(Email mail) {
		// simulate send email
		System.out.println("📧 Send mail: " + mail.content());
	}

}