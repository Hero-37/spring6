package com.atguigu.spring6.iocxml.di;

import java.util.Map;

public class Student {

    private String sid;

    private String sname;

    private Map<String, Teacher> teacherMap;

    public void run() {
        System.out.println("学生Id: " + sid + "; 学生姓名: " + sname);
        System.out.println(teacherMap);
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", teacherMap=" + teacherMap +
                '}';
    }
}
