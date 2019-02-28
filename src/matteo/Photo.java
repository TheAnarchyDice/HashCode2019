package matteo;

import java.util.List;
import java.util.Set;

public class Photo {
  private final int id;
  private final Set<String> tags;
  private final Orientation orientation;

  Photo(int id, Orientation orientation, Set<String> tags) {
    this.id = id;
    this.tags = tags;
    this.orientation = orientation;
  }

  int getId() {
    return id;
  }

  Set<String> getTags() {
    return tags;
  }

  Orientation getOrientation() {
    return orientation;
  }

  public String print() {
    return "id: " + id + "\norientation: " + orientation + "\ntags: " + tags;
  }
}

enum Orientation {
  H,
  V;

  public static Orientation toOrientation(String s) {
    switch (s) {
      case "V":
        return Orientation.V;
      case "H":
        return Orientation.H;
      default:
        throw new RuntimeException("Invalid orientation value");
    }
  }
}
