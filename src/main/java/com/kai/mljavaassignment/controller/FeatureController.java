package com.kai.mljavaassignment.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kai.mljavaassignment.json.CanAccessJson;
import com.kai.mljavaassignment.json.SetFeatureJson;
import com.kai.mljavaassignment.service.FeatureService;

@RestController
public class FeatureController {
	@Autowired
    private FeatureService featureService;

    @GetMapping("/feature")
    @ResponseBody
    private CanAccessJson getFeature(@RequestParam String email, @RequestParam String featureName) {
        boolean canAccess = featureService.checkAccess(email, featureName);
        return new CanAccessJson(canAccess);
    }

    @PostMapping("/feature")
    private void setFeature(@RequestBody SetFeatureJson json, HttpServletResponse response) {
        boolean success = featureService.setFeature(json);
        if (!success) response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
        return;
    }
}
