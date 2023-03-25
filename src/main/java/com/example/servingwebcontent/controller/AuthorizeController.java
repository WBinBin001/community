package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.dto.AccessTokenDTO;
import com.example.servingwebcontent.dto.GithubUser;
import com.example.servingwebcontent.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback( @RequestParam(name = "code") String code,
                            @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("9bb3b639b3ed31956b98");
        accessTokenDTO.setClient_secret("26a5b73d3da1f0eda80b467afed193989f4390da");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        if (user != null) {
            String name = user.getName();
            System.out.println("name = " + name);
            // ...
        }else {
            System.out.println("user 是 null 值");
        }

        return "index";
    }

}
