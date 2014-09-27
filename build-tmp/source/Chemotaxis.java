import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

Poro [] stuffs;
Cookie food;
int cookieColor = color(115,57,0);

public void setup()   
 {  
 	size(600,600);
  stuffs = new Poro[100];
  food = new Cookie(300,300);
  for (int i = 0; i < stuffs.length; i++){
    stuffs[i] = new Poro();
  }
 }   
 public void draw()   
 {  
  background(179,221,255);
  food.show();
  for (int i = 0; i < stuffs.length; i++){
    stuffs[i].show();
    if(stuffs[i].myX < food.myX)
    {
      stuffs[i].myX = stuffs[i].myX + (int)(Math.random()*4) - 1;
    }
    else if(stuffs[i].myX > food.myX)
    {
      stuffs[i].myX = stuffs[i].myX + (int)(Math.random()*4) - 2;
    }
    else 
    {
      stuffs[i].myX = stuffs[i].myX + (int)(Math.random()*5) - 2; 
    }
    if(stuffs[i].myY < food.myY)
    {
      stuffs[i].myY = stuffs[i].myY + (int)(Math.random()*4) - 1;
    }
    else if(stuffs[i].myY > food.myY)
    {
      stuffs[i].myY = stuffs[i].myY + (int)(Math.random()*4) - 2;
    }
    else 
    {
      stuffs[i].myY = stuffs[i].myY + (int)(Math.random()*5) - 2; 
    }
    

    int cookie = get(stuffs[i].myX + 10,stuffs[i].myY+10);
    int cookie1 = get(stuffs[i].myX - 10,stuffs[i].myY-10);
    int cookie2 = get(stuffs[i].myX + 10,stuffs[i].myY-10);
    int cookie3 = get(stuffs[i].myX - 10,stuffs[i].myY+10);
    if (cookie == cookieColor){
      stuffs[i].getBig();
      food.disappear();
    } else if (cookie1 == cookieColor){
      stuffs[i].getBig();
      food.disappear();
    } else if (cookie2 == cookieColor){
      stuffs[i].getBig();
      food.disappear();
    } else if (cookie3 == cookieColor){
      stuffs[i].getBig();
      food.disappear();
    } 
  }

 }  

class Cookie {
  int myX;
  int myY;
  Cookie(int x, int y){
    myX = x;
    myY = y;
  }
  public void show(){
    noStroke();
    fill(cookieColor);
    ellipse(myX,myY,30,30);
    stroke(0);
    ellipse(myX,myY,22,22);
    ellipse(myX,myY,20,20);
  }
  public void disappear(){
    textSize(50);
    text("<3",myX,myY);
    myX = (int)(Math.random()*600);
    myY = (int)(Math.random()*600); 
  }

}

class Poro {   
  int poroSize = 20;  
  int myX;
  int myY;
 	Poro(){
    myX = (int)(Math.random()*600);
    myY = (int)(Math.random()*600);
 	}
 	public void show(){
 		fill(255);
    noStroke();
    ellipse(myX,myY,poroSize,poroSize);
    fill(107,73,44);
    triangle(myX+6,myY-9,myX+9,myY-3,myX+10,myY-10);
    triangle(myX-6,myY-9,myX-9,myY-3,myX-10,myY-10);
    fill(0);
    ellipse(myX+3,myY,3,3);
    ellipse(myX-3,myY,3,3);
    fill(255,99,172);
    arc(myX,myY+5,8,15,0,PI);
  	}
  public void getBig(){
    poroSize = poroSize +10;
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
