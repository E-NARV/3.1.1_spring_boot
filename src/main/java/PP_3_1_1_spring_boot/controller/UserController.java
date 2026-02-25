package PP_3_1_1_spring_boot.controller;

import PP_3_1_1_spring_boot.models.User;
import PP_3_1_1_spring_boot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        // Получаем список всех людей из DAO и отображаем
        model.addAttribute("user", userService.getAll());
        return "index";
    }

    @GetMapping("/show")
    public String show(@RequestParam("id") Long id, Model model) {
        // Получаем одного человека по id из DAO и отображаем
        model.addAttribute("user", userService.getById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        // Создаём нового юзера
        return "new";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        userService.create(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "edit";

        userService.update(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}