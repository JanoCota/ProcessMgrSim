package processmgrsim;

import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import processmgrsim.manager.BiggestSizePolicy;
import processmgrsim.manager.FifoPolicy;
import processmgrsim.manager.ManagerWithPolicy;
import processmgrsim.manager.PlannerPolicy;
import processmgrsim.manager.Process;
import processmgrsim.manager.SmallestSizePolicy;

/**
 *
 * @author janoc
 */
public class UI extends javax.swing.JFrame {

    private final int AVAILABLE_COLORS = 100;
    private final ManagerWithPolicy p;
    private final PlannerPolicy policy;
    private final MemoryPainter g;
    private int PID;
    private DefaultTableModel tbl;

    public UI() {
        this.policy = getPolicy();
        initComponents();
        g = new MemoryPainter(memCanvas, AVAILABLE_COLORS);
        p = new ManagerWithPolicy(memCanvas.getHeight());
        tbl = (DefaultTableModel) jTable1.getModel();
        PID = 1000;
        lblPolicy.setText("Política: " + policy.getName());
        updateUI();
        g.drawWatermark();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        memCanvas = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtSize = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnStartProc = new javax.swing.JButton();
        lblAvailSize = new javax.swing.JLabel();
        lblProcCount = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnKill = new javax.swing.JButton();
        cb1 = new javax.swing.JComboBox<>();
        btnExecAll = new javax.swing.JButton();
        btnExecNext = new javax.swing.JButton();
        lblPolicy = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador de memoria");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        memCanvas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        memCanvas.setPreferredSize(new java.awt.Dimension(200, 400));

        javax.swing.GroupLayout memCanvasLayout = new javax.swing.GroupLayout(memCanvas);
        memCanvas.setLayout(memCanvasLayout);
        memCanvasLayout.setHorizontalGroup(
            memCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        memCanvasLayout.setVerticalGroup(
            memCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Nuevo proceso"));

        txtSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSizeKeyPressed(evt);
            }
        });

        jLabel1.setText("Tamaño");

