import java.sql.*;

public class NavegadorDeRegistro extends TelaDePesquisa {
    public static void pesquisar() {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%';";
            Statement stmSqlPesquisa = conexao.createStatement();
            ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
            if (rstSqlPesquisa.next()) {
                lblNotificacoes.setText(setHtmlFormat("Legal! Foi(Foram) encontrado(s) resultado(s)."));
                txtId.setText(rstSqlPesquisa.getString("id"));
                txtNome.setText(rstSqlPesquisa.getString("nome"));
                txtEmail.setText(rstSqlPesquisa.getString("email"));
            } else {
                lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + txtPesquisa.getText() + "\"."));
            }
            stmSqlPesquisa.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }
}
