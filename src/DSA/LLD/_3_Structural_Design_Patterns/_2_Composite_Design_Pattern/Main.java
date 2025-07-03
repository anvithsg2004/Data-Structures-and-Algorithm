package DSA.LLD._3_Structural_Design_Patterns._2_Composite_Design_Pattern;

import java.util.ArrayList;
import java.util.List;

// Common interface
interface Invite {
    void sendInvitation();
}

// Leaf - single person
class Person implements Invite {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void sendInvitation() {
        System.out.println("Invitation sent to " + name);
    }
}

// Composite - group of people (family)
class Family implements Invite {
    private String familyName;
    private List<Invite> members = new ArrayList<>();

    public Family(String familyName) {
        this.familyName = familyName;
    }

    public void addMember(Invite invite) {
        members.add(invite);
    }

    public void sendInvitation() {
        System.out.println("Sending invitation to family: " + familyName);
        for (Invite member : members) {
            member.sendInvitation();
        }
    }
}

// Using it
public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Alice");
        Person p2 = new Person("Bob");

        Family family = new Family("Smith");
        family.addMember(p1);
        family.addMember(p2);

        // Invite single person
        p1.sendInvitation();

        // Invite whole family
        family.sendInvitation();
    }
}
