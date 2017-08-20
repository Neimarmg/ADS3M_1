package biblioteca.M;

public class Usuario {

    String codUsuario;
    String senha;
    String email;
    String tipo;
    String status;

    public Usuario(String codUsuario, String senha, String email, String tipo, String status) {
        this.codUsuario = codUsuario;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
        this.status = status;
    }

    public Usuario() {

    }

    @Override
    public String toString() {
        return "Usuario{" + "codUsuario=" + codUsuario + ", senha=" + senha + ", email=" + email + ", tipo=" + tipo + ", status=" + status + '}';
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}