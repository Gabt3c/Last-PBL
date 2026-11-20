public class SalaEstudo {

    private String codigo;
    private int capacidade;
    private boolean disponivel;
    private String responsavel;
    private int reservasRealizadas;

    public SalaEstudo(String codigo, int capacidade) {
        this.codigo = codigo;
        this.capacidade = capacidade;
        this.disponivel = true;
        this.responsavel = "Nenhum";
    }

    // Registra a reserva e incrementa o contador após validar a operação.
    public boolean reservar(String aluno) {
        if (!isDisponivel() || aluno == null || aluno.isBlank()) {
            return false;
        }
        this.setDisponivel(false);
        this.setResponsavel(aluno);
        reservasRealizadas++;
        return true;
    }

    // Libera uma sala ocupada e preserva o histórico de reservas.
    public boolean liberar(String aluno) {
        if (isDisponivel()) {
            return false;
        }
        this.setDisponivel(true);
        this.setResponsavel("Nenhum");
        return true;
    }

    public int getReservasRealizadas() {
        return reservasRealizadas;
    }
    //gets e setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isDisponivel() {
    return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    
}
