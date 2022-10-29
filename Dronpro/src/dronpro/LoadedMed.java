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
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author VIBE
 */
public class LoadedMed extends javax.swing.JFrame {

    /**
     * Creates new form LoadedMed
     */
    public LoadedMed() {
        initComponents();
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
     
        setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
    
        
        
        		System.out.println("Hello");
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		try {
			URL url = new URL("http://localhost:8080/drone");
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
				}
				reader.close();
			}
			
			
			System.out.println("Action");
		        JSONArray con = new JSONArray(responseContent.toString());
                        DefaultTableModel defaultTableModel =new DefaultTableModel(); 
                        System.out.println("TOTO2"+con);
                        //System.out.println("All At Once"+responseContent.toString());
                        //Gson gson = new Gson();
                        
                        //String amyJson = gson.toJson(responseContent.toString());
                        //String date=String.valueOf(amyJson);
                        // System.out.println("Start"+date);
                        //JSONObject json = new JSONObject(amyJson);
                        
                        
                       // JSONArray jsonArray = json.getJSONArray("addedmedication");
                        //System.out.println("Run"+jsonArray);
                        defaultTableModel.addColumn("DroneID");
                        
                        defaultTableModel.addColumn("Dronename");
                        defaultTableModel.addColumn("Modelweight");
                        defaultTableModel.addColumn("weight");
                        defaultTableModel.addColumn("MedicationID");
                        defaultTableModel.addColumn("Medname");
                        defaultTableModel.addColumn("MedWeight");
                        defaultTableModel.addColumn("Code");
                        defaultTableModel.addColumn("Med ID");
		        for(int i=0; i<con.length(); i++) {
			     JSONObject cons = con.getJSONObject(i);
                             System.out.println("TOTO"+i);
			     //int id = cons.getInt("id");
			     //int battery_capacity = cons.getInt("battery_capacity");
			     //String state = cons.getString("state");
			     //int weight = cons.getInt("weight");
                             //Gson gson = new Gson();
                             //String amyJson = gson.toJson(cons);
                             
                             
                              //JSONArray jsonArray = cons.getJSONArray("addedmedication");  
                              //System.out.println("View"+amyJson);
                              //JSONObject json = new JSONObject(cons); 
                              
                             //String serialnumber = cons.getString("serialnumber");
                             //String modelweight = cons.getString("modelweight");
                             //System.out.println("Json :"+json);
                         JSONArray json  =cons.getJSONArray("addedmedication"); 
                            for(int c=0; c<json.length();c++){
                                JSONObject co = json.getJSONObject(c);
                                //System.out.println("LOOP"+co);
                                 
                                defaultTableModel.addRow(new Object[]{
                                cons.getInt("id"),
                                //===============,
                                 cons.getString("name"),
                                cons.getString("modelweight"),
                                cons.getInt("weight"),
                                cons.getInt("battery_capacity"),
                       
                                co.getString("medname"),
                                co.getInt("weight"),
                                co.getString("code"),
                                co.getInt("id"),
                                
                            });
                            }
			
                             System.out.println();

   
                             System.out.println("Design"+json);
                             //Object fo = cons.getJSONArray("addedmedication");
                             //System.out.println("The fool down"+fo);
                             //JSONArray jsonarray = cons.getJSONArray(responseContent.toString());
                             //System.out.println("Fp"+fo);
                             //for(int x = 0; x < json.size(); x++) {
                              //   JSONObject explrObject = jsonArray.getJSONObject(x);  
                             //    String jsonarrayS  = jsonarray .get(x).toString();
                             //    System.out.println(jsonarrayS);
                                //System.out.println("The Value"+explrObject.get("medname")); 
                            //}
                              
			     
			
		}
                        alldrone.setModel(defaultTableModel);
                        System.out.println("TOTO"+responseContent.toString());
		}
		catch(MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    
    	public static void GetFun() {

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
        jScrollPane1 = new javax.swing.JScrollPane();
        alldrone = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        alldrone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DronId", "MedicationID", "Dronename", "Modleweight", "weight", "Medname", "Weight", "Code", "MedID"
            }
        ));
        jScrollPane1.setViewportView(alldrone);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setText("DELIVERED");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LoadedMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadedMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadedMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadedMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoadedMed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable alldrone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
