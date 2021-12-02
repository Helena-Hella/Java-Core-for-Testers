public class Course {
    // это полоса препятствий
    // создать метод, который будет просить команду пройти всю полосу

    int[] distances = new int[3];

    public Course(int length1, int length2, int length3) { // создать массив из препятствий
        distances[0] = length1;
        distances[1] = length2;
        distances[2] = length3;
    }

     public void doIt(Team team) {

        for (Member member : team.members) {
            for (int distance : distances) {
                   if (member.maxLength >= distance) {
                    member.isWinner = true;
                }
                   else {
                       member.isWinner = false;
                       break;
                   }
            }
        }
    }

}
