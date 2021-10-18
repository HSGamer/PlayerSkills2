package com.leonardobishop.playerskills2.utils;

/**
 * Used to generate default configurations and for the in game editor.
 */
public class CreatorConfigValue {

    private final String key;
    private final Object def;
    private final String description;
    private final boolean required;
    private Object value;

    public CreatorConfigValue(String key, Object value, Object def, String description, boolean required) {
        this.key = key;
        this.value = value;
        this.def = def;
        this.description = description;
        this.required = required;
    }

    public CreatorConfigValue(String key, Object value, String description, boolean required) {
        this.key = key;
        this.value = value;
        this.def = value;
        this.description = description;
        this.required = required;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getDefault() {
        return def;
    }

    public String getDescription() {
        return description;
    }

    public boolean getRequired() {
        return required;
    }
}
