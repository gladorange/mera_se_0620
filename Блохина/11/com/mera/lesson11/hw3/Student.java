package com.mera.lesson11.hw3;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private String studentName;
    private Set<Lection> visitedLectureList = new HashSet<>();

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public Set<Lection> getVisitedLectureList() {
        return visitedLectureList;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setVisitedLectureList(Set<Lection> visitedLectureList) {
        this.visitedLectureList = visitedLectureList;
    }

    public void addVisitedLecture(Lection lecture) {
        visitedLectureList.add(lecture);
    }

    public void getStudentLectureList(Set<Lection> lectureItems) {
        int maxNum = lectureItems.size();
        int min = 6;
        int numLectures = (min >= maxNum) ? Lesson11Utils.getRandom(maxNum) : Lesson11Utils.getRandom(min, maxNum + 1);

        while (visitedLectureList.size() != numLectures) {
            addVisitedLecture(getRandomLectureList(lectureItems));
        }
    }

    public Lection getRandomLectureList(Set<Lection> lectureItems) {
        Lection[] lectureArr = lectureItems.toArray(new Lection[lectureItems.size()]);
        return lectureArr[Lesson11Utils.getRandom(lectureArr.length)];
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", visitedLectureList=" + visitedLectureList +
                '}';
    }
}
