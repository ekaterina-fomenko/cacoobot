package com.telegram.cacoobot.spring;

import com.telegram.cacoobot.commands.CommandsHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Controller;

/**
 * @author Ekaterina Fomenko
 * @brief This class using for mapping urls for getting needed authorization parameters from cacoo site.
 * @date 6 of December of 2016
 */

@Controller
public class SpringController {

    @RequestMapping("/redirect")
    public void redirectToCacoo(HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {
        String oauth_verifier = request.getParameter("oauth_verifier");
        String chatId = request.getParameter("chatId");
        StringBuilder messageToUser = new StringBuilder("Thank you! Now Cacoo bot is authorized");
        CommandsHandler.INSTANCE.sendMessageToUser(chatId, messageToUser);
        httpServletResponse.sendRedirect("https://telegram.me/cacoobot");
    }

}


