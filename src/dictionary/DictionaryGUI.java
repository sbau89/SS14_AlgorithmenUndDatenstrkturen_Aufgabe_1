/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Stephan
 */
public class DictionaryGUI extends javax.swing.JFrame {

    private Dictionary d;
    private long time;
    private long time2;
    File c;

    /**
     * Creates new form DictionaryGUI.
     */
    public DictionaryGUI() {
        initComponents();

    }

    public void perfomanceSuche() {
        String s = null;
        String sprache = null;
        if ((jRadioButton1.isSelected() || jRadioButton3.isSelected())
	      && (jRadioButton2.isSelected() || jRadioButton4.isSelected())) {
	  if (jRadioButton1.isSelected()) {
	      s = "dtengl8000.txt";
	  }
	  if (jRadioButton3.isSelected()) {
	      s = "dtengl.txt";
	  }
	  if (jRadioButton2.isSelected()) {
	      sprache = "deutsch";
	  }
	  if (jRadioButton4.isSelected()) {
	      sprache = "englisch";
	  }
	  long time2 = System.nanoTime();
	  try {
	      BufferedReader in = new BufferedReader(
		    new FileReader(s));
	      String zeile = null;
	      while ((zeile = in.readLine()) != null) {
		int pos = zeile.indexOf(' ');
		String deutsch = zeile.substring(0, pos);
		String englisch = zeile.substring(pos + 1, zeile.length());
		//d.search(sprache);
		if (sprache.equals("deutsch")) {
		    System.out.println(d.search(deutsch));
		}

		if (sprache.equals("englisch")) {
		    System.out.println(d.search(englisch));
		}
	      }
	  } catch (IOException e) {
	  }
	  jLabel13.setText((Long.toString(System.nanoTime() - time2)));
        }
    }

