package com.example.javarestfulwebserviceswithspringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoRestController {

    @RequestMapping(value = "demo0", method = RequestMethod.GET)
    public String demo0() {
        return "Hi there!";
    }

    @RequestMapping(value = "demo1", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> demo1() {
        try {
            return new ResponseEntity<String>("Demo 1", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "demo2", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_HTML_VALUE})
    public ResponseEntity<String> demo2() {
        try {
            return new ResponseEntity<String>("<b>Demo 2</b>", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "demo3/{fullName}", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> demo3(@PathVariable("fullName") String fullName) {
        try {
            return new ResponseEntity<String>("Hi " + fullName, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

}
