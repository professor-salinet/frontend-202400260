import java.sql.*;

public class NavegadorDeRegistro extends TelaDePesquisa {
    public static void pesquisar() {
        try {
            txtId.setText("");
            txtNome.setText("");
            txtEmail.setText("");
            btnPrimeiro.setEnabled(false);
            btnAnterior.setEnabled(false);
            btnProximo.setEnabled(false);
            btnUltimo.setEnabled(false);
            if (txtPesquisa.getText().trim().equals(txtUsuario) == false) {
                Connection conexao = MySQLConnector.conectar();
                String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%';";
                Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
                if (rstSqlPesquisa.next()) {
                    rstSqlPesquisa.last();
                    int rowNumbers = rstSqlPesquisa.getRow();
                    rstSqlPesquisa.first();

                    lblNotificacoes.setText(setHtmlFormat("Legal! Foi(Foram) encontrado(s) " + rowNumbers + " resultado(s)."));
                    txtId.setText(rstSqlPesquisa.getString("id"));
                    txtNome.setText(rstSqlPesquisa.getString("nome"));
                    txtEmail.setText(rstSqlPesquisa.getString("email"));
                    txtUsuario = txtPesquisa.getText();
                    btnPesquisar.setEnabled(false);
                    if (rowNumbers > 1) {
                        btnProximo.setEnabled(true);
                        btnUltimo.setEnabled(true);
                    }
                } else {
                    txtUsuario = txtPesquisa.getText();
                    btnPesquisar.setEnabled(false);
                    lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + txtPesquisa.getText() + "\"."));
                }
                stmSqlPesquisa.close();
            }
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }
}
