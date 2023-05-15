//Panel class which controls the simulation
package main;

import static util.ImageLoader.loadImage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.Timer;
import org.w3c.dom.Text;
import background.ConcreteFactory;
import background.Factory;
import background.Fan;
import background.Prop;
import background.Title;
import effects.Particle;
import effects.Plant;
import effects.Smoke;
import effects.Triangle;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import table.Table;
import table.TableTop;
import table.Light;
import table.Motherboard;
import table.PartFactory;
import table.Restart;
import table.Room;
import table.Start;
import table.Back;
import table.BaseButton;
import table.CPU;
import table.Display;
import table.ButtonFactory;
import main.Panel.MyMouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import util.ImageLoader;

import decorator.FanDecorator;
import decorator.PowerDecorator;
import decorator.Decorate;
import decorator.SimpleCase;
import util.MinimHelper;

public class Panel extends JPanel implements ActionListener {
	public static int W_WIDTH = 1320;
	public static int W_HEIGHT = 750;

	public static final int startX = 600;
	public static final int startY = 800;
	public static final int numOfRecursions = 9;
	public static final int startAngle = 0;

	// variables for holding mouse position
	private double mouseX;
	private double mouseY;

	// Fields for state and transitions
	private int state = 0;

	private PartFactory partsFact = new PartFactory();
	private ConcreteFactory stuff = new ConcreteFactory();

	private TableTop tabletop;
	private Plant plant;
	private Triangle triangle;
	private Room room;
	private Back bg;
	private ArrayList<Particle> smoke = new ArrayList<Particle>();

	private BaseButton table, mobo, cpu, gpu, ram1, ram2, light, fireex, mobocase;
	private Prop board, pot;
	private Write text;
	private Fan fanning;

	private Title title;
	private Start start;
	private Restart restart;
	Factory maker;
	Decorate casing;
	private Prop props;

	private Minim minim;
	private AudioPlayer ambient, button, click, click1, extinguisher, shift, finish;

	private Timer timer;

	Panel(JFrame frame) {
		this.setBackground(Color.white);
		setPreferredSize(new Dimension(W_WIDTH, W_HEIGHT));
		setLayout(new FlowLayout());

		fanning = new Fan(4 * W_WIDTH / 5, 3 * W_HEIGHT / 20, 0.1f);
		minim = new Minim(new MinimHelper());
		createParts();
		sound();

		ambient.loop();
		MyMouseListener ml = new MyMouseListener();
		addMouseListener(ml);

		MyMouseMotionListener mml = new MyMouseMotionListener();
		addMouseMotionListener(mml);

		timer = new Timer(30, this);
		timer.start();
	}

	public void sound() {
		ambient = minim.loadFile("ambient.mp3");
		button = minim.loadFile("button.mp3");
		click = minim.loadFile("cpu.mp3");
		click1 = minim.loadFile("ram.mp3");
		extinguisher = minim.loadFile("extinguisher.mp3");
		shift = minim.loadFile("shift.mp3");
		finish = minim.loadFile("finish.mp3");
	}

