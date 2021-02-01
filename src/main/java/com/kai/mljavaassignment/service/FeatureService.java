package com.kai.mljavaassignment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kai.mljavaassignment.json.SetFeatureJson;
import com.kai.mljavaassignment.model.Feature;
import com.kai.mljavaassignment.model.User;
import com.kai.mljavaassignment.repository.FeatureRepository;
import com.kai.mljavaassignment.repository.UserRepository;

@Service
public class FeatureService {
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private FeatureRepository featureRepository;

    public boolean checkAccess(String email, String feature) {
        Optional<User> userOpt = userRepository.findUserByEmail(email);
        if (userOpt.isEmpty()) {
            return false;
        }

        User user = userOpt.get();
        return user.hasFeatureAccess(feature);
    }

    public boolean setFeature(SetFeatureJson json) {
        String email = json.getEmail();
        String featureName = json.getFeatureName();
        boolean enable = json.getEnable();

        Optional<User> userOpt = userRepository.findUserByEmail(email);
        if (userOpt.isEmpty()) {
            return false;
        }

        Optional<Feature> featureOpt = featureRepository.findFeatureByName(featureName);
        if (featureOpt.isEmpty()) {
            return false;
        }

        User user = userOpt.get();
        Feature feature = featureOpt.get();

        // Return false if already enabled or already disabled
        if (enable == user.hasFeatureAccess(featureName)) return false;

        System.out.println(String.format(
            "%s %s feature for %s",
            (enable ? "Enabling" : "Disabling"),
            featureName,
            email
        ));
        if (enable) {
            user.getFeatures().add(feature);
        } else {
            user.getFeatures().remove(feature);
        }
        userRepository.save(user);
        return true;
    }
}
