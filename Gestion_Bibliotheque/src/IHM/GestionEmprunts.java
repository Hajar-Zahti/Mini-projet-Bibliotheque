package IHM;

import Utility.BibalExceptions;
import Utility.DBConnection;
import controllers.EmpruntControl;
import controllers.UsagerControl;

import static Utility.Utility.closeStatementResultSet;
import static Utility.Utility.initialiseRequetePreparee;
import static Utility.Utility.showMessageSucces;

import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import Entites.Usager;

import static java.lang.Integer.parseInt;
import java.awt.Color;
import java.awt.Font;
/**
 * 
 * @author Diallo & Janati
 */
public class GestionEmprunts extends javax.swing.JDialog {

    /**
     * @wbp.parser.constructor
     */
    public GestionEmprunts(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIdentifiant();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bibliotheque_icone.png")));
    }

    public GestionEmprunts(java.awt.Frame parent, boolean modal, String titre) {
        this(parent, modal);
        this.titre = titre;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        panAjoutBas = new javax.swing.JPanel();
        nomLabel = new javax.swing.JLabel();
        identifiantLabel = new javax.swing.JLabel();
        identifiantUsagerCombo = new javax.swing.JComboBox();
        validerBouton = new javax.swing.JButton();
        annulerBouton = new javax.swing.JButton();
        nomUsagerLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Emprunter");

        jPanel1.setBackground(new Color(192, 192, 192));
        jPanel1.setName("Gestion personnel"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1162, 608));
        jPanel1.setRequestFocusEnabled(false);

        titleLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30)); // NOI18N
        titleLabel.setForeground(new Color(0, 64, 128));
        titleLabel.setText("Choisir Usager");

        panAjoutBas.setBackground(new Color(192, 192, 192));
        panAjoutBas.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        nomLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nomLabel.setForeground(new Color(0, 0, 0));
        nomLabel.setText("Nom usager");

        identifiantLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        identifiantLabel.setForeground(new Color(0, 0, 0));
        identifiantLabel.setText("Identifiant ");

        identifiantUsagerCombo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        identifiantUsagerCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir identifiant" }));
        identifiantUsagerCombo.setPreferredSize(new java.awt.Dimension(123, 26));
        identifiantUsagerCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identifiantUsagerComboActionPerformed(evt);
            }
        });

        validerBouton.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        validerBouton.setText("Valider");
        validerBouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emprunter(evt);
            }
        });

        annulerBouton.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        annulerBouton.setText("Annuler");
        annulerBouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerBoutonActionPerformed(evt);
            }
        });

        nomUsagerLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        nomUsagerLabel.setText(" ");

        javax.swing.GroupLayout panAjoutBasLayout = new javax.swing.GroupLayout(panAjoutBas);
        panAjoutBas.setLayout(panAjoutBasLayout);
        panAjoutBasLayout.setHorizontalGroup(
            panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAjoutBasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAjoutBasLayout.createSequentialGroup()
                        .addGap(0, 169, Short.MAX_VALUE)
                        .addComponent(annulerBouton)
                        .addGap(30, 30, 30)
                        .addComponent(validerBouton))
                    .addGroup(panAjoutBasLayout.createSequentialGroup()
                        .addGroup(panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nomLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(identifiantLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(62, 62, 62)
                        .addGroup(panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(identifiantUsagerCombo, 0, 230, Short.MAX_VALUE)
                            .addComponent(nomUsagerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panAjoutBasLayout.setVerticalGroup(
            panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAjoutBasLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identifiantLabel)
                    .addComponent(identifiantUsagerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomLabel)
                    .addComponent(nomUsagerLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(annulerBouton)
                    .addComponent(validerBouton))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panAjoutBas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addComponent(panAjoutBas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void identifiantUsagerComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identifiantUsagerComboActionPerformed
        try {
            int usagerId = getUsagerID();
            if (usagerId != -1) {
                Usager usager = UsagerControl.findById(usagerId);
                if (null != usager) {
                    String nom = usager.getNom() + " " + usager.getPrenom();
                    nomUsagerLabel.setText(nom);
                }
            }
        } catch (BibalExceptions e) {
            System.out.println("IHM.Emprunter.identifiantUsagerComboActionPerformed()");
        }
    }//GEN-LAST:event_identifiantUsagerComboActionPerformed

    private void emprunter(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emprunter

        try {
            int usagerId = getUsagerID();
            if (usagerId != -1) {
                EmpruntControl.emprunter(usagerId, titre);
                showMessageSucces("Emprunt enregistré");
            } else {
                showMessageSucces("Veuillez choisir un identifiant");
            }
        } catch (BibalExceptions e) {
            System.out.println("IHM.Emprunter.validerBoutonActionPerformed()");
        }
    }//GEN-LAST:event_emprunter

    private void annulerBoutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerBoutonActionPerformed
        this.dispose();
    }//GEN-LAST:event_annulerBoutonActionPerformed

    private int getUsagerID() {
        String id = identifiantUsagerCombo.getSelectedItem().toString();
        if (!id.equals("Choisir identifiant")) {
            return parseInt(id);
        }
        return -1;
    }

    private void setIdentifiant() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            final String SQL_SELECT_ID = "SELECT id FROM usager ";
            preparedStatement = initialiseRequetePreparee(DBConnection.getConnection(),
                    SQL_SELECT_ID, new Object[0]);
            resultSet = preparedStatement.executeQuery();
            int identifiant;
            while (resultSet.next()) {
                identifiant = resultSet.getInt("id");
                identifiantUsagerCombo.addItem(Integer.toString(identifiant));
            }
        } catch (SQLException | BibalExceptions e) {
            JOptionPane.showMessageDialog(null, "Erreurs d'accès à la base de données",
                    "Erreurs", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeStatementResultSet(preparedStatement, resultSet);
        }
    }

    private String titre;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annulerBouton;
    private javax.swing.JLabel identifiantLabel;
    private javax.swing.JComboBox identifiantUsagerCombo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JLabel nomUsagerLabel;
    private javax.swing.JPanel panAjoutBas;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton validerBouton;
    // End of variables declaration//GEN-END:variables
}
