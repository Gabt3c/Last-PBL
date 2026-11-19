import javax.swing.*;

public class TelaReserva {

    private JFrame janela;
    private JPanel painel;

    public TelaReserva() {

        janela = new JFrame("Reserva de Sala de Estudo");

        painel = new JPanel();

        janela.add(painel);

        janela.setSize(450, 250);

        janela.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        janela.setVisible(true);
    }
}