	public void createParts() {
		
		tabletop = new TableTop("assets/tabletop.png");
		room = new Room("assets/background.png");
		bg = new Back("assets/bg.png");
		
		title = new Title();
		start = new Start(W_WIDTH / 2, 2 * W_HEIGHT / 3, 0.35f);
		restart = new Restart(W_WIDTH / 2, 9 * W_HEIGHT / 10, 0.35f);

		board = stuff.create("board");
		pot = stuff.create("pot");

		table = partsFact.make("table");
		mobo = partsFact.make("mobo");
		mobocase = partsFact.make("mobocase");
		cpu = partsFact.make("cpu");
		gpu = partsFact.make("gpu");
		ram1 = partsFact.make("ram1");
		ram2 = partsFact.make("ram2");
		fireex = partsFact.make("fireex");
		light = partsFact.make("light");

		plant = new Plant();
		triangle = new Triangle();

		casing = new SimpleCase();
		casing = new PowerDecorator(casing, 0.5f);
		casing = new FanDecorator(casing, 0.5f);

		text = new Write();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (state == 0) {
			tabletop.draw(g2);
			start.draw(g2);
			title.draw(g2);
		}

		else if (state == -1) {
			room.draw(g2);
			board.display(g2);
			fanning.draw(g2);
			plant.draw(g2, 9 * W_WIDTH / 10, W_HEIGHT, numOfRecursions, 0);
			pot.display(g2);
			light.draw(g2);
			table.draw(g2);

			triangle.addTriangle(g2);
			text.write(g2, "Wow! It's dark in here, why don't you turn on the lights", " ");

			g2.setColor(new Color(0, 0, 0, 150));
			g2.fill(new Rectangle2D.Double(0, 0, W_WIDTH, W_HEIGHT));
		}

		else if (state == 1) {
			room.draw(g2);
			board.display(g2);
			fanning.draw(g2);
			plant.draw(g2, 9 * W_WIDTH / 10, W_HEIGHT, numOfRecursions, 0);
			pot.display(g2);
			light.draw(g2);
			table.draw(g2);

			triangle.addTriangle(g2);

			g2.setColor(new Color(0, 0, 0, 150));
			g2.fill(new Rectangle2D.Double(0, 0, W_WIDTH, W_HEIGHT));
		}

		else if (state == -2) {
			room.draw(g2);
			board.display(g2);
			fanning.draw(g2);
			plant.draw(g2, 9 * W_WIDTH / 10, W_HEIGHT, numOfRecursions, 0);
			pot.display(g2);
			light.draw(g2);
			table.draw(g2);

			triangle.addTriangle(g2);
			text.write(g2, "That's better! Now let's start by clicking on the table.", " ");

		}

		else if (state == 2) {
			room.draw(g2);
			board.display(g2);
			fanning.draw(g2);
			plant.draw(g2, 9 * W_WIDTH / 10, W_HEIGHT, numOfRecursions, 0);
			pot.display(g2);
			light.draw(g2);
			table.draw(g2);

			triangle.addTriangle(g2);
		}

		else if (state == -3) {
			tabletop.draw(g2);
			mobo.draw(g2);
			cpu.draw(g2);
			gpu.draw(g2);
			ram1.draw(g2);
			ram2.draw(g2);

			text.write(g2, "Let's assemble by starting with the CPU labled \'R7\'.",
					"Try dragging the CPU towards the motherboard.");
		}

		else if (state == 3) {
			tabletop.draw(g2);
			mobo.draw(g2);
			cpu.draw(g2);
			gpu.draw(g2);
			ram1.draw(g2);
			ram2.draw(g2);
		}

		else if (state == -4) {
			tabletop.draw(g2);
			mobo.draw(g2);
			gpu.draw(g2);
			ram1.draw(g2);
			ram2.draw(g2);

			for (int i = 0; i < smoke.size(); i++) {
				Particle part = smoke.get(i);
				part.update(g2, smoke);
			}

			text.write(g2, "Oh no the CPU is smoking!", "Get the fire extinguisher and use it on the CPU.");

		}

		else if (state == 4) {
			tabletop.draw(g2);
			mobo.draw(g2);
			gpu.draw(g2);
			ram1.draw(g2);
			ram2.draw(g2);

			for (int i = 0; i < smoke.size(); i++) {
				Particle part = smoke.get(i);
				part.update(g2, smoke);
			}

			fireex.draw(g2);

		}

		else if (state == -5) {
			tabletop.draw(g2);
			mobo.draw(g2);
			gpu.draw(g2);
			ram1.draw(g2);
			ram2.draw(g2);

			text.write(g2, "Great now that the smoke is out", "Get the ram to the motherboard like the CPU");
		}

		else if (state == 5) {
			tabletop.draw(g2);
			mobo.draw(g2);
			gpu.draw(g2);
			ram1.draw(g2);
			ram2.draw(g2);

		}

		else if (state == -6) {
			tabletop.draw(g2);
			mobo.draw(g2);
			gpu.draw(g2);
			ram1.draw(g2);

			text.write(g2, "Now drag the second ram towards the motherboard.", "");
		}

		else if (state == 6) {
			tabletop.draw(g2);
			mobo.draw(g2);
			gpu.draw(g2);
			ram1.draw(g2);

		}

		else if (state == -7) {
			tabletop.draw(g2);
			mobo.draw(g2);
			gpu.draw(g2);

			text.write(g2, "Last is the GPU which helps the graphics of the computer.",
					"Click on the GPU to install it onto the motherboard.");
		}

		else if (state == 7) {
			tabletop.draw(g2);
			mobo.draw(g2);
			gpu.draw(g2);
		}

		else if (state == -8) {
			tabletop.draw(g2);
			mobo.draw(g2);

			text.write(g2, "Great the parts are all assembled now.", "");
		}

		else if (state == 8) {
			tabletop.draw(g2);
			mobo.draw(g2);
		}

		else if (state == -9) {
			bg.draw(g2);
			casing.showCase(g2);
			mobocase.setMobo(4);
			mobocase.draw(g2);
			text.write(g2, "Finished! Finishing touches have been added.",
					"A Power Supply and some Fans have been installed");

		}

		else if (state == 9) {
			bg.draw(g2);
			casing.showCase(g2);
			mobocase.setMobo(4);
			mobocase.draw(g2);

			restart.draw(g2);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (state == -4 || state == 4) {
			smoke.add(new Smoke(W_WIDTH / 4, W_HEIGHT / 3, 30, 30, 1.2f));
		}
		
		if(state != -1 && state != 1) {
			fanning.update();
		}

		repaint();
	}

	public class MyMouseListener extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
			if (state == 0 && start.clicked(mouseX, mouseY)) {
				state = -1;
				button.play(0);
				ambient.pause();
			} else if (state == -1 && text.clicked(mouseX, mouseY)) {
				state = 1;
			} else if (state == -2 && text.clicked(mouseX, mouseY)) {
				state = 2;
			} else if (state == -3 && text.clicked(mouseX, mouseY)) {
				state = 3;
			} else if (state == -4 && text.clicked(mouseX, mouseY)) {
				state = 4;
				extinguisher.play();
			} else if (state == -5 && text.clicked(mouseX, mouseY)) {
				state = 5;
			} else if (state == -6 && text.clicked(mouseX, mouseY)) {
				state = 6;
			} else if (state == -7 && text.clicked(mouseX, mouseY)) {
				state = 7;
			} else if (state == -8 && text.clicked(mouseX, mouseY)) {
				state = -9;
				finish.play(0);
			} else if (state == -9 && text.clicked(mouseX, mouseY)) {
				state = 9;
			}

			else if (state == 1 && light.clicked(mouseX, mouseY)) {
				state = -2;
				click.play(0);
				ambient.rewind();
				ambient.play();
			}

			else if (state == 2 && light.clicked(mouseX, mouseY)) {
				state = -1;
				click.play(0);
				ambient.pause();
			} else if (state == 2 && table.clicked(mouseX, mouseY)) {
				state = -3;
				shift.play(0);
			}

			else if (state == 7 && gpu.clicked(mouseX, mouseY)) {
				mobo.setMobo(4);
				click.play(0);
				state = -8;
			}

			else if (state == 9 && restart.clicked(mouseX, mouseY)) {
				state = 0;
				mobo.setMobo(0);
				createParts();
				ambient.rewind();
				button.play(0);
			}
		}
	}

	public class MyMouseMotionListener extends MouseMotionAdapter {

		public void mouseDragged(MouseEvent e) {

			mouseX = e.getX();
			mouseY = e.getY();

			if (state == 3) {
				cpu.setLocX(mouseX);
				cpu.setLocY(mouseY);
				if (cpu.hit(mobo)) {
					click.play(0);
					mobo.setMobo(1);
					state = -4;
				}
			}

			if (state == 4) {
				fireex.setLocX(mouseX);
				fireex.setLocY(mouseY);
				if (fireex.hit(mobo)) {
					extinguisher.pause();
					state = -5;
				}
			}

			if (state == 5) {
				ram2.setLocX(mouseX);
				ram2.setLocY(mouseY);
				if (ram2.hit(mobo)) {
					click1.play(0);
					mobo.setMobo(2);
					state = -6;
				}
			}

			if (state == 6) {
				ram1.setLocX(mouseX);
				ram1.setLocY(mouseY);
				if (ram1.hit(mobo)) {
					click1.play(0);
					mobo.setMobo(3);
					state = -7;
				}
			}

			repaint();

		}
	}

}
