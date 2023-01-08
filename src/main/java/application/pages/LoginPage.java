package application.pages;

public class LoginPage extends BasePage {

	public LoginPage() {
		super();
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}
}
