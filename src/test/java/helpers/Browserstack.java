package helpers;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {
    //curl -u "username:password" -X GET "https://api.browserstack.com/app-automate/sessions/9469a70fec5a2d569b609b3e2e36fd3e59d5c478.json"

    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

    public static String getVideoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .log().all()
                .auth().basic(config.user(), config.key())
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