        btnStartProc.setText("Iniciar");
        btnStartProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartProcActionPerformed(evt);
            }
        });

        lblAvailSize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvailSize.setText("lblAvailSize");

        lblProcCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProcCount.setText("lblProcCount");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSize, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStartProc, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblAvailSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProcCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnStartProc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAvailSize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProcCount)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Terminar proceso"));

        btnKill.setText("Matar");
        btnKill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKillActionPerformed(evt);
            }
        });

        btnExecAll.setText("Ejecutar todos los procesos cargados");
        btnExecAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecAllActionPerformed(evt);
            }
        });

        btnExecNext.setText("Ejecutar siguiente proceso");
        btnExecNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecNextActionPerformed(evt);
            }
        });

        lblPolicy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPolicy.setText("lblPolicy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cb1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKill, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnExecAll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExecNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPolicy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPolicy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExecNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExecAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKill)
                    .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PID", "T. llegada", "Tamaño", "T. carga", "T. descarga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(memCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(memCanvas, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        memCanvas.getAccessibleContext().setAccessibleDescription("");

        getAccessibleContext().setAccessibleDescription("Simulador de administrador de memoria por procesos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartProcActionPerformed
        try {
            int s = Integer.parseInt(txtSize.getText());
            if (s > 0) {
                if (s > p.SIZE) {
                    notifyError(String.format(
                            "El tamaño del proceso es mayor al de la memoria (%d)",
                            p.SIZE
                    ));
                    txtSize.requestFocus();
                    txtSize.selectAll();
                } else {
                    int result = p.insert(new Process(nextPID(), s));
                    txtSize.setText("");
                    txtSize.requestFocus();
                    if (result == 0) {
                        g.paint(p);
                    }
                    updateUI();
                }
            } else {
                notifyError("Introduzca un tamaño mayor a cero");
                txtSize.requestFocus();
                txtSize.selectAll();
            }

        } catch (NumberFormatException ex) {
            notifyError("Verifique el tamaño ingresado (numérico).");
            txtSize.requestFocus();
            txtSize.selectAll();
        }
    }//GEN-LAST:event_btnStartProcActionPerformed
    private void btnKillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKillActionPerformed
        try {
            int pid = Integer.parseInt(
                    cb1.getItemAt(
                            cb1.getSelectedIndex()).split(" ")[0]
                            .substring(1, 1 + Integer.toString(PID).length()));
            p.kill(pid);
            g.paint(p);
            updateUI();
        } catch (NoSuchElementException ex) {
            notifyError("Verifique que el proceso esté cargado en memoria");
        }

    }//GEN-LAST:event_btnKillActionPerformed
    private void txtSizeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSizeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnStartProcActionPerformed(null);
        }
    }//GEN-LAST:event_txtSizeKeyPressed
    private void btnExecAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecAllActionPerformed
        try {
            p.executeAll(policy);
        } catch (InterruptedException ex) {
            //Some handling
            System.err.println("Threading error");
        }
        g.paint(p);
        updateUI();
        txtSize.requestFocus();
    }//GEN-LAST:event_btnExecAllActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        g.paint(p);
    }//GEN-LAST:event_formWindowGainedFocus
    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        g.paint(p);
    }//GEN-LAST:event_formWindowStateChanged
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        g.paint(p);
    }//GEN-LAST:event_formWindowOpened

    private void btnExecNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecNextActionPerformed
        try{
        p.executeNext(policy);
        }catch(InterruptedException ex){
            //Some handling
            System.err.println("Threading error");
        }
        g.paint(p);
        updateUI();
        txtSize.requestFocus();
    }//GEN-LAST:event_btnExecNextActionPerformed

    private int nextPID() {
        return PID++;
    }

    private void updateUI() {
        lblAvailSize.setText(String.format("Total: %d bytes, Disponible: %d bytes", p.SIZE, p.getAvailSize()));
        lblProcCount.setText(String.format("Cargados: %d, Cola: %d", p.getProcessCount(), p.getQueueSize()));
        cb1.removeAllItems();
        if (p.getRunningProcesses().size() == 0) {
            cb1.addItem("Vacío");
            cb1.setSelectedIndex(0);
            cb1.setEnabled(false);
            btnKill.setEnabled(false);
            btnExecNext.setEnabled(false);
            btnExecAll.setEnabled(false);
        } else {
            cb1.setEnabled(true);
            btnKill.setEnabled(true);
            btnExecNext.setEnabled(true);
            p.getRunningProcesses().forEach(pr
                    -> cb1.addItem(pr.toString())
            );
            if (p.getRunningProcesses().size() > 1) {
                btnExecAll.setEnabled(true);
            } else {
                btnExecAll.setEnabled(false);
            }
        }
        tbl.setRowCount(0);
        for (String[] row : p.getProcessLogger().asTableRowList()) {
            tbl.addRow(row);
        }
    }

    private void notifyError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private PlannerPolicy getPolicy() {
        String[] values = {
            "FIFO",
            "Menor tamaño",
            "Mayor tamaño"
        };
        String sel = (String) JOptionPane.showInputDialog(null,
                "Seleccione una política para trabajar", "Política",
                JOptionPane.QUESTION_MESSAGE, null, values, values[0]);
        if (sel == null) {
            System.exit(0);
        }
        switch (sel) {
            case "FIFO":
                return new FifoPolicy();
            case "Menor tamaño":
                return new SmallestSizePolicy();
            case "Mayor tamaño":
                return new BiggestSizePolicy();
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExecAll;
    private javax.swing.JButton btnExecNext;
    private javax.swing.JButton btnKill;
    private javax.swing.JButton btnStartProc;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAvailSize;
    private javax.swing.JLabel lblPolicy;
    private javax.swing.JLabel lblProcCount;
    private javax.swing.JPanel memCanvas;
    private javax.swing.JTextField txtSize;
    // End of variables declaration//GEN-END:variables
}
