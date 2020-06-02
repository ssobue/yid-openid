package dev.sobue.auth.yid;

import java.util.Collections;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

  @GetMapping({"", "top"})
  public ModelAndView top() {
    return new ModelAndView("top");
  }

  @GetMapping({"view"})
  public ModelAndView view(@AuthenticationPrincipal OAuth2User principal) {
    return new ModelAndView("view", Collections.singletonMap("principal", principal));
  }
}
