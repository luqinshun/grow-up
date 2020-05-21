package com.lqs.study.growup.lambda.distinct;

import com.lqs.study.growup.lambda.ExcellentStudent;
import com.lqs.study.growup.lambda.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: grow-up
 * @description: lamdba表达式去重
 * @author:luqinshun
 * @create: 2020-05-20 10:31
 **/
public class LambdaDistinct {

    /**
     * 方式一： 通过重写类的equals和hashCode方法来实现去重
     *
     */

    public static void distinctProperty(){
        List<Student> studentList = new ArrayList<>(16);
        Student stu1 = new Student("张珊", "001");
        Student stu2 = new Student("李思", "002");
        Student stu3 = new Student("王武", "003");
        Student stu4 = new Student("张珊", "001");
        studentList.add(stu1);
        studentList.add(stu2);
        studentList.add(stu3);
        studentList.add(stu4);
        List<ExcellentStudent> excellentStudentList = studentList.stream()
                .distinct()
                .map(student -> {
                    ExcellentStudent excellentStudent = new ExcellentStudent();
                    excellentStudent.setName(student.getName());
                    excellentStudent.setStudentNo(student.getStudentNo());
                    return excellentStudent;
                })
                .collect(Collectors.toList());
        System.out.println(excellentStudentList);
    }

    public static void main(String[] args) {
        distinctProperty();
    }
}
