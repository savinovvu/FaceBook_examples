package ru.inbox.savinov_vu.main;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.Post;

import java.util.List;

public class Main {

    public static void main(String[] args) {
   String accessToken = "EAATZC6PZA3CgoBAOG66cJdtzZADHgT7rF0OWZCGHgAUAXEUlb6MD2prTftvQk4wzOKO5ZAVJI3ZAs42PAxtaaKNfZCJw8t4mwUg3tV0xsgN8ZCHdKP4WrEnrugyqji7jkigYqnmOZCEIDYZApG66Tr9aY1IKelf0U6JZB4ZD";
        FacebookClient fbclient = new DefaultFacebookClient(accessToken, Version.LATEST);

        Connection<Post> result = fbclient.fetchConnection("me/feed", Post.class);
        int counter = 0;


        for (List<Post> page : result) {
            for (Post post : page) {
                System.out.println(post.getMessage());
                System.out.println("fb.com/" + post.getId());
                counter++;
            }
        }
        System.out.println(counter);

    }
}
