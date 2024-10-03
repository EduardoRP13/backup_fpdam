import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Juego extends JFrame implements ActionListener {
    private JButton btnJugar;
    private JTextField txtEleccion;
    private JTextArea txtResultados;
    private Random random;

    public Juego() {
        setTitle("Piedra, Papel, Tijera, Lagarto y Spock");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        random = new Random();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel lblInstrucciones = new JLabel("Elige piedra, papel, tijera, lagarto o spock:");
        txtEleccion = new JTextField();
        btnJugar = new JButton("Jugar");
        btnJugar.addActionListener(this);

        panel.add(lblInstrucciones);
        panel.add(txtEleccion);
        panel.add(btnJugar);

        add(panel, BorderLayout.NORTH);

        txtResultados = new JTextArea();
        txtResultados.setEditable(false);
        add(new JScrollPane(txtResultados), BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Juego();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnJugar) {
            String eleccionUsuario = txtEleccion.getText().toLowerCase();
            String[] opciones = {"piedra", "papel", "tijera", "lagarto", "spock"};
            String eleccionMaquina = opciones[random.nextInt(opciones.length)];

            // Lógica del juego
            String resultado = jugar(eleccionUsuario, eleccionMaquina);
            txtResultados.append("Tú elegiste: " + eleccionUsuario + "\n");
            txtResultados.append("La máquina eligió: " + eleccionMaquina + "\n");
            txtResultados.append(resultado + "\n\n");

            // Limpiar campo de texto
            txtEleccion.setText("");
        }
    }

    private String jugar(String usuario, String maquina) {
        if (usuario.equals(maquina)) {
            return "¡Empate!";
        }

        if ((usuario.equals("piedra") && (maquina.equals("tijera") || maquina.equals("lagarto"))) ||
                (usuario.equals("papel") && (maquina.equals("piedra") || maquina.equals("spock"))) ||
                (usuario.equals("tijera") && (maquina.equals("papel") || maquina.equals("lagarto"))) ||
                (usuario.equals("lagarto") && (maquina.equals("papel") || maquina.equals("spock"))) ||
                (usuario.equals("spock") && (maquina.equals("piedra") || maquina.equals("tijera")))) {
            return "¡Ganaste!";
        } else {
            return "¡La máquina gana!";
        }
    }
}
