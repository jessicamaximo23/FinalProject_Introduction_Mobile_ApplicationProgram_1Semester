package Project;

public class Demo {

	public static void main(String[] args) {

		Computer c1 = new Computer("apple", "Mac pro", 3000);
		c1.displayComputer(c1);

		Computer c2 = new Computer("apple", "Mac pro", 3000);
		c1.displayComputer(c2);

		//System.out.println(c1.equal(c2));
		

		Computer c3 = new Computer("samsung", "Mac pro", 300);

		Computer c4 = new Computer("samsung", " pro", 600);
		

	}

}
