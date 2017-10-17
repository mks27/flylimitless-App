package com.flylimitless.flylimitless;



public class profiledata {

    private String name;
    private String email;
    private String phone;
    private String aadhar;

    public profiledata()
    {

    }

    public profiledata(String name, String email, String phone, String aadhar)
    {
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.aadhar=aadhar;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone= phone;
    }

    public String getaadhar() {
        return aadhar;
    }

    public void setaadhar(String aadhar) {
        this.aadhar = aadhar;
    }

}
