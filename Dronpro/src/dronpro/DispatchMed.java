/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dronpro;

import com.google.gson.Gson;
import static dronpro.Dronpro.parse;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import static java.util.Collections.list;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author VIBE
 */
public class DispatchMed extends javax.swing.JFrame {
       String v;
       JTextField show;
    DefaultListModel m = new DefaultListModel();
      
    /**
     * Creates new form DispatchMed
     */
    public DispatchMed(String abc) {
        
        int id_abc = Integer.parseInt(abc);
        System.out.println("View this"+abc);
        initComponents();
        
        //droneN.setEditable(false);
             


        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
     
        setSize(800,540);
        setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
    

        
        
        
        
        System.out.println("Hello");
	BufferedReader reader;
	String line;
	StringBuffer responseContent = new StringBuffer();
	try {
	  URL url = new URL("http://localhost:8080/dronId/"+id_abc);
          HttpURLConnection connection = (HttpURLConnection) url.openConnection();
          connection.setRequestMethod("GET");
	  connection.setConnectTimeout(5000);
	  connection.setReadTimeout(5000);
			
	  int status = connection.getResponseCode();
			//System.out.println(status);
			
	  if(status > 299) {
		reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
		while((line = reader.readLine()) != null) {
			responseContent.append(line);
                        
                       
		}
		reader.close();
		}else {
		reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while((line = reader.readLine()) != null) {
			responseContent.append(line);
                        System.out.println("Host "+line);
		}
		reader.close();
		}
			
			
		//parse(responseContent.toString());
                //System.out.print("All Details :"+responseContent.toString());
                System.out.println("All At Once"+responseContent.toString());

                  JSONObject inputJ = new JSONObject(responseContent.toString());
                System.out.println("TOTO2"+inputJ);
                int Id = inputJ.getInt("id");
		String state = inputJ.getString("name");
                int wei = inputJ.getInt("weight");
                  dd.setText(state);
                  weightT.setText(String.valueOf(wei));
                  ID.setText(String.valueOf(Id));
                  System.out.println("Name"+state);
                  
                //parse(responseContent.toString()); 
                   
                   
                        
                        
	}
	catch(MalformedURLException e) {
	e.printStackTrace();
	} catch (IOException e) {
	  // TODO Auto-generated catch block
	 e.printStackTrace();
	}
        
        
        
        /*Adding All Medication To The LIST*/
        

        System.out.println("Hello");
	BufferedReader readers;
	String lines;
	StringBuffer responseContents = new StringBuffer();
	try {
	  URL url = new URL("http://localhost:8080/medication");
          HttpURLConnection connection = (HttpURLConnection) url.openConnection();
          connection.setRequestMethod("GET");
	  connection.setConnectTimeout(5000);
	  connection.setReadTimeout(5000);
			
	  int status = connection.getResponseCode();
			//System.out.println(status);
			
	  if(status > 299) {
		readers = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
		while((lines = readers.readLine()) != null) {
			responseContents.append(lines);
                        
                       
		}
		readers.close();
		}else {
		readers = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while((lines = readers.readLine()) != null) {
			responseContents.append(lines);
                        System.out.println("Host "+lines);
		}
		readers.close();
		}
			

                System.out.println("All At Once"+responseContents.toString());

     
                System.out.println("Action");
		JSONArray con = new JSONArray(responseContents.toString());
                System.out.println("TOTO2"+con);
		for(int i=0; i<con.length(); i++) {
			JSONObject cons = con.getJSONObject(i);
                        System.out.println("TOTO3"+cons);
	
			String name = cons.getString("medname");
			int w = cons.getInt("weight");
                        int ID = cons.getInt("id");
	
			System.out.println(" name: "+name);
			m.addElement(ID);
                       
			
		}
                medlist.setModel(m);
                   
                   
                        
                        
	}
	catch(MalformedURLException e) {
	e.printStackTrace();
	} catch (IOException e) {
	  // TODO Auto-generated catch block
	 e.printStackTrace();
	}
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        medlist = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        copyList = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ck = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        push = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        weightT = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dd = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        MedW = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        MedN = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        load = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(2147483647, 21474836));
        setPreferredSize(new java.awt.Dimension(781, 716));

        medlist.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(medlist);

        jScrollPane2.setViewportView(copyList);

        jButton1.setText("Add >>>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Drone Section:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Medication To Be Added To Drone For Dispatch:");

        ck.setForeground(new java.awt.Color(51, 153, 0));
        ck.setText("Loading State");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dronpro/image/icons8-drone-64.png"))); // NOI18N

        push.setText("Push Drone");
        push.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pushActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Drone Weight:");

        weightT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Medication Section:");

