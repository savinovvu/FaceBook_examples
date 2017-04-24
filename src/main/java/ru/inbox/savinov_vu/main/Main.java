package ru.inbox.savinov_vu.main;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.User;

import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {
   String accessToken = "EAATZC6PZA3CgoBAOG66cJdtzZADHgT7rF0OWZCGHgAUAXEUlb6MD2prTftvQk4wzOKO5ZAVJI3ZAs42PAxtaaKNfZCJw8t4mwUg3tV0xsgN8ZCHdKP4WrEnrugyqji7jkigYqnmOZCEIDYZApG66Tr9aY1IKelf0U6JZB4ZD";
        FacebookClient fbclient = new DefaultFacebookClient(accessToken, Version.LATEST);

        FacebookClient.AccessToken at = fbclient.obtainExtendedAccessToken("1407275939334666", ResourceBundle.getBundle("config").getString("secret"));
        User me = fbclient.fetchObject("me", User.class);
        System.out.println(me.getName());
        System.out.println(at.getAccessToken());
        System.out.println(at.getExpires());
    }
}
