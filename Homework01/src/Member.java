public class Member {
    String name; // объявляю переменные для мемберов
    int age;
    boolean isWinner;
    int maxLength;

    public Member(String name, int age, int maxLength) {
        this.name = name;
        this.age = age;
        this.maxLength = maxLength;
        isWinner = false;
    }

    public Member() {
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", возраст: " + age ;
    }

}
