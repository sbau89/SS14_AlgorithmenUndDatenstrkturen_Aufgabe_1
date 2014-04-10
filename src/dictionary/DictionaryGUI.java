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
import java.text.DecimalFormat;
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
    private double buildTime;
    private double searchTime;
    private boolean booleanFileChooser = false;
    private File c;

    /**
     * Creates new form DictionaryGUI.
     */
    public DictionaryGUI() {
        initComponents();

    }
    @SuppressWarnings("unchecked")
    public void perfomanceSearch() {
        String s = null;
        String sprache = null;
        if (((jRadioButton8000Einträge.isSelected()
	      || jRadioButton16000Einträge.isSelected())
	      && (jRadioButtonErfolgreich.isSelected()
	      || jRadioButtonNichtErfolgreich.isSelected()))
	      && (sortedArray.isSelected()
	      || hash.isSelected()
	      || tree.isSelected()
	      || hashMap.isSelected()
	      || treeMap.isSelected())) {

	  if (jRadioButton8000Einträge.isSelected()) {
	      s = "dtengl8000.txt";
	  }
	  if (jRadioButton16000Einträge.isSelected()) {
	      s = "dtengl.txt";
	  }
	  if (jRadioButtonErfolgreich.isSelected()) {
	      sprache = "deutsch";
	  }
	  if (jRadioButtonNichtErfolgreich.isSelected()) {
	      sprache = "englisch";
	  }
	  try {
	      BufferedReader in = new BufferedReader(
		    new FileReader(s));
	      String zeile = null;
	      while ((zeile = in.readLine()) != null) {
		int pos = zeile.indexOf(' ');
		String deutsch = zeile.substring(0, pos);
		String englisch = zeile.substring(pos + 1, zeile.length());
		// erfolgreiche Suche
		if (sprache.equals("deutsch")) {
		    //System.out.println(d.search(deutsch));
		    long searchTimeStart = System.nanoTime();
		    d.search(deutsch);
		    long searchTimeEnd = System.nanoTime();
		    searchTime += searchTimeEnd - searchTimeStart;
		}
		// nicht erfolgreiche Suche
		if (sprache.equals("englisch")) {
		    //System.out.println(d.search(englisch));
		    long searchTimeStart = System.nanoTime();
		    d.search(englisch);
		    long searchTimeEnd = System.nanoTime();
		    searchTime += searchTimeEnd - searchTimeStart;
		}
	      }
	  } catch (IOException e) {
	  }
        }
    }
    @SuppressWarnings("unchecked")
    public void build() {
        if (sortedArray.isSelected()
	      || hash.isSelected()
	      || tree.isSelected()
	      || hashMap.isSelected()
	      || treeMap.isSelected()
	      && (jRadioButton16000Einträge.isSelected()
	      || jRadioButton8000Einträge.isSelected())) {

	  d = null;
	  String s = null;
	  if (sortedArray.isSelected()) {
	      d = new SortedArrayDictionary();

	  }
	  if (hash.isSelected()) {
	      d = new HashDictionary();

	  }
	  if (hashMap.isSelected()) {

	      d = new MapDictionary(new HashMap(), "HashMapDictionary");

	  }
	  if (tree.isSelected()) {
	      d = new TreeDictionary();

	  }
	  if (treeMap.isSelected()) {

	      d = new MapDictionary(new TreeMap(), "TreeMapDictionary");
	  }

	  if (booleanFileChooser) {
	      s = c.getName();

	  } else {
	      if (jRadioButton16000Einträge.isSelected()) {
		s = "dtengl.txt";
	      }
	      if (jRadioButton8000Einträge.isSelected()) {
		s = "dtengl8000.txt";
	      }
	  }
	  try {
	      BufferedReader in = new BufferedReader(new FileReader(s));
	      String zeile = null;
	      while ((zeile = in.readLine()) != null) {
		int pos = zeile.indexOf(' ');
		String deutsch = zeile.substring(0, pos);
		String englisch = zeile.substring(pos + 1, zeile.length());
		long buildTimeStart = System.nanoTime();
		d.insert(deutsch, englisch);
		long buildTimeEnd = System.nanoTime();
		buildTime += buildTimeEnd - buildTimeStart;
	      }
	  } catch (IOException e) {
	  }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        implementierung = new javax.swing.ButtonGroup();
        einträge = new javax.swing.ButtonGroup();
        erfolg = new javax.swing.ButtonGroup();
        jLabelDeutschesWortnachschlagen = new javax.swing.JLabel();
        jTextfieldSuchenLöschenEingabe = new javax.swing.JTextField();
        jLabelEnglischeÜbersetzung = new javax.swing.JLabel();
        jLabelEnglischAusgabe = new javax.swing.JLabel();
        jButtonSuchen = new javax.swing.JButton();
        jButtonLöschen = new javax.swing.JButton();
        jLabelDeutsch = new javax.swing.JLabel();
        jTextfieldDeutschEingabe = new javax.swing.JTextField();
        jLabelEnglisch = new javax.swing.JLabel();
        jTextFieldEnglischEingabe = new javax.swing.JTextField();
        jButtonEinfügen = new javax.swing.JButton();
        jLabelAusgabe = new javax.swing.JLabel();
        jButtonAusgeben = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAusgabe = new javax.swing.JTextArea();
        jLabelPerfomancemessung = new javax.swing.JLabel();
        jRadioButton8000Einträge = new javax.swing.JRadioButton();
        jButtonMessen = new javax.swing.JButton();
        jRadioButtonErfolgreich = new javax.swing.JRadioButton();
        jRadioButtonNichtErfolgreich = new javax.swing.JRadioButton();
        jLabelAusgabeMessungAufbau = new javax.swing.JLabel();
        jLabelAufbau = new javax.swing.JLabel();
        jLabelSuche = new javax.swing.JLabel();
        jLabelAusgabeMessungSuche = new javax.swing.JLabel();
        jRadioButton16000Einträge = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        sortedArray = new javax.swing.JCheckBoxMenuItem();
        hash = new javax.swing.JCheckBoxMenuItem();
        tree = new javax.swing.JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();
        hashMap = new javax.swing.JCheckBoxMenuItem();
        treeMap = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelDeutschesWortnachschlagen.setText("Deutsches Wort nachschlagen:");

        jLabelEnglischeÜbersetzung.setText("Englische Übersetzung:");

        jButtonSuchen.setText("suchen");
        jButtonSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuchenActionPerformed(evt);
            }
        });

        jButtonLöschen.setText("löschen");
        jButtonLöschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLöschenActionPerformed(evt);
            }
        });

        jLabelDeutsch.setText("Deutsch:");

        jLabelEnglisch.setText("Englisch:");

        jButtonEinfügen.setText("einfügen");
        jButtonEinfügen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEinfügenActionPerformed(evt);
            }
        });

        jLabelAusgabe.setText("ausgabe:");

        jButtonAusgeben.setText("ausgabe");
        jButtonAusgeben.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAusgebenActionPerformed(evt);
            }
        });

        jTextAreaAusgabe.setColumns(20);
        jTextAreaAusgabe.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAusgabe);

        jLabelPerfomancemessung.setText("Perfomancemessung:");

        einträge.add(jRadioButton8000Einträge);
        jRadioButton8000Einträge.setText("n = 8000");

        jButtonMessen.setText("messen");
        jButtonMessen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMessenActionPerformed(evt);
            }
        });

        erfolg.add(jRadioButtonErfolgreich);
        jRadioButtonErfolgreich.setText("erfolgreich");

        erfolg.add(jRadioButtonNichtErfolgreich);
        jRadioButtonNichtErfolgreich.setText("nicht erfolgreich");

        jLabelAufbau.setText("Aufbau:");

        jLabelSuche.setText("suche:");

        einträge.add(jRadioButton16000Einträge);
        jRadioButton16000Einträge.setText("n = 16000");

        jMenu1.setText("Implementierung");
        jMenu1.setToolTipText("");

        implementierung.add(sortedArray);
        sortedArray.setText("SortedArray");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, sortedArray, org.jdesktop.beansbinding.ELProperty.create("${selected}"), sortedArray, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        jMenu1.add(sortedArray);

        implementierung.add(hash);
        hash.setText("Hash");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jButtonLöschen, org.jdesktop.beansbinding.ELProperty.create("${selected}"), hash, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        jMenu1.add(hash);

        implementierung.add(tree);
        tree.setText("Tree");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tree, org.jdesktop.beansbinding.ELProperty.create("${selected}"), tree, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        jMenu1.add(tree);

        jMenu3.setText("Map");

        implementierung.add(hashMap);
        hashMap.setText("HashMap");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, hashMap, org.jdesktop.beansbinding.ELProperty.create("${selected}"), hashMap, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        jMenu3.add(hashMap);

        implementierung.add(treeMap);
        treeMap.setText("TreeMap");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, treeMap, org.jdesktop.beansbinding.ELProperty.create("${selected}"), treeMap, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        jMenu3.add(treeMap);

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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelSuche)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabelAusgabeMessungSuche))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelAufbau)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabelAusgabeMessungAufbau)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButton8000Einträge, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButtonErfolgreich))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButtonNichtErfolgreich)
                                .addComponent(jRadioButton16000Einträge)))
                        .addComponent(jButtonMessen, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelAusgabe)
                                .addComponent(jLabelPerfomancemessung)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(97, 97, 97)
                                            .addComponent(jButtonEinfügen))
                                        .addComponent(jLabelDeutsch)
                                        .addComponent(jTextfieldDeutschEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldEnglischEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelEnglisch, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextfieldSuchenLöschenEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButtonLöschen)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButtonSuchen)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabelEnglischAusgabe, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelDeutschesWortnachschlagen)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabelEnglischeÜbersetzung, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(1, 1, 1)))
                    .addComponent(jButtonAusgeben))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDeutschesWortnachschlagen)
                    .addComponent(jLabelEnglischeÜbersetzung))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEnglischAusgabe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextfieldSuchenLöschenEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSuchen)
                    .addComponent(jButtonLöschen))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEnglisch)
                    .addComponent(jLabelDeutsch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextfieldDeutschEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEnglischEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEinfügen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAusgabe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton8000Einträge)
                            .addComponent(jRadioButton16000Einträge, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonNichtErfolgreich)
                            .addComponent(jRadioButtonErfolgreich)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAusgeben)
                        .addGap(6, 6, 6)
                        .addComponent(jLabelPerfomancemessung)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAufbau)
                            .addComponent(jLabelAusgabeMessungAufbau))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSuche)
                            .addComponent(jLabelAusgabeMessungSuche))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonMessen))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Implementierung wählen und .txt einlesen
    @SuppressWarnings("unchecked")
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
        booleanFileChooser = true;
        build();
        booleanFileChooser = false;
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    //suche
    @SuppressWarnings("unchecked")
    private void jButtonSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuchenActionPerformed
        Object o = null;
        o = d.search(jTextfieldSuchenLöschenEingabe.getText());
        if (o == null) {
	  jLabelEnglischAusgabe.setText("Wort nicht gefunden");
        } else {
	  jLabelEnglischAusgabe.setText(o.toString());
        }
    }//GEN-LAST:event_jButtonSuchenActionPerformed

    //löschen
    @SuppressWarnings("unchecked")
    private void jButtonLöschenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLöschenActionPerformed
        Object o = null;
        o = d.search(jTextfieldSuchenLöschenEingabe.getText());
        if (o == null) {
	  jLabelEnglischAusgabe.setText("Wort nicht gefunden");
        } else {
	  jLabelEnglischAusgabe.setText(o.toString());
	  d.remove(jTextfieldSuchenLöschenEingabe.getText());
        }
    }//GEN-LAST:event_jButtonLöschenActionPerformed
    //einfügen
    @SuppressWarnings("unchecked")
    private void jButtonEinfügenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEinfügenActionPerformed
        d.insert(jTextfieldDeutschEingabe.getText(), jTextFieldEnglischEingabe.getText());
    }//GEN-LAST:event_jButtonEinfügenActionPerformed
    //ausgabe in TextArea
    @SuppressWarnings("unchecked")
    private void jButtonAusgebenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAusgebenActionPerformed
        jTextAreaAusgabe.setText(d.toString());
    }//GEN-LAST:event_jButtonAusgebenActionPerformed
    //Perfomance Messung, aufbau und suche
    @SuppressWarnings("unchecked")
    private void jButtonMessenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMessenActionPerformed
        for (int i = 0; i < 100; i++) {
	  build();
	  perfomanceSearch();
        }
        buildTime = buildTime / 100.0;
        searchTime = searchTime / 100.0;
        DecimalFormat f = new DecimalFormat("#0.000");
        jLabelAusgabeMessungAufbau.setText(f.format(buildTime / 1000000.0) + "ms");
        jLabelAusgabeMessungSuche.setText((f.format(searchTime / 1000000.0)) + "ms");
    }//GEN-LAST:event_jButtonMessenActionPerformed

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
    private javax.swing.ButtonGroup einträge;
    private javax.swing.ButtonGroup erfolg;
    private javax.swing.JCheckBoxMenuItem hash;
    private javax.swing.JCheckBoxMenuItem hashMap;
    private javax.swing.ButtonGroup implementierung;
    private javax.swing.JButton jButtonAusgeben;
    private javax.swing.JButton jButtonEinfügen;
    private javax.swing.JButton jButtonLöschen;
    private javax.swing.JButton jButtonMessen;
    private javax.swing.JButton jButtonSuchen;
    private javax.swing.JLabel jLabelAufbau;
    private javax.swing.JLabel jLabelAusgabe;
    private javax.swing.JLabel jLabelAusgabeMessungAufbau;
    private javax.swing.JLabel jLabelAusgabeMessungSuche;
    private javax.swing.JLabel jLabelDeutsch;
    private javax.swing.JLabel jLabelDeutschesWortnachschlagen;
    private javax.swing.JLabel jLabelEnglisch;
    private javax.swing.JLabel jLabelEnglischAusgabe;
    private javax.swing.JLabel jLabelEnglischeÜbersetzung;
    private javax.swing.JLabel jLabelPerfomancemessung;
    private javax.swing.JLabel jLabelSuche;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JRadioButton jRadioButton16000Einträge;
    private javax.swing.JRadioButton jRadioButton8000Einträge;
    private javax.swing.JRadioButton jRadioButtonErfolgreich;
    private javax.swing.JRadioButton jRadioButtonNichtErfolgreich;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaAusgabe;
    private javax.swing.JTextField jTextFieldEnglischEingabe;
    private javax.swing.JTextField jTextfieldDeutschEingabe;
    private javax.swing.JTextField jTextfieldSuchenLöschenEingabe;
    private javax.swing.JCheckBoxMenuItem sortedArray;
    private javax.swing.JCheckBoxMenuItem tree;
    private javax.swing.JCheckBoxMenuItem treeMap;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
