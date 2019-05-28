package com.test.uia.matte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting(@RequestParam(value="First", required=false)  String First,
                           @RequestParam(value = "Second", required = false) String Second,
                           @RequestParam(value = "mathType", required = false) String mathType,
                           Model model) {
        if (First != null && Second != null && mathType != null) {
            switch (mathType) {
                case "plus" :
                    model.addAttribute("answer", Double.parseDouble(First) + Double.parseDouble(Second));
                    break;
                case "multiply" :
                    model.addAttribute("answer", Double.parseDouble(First) * Double.parseDouble(Second));
                    break;
                case "delete" :
                    model.addAttribute("answer", Double.parseDouble(First) / Double.parseDouble(Second));
                    break;
                default:
                    break;

            }
        }
        return "index";
    }


}