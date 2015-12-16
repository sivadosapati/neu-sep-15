package project.vehicle.management.data.access;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import project.vehicle.management.ui.MainScreen;

public class DealerCarManagerImpl implements DealerCarManager {
    private File file;

    public DealerCarManagerImpl() {
        file = new File("dealers");
    }
    
   /**
    * Get all dealer ID from file
    * 
    * @param none
    * @return the dealer id array
    */
    public String[] getDealerIds() {
        List<String> dealerIds = new ArrayList<String>();
        FileReadingTemplate template = new FileReadingTemplate() {

            @Override
            public void processLine(String line) {
                String[] arr = line.split("\t");
                String dealerId = arr[0];
                dealerIds.add(dealerId);
            }

        };
        template.setSkipFirstLine(false);
        try {
            template.parseFile(file);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new MainScreen(""),
                    e.getMessage() + "\nPlease contact administrator to fix it!");
            System.exit(1);
            e.printStackTrace();
        }
        return dealerIds.toArray(new String[dealerIds.size()]);
    }
}
