import javax.swing.*;

public class TelaReserva {

     private JFrame janela;
    private JPanel painel;
    private SalaEstudo sala = new SalaEstudo("SALA-201", 6);


    
    public TelaReserva() {
        //Inicia a janela
        janela = new JFrame("Reserva de Sala de Estudo");
        painel = new JPanel();
        janela.add(painel);
        janela.setSize(450, 250);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        //Adiciona a janela os itens abaixo
        painel.add(labelAluno);
        painel.add(campoAluno);
        painel.add(botaoReservar);
        painel.add(botaoLiberar);
        painel.add(labelSituacao);
    }

    //cria os componentes da janela
    JLabel labelSituacao = new JLabel("Situação: disponível");
    JLabel labelAluno = new JLabel("Aluno:");
    JTextField campoAluno = new JTextField(20);

    //metodo para atualizar a interface
    private void atualizarInterface() {
    if (sala.isDisponivel() == true) {
        labelSituacao.setText("Situação: disponível" );
    } 
    else {
        labelSituacao.setText("Reservada por: "+ sala.getResponsavel()
        );
    }
}
    //botoes (CARALHO Q BGLH CHATO DOS INFERNOS)

    JButton botaoReservar = new JButton("Reservar");{
    //logica do botao
    botaoReservar.addActionListener(evento -> {
    String aluno = campoAluno.getText();
    boolean sucesso = sala.isDisponivel();
    if (sucesso == true) {
    JOptionPane.showMessageDialog(janela,"Sala reservada com sucesso!");
    sala.reservar(aluno);
    } 

    else {
    JOptionPane.showMessageDialog(janela,"Não foi possível realizar a reserva.");
    }
    
    atualizarInterface();
        });
    }

    JButton botaoLiberar = new JButton("Liberar");{
    //logica do botao
    botaoLiberar.addActionListener(evento -> {
    String aluno = campoAluno.getText();
    boolean sucesso = sala.isDisponivel();
    if (sucesso == false) {
    JOptionPane.showMessageDialog(janela,"Sala liberada com sucesso!");
    sala.liberar(aluno);
    } 

    else {
    JOptionPane.showMessageDialog(janela,"A sala ja esta liberada");
    }
    
    atualizarInterface();
        });

    }
}