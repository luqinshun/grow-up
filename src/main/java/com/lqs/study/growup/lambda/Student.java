package com.lqs.study.growup.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: grow-up
 * @description:
 * @author:luqinshun
 * @create: 2020-05-20 10:29
 **/

public class Student {
    private String name;

    private String studentNo;

    public Student(String name, String studentNo) {
        this.name = name;
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }
}
