import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {
  
  public ImageFilter(String filename) {
    super(filename);   // Calls the Image class constructor

  }

  // pixelate filter
   public void pixelate(int gridSize) {
    int numRows = getHeight();  
    int numCols = getWidth();   //THESE 2 METHODS GIVE YOU THE WIDTH AND HEIGHT
   
//GO THROUGH IT BASED ON THE PARAMATER SIZE
   
    for (int rowStart = 0; rowStart < numRows; rowStart += gridSize) {
        for (int colStart = 0; colStart < numCols; colStart += gridSize) {
            // Determine the end row and column for the current block
            int rowEnd = Math.min(rowStart + gridSize, numRows);
            int colEnd = Math.min(colStart + gridSize, numCols);
           
            int redSum = 0;
          int greenSum = 0;
          int blueSum = 0;
            int pixelCount = 0;
//SETS THE SUM OF RED GREEN AND BLUE THAT WILL BE DIVIDED LATER
         
          //rowstart determines the start of your current chunk, row end is the end of the chunk
          for (int row = rowStart; row < rowEnd; row++) {
                for (int col = colStart; col < colEnd; col++) {
                    Pixel pixel = getPixel(row, col);
                    redSum += pixel.getRed();         //adds the current colors of the pixel to the total chunk value
                    greenSum += pixel.getGreen();    
                    blueSum += pixel.getBlue();      
                    pixelCount++;                     //goes to next pixel while adding 1 to the count
                }
            }
           
            int avgRed = redSum / pixelCount;
            int avgGreen = greenSum / pixelCount;//divides the chunk colors by total amt of pixels there are in the chunk
            int avgBlue = blueSum / pixelCount;
           
            // Set each pixel in the block to the average color
            for (int row = rowStart; row < rowEnd; row++) {
                for (int col = colStart; col < colEnd; col++) {
                    Pixel pixel = getPixel(row, col); // Get the Pixel object at (row, col)
           
                  pixel.setRed(avgRed);            
                   pixel.setGreen(avgGreen);     // Set the colors in that chunk to the average color
                pixel.setBlue(avgBlue);          
         }
      }
   }
}
   }

// motion blur filter


  /*
   * Applies a motion blur to the image
   */
public void motionBlur(int length, String direction) {
Pixel[][] imagePixels = getImagePixels();  // Get the 2D array of Pixel objects

    // Traverse the image pixel array
    for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        int redTotal = 0;
        int greenTotal = 0;
        int blueTotal = 0;
        int count = 0;
        
        // Check neighboring pixels based on the direction
        for (int i = 0; i < length; i++) {
          int newX = x;
          int newY = y;

          // Adjust coordinates based on the motion blur direction
          if (direction.equals("horizontal")) {
            newX = x + i;
          } else if (direction.equals("vertical")) {
            newY = y + i;
          } else if (direction.equals("diagonal")) {
            newX = x + i;
            newY = y + i;
          }

          // Make sure the new coordinates are within bounds of the image
          if (newX >= 0 && newX < getWidth() && newY >= 0 && newY < getHeight()) {
            Pixel currentPixel = imagePixels[newY][newX];
            redTotal += currentPixel.getRed();
            greenTotal += currentPixel.getGreen();
            blueTotal += currentPixel.getBlue();
            count++;
          }
        }

        // Calculate the average color values of the neighboring pixels
        int avgRed = redTotal / count;
        int avgGreen = greenTotal / count;
        int avgBlue = blueTotal / count;

        // Create a Color object with the average RGB values
        Color avgColor = new Color(avgRed, avgGreen, avgBlue);

        // Use a set method to update the pixel (assuming setPixel is available)
        setPixel(x, y, avgColor);  // Replace this with the actual method for setting the pixel
      }
    }


    
  }

  // threshold filter
    public void threshold(int value) {
    /* makes an immage black and white by comparing the grayscale value of each pixel to a threshold value
    * if the RGB average is less than the threshold value, the pixel is colored white, otherwise, the pi
     */

    // creates an vairable to store the average red, green, and blue value of each pixel
    // int avgRGB = 0;

    // traverses the 2D array of pixels
    for (int row = 0; row < pixels.length; row++) {
     for (int col = 0; col < pixels[0].length; col++) {
      // finds the current red, green, and blue values of each pixel and finds the average of those values
      Pixel currentPixel = pixels[row][col];
      int currentBlue = currentPixel.getBlue();
      int currentGreen = currentPixel.getGreen();
      int currentRed = currentPixel.getRed();
      int avgRGB = (currentBlue + currentGreen + currentRed) / 3;
      // if the average is less than the parameter value, set the color of the pixel to black
    if (avgRGB < value) {
      currentPixel.setColor(Color.BLACK);

    }
      // else set the color of the pixel to white
      else {
         currentPixel.setColor(Color.WHITE);

  }
   }
}


    
  }
// removes red and green values from the image, making the image blue
   public void blue() {
    Pixel[][] imagePixels = getImagePixels();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        currentPixel.setRed(0);
        currentPixel.setGreen(0);
      }
    }
  }
}
