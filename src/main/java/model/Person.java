package model;

public class Person {
    private String name;
    private Position position;
    private final int teacherLevel = 2;
    private final int seniorStudentLevel = 5;
    private final int juniorStudentLevel = 7;
    private int level;

    public Person(String name, Position position) {
        this.name = name;
        this.position = position;
        assignLevel();
    }

    //assigns different levels to different persons based on their positions
    public void assignLevel() {
            if (this.position.name().equalsIgnoreCase("TEACHER")) {
                this.level = teacherLevel;
            } else if (this.position.name().equalsIgnoreCase("junior_student")) {
                this.level = juniorStudentLevel;
            } else if (this.position.name().equalsIgnoreCase("senior_student")) {
                this.level = seniorStudentLevel;
            }else {
                this.level = -1;
            }

    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Position getPosition() {
        return position;
    }
}
