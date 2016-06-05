import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
	}

	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		
		if(mouseOver(mx, my, 210, 150, 200, 64)){
			game.gameState = Game.STATE.Game;
			handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
		}
		
		if(mouseOver(mx, my, 210, 250, 200, 64)){
			System.exit(1);
		}
	
		
	}
	
		
	public void mouseReleased(MouseEvent e){
	}

	
	public boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}else return false;
		}else return false;
	}
	
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		Font fnt = new Font("arial", 1, 50);
		Font fnt2 = new Font("arial", 1, 30);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Menu", 240, 70);
		
		g.setFont(fnt2);
		g.drawRect(210, 150, 200, 64);
		g.drawString("Start", 270, 190);
		
		
		g.setColor(Color.white);
		g.drawRect(210, 250, 200, 64);
		g.drawString("Wyj�cie", 260, 290);
		
		
		
		
	}
	}
	
	

