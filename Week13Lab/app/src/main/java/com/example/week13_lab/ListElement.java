package com.example.week13_lab;

import java.util.HashMap;
import java.util.Map;

public class ListElement {
    private ElementType element_type; //0: header, 1: item

    private String title; //header_text for Header, full_name for Item
    private String email;
    private String picture_url;

    public enum ElementType{
        HEADER(0),
        ITEM(1);

        private int value;
        private static Map map = new HashMap<>();

        private ElementType(int value){
            this.value = value;
        }
        static {
            for(ElementType elementType : ElementType.values()){
                map.put(elementType.value, elementType);
            }
        }

        public static ElementType valueOf(int elementType){
            return (ElementType) map.get(elementType);
        }

        public int getValue(){
            return value;
        }
    }

    public ListElement(ElementType element_type, String fullname, String email, String picture_url) {
        this.element_type = element_type;
        this.title = fullname;
        this.email = email;
        this.picture_url = picture_url;
    }

    public ListElement(ElementType element_type, String title) {
        this.element_type = element_type;
        this.title = title;
    }

    public ElementType getElement_type() {
        return element_type;
    }

    public String getTitle() {
        return title;
    }

    public String getFullName() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getPicture_url() {
        return picture_url;
    }
}
