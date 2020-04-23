package com.tutulei.qasys.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "class", schema = "QAsys", catalog = "")
public class ClassEntity {
    private int classId;
    private String className;
    private String classSchool;
    private String classTable;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "class_name")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Basic
    @Column(name = "class_school")
    public String getClassSchool() {
        return classSchool;
    }

    public void setClassSchool(String classSchool) {
        this.classSchool = classSchool;
    }

    @Basic
    @Column(name = "class_table")
    public String getClassTable() {
        return classTable;
    }

    public void setClassTable(String classTable) {
        this.classTable = classTable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassEntity that = (ClassEntity) o;
        return classId == that.classId &&
                Objects.equals(className, that.className) &&
                Objects.equals(classSchool, that.classSchool) &&
                Objects.equals(classTable, that.classTable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, className, classSchool, classTable);
    }
}