        dd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dd.setForeground(new java.awt.Color(51, 153, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Drone Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Medication weight");

        MedW.setForeground(new java.awt.Color(51, 153, 0));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Medication Name");

        load.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        load.setForeground(new java.awt.Color(51, 153, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(load, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jSeparator1)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addGap(9, 9, 9)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(weightT, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ck, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MedW, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MedN, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(109, 109, 109))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(push, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(108, 108, 108)
                                                .addComponent(jButton1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(weightT, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ck, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(211, 211, 211)))
                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MedW, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MedN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(push, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(391, 391, 391)
                .addComponent(load, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
DefaultListModel m1 = new DefaultListModel();
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int med =m1.getSize();
        System.out.println("Index Of"+med);
        if(med==1){
            JOptionPane.showMessageDialog(null,"Cant add more than one Drug to a drone" , "Error Message",JOptionPane.ERROR_MESSAGE);
        }
        else if(!(med==1)){
       
        //copyList.setListData((String[]) medlist.getSelectedValues());
        int index = medlist.getSelectedIndex();
        System.out.println("The Index"+index);
        Object value = medlist.getSelectedValue();
        //int val = Integer.parseInt(value);
        System.out.println("The Value"+value);
        m1.addElement(value);
        copyList.setModel(m1);
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pushActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pushActionPerformed
        // TODO add your handling code here:
        //for(int i = 0; i< copyList.getModel().;i++){
        
        int index =(int) m1.firstElement();
        Object va = copyList.getSelectedValue();
        
         //x = copyList.getModel().getElementAt(i);
        //System.out.println(x);
        System.out.println("Hello :"+index);

        /*Adding All Medication To The LIST*/
        

	BufferedReader reader;
	String line;
	StringBuffer responseContent = new StringBuffer();
	try {
	  URL url = new URL("http://localhost:8080/medId/"+index);
          HttpURLConnection connection = (HttpURLConnection) url.openConnection();
          connection.setRequestMethod("GET");
	  connection.setConnectTimeout(5000);
	  connection.setReadTimeout(5000);
			
	  int status = connection.getResponseCode();
			//System.out.println(status);
			
	  if(status > 299) {
		reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
		while((line = reader.readLine()) != null) {
			responseContent.append(line);
                        
                       
		}
		reader.close();
		}else {
		reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while((line = reader.readLine()) != null) {
			responseContent.append(line);
                        System.out.println("Host "+line);
		}
		reader.close();
		}
			
			
		//parse(responseContent.toString());
                //System.out.print("All Details :"+responseContent.toString());
                System.out.println("All At Once"+responseContent.toString());

                JSONObject inputJ = new JSONObject(responseContent.toString());
                System.out.println("TOTO2"+inputJ);
		String state = inputJ.getString("medname");
                int wei = inputJ.getInt("weight");
                 MedW.setText(""+wei);
                 MedN.setText(state);
                //parse(responseContent.toString());
                int c =Integer.parseInt(weightT.getText());
                int id = Integer.parseInt(ID.getText());
                if(c<wei){
                    JOptionPane.showMessageDialog(null,"Medication Weight Is Higher Than Drone" , "Error Message",JOptionPane.ERROR_MESSAGE);
                }else{
                    
                    conec(index,id);
                    
                    
                    
                    JOptionPane.showMessageDialog(null,"Successful!");
                }
                   
                   
                        
                        
	}
	catch(MalformedURLException e) {
	e.printStackTrace();
	} catch (IOException e) {
	  // TODO Auto-generated catch block
	 e.printStackTrace();
	}

           
      //}
    }//GEN-LAST:event_pushActionPerformed

    
    public void conec(int y,int x){
        BufferedReader reader;
	String line;
	StringBuffer responseContent = new StringBuffer();
	try {
	  URL url = new URL("http://localhost:8080/"+y+"/drone/"+x);//http://localhost:8080/2/drone/1
          HttpURLConnection connection = (HttpURLConnection) url.openConnection();
          connection.setRequestMethod("PUT");
	  connection.setConnectTimeout(5000);
	  connection.setReadTimeout(5000);
			
	  int status = connection.getResponseCode();
			//System.out.println(status);
			
	  if(status > 299) {
		reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
		while((line = reader.readLine()) != null) {
			responseContent.append(line);
                        
                       
		}
		reader.close();
		}else {
		reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while((line = reader.readLine()) != null) {
			responseContent.append(line);
                        System.out.println("Host "+line);
                        String z ="Drone is in DELIVERING State";
                        load.setText(z);
		}
		reader.close();
		}
          
           
	}
	catch(MalformedURLException e) {
	e.printStackTrace();
	} catch (IOException e) {
	  // TODO Auto-generated catch block
	 e.printStackTrace();
	}

    }

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
            java.util.logging.Logger.getLogger(DispatchMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DispatchMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DispatchMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DispatchMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DispatchMed("").setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JLabel MedN;
    private javax.swing.JLabel MedW;
    private javax.swing.JLabel ck;
    private javax.swing.JList<String> copyList;
    private javax.swing.JLabel dd;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel load;
    private javax.swing.JList<String> medlist;
    private javax.swing.JButton push;
    private javax.swing.JLabel weightT;
    // End of variables declaration//GEN-END:variables
}
