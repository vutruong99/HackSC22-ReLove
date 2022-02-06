package com.example.relove;

public class Owner {
    String business_name,owner_name,type,address,phone,email,zip, image;
    int business_id, num_orders;
    double rating;

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }

    public void setNum_orders(int num_orders) {
        this.num_orders = num_orders;
    }

    public int getBusiness_id() {
        return business_id;
    }

    public int getNum_orders() {
        return num_orders;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    //    public Owner(String business_id, String business_name, String owner_name, String type, String address, String phone, String email, String zip, String rating, String num_orders, String image) {
//        this.business_id = business_id;
//        this.business_name = business_name;
//        this.owner_name = owner_name;
//        this.type = type;
//        this.address = address;
//        this.phone = phone;
//        this.email = email;
//        this.zip = zip;
//        this.rating = rating;
//        this.num_orders = num_orders;
//        this.image = image;
//    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
