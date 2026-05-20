package com.william.kill_spa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class FrontendController {

  @GetMapping("/")
  String index() {
    return "index";
  }
}
