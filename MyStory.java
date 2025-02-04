import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

  // instance variables
  
  private String[] imageArr;

   
  // constructor

   public MyStory(String[] imageArr) {
    this.imageArr = imageArr;
  }
  

  // main drawScene method 

  public void drawScene() {
    drawFlag();
    drawSport();
    drawPanda();
  }
// draw methods for each image

  // draws flag image and pixelates it
  public void drawFlag() {
    clear("white");
    
    setTextHeight(30);
    setTextColor("black");

    drawText("I am chinese", 100, 40);
    ImageFilter flag = new ImageFilter(imageArr[0]);
    drawImage(flag, 20, 60, 350);
    playSound("chime.wav");
    pause(1.0);

    clear("white");
    for(int i = 0; i < 5; i++){
    flag.pixelate(5);
    drawText("I am chinese", 100, 40);
    drawImage(flag, 20, 60, 350);
    
    pause(1.0);
  }


    // draws sport image and motion blurs it
  }

  public void drawSport() {
    clear("white");
    
    setTextHeight(30);
    setTextColor("black");

    drawText("National Sport: Pingpong", 50, 40);
    ImageFilter sport = new ImageFilter(imageArr[1]);
    drawImage(sport, 20, 60, 350);
    playSound("baseball_hit.wav");
    pause(1.0);

    clear("white");
    for(int i = 0; i < 7; i++){
    sport.motionBlur(10, "vertical");
    drawText("National Sport: Pingpong", 50, 40);
    drawImage(sport, 20, 60, 350);
    
    pause(1.0);
  }
    
  }

// draws panda image and makes image blue
  
  public void drawPanda() {
    clear("white");
    
    setTextHeight(30);
    setTextColor("black");

    drawText("National Animal: Panda", 50, 40);
    ImageFilter panda = new ImageFilter(imageArr[2]);
    drawImage(panda, 20, 60, 350);
    playSound("bear_growl_y.wav");
    pause(1.0);

    clear("white");
    for(int i = 0; i < 5; i++){
    panda.blue();
    drawText("National Animal: Panda", 50, 40);
    drawImage(panda, 20, 60, 350);
    
    pause(1.0);
    }
    
  }
}
