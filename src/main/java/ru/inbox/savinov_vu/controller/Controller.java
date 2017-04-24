package ru.inbox.savinov_vu.controller;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.User;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {



    @FXML
    private Button button;

    @FXML
    private Label message;


    public void authUser() {

        String appId = "1407275939334666";
        String domain = "http://google.com";

        String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id=" + appId + "&redirect_uri=" + domain + "&scope=user_about_me,"
                + "user_actions.books,user_actions.fitness,user_actions.music,user_actions.news,user_actions.video,user_birthday,user_education_history,"
                + "user_events,user_photos,user_friends,user_games_activity,user_hometown,user_likes,user_location,user_photos,user_relationship_details,"
                + "user_relationships,user_religion_politics,user_status,user_tagged_places,user_videos,user_website,user_work_history,ads_management,ads_read,email,"
                + "manage_pages,publish_actions,read_insights,read_page_mailboxes,rsvp_event,manage_pages";
/*,read_friendlists,user_activities,user_groups,user_interests,manage_notifications,read_mailbox,read_stream,*/
        ChromeDriverManager.getInstance().setup();

        WebDriver driver = new ChromeDriver();
        driver.get(authUrl);
        String accessToken;
        while (true) {

            if (!driver.getCurrentUrl().contains("facebook.com")) {
                String url = driver.getCurrentUrl();
                System.out.println("url = " + url );
                accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");
                System.out.println("token = " + accessToken);
                driver.quit();

                FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.LATEST);
                User user = fbClient.fetchObject("me", User.class);

                message.setText(user.getName());
                break;
            }
       }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
