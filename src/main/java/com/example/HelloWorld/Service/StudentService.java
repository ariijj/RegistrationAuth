package com.example.HelloWorld.Service;

import com.example.HelloWorld.Entity.Student;
import com.example.HelloWorld.Repo.StudentRepo;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
@Autowired
 private StudentRepo repo;



    public Iterable<Student> listAll() {
        return this.repo.findAll();
    }

    public void deleteStudent(String id) {
       repo.deleteById(id);
    }

    public Student getStudentByID(String studentid) {
       return repo.findById(studentid).get();
    }

    public void saveorUpdate(Student students) {
        repo.save(students);
    }

    @Autowired
    private StudentRepo studentRepository;

    public String addCandidat(MultipartFile upload1,MultipartFile upload2,MultipartFile upload3, String name,String studentaddress,String mobile,String studentbirth,String studentemail,String passwod,String compasswod) throws IOException {
        Student cn;
        cn = new Student();
        cn.setStudentname(name);
        cn.setStudentaddress(studentaddress);
        cn.setmobile(mobile);
        cn.setStudentbirth(studentbirth);
        cn.setStudentemail(studentemail);
        cn.setPassworld(passwod);
        cn.setCompassworld(compasswod);
        List<Object> list = new ArrayList<>();
        list.add(new Binary(BsonBinarySubType.BINARY, upload1.getBytes()));
        list.add(upload1.getContentType());
        cn.setCV(list);
        List<Object> list2 = new ArrayList<>();
        list2.add(new Binary(BsonBinarySubType.BINARY, upload2.getBytes()));
        list2.add(upload2.getContentType());
        cn.setCV(list);
        List<Object> list3 = new ArrayList<>();
        list3.add(new Binary(BsonBinarySubType.BINARY, upload3.getBytes()));
        list3.add(upload3.getContentType());
        cn.setCV(list);
        studentRepository.save(cn);
        return "Success";
    }
}
