package javaproject;

public class Member {
    private char memberType; // тип члена
    private int memberId; // ID пользователя
    private String name; // имя
    private double fees; // сборы

    public Member(char memberType, int memberId, String name, double fees) {
        this.memberType = memberType;
        this.memberId = memberId;
        this.name = name;
        this.fees = fees;
    }

    public char getMemberType() {
        return memberType;
    }

    public void setMemberType(char memberType) {
        this.memberType = memberType;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberType=" + memberType +
                ", memberId=" + memberId +
                ", name='" + name + '\'' +
                ", fees=" + fees +
                '}';
    }
}
