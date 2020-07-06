import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Igu extends JFrame{
  private Cronometro cronometro;
  private JButton iniciar;
  private JButton pausar;
  private JButton reiniciar;
  private JLabel titulo;
  private JLabel LabelContador;
  
  public Igu(){
  	cronometro= new Cronometro();
    JPanel botones = new JPanel();
    JPanel tableros = new JPanel();
    JPanel caja = new JPanel();
    JPanel contador= new JPanel();

    
    iniciar= new JButton();
    pausar = new JButton();
    reiniciar= new JButton();
    titulo = new JLabel("CRONÓMETRO");
    LabelContador= new JLabel();
    
    caja.setLayout(new GridLayout(3,1));
    tableros.setLayout(new GridLayout(1,1));
    LabelContador.setLayout(new GridLayout(1,1));

    titulo.setHorizontalAlignment(JLabel.CENTER);
    titulo.setForeground(Color.white);
    titulo.setFont(new Font ("Courier",Font.PLAIN,60));
    tableros.setBackground(Color.black);
    
    LabelContador.setHorizontalAlignment(JLabel.CENTER);
    LabelContador.setForeground(Color.white);
    LabelContador.setFont(new Font ("Courier",Font.PLAIN,50));
    LabelContador.setOpaque(true);
    LabelContador.setBackground(Color.black);
    
    ImageIcon IconoPausar=new ImageIcon("Iconos/pause.png");
    pausar.setBackground(Color.BLACK);
    pausar.setBounds(400, 300, 100, 100);    
    pausar.setIcon(new ImageIcon(IconoPausar.getImage().getScaledInstance(pausar.getWidth(),pausar.getHeight(),Image.SCALE_SMOOTH)));

    ImageIcon IconoIniciar=new ImageIcon("Iconos/video.png");
    iniciar.setBackground(Color.BLACK);
    iniciar.setBounds(400, 300, 100, 100);    
    iniciar.setIcon(new ImageIcon(IconoIniciar.getImage().getScaledInstance(iniciar.getWidth(),iniciar.getHeight(),Image.SCALE_SMOOTH)));

    ImageIcon IconoReiniciar=new ImageIcon("Iconos/reiniciar.png");
    reiniciar.setBackground(Color.BLACK);
    reiniciar.setBounds(400, 300, 100, 100);    
    reiniciar.setIcon(new ImageIcon(IconoReiniciar.getImage().getScaledInstance(reiniciar.getWidth(),reiniciar.getHeight(),Image.SCALE_SMOOTH)));
    botones.setBackground(Color.black);
    botones.add(iniciar);
    botones.add(pausar);
    botones.add(reiniciar);
    tableros.add(titulo);
    caja.add(tableros);
    caja.add(LabelContador);
    caja.add(botones);

    getContentPane().add(caja);
    pack();
    this.setVisible(true);
    setTitle("Cronómetro");
    LabelContador.setText("00:00:00");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setBounds(100,100,550,558);
    
    pausar.setEnabled(false);
    reiniciar.setEnabled(false);
    Timer timer = new Timer (1000, new ActionListener ()
    {
        public void actionPerformed(ActionEvent e)
        {
      		cronometro.Start();
    		String Tiempo=(cronometro.getHoras().getUnidadDeTiempo() <= 9 ? "0" : "") + cronometro.getHoras().getUnidadDeTiempo() + ":" 
    		+(cronometro.getMinutos().getUnidadDeTiempo() <= 9 ? "0" : "") + cronometro.getMinutos().getUnidadDeTiempo() + ":" 
    		+(cronometro.getSegundos().getUnidadDeTiempo() <= 9 ? "0" : "") + cronometro.getSegundos().getUnidadDeTiempo();
    	  LabelContador.setText(Tiempo);	

         }
    });
    ActionListener oyente = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent ae) {
	        timer.start();
    	    iniciar.setEnabled(false);
    	    pausar.setEnabled(true);
    	    reiniciar.setEnabled(true);
	    	}	
		};
    	iniciar.addActionListener(oyente);

        ActionListener oyente2 = new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent ae) {
    	        timer.stop();
        	    iniciar.setEnabled(true);
        	    pausar.setEnabled(false);
        	    reiniciar.setEnabled(true);
    	    	}	
    		};
        	pausar.addActionListener(oyente2);
            ActionListener oyente3 = new ActionListener() {

        		@Override
        		public void actionPerformed(ActionEvent ae) {
        	      if(timer.isRunning()) { 
        	    	  timer.stop();
        	      }
        	      cronometro.getHoras().setUnidadDeTiempo(0);
        	      cronometro.getMinutos().setUnidadDeTiempo(0);
        	      cronometro.getSegundos().setUnidadDeTiempo(0);
        	      LabelContador.setText("00:00:00");
          	    iniciar.setEnabled(true);
          	    pausar.setEnabled(false);
          	    reiniciar.setEnabled(false);
        	    	}	
        		};
            	reiniciar.addActionListener(oyente3);
    	}
    }


