package LabOne;

public  abstract class Person {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email =email;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            if (!email.contains("@")) {
                throw new IllegalArgumentException("Invalid email");
            }
            this.email = email.trim();
        } else {
            this.email = null;
        }
    }
    public abstract double calculateTuition();
}
