import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // array of images
    String[] image = {"chineseflag-(1).jpg","pingpong.jpg","panda-8171354_640.jpg"};
// draw and play scene
    MyStory scene = new MyStory(image);
    
    scene.drawScene();

    Theater.playScenes(scene);


    

    
    
  }
}
