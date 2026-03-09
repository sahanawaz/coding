package Entity;

import java.text.MessageFormat;
import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String email;

    public Employee(Builder builder) {
        id = builder.id;
        name = builder.name;
        email = builder.email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static class Builder {
        private int id;
        private String name;
        private String email;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Employee build() {
            if (Objects.isNull(name) || Objects.isNull(email))
                throw new IllegalStateException("Name and Email is mandatory");

            return new Employee(this);
        }
    }

    @Override
    public String toString() {
        return String.format("""
                {
                    "name": "%s",
                    "email": "%s"
                }
                """, name, email);
    }
}
