package com.example.HelloWorld.Entity;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collation = "candidat")
public class Student {
    @Id
    private String _id;
    private String username;
    private String email;
    private String studentbirth;
    private String studentaddress;
    private String mobile;
    private String password;
    private String compassword;
    private List<Object> CV;
    private List<Object> Lettre_motivation;
    private List<Object> Image;



 public Student(String studentname,String studentaddress,String mobile,String studentemail,String studentbirth,List<Object> CV,List<Object> lettre_motivation,List<Object> image){
     this.username=studentname;
     this.studentaddress=studentaddress;
     this.mobile=mobile;
     this.studentbirth=studentbirth;
     this.email=studentemail;
     this.CV=CV;
     this.Lettre_motivation=lettre_motivation;
     this.Image=image;

 }
 public Student(){}


    public String get_id(){return _id;}
    public void set_id(String _id){
     this._id=_id;
    }
    public String getStudentname() {
        return username;
    }
    public void setStudentname(String studentname){
     this.username=studentname;
    }
     public String getStudentaddress(){return studentaddress;}
     public void setStudentaddress(String studentaddress){
    this.studentaddress=studentaddress;
}
    public String getMobile(){return mobile;}
    public void setmobile(String mobile){
     this.mobile=mobile;
    }

    public void setStudentemail(String studentemail) {
        this.email = studentemail;
    }

   // public void setFile(LoadFile CV) {this.file = CV;}

    public void setStudentbirth(String studentbirth) {
        this.studentbirth = studentbirth;
    }

    public String getStudentemail() {
        return email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStudentbirth(String studentbirth) {
        return this.studentbirth;
    }

    public String getPassworld() {
        return password;
    }

    public void setPassworld(String password) {
        this.password = password;
    }

    public String getStudentbirth() {
        return studentbirth;
    }

    public String getCompassword() {return compassword;}
    public void setCompassworld(String compassword) {this.compassword = compassword;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCompassword(String compassword) {
        this.compassword = compassword;
    }

    public List<Object> getCV() {
        return CV;
    }

    public void setCV(List<Object> CV) {
        this.CV = CV;
    }

    public List<Object> getLettre_motivation() {
        return Lettre_motivation;
    }

    public void setLettre_motivation(List<Object> lettre_motivation) {
        Lettre_motivation = lettre_motivation;
    }

    public List<Object> getImage() {
        return Image;
    }

    public void setImage(List<Object> image) {
        Image = image;
    }

    @Override
    public String toString() {
        return "Student{" +
                "_id='" + _id + '\'' +
                ", studentname='" + username + '\'' +
                ", studentemail='" + email + '\'' +
                ", studentbirth='" + studentbirth + '\'' +
                ", studentaddress='" + studentaddress + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", compassword='" + compassword + '\'' +
                ", CV=" + CV +
                ", Lettre_motivation=" + Lettre_motivation +
                ", Image=" + Image +
                '}';
    }

    /**
     * get field
     *
     * @return file
     */


    /**
     * set field
     *
     * @param file
     */

    //public String toString() {return "Student{" + "_id='" + _id + '\'' + ", studentname='" + studentname + '\'' + ", studentaddress='" + studentaddress + '\'' + ", mobile='" + mobile + '\'' + '}';}



}
