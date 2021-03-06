/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.tLivrariaOOJF.view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.com.senactech.tLivrariaOOJF.model.Cliente;
import br.com.senactech.tLivrariaOOJF.services.ClienteServicos;
import br.com.senactech.tLivrariaOOJF.services.ServicosFactory;
import br.com.senactech.tLivrariaOOJF.util.ValidaCPF;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static tlivrariaoojf.TLivrariaOOJF.cadClientes;

/**
 *
 * @author jairb
 */
public class jfCliente extends javax.swing.JFrame {

    /**
     * Creates new form jfCliente
     */
    public jfCliente() throws SQLException {
        initComponents();
        addRowToTableBD();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgCpfCnpj = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jrbCpf = new javax.swing.JRadioButton();
        jrbCnpj = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfNomeCliente = new javax.swing.JTextField();
        jtfCpfCnpj = new javax.swing.JTextField();
        jtfEndereco = new javax.swing.JTextField();
        jtfTelefone = new javax.swing.JTextField();
        jbSalvar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();
        jbEditar = new javax.swing.JButton();
        jbConfirmar = new javax.swing.JButton();
        jbDeletar = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Cliente");

        jLabel2.setText("Nome Cliente:");

        bgCpfCnpj.add(jrbCpf);
        jrbCpf.setText("CPF");
        jrbCpf.setToolTipText("");

        bgCpfCnpj.add(jrbCnpj);
        jrbCnpj.setText("CNPJ");

        jLabel4.setText("Endere??o:");

        jLabel5.setText("Telefone:");

        jtfNomeCliente.setToolTipText("");
        jtfNomeCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNomeClienteFocusLost(evt);
            }
        });
        jtfNomeCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfNomeClienteMouseExited(evt);
            }
        });
        jtfNomeCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNomeClienteKeyTyped(evt);
            }
        });

        jtfCpfCnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCpfCnpjFocusLost(evt);
            }
        });
        jtfCpfCnpj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfCpfCnpjMouseExited(evt);
            }
        });
        jtfCpfCnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCpfCnpjKeyTyped(evt);
            }
        });

        jtfEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfEnderecoFocusLost(evt);
            }
        });
        jtfEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfEnderecoMouseExited(evt);
            }
        });
        jtfEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfEnderecoKeyTyped(evt);
            }
        });

        jtfTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfTelefoneFocusLost(evt);
            }
        });
        jtfTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfTelefoneMouseExited(evt);
            }
        });
        jtfTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTelefoneKeyTyped(evt);
            }
        });

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idCliente", "Nome", "CPF", "CNPJ", "Telefone", "Endere??o"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtClientes.setToolTipText("");
        jtClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtClientes);
        jtClientes.getAccessibleContext().setAccessibleName("");

        jbEditar.setText("Editar");
        jbEditar.setEnabled(false);
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbConfirmar.setText("Confirmar");
        jbConfirmar.setEnabled(false);
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        jbDeletar.setText("Deletar");
        jbDeletar.setEnabled(false);
        jbDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletarActionPerformed(evt);
            }
        });

        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbCpf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbCnpj))
                            .addComponent(jLabel4))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNomeCliente)
                            .addComponent(jtfEndereco)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(16, 16, 16)
                                .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jbSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbLimpar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jbEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbConfirmar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbDeletar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbSair)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbCpf)
                    .addComponent(jrbCnpj)
                    .addComponent(jtfCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar)
                    .addComponent(jbLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEditar)
                    .addComponent(jbConfirmar)
                    .addComponent(jbDeletar)
                    .addComponent(jbSair))
                .addContainerGap())
        );

        jtfNomeCliente.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        // TODO add your handling code here:
        jtfNomeCliente.setText("");
        jtfCpfCnpj.setText("");
        jtfEndereco.setText("");
        jtfTelefone.setText("");
        bgCpfCnpj.clearSelection();
        jtfNomeCliente.requestFocus();
        
        jtfCpfCnpj.setEnabled(true);
        jbSalvar.setEnabled(true);
        jbEditar.setEnabled(false);
        jbConfirmar.setEnabled(false);
        jbDeletar.setEnabled(false);
        
        jTableFilterClear();
    }//GEN-LAST:event_jbLimparActionPerformed

    public void jTableFilterClear() {
        DefaultTableModel model = (DefaultTableModel) jtClientes.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        jtClientes.setRowSorter(sorter);
        sorter.setRowFilter(null);
    }
        
    
    public void addRowToTableBD() throws SQLException {
        //Cria obj model e recebe a modelagem da tabela JtPessoa do JFrame
        DefaultTableModel model = (DefaultTableModel) jtClientes.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        Object rowData[] = new Object[6]; //cria vetor para as colunas da tabela
        ClienteServicos clienteS = ServicosFactory.getClienteServicos();
        for (Cliente c : clienteS.getClientes()) {
            rowData[0] = c.getIdCliente();
            rowData[1] = c.getNomeCliente();
            rowData[2] = c.getCpf();
            rowData[3] = c.getCnpj();
            rowData[4] = c.getTelefone();
            rowData[5] = c.getEndereco();
            model.addRow(rowData);
        }
    }
    
    public Boolean validaInputs() throws SQLException {
        String telefone = jtfTelefone.getText();
        
        if (jtfNomeCliente.getText().isEmpty() ||
                jtfTelefone.getText().isEmpty() ||
                jtfEndereco.getText().isEmpty() ||
                jtfCpfCnpj.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Todos os campos devem ser preenchidos!",
                    ".: Erro :.", JOptionPane.ERROR_MESSAGE);
            jtfNomeCliente.requestFocus();
            return false;
        }
        
        if (telefone.length() < 14) {
            JOptionPane.showMessageDialog(this,
                    "Telefone informado esta incorreto",
                    ".: Erro :.", JOptionPane.ERROR_MESSAGE);
            jtfTelefone.requestFocus();
            return false;
        }
        
        if (!jrbCpf.isSelected() && !jrbCnpj.isSelected()) {
            JOptionPane.showMessageDialog(this,
                    "Selecione o CPF ou o CNPJ.",
                    ".: Erro :.", JOptionPane.ERROR_MESSAGE);
            jrbCpf.requestFocus();
            return false;
        }
        
        ClienteServicos clienteS = ServicosFactory.getClienteServicos();
        if (jrbCpf.isSelected()) {
            String cpf = jtfCpfCnpj.getText();
            
            if (!ValidaCPF.isCPF(cpf)) {
                JOptionPane.showMessageDialog(this,
                        "CPF informado esta incorreto!!!",
                        ".: Erro :.", JOptionPane.ERROR_MESSAGE);
                jtfCpfCnpj.requestFocus();
                return false;
            
            }
//            else {;
//                if (clienteS.verCPF(cpf)) {
//                    JOptionPane.showMessageDialog(this,
//                        "CPF informado j?? est?? em uso!",
//                        ".: Erro :.", JOptionPane.ERROR_MESSAGE);
//                    jtfCpfCnpj.requestFocus();
//                    return false;
//                }
//            }
        }
        
        return true;
    }
    
    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            // TODO add your handling code here:
            if (validaInputs()) {
                int id = cadClientes.addIdCli();
                String nomeCliente = jtfNomeCliente.getText();
                String cpf = "";
                String cnpj = "";
                if (jrbCpf.isSelected()) {
                    cpf = jtfCpfCnpj.getText();
                } else {
                    cnpj = jtfCpfCnpj.getText();
                }
                String telefone = jtfTelefone.getText();
                String endereco = jtfEndereco.getText();
                
                Cliente c = new Cliente(id, nomeCliente, cpf, endereco, telefone, cnpj);
                ClienteServicos clienteS = ServicosFactory.getClienteServicos();
                
                try {
                    clienteS.cadCliente(c);
                    addRowToTableBD();
                    jbLimpar.doClick();
                    JOptionPane.showMessageDialog(this, "Cliente foi salvo com sucesso!");
                } catch(SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Erro! " + ex.getMessage(),
                        "erro", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        // TODO add your handling code here:
        try {
            jbDeletar.setEnabled(false);
            jbSalvar.setEnabled(false);
            jbEditar.setEnabled(false);
            jtfCpfCnpj.setEnabled(false);
            jbConfirmar.setEnabled(true);
            jbLimpar.setText("Cancelar");
            
            int linha;
            String cpfCnpj;
            linha = jtClientes.getSelectedRow();
            ClienteServicos clienteS = ServicosFactory.getClienteServicos();
            Cliente c = new Cliente();
            if (!((String) jtClientes.getValueAt(linha, 2)).isBlank()) {
                cpfCnpj = (String) jtClientes.getValueAt(linha, 2);
                c = clienteS.buscarClienteBD(cpfCnpj);
                jtfCpfCnpj.setText(c.getCpf());
                jrbCpf.setSelected(true);
                jrbCnpj.setSelected(false);
            } else if (!((String) jtClientes.getValueAt(linha, 3)).isBlank()) {
                cpfCnpj = (String) jtClientes.getValueAt(linha, 3);
                c = clienteS.buscarClienteCnpjBD(cpfCnpj);
                jtfCpfCnpj.setText(c.getCnpj());
                jrbCpf.setSelected(false);
                jrbCnpj.setSelected(true);
            } else {
                System.out.println("Cpf e Cnpj n??o foram preenchidos.");
            }
            
            jtfNomeCliente.setText(c.getNomeCliente());
            jtfEndereco.setText(c.getEndereco());
            jtfTelefone.setText(c.getTelefone());
            
        } catch(SQLException ex) {
            Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jtClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClientesMouseClicked
        // TODO add your handling code here:
        jbDeletar.setEnabled(true);
        jbEditar.setEnabled(true);
    }//GEN-LAST:event_jtClientesMouseClicked

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbSairActionPerformed

    private void jbDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarActionPerformed
        // TODO add your handling code here:
        try {
            jbEditar.setEnabled(false);
            int linha;
            String cpfCnpj;
            linha = jtClientes.getSelectedRow();
            ClienteServicos clienteS = ServicosFactory.getClienteServicos();
            Cliente c = new Cliente();

            if (!((String) jtClientes.getValueAt(linha, 2)).isBlank()) {
                cpfCnpj = (String) jtClientes.getValueAt(linha, 2);
                c = clienteS.buscarClienteBD(cpfCnpj);
            } else if (!((String) jtClientes.getValueAt(linha, 3)).isBlank()) {
                cpfCnpj = (String) jtClientes.getValueAt(linha, 3);
                c = clienteS.buscarClienteCnpjBD(cpfCnpj);
                System.out.println(c);
            } else {
                System.out.println("Cpf e Cnpj n??o foram preenchidos.");
            }
            
            Object[] resp = {"Sim", "N??o"};
            int resposta = JOptionPane.showOptionDialog(this,
                "Deseja realmente deletar " + c.getNomeCliente() + "?",
                ".: Deletar :.", JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE, null, resp, resp[0]);
            
            if (resposta == 0) {
                try {
                    clienteS.deletarCliente(c.getIdCliente());
                    addRowToTableBD();
                    JOptionPane.showMessageDialog(this, "Cliente deletado com sucesso!",
                    ".: Deletar :.", JOptionPane.INFORMATION_MESSAGE);
                } catch(SQLException ex) {
                    Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Entendemos sua decis??o!",
                    ".: Deletar :.", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch(SQLException ex) {
            Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            jbDeletar.setEnabled(false);
        }
    }//GEN-LAST:event_jbDeletarActionPerformed

    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        try {
            // TODO add your handling code here:
            if (validaInputs()) {
                ClienteServicos clienteS = ServicosFactory.getClienteServicos();
                Cliente c = new Cliente();
                String cpfCnpj = jtfCpfCnpj.getText();
                if (jrbCpf.isSelected() && !cpfCnpj.isBlank()) {
                    c = clienteS.buscarClienteBD(cpfCnpj);
                    c.setCpf(cpfCnpj);
                } else if (jrbCnpj.isSelected() && !cpfCnpj.isBlank()) {
                    c = clienteS.buscarClienteCnpjBD(cpfCnpj);
                    c.setCnpj(cpfCnpj);
                } else {
                    System.out.println("Cpf e Cnpj n??o foram preenchidos.");
                }
                
                c.setEndereco(jtfEndereco.getText());
                c.setNomeCliente(jtfNomeCliente.getText());
                c.setTelefone(jtfTelefone.getText());
                
                clienteS.atualizarCliente(c);
                addRowToTableBD();
                
                jbLimpar.doClick();
                jbLimpar.setText("Limpar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbConfirmarActionPerformed

    private void jtfNomeClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeClienteKeyTyped
        // TODO add your handling code here:
        String caracteres = "' ";
        
        if (!Character.isAlphabetic(evt.getKeyChar())
                && !caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        
        if ((jtfNomeCliente.getText() + evt.getKeyChar()).length() > 60) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfNomeClienteKeyTyped

    private void jtfCpfCnpjKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCpfCnpjKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321/- ";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        
        if ((jtfCpfCnpj.getText() + evt.getKeyChar()).length() > 20) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfCpfCnpjKeyTyped

    private void jtfTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelefoneKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321()- ";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        
        if ((jtfTelefone.getText() + evt.getKeyChar()).length() > 20) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfTelefoneKeyTyped

    private void jtfEnderecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEnderecoKeyTyped
        // TODO add your handling code here:
        String caracteres = "0123456789????-' ";
        
        if (!Character.isAlphabetic(evt.getKeyChar())
                && !caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        
        if ((jtfEndereco.getText() + evt.getKeyChar()).length() > 100) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfEnderecoKeyTyped

    private void jtfNomeClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNomeClienteFocusLost
        // TODO add your handling code here:
        jtfNomeCliente.setText(jtfNomeCliente.getText().toUpperCase().trim().replaceAll(" +", " "));
    }//GEN-LAST:event_jtfNomeClienteFocusLost

    private void jtfNomeClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfNomeClienteMouseExited
        // TODO add your handling code here:
        jtfNomeCliente.setText(jtfNomeCliente.getText().toUpperCase().trim().replaceAll(" +", " "));
    }//GEN-LAST:event_jtfNomeClienteMouseExited

    private void jtfCpfCnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCpfCnpjFocusLost
        // TODO add your handling code here:
        jtfCpfCnpj.setText(jtfCpfCnpj.getText().toUpperCase().trim().replaceAll(" +", " "));
    }//GEN-LAST:event_jtfCpfCnpjFocusLost

    private void jtfCpfCnpjMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfCpfCnpjMouseExited
        // TODO add your handling code here:
        jtfCpfCnpj.setText(jtfCpfCnpj.getText().toUpperCase().trim().replaceAll(" +", " "));
    }//GEN-LAST:event_jtfCpfCnpjMouseExited

    private void jtfTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfTelefoneFocusLost
        // TODO add your handling code here:
        jtfTelefone.setText(jtfTelefone.getText().toUpperCase().trim().replaceAll(" +", " "));
    }//GEN-LAST:event_jtfTelefoneFocusLost

    private void jtfTelefoneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfTelefoneMouseExited
        // TODO add your handling code here:
        jtfTelefone.setText(jtfTelefone.getText().toUpperCase().trim().replaceAll(" +", " "));
    }//GEN-LAST:event_jtfTelefoneMouseExited

    private void jtfEnderecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfEnderecoFocusLost
        // TODO add your handling code here:
        jtfEndereco.setText(jtfEndereco.getText().toUpperCase().trim().replaceAll(" +", " "));
    }//GEN-LAST:event_jtfEnderecoFocusLost

    private void jtfEnderecoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfEnderecoMouseExited
        // TODO add your handling code here:
        jtfEndereco.setText(jtfEndereco.getText().toUpperCase().trim().replaceAll(" +", " "));
    }//GEN-LAST:event_jtfEnderecoMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jfCliente().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgCpfCnpj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbDeletar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSair;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JRadioButton jrbCnpj;
    private javax.swing.JRadioButton jrbCpf;
    private javax.swing.JTable jtClientes;
    private javax.swing.JTextField jtfCpfCnpj;
    private javax.swing.JTextField jtfEndereco;
    private javax.swing.JTextField jtfNomeCliente;
    private javax.swing.JTextField jtfTelefone;
    // End of variables declaration//GEN-END:variables

}
