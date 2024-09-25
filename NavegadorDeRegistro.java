import java.sql.*;
import java.util.*;

public class NavegadorDeRegistro extends TelaDeAtualizacao {
    public static void popularIds() {
        try {
            ArrayList<String> idsTemp = new ArrayList<>();
            idsTemp.add("Selecione aqui o id");
            Connection conexao = MySQLConnector.conectar();
            String strSqlPopularIds = "select * from `db_senac`.`tbl_senac` order by `id` asc;";
            Statement stmSqlPopularIds = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPopularIds = stmSqlPopularIds.executeQuery(strSqlPopularIds);
            while (rstSqlPopularIds.next()) {
                idsTemp.add(rstSqlPopularIds.getString("id"));
            }
            ids = idsTemp.toArray(new String[0]);
            stmSqlPopularIds.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    public static void atualizarId(String id) {
        // ...
    }

    public static void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        txtSenha.setText("");
        // adicionar o código que vai selecionar o primeiro item do combo box
    }

    public static void atualizarCampos(String id) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlAtualizarCampos = "select * from `db_senac`.`tbl_senac` where `id` = " + id + ";";
            Statement stmSqlAtualizarCampos = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlAtualizarCampos = stmSqlAtualizarCampos.executeQuery(strSqlAtualizarCampos);
            if (rstSqlAtualizarCampos.next()) {
                txtNome.setText(rstSqlAtualizarCampos.getString("nome"));
                txtEmail.setText(rstSqlAtualizarCampos.getString("email"));
                txtSenha.setText(rstSqlAtualizarCampos.getString("senha"));
            } else {
                lblNotificacoes.setText("Ops! Não foi encontrado o id selecionado. Por favor, verifique e tente novamente.");
            }
            stmSqlAtualizarCampos.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }
}