    public void aufbau() {
        d = null;
        String s = null;
        if (jCheckBoxMenuItem1.isSelected()
	      || jCheckBoxMenuItem2.isSelected()
	      || jCheckBoxMenuItem3.isSelected()
	      || jCheckBoxMenuItem5.isSelected()
	      || jCheckBoxMenuItem6.isSelected()) {

	  if (jCheckBoxMenuItem1.isSelected()) {
	      d = new SortedArrayDictionary();

	  }
	  if (jCheckBoxMenuItem2.isSelected()) {
	      d = new HashDictionary();

	  }
	  if (jCheckBoxMenuItem5.isSelected()) {

	      d = new MapDictionary(new HashMap(), "HashMapDictionary");

	  }
	  if (jCheckBoxMenuItem3.isSelected()) {
	      d = new TreeDictionary();

	  }
	  if (jCheckBoxMenuItem6.isSelected()) {

	      d = new MapDictionary(new TreeMap(), "TreeMapDictionary");
	  }
        }
        try {
	  if (c != null) {
	      s = c.getName();
	  } else {
	      if (jRadioButton3.isSelected()) {
		s = "dtengl.txt";
	      }
	      if (jRadioButton1.isSelected()) {
		s = "dtengl8000.txt";
	      }
	  }
	  BufferedReader in = new BufferedReader(new FileReader(s));
	  String zeile = null;
	  while ((zeile = in.readLine()) != null) {
	      int pos = zeile.indexOf(' ');
	      String deutsch = zeile.substring(0, pos);
	      String englisch = zeile.substring(pos + 1, zeile.length());
	      d.insert(deutsch, englisch);
	  }
        } catch (IOException e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        suchen = new javax.swing.JButton();
        löschen = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        einfügen = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ausgeben = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        messen = new javax.swing.JButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jCheckBoxMenuItem5 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem6 = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Deutsches Wort nachschlagen:");

        jLabel2.setText("Englische Übersetzung:");

        suchen.setText("suchen");
        suchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suchenActionPerformed(evt);
            }
        });

        löschen.setText("löschen");
        löschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                löschenActionPerformed(evt);
            }
        });

        jLabel4.setText("Deutsch:");

        jLabel5.setText("Englisch:");

        einfügen.setText("einfügen");
        einfügen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                einfügenActionPerformed(evt);
            }
        });

        jLabel7.setText("ausgabe:");

        ausgeben.setText("ausgabe");
        ausgeben.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ausgebenActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel9.setText("Perfomancemessung:");

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("n = 8000");

        messen.setText("messen");
        messen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messenActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton2);
        jRadioButton2.setText("erfolgreich");

        buttonGroup3.add(jRadioButton4);
        jRadioButton4.setText("nicht erfolgreich");

        jLabel11.setText("Aufbau:");

        jLabel12.setText("suche:");

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("n = 16000");

        jMenu1.setText("Implementierung");
        jMenu1.setToolTipText("");

        buttonGroup1.add(jCheckBoxMenuItem1);
        jCheckBoxMenuItem1.setText("SortedArray");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jCheckBoxMenuItem1, org.jdesktop.beansbinding.ELProperty.create("${selected}"), jCheckBoxMenuItem1, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        jMenu1.add(jCheckBoxMenuItem1);

        buttonGroup1.add(jCheckBoxMenuItem2);
        jCheckBoxMenuItem2.setText("Hash");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, löschen, org.jdesktop.beansbinding.ELProperty.create("${selected}"), jCheckBoxMenuItem2, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        jMenu1.add(jCheckBoxMenuItem2);

        buttonGroup1.add(jCheckBoxMenuItem3);
        jCheckBoxMenuItem3.setText("Tree");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jCheckBoxMenuItem3, org.jdesktop.beansbinding.ELProperty.create("${selected}"), jCheckBoxMenuItem3, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        jMenu1.add(jCheckBoxMenuItem3);

        jMenu3.setText("Map");

        buttonGroup1.add(jCheckBoxMenuItem5);
        jCheckBoxMenuItem5.setText("HashMap");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jCheckBoxMenuItem5, org.jdesktop.beansbinding.ELProperty.create("${selected}"), jCheckBoxMenuItem5, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        jMenu3.add(jCheckBoxMenuItem5);

        buttonGroup1.add(jCheckBoxMenuItem6);
        jCheckBoxMenuItem6.setText("TreeMap");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jCheckBoxMenuItem6, org.jdesktop.beansbinding.ELProperty.create("${selected}"), jCheckBoxMenuItem6, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        jMenu3.add(jCheckBoxMenuItem6);

        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Datei");

        jMenuItem1.setText("einlesen");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(97, 97, 97)
                                    .addComponent(einfügen))
                                .addComponent(jLabel4)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(löschen)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(suchen)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel13))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel10)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButton4)
                                .addComponent(jRadioButton3)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(messen, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(ausgeben))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suchen)
                    .addComponent(löschen))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(einfügen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ausgeben)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Implementierung wählen und .txt einlesen
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter
	      = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fc.setFileFilter(filter);

        fc.setDialogTitle("Dictionary lesen");
        int returnVal = fc.showOpenDialog(DictionaryGUI.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        }
        c = fc.getSelectedFile();
        aufbau();
        c = null;
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    //suche
    private void suchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suchenActionPerformed
        Object o = null;
        o = d.search(jTextField1.getText());
        if (o == null) {
	  jLabel3.setText("Wort nicht gefunden");
        } else {
	  jLabel3.setText(o.toString());
        }
    }//GEN-LAST:event_suchenActionPerformed

    //löschen
    private void löschenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_löschenActionPerformed
        Object o = null;
        o = d.search(jTextField1.getText());
        if (o == null) {
	  jLabel3.setText("Wort nicht gefunden");
        } else {
	  jLabel3.setText(o.toString());
	  d.remove(jTextField1.getText());
        }
    }//GEN-LAST:event_löschenActionPerformed
    //einfügen
    private void einfügenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_einfügenActionPerformed
        d.insert(jTextField2.getText(), jTextField3.getText());
    }//GEN-LAST:event_einfügenActionPerformed
    //ausgabe in TextArea
    private void ausgebenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ausgebenActionPerformed
        jTextArea1.setText(d.toString());
    }//GEN-LAST:event_ausgebenActionPerformed
    //Perfomance Messung, aufbau und suche
    private void messenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messenActionPerformed
        // Dictionary Neuaufbau Einträge n = 16000
        time = System.nanoTime();
        aufbau();
        jLabel10.setText((Long.toString(System.nanoTime() - time)));
        time2 = System.nanoTime();
        perfomanceSuche();
        jLabel13.setText((Long.toString(System.nanoTime() - time2)));
    }//GEN-LAST:event_messenActionPerformed

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
	  java.util.logging.Logger.getLogger(DictionaryGUI.class
		.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
	  java.util.logging.Logger.getLogger(DictionaryGUI.class
		.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
	  java.util.logging.Logger.getLogger(DictionaryGUI.class
		.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	  java.util.logging.Logger.getLogger(DictionaryGUI.class
		.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
	  public void run() {
	      new DictionaryGUI().setVisible(true);
	  }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ausgeben;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton einfügen;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem5;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton löschen;
    private javax.swing.JButton messen;
    private javax.swing.JButton suchen;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
