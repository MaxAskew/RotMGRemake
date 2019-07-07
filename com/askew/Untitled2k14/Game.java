/*     */ package com.askew.Untitled2k14;
/*     */ 
/*     */ import com.askew.Untitled2k14.entity.mob.Player;
/*     */ import com.askew.Untitled2k14.graphics.Font;
/*     */ import com.askew.Untitled2k14.graphics.Screen;
/*     */ import com.askew.Untitled2k14.input.Keyboard;
/*     */ import com.askew.Untitled2k14.input.Mouse;
/*     */ import com.askew.Untitled2k14.level.Level;
/*     */ import com.askew.Untitled2k14.level.TileCoordinate;
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferStrategy;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.DataBufferInt;
/*     */ import java.awt.image.WritableRaster;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ 
/*     */ public class Game
/*     */   extends Canvas
/*     */   implements Runnable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  27 */   private static int width = 360;
/*  28 */   private static int height = 240;
/*  29 */   private static int scale = 3;
/*     */   
/*     */   private Keyboard key;
/*     */   
/*     */   private Thread thread;
/*     */   private JFrame frame;
/*  35 */   public static String title = "Zombies2K14";
/*  36 */   private boolean running = false;
/*     */   
/*     */   private Screen screen;
/*     */   
/*     */   public Level level;
/*     */   public Player player;
/*     */   private Font font;
/*  43 */   private BufferedImage image = new BufferedImage(width, height, 1);
/*  44 */   private int[] pixels = ((DataBufferInt)this.image.getRaster().getDataBuffer()).getData();
/*  45 */   public static String username = "";
/*     */   
/*     */   public Game()
/*     */   {
/*  49 */     Dimension size = new Dimension(width * scale, height * scale);
/*  50 */     setPreferredSize(size);
/*     */     
/*  52 */     this.screen = new Screen(width, height);
/*  53 */     this.frame = new JFrame();
/*  54 */     this.key = new Keyboard();
/*  55 */     addKeyListener(this.key);
/*  56 */     this.font = new Font();
/*     */     
/*  58 */     TileCoordinate playerSpawn = new TileCoordinate(36, 90);
/*  59 */     this.level = Level.CoreLevel;
/*  60 */     this.player = new Player(playerSpawn.x(), playerSpawn.y(), this.key, username);
/*     */     
/*  62 */     this.player.init(this.level);
/*     */     
/*  64 */     Mouse mouse = new Mouse();
/*  65 */     addMouseListener(mouse);
/*  66 */     addMouseMotionListener(mouse);
/*  67 */     addKeyListener(this.key);
/*     */   }
/*     */   
/*     */ 
/*     */   public static int getWindowWidth()
/*     */   {
/*  73 */     return width * scale;
/*     */   }
/*     */   
/*     */   public static int getWindowHeight()
/*     */   {
/*  78 */     return height * scale;
/*     */   }
/*     */   
/*     */   public synchronized void start()
/*     */   {
/*  83 */     this.running = true;
/*  84 */     this.thread = new Thread(this, "Display");
/*     */     
/*  86 */     this.thread.start();
/*     */     
/*  88 */     username = JOptionPane.showInputDialog(this, "Please enter a username (3 or less characters)");
/*  89 */     while (username.length() >= 4)
/*     */     {
/*  91 */       username = "";
/*  92 */       username = JOptionPane.showInputDialog(this, "Please enter a username (3 or less characters)");
/*     */     }
/*     */   }
/*     */   
/*     */   public synchronized void stop()
/*     */   {
/*  98 */     this.running = false;
/*     */     try
/*     */     {
/* 101 */       this.thread.join();
/*     */     }
/*     */     catch (InterruptedException e) {
/* 104 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void run()
/*     */   {
/* 111 */     long lastTime = System.nanoTime();
/* 112 */     long timer = System.currentTimeMillis();
/* 113 */     double ns = 1.6666666666666666E7D;
/* 114 */     double delta = 0.0D;
/* 115 */     int frames = 0;
/* 116 */     int updates = 0;
/* 117 */     requestFocus();
/* 118 */     while (this.running)
/*     */     {
/* 120 */       long now = System.nanoTime();
/* 121 */       delta += (now - lastTime) / 1.6666666666666666E7D;
/* 122 */       lastTime = now;
/* 123 */       while (delta >= 1.0D)
/*     */       {
/* 125 */         update();
/*     */         
/* 127 */         updates++;
/* 128 */         delta -= 1.0D;
/*     */       }
/* 130 */       render();
/* 131 */       frames++;
/*     */       
/* 133 */       if (System.currentTimeMillis() - timer > 1000L)
/*     */       {
/* 135 */         timer += 1000L;
/* 136 */         this.frame.setTitle(title + " || FPS: " + frames + " || UPS: " + updates);
/*     */         
/* 138 */         updates = 0;
/* 139 */         frames = 0;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void update()
/*     */   {
/* 147 */     this.key.update();
/* 148 */     this.player.update();
/* 149 */     this.level.update();
/*     */   }
/*     */   
/*     */   public void render()
/*     */   {
/* 154 */     BufferStrategy bs = getBufferStrategy();
/* 155 */     if (bs == null)
/*     */     {
/* 157 */       createBufferStrategy(3);
/* 158 */       return;
/*     */     }
/* 160 */     this.screen.clear();
/*     */     
/* 162 */     int xScroll = this.player.x - this.screen.width / 2;
/* 163 */     int yScroll = this.player.y - this.screen.height / 2;
/* 164 */     this.level.render(xScroll, yScroll, this.screen);
/* 165 */     this.player.render(this.screen);
/* 166 */     this.font.render(this.screen.width / 2 - 21, this.screen.height / 2 - 20, username, this.screen);
/*     */     
/* 168 */     for (int i = 0; i < this.pixels.length; i++)
/*     */     {
/* 170 */       this.pixels[i] = this.screen.pixels[i];
/*     */     }
/*     */     
/* 173 */     Graphics g = bs.getDrawGraphics();
/*     */     
/* 175 */     g.drawImage(this.image, 0, 0, getWidth(), getHeight(), null);
/* 176 */     g.setColor(Color.pink);
/* 177 */     g.drawString("x: " + this.player.x + ", y: " + this.player.y, 10, 15);
/* 178 */     g.drawString("ButtonPressed: " + Mouse.getButton(), 10, 30);
/* 179 */     g.drawString("Mouse x: " + Mouse.getX() + ", Mouse y: " + Mouse.getY(), 10, 45);
/* 180 */     g.drawString("Swimming: " + this.player.swimming, 10, 60);
/*     */     
/* 182 */     g.dispose();
/* 183 */     bs.show();
/*     */   }
/*     */   
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 189 */     Game game = new Game();
/* 190 */     game.frame.setResizable(false);
/* 191 */     game.frame.add(game);
/* 192 */     game.frame.pack();
/* 193 */     game.frame.setDefaultCloseOperation(3);
/* 194 */     game.frame.setLocationRelativeTo(null);
/* 195 */     game.frame.setVisible(true);
/* 196 */     game.start();
/*     */   }
/*     */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\Game.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */