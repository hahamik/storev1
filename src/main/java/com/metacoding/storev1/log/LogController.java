package com.metacoding.storev1.log;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogController {

    @GetMapping("/log/list")
    public String logList() {
        return "log/list";
    }
}
