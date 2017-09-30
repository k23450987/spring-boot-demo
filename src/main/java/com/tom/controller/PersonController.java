package com.tom.controller;


import com.github.pagehelper.PageHelper;
import com.tom.model.Person;
import com.tom.service.PersonService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Resource
    private PersonService personService;

    /**
     * 分页查询
     *
     * @param pageNum 页码
     * @param pageSize 条数
     * @return 查询结果
     */
    @GetMapping("/getPeople/{pageNum}/{pageSize}")
    @ResponseBody
    public List<Person> getPeople(@PathVariable("pageNum") String pageNum,
            @PathVariable("pageSize") String pageSize) {
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        return personService.selectAll();
    }

    @GetMapping("/toInsert")
    public String toInsert() {
        return "pages/person/insert";
    }

    @PostMapping("/insert")
    @ResponseBody
    public Integer insert(Person person) {
        personService.insertSelective(person);
        return person.getId();
    }

    @GetMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") String id, Model model) {
        Person person = personService.selectByPrimaryKey(Integer.parseInt(id));
        model.addAttribute("person", person);
        return "pages/person/update";
    }

    @PostMapping("/update")
    @ResponseBody
    public Integer toUpdate(Person person) {
        personService.updateByPrimaryKeySelective(person);
        return person.getId();
    }

}
