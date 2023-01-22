package bdbt_bada_project.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
@Controller
@ControllerAdvice
public class AppController implements WebMvcConfigurer {

    @Autowired
    private PracownicyDAO dao;

    @RequestMapping(value = {"/main_user"})
    public String showUserPage(Model model) {
        List<Pracownicy> listPracownicy = dao.list();
        model.addAttribute("listPracownicy", listPracownicy);
        return "user/main_user";
    }

    @RequestMapping(value = {"/new_worker"})
    public String showNewWorker(Model model) {
        Pracownicy pracownicy = new Pracownicy();
        model.addAttribute("pracownicy", pracownicy);
        return "admin/new_worker";
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public String save(@ModelAttribute("pracownicy") Pracownicy pracownicy) {
        dao.save(pracownicy);
        return "redirect:/main_admin";
    }

    @RequestMapping(value = {"/main_admin"})
    public String showAdminPage(Model model) {
            List<Pracownicy> listPracownicy = dao.list();
            model.addAttribute("listPracownicy",listPracownicy);
        return "admin/main_admin";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("admin/edit_form");
        Pracownicy pracownicy = dao.get(id);
        mav.addObject("pracownicy", pracownicy);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("pracownicy") Pracownicy pracownicy) {
        dao.update(pracownicy);
        return "redirect:/main_admin";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name= "id") int id) {
        dao.delete(id);
        return "redirect:/main_admin";
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/new_worker").setViewName("admin/new_worker");
        registry.addViewController("/save").setViewName("admin/main_admin");
        registry.addViewController("/update").setViewName("admin/main_admin");
        registry.addViewController("/delete/{id}").setViewName("admin/main_admin");
        registry.addViewController("/edit/{id}").setViewName("admin/edit_form");
    }

    @Controller
    public class DashboardController {
        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {

                return "redirect:/main_admin";
            } else if (request.isUserInRole("USER")) {

                return "redirect:/main_user";
            } else {
                return "redirect:/index";
            }
        }
    }


}

