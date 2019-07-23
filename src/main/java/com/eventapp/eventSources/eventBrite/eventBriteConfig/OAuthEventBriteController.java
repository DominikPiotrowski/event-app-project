package com.eventapp.eventSources.eventBrite.eventBriteConfig;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class OAuthEventBriteController {

    @Autowired
    private OAuth2RestTemplate eventBriteRestTemplate;

    @RequestMapping("/login")

    public String eventBriteLogin() {
        JsonNode node = eventBriteRestTemplate.getForObject(
                "https://www.eventbriteapi.com/v3/users/me/?token=SESXYS4X3FJ5LHZRWGKQ", JsonNode.class);

        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(node.get("name").asText(),
                        eventBriteRestTemplate.getAccessToken().getValue(),
                        Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));

        SecurityContextHolder.getContext().setAuthentication(auth);
        return "redirect:home.html"; //jaki redirect?
    }
}
