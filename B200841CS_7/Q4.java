import java.util.*;

interface SortVotes{
    void ascendDisplay();
    void descendDisplay();
}

class ElectionPost implements SortVotes{
    String nameOfThePost;
    ArrayList<String> listOfCandidates;
    ArrayList<String> votesEntered;
    Hashtable<String,Integer> votes;
    public ElectionPost(String nameOfThePost){
        this.nameOfThePost = nameOfThePost;
        this.listOfCandidates = new ArrayList<>();
        this.votesEntered = new ArrayList<>();
        this.votes = new Hashtable<>();
    }
    public void getListOfCandidates(Scanner s){
        int n = Integer.parseInt(s.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String name = s.nextLine().trim();
            this.listOfCandidates.add(name);
            this.votes.put(name, 0);
        }
    }
    public void getVotes(Scanner s){
        int n = Integer.parseInt(s.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String name = s.nextLine().trim();
            this.votesEntered.add(name);
            if(this.votes.get(name) != null){
                this.votes.put(name, this.votes.get(name) + 1);
            }
        }
    }
    public int compare(String o1 , String o2){
        return this.votes.get(o1) - this.votes.get(o2);
    }
    public void displayDetails(){
        System.out.println(this.nameOfThePost);
        for (String name : listOfCandidates) {
            System.out.println(name);
        }
    }

    public void ascendDisplay(){
        ArrayList<String> ascendList = new ArrayList<>();
        for (String name : this.listOfCandidates) {
            ascendList.add(name);
        }
        Comparator<String> Sorter = (o1,o2) -> compare(o1, o2);
        Collections.sort(ascendList , Sorter);
        for (String name : ascendList) {
            System.out.println(name + " - " + this.votes.get(name));
        }
    }
    public void descendDisplay(){
        ArrayList<String> descendList = new ArrayList<>();
        for (String name : this.listOfCandidates) {
            descendList.add(name);
        }
        Comparator<String> Sorter = (o1,o2) -> compare(o2, o1);
        Collections.sort(descendList , Sorter);
        for (String name : descendList) {
            System.out.println(name + " - " + this.votes.get(name));
        }
    }
}


public class Q4 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        ElectionPost e = new ElectionPost(s.nextLine().trim());
        e.getListOfCandidates(s);
        e.getVotes(s);
        e.displayDetails();
        e.ascendDisplay();
        e.descendDisplay();
        s.close();
    }

}
