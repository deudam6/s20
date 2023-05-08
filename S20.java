<%@ page language="java" contentType="text/html; charset=UTF-8" 
 pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title>Number to Words Converter</title> 
<style> 
 .red { 
 color: red; 
 } 
</style> 
</head> 
<body> 
 <h1>Number to Words Converter</h1> 
 <form method="post"> 
 Enter a number: <input type="text" name="number" /><br /> 
 <input type="submit" value="Convert" /> 
 </form> 
 <br /> 
 <%-- Get the number from the request parameter --%> 
 <% String numberStr = request.getParameter("number"); %> 
 <%-- Check if the number is not null and not empty --%> 
 <% if (numberStr != null && !numberStr.trim().isEmpty()) { %> 
 <%-- Convert the number to words --%> 
 <% String[] words = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", 
"Seven", "Eight", "Nine" }; %> 
 <% String number = numberStr.trim(); %> 
 <span class="red"> 
 <% for (int i = 0; i < number.length(); i++) { %> 
 <%= words[Character.getNumericValue(number.charAt(i))] + " " %> 
 <% } %> 
 </span> 
 <% } %> 
</body> 
</html> 
2.o/p
import java.awt.BorderLayout; 
import java.awt.Color; 
import java.awt.Dimension; 
import java.awt.Graphics; 
import java.awt.Image; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.File; 
import java.io.IOException; 
import javax.imageio.ImageIO; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.Timer; 
public class BlinkingImage extends JPanel implements ActionListener { 
 private static final long serialVersionUID = 1L; 
 private Image image; 
 private boolean blinkOn = true; 
 public BlinkingImage(Image image) { 
 this.image = image; 
 Timer timer = new Timer(500, this); // timer fires every 500ms 
 timer.start(); 
 } 
 @Override 
 protected void paintComponent(Graphics g) { 
 super.paintComponent(g); 
 if (blinkOn) { 
 g.drawImage(image, 0, 0, this); 
 } 
 } 
 @Override 
 public void actionPerformed(ActionEvent e) { 
 blinkOn = !blinkOn; 
 repaint(); 
 } 
 public static void main(String[] args) { 
 try { 
 Image image = ImageIO.read(new File("path/to/image.png")); 
 JPanel contentPane = new BlinkingImage(image); 
 contentPane.setPreferredSize(new Dimension(image.getWidth(null), 
image.getHeight(null))); 
 JFrame frame = new JFrame("Blinking Image"); 
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 frame.getContentPane().add(contentPane, BorderLayout.CENTER); 
 frame.pack(); 
 frame.setLocationRelativeTo(null); 
 frame.setVisible(true); 
 } catch (IOException e) { 
 e.printStackTrace(); 
 } 
 } 
} 