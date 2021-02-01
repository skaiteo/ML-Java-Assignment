package com.kai.mljavaassignment.json;

public class SetFeatureJson {
    private String featureName;
    private String email;
    private boolean enable;

    public SetFeatureJson(String featureName, String email, boolean enable) {
        this.featureName = featureName;
        this.email = email;
        this.enable = enable;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
