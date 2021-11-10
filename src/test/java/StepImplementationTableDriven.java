import com.thoughtworks.gauge.Step;

public class StepImplementationTableDriven {
    @Step("Username: <username> Password: <password>")
    public void implementation1(String username,String password) {
        System.out.println("username "+username+" password "+password );
    }
}
