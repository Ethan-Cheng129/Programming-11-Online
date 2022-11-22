public class Teacher {
    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    private String lastname;
    private String subject;

    Teacher() {// This is the builder that creates the teacher object
        firstname = "";
        lastname = "";
        subject = "";

    }

    Teacher(String firstname, String lastname, String subject) {// This sets the name and subject the teacher is teaching.
        this.firstname = firstname;
        this.lastname = lastname;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Name: " + firstname + "  " + lastname + " " + "Subject: " + subject;
    }// this is the format of the teacher array.
}
