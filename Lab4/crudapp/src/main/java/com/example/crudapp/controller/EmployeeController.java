package com.example.crudapp.controller;

import com.example.crudapp.model.Employee;
import com.example.crudapp.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", service.getAll());
        return "index";
    }

    @GetMapping("/new")
    public String showNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "new_employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        service.save(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Employee emp = service.getById(id).orElse(null);
        model.addAttribute("employee", emp);
        return "edit_employee";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        service.save(employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
