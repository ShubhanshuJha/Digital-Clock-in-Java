import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.Date;
import java.text.*;

public class Window extends Frame{ //can extend JFrame
	// private Label clockLabel, heading; //these can be JLabel
	// private Font font;
	private Label clock_heading, clock_time;
	private Label date_heading, date;
	private Label timeZone_heading, timeZone;
	private Label spacer1, spacer2, spacer3, spacer4, last_spacer1, last_spacer2, last_spacer3, last_spacer4;

	Window(String s){
		setTitle(s); //could call this super as well
		setSize(700, 400);
		setLocation(300, 200);
		setBackground(Color.MAGENTA);
		setForeground(Color.black);
		Font fn = new Font("MONOSPACED", Font.ROMAN_BASELINE, 32);
		Font fn2 = new Font("Forte", Font.BOLD, 32);
		setFont(fn);
		// font = fn;
		// this.createGUI();
		clock_heading = new Label("Time: ");
		clock_time = new Label("Clock");

		date_heading = new Label("Date: ");
		date = new Label("Date");

		timeZone_heading = new Label("TimeZone: ");
		timeZone = new Label("TimeZone");

		spacer1 = new Label();
		spacer2 = new Label();
		spacer3 = new Label();
		spacer4 = new Label();

		last_spacer1 = new Label();
		last_spacer2 = new Label();
		// last_spacer3 = new Label();
		// last_spacer4 = new Label();

		clock_time.setFont(fn2);
		clock_heading.setFont(fn);
		date_heading.setFont(fn);
		date.setFont(fn2);
		timeZone_heading.setFont(fn);
		timeZone.setFont(fn2);

		add(spacer1);
		this.add(clock_heading);
		this.add(clock_time);
		add(spacer3);

		this.add(spacer2);
		add(date_heading);
		add(date);
		this.add(spacer4);
		startClock();

		add(last_spacer1);
		add(timeZone_heading);
		add(timeZone);
		add(last_spacer2);
		// add(last_spacer3);
		// add(last_spacer4);

		// setLayout(new FlowLayout());
		setLayout(new GridLayout(3, 4));

		setVisible(true);
		setResizable(false);
		// isResizable();

		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	/*public void createGUI(){
		clockLabel = new JLabel("Clock");
		heading = new JLabel("My Clock");

		clockLabel.setFont(font);
		heading.setFont(font);
		super.setBackground(Color.BLACK);
		super.setForeground(Color.RED);
		this.setLayout(new GridLayout(2, 1));
		this.add(heading);
		this.add(clockLabel);
		this.startClock();
	}*/
	public void startClock(){
		/*Timer timer = new Timer(1000, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
				// String dateTime = new Date().toString();
				// String dateTime = new Date().toLocaleString();

				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss a");
				String dateTime = sdf.format(d);

				clock_time.setText(dateTime);
				// @SuppressWarnings
				// date.setText(new Date().toLocaleString());
				date.setText(d.toString());
			}
		}); //(millisecond, actionlistener)
		timer.start();*/ //Thread is doing the same as of this timer will perform

		Thread t = new Thread(){
			@Override
			public void run(){
				try{
					while(true){
						Date d = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss a");
						String dateTime = sdf.format(d);

						clock_time.setText(dateTime);
						date.setText(d.toString());
						timeZone.setText("  "+d.toString().substring(20, d.toString().length()));

						Thread.currentThread().sleep(1000); //Thread.sleep(1000);
					}
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		};
		t.start();
	}
}