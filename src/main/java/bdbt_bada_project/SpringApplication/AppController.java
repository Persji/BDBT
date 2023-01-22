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
    @Autowired
    private DomyDAO daoDomy;

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

    @RequestMapping(value = {"/new_house"})
    public String showNewHouse(Model model) {
        Domy domy = new Domy();
        model.addAttribute("domy", domy);
        return "admin/new_house";
    }

    @RequestMapping(value = {"/savePracownik"}, method = RequestMethod.POST)
    public String savePracownik(@ModelAttribute("pracownicy") Pracownicy pracownicy) {
        dao.save(pracownicy);
        return "redirect:/pracownicy_table";
    }

    @RequestMapping(value = {"/saveDom"}, method = RequestMethod.POST)
    public String saveDom(@ModelAttribute("domy") Domy domy) {
        daoDomy.save(domy);
        return "redirect:/domy_table";
    }



    @RequestMapping(value = {"/pracownicy_table"})
    public String showPracownicyTablePage(Model model) {
        List<Pracownicy> listPracownicy = dao.list();
        model.addAttribute("listPracownicy",listPracownicy);
        return "admin/pracownicy_table";
    }

    @RequestMapping(value = {"/domy_table"})
    public String showDomyTablePage(Model model) {
        List<Domy> listDomy = daoDomy.list();
        model.addAttribute("listDomy",listDomy);
        return "admin/domy_table";
    }

    @RequestMapping("/editPracownik/{id}")
    public ModelAndView showEditFormPracownik(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("admin/edit_formPracownik");
        Pracownicy pracownicy = dao.get(id);
        mav.addObject("pracownicy", pracownicy);
        return mav;
    }

    @RequestMapping("/editDom/{id}")
    public ModelAndView showEditFormDom(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("admin/edit_formDom");
        Domy domy = daoDomy.get(id);
        mav.addObject("domy", domy);
        return mav;
    }

    @RequestMapping(value = "/updatePracownik", method = RequestMethod.POST)
    public String updatePracownik(@ModelAttribute("pracownicy") Pracownicy pracownicy) {
        dao.update(pracownicy);
        return "redirect:/pracownicy_table";
    }

    @RequestMapping(value = "/updateDom", method = RequestMethod.POST)
    public String updateDom(@ModelAttribute("domy") Domy domy) {
        daoDomy.update(domy);
        return "redirect:/domy_table";
    }

    @RequestMapping("/deletePracnowik/{id}")
    public String deletePracownik(@PathVariable(name= "id") int id) {
        dao.delete(id);
        return "redirect:/pracownicy_table";
    }

    @RequestMapping("/deleteDom/{id}")
    public String deleteDom(@PathVariable(name= "id") int id) {
        daoDomy.delete(id);
        return "redirect:/domy_table";
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/new_worker").setViewName("admin/new_worker");
        registry.addViewController("/savePracownik").setViewName("admin/main_admin");
        registry.addViewController("/saveDom").setViewName("admin/main_admin");
        registry.addViewController("/updatePracownik").setViewName("admin/main_admin");
        registry.addViewController("/updateDom").setViewName("admin/main_admin");
        registry.addViewController("/deletePracownik/{id}").setViewName("admin/main_admin");
        registry.addViewController("/deleteDomy/{id}").setViewName("admin/main_admin");
        registry.addViewController("/editPracownik/{id}").setViewName("admin/edit_formPracownik");
        registry.addViewController("/editDom/{id}").setViewName("admin/edit_formDom");
        registry.addViewController("/pracownicy_table").setViewName("admin/pracownicy_table");
        registry.addViewController("/domy_table").setViewName("admin/domy_table");
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

