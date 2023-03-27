package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String showRollDicePage () {
            return "dice-roll/roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String returnResults (@PathVariable int n, Model model) {
        int roll = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        model.addAttribute("guess", n);
        model.addAttribute("roll", roll);
        return "dice-roll/dice-results";
    }
}
