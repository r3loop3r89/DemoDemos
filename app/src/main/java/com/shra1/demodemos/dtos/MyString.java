package com.shra1.demodemos.dtos;

public class MyString {
    String name;
    boolean selected;

    public MyString(String name, boolean selected) {

        this.name = name;
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public boolean equals(Object obj) {
        MyString selectedObj = (MyString) obj;
        if (selectedObj.name.equals(this.name)
                &&
                selectedObj.selected == this.selected) {
            return true;
        } else {
            return false;
        }
    }
}
