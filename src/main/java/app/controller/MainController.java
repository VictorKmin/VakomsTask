package app.controller;


import app.entity.LongShortUrl;
import app.service.urlService.UrlService;
import app.service.urlService.UrlUtil;
import app.service.validators.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {


    @Autowired
    private UrlService urlService;
    @Autowired
    private UrlUtil util;
    @Autowired
    private UrlValidator urlValidator;


    @ModelAttribute("url")
    public LongShortUrl longShortUrl() {
        return new LongShortUrl();
    }


    @InitBinder("url")
    public void binder(WebDataBinder binder) {
        binder.addValidators(urlValidator);
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("urls", urlService.findAll());

        return "index";
    }

    @PostMapping("/")
    public String myUrl(
            @ModelAttribute("url") @Validated LongShortUrl longShortUrl,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "index";
        }
        String enteredUrl = longShortUrl.getEnteredUrl();
        String id = util.urlHasher(enteredUrl);
        longShortUrl.setId(id);
        longShortUrl.setPrettyUrl(util.prettyUrl(enteredUrl.split("/", 4)));
        urlService.save(longShortUrl);
        return "redirect:/";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void redirectToUrl(@PathVariable String id, HttpServletResponse resp) throws Exception {

    }
}
