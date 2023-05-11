package org.yuliandr.learnJava.model.entity;

import static org.yuliandr.learnJava.util.Validation.numberValidate;
import static org.yuliandr.learnJava.util.Validation.stringValidate;

public class Player {
    private static final int MIN_RANK = 100;
    private static final int MAX_RANK = 3000;
    private static final int MAX_AGE = 100;
    private static final int MIN_AGE = 6;
    private static final String[] CHARACTERS_EMAIL = {"@", "."};

    private String name;
    private String email;
    private boolean white;
    private int rank;
    private int age;

    public Player() {
    }

    public Player(String name, String email, boolean white, int rank, int age) {

        if (stringValidate(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("The name should be not empty");
        }

        if (stringValidate(email)) {
            for (String str : CHARACTERS_EMAIL) {
                if (!email.contains(str)) {
                    throw new IllegalArgumentException("Wrong email format");
                }
            }
            this.email = email;
        } else {
            throw new IllegalArgumentException("The email should be not empty");
        }
        this.white = white;

        if (numberValidate(MIN_RANK, MAX_RANK, rank)) {
            this.rank = rank;
        } else {
            throw new IllegalArgumentException(String.format("The rank must be between %d and %d", MIN_RANK, MAX_RANK));
        }

        if (numberValidate(MIN_AGE, MAX_AGE, age)) {
            this.age = age;
        } else {
            throw new IllegalArgumentException(String.format("The age must be between %d and %d", MIN_AGE, MAX_AGE));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (stringValidate(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("The name should be not empty");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (stringValidate(email)) {
            for (String str : CHARACTERS_EMAIL) {
                if (!email.contains(str)) {
                    throw new IllegalArgumentException("Wrong email format");
                }
            }
            this.email = email;
        } else {
            throw new IllegalArgumentException("The email should be not empty");
        }
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        if (numberValidate(MIN_RANK, MAX_RANK, rank)) {
            this.rank = rank;
        } else {
            throw new IllegalArgumentException(String.format("The rank must be between %d and %d", MIN_RANK, MAX_RANK));
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (numberValidate(MIN_AGE, MAX_AGE, age)) {
            this.age = age;
        } else {
            throw new IllegalArgumentException(String.format("The age must be between %d and %d", MIN_AGE, MAX_RANK));
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", white=" + white +
                ", rank=" + rank +
                ", age=" + age +
                '}';
    }
}
