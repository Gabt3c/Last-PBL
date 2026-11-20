import javax.swing.*;

public class TelaReserva {

    private final JFrame janela;
    private final SalaEstudo sala = new SalaEstudo("SALA-201", 6);
    private final JLabel labelSituacao = new JLabel();
    private final JLabel labelReservas = new JLabel();
    private final JTextField campoAluno = new JTextField(20);
    private final JButton botaoReservar = new JButton("Reservar");
    private final JButton botaoLiberar = new JButton("Liberar");

    public TelaReserva() {
        janela = new JFrame("Reserva de Sala de Estudo");
        JPanel painel = new JPanel();
        painel.add(new JLabel("Aluno:"));
        painel.add(campoAluno);
        painel.add(botaoReservar);
        painel.add(botaoLiberar);
        painel.add(labelSituacao);
        painel.add(labelReservas);

        botaoReservar.addActionListener(evento -> reservar());
        botaoLiberar.addActionListener(evento -> liberar());

        atualizarInterface();
        janela.add(painel);
        janela.setSize(450, 250);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

    // Mostra o resultado retornado pela regra de negócio.
    private void reservar() {
        boolean sucesso = sala.reservar(campoAluno.getText());
        atualizarInterface();
        JOptionPane.showMessageDialog(janela, sucesso
                ? "Sala reservada com sucesso!"
                : "Informe o nome do aluno para reservar.");
    }

    private void liberar() {
        boolean sucesso = sala.liberar(campoAluno.getText());
        atualizarInterface();
        JOptionPane.showMessageDialog(janela, sucesso
                ? "Sala liberada com sucesso!"
                : "A sala já está liberada.");
    }

    // Sincroniza o rótulo do contador e os botões com o estado da sala.
    private void atualizarInterface() {
        if (sala.isDisponivel()) {
            labelSituacao.setText("Situação: disponível");
        } else {
            labelSituacao.setText("Reservada por: " + sala.getResponsavel());
        }

        labelReservas.setText("Reservas realizadas: " + sala.getReservasRealizadas());
        botaoReservar.setEnabled(sala.isDisponivel());
        botaoLiberar.setEnabled(!sala.isDisponivel());
    }
}
