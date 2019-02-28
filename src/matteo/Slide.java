package matteo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Slide {
  private final Photo p1;
  private final Photo p2;
  private final Set<String> tags;

  Slide(Photo p1) {
    this.p1 = p1;
    this.p2 = null;
    tags = new HashSet<>();
    tags.addAll(p1.getTags());
  }

  Slide(Photo p1, Photo p2) {
    if (!(p1.getOrientation().equals(Orientation.V) && p2.getOrientation().equals(Orientation.V))) {
      throw new IllegalArgumentException();
    }

    this.p1 = p1;
    this.p2 = p2;
    tags = new HashSet<>();
    tags.addAll(p1.getTags());
    tags.addAll(p2.getTags());
  }

  public Photo getP1() {
    return p1;
  }

  public Photo getP2() {
    return p2;
  }

  public Orientation getOrientation() {
    return p1.getOrientation();
  }

  public Set<String> getTags() {
    return tags;
  }

  public int score(Slide other){
    Set<String> tagsTmp = new HashSet<>();
    tagsTmp.addAll(this.getTags());
    tagsTmp.retainAll(other.getTags());
    int numTagsIntersection = tagsTmp.size();

    tagsTmp = new HashSet<>();
    tagsTmp.addAll(this.getTags());
    tagsTmp.removeAll(other.getTags());
    int tagsThisDiffOther = tagsTmp.size();

    tagsTmp = new HashSet<>();
    tagsTmp.addAll(other.getTags());
    tagsTmp.removeAll(this.getTags());
    int tagsOtherDiffThis = tagsTmp.size();

    return Math.min(numTagsIntersection, Math.min(tagsThisDiffOther, tagsOtherDiffThis));


  }
}
