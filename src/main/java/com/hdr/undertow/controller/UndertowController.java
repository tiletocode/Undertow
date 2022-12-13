package com.hdr.undertow.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hdr.undertow.entity.Undertow;
import com.hdr.undertow.repository.UndertowRepository;

import org.springframework.data.domain.Sort;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UndertowController {

    private final UndertowRepository repository;

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @PostMapping("/add")
    public String click() {
        Long id = repository.findTop1ByOrderByIdDesc().getId();
        LocalDateTime time = repository.findTop1ByOrderByIdDesc().getTime();
        int count = repository.findTop1ByOrderByIdDesc().getCount();

        Undertow c = Undertow.builder()
                .id(id)
                .time(time)
                .count(count + 1).build();

        repository.save(c);
        return "redirect:/";
    }

    @GetMapping("/list")
    public ModelAndView list(ModelAndView mav) {
        Iterable<Undertow> metricList = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        mav.addObject("metricList", metricList);
        mav.setViewName("list");
        return mav;
    }

    @GetMapping("/exception")
    public String ex() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("nofile.txt"));
        return "index";
    }
}
