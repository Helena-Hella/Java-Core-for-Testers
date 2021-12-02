public class Main {
    public static void main(String[] args){

        Member member1 = new Member ("Igor", 25, 400);
        Member member2 = new Member ("Oleg", 28, 10);
        Member member3 = new Member ("Maksim", 40, 50);
        Member member4 = new Member ("Masha", 30, 500);
        Team team = new Team ("Название моей команды", member1, member2, member3, member4); //создаем команду

        Course course = new Course (5, 100, 50); //создаем полосу препятствий
        System.out.println("Наша команда: ");
        team.showInfoAboutMembers(); //выводим членов команды
        course.doIt(team); // просим команду пройти полосу
        System.out.println("Победители, прошедние полосу препятствий: ");
        team.showInfoAboutWinners(); //показываем победителей

    }
}
