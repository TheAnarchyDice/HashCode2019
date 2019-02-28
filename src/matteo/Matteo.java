package matteo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Matteo {
  public static void main(String[] args) {

    Scanner input = null;
    try {
      input = new Scanner(new File("a_example.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    int numPhotos = input.nextInt();
    List<Photo> photos = new ArrayList<>();

    for (int i = 0; i < numPhotos; i++) {
      Orientation orientation = Orientation.toOrientation(input.next());
      int numTags = input.nextInt();
      Set<String> tags = new HashSet<>();

      for (int j = 0; j < numTags; j++) {
        tags.add(input.next());
      }

      photos.add(new Photo(i, orientation, tags));
    }

    for (Photo photo : photos) {
      System.out.println(photo.print() + "\n");
    }

    Photo p0 = photos.get(0);
    Photo p3 = photos.get(3);

    /*System.out.println(p0.getOrientation());
    System.out.println(p3.getOrientation());
    Slide slide = new Slide(p0, p3);
    System.out.println(slide.getTags());*/

    Slide s0 = new Slide(p0);
    Slide s3 = new Slide(p3);
    System.out.println(s0.score(s3));


  }
}
