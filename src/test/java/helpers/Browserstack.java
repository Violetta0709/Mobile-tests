package helpers;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {
    //curl -u "violettaiuzykhov_vNtwhn:ZoecLiVGWyJ4Dkxbs7pq" -X GET "https://api.browserstack.com/app-automate/sessions/9469a70fec5a2d569b609b3e2e36fd3e59d5c478.json"
    public static String getVideoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .log().all()
                .auth().basic("violettaiuzykhov_vNtwhn", "ZoecLiVGWyJ4Dkxbs7pq")
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
