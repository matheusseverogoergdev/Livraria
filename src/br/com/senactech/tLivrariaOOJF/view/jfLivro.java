/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.tLivrariaOOJF.view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.com.senactech.tLivrariaOOJF.model.Livro;
import br.com.senactech.tLivrariaOOJF.services.EditoraServicos;
import br.com.senactech.tLivrariaOOJF.services.LivroServicos;
import br.com.senactech.tLivrariaOOJF.services.ServicosFactory;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static tlivrariaoojf.TLivrariaOOJF.cadEditoras;
import static tlivrariaoojf.TLivrariaOOJF.cadLivros;

/**
 *
 * @author jairb
 */
public class jfLivro extends javax.swing.JFrame {

        JButton btnClick = null;
    
    /**
     * Creates new form jfLivro
     */
    public jfLivro() throws SQLException {
        initComponents();
        addRowToTableBD();
        this.addEditoraJCB();
    }

    public void addEditoraJCB() {
        try {
            jcbEditora.addItem("Selecione");
            //        cadEditoras.getEditora().forEach(listEdt -> {
            //            jcbEditora.addItem(listEdt.getNmEditora());
            //        });

            EditoraServicos editoraS = ServicosFactory.getEditoraServicos();
            editoraS.getEditoras().forEach(listEditora -> {
                jcbEditora.addItem(listEditora.getNmEditora());
            });
            
        } catch (SQLException ex) {
            Logger.getLogger(jfLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

//    public void addRowToTable() {
//        DefaultTableModel model = (DefaultTableModel) jtLivros.getModel();
//        model.getDataVector().removeAllElements();
//        model.fireTableDataChanged();
//        Object rowData[] = new Object[8];//define vetor das colunas
//        for (Livro listLiv : cadLivros.getLivros()) {
//            rowData[0] = listLiv.getIdLivro();
//            rowData[1] = listLiv.getTitulo();
//            rowData[2] = listLiv.getAssunto();
//            rowData[3] = listLiv.getAutor();
//            rowData[4] = listLiv.getIsbn();
//            rowData[5] = listLiv.getEstoque();
//            rowData[6] = listLiv.getPreco();
//            rowData[7] = cadEditoras.getNomeEdt(listLiv.getIdEditora());
//            model.addRow(rowData);
//        }
//
//    }
    
    public void addRowToTableBD() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) jtLivros.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        Object rowData[] = new Object[8];//define vetor das colunas
        LivroServicos livroS = ServicosFactory.getLivroServicos();
        EditoraServicos editoraS = ServicosFactory.getEditoraServicos();
        for (Livro l : livroS.getLivros()) {
            rowData[0] = l.getIdLivro();
            rowData[1] = l.getTitulo();
            rowData[2] = l.getAssunto();
            rowData[3] = l.getAutor();
            rowData[4] = l.getIsbn();
            rowData[5] = l.getEstoque();
            rowData[6] = l.getPreco();
//            rowData[7] = cadEditoras.getNomeEdt(l.getIdEditora());
            rowData[7] = editoraS.getNomeEditora(l.getIdEditora());
            model.addRow(rowData);
        }

    }
    
    public Boolean validaInputs() throws SQLException {
        if (jtfTitulo.getText().isBlank() ||
                jtfAssunto.getText().isBlank() ||
                jtfAutor.getText().isBlank() ||
                jtfISBN.getText().isBlank() ||
                jcbEditora.getSelectedItem().equals("Selecione") ||
                jtfEstoque.getText().isBlank() ||
                jtfPreco.getText().isBlank()) {
            JOptionPane.showMessageDialog(this,
                    "Todos os campos devem ser preenchidos!",
                    ".: Erro :.", JOptionPane.ERROR_MESSAGE);
            jtfTitulo.requestFocus();
            return false;
        }
        
        if (jtfISBN.getText().length() != 10) {
            JOptionPane.showMessageDialog(this,
                    "O ISBN deve conter 10 dígitos!",
                    ".: Erro :.", JOptionPane.ERROR_MESSAGE);
            jtfISBN.requestFocus();
            return false;
        }
        
        // Cria a variável que recebe a soma dos 9 primeiros digitos do ISBN.
        int sum = 0;
        // Laço de repetição pra navegar entre os 9 primeiros digitos do ISBN
        for (int i = 0; i < 9; i++) {
            // Pega o dígito do ISBN de acordo com a posição do i.
            int digit = Character.getNumericValue(jtfISBN.getText().charAt(i));
            
            // Se o dígito for negativo ou maior que 9, retorna erro
            if (0 > digit || 9 < digit) {
                JOptionPane.showMessageDialog(this,
                    "O ISBN deve conter 10 dígitos positivos de 0 até 9!",
                    ".: Erro :.", JOptionPane.ERROR_MESSAGE);
                jtfISBN.requestFocus();
                return false;
            }
            
            // Soma os dígitos multiplicando os por 10 - i.
            sum += (digit * (10 - i));
        }
        
        // Verifica o último dígito
        char lastDigit = jtfISBN.getText().charAt(9);
        
        if (lastDigit != 'X' && (lastDigit < '0' || lastDigit > '9')) {
            JOptionPane.showMessageDialog(this,
                    "O último dígito do ISBN deve ser X ou um número de 0 até 9.",
                    ".: Erro :.", JOptionPane.ERROR_MESSAGE);
                jtfISBN.requestFocus();
            return false;
        }

        // Se o último dígito for 'X', adiciona 10 a soma,
        // do contrário adiciona seu valor
        sum += ((lastDigit == 'X') ? 10 : lastDigit);
        
        // Retorna true se a soma dos dígitos for divisível por 11.
        if (sum % 11 != 0) {
            JOptionPane.showMessageDialog(this,
                    "A soma ponderada do ISBN deve ser divisível por 11.",
                    ".: Erro :.", JOptionPane.ERROR_MESSAGE);
                jtfISBN.requestFocus();
            return false;
        }
        
        if (btnClick.getText() == "Salvar") {
            LivroServicos livroS = ServicosFactory.getLivroServicos();
            if (livroS.verificaLivro(jtfISBN.getText())) {
                JOptionPane.showMessageDialog(this,
                            "ISBN já cadastrado!!!",
                            ".: Erro :.", JOptionPane.ERROR_MESSAGE);
                jtfISBN.requestFocus();
                return false;
            }
        }
        
        return true;
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
        jcbEditora = new javax.swing.JComboBox<>();
        jbSalvar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfTitulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLivros = new javax.swing.JTable();
        jtfAssunto = new javax.swing.JTextField();
        jtfAutor = new javax.swing.JTextField();
        jtfISBN = new javax.swing.JTextField();
        jtfEstoque = new javax.swing.JTextField();
        jtfPreco = new javax.swing.JTextField();
        jbLimpar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbConfirmar = new javax.swing.JButton();
        jbDeletar = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cadastro de Livro");

        jLabel1.setText("Titulo Livro");

        jLabel3.setText("Assunto");

        jLabel4.setText("Autor");

        jLabel5.setText("ISBN");

        jLabel6.setText("Estoque");

        jLabel7.setText("Preço");

        jLabel8.setText("Editora");

        jtfTitulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfTituloFocusLost(evt);
            }
        });
        jtfTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfTituloMouseExited(evt);
            }
        });
        jtfTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTituloKeyTyped(evt);
            }
        });

        jtLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Titulo", "Assunto", "Autor", "ISBN", "Estoque", "Preço", "Editora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtLivrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtLivros);

        jtfAssunto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfAssuntoFocusLost(evt);
            }
        });
        jtfAssunto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfAssuntoMouseExited(evt);
            }
        });
        jtfAssunto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAssuntoKeyTyped(evt);
            }
        });

        jtfAutor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfAutorFocusLost(evt);
            }
        });
        jtfAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfAutorMouseExited(evt);
            }
        });
        jtfAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAutorKeyTyped(evt);
            }
        });

        jtfISBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfISBNKeyTyped(evt);
            }
        });

        jtfEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfEstoqueKeyTyped(evt);
            }
        });

        jtfPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfPrecoKeyTyped(evt);
            }
        });

        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

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
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfAssunto))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtfISBN))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jcbEditora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jbSalvar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbLimpar))))
                            .addComponent(jtfAutor)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSair)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtfAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar)
                    .addComponent(jbLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEditar)
                    .addComponent(jbConfirmar)
                    .addComponent(jbDeletar)
                    .addComponent(jbSair))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        // TODO add your handling code here:
        btnClick = (JButton) evt.getSource();
        
        try {
            if (validaInputs()) {
                int idLivro = cadLivros.addIdLiv();
                String titulo = jtfTitulo.getText();
                String autor = jtfAutor.getText();
                String assunto = jtfAssunto.getText();
                String isbn = jtfISBN.getText();
                int estoque = Integer.parseInt(jtfEstoque.getText());
                float preco = Float.parseFloat(jtfPreco.getText());
                System.out.println(jcbEditora.getSelectedItem().toString());
//                int idEditora = jcbEditora.getSelectedIndex();

                EditoraServicos editoraS = ServicosFactory.getEditoraServicos();
                

                int idEditora = editoraS.buscarEditora(jcbEditora.getSelectedItem().toString()).getIdEditora();
    
                System.out.println(idEditora);
                
                Livro l = new Livro(idLivro, titulo, autor, assunto, isbn,
                        estoque, preco, idEditora);
                LivroServicos livroS = ServicosFactory.getLivroServicos();
                
                try {
                    livroS.cadLivro(l);
                    addRowToTableBD();
                    jbLimpar.doClick();
                    JOptionPane.showMessageDialog(this, "Livro foi salvo com sucesso!");
                } catch(SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Erro! " + ex.getMessage(),
                        "erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch(SQLException ex) {
            Logger.getLogger(jfLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        // TODO add your handling code here:
        jtfTitulo.setText("");
        jtfAssunto.setText("");
        jtfAutor.setText("");
        jtfISBN.setText("");
        jtfEstoque.setText("");
        jtfPreco.setText("");
        jcbEditora.setSelectedIndex(0);
        
        jtfISBN.setEnabled(true);
        jbSalvar.setEnabled(true);
        jbEditar.setEnabled(false);
        jbConfirmar.setEnabled(false);
        jbDeletar.setEnabled(false);
        
        jTableFilterClear();
    }//GEN-LAST:event_jbLimparActionPerformed

    public void jTableFilterClear() {
        DefaultTableModel model = (DefaultTableModel) jtLivros.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        jtLivros.setRowSorter(sorter);
        sorter.setRowFilter(null);
    }
    
    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        // TODO add your handling code here:
        try {
            jbDeletar.setEnabled(false);
            jbSalvar.setEnabled(false);
            jbEditar.setEnabled(false);
            jtfISBN.setEnabled(false);
            jbConfirmar.setEnabled(true);
            jbLimpar.setText("Cancelar");
            
            int linha = jtLivros.getSelectedRow();
            String isbn = (String) jtLivros.getValueAt(linha, 4);
            LivroServicos livroS = ServicosFactory.getLivroServicos();
            
            Livro l = livroS.buscarLivroBD(isbn);
            
            jtfTitulo.setText(l.getTitulo());
            jtfAssunto.setText(l.getAssunto());
            jtfAutor.setText(l.getAutor());
            jtfISBN.setText(l.getIsbn());
            jtfEstoque.setText(Integer.toString(l.getEstoque()));
            jtfPreco.setText(Float.toString(l.getPreco()));
//            jcbEditora.setSelectedIndex(l.getIdEditora());
            EditoraServicos editoraS = ServicosFactory.getEditoraServicos();
            jcbEditora.setSelectedItem(editoraS.getNomeEditora(l.getIdEditora()));
            
        } catch(SQLException ex) {
            Logger.getLogger(jfLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
            try {
                // TODO add your handling code here:
                btnClick = (JButton) evt.getSource();
                if (validaInputs()) {
                    LivroServicos livroS = ServicosFactory.getLivroServicos();
                    Livro l = livroS.buscarLivroBD(jtfISBN.getText());
                    
                    System.out.println(l.toString());
                    
                    l.setTitulo(jtfTitulo.getText());
                    l.setAssunto(jtfAssunto.getText());
                    l.setAutor(jtfAutor.getText());
                    l.setEstoque(Integer.parseInt(jtfEstoque.getText()));
                    l.setIsbn(jtfISBN.getText());
                    l.setPreco(Float.parseFloat(jtfPreco.getText()));
                    
                    EditoraServicos editoraS = ServicosFactory.getEditoraServicos();
                    l.setIdEditora(editoraS.buscarEditora(jcbEditora.getSelectedItem().toString()).getIdEditora());
                
                    System.out.println(l.toString());
                    
                    livroS.atualizarLivro(l);
                    addRowToTableBD();
                    
                    jbLimpar.doClick();
                    jbLimpar.setText("Limpar");
                
                    JOptionPane.showMessageDialog(this, "Livro atualizado com sucesso!");
                    
                } else {
                    jbLimpar.doClick();
                    jtfISBN.setEnabled(true);
                }   
            } catch (SQLException ex) {
                Logger.getLogger(jfLivro.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jbConfirmarActionPerformed

    private void jbDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jbDeletarActionPerformed

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbSairActionPerformed

    private void jtLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtLivrosMouseClicked
        // TODO add your handling code here:
        jbDeletar.setEnabled(true);
        jbEditar.setEnabled(true);
    }//GEN-LAST:event_jtLivrosMouseClicked

    private void jtfISBNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfISBNKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321Xx";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        
        if ((jtfISBN.getText() + evt.getKeyChar()).length() > 10) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfISBNKeyTyped

    private void jtfEstoqueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEstoqueKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfEstoqueKeyTyped

    private void jtfPrecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPrecoKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfPrecoKeyTyped

    private void jtfAutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAutorKeyTyped
        // TODO add your handling code here:
        String caracteres = "' ";
        
        if (!Character.isAlphabetic(evt.getKeyChar())
                && !caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        
        if ((jtfAutor.getText() + evt.getKeyChar()).length() > 60) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfAutorKeyTyped

    private void jtfAssuntoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAssuntoKeyTyped
        // TODO add your handling code here:
        String caracteres = ",' ";
        
        if (!Character.isAlphabetic(evt.getKeyChar())
                && !caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        
        if ((jtfAssunto.getText() + evt.getKeyChar()).length() > 100) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfAssuntoKeyTyped

    private void jtfAutorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfAutorMouseExited
        // TODO add your handling code here:
        jtfAutor.setText(jtfAutor.getText().toUpperCase().trim().replaceAll(" +", " "));
    }//GEN-LAST:event_jtfAutorMouseExited

    private void jtfAutorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfAutorFocusLost
        // TODO add your handling code here:
        jtfAutor.setText(jtfAutor.getText().toUpperCase().trim().replaceAll(" +", " "));
    }//GEN-LAST:event_jtfAutorFocusLost

    private void jtfTituloMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfTituloMouseExited
        // TODO add your handling code here:
        jtfTitulo.setText(jtfTitulo.getText().toUpperCase().trim().replaceAll(" +", " "));
    }//GEN-LAST:event_jtfTituloMouseExited

    private void jtfTituloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfTituloFocusLost
        // TODO add your handling code here:
        jtfTitulo.setText(jtfTitulo.getText().toUpperCase().trim().replaceAll(" +", " "));
    }//GEN-LAST:event_jtfTituloFocusLost

    private void jtfAssuntoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfAssuntoMouseExited
        // TODO add your handling code here:
        jtfAssunto.setText(jtfAssunto.getText().toUpperCase().trim().replaceAll(" +", " "));
    }//GEN-LAST:event_jtfAssuntoMouseExited

    private void jtfAssuntoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfAssuntoFocusLost
        // TODO add your handling code here:
        jtfAssunto.setText(jtfAssunto.getText().toUpperCase().trim().replaceAll(" +", " "));
    }//GEN-LAST:event_jtfAssuntoFocusLost

    private void jtfTituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTituloKeyTyped
        // TODO add your handling code here:
        if ((jtfTitulo.getText() + evt.getKeyChar()).length() > 60) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfTituloKeyTyped

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
            java.util.logging.Logger.getLogger(jfLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jfLivro().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(jfLivro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbDeletar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSair;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox<String> jcbEditora;
    private javax.swing.JTable jtLivros;
    private javax.swing.JTextField jtfAssunto;
    private javax.swing.JTextField jtfAutor;
    private javax.swing.JTextField jtfEstoque;
    private javax.swing.JTextField jtfISBN;
    private javax.swing.JTextField jtfPreco;
    private javax.swing.JTextField jtfTitulo;
    // End of variables declaration//GEN-END:variables
}
