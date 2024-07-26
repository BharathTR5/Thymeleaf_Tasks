package thymeleaf.tasks.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @GetMapping("/")
    public String loadMain() {
        return "index";
    }

    @GetMapping("/otp")
    public String generateOtp(ModelMap map) {
        int otp = new Random().nextInt(1000, 10000);
        map.put("otp", otp);
        return "index";
    }

    @GetMapping("/toss")
    public String getToss(ModelMap map) {
        String[] toss = { "head", "tails" };
        map.put("toss", toss[new Random().nextInt(0, 2)]);
        return "index";
    }

    @GetMapping("/random-color")
    public String generateColor(ModelMap map) {
        List<String> colors = Arrays.asList("red", "green", "yellow", "blue", "purple", "pink", "orange", "goldenrod",
                "violet");
        String color = colors.get(new Random().nextInt(0, colors.size()));
        map.put("color", color);
        return "index";
    }

    @GetMapping("/wish")
    public String printMessage(@RequestParam String message, @RequestParam String color, ModelMap map) {
        map.put("color1", color);
        map.put("message", message);
        return "index";
    }

    @GetMapping("/calci")
    public String calculator(@RequestParam double num1,@RequestParam double num2,@RequestParam String operation,ModelMap map){
        map.put("num1", num1);
        map.put("num2", num2);
        
        switch (operation) {
            case "add":
                map.put("ans", num1+num2);
                break;
            case "sub":
                map.put("ans", num1-num2);
                break;
            case "mul":
                map.put("ans", num1*num2);
                break;
            case "div":
                map.put("ans", num1/num2);
                break;
            default:
                break;
        }

        return "index";
    }

}