package com.example.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.GovernmentScheme;
import com.example.demo.service.GovernmentSchemeService;

@Controller
public class GovernmentSchemeController {

    @Autowired
    private GovernmentSchemeService service;

    // OPEN ADD PAGE
    @GetMapping("/admin/addscheme")
    public String addSchemePage(Model model) {

        model.addAttribute("scheme",
                new GovernmentScheme());

        return "addscheme";
    }

    // SAVE SCHEME
    @PostMapping("/admin/savescheme")
    public String saveScheme(
            @ModelAttribute("scheme")
            GovernmentScheme scheme,

            @RequestParam("file")
            MultipartFile file) {

        try {

            String uploadDir =
                    "src/main/resources/static/scheme/";

            File dir = new File(uploadDir);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            String filename =
                    file.getOriginalFilename();

            BufferedOutputStream bout =
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    uploadDir + filename));

            bout.write(file.getBytes());

            bout.close();

            scheme.setImage(filename);

            service.saveScheme(scheme);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return "redirect:/admin/viewscheme";
    }

    // VIEW ALL SCHEMES
    @GetMapping("/admin/viewscheme")
    public String viewSchemes(Model model) {

        model.addAttribute("list",
                service.getAllSchemes());

        return "viewscheme";
    }
}