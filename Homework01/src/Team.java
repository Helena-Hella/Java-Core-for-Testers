public class Team extends Member {

    // название команды
    // массив из 4 участников, их можно указать сразу в конструкторе
    // метод для вывода информации о членах команды, прошедших дистанцию
    // метод вывода информации о всех членах команды

    String name;
    Member[] members = new Member[4];

    public Team(String name, Member member1, Member member2, Member member3, Member member4) {
        this.name = name;
        this.age = age;
        members[0] = member1;
        members[1] = member2;
        members[2] = member3;
        members[3] = member4;
    }

    public void showInfoAboutMembers() {
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public void showInfoAboutWinners() {
        for (Member member : members) {
            if (member.isWinner) {
                System.out.println(member);
            }
        }
    }

}
