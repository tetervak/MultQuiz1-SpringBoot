package ca.tetervak.multquiz1.controller;

import ca.tetervak.multquiz1.domain.Problem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuizController {

    @RequestMapping(value={"/", "/InputAnswer"})
    public String inputAnswer(Model model){
        model.addAttribute("problem",new Problem());
        return "InputAnswer";
    }

    @RequestMapping("/CheckAnswer")
    public ModelAndView checkAnswer(
            @RequestParam(name="A") String strA,
            @RequestParam(name="B") String strB,
            @RequestParam String userAnswer){

        ModelAndView mv;
        try {
            int a = Integer.parseInt(strA);
            int b = Integer.parseInt(strB);
            Problem problem = new Problem(a, b);
            if (problem.getAnswer() == Double.parseDouble(userAnswer)) {
                mv = new ModelAndView("RightAnswer");
            } else {
                mv = new ModelAndView("WrongAnswer");
            }
            mv.addObject("problem", problem);
        } catch (NumberFormatException e) {
            mv = new ModelAndView("BadInput");
            mv.addObject("A", strA);
            mv.addObject("B", strB);
        }
        mv.addObject("userAnswer", userAnswer);
        return mv;
    }
}
