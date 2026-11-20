public class SalaEstudo {

    private String codigo;
    private int capacidade;
    private boolean disponivel;
    private String responsavel;

    public SalaEstudo(String codigo, int capacidade) {
        this.codigo = codigo;
        this.capacidade = capacidade;
        this.disponivel = true;
        this.responsavel = "Nenhum";
    }

    //Reserva de acordo com a disponibilidade
    public boolean reservar(String aluno){
        if (!isDisponivel() && aluno.equals(null) || aluno == " "){
            return false;
        }
        this.setDisponivel(false);
        this.setResponsavel(aluno);
        return true; 
    }

    //Liberar desde que não esteja livre
    public boolean liberar(String aluno) {
        if (isDisponivel() == false && !aluno.equals(null) || aluno != " "){
        disponivel = true;
        }
        this.setDisponivel(true);
        this.setResponsavel("Nenhum");
        return false;
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