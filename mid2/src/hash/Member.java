package hash;

import java.util.Objects;

public class Member {

    private String id;

    public Member(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static void main(String[] args) {

        Member member1 = new Member("idA");
        Member member2 = new Member("idA");

        System.out.println("(member1 == member2) = " + (member1 == member2));
        System.out.println("member1 equals member2 = " + member1.equals(member2));
        System.out.println("member1.hashCode() = " + member1.hashCode());
        System.out.println("member2.hashCode() = " + member2.hashCode());
    }
}
